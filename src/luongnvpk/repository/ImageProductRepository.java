package luongnvpk.repository;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;

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
import luongnvpk.model.filter.FindFilter;
import luongnvpk.model.filter.ListFilter;
import luongnvpk.model.filter.Paging;

public class ImageProductRepository extends BaseRepository<ImageProduct> {

	public ImageProductRepository() {
		super();
		System.out.println("on class category");
		super.Repoclass = ImageProduct.class;
		super.name = "image_product";
	}
	
	
}
