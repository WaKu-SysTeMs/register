/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.DataAddDb;
import entity.Category;
import entity.ProductInfo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class DataAddBean implements Serializable {

    @EJB
    DataAddDb db;

    @PostConstruct
    public void pCate() {
        db.createCate(new Category("J01", "洋画(ホラー、オカルト)"));
        db.createCate(new Category("J02", "洋画(SF、ファンタジー)"));
        db.createCate(new Category("J03", "洋画(アクション)"));
        db.createCate(new Category("J04", "邦画(ホラー、SF)"));
        db.createCate(new Category("J05", "邦画(アクション)"));
        db.createCate(new Category("J06", "邦画(ミステリー、恋愛)"));
        db.createCate(new Category("J07", "海外ドラマ"));
        db.createCate(new Category("J08", "国内ドラマ"));
        db.createCate(new Category("J09", "アニメ"));
        db.createCate(new Category("J10", "特撮"));
        db.createCate(new Category("J11", "ディズニー"));
        db.createCate(new Category("J12", "ジブリ"));
        db.createCate(new Category("J13", "ドキュメント"));
        db.createCate(new Category("J14", "スポーツ"));

        db.createProduct(new ProductInfo(1111111111, "苔大全", null,null, null, "佐々木 春樹", null));
    }
    


}
