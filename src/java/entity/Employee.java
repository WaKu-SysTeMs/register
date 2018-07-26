/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author s20163037
 */
@Entity
@Table(name = "emp_info")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L; // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 10)
    private Integer emp_num;            // 社員番号

    @Size(max = 30)
    private String emp_name;            // 社員名

    @Size(max = 1)
    @NotNull
    @JoinColumn(table = "role_info")
    private Role role_id;               // ロールID(FK)

    @Size(max = 20)
    private String passwd;              // パスワード

    @NotNull
    @Size(max = 3)
    @JoinColumn(table = "store_info")
    private Store store_id;             // 勤務地(FK：店舗ID)

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Employee() {
    }

    public Employee(Integer emp_num, String emp_name, Role role_id, String passwd, Store store_id) {
        this.emp_num = emp_num;
        this.emp_name = emp_name;
        this.role_id = role_id;
        this.passwd = passwd;
        this.store_id = store_id;
    }

    /* ゲッター、セッター */
    public Integer getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(Integer emp_num) {
        this.emp_num = emp_num;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Store getStore_id() {
        return store_id;
    }

    public void setStore_id(Store store_id) {
        this.store_id = store_id;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
