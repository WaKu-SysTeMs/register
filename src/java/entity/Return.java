/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author s20163060
 */
@NamedQueries({
    @NamedQuery(name = Return.Qmember_name,
            query = "SELECT r.member_name FROM Return r WHERE r.MEMBER_INFO.member_name = :member_name"),
    @NamedQuery(name = Return.Qdvd_num,
            query = "SELECT r.dvd_num FROM Return r WHERE r.dvd_num = :dvd_num"),
    @NamedQuery(name = Return.Qreturn,
            query = "SELECT r FROM Return r WHERE ")
})
@Entity
@Table(name = "RENTAL_DETAIL")
public class Return implements Serializable{
    
    public static final String Qmember_name = "Qmember_name";
    public static final String Qdvd_num = "Qdvd_num";
    public static final String Qreturn = "Qreturn";
    @Transient
//    String kari = "ちょっとよくわからないです。";
    
    @Id
    private int rental_num;
    @Id
    private int detail_num;
    private String member_name;
    private int dvd_num;
    private String product_name;
    private String rental_date;
    private String return_plan;
    private int delay;
    
    public Return(){
    }
    
    public Return(String product_name, String rental_date, String return_plan, int delay){
        this.product_name = product_name;
        this.rental_date = rental_date;
        this.return_plan = return_plan;
        this.delay = delay;
    }

    
    
    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public int getDvd_num() {
        return dvd_num;
    }

    public void setDvd_num(int dvd_num) {
        this.dvd_num = dvd_num;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getRental_date() {
        return rental_date;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    public String getReturn_plan() {
        return return_plan;
    }

    public void setReturn_plan(String return_plan) {
        this.return_plan = return_plan;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
    
    
}
