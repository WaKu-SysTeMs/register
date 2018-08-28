/*
 * 社員情報 EMP_INFO
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
@Table(name = "emp_info")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L; // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 10)
    @Column(length = 10)
    private Integer emp_num;            // 社員番号

    @Size(max = 30)
    @Column(length = 30)
    private String emp_name;            // 社員名

    @Size(max = 1)                   // もしくは@patternで
    @NotNull
    @JoinColumn(name = "role_id")
    private RoleInfo role_id;               // ロールID(FK)

    @Size(max = 20)
    @Column(length = 20)
    private String passwd;              // パスワード

    @NotNull
    @Size(max = 3)
    @JoinColumn(name = "store_id")
    private StoreInfo store_id;             // 勤務地(FK：店舗ID)

    @OneToMany(mappedBy = "emp_num", cascade = CascadeType.ALL)
    private List<Inspection> inspection;

    @OneToMany(mappedBy = "emp_num", cascade = CascadeType.ALL)
    private List<RentalInfo> rentalInfo;

    @OneToMany(mappedBy = "emp_num", cascade = CascadeType.ALL)
    private List<MoveHistory> moveHistory;

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Employee() {
    }

    public Employee(Integer emp_num, String emp_name, RoleInfo role_id, String passwd, StoreInfo store_id) {
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

    public RoleInfo getRole_id() {
        return role_id;
    }

    public void setRole_id(RoleInfo role_id) {
        this.role_id = role_id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public StoreInfo getStore_id() {
        return store_id;
    }

    public void setStore_id(StoreInfo store_id) {
        this.store_id = store_id;
    }

    public List<Inspection> getInspection() {
        return inspection;
    }

    public void setInspection(List<Inspection> inspection) {
        this.inspection = inspection;
    }

    public List<RentalInfo> getRentalInfo() {
        return rentalInfo;
    }

    public void setRentalInfo(List<RentalInfo> rentalInfo) {
        this.rentalInfo = rentalInfo;
    }

    public List<MoveHistory> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(List<MoveHistory> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
