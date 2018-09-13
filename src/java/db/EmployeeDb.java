/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.Employee;
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
public class EmployeeDb extends TryCatchDb {
@PersistenceContext
private EntityManager em;

    public EmployeeDb() {
        super(Employee.class);
    }

    public Employee loginemp(String user){
        try {
            Query q=em.createNativeQuery("select * from emp_info where emp_num = ?1", Employee.class);
            q.setParameter(1, user);
            return (Employee)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            }
    }

}
