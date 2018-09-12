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

    @Size(max = 1)
    protected String release_kbn;         // 新旧区分
    protected Map<String, String> releaseItems;   // 新旧区分の選択肢
//    {
    //        test = new ArrayList<>();x=1;
    //        test.add(new TestRental(x++,"究極の苺","旧作","01"));
    //        test.add(new TestRental(x++,"おいしいサンセバスチャンケーキのつくりかた","新作","-"));
    //    }
    @EJB
    RentalInfoDb rentalDb;

    @EJB
    MemberDb memberDb;

    @Inject
    transient Logger log;

    @Inject
    Conversation conv;

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
        if (!conv.isTransient()) {
            conv.begin();
            log.info(log.getName() + " | 貸出会話スコープ開始 ****");
        } else {
            log.info(log.getName() + " | 貸出会話スコープ ****");
        }
        return "/pages/rental/create.xhtml";
    }

    /**
     * 商品の精算
     *
     * @return 精算画面に遷移
     */
    public String create_2() {
        return "create_payment.xhtml?faces-redirect=true";
    }

    public String search() {                                // 会員名　取得
        this.member_name = null;
        Member m = (Member) memberDb.search(this.member_num);
        if (m != null) {
            this.member_name = m.getMember_name();
        }
        return null;
    }

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

    public Map<String, String> getReleaseItems() {
        return releaseItems;
    }

    public void setReleaseItems(Map<String, String> releaseItems) {
        this.releaseItems = releaseItems;
    }



}
