package db;

import entity.DelayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.TryCatchDb;

/**
 *
 * @author s20163037
 */
@Stateless
public class DelayListDb extends TryCatchDb {

    @PersistenceContext
    EntityManager em;

    public DelayListDb() {
        super(DelayList.class);
    }


}
