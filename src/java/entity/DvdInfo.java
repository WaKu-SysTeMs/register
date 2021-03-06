/*
 * DVD情報 DVD_INFO
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
//@NamedQueries({
//    @NamedQuery(name = DvdInfo.Qall, query = "SELECT e FROM DVD_INFO e")
//})
@Entity
@Table(name = "dvd_info")
@NamedQueries({
    @NamedQuery(name = DvdInfo.DvdInfoQAll, query = "SELECT r FROM DvdInfo r"),
    @NamedQuery(name = DvdInfo.DvdInfoQReturnSearch, query = "SELECT di.dvd_num, di.product_num, rd.rental_num, rd.return_plan, ri.rental_date FROM DvdInfo di "
            + "JOIN RentalDetail rd ON di.dvd_num = rd.dvd_num "
            + "JOIN RentalInfo ri ON rd.rental_num = ri.rental_num "
            + "WHERE di.dvd_num = ?1")
})
public class DvdInfo implements Serializable {
    
    public static final String DvdInfoQAll = "DvdInfoQAll";
    public static final String DvdInfoQReturnSearch = "DvdInfoQReturnSearch";

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 9)
    @Column(length = 9)
    private String dvd_num;            // DVD番号

    @NotNull
    @Size(max = 6)
    @JoinColumn(name = "product_num")
    private ProductInfo product_num;    // 商品番号(FK)

    @NotNull
    @Size(max = 3)
    @JoinColumn(name = "store_id")
    private StoreInfo store_id;          // 店舗ID(FK)

    @Size(max = 1)                          // もしくは@patternで
    private char rental_status; // 貸出状況

    @OneToMany(mappedBy = "dvd_num", cascade = CascadeType.ALL)
    private List<RentalDetail> rental_detail;

    @OneToMany(mappedBy = "dvd_num", cascade = CascadeType.ALL)
    private List<MoveDetail> move_detail;

    @Transient                           // シリアライズしない
    private boolean editable;
    
    @Transient
    private String rental_num;

    /* コンストラクタ */
    public DvdInfo() {
    }

    public DvdInfo(String dvd_num, ProductInfo product_num, StoreInfo store_id, char rental_status) {
        this.dvd_num = dvd_num;
        this.product_num = product_num;
        this.store_id = store_id;
        this.rental_status = rental_status;
    }

    /* ゲッター、セッター */
    public String getDvd_num() {
        return dvd_num;
    }

    public void setDvd_num(String dvd_num) {
        this.dvd_num = dvd_num;
    }

    public ProductInfo getProduct_num() {
        return product_num;
    }

    public void setProduct_num(ProductInfo product_num) {
        this.product_num = product_num;
    }

    public StoreInfo getStore_id() {
        return store_id;
    }

    public void setStore_id(StoreInfo store_id) {
        this.store_id = store_id;
    }

    public char getRental_status() {
        return rental_status;
    }

    public void setRental_status(char rental_status) {
        this.rental_status = rental_status;
    }

    public List<RentalDetail> getRental_detail() {
        return rental_detail;
    }

    public void setRental_detail(List<RentalDetail> rental_detail) {
        this.rental_detail = rental_detail;
    }

    public List<MoveDetail> getMove_detail() {
        return move_detail;
    }

    public void setMove_detail(List<MoveDetail> move_detail) {
        this.move_detail = move_detail;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getRental_num() {
        return rental_num;
    }

    public void setRental_num(String rental_num) {
        this.rental_num = rental_num;
    }
    

}
