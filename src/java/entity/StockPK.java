///*
// * 
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Objects;
//import javax.persistence.*;
//import javax.validation.constraints.Size;
//
///**
// *
// * @author sakura＊
// */
//@Embeddable
//@SecondaryTables({
//    @SecondaryTable(name = "product_info"),
//    @SecondaryTable(name = "store_info")
//})
//class StockPK implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @Size(max = 13)
//    @JoinColumn(table = "product_info")
//    private ProductInfo product_num;       // 商品番号
//
//    @Size(max = 3)
//    @JoinColumn(table = "store_info")
//    private Store store_id;                 // 店舗ID
//
//    /* コンストラクタ */
//    public StockPK() {
//    }
//
//    public StockPK(ProductInfo product_num, Store store_id) {
//        this.product_num = product_num;
//        this.store_id = store_id;
//    }
//
//
//
//    /* hash、equals */
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 29 * hash + Objects.hashCode(this.product_num);
//        hash = 29 * hash + Objects.hashCode(this.store_id);
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
//        final StockPK other = (StockPK) obj;
//        if (!Objects.equals(this.product_num, other.product_num)) {
//            return false;
//        }
//        if (!Objects.equals(this.store_id, other.store_id)) {
//            return false;
//        }
//        return true;
//    }
//
//    /* ゲッター、セッター */
//
//    public ProductInfo getProduct_info() {
//        return product_num;
//    }
//
//    public void setProduct_info(ProductInfo product_num) {
//        this.product_num = product_num;
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
//    
//
//}
