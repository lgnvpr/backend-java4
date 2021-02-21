package luongnvpk.repository;

import java.util.ArrayList;
import java.util.List;

import luongnvpk.helper.ObjectHelper;
import luongnvpk.model.CartProduct;
import luongnvpk.model.Product;
import luongnvpk.model.Enum.EMapping;
import luongnvpk.model.Enum.EService;
import luongnvpk.model.filter.FilterProps;
import luongnvpk.model.filter.FindFilter;
import luongnvpk.model.filter.IMappingTable;

public class CartProductRepository extends BaseRepository<CartProduct> {

	public CartProductRepository() {
		super();
		super.Repoclass = CartProduct.class;
		super.name = EService.cartProduct;
		super.join = new ArrayList<IMappingTable>();
	}
	public void initMapping() {
		this.join.add(new IMappingTable(EMapping.manyToOne, "productId", "product",(BaseRepository) MainRepository.productRepo));
	}
	
	public CartProduct checkExitCartProductByCutomerAndProduct(CartProduct item) {
		ArrayList<FilterProps> filter = new ArrayList<FilterProps>();
		String[] filterCutomerValue = {item.getCustomerId()};
		String[] filterProductValue = {item.getProductId()};
		filter.add(new FilterProps("customerId", filterCutomerValue ));
		filter.add(new FilterProps("productId", filterProductValue ));
		FindFilter findFilter = new FindFilter();
		findFilter.setFilter(filter.toArray(FilterProps[]::new));
		List<CartProduct> checkExit = super.find(findFilter);
		return checkExit.size()>0 ? checkExit.get(0):null;
	}
	
	public CartProduct addToCart(CartProduct item) {
		CartProduct checkExit = this.checkExitCartProductByCutomerAndProduct(item);
		if(checkExit!=null) {
			checkExit.setAmount(checkExit.getAmount()+1);
			return super.save(checkExit);
		}
		item.setAmount(1);
		return super.save(item);
	}
	
	
	
}
