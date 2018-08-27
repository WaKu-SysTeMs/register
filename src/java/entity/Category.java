/*
 * ジャンル CATEGORY
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
//    @NamedQuery(name = Category.CategoryQAll, query = "SELECT e FROM Category e"),
//    @NamedQuery(name =Category.CategoryQName, query = "SELECT e.category_id FROM Category e WHERE e. = ?1")
//})
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @NotNull
    @Size(max = 3)
    private String category_id;         // ジャンルID

    @Size(max = 20)
    private String category_name;       // ジャンル名

    @OneToMany(mappedBy = "fav_category", cascade = CascadeType.ALL)
    private List<Member> member;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
    private List<ProductInfo> productInfo;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
    private List<TargetCategory> targetCategory;

    @Transient                  // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Category() {
    }

    public Category(String category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    /* セッター、ゲッター */
    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    public List<ProductInfo> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<ProductInfo> productInfo) {
        this.productInfo = productInfo;
    }

    public List<TargetCategory> getTargetCategory() {
        return targetCategory;
    }

    public void setTargetCategory(List<TargetCategory> targetCategory) {
        this.targetCategory = targetCategory;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    

}
