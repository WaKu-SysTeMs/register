/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.model.SelectItem;



/**
 *
 * @author s20163043
 */
@Named
@RequestScoped
public class CategoryBean {
     private Integer category;
     
     private SelectItem[] categoryID = {
        new SelectItem(1,"アクション"),
        new SelectItem(2,"サスペンス"),
        new SelectItem(3,"恋愛"),
        new SelectItem(4,"SF"),
        new SelectItem(5,"ドラマ"),
        new SelectItem(6,"洋画")
    };
     
     public CategoryBean() {
    }

    public CategoryBean(Integer category) {
        this.category = category;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public SelectItem[] getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(SelectItem[] categoryID) {
        this.categoryID = categoryID;
    }
    
    
}
