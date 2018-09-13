/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.*;
import entity.*;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.*;
import javax.enterprise.context.*;
import javax.validation.constraints.Size;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author s20163037
 */
@Named
@ConversationScoped
public class RentalBean implements Serializable {
    private Integer cnt = 1;
    @Size(max = 30)
    private String member_name;     // 会員名
    @Size(max = 9)
    private String member_num;           // 会員番号(FK)
    @Size(max = 9)
    private String dvd_num;    // DVD番号
    @Size(max = 100)
    private String product_name;    // 作品名
    private boolean sale;
    private String product_num;
    @Size(max = 1)
    protected String release_kbn;         // 新旧区分
    protected Map<String, String> releaseItems;   // 新旧区分の選択肢
    @Size(max = 6)
    private String release_name;         // 区分名

    @Inject
    RentalInfoDb rentalDb;
    @Inject
    MemberDb memberDb;
    @Inject
    ProductInfoDb productDb;
    @Inject
    DvdInfoDb dvdinfodb;
    @Inject
    transient Logger log;
    @Inject
    Conversation conv;

    List<ProductInfo> productList = new ArrayList<ProductInfo>();
    
    
    
    
    /* *****【初期化】 ************************************* */
    {
        releaseItems = new LinkedHashMap<>();
        releaseItems.put("当日", "1");
        releaseItems.put("1泊2日", "2");
        releaseItems.put("2泊3日", "3");
        releaseItems.put("7泊8日", "4");
    }

    /**
     * 貸出処理(会員検索、商品検索)
     *
     * @return 貸出画面へ
     */
    public String create() {
        if (conv.isTransient()) {
            conv.begin();
            log.info(log.getName() + " | 貸出会話スコープ開始 ****");
        } else {
            log.info(log.getName() + " | 貸出会話スコープ ****");
        }
        return "/pages/rental/create.xhtml?faces-redirect=true";
    }

    /**
     * 商品の精算
     *
     * @return 精算画面に遷移
     */
    public String create_2() {
        return "create_payment.xhtml?faces-redirect=true";
    }

    /**
     *  会員名　取得
     * @return 
     */

    public String search() {
        this.member_name = "";
        Member m = (Member) memberDb.search(this.member_num);
        if (m != null) {
            this.member_name = m.getMember_name();
        }
        return null;
    }
    /**
     *  DVD情報取得 
     * @return 
     */
    public void serchProduct(){ //
        DvdInfo dvdinfo = (DvdInfo)this.dvdinfodb.search(this.dvd_num);
        if(dvdinfo!=null){
            productList.add(dvdinfo.getProduct_num());
        }else{
            System.out.println("aaaa");
        }
    }

    /**
     *  商品情報取得 
     * @return 
     */
//    public String searchProduct() {
//        ProductInfo p = (ProductInfo) productDb.search(this.product_num);
//        if (p != null) {
//            this.product_name = p.getProduct_name();
//        }
//        return null;
//    }

    /* ゲッター、セッター */
    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_num() {
        return member_num;
    }

    public void setMember_num(String member_num) {
        this.member_num = member_num;
    }

    public String getRelease_kbn() {
        return release_kbn;
    }

    public void setRelease_kbn(String release_kbn) {
        this.release_kbn = release_kbn;
    }

    public String getDvd_num() {
        return dvd_num;
    }

    public void setDvd_num(String dvd_num) {
        this.dvd_num = dvd_num;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getRelease_name() {
        return release_name;
    }

    public void setRelease_name(String release_name) {
        this.release_name = release_name;
    }

    
    
    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public Map<String, String> getReleaseItems() {
        return releaseItems;
    }

    public void setReleaseItems(Map<String, String> releaseItems) {
        this.releaseItems = releaseItems;
    }

    public List<ProductInfo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductInfo> productList) {
        this.productList = productList;
    }
    
    

}
