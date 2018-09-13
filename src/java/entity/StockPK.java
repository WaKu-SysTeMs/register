/*
 * 在庫 STOCK(複合主キー)
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;

public class StockPK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 6)
    private String product_num;       // 商品番号

    @Size(max = 3)
    private String store_id;                 // 店舗ID

    /* コンストラクタ */
    public StockPK() {
    }

    public StockPK(String product_num, String store_id) {
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
    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

}
