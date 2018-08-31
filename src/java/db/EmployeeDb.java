/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.Employee;
import javax.ejb.Stateless;
import util.TryCatchDb;


/**
 *
 * @author s20163037
 */
@Stateless
public class EmployeeDb extends TryCatchDb {


    public EmployeeDb() {
        super(Employee.class);
    }


}
