<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T1 Community | Sign Up</title>
<style>
body { background: #0f0f0f; color: #fff; font-family: 'Pretendard', sans-serif; display:flex; justify-content:center; align-items:center; min-height:100vh; margin:0;}
.container { background:#1a1a1a; padding:40px; border-radius:15px; width:100%; max-width:500px; border:2px solid #E2012D;}
h1 { text-align:center; margin-bottom:30px; color:#C69C6D; }
input[type=text], input[type=password], input[type=email] { width:100%; padding:12px; margin-bottom:20px; border-radius:5px; border:1px solid #333; background:#0b0b0b; color:#fff;}
button { width:100%; padding:15px; border:none; border-radius:5px; background:#E2012D; color:#fff; font-weight:bold; cursor:pointer;}
button:hover { background:#ff1a4a; }
</style>
</head>
<body>
<div class="container">
    <h1>Sign Up</h1>
    <form action="/user/join" method="post">
        <input type="text" name="id" placeholder="ID" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="text" name="nickName" placeholder="Nick Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <button type="submit">회원가입</button>
    </form>
    <p style="text-align:center; margin-top:15px;"><a href="/user/loginForm" style="color:#E2012D;">로그인</a> 바로가기</p>
</div>
</body>
</html>
