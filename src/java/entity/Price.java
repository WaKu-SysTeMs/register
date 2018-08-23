///*
// * 料金 PRICE_LIST
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Objects;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author s20163037
// */
//@Embeddable
//@Table(name = "price_list")
//public class Price implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @EmbeddedId
//    private PricePK price_id;               // 複合キー
//
//    @Size(max = 3)
//    private Integer price;                  // 料金
//
//    @OneToMany(mappedBy = "stay_num", cascade = CascadeType.ALL)
//    private List<RentalDetail> rentalDetail;
//    
//  
//    private StayList staylist;
//
//    @Transient                           // シリアライズしない
//    private boolean editable;
//
//    /* コンストラクタ */
//    public Price() {
//    }
//
//    public Price(PricePK price_id, Integer price) {
//        this.price_id = price_id;
//        this.price = price;
//    }
//
//
//    
//    
//    public PricePK getPrice_id() {
//        return price_id;
//    }
//
//    /* ゲッター、セッター */
//    public void setPrice_id(PricePK price_id) {
//        this.price_id = price_id;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public List<RentalDetail> getRentalDetail() {
//        return rentalDetail;
//    }
//
//    public void setRentalDetail(List<RentalDetail> rentalDetail) {
//        this.rentalDetail = rentalDetail;
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
//
//@Embeddable
//class PricePK implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @NotNull
//    @Size(max = 1)
//    private String release_kbn;        // 新旧区分
//
//    @NotNull
//    @Size(max = 1)
//    private String stay_num;              // 泊数ID
//
//    /* コンストラクタ */
//    public PricePK() {
//    }
//
//    public PricePK(String release_kbn, String stay_num) {
//        this.release_kbn = release_kbn;
//        this.stay_num = stay_num;
//    }
//
//    /* hash、equals */
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 89 * hash + Objects.hashCode(this.release_kbn);
//        hash = 89 * hash + Objects.hashCode(this.stay_num);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final PricePK other = (PricePK) obj;
//        if (!Objects.equals(this.release_kbn, other.release_kbn)) {
//            return false;
//        }
//        if (!Objects.equals(this.stay_num, other.stay_num)) {
//            return false;
//        }
//        return true;
//    }
//
//    /* ゲッター、セッター */
//    public String getRelease_kbn() {
//        return release_kbn;
//    }
//
//    public void setRelease_kbn(String release_kbn) {
//        this.release_kbn = release_kbn;
//    }
//
//    public String getStay_num() {
//        return stay_num;
//    }
//
//    public void setStay_num(String stay_num) {
//        this.stay_num = stay_num;
//    }
//
//}
//
