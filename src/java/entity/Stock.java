/*
 * 在庫 STOCK
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author sakura＊
 */
@Entity
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    private StockPK stock_id;           // 在庫ID(複合キー)

    @Size(max = 2)
    private Integer stock_cnt;           // 在庫総数

    @Size(max = 2)
    private Integer rental_cnt;         // 貸出枚数

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Stock() {
    }

    public Stock(StockPK stock_id, Integer stock_cnt, Integer rental_cnt) {
        this.stock_id = stock_id;
        this.stock_cnt = stock_cnt;
        this.rental_cnt = rental_cnt;
    }

    /* ゲッター、セッター */
    public StockPK getStock_id() {
        return stock_id;
    }

    public void setStock_id(StockPK stock_id) {
        this.stock_id = stock_id;
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


@Embeddable
class StockPK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 13)
    private ProductInfo product_num;       // 商品番号

    @Size(max = 3)
    private StoreInfo store_id;                 // 店舗ID

    /* コンストラクタ */
    public StockPK() {
    }

    public StockPK(ProductInfo product_num, StoreInfo store_id) {
        this.product_num = product_num;
        this.store_id = store_id;
    }



    /* hash、equals */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.product_num);
        hash = 29 * hash + Objects.hashCode(this.store_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StockPK other = (StockPK) obj;
        if (!Objects.equals(this.product_num, other.product_num)) {
            return false;
        }
        if (!Objects.equals(this.store_id, other.store_id)) {
            return false;
        }
        return true;
    }

    /* ゲッター、セッター */
    public ProductInfo getProduct_info() {
        return product_num;
    }

    public void setProduct_info(ProductInfo product_num) {
        this.product_num = product_num;
    }

    public StoreInfo getStore_id() {
        return store_id;
    }

    public void setStore_id(StoreInfo store_id) {
        this.store_id = store_id;
    }
}
