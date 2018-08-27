/*
 * 在庫移動詳細 MOVE_DETAIL(複合主キー)
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;


/**
 *
 * @author s20163037
 */
public class MoveDetailPK implements Serializable {

    private static final long serialVersionUID = 1L; // シリアルバージョンUIDのバージョン管理

    private Integer move_num;       // 移動番号(FK)

    @Size(max = 2)
    private Integer move_detail_num;     // 移動明細番号

    /* コンストラクタ */
    public MoveDetailPK() {
    }

    public MoveDetailPK(Integer move_num, Integer move_detail_num) {
        this.move_num = move_num;
        this.move_detail_num = move_detail_num;
    }

    /* ゲッター、セッター */
    public Integer getMove_num() {
        return move_num;
    }

    public void setMove_num(Integer move_num) {
        this.move_num = move_num;
    }

    public Integer getMove_detail_num() {
        return move_detail_num;
    }

    public void setMove_detail_num(Integer move_detail_num) {
        this.move_detail_num = move_detail_num;
    }

    /* hashCode、equals */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.move_num);
        hash = 97 * hash + Objects.hashCode(this.move_detail_num);
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
        final MoveDetailPK other = (MoveDetailPK) obj;
        if (!Objects.equals(this.move_num, other.move_num)) {
            return false;
        }
        if (!Objects.equals(this.move_detail_num, other.move_detail_num)) {
            return false;
        }
        return true;
    }

}
