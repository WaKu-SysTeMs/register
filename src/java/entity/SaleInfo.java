/*
 * SALE情報 SALE_INFO
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author s20163037
 */
@Entity
@Table( name = "sale_info" )
public class SaleInfo implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size( max = 7 )
    private String sale_id;         // SALE ID

    @Size( max = 50 )
    private String sale_name;       // SALE名

    @NotNull
    @Temporal( javax.persistence.TemporalType.DATE )
    private Date start_date;        // 開始日時

    @Temporal( javax.persistence.TemporalType.DATE )
    private Date end_date;          // 終了日時

    @Size( max = 3 )
    private Integer discount_rate;  // 割引内容

    @Size( max = 1 )
    private char discount_flg;      // 割引フラグ

    @Size( max = 2 )
    private Integer discount_cnt;   // 割引カウンター

    @OneToMany( mappedBy = "sale_id", cascade = CascadeType.ALL )
    private List<RentalDetail> rentalDetail;
//
//    @OneToMany(mappedBy = "sale_id", cascade = CascadeType.ALL)
//    private List<TargetStore> targetStore;

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */

    public SaleInfo() {
    }


    public SaleInfo( String sale_id, String sale_name, Date start_date, Date end_date, Integer discount_rate, char discount_flg, Integer discount_cnt ) {
        this.sale_id = sale_id;
        this.sale_name = sale_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.discount_rate = discount_rate;
        this.discount_flg = discount_flg;
        this.discount_cnt = discount_cnt;
    }

    /* ゲッター、セッター */

    public String getSale_id() {
        return sale_id;
    }


    public void setSale_id( String sale_id ) {
        this.sale_id = sale_id;
    }


    public String getSale_name() {
        return sale_name;
    }


    public void setSale_name( String sale_name ) {
        this.sale_name = sale_name;
    }


    public Date getStart_date() {
        return start_date;
    }


    public void setStart_date( Date start_date ) {
        this.start_date = start_date;
    }


    public Date getEnd_date() {
        return end_date;
    }


    public void setEnd_date( Date end_date ) {
        this.end_date = end_date;
    }


    public Integer getDiscount_rate() {
        return discount_rate;
    }


    public void setDiscount_rate( Integer discount_rate ) {
        this.discount_rate = discount_rate;
    }


    public char getDiscount_flg() {
        return discount_flg;
    }


    public void setDiscount_flg( char discount_flg ) {
        this.discount_flg = discount_flg;
    }


    public Integer getDiscount_cnt() {
        return discount_cnt;
    }


    public void setDiscount_cnt( Integer discount_cnt ) {
        this.discount_cnt = discount_cnt;
    }


    public List<RentalDetail> getRentalDetail() {
        return rentalDetail;
    }


    public void setRentalDetail( List<RentalDetail> rentalDetail ) {
        this.rentalDetail = rentalDetail;
    }
//
//    public List<TargetStore> getTargetStore() {
//        return targetStore;
//    }
//
//    public void setTargetStore(List<TargetStore> targetStore) {
//        this.targetStore = targetStore;
//    }


    public boolean isEditable() {
        return editable;
    }


    public void setEditable( boolean editable ) {
        this.editable = editable;
    }

}
