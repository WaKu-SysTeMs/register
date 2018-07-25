/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163037
 */
@NamedQueries({
    @NamedQuery(name = Member.MemberQAll, query = "SELECT e FROM Member e"),
    @NamedQuery(name = Member.MemberQName, query = "SELECT e.member_name FROM Member e WHERE e.member_num = ?1")
})

@Entity
@Table(name = "member_info")
@SecondaryTables({
    @SecondaryTable(name = "job_list"),
    @SecondaryTable(name = "category")
})
public class Member implements Serializable {

    private static final long serialVersionUID = 1L; // シリアライズ

    public static final String MemberQAll = "MemberQAll";
    public static final String MemberQName = "MemberQName";

    @Id
    @NotNull
    @Size(max = 12)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer memberNum;     // 会員番号

    private String memberName;     // 会員名

    private String memberRuby;     // 会員名 かな表記

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;        // 生年月日

    private String sex;             // 性別

    private String postalCode;     // 郵便番号

    private String memberAdd;      // 住所

    private String addRuby;        // 住所 かな表記

    private String memberPhone;    // 携帯番号

    private String memberMail;     // メールアドレス

    @JoinColumn(table = "job_list")
    private Job jobId;          // 職業ID

    @JoinColumn(table = "category", name = "fav_category")
    private Category favCategory;    // 好みのジャンル

    private char tempFlg;          // 仮会員フラグ

    @Transient                  // シリアライズしない
    private boolean editable;

    public Member() {
    }

    public Member(Integer memberNum, String memberName, String memberRuby,
            Date birthDate, String sex, String postalCode, String memberAdd, String addRuby, 
            String memberPhone, String memberMail, Job jobId, Category favCategory, char tempFlg, boolean editable) {
        this.memberNum = memberNum;
        this.memberName = memberName;
        this.memberRuby = memberRuby;
        this.birthDate = birthDate;
        this.sex = sex;
        this.postalCode = postalCode;
        this.memberAdd = memberAdd;
        this.addRuby = addRuby;
        this.memberPhone = memberPhone;
        this.memberMail = memberMail;
        this.jobId = jobId;
        this.favCategory = favCategory;
        this.tempFlg = tempFlg;
        this.editable = editable;
    }

    /* ゲッター、セッター */
    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberRuby() {
        return memberRuby;
    }

    public void setMemberRuby(String memberRuby) {
        this.memberRuby = memberRuby;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMemberAdd() {
        return memberAdd;
    }

    public void setMemberAdd(String memberAdd) {
        this.memberAdd = memberAdd;
    }

    public String getAddRuby() {
        return addRuby;
    }

    public void setAddRuby(String addRuby) {
        this.addRuby = addRuby;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberMail() {
        return memberMail;
    }

    public void setMemberMail(String memberMail) {
        this.memberMail = memberMail;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public Category getFavCategory() {
        return favCategory;
    }

    public void setFavCategory(Category favCategory) {
        this.favCategory = favCategory;
    }

    public char getTempFlg() {
        return tempFlg;
    }

    public void setTempFlg(char tempFlg) {
        this.tempFlg = tempFlg;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
