<%@ page contentType="text/html;charset=gb2312"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
           <form action="updateBook" method="post" name="form1">
               <table align="center">
                  <tr> 
                      <td>ͼ���ţ�</td>
                      <td><input type="hidden" name="bookid" value="${book.bookid}">${book.bookid}</td>
                  </tr>
                  <tr>
                      <td>ͼ������</td>
                      <td><input type="text" name="bookname" value="${book.bookname}"></td>
                  </tr>
                  <tr>
                      <td>���ߣ�</td>
                      <td><input type="text" name="author"  value="${book.author}"></td>
                  </tr>
                  <tr>
                      <td>�۸�</td>
                      <td><input type="text" name="price"  value="${book.price}"></td>
                  </tr>
                  <tr>
                      <td>�����磺</td>
                      <td><input type="text" name="publisher"  value="${book.publisher}"></td>
                  </tr>
                  <tr>
                      <td><input type="submit" value="�ύ"></td>
                      <td><input type="reset" value="��д"></td>
                  </tr>
               </table>
           </form>
      </td>
   </tr>
</table>