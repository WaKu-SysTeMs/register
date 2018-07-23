/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author s20163060
 */
@NamedQueries({
    @NamedQuery(name = Return.ReturnQAll,
            query = "SELECT r FROM Return r")
})
@Entity
@Table(name = "RENTAL_DETAIL")
public class Return implements Serializable{
    
    public static final String ReturnQAll = "ReturnQAll";
    @Transient
//    String kari = "ちょっとよくわからないです。";
    
    @Id
    private Number rental_num;  //貸出番号
    @Id
    private Number detail_num;  //明細番号
    
    private Number dvd_num;     //DVD番号
    private String release_kbn; //新旧区分
    private Date return_plan;   //返却予定日
    private Date return_date;   //返却年月日
    private String sale_id;     //SALE_ID
    private String stay_num;    //泊数ID
    private String discount_flg;//割引フラグ
    private String invalid_flg; //無効フラグ
    
    public Return(){
        
    }
    
    public Return(Number rental_num, Number detail_num, Number dvd_num,
            String release_kbn, Date return_plan, Date return_date,
            String sale_id, String stay_num, String discount_flg, String invalid_flg){
        
        this.rental_num = rental_num;
        this.detail_num = detail_num;
        this.dvd_num = dvd_num;
        this.release_kbn = release_kbn;
        this.return_plan = return_plan;
        this.return_date = return_date;
        this.sale_id = sale_id;
        this.stay_num = stay_num;
        this.discount_flg = discount_flg;
        this.invalid_flg = invalid_flg;
    }

    public Number getRental_num() {
        return rental_num;
    }

    public void setRental_num(Number rental_num) {
        this.rental_num = rental_num;
    }

    public Number getDetail_num() {
        return detail_num;
    }

    public void setDetail_num(Number detail_num) {
        this.detail_num = detail_num;
    }

    public Number getDvd_num() {
        return dvd_num;
    }

    public void setDvd_num(Number dvd_num) {
        this.dvd_num = dvd_num;
    }

    public String getRelease_kbn() {
        return release_kbn;
    }

    public void setRelease_kbn(String release_kbn) {
        this.release_kbn = release_kbn;
    }

    public Date getReturn_plan() {
        return return_plan;
    }

    public void setReturn_plan(Date return_plan) {
        this.return_plan = return_plan;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getStay_num() {
        return stay_num;
    }

    public void setStay_num(String stay_num) {
        this.stay_num = stay_num;
    }

    public String getDiscount_flg() {
        return discount_flg;
    }

    public void setDiscount_flg(String discount_flg) {
        this.discount_flg = discount_flg;
    }

    public String getInvalid_flg() {
        return invalid_flg;
    }

    public void setInvalid_flg(String invalid_flg) {
        this.invalid_flg = invalid_flg;
    }
    
    
}
