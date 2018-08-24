/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;


/**
 *
 * @author s20163037
 */
public class PriceListPK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 1)
    private String release_kbn;         // 新旧区分(FK)

    @Size(max = 1)
    private String stay_num;        // 泊数ID(FK)

    /* コンストラクタ */
    public PriceListPK() {
    }

    public PriceListPK(String release_kbn, String stay_num) {
        this.release_kbn = release_kbn;
        this.stay_num = stay_num;
    }
    /* ゲッター、セッター */

    public String getRelease_kbn() {
        return release_kbn;
    }

    public void setRelease_kbn(String release_kbn) {
        this.release_kbn = release_kbn;
    }

    public String getStay_num() {
        return stay_num;
    }

    public void setStay_num(String stay_num) {
        this.stay_num = stay_num;
    }


    /* hashCode、 eqauls */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.release_kbn);
        hash = 97 * hash + Objects.hashCode(this.stay_num);
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
        final PriceListPK other = (PriceListPK) obj;
        if (!Objects.equals(this.release_kbn, other.release_kbn)) {
            return false;
        }
        if (!Objects.equals(this.stay_num, other.stay_num)) {
            return false;
        }
        return true;
    }

}
