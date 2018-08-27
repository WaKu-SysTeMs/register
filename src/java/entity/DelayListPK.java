/*
 * 延滞料金 DELAY_LIST(複合主キー)
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;


/**
 *
 * @author s20163037
 */
public class DelayListPK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 12)
    private Integer member_num;            // 会員番号(FK)

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date payment_date;             // 支払日


    /* コンストラクタ */
    public DelayListPK() {
    }

    public DelayListPK(Integer member_num, Date payment_date) {
        this.member_num = member_num;
        this.payment_date = payment_date;
    }

    /* ゲッター、セッター */
    public Integer getMember_num() {
        return member_num;
    }

    public void setMember_num(Integer member_num) {
        this.member_num = member_num;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    /* hashCode、 equals */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.member_num);
        hash = 67 * hash + Objects.hashCode(this.payment_date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DelayListPK other = (DelayListPK) obj;
        if (!Objects.equals(this.member_num, other.member_num)) {
            return false;
        }
        if (!Objects.equals(this.payment_date, other.payment_date)) {
            return false;
        }
        return true;
    }

}
