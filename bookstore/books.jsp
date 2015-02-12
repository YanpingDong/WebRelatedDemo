<%@ page contentType="text/html;charset=gb2312" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
          <table align="center" border="1">
             <tr>
                <td>图书编号</td><td>图书名称</td><td>作者</td><td>价格</td><td>出版社</td><td></td><td></td>
             </tr>
             <!--  c:forEach用于循环控制，items属性指出要循环遍历的集合，var定义一个循环变量，表示集合中的一个元素 -->
             <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bookid}</td>
                    <td>${book.bookname}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.publisher}</td>
                    <td> <a href="deleteBook?bookid=${book.bookid}">删除</a> </td>
                    <td> <a href="findBookByID?bookid=${book.bookid}">修改</a> </td>
                </tr>
             </c:forEach>
          </table>
      </td>
   </tr>
</table>