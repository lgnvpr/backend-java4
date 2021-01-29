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
import luongnvpk.model.filter.FindFilter;
import luongnvpk.model.filter.ListFilter;
import luongnvpk.model.filter.Paging;

public class AccountStaffRepository extends BaseRepository<Account> {

	public AccountStaffRepository() {
		super();
		super.Repoclass = Account.class;
		super.name = "account";
	}

	public String login(String name, String password) throws IOException {
		@SuppressWarnings({ "deprecation", "unchecked" })
		Query<Account> query = this.getSession().createNativeQuery(
				"select * from " + this.name + " where is_deleted=0 and username =:username and password = :password",
				this.Repoclass);
		Query<Account> setParameter = query.setParameter("username", name);
		query.setParameter("password", password);
		try {
			String get = ObjectHelper.gson().toJson(query.getResultList().get(0));
			System.out.println(get);
			String token = AuthenHelper.signJwt(get);
			AuthenHelper.veryJWT(get, token);
			return token;
		} catch (Exception e) {
			ErrorRequest.BadInput("Tên tài khoản hoạt mật khẩu không đúng");
			return null;
		}
	}
	
	@SuppressWarnings("deprecation")
	public Account save(Account account) {
		@SuppressWarnings({ "unchecked", "deprecation" })
		Query<Account> query = this.getSession().createNativeQuery(
				"select * from " + this.name + " where is_deleted=0 and username =:username",
				this.Repoclass);
		query.setParameter("username", account.getUsername());
		try {
			query.getResultList().get(0);
			ErrorRequest.Error500("Tài khoản đã tồn tại");
			return null;
		} catch (Exception e) {
			SendMail.sendMail(account.getUsername());
			return super.save(account);
		}
	}
	
	
	
}
