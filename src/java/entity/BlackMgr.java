/*
 * ブラック管理 BLACK_MGR
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author sakura＊
 */
@Entity
@Table(name = "black_mgr")
public class BlackMgr implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 12)
    @JoinColumn(name = "member_num")
    private Member member_num;          // 会員番号(FK)

    @Size(max = 2)
    @Column(length = 2)
    private Integer delay_cnt;          // 遅延カウンター

    @Size(max = 1)
    @Column(length = 1)
    private char blk_flg;               // ブラックフラグ

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public BlackMgr() {
    }

    public BlackMgr(Member member_num, Integer delay_cnt, char blk_flg) {
        this.member_num = member_num;
        this.delay_cnt = delay_cnt;
        this.blk_flg = blk_flg;
    }

    /* ゲッター、セッター */
    public Member getMember_num() {
        return member_num;
    }

    public void setMember_num(Member member_num) {
        this.member_num = member_num;
    }

    public Integer getDelay_cnt() {
        return delay_cnt;
    }

    public void setDelay_cnt(Integer delay_cnt) {
        this.delay_cnt = delay_cnt;
    }

    public char getBlk_flg() {
        return blk_flg;
    }

    public void setBlk_flg(char blk_flg) {
        this.blk_flg = blk_flg;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
