/*
 * 返却処理用Bean
 */
package bean;

import db.*;
import entity.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.*;
import javax.validation.constraints.*;
import login.AccountManager;

@Named
@ConversationScoped
public class ReturnBean implements Serializable {

    Integer cnt = 0;            // カウントアップ用

    @Size(max = 9)
    private String member_num;           // 会員番号

    @Size(max = 30)
    private String member_name;     // 会員名

    @Size(max = 9)
    private String dvd_num;    // DVD番号

    @Size(max = 100)
    private String product_name;    // 作品名

    List<Integer> entaikin = new ArrayList();
    List<ProductInfo> productList = new ArrayList();
    List<DvdInfo> dvdList = new ArrayList();
    List<RentalDetail> DetailList = new ArrayList<>();
    List<RentalInfo> rentalInfo = new ArrayList<>();

    @Inject
    transient Logger log;

    @Inject
    Conversation conv;

    @Inject
    AccountManager AM;
    
    @Inject
    MemberDb memberDb;

    @Inject
    DvdInfoDb dvdInfoDb;

    @Inject
    RentalInfoDb rentalInfoDb;

    @Inject
    RentalDetailDb rentalDetailDb;

    /**
     * 返却処理
     *
     * @return 返却処理へ
     */
    public String update() {
        if (conv.isTransient()) {
            conv.begin();
            log.info(log.getName() + " | 返却処理開始 ****");
        } else {
            log.info(log.getName() + " | 貸出会話スコープ ****");
        }
        return "/pages/return/update.xhtml?faces-redirect=true";
    }

    /**
     *
     * @return 延滞金精算画面
     */
    public String update_1() {
        return "update_delay.xhtml?faces-redirect=true";
    }

    /**
     *
     * @return 次へ
     */
    public String update_2() {
        return "update_pay_off_miss.xhtml?faces-redirect=true";
    }

    public void searchProduct() {
        try {
            DvdInfo dvdInfo = (DvdInfo) this.dvdInfoDb.search(this.dvd_num);
            if (dvdInfo != null) {
                productList.add(dvdInfo.getProduct_num());
                dvdList.add(dvdInfo);
                
                System.out.print(dvdList + "**********************!");
            }
        } catch (Exception e) {
            log.info(dvd_num + "が見つかりません");
        }
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getMember_num() {
        return member_num;
    }

    public void setMember_num(String member_num) {
        this.member_num = member_num;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
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

    public List<ProductInfo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductInfo> productList) {
        this.productList = productList;
    }

    public List<DvdInfo> getDvdList() {
        return dvdList;
    }

    public void setDvdList(List<DvdInfo> dvdList) {
        this.dvdList = dvdList;
    }

    public List<RentalDetail> getDetailList() {
        return DetailList;
    }

    public void setrDetailList(List<RentalDetail> DetailList) {
        this.DetailList = DetailList;
    }

}
