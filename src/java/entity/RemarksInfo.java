/*
 * 備考情報 REMARKS_INFO
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
//    @NamedQuery(name = RemarksInfo.Qall, query = "SELECT e FROM REMARKS_INFO e")
//})
@Entity
@Table(name = "remarks_info")
public class RemarksInfo implements Serializable {
    
    public static final String Qall = "Qall";

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 9)
    @JoinColumn(name = "member_num")
    private Member member_num;          // 会員番号

    @Size(max = 200)
    @Column(length = 200)
    private String remarks;         // 備考

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public RemarksInfo() {
    }

    public RemarksInfo(Member member_num, String remarks) {
        this.member_num = member_num;
        this.remarks = remarks;
    }


    /* ゲッター、セッター */
    public Member getMember_num() {
        return member_num;
    }

    public void setMember_num(Member member_num) {
        this.member_num = member_num;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
