package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import modal.Account;
import modal.Product;

// methods for working with the Product table.
public class AccountDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
// search product
	public Account search(String characters) {
		String query = "select * from Account where user_mail = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, characters );
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				return new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), 0);
				//String usr, String pwd, int role, String name, String address, String phone, int check
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
		

	}
	// check account exits or not
		public boolean checkAccountExits(String characters) {
			String query = "select * from Account where user_mail = ?";
			Account a = null;
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, characters );
				rs = ps.executeQuery();
				System.out.println(rs);
				while (rs.next()) {
					a =  new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
							rs.getString(6), 0);
					//String usr, String pwd, int role, String name, String address, String phone, int check
				}

			} catch (Exception e) {
				System.out.println(e);
			}

			if (a == null ) {
				return false;
			} else {
				return true;
			}

		}
		public void signup(Account acc) {
			String query = "insert into Account \r\n"
					+ "values (?,?,0,?,'','');";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, acc.getUsr() );
				ps.setString(2, acc.getPwd() );
				ps.setString(3, acc.getName() );
				ps.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}


		}


	public static void main(String[] args) {
		AccountDAO a = new AccountDAO();
		String character = "anh2522003@gmail.com";
		Account acc = a.search(character);
		System.out.println(acc);
	}

}
