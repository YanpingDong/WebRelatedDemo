<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--��¼�������-->
                     <h2>post to servlet</h2>
                     <form action="login_process" method="post">
                        <!-- ��Ҫ���漰�ύ��Ϣ����Ҫ�õ�form��action�������ύ���ĸ��ļ����� -->
				                        �û�����<input type="text" name="username" value="aaa"> <br>
				                        ���<input type="password" name="userpass" value=""> <br> 
                        <input type="submit" value="��¼"><input type="reset" value="��д">
                     </form>
                 </td>
                 <td>
                      ��ӭ�������ǵ���꣡
                 </td>
             </tr>
             
             <tr>
                 <td>
                     <!--��¼�������-->
                     <h2>post to jsp</h2>
                     <form action="login_process.jsp" method="post">
                        <!-- ��Ҫ���漰�ύ��Ϣ����Ҫ�õ�form��action�������ύ���ĸ��ļ����� -->
				                        �û�����<input type="text" name="username" value="aaa"> <br>
				                        ���<input type="password" name="userpass" value=""> <br> 
                        <input type="submit" value="��¼"><input type="reset" value="��д">
                     </form>
                 </td>
                 <td>
                      ��ӭ�������ǵ���꣡
                 </td>
             </tr>
             <tr>
                 <td>
                     <!--��¼�������-->
                     <h2>add user</h2>
                     <form action="addUser" method="post">
                        <!-- ��Ҫ���漰�ύ��Ϣ����Ҫ�õ�form��action�������ύ���ĸ��ļ����� -->
				                        �û�����<input type="text" name="username" value="aaa"> <br>
				                        ���<input type="password" name="userpass" value=""> <br> 
                        <input type="submit" value="add"><input type="reset" value="��д">
                     </form>
                 </td>
                 <td>
                      ��ӭ�������ǵ���꣡
                 </td>
             </tr>  
         </table>
      </td>
   </tr>
</table>