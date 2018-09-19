/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.DvdInfoDb;
import entity.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163037
 */
public class DvdBean implements Serializable {

    @Size(max = 9)
    private String dvd_num;    // DVD番号
    @Inject
    DvdInfoDb dvdInfoDb;
    
    List<ProductInfo> productList = new ArrayList();
    List<DvdInfo> dvdlist = new ArrayList();


    /**
     * DVD情報取得
     */
    public void searchProduct() { //
        DvdInfo dvdinfo = (DvdInfo) this.dvdInfoDb.search(this.dvd_num);
        if (dvdinfo != null) {
            productList.add(dvdinfo.getProduct_num());
            dvdlist.add(dvdinfo);
        } else {
            System.out.println("aaaa");
        }
        dvd_num = null;
    }
}
