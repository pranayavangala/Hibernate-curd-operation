package ui;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Product;

public class ProductTest1 {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		//=================================================================
		
		Product product=new Product();
		
		product.setPid(2);
		product.setPname("mobile");
		product.setPrice(20000.0f);
		product.setMname("samsung");
		
		Transaction tx=null;
		
		try {
			
			tx=session.beginTransaction();
			
			session.save(product);
			
			tx.commit();
			
		} catch (Exception e) {
			
			tx.rollback();
		}
		
		//======================================================================
		
		Criteria criteria=session.createCriteria(Product.class);
		
		List<Product> products=criteria.list();
		
		for(int i=0;i<products.size();i++)
		{
			Product p=products.get(i);
			
			System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPrice()+"\t"+p.getMname());
		}
		
		//====================================================================
				
		Query query=session.createQuery("From Product");
		
		List<Product> products1=query.list();
				
		for(int i=0;i<products1.size();i++)
		{
			Product p=products1.get(i);
					
			System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPrice()+"\t"+p.getMname());
		}
				
		//====================================================================
	}
}
