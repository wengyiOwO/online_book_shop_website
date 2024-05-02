package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class StaffsService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public StaffsService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addStaff(Staffs staff) {
        mgr.persist(staff);
        return true;
    }

    public Staffs findStaffById(String id) {
        Staffs staff = mgr.find(Staffs.class, id);
        return staff;
    }

    public boolean deleteStaff(String id) {
        Staffs staff = findStaffById(id);
        if (staff != null) {
            mgr.remove(staff);
            return true;
        }
        return false;
    }

    public List<Staffs> findAll() {
        List staffList = mgr.createNamedQuery("Staffs.findAll").getResultList();
        return staffList;
    }

    public boolean updateStaff(Staffs staff) {
        Staffs tempStaff = findStaffById(staff.getStaffId());
        if (tempStaff != null) {
            tempStaff.setStaffName(staff.getStaffName());
            tempStaff.setCompanyEmail(staff.getCompanyEmail());
            tempStaff.setPhoneNum(staff.getPhoneNum());
            return true;
        }
        return false;
    }
    
    public Staffs findByEmailAndPassword(String email, String password) {
        try {
            Staffs staff = (Staffs) mgr.createNamedQuery("Staffs.findByStaffEmailPassword").setParameter("companyEmail", email).setParameter("password", password).getSingleResult();
            return staff;
        } catch (NoResultException e) {
            return null;
        }
    }
}
