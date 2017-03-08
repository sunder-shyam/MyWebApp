<html>
<body>
<form action="login">
Username : <input type="text" name="uname">
Password : <input type="password" name="pwd">
<%String target=request.getParameter("target"); %>
 <%if(target != null && target.length() != 0){
    out.print("<input type=hidden name=target value="+target+">");   
   }
   %>  

<input type="submit">
</form>
</body>
</html>
