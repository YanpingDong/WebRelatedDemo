<%@ page contentType="text/html;charset=gb2312"%>
<!-- 上面的代码声明文档类型和编码方式，每个JSP文件基本上都会有 -->
<html>
   <head>
      <title>第一个JSP程序</title>
      
      <script language="javascript">
      function check(){
		      username = document.form.username.value;
		      if(username.length<6 || username.length>8){
		         alert("用户名长度不合适！");
		         return false;
		      }else{
		         return true;
		      }
		   }
		</script>
   </head>

   <body>
      Hello,晚上好！
      <form name="form"action="目标文件" method="get|post">
       <input type="text" name="username" value="值"/>
       <input type="password" name="名字" value="值"/>
       <input type="submit" value="值"/>
        <input type="reset" value="值"/>
        <input type="button" value="button" onClick="javascript:check()"/>
         <input type="radio" name="名字" value="值"/>
          <input type="radio" name="sex" value="1" checked>男</input>
        <input type="radio" name="sex" value="0">女</input>
        
        <textarea name="名字" cols="列数" rows="行数">
     默认值
   </textarea>
      </form>
   </body>   
</html>