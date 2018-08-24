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
public class DelayListPK implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Size(max = 12)
    private Integer member_num;     // 会員番号

    @Size(max = 2)
    private Integer detail_num;                    // 明細番号

    /* コンストラクタ */
    public DelayListPK() {
    }

    public DelayListPK(Integer member_num, Integer detail_num) {
        this.member_num = member_num;
        this.detail_num = detail_num;
    }

    /* ゲッター、セッター */
    public Integer getMember_num() {
        return member_num;
    }

    public void setMember_num(Integer member_num) {
        this.member_num = member_num;
    }

    public Integer getDetail_num() {
        return detail_num;
    }

    public void setDetail_num(Integer detail_num) {
        this.detail_num = detail_num;
    }

    /* hashCode、 equals */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.member_num);
        hash = 59 * hash + Objects.hashCode(this.detail_num);
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
        final DelayListPK other = (DelayListPK) obj;
        if (!Objects.equals(this.member_num, other.member_num)) {
            return false;
        }
        if (!Objects.equals(this.detail_num, other.detail_num)) {
            return false;
        }
        return true;
    }

}
