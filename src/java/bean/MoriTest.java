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
        new SelectItem(2, "女")
    };
    
    
    private Integer test2;
    private SelectItem[] langs2 = {
        new SelectItem(1,"会社員・公務員"),
        new SelectItem(2,"派遣・アルバイト"),
        new SelectItem(3,"自営業"),
        new SelectItem(4,"専業主婦"),
        new SelectItem(5,"学生"),
        new SelectItem(6,"その他"),
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
    
    
}
