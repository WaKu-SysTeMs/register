/*
 * 返却処理用Bean
 */
package bean;

import db.*;
import entity.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    private String dvd_num;    // DVD番号

    private String rental_num;          // 貸出番号

    @Size(max = 9)
    private String member_num;           // 会員番号

    @Size(max = 30)
    private String member_name;     // 会員名

    @Size(max = 100)
    private String product_name;    // 作品名

    private Date rental_date;            // 貸出年月日

    private Date return_plan;           //返却予定日

    @Size(max = 9)
    private Integer delay;                 // 延滞料金

    List<Integer> entaikin = new ArrayList();
    List<ProductInfo> productList = new ArrayList();        // 商品情報List
    List<DvdInfo> dvdList = new ArrayList();                // DVD情報List
    List<Member> memberList = new ArrayList<>();              // 会員情報List
    List<RentalDetail> detailList = new ArrayList<>();      // 貸出明細List
    List<RentalInfo> rentalList = new ArrayList<>();        // 貸出情報List
    List<DelayList> delayList = new ArrayList<>();          // 延滞料金List

    @Inject
    transient Logger log;

    @Inject
    Conversation conv;

    @Inject
    AccountManager AM;

    @Inject
    RentalDetailDb rentalDetailDb;

    @Inject
    RentalDb rentalDb;

    @Inject
    MemberDb memberDb;

    @Inject
    DvdInfoDb dvdInfoDb;

    @Inject
    RentalInfoDb rentalInfoDb;

    @Inject
    DelayListDb delayListDb;

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

    /**
     * DVD情報、貸出情報、貸出明細、延滞情報の取得
     */
    public void searchProduct() {
        try {

            RentalDetail rentalDetail = (RentalDetail) this.rentalDetailDb.dvdReturnMax(this.dvd_num);    // 返却予定日が最新の貸出明細情報を取得
            DvdInfo dvdInfo = (DvdInfo) this.dvdInfoDb.search(this.dvd_num);                              // dvd番号からDVD情報を取得

            if (rentalDetail != null) {
                RentalInfo rentalInfo = (RentalInfo) this.rentalInfoDb.search(rentalDetail.getRental_num().getRental_num());    // 貸出番号から貸出情報取得
                detailList.add(rentalDetail);
                rentalList.add(rentalDetail.getRental_num());

                if (rentalInfo != null) {

//                    if (this.member_name != rentalInfo.getMember_num().getMember_name()) {
//
//                    } else {
                    this.member_name = rentalInfo.getMember_num().getMember_name();

                    DelayList delayL = (DelayList) this.delayListDb.searchDelay(rentalInfo.getMember_num().getMember_num());    // 会員番号から延滞情報取得

                    if (delayL == null) {           // 延滞情報がnullなら0
                        this.delay = 0;
                    } else {
                        this.delay = delayL.getDelay();// nullでないなら延滞金を格納
                    }

                    if (dvdInfo != null) {
                        productList.add(dvdInfo.getProduct_num());
                        dvdList.add(dvdInfo);
                    }
                }
            }

        } catch (Exception e) {
            log.info("** " + this.dvd_num + " が見つかりません *****");
        }
    }

    /**
     * 貸出枚数のカウントアップ
     *
     * @return
     */
    public Integer cntUp() {
        return ++this.cnt;
    }

    /**
     * 返却情報を1件削除
     *
     * @param item
     */
    public void clear(RentalDetail item) {
        detailList.remove(item);
        this.delay = null;
    }

    /* ゲッター、セッター */
    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getDvd_num() {
        return dvd_num;
    }

    public void setDvd_num(String dvd_num) {
        this.dvd_num = dvd_num;
    }

    public String getRental_num() {
        return rental_num;
    }

    public void setRental_num(String rental_num) {
        this.rental_num = rental_num;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public Date getReturn_plan() {
        return return_plan;
    }

    public void setReturn_plan(Date return_plan) {
        this.return_plan = return_plan;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
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

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<RentalDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<RentalDetail> detailList) {
        this.detailList = detailList;
    }

    public List<RentalInfo> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<RentalInfo> rentalList) {
        this.rentalList = rentalList;
    }

    public List<DelayList> getDelayList() {
        return delayList;
    }

    public void setDelayList(List<DelayList> delayList) {
        this.delayList = delayList;
    }

}
