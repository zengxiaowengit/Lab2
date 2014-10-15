package factory;

import dao.BookDAO;
import dao.BookDAOImpl;

public class BookDAOFactory {
	public static BookDAO getBookDAOInstance()
	{
		return new BookDAOImpl() ;
	}
}
