package cabModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class CabDAO 
{
	//ESTABLISH CONNECTION
		Connection con;
		
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql@123");
				
			} catch (ClassNotFoundException e) 
			{
				
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Create Method which calculate total amount
		public int getTotalAmt(String cabtype,int km)
		{
			//declare Resources
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			int totalAmt=0;
			int rate = 0;
			//Write Query
			String query = "select rate_per_km from cab_info where cab_type=?";
			//create platform
			try {
				pstmt=con.prepareStatement(query);
				//set values for placeholder
				pstmt.setString(1, cabtype);
				//execute the query
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					rate = rs.getInt(1);
				}
				totalAmt=rate*km;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return totalAmt;
		}
		public int getWaitingCharges(String cabtype,int wtime)
		{
			//declare Resources
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			int totalCharge=0;
			int rate = 0;
			//Write Query
			String query = "select waiting_charges from cab_info where cab_type=?";
			//create platform
			try {
				pstmt=con.prepareStatement(query);
				//set values for placeholder
				pstmt.setString(1, cabtype);
				//execute the query
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					rate = rs.getInt(1);
				}
				totalCharge=rate*wtime;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return totalCharge;
		}


}
