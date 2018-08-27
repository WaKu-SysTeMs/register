/*
 * 料金 PRICE_LIST
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author s20163037
 */
@Entity
@Table(name = "price_list")
@IdClass(value = PriceListPK.class)
public class PriceList implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 1)
    @JoinColumn(name = "release_kbn")
    private ReleaseList release_kbn;           // 新旧区分(FK)

    @Id
    @Size(max = 1)
    @JoinColumn(name = "stay_num")
    private StayList stay_num;                 // 泊数ID(FK)

    @Size(max = 3)
    private Integer price;                     // 料金

    @OneToMany(mappedBy = "release_kbn", cascade = CascadeType.ALL)
    private List<RentalDetail> rentalDetail;

    @Transient                           // シリアライズしない
    private boolean editable;

    
    /* コンストラクタ */
    public PriceList() {
    }

    public PriceList(ReleaseList release_kbn, StayList stay_num, Integer price) {
        this.release_kbn = release_kbn;
        this.stay_num = stay_num;
        this.price = price;
    }


    /* ゲッター、セッター */
    public ReleaseList getRelease_kbn() {
        return release_kbn;
    }

    public void setRelease_kbn(ReleaseList release_kbn) {
        this.release_kbn = release_kbn;
    }

    public StayList getStay_num() {
        return stay_num;
    }

    public void setStay_num(StayList stay_num) {
        this.stay_num = stay_num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<RentalDetail> getRentalDetail() {
        return rentalDetail;
    }

    public void setRentalDetail(List<RentalDetail> rentalDetail) {
        this.rentalDetail = rentalDetail;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
