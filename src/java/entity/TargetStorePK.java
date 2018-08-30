/*
 * 対象店舗 TARGET_STORE(複合主キー)aaa
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 *
 * @author sakura＊
 */
public class TargetStorePK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 7)
    private String sale_id;         // SALE ID(FK)

    @Size(max = 3)
    private String store_id;            // 店舗ID(FK)

    /* コンストラクタ */
    public TargetStorePK() {
    }

    public TargetStorePK(String sale_id, String store_id) {
        this.sale_id = sale_id;
        this.store_id = store_id;
    }

    /* ゲッター、セッター */
    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    /* hashCode、equals */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.sale_id);
        hash = 97 * hash + Objects.hashCode(this.store_id);
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
        final TargetStorePK other = (TargetStorePK) obj;
        if (!Objects.equals(this.sale_id, other.sale_id)) {
            return false;
        }
        if (!Objects.equals(this.store_id, other.store_id)) {
            return false;
        }
        return true;
    }

}
