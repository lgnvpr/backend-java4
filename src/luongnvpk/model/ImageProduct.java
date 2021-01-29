package luongnvpk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "image_product")
public class ImageProduct  extends BaseModel{
	@Column(name = "link")
	String link;
	@Column(name = "product_id")
	String productId;
	public String getLink() {
		return link;
	}
	public void setLink(String image) {
		this.link = image;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	
}
