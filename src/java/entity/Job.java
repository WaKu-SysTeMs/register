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
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
///**
// *
// * @author s20163037
// */
//@Entity
//@Table(name = "job_list")
//public class Job implements Serializable{
//    
//    private static final long serialVersionUID = 1L; // シリアライズ
//    
//    @Id
//    private String job_id;
//    
//    @Size(max = 20)
//    private String job_name;
//    
//    @OneToMany(mappedBy = "job_id", cascade = CascadeType.ALL)
//    private List<Member> member;
//    
//
//    public Job() {
//    }
//
//    
//    public Job(String job_id, String job_name) {
//        this.job_id = job_id;
//        this.job_name = job_name;
//    }
//
//    public String getJob_id() {
//        return job_id;
//    }
//
//    public void setJob_id(String job_id) {
//        this.job_id = job_id;
//    }
//
//    public String getJob_name() {
//        return job_name;
//    }
//
//    public void setJob_name(String job_name) {
//        this.job_name = job_name;
//    }
//    
//    
//}
