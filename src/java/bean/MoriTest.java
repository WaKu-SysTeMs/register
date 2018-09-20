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
    private Integer test2;
    
    private SelectItem[] langs2 = {
        new SelectItem(1,"会社員・公務員"),
        new SelectItem(2,"派遣・アルバイト"),
        new SelectItem(3,"自営業"),
        new SelectItem(4,"専業主婦"),
        new SelectItem(5,"学生"),
        new SelectItem(9,"その他")
    };
    
    private Integer test6;
    private SelectItem[] langs6 = {
        new SelectItem(1,"すべて"),
        new SelectItem(2,"菊水店"),
        new SelectItem(3,"白石店")
    };
    
    private Integer sex;
     private SelectItem[] langs1 = {
        new SelectItem(1,"男"),
        new SelectItem(0,"女")
    };
    
    public MoriTest() {
    }

    public MoriTest(Integer test) {
        this.test = test;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public SelectItem[] getLangs1() {
        return langs1;
    }

    public void setLangs1(SelectItem[] langs1) {
        this.langs1 = langs1;
    }

    
}
