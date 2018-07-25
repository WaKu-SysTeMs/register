///*
// * 貸出処理　エンティティ
// */
//package entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.Transient;
//import javax.validation.constraints.NotNull;
//
///**
// *
// * @author s20163037
// */
//@NamedQueries({
//    @NamedQuery(name = Rental.RentalQAll,
//            query = "SELECT e FROM Rental e")
//})
//@Entity
//@Table(name = "RENTAL_INFO")
//public class Rental implements Serializable {
//
//    public static final String RentalQAll = "RentalQAll";
//
//    @Id
//    @NotNull
//    private Integer rentalNum;          // 貸出番号
//    
//    @JoinColumn(table = "member_info")
//    private Member member_info;
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date rentalDate;
//    
//    private int amount;
//    @Transient
//    private boolean editable;
//
//    public Rental() {
//    }
//
//    public Rental(Integer rentalNum, int amount, Date rentalDate) {
//        this.rentalNum = rentalNum;
//        this.amount = amount;
//        this.rentalDate = rentalDate;
//    }
//
//    public Integer getRentalNum() {
//        return rentalNum;
//    }
//
//    public void setRentalNum(Integer rentalNum) {
//        this.rentalNum = rentalNum;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public Date getRentalDate() {
//        return rentalDate;
//    }
//
//    public void setRentalDate(Date rentalDate) {
//        this.rentalDate = rentalDate;
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
