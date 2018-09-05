/*
 * 貸出明細 RENTAL_DETAIL(複合主キー)
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;

public class RentalDetailPK implements Serializable {

    private String rental_num;          //貸出番号(FK)

    @Size(max = 2)
    private String detail_num;          //明細番号

    /* コンストラクタ */
    public RentalDetailPK() {
    }

    public RentalDetailPK(String rental_num, String detail_num) {
        this.rental_num = rental_num;
        this.detail_num = detail_num;
    }

    /* hash、equals */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.rental_num);
        hash = 97 * hash + Objects.hashCode(this.detail_num);
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
        final RentalDetailPK other = (RentalDetailPK) obj;
        if (!Objects.equals(this.rental_num, other.rental_num)) {
            return false;
        }
        if (!Objects.equals(this.detail_num, other.detail_num)) {
            return false;
        }
        return true;
    }

    /* ゲッター、セッター */
    public String getRental_num() {
        return rental_num;
    }

    public void setRental_num(String rental_num) {
        this.rental_num = rental_num;
    }

    public String getDetail_num() {
        return detail_num;
    }

    public void setDetail_num(String detail_num) {
        this.detail_num = detail_num;
    }
}
