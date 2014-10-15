package dao;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.* ;
import dao.DBConn;;

public class BookDAOImpl implements BookDAO{

	@Override//�� book�Єh������
	public void delete(String title) throws Exception {
		String sql = "DELETE FROM book WHERE Title=?" ;
		PreparedStatement pstmt = null ;
		DBConn dbc = null ;
		dbc = new DBConn() ;
		try
		{
			pstmt = dbc.getConn().prepareStatement(sql) ;
			pstmt.setString(1,title);
			pstmt.executeUpdate() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			throw new Exception("�����г��ִ��󣡣���") ;
		}
		finally
		{
			dbc.closeConn() ;
		}
	}

	@Override//��ԃĳ���ߵ����Е���
	public List<Book> queryByAuthor(String name) throws Exception {
		List<Book> list=new ArrayList<Book>();
		Book book=null;
		String sql="select AuthorID from Author where name=?";
		String sql2="select * from Book where AuthorID=?";
		PreparedStatement pstmt=null;
		DBConn dbc= new DBConn();
		BigDecimal authorID = null;
		try
		{
			
			pstmt=dbc.getConn().prepareStatement(sql);//Ԥ����sql
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();//ִ�в��������ؽ����
			while(rs.next())	authorID = rs.getBigDecimal(1);
			
		}
		catch(Exception e)
		{
			throw new Exception("��������1!");
		}
		finally{
			if(dbc!=null)	dbc.closeConn();
		}
		
		try{
			System.out.println("AuthID is "+authorID);
			pstmt=dbc.getConn().prepareStatement(sql2);//Ԥ����sql2
			pstmt.setBigDecimal(1, authorID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())//ѭ����ȡ���
			{
				book=new Book();//ʵ����Book
				book.setIsbn(rs.getBigDecimal(1));
				book.setTitle(rs.getString(2));
				book.setAuthorID(rs.getBigDecimal(3));
				book.setPublisher(rs.getString(4));
				book.setPublishDate(rs.getDate(5));
				book.setPrice(rs.getInt(6));
				list.add(book);//��book�����м��뵽list������
				
			}
		}
		catch(Exception e)
		{
			throw new Exception("��������2!");
		}
		finally
		{
			if(dbc!=null)	dbc.closeConn();
		}
		return list;
	}

	@Override//�鿴����Ԕ����Ϣ��
	public List<Book> queryByTitle(String title) throws Exception {
		List<Book> list=new ArrayList<Book>();
		Book book=null;
		String sql="select * from book where Title=?";
		PreparedStatement pstmt=null;
		DBConn dbc=null;
		dbc=new DBConn();
		try
		{
			
			pstmt=dbc.getConn().prepareStatement(sql);//Ԥ����sql
			pstmt.setString(1, title);
			ResultSet rs=pstmt.executeQuery();//ִ�в��������ؽ����
			while(rs.next())//ѭ����ȡ���
			{
				book=new Book();//ʵ����Book
				book.setIsbn(rs.getBigDecimal(1));
				book.setTitle(rs.getString(2));
				book.setAuthorID(rs.getBigDecimal(3));
				book.setPublisher(rs.getString(4));
				book.setPublishDate(rs.getDate(5));
				book.setPrice(rs.getInt(6));
				list.add(book);//��book�����м��뵽list������
				
			}
		}
		catch(Exception e)
		{
			throw new Exception("��������!");
		}
		finally
		{
			dbc.closeConn();
		}
		return list;
	}

	
}
