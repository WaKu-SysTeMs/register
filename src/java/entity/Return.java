/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author s20163060
 */
@NamedQueries({
    @NamedQuery(name = Return.Qmember_name,
            query = "SELECT r FROM Return r")
})
@Entity
@Table(name = "RENTAL_DETAIL")
@SecondaryTables({
    @SecondaryTable(name = "RENTAL_INFO"),
    @SecondaryTable(name = "MEMBER_INFO"),
    @SecondaryTable(name = "DELAY_LIST"),
    @SecondaryTable(name = "DVD_INFO"),
    @SecondaryTable(name = "PRODUCT_INFO")
})
public class Return implements Serializable{
    
    public static final String Qmember_name = "Qmember_name";
    public static final String Qdvd_num = "Qdvd_num";
    public static final String Qreturn = "Qreturn";
    @Transient
    String kari = "ちょっとよくわからないです。";
    
    
    public Return(){
    }
}
