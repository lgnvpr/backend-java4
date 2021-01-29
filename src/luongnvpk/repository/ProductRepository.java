package luongnvpk.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import luongnvpk.helper.AuthenHelper;
import luongnvpk.helper.ErrorRequest;
import luongnvpk.helper.HibernateUtil;
import luongnvpk.helper.ObjectHelper;
import luongnvpk.helper.SendMail;
import luongnvpk.model.Account;
import luongnvpk.model.BaseModel;
import luongnvpk.model.CategoryProduct;
import luongnvpk.model.ImageProduct;
import luongnvpk.model.Product;
import luongnvpk.model.filter.FilterProps;
import luongnvpk.model.filter.FindFilter;
import luongnvpk.model.filter.IMappingTable;
import luongnvpk.model.filter.ListFilter;
import luongnvpk.model.filter.Paging;

public class ProductRepository extends BaseRepository<Product> {

	public ProductRepository() {
		super();
		super.Repoclass = Product.class;
		super.name = "product";
		super.join = new ArrayList<IMappingTable>();
		IMappingTable category = new IMappingTable("hasOne", "category_product",(BaseRepository) MainRepository.categoryRepo);
		this.join.add(category);
		
	}

	@Override
	public Paging<Product> list(ListFilter filter) {
		Paging<Product> list = super.list(filter);
		ArrayList<String> ids = new ArrayList<String>();

		String[] newIds = list.getRows().stream().map(e -> e.getCategoryProductId()).toArray(String[]::new);
		try {
			List<CategoryProduct> category = MainRepository.categoryRepo.get(newIds);
			FindFilter filterFindImage  = new FindFilter();
//			filterFindImage.setFilter(new FilterProps("product_id", newIds));
			List<ImageProduct> image =MainRepository.imageProductRepo.get(newIds);
			Product[] newList = list.getRows().stream().map(e -> {
				CategoryProduct findItem = category.stream().filter(i->{
					if(i.getId().equalsIgnoreCase(e.getCategoryProductId())) {
						return true;
					}
					return false;
				}).toArray(CategoryProduct[]::new)[0];
				e.setCategoryProduct(findItem);
				return e;
			}).toArray(Product[]::new);
			
			list.setRows(Arrays.asList(newList));
		} catch (Exception e2) {
			System.out.println(e2);
		}
		;
		return list;
	}

}
