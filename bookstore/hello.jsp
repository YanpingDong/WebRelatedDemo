<%@ page contentType="text/html;charset=gb2312"%>
<!-- ����Ĵ��������ĵ����ͺͱ��뷽ʽ��ÿ��JSP�ļ������϶����� -->
<html>
   <head>
      <title>��һ��JSP����</title>
      
      <script language="javascript">
      function check(){
		      username = document.form.username.value;
		      if(username.length<6 || username.length>8){
		         alert("�û������Ȳ����ʣ�");
		         return false;
		      }else{
		         return true;
		      }
		   }
		</script>
   </head>

   <body>
      Hello,���Ϻã�
      <form name="form"action="Ŀ���ļ�" method="get|post">
       <input type="text" name="username" value="ֵ"/>
       <input type="password" name="����" value="ֵ"/>
       <input type="submit" value="ֵ"/>
        <input type="reset" value="ֵ"/>
        <input type="button" value="button" onClick="javascript:check()"/>
         <input type="radio" name="����" value="ֵ"/>
          <input type="radio" name="sex" value="1" checked>��</input>
        <input type="radio" name="sex" value="0">Ů</input>
        
        <textarea name="����" cols="����" rows="����">
     Ĭ��ֵ
   </textarea>
      </form>
   </body>   
</html>