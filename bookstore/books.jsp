<%@ page contentType="text/html;charset=gb2312" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

   <tr>
      <td>
          <table align="center" border="1">
             <tr>
                <td>ͼ����</td><td>ͼ������</td><td>����</td><td>�۸�</td><td>������</td><td></td><td></td>
             </tr>
             <!--  c:forEach����ѭ�����ƣ�items����ָ��Ҫѭ�������ļ��ϣ�var����һ��ѭ����������ʾ�����е�һ��Ԫ�� -->
             <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bookid}</td>
                    <td>${book.bookname}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.publisher}</td>
                    <td> <a href="deleteBook?bookid=${book.bookid}">ɾ��</a> </td>
                    <td> <a href="findBookByID?bookid=${book.bookid}">�޸�</a> </td>
                </tr>
             </c:forEach>
          </table>
      </td>
   </tr>
</table>