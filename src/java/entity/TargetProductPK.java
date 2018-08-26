/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author sakura＊
 */
public class TargetProductPK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 7)
    private String sale_id;         // SALE ID

    @Size(max = 13)
    @Column(name = "product_num")
    private Integer product_num;    // 商品番号(FK)

    /* コンストラクタ */
    public TargetProductPK() {
    }

    public TargetProductPK(String sale_id, Integer product_num) {
        this.sale_id = sale_id;
        this.product_num = product_num;
    }

    /* ゲッター、セッター */
    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public Integer getProduct_num() {
        return product_num;
    }

    public void setProduct_num(Integer product_num) {
        this.product_num = product_num;
    }

    /* hashCode、equals */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.sale_id);
        hash = 47 * hash + Objects.hashCode(this.product_num);
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
        final TargetProductPK other = (TargetProductPK) obj;
        if (!Objects.equals(this.sale_id, other.sale_id)) {
            return false;
        }
        if (!Objects.equals(this.product_num, other.product_num)) {
            return false;
        }
        return true;
    }

}
