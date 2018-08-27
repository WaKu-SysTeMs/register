/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author s20163060
 */
@Named
@RequestScoped
public class TestRental {
    
    private Integer num;
    private String name;
    private String kbn;
    private String saleId;
    
    public TestRental(){}

    public TestRental(Integer num, String name, String kbn, String saleId) {
        this.num = num;
        this.name = name;
        this.kbn = kbn;
        this.saleId = saleId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKbn() {
        return kbn;
    }

    public void setKbn(String kbn) {
        this.kbn = kbn;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }
    
    
    
}
