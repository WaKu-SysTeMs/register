///*
// * 対象ジャンル TARGET_CATEGORY
// */
//package entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author sakura＊
// */
//@Entity
//@Table(name = "target_category")
//public class TargetCategory implements Serializable {
//    
//    
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @Id
//    @Size(max = 7)
//    private SaleInfo sale_id;           // SALE ID
//    
//    @EmbeddedId
//    private Category category_id;       // ジャンルID
//
//
//    @Transient                           // シリアライズしない
//    private boolean editable;
//
//    
//    /* コンストラクタ */
//    
//    
//    /* ゲッター、セッター */
//    
//}
