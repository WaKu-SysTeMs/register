///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package bean;
//
//import db.RentalDb;
//import entity.Rental;
//import java.io.Serializable;
//import java.util.List;
//import java.util.logging.Logger;
//import javax.ejb.EJB;
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//
///**
// *
// * @author s20163037
// */
//@Named
//@SessionScoped
//public class RentalListBean implements Serializable {
//
//    private List<Rental> rentalList;
//
//    @EJB
//    RentalDb rentalDb;
//
//    @Inject
//    transient Logger log;
//    
//    /**
//     * rentalListへ貸出情報を全件いれる
//     * 
//     * @return 貸出一覧画面表示
//     */
//    public String list(){
//        log.info(log.getName() + "| 貸出一覧画面");
//        rentalList = rentalDb.getAll();
//        return  "/pages/rental/list.xhtml";
//    }
//    
//}
