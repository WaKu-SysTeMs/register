/*
 * 貸出上限 RENTAL_MAX
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 *
 * @author sakura＊
 */
//@NamedQueries({
//    @NamedQuery(name = RentalMax.Qall, query = "SELECT * FROM RENTAL_MAX")
//})
@Entity
@Table(name = "rental_max")
public class RentalMax implements Serializable {
    
    public static final String Qall = "Qall";

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 9)
    @JoinColumn(name = "member_num")
    private Member member_num;          // 会員番号

    @Size(max = 2)
    @Column(length = 2)
    private Integer borrowing_cnt;      // 借入枚数

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public RentalMax() {
    }

    public RentalMax(Member member_num, Integer borrowing_cnt) {
        this.member_num = member_num;
        this.borrowing_cnt = borrowing_cnt;
    }

    /* ゲッター、セッター */
    public Member getMember_num() {
        return member_num;
    }

    public void setMember_num(Member member_num) {
        this.member_num = member_num;
    }

    public Integer getBorrowing_cnt() {
        return borrowing_cnt;
    }

    public void setBorrowing_cnt(Integer borrowing_cnt) {
        this.borrowing_cnt = borrowing_cnt;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
