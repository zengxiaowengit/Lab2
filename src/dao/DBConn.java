package dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class DBConn {
	private Connection conn;  
    /** 
     * �������ݿ� 
     * @return 
     */  
    public Connection getConn(){  
        String url = "jdbc:mysql://localhost:3306/BOOKDB"; // ���ݿ��ַ[jdbc:mysql://<IP>:<db-port>/<db-name>]  
        String user = "root"; // ���ݿ��û���  
        String pwd = "admin"; // ���ݿ�����  
        try {  
            Class.forName("com.mysql.jdbc.Driver"); // ��������  
            conn = DriverManager.getConnection(url, user, pwd);// ע����������  
            if (!conn.isClosed()) {  
                System.out.println("���ݿ����ӳɹ�");  
            }  
            if (conn == null) {  
                System.out.println("�������ݿ�ʧ�ܣ��Ӽ�������������");  
            }  
  
        } catch (ClassNotFoundException e) {  
        	System.out.println("Class NOT find...");
            e.printStackTrace();  
        } catch (SQLException e) {  
        	System.out.println("SQL Exception 30...");
            e.printStackTrace();  
        }  
        return conn;  
    }  
    /** 
     * �ر����ݿ����� 
     */  
    public void closeConn(){  
        if(conn!=null) {  
            try{  
                conn.close();  
            }catch(Exception e){  
            	System.out.println("SQL Exception 43...");
                e.printStackTrace();  
            }  
        }  
    }  

}
