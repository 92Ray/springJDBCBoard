<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T1 Community | Update Info</title>
<style>
body { background:#0f0f0f; color:#fff; font-family:'Pretendard',sans-serif; display:flex; justify-content:center; align-items:center; min-height:100vh; margin:0;}
.container { background:#1a1a1a; padding:40px; border-radius:15px; width:100%; max-width:500px; border:2px solid #E2012D;}
h1 { text-align:center; margin-bottom:30px; color:#C69C6D; }
input[type=text], input[type=password], input[type=email] { width:100%; padding:12px; margin-bottom:20px; border-radius:5px; border:1px solid #333; background:#0b0b0b; color:#fff;}
button { width:100%; padding:15px; border:none; border-radius:5px; background:#E2012D; color:#fff; font-weight:bold; cursor:pointer;}
button:hover { background:#ff1a4a; }
</style>
</head>
<body>
<div class="container">
    <h1>회원정보 수정</h1>
    <form action="/user/update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <input type="password" name="password" placeholder="새 비밀번호 입력" required>
        <input type="text" name="nickName" placeholder="Nick Name" value="${user.nickName}" required>
        <input type="email" name="email" placeholder="Email" value="${user.email}" required>
        <button type="submit">정보 수정</button>
    </form>
</div>
</body>
</html>
