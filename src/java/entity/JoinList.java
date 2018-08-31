/*
 * 入退会リスト JOIN_LIST
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author sakura＊
 */
//@NamedQueries({
//    @NamedQuery(name = JoinList.Qall, query = "SELECT * FROM JOIN_LIST")
//})
@Entity
@Table(name = "join_list")
public class JoinList implements Serializable {
    
    public static final String Qall = "Qall";

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 9)
    @JoinColumn(name = "member_num")
    private Member member_num;          // 会員番号(FK)

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date join_date;             // 入会年月日

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date resign_plan;           // 退会予定年月日

    @Size(max = 1)                   // もしくは@patternで
    private char resign_flg;            // 退会フラグ

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public JoinList() {
    }

    public JoinList(Member member_num, Date join_date, Date resign_plan, char resign_flg) {
        this.member_num = member_num;
        this.join_date = join_date;
        this.resign_plan = resign_plan;
        this.resign_flg = resign_flg;
    }

    /* ゲッター、セッター */
    public Member getMember_num() {
        return member_num;
    }

    public void setMember_num(Member member_num) {
        this.member_num = member_num;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public Date getResign_plan() {
        return resign_plan;
    }

    public void setResign_plan(Date resign_plan) {
        this.resign_plan = resign_plan;
    }

    public char getResign_flg() {
        return resign_flg;
    }

    public void setResign_flg(char resign_flg) {
        this.resign_flg = resign_flg;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
