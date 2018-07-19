/*
 * 貸出処理　エンティティ
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 *
 * @author s20163037
 */
@NamedQueries({
    @NamedQuery(name = Rental.RentalQAll,
            query = "SELECT e FROM Rental e")
})
@Entity
@Table()
public class Rental implements Serializable {
    
    public static final String RentalQAll = "RentalQAll";
    
    @Id
    private Integer rentalNum;
    
    @Transient
    private boolean editable;

    public Rental() {

    }

}
