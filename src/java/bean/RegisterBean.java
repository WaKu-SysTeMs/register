/*
 * レジ処理　Bean
 */
package bean;

import db.RegisterDb;
import entity.Register;
import entity.StoreInfo;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class RegisterBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    @Inject
    transient Logger log;

    @Inject
    Conversation conv;

    @EJB
    RegisterDb registerDb;

    @Size(max = 4)
    private String register_id;         // レジID

    @NotNull
    @Size(max = 3)
    private StoreInfo store_id;             // 店舗ID(FK)

    @Size(max = 7)
    private Integer register_amt;           // レジ内金額
    
    

}
