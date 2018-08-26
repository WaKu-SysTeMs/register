///*
// * 延滞料金 DELAY_LIST
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author s20163037
// */
//@Entity
//@Table(name = "delay_list")
//@IdClass(value = DelayListPK.class)
//public class DelayList implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @Id
//    @Size(max = 12)
//    private Member member_num;             // 会員番号(FK)
//
//    @Id
//    private RentalDetail rental_num;
//    
//    @Id
//    @Size(max = 2)
//    private RentalDetail detail_num;                 // 明細番号
//
//    @Size(max = 9)
//    private Integer delay;                 // 延滞料金
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date payment_date;             // 支払日
//
//    @Transient                  // シリアライズしない
//    private boolean editable;
//
//    /* コンストラクタ */
//    public DelayList() {
//    }
//
////    public DelayList(Member member_num, RentalDetail detail_num, Integer delay, Date payment_date) {
////        this.member_num = member_num;
////        this.detail_num = detail_num;
////        this.delay = delay;
////        this.payment_date = payment_date;
////    }
//    /* ゲッター、セッター */
//    public Member getMember_num() {
//        return member_num;
//    }
//
//    public void setMember_num(Member member_num) {
//        this.member_num = member_num;
//    }
//
//    public RentalDetail getDetail_num() {
//        return detail_num;
//    }
//
//    public void setDetail_num(RentalDetail detail_num) {
//        this.detail_num = detail_num;
//    }
//
//    public Integer getDelay() {
//        return delay;
//    }
//
//    public void setDelay(Integer delay) {
//        this.delay = delay;
//    }
//
//    public Date getPayment_date() {
//        return payment_date;
//    }
//
//    public void setPayment_date(Date payment_date) {
//        this.payment_date = payment_date;
//    }
//
//    public boolean isEditable() {
//        return editable;
//    }
//
//    public void setEditable(boolean editable) {
//        this.editable = editable;
//    }
//
//}
