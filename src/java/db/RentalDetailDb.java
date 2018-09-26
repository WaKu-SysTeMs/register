package db;

//import entity.Rental;
import entity.DvdInfo;
import entity.ReleaseList;
import entity.RentalDetail;
import entity.RentalInfo;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import util.TryCatchDb;

/**
 *
 * @author s20163037
 */
@Stateless
public class RentalDetailDb extends TryCatchDb {

    @PersistenceContext
    EntityManager em;
    @Inject
    RentalInfoDb rentalinfodb;

    public RentalDetailDb() {
        super(RentalDetail.class);
    }

    public void insert(int ii, boolean b, int seikyuu, Date kasidasihizuke, Integer hakusuu, String dvd_num, String release_kbn, String haku) {
        Integer cnt1;
        Integer cnt2;
        cnt1 = rentalinfodb.getCnt();
        String s1;
        s1 = Integer.toString(cnt1);
        String s2 = "";

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(kasidasihizuke);
        calendar.add(Calendar.DATE, hakusuu);
        kasidasihizuke = calendar.getTime();
        try {
            Query q = em.createNativeQuery("select count(*) from rental_detail where rental_num = ?1");
            q.setParameter(1, s1);
            cnt2 = ((BigDecimal) q.getSingleResult()).intValue();
            cnt2++;
            s2 = Integer.toString(cnt2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Query q = em.createNativeQuery("insert into rental_detail values(?1,?2,'0',null,?3,?4,?5,?6,?7,?8,null)");
            q.setParameter(1, s2);
            q.setParameter(2, b);
            q.setParameter(3, kasidasihizuke);
            q.setParameter(4, seikyuu);
            q.setParameter(5, dvd_num);
            q.setParameter(6, release_kbn);
            q.setParameter(7, haku);
            q.setParameter(8, s1);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public RentalDetail searchDetail(){
        try{
            DvdInfo dvdInfo = new DvdInfo();
            Query q = em.createNamedQuery(RentalDetail.RentalDetailQdvdNum, RentalDetail.class);
            q.setParameter(1, dvdInfo.getDvd_num());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
