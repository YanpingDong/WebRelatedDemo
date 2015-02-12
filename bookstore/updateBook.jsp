<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
           <form action="updateBook" method="post" name="form1">
               <table align="center">
                  <tr> 
                      <td>图书编号：</td>
                      <td><input type="hidden" name="bookid" value="${book.bookid}">${book.bookid}</td>
                  </tr>
                  <tr>
                      <td>图书名：</td>
                      <td><input type="text" name="bookname" value="${book.bookname}"></td>
                  </tr>
                  <tr>
                      <td>作者：</td>
                      <td><input type="text" name="author"  value="${book.author}"></td>
                  </tr>
                  <tr>
                      <td>价格：</td>
                      <td><input type="text" name="price"  value="${book.price}"></td>
                  </tr>
                  <tr>
                      <td>出版社：</td>
                      <td><input type="text" name="publisher"  value="${book.publisher}"></td>
                  </tr>
                  <tr>
                      <td><input type="submit" value="提交"></td>
                      <td><input type="reset" value="重写"></td>
                  </tr>
               </table>
           </form>
      </td>
   </tr>
</table>