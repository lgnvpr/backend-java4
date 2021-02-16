package luongnvpk.repository;

import java.util.ArrayList;
import luongnvpk.model.Product;
import luongnvpk.model.Enum.EMapping;
import luongnvpk.model.Enum.EService;
import luongnvpk.model.filter.IMappingTable;

public class ProductRepository extends BaseRepository<Product> {

	public ProductRepository() {
		super();
		super.Repoclass = Product.class;
		super.name = EService.product;
		super.join = new ArrayList<IMappingTable>();
	}
	public void initMapping() {
		this.join.add(new IMappingTable(EMapping.manyToOne, "categoryProductId", "categoryProduct",(BaseRepository) MainRepository.categoryRepo));		
	}
}
