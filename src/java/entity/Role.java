/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author s20163037
 */
@Entity
@Table(name="role_info")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
    
    @Id @Size(max=1)
    private String role_id;         // ロールID
    
    @Size(max=7)
    private String role_name;       // 役職
    
    @OneToMany(mappedBy = "role_id", cascade = CascadeType.ALL)
    private List<Employee> employee;
    
    @Transient                           // シリアライズしない
    private boolean editable;
    
    /* コンストラクタ */

    public Role() {
    }

    public Role(String role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }
    
    /* ゲッター、セッター */

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
}
