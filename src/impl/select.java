package impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConn;

public class select{  
    
    /** 
     * ע��ʱ��⹦�� 
     * @param userName 
     * @return 
     */  
    public int selectByName(String userName) {  
        int count=0;  
        try {  
            DBConn db = new DBConn();  
            Connection conn = db.getConn();  
            Statement stmt = conn.createStatement();  
          
            String sq20 = "SELECT count(*) FROM user WHERE username = "   
                + "'" + userName + "'";  
            //ִ�и����� SQL ��䣬����䷵�ص��� ResultSet����  
            ResultSet rs = stmt.executeQuery(sq20) ;  
            while(rs.next()){   
                count = rs.getInt(1);  
            }  
            if(rs != null){ // �رռ�¼��  
                try{   
                    rs.close() ;   
                }catch(SQLException e){   
                    e.printStackTrace() ;  
                }   
            }   
            if(stmt != null){ // �ر�����   
                try{  
                    stmt.close() ;   
                }catch(SQLException e){  
                    e.printStackTrace() ;  
                }  
            }   
            if(conn != null){ // �ر����Ӷ���  
                try{  
                    conn.close() ;  
                }catch(SQLException e){   
                    e.printStackTrace() ;   
                }  
            }  
            db.closeConn();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return count;  
    }
    
    /*
     @param userName 
     * @param passWord 
     * @return 
     * */
    public int selectStatement(String userName,String passWord) {  
        int count=0;  
        try {  
            DBConn db = new DBConn();  
            Connection conn = db.getConn();  
            Statement stmt = conn.createStatement() ;  
              
            String sq20 = "SELECT count(*) FROM user WHERE username = "   
                + "'" + userName + "' and password = '" + passWord + "'";  
              
            ResultSet rs = stmt.executeQuery(sq20) ;  
            while(rs.next()){   
                count = rs.getInt(1);  
            }  
            if(rs != null){ // �رռ�¼��  
                try{   
                    rs.close() ;   
                }catch(SQLException e){   
                    e.printStackTrace() ;  
                }   
            }   
            if(stmt != null){ // �ر�����   
                try{  
                    stmt.close() ;   
                }catch(SQLException e){  
                    e.printStackTrace() ;  
                }  
            }   
            if(conn != null){ // �ر����Ӷ���  
                try{  
                    conn.close() ;  
                }catch(SQLException e){   
                    e.printStackTrace() ;   
                }  
            }  
            db.closeConn();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return count;  
    }  
}
