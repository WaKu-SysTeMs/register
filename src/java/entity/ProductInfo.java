///*
// * PRODUCT_INFO
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
///**
// *
// * @author sakura＊
// */
//@Entity
//@Table(name = "product_info")
//@SecondaryTables({
//    @SecondaryTable(name = "category"),
//    @SecondaryTable(name = "release_list")
//})
//public class ProductInfo implements Serializable {
//
//    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
//
//    @Id
//    @Size(max = 13)
//    private Integer product_num;    // 商品番号
//
//    @Size(max = 100)
//    private String product_name;    // 作品名
//
//    @NotNull
//    @Size(max = 3)
//    @JoinColumn(table = "category")
//    private Category category_id;   // ジャンルID(FK)
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date rental_start_date; // 貸出開始年月日
//
//    @Size(max = 3)
//    private String play_time;       // 再生時間
//
//    @Size(max = 30)
//    private String director;        // 監督
//
//    @NotNull
//    @Size(max = 1)
//    @JoinColumn(table = "release_list")
//    private ReleaseList release_kbn;    // 新旧区分
//
//    @OneToMany(mappedBy = "product_num", cascade = CascadeType.ALL)
//    private List<DvdInfo> dvdInfo;
////
////    @OneToMany(mappedBy = "stock_id", cascade = CascadeType.ALL)
////    private List<Stock> stock;
//
//    @Transient
//    private boolean editable;           // シリアライズしない
//
//    /* コンストラクタ */
//    public ProductInfo() {
//    }
//
//    public ProductInfo(Integer product_num, String product_name, Category category_id, Date rental_start_date, String play_time, String director, ReleaseList release_kbn) {
//        this.product_num = product_num;
//        this.product_name = product_name;
//        this.category_id = category_id;
//        this.rental_start_date = rental_start_date;
//        this.play_time = play_time;
//        this.director = director;
//        this.release_kbn = release_kbn;
//    }
//
//    /* ゲッター、セッター */
//    public Integer getProduct_num() {
//        return product_num;
//    }
//
//    public void setProduct_num(Integer product_num) {
//        this.product_num = product_num;
//    }
//
//    public String getProduct_name() {
//        return product_name;
//    }
//
//    public void setProduct_name(String product_name) {
//        this.product_name = product_name;
//    }
//
//    public Category getCategory_id() {
//        return category_id;
//    }
//
//    public void setCategory_id(Category category_id) {
//        this.category_id = category_id;
//    }
//
//    public Date getRental_start_date() {
//        return rental_start_date;
//    }
//
//    public void setRental_start_date(Date rental_start_date) {
//        this.rental_start_date = rental_start_date;
//    }
//
//    public String getPlay_time() {
//        return play_time;
//    }
//
//    public void setPlay_time(String play_time) {
//        this.play_time = play_time;
//    }
//
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public ReleaseList getRelease_kbn() {
//        return release_kbn;
//    }
//
//    public void setRelease_kbn(ReleaseList release_kbn) {
//        this.release_kbn = release_kbn;
//    }
//
//    public List<DvdInfo> getDvdInfo() {
//        return dvdInfo;
//    }
//
//    public void setDvdInfo(List<DvdInfo> dvdInfo) {
//        this.dvdInfo = dvdInfo;
//    }
//
////    public List<Stock> getStock() {
////        return stock;
////    }
////
////    public void setStock(List<Stock> stock) {
////        this.stock = stock;
////    }
////    
//    
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
