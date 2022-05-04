package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import modal.Product;

// methods for working with the Product table.
public class ListProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
// search product
	public List<Product> search(String characters) {
		List<Product> list = new ArrayList<>();
		String query = "select *  from Products where product_name  like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,'%' + characters + '%');
			rs = ps.executeQuery();
			while (rs.next()) {
				
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
		

	}

	public Product getProduct(String character) {
		Product p = new Product();
		String query = "select *  from Products where product_id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,character);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1) ;
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}


		return p;

	}

	public List<Product> getListHotDealSection() {
		List<Product> list = new ArrayList<>();
		String query = "select  * from Products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		String query = "select  * from Products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
	
	public List<Product> getListTopSelling() {
		List<Product> list = new ArrayList<>();
		String query = "select  * from Products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public List<Product> getListNewProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select  * from Products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public List<Product> getListTop_3_Selling() {
		List<Product> list = new ArrayList<>();
		String query = "select top(3) * from Products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
	// get related product in page Product 
	public List<Product> getRelatedProductProduct(String character) {
		List<Product> list = new ArrayList<>();
		String query = "select  top(2) * from Products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
//			int id, String name, String decription, float price, String src, String type, String brand, int number
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public static void main(String[] args) {
		ListProductDAO dao = new ListProductDAO();
		List<Product> lp = dao.getListHotDealSection();

		for (Product o : lp) {
			System.out.println(o);

		}
	}

}
