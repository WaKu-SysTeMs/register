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
import javax.inject.*;
import javax.enterprise.context.*;
import javax.validation.constraints.Size;
import login.AccountManager;

/**
 *
 * @author s20163037
 */
@Named
@ConversationScoped
public class RentalBean implements Serializable {

    private Integer cnt = 0;
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

    private int goukei; //合計金額
    private int waribikicnt = 0; //割引数計
    private int seikyuu; //請求金額
    private int wk;
    private String wks;
    private String wks2;
    private String kubun;
    private Integer siharaigaku;
    private int oturi;
    private String rental_status;
    private Integer kasidasijougen;

    @Inject
    RentalInfoDb rentalDb;
    @Inject
    MemberDb memberDb;
    @Inject
    ProductInfoDb productDb;
    @Inject
    DvdInfoDb dvdinfodb;
    @Inject
    RentalInfoDb rentalinfodb;
    @Inject
    RentalDetailDb rentaldetaildb;
    @Inject
    transient Logger log;
    @Inject
    Conversation conv;
    @Inject
    AccountManager AM;
    @Inject
    RentalMaxDb rentalmaxdb;

    List<ProductInfo> productList = new ArrayList();
    List<DvdInfo> dvdlist = new ArrayList();
    List<Boolean> waribikilist = new ArrayList();
    List<String> kingakulist = new ArrayList();
    Date kasidasihizuke = new Date();


    /* *****【初期化】 ************************************* */
    {
        releaseItems = new LinkedHashMap<>();
        releaseItems.put("当日", "0");
        releaseItems.put("1泊2日", "1");
        releaseItems.put("2泊3日", "2");
        releaseItems.put("7泊8日", "7");
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
        if (this.kasidasijougen < this.dvdlist.size()) {
            return null;
        }
        this.waribikicnt = 0;
        this.waribikikeisan();
        return "/pages/rental/create_payment.xhtml?faces-redirect=true";
    }

    public String create_1() {
        this.waribikilist = new ArrayList();
        this.kingakulist = new ArrayList();
        return "/pages/rental/create.xhtml?faces-redirect=true";
    }

    public String list() {
        return "/pages/rental/list.xhtml?faces-redirect=true";
    }

    public String update() {
        return "/pages/rental/update.xhtml?faces-redirect=true";
    }

    /**
     * 会員名　取得
     *
     * @return
     */
    public String search() {
        try {
            this.member_name = "";
            Member m = (Member) memberDb.search(this.member_num);
            if (m != null) {
                this.member_name = m.getMember_name();
            }
        } catch (Exception e) {
            e.getMessage();
        }

        this.kasidasijougen = 0;
        RentalMax rm = (RentalMax) rentalmaxdb.syutoku(this.member_num);
        if (rm != null) {
            this.kasidasijougen = rm.getBorrowing_cnt();
        }
        return null;
    }

    /**
     * DVD情報取得
     */
    public void searchProduct() { //
        DvdInfo dvdinfo = (DvdInfo) this.dvdinfodb.search(this.dvd_num);
        if (dvdinfo != null) {
            productList.add(dvdinfo.getProduct_num());
            dvdlist.add(dvdinfo);

        } else {
            System.out.println("aaaa");
        }
        dvd_num = null;
    }

    //リスト中身1行削除
    public void listDelete(DvdInfo item) {
        dvdlist.remove(item);
    }

    public void waribikikeisan() {
        for (boolean bool : waribikilist) {
            if (bool) {
                this.waribikicnt++;
            }
        }
    }

    public void jougengenzan() {
        rentalmaxdb.genzan(this.member_num, this.dvdlist.size(), this.kasidasijougen);
        productList = new ArrayList();
        dvdlist = new ArrayList();
        waribikilist = new ArrayList();
        kingakulist = new ArrayList();
        kasidasihizuke = new Date();
        member_num = null;
        member_name = null;
        kasidasijougen = null;
    }

    //Rental_Infoに登録(DB)
    public void infotouroku() {
        this.rentalinfodb.insert(this.seikyuu, AM.getUser(), this.member_num, AM.getPassword());
    }

    //Rental_Detailに登録(DB)   DVDループで回して要素取得 Detaildbにinsert
    public void detailtouroku() {
        DvdInfo dvdinfo;
        boolean b;
        int ii;
        String haku;
        Integer hakusuu;
        for (int i = 0; i < dvdlist.size(); i++) {
            dvdinfo = dvdlist.get(i);
            b = waribikilist.get(i);
            haku = kingakulist.get(i);
            hakusuu = Integer.parseInt(haku);
            ii = i + 1;
            rentaldetaildb.insert(ii, b, seikyuu, kasidasihizuke, hakusuu, dvdinfo.getDvd_num(), dvdinfo.getProduct_num().getRelease_kbn().getRelease_kbn(), haku);
        }
    }

    public void dvdupdate() {
        for (DvdInfo d : dvdlist) {
            dvdinfodb.statusupdte(d.getDvd_num());
        }
    }

    public Integer cntup() {
        return ++cnt;
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
        this.waribikilist.add(sale);
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

    public int getGoukei() {
        goukei = 0;
        for (String wklist : kingakulist) {
            this.wks = wklist;
            if (wks.equals("0")) {
                this.goukei += 200;
            } else if (wks.equals("1")) {
                this.goukei += 260;
            } else if (wks.equals("2")) {
                this.goukei += 300;
            } else if (wks.equals("7")) {
                this.goukei += 160;
            }
        }
        return goukei;
    }

    public void setGoukei(int goukei) {
        this.goukei = goukei;
    }

    public int getWaribikicnt() {
        return waribikicnt;
    }

    public void setWaribikicnt(int waribikicnt) {
        this.waribikicnt = waribikicnt;
    }

    public int getSeikyuu() {
        seikyuu = goukei - waribikicnt * 50;
        return seikyuu;
    }

    public void setSeikyuu(int seikyuu) {
        this.seikyuu = seikyuu;
    }

    public List<DvdInfo> getDvdlist() {
        cnt = 0;
        return dvdlist;
    }

    public void setDvdlist(List<DvdInfo> dvdlist) {
        this.dvdlist = dvdlist;
    }

    public List<Boolean> getWaribikilist() {
        return waribikilist;
    }

    public List<String> getKingakulist() {
        return kingakulist;
    }

    public void setKingakulist(List<String> kingakulist) {
        this.kingakulist = kingakulist;
    }

    public int getWk() {
        return wk;
    }

    public void setWk(int wk) {
        this.wk = wk;
    }

    public String getWks() {
        return wks;
    }

    public void setWks(String wks) {
        this.wks = wks;
    }

    public String getWks2() {
        return wks2;
    }

    public void setWks2(String wks2) {
        this.wks2 = wks2;
    }

    public String getKubun() {
        return kubun;
    }

    public void setKubun(String kubun) {
        this.kingakulist.add(kubun);
    }

    public Integer getSiharaigaku() {
        return siharaigaku;
    }

    public void setSiharaigaku(Integer siharaigaku) {
        this.siharaigaku = siharaigaku;
    }

    public int getOturi() {
        oturi = 0;
        oturi = siharaigaku - seikyuu;
        return oturi;
    }

    public void setOturi(int oturi) {
        this.oturi = oturi;
    }

    public Date getKasidasihizuke() {
        return kasidasihizuke;
    }

    public void setKasidasihizuke(Date kasidasihizuke) {
        this.kasidasihizuke = kasidasihizuke;
    }

    public String getRental_status() {
        return rental_status;
    }

    public void setRental_status(String rental_status) {
        this.rental_status = rental_status;
    }

    public Integer getKasidasijougen() {
        return kasidasijougen;
    }

    public void setKasidasijougen(Integer kasidasijougen) {
        this.kasidasijougen = kasidasijougen;
    }

}
