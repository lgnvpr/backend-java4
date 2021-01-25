<%@page import="luongnvpk.helper._C"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	@charset "UTF-8";
.page{
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(90deg, rgba(223,80,87,1) 35%, rgba(255,86,53,1) 100%);
}

.frame{
    border: 1px solid #3333;
    padding : 50px;
    border-radius: 50px;
    background-color: white;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 500px;
}

input{
    padding : 15px;
    border : 1px solid #3333;
    border-radius: 15px;
    outline: none;
}

input:focus{
    border: 2px solid ;
    border: 2px solid rgba(223,80,87,1);
}

.title{
    font-size: 2rem;
}

.label-input{
    position: absolute;
    top : 0px;
    background-color: white;
    left: 30px;
    color : rgb(46, 46, 46);
}

.input{
    padding : 10px;
    position: relative;
}

.fr-button{
    display: flex;
    justify-content: center;
    align-items: center;
    padding : 10px;
}

button {
    padding : 15px;
    width: 100%;
    border-radius: 15px;
    outline: none;
    border: none;
    background-color: linear-gradient(90deg, rgba(223,80,87,1) 35%, rgba(255,86,53,1) 100%);
    cursor: pointer;
}
	
</style>
<link rel="stylesheet" href="http://localhost:8080/luongnvpk01506/view/login/login.css" type="text/css"/>
</head>
<body>
	<div class = "page">
        <form action="http://localhost:8080/luongnvpk01506/account/login" method="get">
        	<div class = "frame">
            <div>
                <h3  class = "title">Thông tin</h3>
            </div>
            <div class= "form" >
            	<div>
            		<h3>Tên đăng nhập</h3>
            		<label><%=request.getAttribute("username") %></label>
            	</div>
            	
            	<div>
            		<h3>Mẩt khẩu</h3>
            		<p><%=request.getAttribute("password") %></p>
            	</div>
            	
            	<div>
            		<h3>Quyền</h3>
            		<p><%=request.getAttribute("permission") %></p>
            	</div>
            	
                
            </div>
        </div>
        </form>
    </div>
</body>
</html>