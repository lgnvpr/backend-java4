package luongnvpk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "detail_bill")
public class DetailBill extends BaseModel{
	@Column(name = "bill_id")
	String billId;
	@Column(name = "product_id")
	String productId;
	
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	} 
	
	
}
