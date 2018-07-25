/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163037
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L; // シリアライズ

    @Id
    @Size(max = 3) @Column(name = "category_id")
    private String categoryId;         // ジャンルID

    @Size(max = 20) @Column(name = "category_name")
    private String categoryName;       // ジャンル名
    
    @OneToMany(mappedBy = "favCategory", cascade = CascadeType.ALL)
    private List<Member> member;

    /* コンストラクタ */
    public Category() {
    }

    public Category(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    
    /* セッター、ゲッター */
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }


}
