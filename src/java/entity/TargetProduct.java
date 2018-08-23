/*
 * 対象商品 TARGET_PRODUCT
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author s20163037
 */
//@Entity
@Table(name = "target_product")
public class TargetProduct implements Serializable {

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理
}
