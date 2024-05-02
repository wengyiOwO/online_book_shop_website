package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class UsersService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public UsersService(EntityManager mgr) {
        this.mgr = mgr;
    }
    
    public boolean addUser(Users user) {
        mgr.persist(user);
        return true;
    }
        
    public Users findUserByUserID(String id) {
        Users user = mgr.find(Users.class, id);
        return user;
    }

    public boolean deleteUser(String id) {
        Users user = findUserByUserID(id);
        if (user != null) {
            mgr.remove(user);
            return true;
        }
        return false;
    }

    public List<Users> findAll() {
        List userList = mgr.createNamedQuery("Users.findAll").getResultList();
        return userList;
    }


    public boolean updateUser(Users user) {
        Users tempUser = findUserByUserID(user.getUserId());
        if (tempUser != null) {
            tempUser.setUserName(user.getUserName());
            tempUser.setUserEmail(user.getUserEmail());
            tempUser.setPhoneNum(user.getPhoneNum());
            return true;
        }
        return false;
    }
    
    public Users findByEmailAndPassword(String email, String password) {
        try {
            Users user = (Users) mgr.createNamedQuery("Users.findByUserEmailPassword").setParameter("userEmail", email).setParameter("password", password).getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
