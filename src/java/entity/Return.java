///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//
///**
// *
// * @author s20163060
// */
//@NamedQueries({
//    @NamedQuery(name = Return.ReturnQAll,
//            query = "SELECT r FROM Return r")
//})
//@Entity
//@Table(name = "RENTAL_DETAIL")
//public class Return implements Serializable{
//    
//    public static final String ReturnQAll = "ReturnQAll";
//    @Transient
////    String kari = "ちょっとよくわからないです。";
//    
//    @Id
//    private Number rental_num;  //貸出番号
//    @Id
//    private Number detail_num;  //明細番号
//    
//    private Number dvd_num;     //DVD番号
//    private String release_kbn; //新旧区分
//    private Date return_plan;   //返却予定日
//    private Date return_date;   //返却年月日
//    private String sale_id;     //SALE_ID
//    private String stay_num;    //泊数ID
//    private String discount_flg;//割引フラグ
//    private String invalid_flg; //無効フラグ
//    
//    public Return(){
//        
//    }
//    
//    public Return(Number rental_num, Number detail_num, Number dvd_num,
//            String release_kbn, Date return_plan, Date return_date,
//            String sale_id, String stay_num, String discount_flg, String invalid_flg){
//        
//        this.rental_num = rental_num;
//        this.detail_num = detail_num;
//        this.dvd_num = dvd_num;
//        this.release_kbn = release_kbn;
//        this.return_plan = return_plan;
//        this.return_date = return_date;
//        this.sale_id = sale_id;
//        this.stay_num = stay_num;
//        this.discount_flg = discount_flg;
//        this.invalid_flg = invalid_flg;
//    }
//}
