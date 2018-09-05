/*
 * 会員情報処理　Bean
 */
package bean;

import db.BlackMgrDb;
import db.MemberDb;
import entity.Category;
import entity.Job;
import entity.Member;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class MemberBean implements Serializable {

    @Size(max = 9)
    private String member_num;     // 会員番号

    @Size(max = 30)
    private String member_name;     // 会員名

    @Size(max = 40)
    private String member_ruby;     // 会員名 かな表記

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birth_date;        // 生年月日

    @Size(max = 2)                   // もしくは@patternで
    private String sex;             // 性別

    @Size(max = 8)                   // もしくは@patternで
    private String postal_code;     // 郵便番号

    @Size(max = 80)
    private String member_add;      // 住所

    @Size(max = 200)
    private String add_ruby;        // 住所 かな表記

    @Size(max = 20)
    private String member_phone;    // 携帯番号

    @Size(max = 40)
    private String member_mail;     // メールアドレス

    @NotNull
    @Size(max = 1)
    private Job job_id;          // 職業ID(FK)

    @Size(max = 3)
    private Category fav_category;    // 好みのジャンル(FK)

    @Size(max = 1)
    private char temp_flg;          // 仮会員フラグ

    @PersistenceContext
    EntityManager em;

    @Inject
    transient Logger log;

    @Inject
    Conversation conv;

    @EJB
    MemberDb memberDb;

    @EJB
    BlackMgrDb blackMgrDb;

    @PostConstruct
    public void start() {
        if (!conv.isTransient()) {
            log.info(log.getName() + "| 会話スコープ終了");
            conv.end();
        }
    }

    public String create() {
        log.info(log.getName() + "| 会員登録画面");
        if (conv.isTransient()) {
            conv.begin();
        }
        return "/pages/member/create.xhtml";
    }

    public String search() {                                // 会員名　取得
        Member m = (Member) memberDb.search(this.member_num);
        if (m != null) {
            this.member_name = m.getMember_name();
        }
        return null;
    }


    public List<Member> getAll() {          // MemberInfo 全件取得
        return memberDb.getAll();
    }

    /* ゲッター、セッター */

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

    public String getMember_ruby() {
        return member_ruby;
    }

    public void setMember_ruby(String member_ruby) {
        this.member_ruby = member_ruby;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getMember_add() {
        return member_add;
    }

    public void setMember_add(String member_add) {
        this.member_add = member_add;
    }

    public String getAdd_ruby() {
        return add_ruby;
    }

    public void setAdd_ruby(String add_ruby) {
        this.add_ruby = add_ruby;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public String getMember_mail() {
        return member_mail;
    }

    public void setMember_mail(String member_mail) {
        this.member_mail = member_mail;
    }

    public Job getJob_id() {
        return job_id;
    }

    public void setJob_id(Job job_id) {
        this.job_id = job_id;
    }

    public Category getFav_category() {
        return fav_category;
    }

    public void setFav_category(Category fav_category) {
        this.fav_category = fav_category;
    }

    public char getTemp_flg() {
        return temp_flg;
    }

    public void setTemp_flg(char temp_flg) {
        this.temp_flg = temp_flg;
    }

}
