/*
 * 貸出処理　エンティティ
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author s20163037
 */
@NamedQueries({
    @NamedQuery(name = Rental.RentalQAll,
            query = "SELECT e FROM Rental e")
})
@Entity
@Table(name = "rental_info")
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L; // シリアライズ

    public static final String RentalQAll = "RentalQAll";

    @Id
    @NotNull
    private Integer rental_num;          // 貸出番号

    @JoinColumn(table = "member_info")
    private Member member_num;           // 会員番号(FK)

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rental_date;            // 貸出年月日

    private int amount;                 // 合計金額

    @JoinColumn(table = "register")
    private Register register_id;         // レジ番号(FK)

    @JoinColumn(table = "emp_info")
    private Employee emp_num;               // 社員番号(FK)

    @Transient                              // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Rental() {
    }

    public Rental(Integer rental_num, Member member_num, Date rental_date, int amount, Register register_id, Employee emp_num) {
        this.rental_num = rental_num;
        this.member_num = member_num;
        this.rental_date = rental_date;
        this.amount = amount;
        this.register_id = register_id;
        this.emp_num = emp_num;
    }

    /* セッター、ゲッター */
    public Integer getRental_num() {
        return rental_num;
    }

    public void setRental_num(Integer rental_num) {
        this.rental_num = rental_num;
    }

    public Member getMember_num() {
        return member_num;
    }

    public void setMember_num(Member member_num) {
        this.member_num = member_num;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Register getRegister_id() {
        return register_id;
    }

    public void setRegister_id(Register register_id) {
        this.register_id = register_id;
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
