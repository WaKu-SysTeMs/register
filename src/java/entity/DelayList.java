/*
 * 延滞料金 DELAY_LIST
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
@Entity
@Table(name = "delay_list")
@IdClass(value = DelayListPK.class)
public class DelayList implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 12)
    @JoinColumn(name = "member_num")
    private Member member_num;             // 会員番号(FK)

    @Id
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date payment_date;             // 支払日

    @Size(max = 9)
    @Column(length = 9)
    private Integer delay;                 // 延滞料金

    @Transient                  // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public DelayList() {
    }

    public DelayList(Member member_num, Date payment_date, Integer delay) {
        this.member_num = member_num;
        this.payment_date = payment_date;
        this.delay = delay;
    }

    /* ゲッター、セッター */
    public Member getMember_num() {
        return member_num;
    }

    public void setMember_num(Member member_num) {
        this.member_num = member_num;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
