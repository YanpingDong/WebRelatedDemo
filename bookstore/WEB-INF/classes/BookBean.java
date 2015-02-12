package bean;

import java.sql.*; 
import java.util.ArrayList;
import java.util.Random;

public class BookBean {
	private String bookid;
	   private String bookname;
	   private String author;
	   private float price;
	   private String publisher;

	   public void setBookid(String bookid){
	      this.bookid = bookid;
	   }

	   public String getBookid(){
	      return bookid;
	   }

	   public void setBookname(String bookname){
	      this.bookname = bookname;
	   }

	   public String getBookname(){
	      return bookname;
	   }

	   public void setAuthor(String author){
	      this.author = author;
	   }

	   public String getAuthor(){
	      return author;
	   }

	   public void setPrice(float price){
	      this.price = price;
	   }
	   
	   public float getPrice(){
	      return price;
	   }

	   public void setPublisher(String publisher){
	      this.publisher = publisher;
	   }

	   public String getPublisher(){
	      return publisher;
	   }  

	   public boolean deleteBook(String bookid){
		   Random random = new Random(3);
		   int n = random.nextInt();
		   boolean success = false;
		   if(n != 1)
			   success = true;
		   
		   return success;
		   }
	   public boolean update(){
		   Random random = new Random(3);
		   int n = random.nextInt();
		   boolean success = false;
		   if(n != 1)
			   success = true;
		   
		   return success;
	   }
	   public ArrayList findAllBooks(){
	      ArrayList books = new ArrayList();
	     
         for(int i = 0; i < 3; i++)
         {
            String tempBookid = i + "id";
            String tempBookname = i + "Bookname";
            String tempAuthor = i + "Author";
            float tempPrice = 10.0f;
            String tempPublisher = i + "Publisher";;

            BookBean book = new BookBean();
            book.setBookid(tempBookid);
            book.setBookname(tempBookname);
            book.setAuthor(tempAuthor);
            book.setPrice(tempPrice);
            book.setPublisher(tempPublisher);

            books.add(book);
         }
	      
	      return books;
	   }
	   public BookBean findBookByID(String bookid){
		      BookBean book=new BookBean();
	         String tempBookname = bookid + "Bookname";
	         String tempAuthor = bookid + "Author";
	         float tempPrice = 11.0f;
	         String tempPublisher = bookid + "Publisher";

	         book.setBookid(bookid);
	         book.setBookname(tempBookname);
	         book.setAuthor(tempAuthor);
	         book.setPrice(tempPrice);
	         book.setPublisher(tempPublisher);


		      return book;
		   }
	}