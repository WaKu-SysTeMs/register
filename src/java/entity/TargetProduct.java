/*
 * 対象商品 TARGET_PRODUCT
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163037
 */
@Entity
@Table(name = "target_product")
@IdClass(value = TargetProductPK.class)
public class TargetProduct implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 7)
    @JoinColumn(name = "sale_id")
    private SaleInfo sale_id;            // SALE ID(FK)

    @Id
    @Size(max = 13)
    @JoinColumn(name = "product_num")
    private ProductInfo product_num;    // 商品番号(FK)

    @Transient                           // シリアライズしない
    private boolean editable;
    
    /* コンストラクタ */

    public TargetProduct() {
    }

    public TargetProduct(SaleInfo sale_id, ProductInfo product_num) {
        this.sale_id = sale_id;
        this.product_num = product_num;
    }
    
    /* ゲッター、セッター */

    public SaleInfo getSale_id() {
        return sale_id;
    }

    public void setSale_id(SaleInfo sale_id) {
        this.sale_id = sale_id;
    }

    public ProductInfo getProduct_num() {
        return product_num;
    }

    public void setProduct_num(ProductInfo product_num) {
        this.product_num = product_num;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
