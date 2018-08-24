///*
// * 延滞料金 DELAY_LIST
// */
//package entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author s20163037
// */
////@Entity
//@Table(name = "delay_list")
//public class DelayList implements Serializable{
//    
//     private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//     
//     @Id
//     @Size(max = 12)
//     private Member member_num;             // 会員番号(FK)
//     
//     @Id
//     @NotNull
//     private RentalInfo rental_num;         // 貸出番号(FK)
//     
//     @Id
//     @Size(max = 2)
//}
