/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "STAFFS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staffs.findAll", query = "SELECT s FROM Staffs s"),
    @NamedQuery(name = "Staffs.findByStaffId", query = "SELECT s FROM Staffs s WHERE s.staffId = :staffId"),
    @NamedQuery(name = "Staffs.findByStaffName", query = "SELECT s FROM Staffs s WHERE s.staffName = :staffName"),
    @NamedQuery(name = "Staffs.findByCompanyEmail", query = "SELECT s FROM Staffs s WHERE s.companyEmail = :companyEmail"),
    @NamedQuery(name = "Staffs.findByPhoneNum", query = "SELECT s FROM Staffs s WHERE s.phoneNum = :phoneNum"),
    @NamedQuery(name = "Staffs.findByPassword", query = "SELECT s FROM Staffs s WHERE s.password = :password"),
    @NamedQuery(name = "Staffs.findByStaffEmailPassword", query = "SELECT s FROM Staffs s WHERE s.companyEmail = :companyEmail AND s.password = :password")})
public class Staffs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "STAFF_ID")
    private String staffId;
    @Size(max = 50)
    @Column(name = "STAFF_NAME")
    private String staffName;
    @Size(max = 50)
    @Column(name = "COMPANY_EMAIL")
    private String companyEmail;
    @Size(max = 12)
    @Column(name = "PHONE_NUM")
    private String phoneNum;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne
    private Roles roleId;

    public Staffs() {
    }

    public Staffs(String staffId) {
        this.staffId = staffId;
    }

    public Staffs(String staffId, String staffName, String companyEmail, String phoneNum) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.companyEmail = companyEmail;
        this.phoneNum = phoneNum;
    }
    
    public Staffs(String staffId, String staffName, String companyEmail, String phoneNum, String password, Roles roleId) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.companyEmail = companyEmail;
        this.phoneNum = phoneNum;
        this.password = password;
        this.roleId = roleId;
    }
    
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staffs)) {
            return false;
        }
        Staffs other = (Staffs) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Staffs[ staffId=" + staffId + " ]";
    }
    
}
