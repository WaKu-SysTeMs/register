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
public class Test3 {
    
    String flg;

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg;
    }
    
    
}
