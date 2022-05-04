package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import context.DBContext;
import modal.Cart;
import modal.Orders;
import modal.Product;
import modal.ProductOrders;

public class OrdersDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
//insert information of Order to data source, that including list of
// products in cart(c) and information of buyer in Orders o
	public void insertOrder(Orders o, Cart c, String email) throws Exception { 
		// insert data into table [Orders]

		String query1 ="insert into  [dbo].[Orders] ([user_mail],[order_status] , [order_discount_code] ,[order_address]  )		values (?, ?,?,?)";
		String query2 ="select max(order_id) from Orders";
		String query3 = "insert into [dbo].[Orders_detail]\r\n"
				+ "values (?,?, ?, ?);";
        String idd;
        int id = 0 ;
		//null,  0  ,'2003-12-31', '' , 'd')
		//String user_mail,int  order_status , 
		//Date order_date ,  String order_discount_code , String order_addess
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query1);
			ps.setString(1,email );
			ps.setInt(2,o.getStatus());
			ps.setString(3,o.getDiscount());
			ps.setString(4,  o.getAddress());
			ps.executeUpdate();
                 try {
         			conn = new DBContext().getConnection();
        			ps = conn.prepareStatement(query2);
        			rs = ps.executeQuery();
        			while (rs.next()) {
                         idd = rs.getString(1);
                         id = Integer.parseInt(idd);
        			}
        			try {
        				conn = new DBContext().getConnection();
        				ps = conn.prepareStatement(query3);
        				List<Product> ls = c.getItems();
        				for (Product p : ls ) {
        					ps.setInt(1, id);
        					ps.setInt(2, p.getId());
        					ps.setInt(3, p.getNumber() );
        					ps.setFloat(4, p.getPrice() );
        					ps.executeUpdate();
        				}

        			} catch (Exception e) {
						// TODO: handle exception
					}
                 }catch (Exception e) {
					// TODO: handle exception
				}
		} catch (Exception e) {
			System.out.println(e);
		} 



	}
	public static void main(String[] args) {
		OrdersDAO or = new OrdersDAO();
		String email = "cun180416@gmail.com";
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		List<ProductOrders> lp = new ArrayList<>();
		lp.add(new ProductOrders(1,1,1,"samsung"));
		Orders o = new Orders(1,8,0,now,"115 ha doan 2","0869796111",lp,email,now,"0");
		List<Product> items = new ArrayList<Product>();
		items.add(new Product(1,"samsung", "nothing", 8, "src.jsp", "type1" , "nobrand" , 1));
		Cart c = new Cart(items);
		try {
			or.insertOrder(o, c, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
