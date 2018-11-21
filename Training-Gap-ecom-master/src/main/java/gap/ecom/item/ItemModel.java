package gap.ecom.item;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
@Entity
@Table(name="t_cart")
@IdClass(ItemModelid.class)
public class ItemModel implements Serializable{
	@Id
	private Long uid;
	@Id
	private Long prid;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private float price;
	
	ItemModel()
	{
		
	}
	ItemModel(Long uid,Long prid,int quantity,float price)
	{
		this.uid=uid;
		this.prid=prid;
		this.quantity=quantity;
		this.price=price;	
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getPrid() {
		return prid;
	}
	public void setPrid(Long prid) {
		this.prid = prid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}

