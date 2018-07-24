///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.validation.constraints.Size;
//
///**
// *
// * @author s20163037
// */
//@Entity
//public class Category implements Serializable {
//
//    private static final long serialVersionUID = 1L; // シリアライズ
//
//    @Id
//    @Size(max = 3)
//    private String category_id;
//
//    @Size(max = 20)
//    private String category_name;
//    
//    @OneToMany(mappedBy = "fav_category", cascade = CascadeType.ALL)
//    private List<Member> member;
//
//    public Category() {
//    }
//
//    public Category(String category_id, String category_name) {
//        this.category_id = category_id;
//        this.category_name = category_name;
//    }
//
//    public String getCategory_id() {
//        return category_id;
//    }
//
//    public void setCategory_id(String category_id) {
//        this.category_id = category_id;
//    }
//
//    public String getCategory_name() {
//        return category_name;
//    }
//
//    public void setCategory_name(String category_name) {
//        this.category_name = category_name;
//    }
//
//    public List<Member> getMember() {
//        return member;
//    }
//
//    public void setMember(List<Member> member) {
//        this.member = member;
//    }
//    
//    
//
//}
