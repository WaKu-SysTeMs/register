/*
 * 貸出明細 RENTAL_DETAIL
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author s20163060
 */
@NamedQueries({
    @NamedQuery(name = RentalDetail.RentalDetailQAll,
            query = "SELECT r FROM RentalDetail r")
})
@Entity
@Table(name = "rental_detail")
@IdClass(value = RentalDetailPK.class)
public class RentalDetail implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    public static final String RentalDetailQAll = "RentalDetailQAll";

    @Id
    private RentalInfo rental_num;              // 貸出番号(FK) 

    @Id
    @Size(max = 2)
    private Integer detail_num;                 // 明細番号

    @NotNull
    @Size(max = 14)
    private DvdInfo dvd_num;             //DVD番号(FK)

    @NotNull
    @Size(max = 1)
    private PriceList release_kbn;          //新旧区分(FK)

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date return_plan;           //返却予定日

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date return_date;           //返却年月日

    @NotNull
    @Size(max = 7)
    private SaleInfo sale_id;           //SALE_ID(FK)

//    @Size(max = 1)
//    private PriceList stay_num;             //泊数ID(FK)
    
    @Size(max = 1)
    private char discount_flg;          //割引フラグ

    @Size(max = 3)
    private Integer subtotal;           // 小計

    @Size(max = 1)
    private char invalid_flg;           //無効フラグ
    
//    @OneToMany(mappedBy = "detail_num", cascade = CascadeType.ALL)
//    private List<DelayList> relayList;

    @Transient                          // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public RentalDetail() {
    }

    /* ゲッター、セッター */
    public RentalInfo getRental_num() {
        return rental_num;
    }

    public void setRental_num(RentalInfo rental_num) {
        this.rental_num = rental_num;
    }

    public Integer getDetail_num() {
        return detail_num;
    }

    public void setDetail_num(Integer detail_num) {
        this.detail_num = detail_num;
    }

    public DvdInfo getDvd_num() {
        return dvd_num;
    }

    public void setDvd_num(DvdInfo dvd_num) {
        this.dvd_num = dvd_num;
    }

    public PriceList getRelease_kbn() {
        return release_kbn;
    }

    public void setRelease_kbn(PriceList release_kbn) {
        this.release_kbn = release_kbn;
    }

    public Date getReturn_plan() {
        return return_plan;
    }

    public void setReturn_plan(Date return_plan) {
        this.return_plan = return_plan;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public SaleInfo getSale_id() {
        return sale_id;
    }

    public void setSale_id(SaleInfo sale_id) {
        this.sale_id = sale_id;
    }

    public char getDiscount_flg() {
        return discount_flg;
    }

    public void setDiscount_flg(char discount_flg) {
        this.discount_flg = discount_flg;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public char getInvalid_flg() {
        return invalid_flg;
    }

    public void setInvalid_flg(char invalid_flg) {
        this.invalid_flg = invalid_flg;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
