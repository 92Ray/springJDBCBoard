<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
body { background:#0f0f0f; color:#fff; font-family:'Pretendard',sans-serif; display:flex; justify-content:center; align-items:center; min-height:100vh; margin:0;}
.container { text-align:center; }
a { color:#E2012D; text-decoration:none; font-weight:bold; }
a:hover { color:#ff1a4a; }
</style>
</head>
<body>
<div class="container">
    <h1>성공!</h1>
    <p>${message}</p>
    <p><a href="/board/boardlist">게시판으로 이동</a></p>
</div>
</body>
</html>
