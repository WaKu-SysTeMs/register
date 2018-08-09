/*
 * レジ〆 INSPECTION
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author sakura＊
 */
@Entity
@Table(name = "inspection")
public class Inspection implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    private Integer inspection_num;         // レジ〆番号

    @NotNull
    @Size(max = 4)
    private Register register_id;           // レジID(FK)

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inspection_date;           // レジ〆年月日時

    @NotNull
    @Size(max = 7)
    private Integer inspection_sum;         // レジ〆金額合計

    @NotNull
    @Size(max = 6)
    private Integer misc_pl_amt;            // 雑損益額

    @Size(max = 10)
    private Employee emp_num;               // 社員番号(FK)

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Inspection() {
    }

    public Inspection(Integer inspection_num, Register register_id, Date inspection_date, Integer inspection_sum, Integer misc_pl_amt, Employee emp_num) {
        this.inspection_num = inspection_num;
        this.register_id = register_id;
        this.inspection_date = inspection_date;
        this.inspection_sum = inspection_sum;
        this.misc_pl_amt = misc_pl_amt;
        this.emp_num = emp_num;
    }

    /* ゲッター、セッター */
    public Integer getInspection_num() {
        return inspection_num;
    }

    public void setInspection_num(Integer inspection_num) {
        this.inspection_num = inspection_num;
    }

    public Register getRegister_id() {
        return register_id;
    }

    public void setRegister_id(Register register_id) {
        this.register_id = register_id;
    }

    public Date getInspection_date() {
        return inspection_date;
    }

    public void setInspection_date(Date inspection_date) {
        this.inspection_date = inspection_date;
    }

    public Integer getInspection_sum() {
        return inspection_sum;
    }

    public void setInspection_sum(Integer inspection_sum) {
        this.inspection_sum = inspection_sum;
    }

    public Integer getMisc_pl_amt() {
        return misc_pl_amt;
    }

    public void setMisc_pl_amt(Integer misc_pl_amt) {
        this.misc_pl_amt = misc_pl_amt;
    }

    public Employee getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(Employee emp_num) {
        this.emp_num = emp_num;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
