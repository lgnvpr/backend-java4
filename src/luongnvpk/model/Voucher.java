package luongnvpk.model;

import java.util.Date;

public class Voucher extends BaseModel{
	String codeVoucher;
	String percentSale;
	String totalSale;
	Date endAt;
	Date startAt;
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
