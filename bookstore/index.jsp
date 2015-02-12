<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
         <table>
             <tr>
                 <td>
                     <!--登录界面代码-->
                     <h2>post to servlet</h2>
                     <form action="login_process" method="post">
                        <!-- 主要是涉及提交信息，就要用到form，action决定了提交给哪个文件处理 -->
				                        用户名：<input type="text" name="username" value="aaa"> <br>
				                        口令：<input type="password" name="userpass" value=""> <br> 
                        <input type="submit" value="登录"><input type="reset" value="重写">
                     </form>
                 </td>
                 <td>
                      欢迎光临我们的书店！
                 </td>
             </tr>
             
             <tr>
                 <td>
                     <!--登录界面代码-->
                     <h2>post to jsp</h2>
                     <form action="login_process.jsp" method="post">
                        <!-- 主要是涉及提交信息，就要用到form，action决定了提交给哪个文件处理 -->
				                        用户名：<input type="text" name="username" value="aaa"> <br>
				                        口令：<input type="password" name="userpass" value=""> <br> 
                        <input type="submit" value="登录"><input type="reset" value="重写">
                     </form>
                 </td>
                 <td>
                      欢迎光临我们的书店！
                 </td>
             </tr>
             <tr>
                 <td>
                     <!--登录界面代码-->
                     <h2>add user</h2>
                     <form action="addUser" method="post">
                        <!-- 主要是涉及提交信息，就要用到form，action决定了提交给哪个文件处理 -->
				                        用户名：<input type="text" name="username" value="aaa"> <br>
				                        口令：<input type="password" name="userpass" value=""> <br> 
                        <input type="submit" value="add"><input type="reset" value="重写">
                     </form>
                 </td>
                 <td>
                      欢迎光临我们的书店！
                 </td>
             </tr>  
         </table>
      </td>
   </tr>
</table>