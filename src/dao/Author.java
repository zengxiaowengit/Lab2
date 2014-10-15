package dao;

import sun.security.util.BigInt;

public class Author {
	private BigInt AuthorID;
	private String Name;
	private	int Age;
	private String	Country;
	public BigInt getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(BigInt authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}
