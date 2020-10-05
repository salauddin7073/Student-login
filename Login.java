import java.util.*;
import java.sql.*;
class Login
{
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		String login="2020102",pas="66899",s1,s2;
		boolean flag = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sallu","root","12345");
			Statement stmt = conn.createStatement();
			//stmt.executeUpdate("insert into student values(3,'hfg',2020105,88665522)");
			ResultSet rs = stmt.executeQuery("select * from student");
			while(rs.next())
			{
				s1 = rs.getString("Login_ID");
				s2 = rs.getString("Password");		
				if(s1.equals(login) && s2.equals(pas))
				{
					flag = true;
				}
			}
					if(flag)
				{
					System.out.println("Login Successfull");
				}
				else
				{
						System.out.println("Login Not-Successfull");
				}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}