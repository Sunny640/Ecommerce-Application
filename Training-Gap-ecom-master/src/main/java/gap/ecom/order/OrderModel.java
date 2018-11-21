package gap.ecom.order;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ts_order")
public class OrderModel implements Serializable {

    @Id
    Long orderId;

    @Column(name = "uid")
    Long uid;

    @Column(name = "total_quantity")
    int totalQuantity;





    @Column(name="total_price")
    float totalPrice;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }




    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
