package gap.ecom.payment;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="t_payment")
public class PaymentModel {
    @Id
    long s;


    @Column(name = "order_id")
    long orderId;

    @Column(name = "uid")
    long uid;

    @Column(name = "prid")
    long productId;

    @Column(name = "price")
    float price;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getS() {
        return s;
    }

    public void setS(long s) {
        this.s = s;
    }
}
