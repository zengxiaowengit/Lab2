package com;

import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import factory.BookDAOFactory;

public class bookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BigDecimal isbn;
	private String title;
	private BigDecimal authorID;
	private String publisher;
	private Date publishDate;
	private int price;

	// 以作者名字查詢book
	public String queryByAuthor() throws Exception {
		String author = ServletActionContext.getRequest()
				.getParameter("author");
		System.out.println("读取到的author值是"+author);
		try {
			// Request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("authorQuery", BookDAOFactory.getBookDAOInstance()
					.queryByAuthor(author));
			request.setAttribute("current_author", author);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "query";
	}
	
	public String queryByTitle() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//String title = ServletActionContext.getRequest()
			//	.getParameter("title");
		new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("读取到的title值是"+title);
		try {
			// Request对象
			
			request.setAttribute("titleQuery", BookDAOFactory.getBookDAOInstance()
					.queryByTitle(title));
			System.out.println("QueryByTitle执行完毕。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
	// 删除用户--已实现
	public String delete() throws Exception {
		try {
			// 获取传送过来的title

			String title = ServletActionContext.getRequest().getParameter(
					"title");
			HttpServletRequest request = ServletActionContext.getRequest();
			BookDAOFactory.getBookDAOInstance().delete(title);
			String deleteMsg= "delete book success!";
			request.setAttribute("deleteMsg", deleteMsg);
			//内部测试
			System.out.println("delete执行完毕.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "delete";
	}

	public BigDecimal getIsbn() {
		return isbn;
	}

	public void setIsbn(BigDecimal isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getAuthorID() {
		return authorID;
	}

	public void setAuthorID(BigDecimal authorID) {
		this.authorID = authorID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
