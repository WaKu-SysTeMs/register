/*
 * 泊数 STAY_LIST
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author sakura＊
 */
@Entity
@Table(name = "stay_list")
public class StayList implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 1)
    private String stay_num;        // 泊数ID

    @Size(max = 4)
    private String stay_name;       // 泊数名

    @OneToMany(mappedBy = "stay_num", cascade = CascadeType.ALL)
    private List<PriceList> priceList;

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public StayList() {
    }

    public StayList(String stay_num, String stay_name) {
        this.stay_num = stay_num;
        this.stay_name = stay_name;
    }

    /* ゲッター、セッター */
    public String getStay_num() {
        return stay_num;
    }

    public void setStay_num(String stay_num) {
        this.stay_num = stay_num;
    }

    public String getStay_name() {
        return stay_name;
    }

    public void setStay_name(String stay_name) {
        this.stay_name = stay_name;
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
