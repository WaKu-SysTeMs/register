///*
// * 貸出明細 RENTAL_DETAIL
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author s20163060
// */
//@NamedQueries({
//    @NamedQuery(name = RentalDetail.RentalDetailQAll,
//            query = "SELECT r FROM RentalDetail r")
//})
//@Entity
//@Table(name = "rental_detail")
//@SecondaryTables({
//    @SecondaryTable(name = "dvd_info"),
//    @SecondaryTable(name = "price_list"),
//    @SecondaryTable(name = "sale_info")
//})
//public class RentalDetail implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    public static final String RentalDetailQAll = "RentalDetailQAll";
//
//    @EmbeddedId
//    private RenalDetailPK rental_num;          //貸出番号(FK)
//
//    @NotNull
//    @Size(max = 14)
//    @JoinColumn(table = "dvd_info")
//    private DvdInfo dvd_num;             //DVD番号(FK)
//
//    @NotNull
//    @Size(max = 1)
//    @JoinColumn(table = "price_list")
//    private Price release_kbn;          //新旧区分(FK)
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date return_plan;           //返却予定日
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date return_date;           //返却年月日
//
//    @NotNull
//    @Size(max = 7)
//    @JoinColumn(table = "sale_info")
//    private SaleInfo sale_id;           //SALE_ID(FK)
//
//    @Size(max = 1)
//    @JoinColumn(table = "price_list")
//    private Price stay_num;             //泊数ID(FK)
//
//    @Size(max = 1)
//    private char discount_flg;          //割引フラグ
//
//    @Size(max = 3)
//    private Integer subtotal;           // 小計
//
//    @Size(max = 1)
//    private char invalid_flg;           //無効フラグ
//
//    @Transient                          // シリアライズしない
//    private boolean editable;
//
//    /* コンストラクタ */
//    public RentalDetail() {
//    }
//
//    public RentalDetail(RenalDetailPK rental_num, DvdInfo dvd_num, Price release_kbn, Date return_plan, Date return_date, SaleInfo sale_id, Price stay_num, char discount_flg, Integer subtotal, char invalid_flg) {
//        this.rental_num = rental_num;
//        this.dvd_num = dvd_num;
//        this.release_kbn = release_kbn;
//        this.return_plan = return_plan;
//        this.return_date = return_date;
//        this.sale_id = sale_id;
//        this.stay_num = stay_num;
//        this.discount_flg = discount_flg;
//        this.subtotal = subtotal;
//        this.invalid_flg = invalid_flg;
//    }
//
//    /* ゲッター、セッター */
//    public RenalDetailPK getRental_num() {
//        return rental_num;
//    }
//
//    public void setRental_num(RenalDetailPK rental_num) {
//        this.rental_num = rental_num;
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
//    public Price getRelease_kbn() {
//        return release_kbn;
//    }
//
//    public void setRelease_kbn(Price release_kbn) {
//        this.release_kbn = release_kbn;
//    }
//
//    public Date getReturn_plan() {
//        return return_plan;
//    }
//
//    public void setReturn_plan(Date return_plan) {
//        this.return_plan = return_plan;
//    }
//
//    public Date getReturn_date() {
//        return return_date;
//    }
//
//    public void setReturn_date(Date return_date) {
//        this.return_date = return_date;
//    }
//
//    public SaleInfo getSale_id() {
//        return sale_id;
//    }
//
//    public void setSale_id(SaleInfo sale_id) {
//        this.sale_id = sale_id;
//    }
//
//    public Price getStay_num() {
//        return stay_num;
//    }
//
//    public void setStay_num(Price stay_num) {
//        this.stay_num = stay_num;
//    }
//
//    public char getDiscount_flg() {
//        return discount_flg;
//    }
//
//    public void setDiscount_flg(char discount_flg) {
//        this.discount_flg = discount_flg;
//    }
//
//    public Integer getSubtotal() {
//        return subtotal;
//    }
//
//    public void setSubtotal(Integer subtotal) {
//        this.subtotal = subtotal;
//    }
//
//    public char getInvalid_flg() {
//        return invalid_flg;
//    }
//
//    public void setInvalid_flg(char invalid_flg) {
//        this.invalid_flg = invalid_flg;
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
