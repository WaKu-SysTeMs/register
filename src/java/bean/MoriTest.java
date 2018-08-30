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
public class MoriTest {

    private Integer test;

    private SelectItem[] langs = {
        new SelectItem(1,"男"),
        new SelectItem(2, "女"),
        new SelectItem(3, "すべて")
    };
    
    
    private Integer test2;
    private SelectItem[] langs2 = {
        new SelectItem(1,"会社員・公務員"),
        new SelectItem(2,"派遣・アルバイト"),
        new SelectItem(3,"自営業"),
        new SelectItem(4,"専業主婦"),
        new SelectItem(5,"学生"),
        new SelectItem(6,"その他")
    };
    
    private Integer test3;
    private SelectItem[] langs3 = {
        new SelectItem(1,"ブラック会員である"),
        new SelectItem(2,"ブラック会員でない"),
        new SelectItem(3,"すべて")
    };
    
    private Integer test4;
    private SelectItem[] langs4 = {
        new SelectItem(1,"退会済み"),
        new SelectItem(2,"退会していない"),
        new SelectItem(3,"すべて")
    };
    
    private Integer test5;
    private SelectItem[] langs5 = {
        new SelectItem(1,"会員"),
        new SelectItem(2,"仮入会"),
        new SelectItem(3,"すべて")
    };
    
    private Integer test6;
    private SelectItem[] langs6 = {
        new SelectItem(1,"店舗１"),
        new SelectItem(2,"店舗２"),
        new SelectItem(3,"すべて")
    };
    
    public MoriTest() {
    }

    public MoriTest(Integer test) {
        this.test = test;
    }

    public SelectItem[] getLangs() {
        return langs;
    }

    public void setLangs(SelectItem[] langs) {
        this.langs = langs;
    }


    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

    public SelectItem[] getLangs2() {
        return langs2;
    }

    public void setLangs2(SelectItem[] langs2) {
        this.langs2 = langs2;
    }

    public Integer getTest3() {
        return test3;
    }

    public void setTest3(Integer test3) {
        this.test3 = test3;
    }

    public SelectItem[] getLangs3() {
        return langs3;
    }

    public void setLangs3(SelectItem[] langs3) {
        this.langs3 = langs3;
    }

    public Integer getTest4() {
        return test4;
    }

    public void setTest4(Integer test4) {
        this.test4 = test4;
    }

    public SelectItem[] getLangs4() {
        return langs4;
    }

    public void setLangs4(SelectItem[] langs4) {
        this.langs4 = langs4;
    }

    public Integer getTest5() {
        return test5;
    }

    public void setTest5(Integer test5) {
        this.test5 = test5;
    }

    public SelectItem[] getLangs5() {
        return langs5;
    }

    public void setLangs5(SelectItem[] langs5) {
        this.langs5 = langs5;
    }

    public Integer getTest6() {
        return test6;
    }

    public void setTest6(Integer test6) {
        this.test6 = test6;
    }

    public SelectItem[] getLangs6() {
        return langs6;
    }

    public void setLangs6(SelectItem[] langs6) {
        this.langs6 = langs6;
    }
    
    
}
