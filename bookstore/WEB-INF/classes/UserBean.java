package bean;
import java.util.Random;

public class UserBean
{
	private String username;
	private String userpass;
	
	public UserBean(){}
	
	public UserBean(String username,String userpass){
	      this.username = username;
	      this.userpass = userpass;
	   }
	 
	public void setUsername(String username){
	      this.username = username;
	   }

   public String getUsername(){
      return username;
   }

   public void setUserpass(String userpass){
      this.userpass = userpass;
   }

   public String getUserpass(){
      return userpass;
   } 
   public boolean login(){
	  //maybe very complex 
	  return username.equals(userpass);
   }
   
   public boolean add(){
	   //add action simulations 
	   Random random = new Random(3);
	   int n = random.nextInt();
	   boolean success = false;
	   if(n != 1)
		   success = true;
	   
	   return success;
   }
   
}