/*
 * 対象ジャンル TARGET_CATEGORY
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
//    @NamedQuery(name = TargetCategory.Qall, query = "SELECT e FROM TARGET_CATEGORY e")
//})
@Entity
@Table(name = "target_category")
@IdClass(value = TargetCategoryPK.class)
public class TargetCategory implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 7)
    @JoinColumn(name = "sale_id")
    private SaleInfo sale_id;           // SALE ID(FK)

    @Id
    @JoinColumn(name = "category_id")
    private Category category_id;       // ジャンルID

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public TargetCategory() {
    }

    public TargetCategory(SaleInfo sale_id, Category category_id) {
        this.sale_id = sale_id;
        this.category_id = category_id;
    }

    /* ゲッター、セッター */
    public SaleInfo getSale_id() {
        return sale_id;
    }

    public void setSale_id(SaleInfo sale_id) {
        this.sale_id = sale_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
