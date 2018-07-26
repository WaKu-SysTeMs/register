/*
 * 貸出処理　エンティティ
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

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
@SecondaryTables({
    @SecondaryTable(name = "member_info"),
    @SecondaryTable(name = "register"),
    @SecondaryTable(name = "emp_info")
})
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    public static final String RentalQAll = "RentalQAll";

    @Id
    @NotNull
    private Integer rental_num;          // 貸出番号

    @NotNull
    @Size(max = 12)
    @JoinColumn(table = "member_info")
    private Member member_num;           // 会員番号(FK)

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rental_date;            // 貸出年月日

    @Size(max = 6)
    private Integer amount;                  // 合計金額

    @NotNull
    @Size(max = 4)
    @JoinColumn(table = "register")
    private Register register_id;        // レジ番号(FK)

    @Size(max = 10)
    @JoinColumn(table = "emp_info")
    private Employee emp_num;            // 社員番号(FK)

    @Transient                           // シリアライズしない
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
