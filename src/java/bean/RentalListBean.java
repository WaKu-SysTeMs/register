/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.RentalInfoDb;
import entity.RentalInfo;
//import entity.Rental;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class RentalListBean implements Serializable {


    

    @EJB
    RentalInfoDb rentalDb;

    @Inject
    transient Logger log;
    
     public List<RentalInfo> getAll() {          // MemberInfo 全件取得
        return rentalDb.getAll();
    }
}
