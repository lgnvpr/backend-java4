package luongnvpk.repository;

import luongnvpk.model.BaseModel;

public class MainRepository {
	public static ProductRepository productRepo = null;
	public static AccountStaffRepository accountRepo = null;
	public static CategoryRepository categoryRepo = null;
	public static ImageProductRepository imageProductRepo= null;
	
	public static void init() {
		if(productRepo==null) {
			productRepo = new ProductRepository();
			System.out.println("productRepo is init");
		}
		if(accountRepo== null) {
			accountRepo = new AccountStaffRepository();
			System.out.println("accountRepo is init");
		}
		if(categoryRepo== null) {
			categoryRepo = new CategoryRepository();
			System.out.println("categoryRepo is init");
		}
		if(imageProductRepo== null) {
			imageProductRepo = new ImageProductRepository();
			System.out.println("image product Repo is init");
		}
		
	}
	
}