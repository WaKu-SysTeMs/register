/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.DvdInfoDb;
import db.ProductInfoDb;
import entity.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class DvdBean implements Serializable {

    @Size(max = 9)
    private String dvd_num;    // DVD番号
    @Size(max = 6)
    private String product_num; //商品番号
    private String director;
    private String play_time;
    private String product_name;
    private Date rental_start_date;
    private String category_id;
    private String release_kbn;
    
    
    @Inject
    DvdInfoDb dvdInfoDb;
    @Inject
    ProductInfoDb productinfodb;
    
    List<ProductInfo> productList = new ArrayList();
    List<DvdInfo> dvdlist = new ArrayList();
    List<DvdInfo> dvdkensakulist = new ArrayList();
    List<ProductInfo> prokensakulist = new ArrayList();


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
    
    
    public void dvdkensaku(){
        dvdkensakulist = new ArrayList();
        if(!getDvd_num().equals("")){
            dvdkensakulist.add(dvdInfoDb.serchDVD(getDvd_num()));
        }else if(!getProduct_num().equals("")){
            dvdkensakulist.addAll(dvdInfoDb.kensaku(getProduct_num()));
        }
    }
    
    public void prokensaku(){
        prokensakulist = new ArrayList();
        
        if(!getProduct_num().equals("")){
            prokensakulist.add(productinfodb.serchProduct(getProduct_num()));
        }else if(!getProduct_name().equals("")){
            prokensakulist.addAll(productinfodb.prokensaku(getProduct_name()));
        }
        
    }
    
    public String kasidasijoukyou(String s){
        if(s.equals("0")){
            return "貸出可";
        }else if(s.equals("1")){
            return "貸出中";
        }else if(s.equals("2")){
            return "貸出不可";
        }else
            return "貸出保留";
    }
    
    
    
    
    
    
    public String getDvd_num() {
        return dvd_num;
    }

    public void setDvd_num(String dvd_num) {
        this.dvd_num = dvd_num;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlay_time() {
        return play_time;
    }

    public void setPlay_time(String play_time) {
        this.play_time = play_time;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Date getRental_start_date() {
        return rental_start_date;
    }

    public void setRental_start_date(Date rental_start_date) {
        this.rental_start_date = rental_start_date;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getRelease_kbn() {
        return release_kbn;
    }

    public void setRelease_kbn(String release_kbn) {
        this.release_kbn = release_kbn;
    }

    public List<ProductInfo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductInfo> productList) {
        this.productList = productList;
    }

    public List<DvdInfo> getDvdlist() {
        return dvdlist;
    }

    public void setDvdlist(List<DvdInfo> dvdlist) {
        this.dvdlist = dvdlist;
    }

    public List<DvdInfo> getDvdkensakulist() {
        return dvdkensakulist;
    }

    public void setDvdkensakulist(List<DvdInfo> dvdkensakulist) {
        this.dvdkensakulist = dvdkensakulist;
    }

    public List<ProductInfo> getProkensakulist() {
        return prokensakulist;
    }

    public void setProkensakulist(List<ProductInfo> prokensakulist) {
        this.prokensakulist = prokensakulist;
    }  
    
}
