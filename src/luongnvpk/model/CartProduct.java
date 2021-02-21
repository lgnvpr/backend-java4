package luongnvpk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import luongnvpk.model.Enum.EService;

@Entity
@Table(name = EService.cartProduct)
public class CartProduct extends BaseModel{
	@Column(name = "product_id")
	String productId;
	@Column(name = "customer_id")
	String customerId; 
	@Column(name = "amount")
	int amount;
	
	@Transient
	Product product;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
