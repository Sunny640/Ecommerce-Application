package gap.ecom.inventory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Inventory2")  
public class InvModel {
	@Id
	private long productId;
	@Column(name="productName")
	private String productName;
	@Column(name="brand")
	private String brand;
	@Column(name="Category")
	private String Category;
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private float price;
	
	
	public long getproductId() {
		return productId;
	}
	public float getprice() {
		return price;
	}
	public void setprice(float p)
	{
		price=p;
	}
	public void setproductId(long productId) {
		this.productId = productId;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

