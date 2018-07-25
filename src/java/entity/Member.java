///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.SecondaryTable;
//import javax.persistence.SecondaryTables;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.Transient;
//import javax.validation.constraints.Size;
//
///**
// *
// * @author s20163037
// */
//
//@NamedQueries({
//    @NamedQuery(name = Member.MemberQAll, query = "SELECT e FROM Member e")
//})
//
//@Entity
//@Table(name = "member_info")
//@SecondaryTables({
//    @SecondaryTable(name = "job_list"),
//    @SecondaryTable(name = "category")
//})
//public class Member implements Serializable {
//
//    private static final long serialVersionUID = 1L; // シリアライズ
//    
//     public static final String MemberQAll = "MemberQAll";
//
//    @Id
//    @Size(max = 12)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer member_num;     // 会員番号
//
//    private String member_name;     // 会員名
//
//    private String member_ruby;     // 会員名 かな表記
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date birth_date;        // 生年月日
//
//    private String sex;             // 性別
//
//    private String postal_code;     // 郵便番号
//
//    private String member_add;      // 住所
//
//    private String add_ruby;        // 住所 かな表記
//
//    private String member_phone;    // 携帯番号
//
//    private String member_mail;     // メールアドレス
//
//    @JoinColumn(table = "job_list")
//    private Job job_id;          // 職業ID
//
//    @JoinColumn(table = "category", name = "fav_category")
//    private Category fav_category;    // 好みのジャンル
//
//    private char temp_flg;          // 仮会員フラグ
//
//    @Transient                  // シリアライズしない
//    private boolean editable;
//
//    public Member() {
//    }
//
//    public Member(Integer member_num, String member_name, String member_ruby,
//            Date birth_date, String sex, String postal_code, String member_add, 
//            String add_ruby, String member_phone, Job job_id, Category fav_category, char temp_flg) {
//        this.member_num = member_num;
//        this.member_name = member_name;
//        this.member_ruby = member_ruby;
//        this.birth_date = birth_date;
//        this.sex = sex;
//        this.postal_code = postal_code;
//        this.member_add = member_add;
//        this.add_ruby = add_ruby;
//        this.member_phone = member_phone;
//        this.job_id = job_id;
//        this.fav_category = fav_category;
//        this.temp_flg = temp_flg;
//    }
//    
//    
//
//    /* ゲッター、セッター */
//    public Integer getMember_num() {
//        return member_num;
//    }
//
//    public void setMember_num(Integer member_num) {
//        this.member_num = member_num;
//    }
//
//    public String getMember_name() {
//        return member_name;
//    }
//
//    public void setMember_name(String member_name) {
//        this.member_name = member_name;
//    }
//
//    public String getMember_ruby() {
//        return member_ruby;
//    }
//
//    public void setMember_ruby(String member_ruby) {
//        this.member_ruby = member_ruby;
//    }
//
//    public Date getBirth_date() {
//        return birth_date;
//    }
//
//    public void setBirth_date(Date birth_date) {
//        this.birth_date = birth_date;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getPostal_code() {
//        return postal_code;
//    }
//
//    public void setPostal_code(String postal_code) {
//        this.postal_code = postal_code;
//    }
//
//    public String getMember_add() {
//        return member_add;
//    }
//
//    public void setMember_add(String member_add) {
//        this.member_add = member_add;
//    }
//
//    public String getAdd_ruby() {
//        return add_ruby;
//    }
//
//    public void setAdd_ruby(String add_ruby) {
//        this.add_ruby = add_ruby;
//    }
//
//    public String getMember_phone() {
//        return member_phone;
//    }
//
//    public void setMember_phone(String member_phone) {
//        this.member_phone = member_phone;
//    }
//
//    public String getMember_mail() {
//        return member_mail;
//    }
//
//    public void setMember_mail(String member_mail) {
//        this.member_mail = member_mail;
//    }
//
//    public Job getJob_id() {
//        return job_id;
//    }
//
//    public void setJob_id(Job job_id) {
//        this.job_id = job_id;
//    }
//
//    public Category getFav_category() {
//        return fav_category;
//    }
//
//    public void setFav_category(Category fav_category) {
//        this.fav_category = fav_category;
//    }
//
//    public char getTemp_flg() {
//        return temp_flg;
//    }
//
//    public void setTemp_flg(char temp_flg) {
//        this.temp_flg = temp_flg;
//    }
//
//    public boolean isEditable() {
//        return editable;
//    }
//
//    public void setEditable(boolean editable) {
//        this.editable = editable;
//    }
//
//}
