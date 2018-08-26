///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Objects;
//import javax.validation.constraints.Size;
//
///**
// *
// * @author s20163037
// */
//public class DelayListPK implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @Size(max = 12)
//    private Integer member_num;     // 会員番号
//
//    private RentalDetail rental_num;          // 貸出番号
//
//    @Size(max = 2)
//    private RentalDetail detail_num;                    // 明細番号
//
//
//    /* コンストラクタ */
//    public DelayListPK() {
//    }
////
////    public DelayListPK(Integer member_num, Integer detail_num) {
////        this.member_num = member_num;
////        this.detail_num = detail_num;
////    }
//
//    /* ゲッター、セッター */
//    public Integer getMember_num() {
//        return member_num;
//    }
//
//    public void setMember_num(Integer member_num) {
//        this.member_num = member_num;
//    }
//
////    public Integer getDetail_num() {
////        return detail_num;
////    }
////
////    public void setDetail_num(Integer detail_num) {
////        this.detail_num = detail_num;
////    }
////
////    public Integer getRental_num() {
////        return rental_num;
////    }
////
////    public void setRental_num(Integer rental_num) {
////        this.rental_num = rental_num;
////    }
//
//    public RentalDetail getRental_num() {
//        return rental_num;
//    }
//
//    public void setRental_num(RentalDetail rental_num) {
//        this.rental_num = rental_num;
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
//    
//
//
//    /* hashCode、 equals */
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 67 * hash + Objects.hashCode(this.member_num);
//        hash = 67 * hash + Objects.hashCode(this.rental_num);
//        hash = 67 * hash + Objects.hashCode(this.detail_num);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final DelayListPK other = (DelayListPK) obj;
//        if (!Objects.equals(this.member_num, other.member_num)) {
//            return false;
//        }
//        if (!Objects.equals(this.rental_num, other.rental_num)) {
//            return false;
//        }
//        if (!Objects.equals(this.detail_num, other.detail_num)) {
//            return false;
//        }
//        return true;
//    }
//
//
//}
