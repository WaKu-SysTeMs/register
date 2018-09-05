/*
 * DB処理用　汎用クラス(継承)
 */
package util;

import java.util.List;


/**
 *
 * @author s20163037
 */
public class TryCatchDb<T> extends SuperDb {
    
    

    public TryCatchDb(Class entityC) {
        super(entityC);
    }

    public void add(T obj) {         // 新規登録
        try {
            create(entityC);
        } catch (Exception e) {

        }
    }

    public void update(T obj) {          // 更新
        try {
            edit(obj);
        } catch (Exception e) {

        }
    }

    public void delete(T obj) {          // 削除
        try {
            remove(obj);
        } catch (Exception e) {

        }
    }

    public T search(Object key) {        // 検索
        return (T) find(key);
    }

    public List<T> getAll() {            // 全件データリスト取得
        return findAll();
    }

    public List<T> getRange(int[] range) {       // データ範囲取得
        return findRange(range);
    }

    public int dataCount() {                 // 総件数取得
        return count();
    }

}
