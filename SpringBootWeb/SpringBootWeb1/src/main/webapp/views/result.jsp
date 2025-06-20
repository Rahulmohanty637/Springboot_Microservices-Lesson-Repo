<%@page language="java" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<head/>
 <body>
        <h2>Calculator</h2>
        <h2>Result is: <%= session.getAttribute("subres") %></h2>
        <h2>added result: ${result}</h2>

        <br/>

        <p>Alien : ${alien.aid}, ${alien.aname}</p>

 </body>
</html>