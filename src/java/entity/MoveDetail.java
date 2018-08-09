///*
// * MOVE_DETAIL
// */
//package entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author sakura＊
// */
//@Entity
//@Table(name = "move_detail")
//@SecondaryTables({
//    @SecondaryTable(name = "move_history"),
//    @SecondaryTable(name = "dvd_info"),
//    @SecondaryTable(name = "store_info")
//})
//public class MoveDetail implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @EmbeddedId
//    @JoinColumn(table = "move_history")
//    private MoveHistory move_num;        // 移動番号(FK)
//
//    @Id
//    @Size(max = 2)
//    private Integer move_detail_num;     // 移動明細番号
//
//    @NotNull
//    @Size(max = 14)
//    @JoinColumn(table = "dvd_info")
//    private DvdInfo dvd_num;             // DVD番号(FK)
//
//    @NotNull
//    @Size(max = 3)
//    @JoinColumn(table = "store_info")
//    private Store before_store_id;       // 移動前店舗ID(FK)
//
//    @NotNull
//    @Size(max = 3)
//    @JoinColumn(table = "store_info")
//    private Store after_store_id;        // 移動後店舗ID(FK)
//
//    @Transient                          // シリアライズしない
//    private boolean editable;
//    
//    /*コンストラクタ */
//
//    public MoveDetail() {
//    }
//
//    public MoveDetail(MoveHistory move_num, Integer move_detail_num, DvdInfo dvd_num, Store before_store_id, Store after_store_id) {
//        this.move_num = move_num;
//        this.move_detail_num = move_detail_num;
//        this.dvd_num = dvd_num;
//        this.before_store_id = before_store_id;
//        this.after_store_id = after_store_id;
//    }
//    
//    /* ゲッター、セッター */
//    public MoveHistory getMove_num() {
//        return move_num;
//    }
//
//    public void setMove_num(MoveHistory move_num) {
//        this.move_num = move_num;
//    }
//
//    public Integer getMove_detail_num() {
//        return move_detail_num;
//    }
//
//    public void setMove_detail_num(Integer move_detail_num) {
//        this.move_detail_num = move_detail_num;
//    }
//
//    public DvdInfo getDvd_num() {
//        return dvd_num;
//    }
//
//    public void setDvd_num(DvdInfo dvd_num) {
//        this.dvd_num = dvd_num;
//    }
//
//    public Store getBefore_store_id() {
//        return before_store_id;
//    }
//
//    public void setBefore_store_id(Store before_store_id) {
//        this.before_store_id = before_store_id;
//    }
//
//    public Store getAfter_store_id() {
//        return after_store_id;
//    }
//
//    public void setAfter_store_id(Store after_store_id) {
//        this.after_store_id = after_store_id;
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
