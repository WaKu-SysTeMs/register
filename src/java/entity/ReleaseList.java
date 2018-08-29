/*
 * 新旧区分 RELEASE_LIST
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author sakura＊
 */
@Entity
@Table(name = "release_list")
public class ReleaseList implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 1)
    @Column(length = 1)
    private String release_kbn;         // 新旧区分

    @Size(max = 6)
    @Column(length = 6)
    private String release_name;         // 区分名

    @OneToMany(mappedBy = "release_kbn", cascade = CascadeType.ALL)
    private List<ProductInfo> productInfo;

    @OneToMany(mappedBy = "release_kbn", cascade = CascadeType.ALL)
    private List<PriceList> priceList;

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public ReleaseList() {
    }

    public ReleaseList(String release_kbn, String release_name) {
        this.release_kbn = release_kbn;
        this.release_name = release_name;
    }

    /* ゲッター、セッター */
    public String getRelease_kbn() {
        return release_kbn;
    }

    public void setRelease_kbn(String release_kbn) {
        this.release_kbn = release_kbn;
    }

    public String getRelease_name() {
        return release_name;
    }

    public void setRelease_name(String release_name) {
        this.release_name = release_name;
    }

    public List<ProductInfo> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<ProductInfo> productInfo) {
        this.productInfo = productInfo;
    }

    public List<PriceList> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceList> priceList) {
        this.priceList = priceList;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
