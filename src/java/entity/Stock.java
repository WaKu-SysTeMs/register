/*
 * 在庫 STOCK
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author sakura＊
 */
//@NamedQueries({
//    @NamedQuery(name = Stock.Qall, query = "SELECT e FROM STOCK e")
//})
@Entity
@IdClass(value = StockPK.class)
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 6)
    @JoinColumn(name = "product_num")
    private ProductInfo product_num;            // 商品番号

    @Id
    @Size(max = 3)
    @JoinColumn(name = "store_id")
    private StoreInfo store_id;                 // 店舗ID

    @Size(max = 2)
    @Column(length = 2)
    private Integer stock_cnt;                  // 在庫総数

    @Size(max = 2)
    @Column(length = 2)
    private Integer rental_cnt;                 // 貸出枚数

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Stock() {
    }

    public Stock(ProductInfo product_num, StoreInfo store_id, Integer stock_cnt, Integer rental_cnt) {
        this.product_num = product_num;
        this.store_id = store_id;
        this.stock_cnt = stock_cnt;
        this.rental_cnt = rental_cnt;
    }

    /* ゲッター、セッター */
    public ProductInfo getProduct_num() {
        return product_num;
    }

    public void setProduct_num(ProductInfo product_num) {
        this.product_num = product_num;
    }

    public StoreInfo getStore_id() {
        return store_id;
    }

    public void setStore_id(StoreInfo store_id) {
        this.store_id = store_id;
    }

    public Integer getStock_cnt() {
        return stock_cnt;
    }

    public void setStock_cnt(Integer stock_cnt) {
        this.stock_cnt = stock_cnt;
    }

    public Integer getRental_cnt() {
        return rental_cnt;
    }

    public void setRental_cnt(Integer rental_cnt) {
        this.rental_cnt = rental_cnt;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    }
