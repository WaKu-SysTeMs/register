/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163022
 */
@Embeddable
public class DelayListPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RENTAL_NUM")
    private String rentalNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DETAIL_NUM")
    private String detailNum;

    public DelayListPK() {
    }

    public DelayListPK(String rentalNum, String detailNum) {
        this.rentalNum = rentalNum;
        this.detailNum = detailNum;
    }

    public String getRentalNum() {
        return rentalNum;
    }

    public void setRentalNum(String rentalNum) {
        this.rentalNum = rentalNum;
    }

    public String getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(String detailNum) {
        this.detailNum = detailNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentalNum != null ? rentalNum.hashCode() : 0);
        hash += (detailNum != null ? detailNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelayListPK)) {
            return false;
        }
        DelayListPK other = (DelayListPK) object;
        if ((this.rentalNum == null && other.rentalNum != null) || (this.rentalNum != null && !this.rentalNum.equals(other.rentalNum))) {
            return false;
        }
        if ((this.detailNum == null && other.detailNum != null) || (this.detailNum != null && !this.detailNum.equals(other.detailNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DelayListPK[ rentalNum=" + rentalNum + ", detailNum=" + detailNum + " ]";
    }
    
}
