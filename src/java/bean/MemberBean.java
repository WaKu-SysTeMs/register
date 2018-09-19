/*
 * 会員情報処理　Bean
 */
package bean;

import db.BlackMgrDb;
import db.JobDb;
import db.MemberDb;
import entity.Category;
import entity.Job;
import entity.Member;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
    private String job_id;          // 職業ID(FK)
    @Size(max = 3)
    private String fav_category;    // 好みのジャンル(FK)
    @Size(max = 1)
    private String temp_flg;          // 仮会員フラグ
    @Inject
    transient Logger log;
    @Inject
    Conversation conv;
    @EJB
    MemberDb memberDb;
    @EJB
    BlackMgrDb blackMgrDb;
    @Inject
    JobDb jobdb;
    @Inject
    MemberDb memberdb;

    private String job_name;
    private String sex_name;

    public String create() {
        if (conv.isTransient()) {
            conv.begin();
            log.info(log.getName() + " | 会員入会会話スコープ開始 ****");
        } else {
            log.info(log.getName() + " | 会員入会スコープ ****");
        }
        return "/pages/member/create.xhtml?faces-redirect=true";
    }
    
    public String create1(){
        return "/pages/member/createconfirm.xhtml?faces-redirect=true";
    }
    
    public String create2(){
        return "/pages/member/createcomplete.xhtml?faces-redirect=true";
    }
    
    public String search() {                                // 会員名　取得
        this.member_name = null;
        Member m = (Member) memberDb.search(this.member_num);
        if (m != null) {
            this.member_name = m.getMember_name();
        }
        return null;
    }
    
    public void touroku(){
        memberdb.insert();
    }
    
    
    
    
    
    
    
    
    public String dateformat(Date date){
        return (new SimpleDateFormat("yyyy年MM月dd日")).format(date);
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
        if(sex.equals("1")){
            setSex_name("男");
        }else{
            setSex_name("女");
        }
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

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
        setJob_name(((Job)jobdb.search(job_id)).getJob_name());
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getSex_name() {
        return sex_name;
    }

    public void setSex_name(String sex_name) {
        this.sex_name = sex_name;
    }
    
    
}
