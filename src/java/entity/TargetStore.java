///*
// * 対象店舗 TARGET_STORE
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
//@Table(name = "target_store")
//public class TargetStore implements Serializable {
//
//    @EmbeddedId
//    @Size(max = 7)
//    private SaleInfo sale_id;       // SALE ID(FK)
//
//    @EmbeddedId
//    @Size(max = 3)
//    private Store store_id;        // 店舗ID(FK)
//
//    @Transient                           // シリアライズしない
//    private boolean editable;
//
//    /* コンストラクタ */
//    public TargetStore() {
//    }
//
//    public TargetStore(SaleInfo sale_id, Store store_id) {
//        this.sale_id = sale_id;
//        this.store_id = store_id;
//    }
//
//    /* ゲッター、セッター */
//    public SaleInfo getSale_id() {
//        return sale_id;
//    }
//
//    public void setSale_id(SaleInfo sale_id) {
//        this.sale_id = sale_id;
//    }
//
//    public Store getStore_id() {
//        return store_id;
//    }
//
//    public void setStore_id(Store store_id) {
//        this.store_id = store_id;
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
