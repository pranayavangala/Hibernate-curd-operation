package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Product;

public class ProductDAO {

	Configuration configuration=null;
	SessionFactory sessionFactory=null;
	Transaction tx=null;
	Session session=null;
	
	public ProductDAO() {
		
		configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public int insertProduct(Product product)
	{
		int result=0;
		
		try {
			
			session=sessionFactory.openSession();
			
			tx=session.beginTransaction();
			
			session.save(product);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
			
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Product> getProductsList()
	{
		session=sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Product.class);
		
		List<Product> products=criteria.list();
		
		return products;
	}
}
