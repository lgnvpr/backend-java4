package luongnvpk.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Access;
import org.hibernate.annotations.NotFound;

import luongnvpk.model.Enum.EService;

@Entity
@Table(name = EService.product)
public class Product extends BaseModel {
	@Column(name = "name")
	String name;
	@Column(name = "price")
	BigInteger price;
	@Column(name = "description")
	String description;
	@Column(name = "category_product_id")
	String categoryProductId;
	@Column(name = "price_sale")
	BigInteger priceSale;
	@Column(name = "percent_sale", nullable = false)
	int percentSale;
	String image;

	@Transient
	public CategoryProduct categoryProduct;

	@Transient
	public ImageProduct[] productImage;

	public ImageProduct[] getProductImage() {
		return productImage;
	}

	public void setProductImage(ImageProduct[] productImage) {
		this.productImage = productImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getPrice() {
		return price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryProductId() {
		return categoryProductId;
	}

	public void setCategoryProductId(String categoryProductId) {
		this.categoryProductId = categoryProductId;
	}

	public BigInteger getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(BigInteger priceSale) {
		this.priceSale = priceSale;
	}

	public int getPercentSale() {
		return percentSale;
	}

	public void setPercentSale(int percentSale) {
		this.percentSale = percentSale;
	}

	public CategoryProduct getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoryProduct categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
