package luongnvpk.model;

public class DetailBill extends BaseModel{
	String billId;
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
