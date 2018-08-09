///*
// * MOVE_HISTORY
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.*;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author sakura＊
// */
//@Entity
//@Table(name = "move_history")
//@SecondaryTables({
//    @SecondaryTable(name = "product_info"),
//    @SecondaryTable(name = "emp_info")
//})
//public class MoveHistory implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @Id
//    private Integer move_num;       // 移動番号
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date move_date;         // 移動処理日付
//
//    @NotNull
//    @Size(max = 13)
//    @JoinColumn(name = "product_info")
//    private ProductInfo product_num;    // 商品番号
//
//    @NotNull
//    @Size(max = 10)
//    @JoinColumn(name = "emp_info")
//    private Employee emp_num;           // 社員番号
//
//    @OneToMany(mappedBy = "move_num", cascade = CascadeType.ALL)
//    private List<MoveDetail> moveDetail;
//
//    @Transient                           // シリアライズしない
//    private boolean editable;
//
//    /* コンストラクタ */
//    public MoveHistory() {
//    }
//
//    public MoveHistory(Integer move_num, Date move_date, ProductInfo product_num, Employee emp_num) {
//        this.move_num = move_num;
//        this.move_date = move_date;
//        this.product_num = product_num;
//        this.emp_num = emp_num;
//    }
//
//    /* ゲッター、セッター */
//    public Integer getMove_num() {
//        return move_num;
//    }
//
//    public void setMove_num(Integer move_num) {
//        this.move_num = move_num;
//    }
//
//    public Date getMove_date() {
//        return move_date;
//    }
//
//    public void setMove_date(Date move_date) {
//        this.move_date = move_date;
//    }
//
//    public ProductInfo getProduct_num() {
//        return product_num;
//    }
//
//    public void setProduct_num(ProductInfo product_num) {
//        this.product_num = product_num;
//    }
//
//    public Employee getEmp_num() {
//        return emp_num;
//    }
//
//    public void setEmp_num(Employee emp_num) {
//        this.emp_num = emp_num;
//    }
//
//    public List<MoveDetail> getMoveDetail() {
//        return moveDetail;
//    }
//
//    public void setMoveDetail(List<MoveDetail> moveDetail) {
//        this.moveDetail = moveDetail;
//    }
//
//    public boolean isEditable() {
//        return editable;
//    }
//
//    public void setEditable(boolean editable) {
//        this.editable = editable;
//    }
//
//}
