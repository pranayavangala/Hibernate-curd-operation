package ui;

import java.util.List;

import dao.ProductDAO;
import pojo.Product;

public class ProductTest {

	public static void main(String[] args) {
		
		/*Product product=new Product();
		product.setPid(1);
		product.setPname("watch");
		product.setPrice(500.0f);
		product.setMname("apple");*/
		
		ProductDAO dao=new ProductDAO();
		//dao.insertProduct(product);
		
		List<Product> products=dao.getProductsList();
		
		for(int i=0;i<products.size();i++)
		{
			Product p=products.get(i);
			
			System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPrice()+"\t"+p.getMname());
		}
	}
}
