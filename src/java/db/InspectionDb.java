/*
 * ブラック会員情報　CRUD処理クラス
 */
package db;

import entity.Inspection;
import javax.ejb.Stateless;
import util.TryCatchDb;


/**
 *
 * @author s20163037
 */
@Stateless
public class InspectionDb extends TryCatchDb {


    public InspectionDb() {
        super(Inspection.class);
    }


}
