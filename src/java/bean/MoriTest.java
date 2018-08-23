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
}
