/*
 * 在庫移動履歴 MOVE_HISTORY
 */
package entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author sakura＊
 */
//@NamedQueries({
//    @NamedQuery(name = MoveHistory.Qall, query = "SELECT * FROM MOVE_HISTORY")
//})
@Entity
@Table(name = "move_history")
public class MoveHistory implements Serializable {

    public static final String Qall = "Qall";

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    private String move_num;       // 移動番号

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date move_date;         // 移動処理日付

    @NotNull
    @Size(max = 6)
    @JoinColumn(name = "product_num")
    private ProductInfo product_num;    // 商品番号(FK)

    @NotNull
    @Size(max = 8)
    @JoinColumn(name = "emp_num")
    private Employee emp_num;           // 社員番号(FK)

    @OneToMany(mappedBy = "move_num", cascade = CascadeType.ALL)
    private List<MoveDetail> moveDetail;

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public MoveHistory() {
    }

    public MoveHistory(String move_num, Date move_date, ProductInfo product_num, Employee emp_num) {
        this.move_num = move_num;
        this.move_date = move_date;
        this.product_num = product_num;
        this.emp_num = emp_num;
    }

    /* ゲッター、セッター */
    public String getMove_num() {
        return move_num;
    }

    public void setMove_num(String move_num) {
        this.move_num = move_num;
    }

    public Date getMove_date() {
        return move_date;
    }

    public void setMove_date(Date move_date) {
        this.move_date = move_date;
    }

    public ProductInfo getProduct_num() {
        return product_num;
    }

    public void setProduct_num(ProductInfo product_num) {
        this.product_num = product_num;
    }

    public Employee getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(Employee emp_num) {
        this.emp_num = emp_num;
    }

    public List<MoveDetail> getMoveDetail() {
        return moveDetail;
    }

    public void setMoveDetail(List<MoveDetail> moveDetail) {
        this.moveDetail = moveDetail;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
