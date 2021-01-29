package luongnvpk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart_product")
public class Voucher extends BaseModel{
	@Column(name = "code_voucher")
	String codeVoucher;
	@Column(name = "percent_sale")
	String percentSale;
	@Column(name = "total_sale")
	String totalSale;
	@Column(name = "end_at")
	Date endAt;
	@Column(name = "start_at")
	Date startAt;
	@Column(name = "total")
	Date total;
	public String getCodeVoucher() {
		return codeVoucher;
	}
	public void setCodeVoucher(String codeVoucher) {
		this.codeVoucher = codeVoucher;
	}
	public String getPercentSale() {
		return percentSale;
	}
	public void setPercentSale(String percentSale) {
		this.percentSale = percentSale;
	}
	public String getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(String totalSale) {
		this.totalSale = totalSale;
	}
	public Date getEndAt() {
		return endAt;
	}
	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}
	public Date getStartAt() {
		return startAt;
	}
	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	public Date getTotal() {
		return total;
	}
	public void setTotal(Date total) {
		this.total = total;
	}
	
	
}
