/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author s20163022
 */
@Entity
@Table(name = "DELAY_LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DelayList.findAll", query = "SELECT d FROM DelayList d"),
    @NamedQuery(name = "DelayList.findByRentalNum", query = "SELECT d FROM DelayList d WHERE d.delayListPK.rentalNum = :rentalNum"),
    @NamedQuery(name = "DelayList.findByDetailNum", query = "SELECT d FROM DelayList d WHERE d.delayListPK.detailNum = :detailNum"),
    @NamedQuery(name = "DelayList.findByDelay", query = "SELECT d FROM DelayList d WHERE d.delay = :delay"),
    @NamedQuery(name = "DelayList.findByPaymentDate", query = "SELECT d FROM DelayList d WHERE d.paymentDate = :paymentDate")})
public class DelayList implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DelayListPK delayListPK;
    @Column(name = "DELAY")
    private Integer delay;
    @Column(name = "PAYMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    public DelayList() {
    }

    public DelayList(DelayListPK delayListPK) {
        this.delayListPK = delayListPK;
    }

    public DelayList(String rentalNum, String detailNum) {
        this.delayListPK = new DelayListPK(rentalNum, detailNum);
    }

    public DelayListPK getDelayListPK() {
        return delayListPK;
    }

    public void setDelayListPK(DelayListPK delayListPK) {
        this.delayListPK = delayListPK;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (delayListPK != null ? delayListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelayList)) {
            return false;
        }
        DelayList other = (DelayList) object;
        if ((this.delayListPK == null && other.delayListPK != null) || (this.delayListPK != null && !this.delayListPK.equals(other.delayListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DelayList[ delayListPK=" + delayListPK + " ]";
    }
    
}
