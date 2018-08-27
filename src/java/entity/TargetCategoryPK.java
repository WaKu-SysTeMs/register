/*
 * 対象ジャンル TARGET_CATEGORY(複合主キー)
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;


/**
 *
 * @author sakura＊
 */
public class TargetCategoryPK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 7)
    private String sale_id;         // SALE ID(FK)

    @Size(max = 3)
    private String category_id;         // ジャンルID(FK)

    /* コンストラクタ */
    public TargetCategoryPK() {
    }

    public TargetCategoryPK(String sale_id, String category_id) {
        this.sale_id = sale_id;
        this.category_id = category_id;
    }

    /* ゲッター、セッター */
    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    /* hashCode、equals */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.sale_id);
        hash = 29 * hash + Objects.hashCode(this.category_id);
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
        final TargetCategoryPK other = (TargetCategoryPK) obj;
        if (!Objects.equals(this.sale_id, other.sale_id)) {
            return false;
        }
        if (!Objects.equals(this.category_id, other.category_id)) {
            return false;
        }
        return true;
    }

}
