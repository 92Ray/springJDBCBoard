<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T1 Community | Join the Roster</title>
<style>
    :root {
        --t1-red: #E2012D;
        --t1-black: #0f0f0f;
        --t1-gray: #1a1a1a;
        --t1-gold: #C69C6D;
        --t1-dark-red: #8b0000;
    }

    body {
        background-color: var(--t1-black);
        font-family: 'Pretendard', sans-serif;
        color: #ffffff;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
        /* 배경에 은은한 그리드 패턴으로 게이밍 감성 추가 */
        background-image: linear-gradient(rgba(226, 1, 45, 0.05) 1px, transparent 1px),
                          linear-gradient(90deg, rgba(226, 1, 45, 0.05) 1px, transparent 1px);
        background-size: 30px 30px;
    }

    .join-container {
        width: 100%;
        max-width: 450px;
        background: rgba(26, 26, 26, 0.95);
        padding: 50px 40px;
        border-radius: 20px;
        border: 2px solid var(--t1-red);
        box-shadow: 0 0 50px rgba(226, 1, 45, 0.3);
        position: relative;
    }

    /* 상단 장식 레이블 */
    .join-container::after {
        content: "NEW AGENT REGISTRATION";
        position: absolute;
        top: -12px;
        left: 50%;
        transform: translateX(-50%);
        background: var(--t1-red);
        padding: 2px 20px;
        font-size: 0.7rem;
        font-weight: bold;
        border-radius: 10px;
        letter-spacing: 2px;
    }

    .header {
        text-align: center;
        margin-bottom: 40px;
    }

    .header h1 {
        font-size: 2.2rem;
        font-weight: 900;
        margin: 0;
    }

    .header p {
        color: var(--t1-gold);
        font-size: 0.85rem;
        margin-top: 10px;
        letter-spacing: 1px;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-group label {
        display: block;
        font-size: 0.8rem;
        color: #888;
        margin-bottom: 8px;
        font-weight: bold;
    }

    input {
        width: 100%;
        padding: 14px 15px;
        background: #000;
        border: 1px solid #333;
        border-radius: 8px;
        color: #fff;
        font-size: 1rem;
        box-sizing: border-box;
        transition: 0.3s;
    }

    input:focus {
        border-color: var(--t1-red);
        outline: none;
        box-shadow: 0 0 10px rgba(226, 1, 45, 0.4);
    }

    /* 회원가입 버튼 */
    .btn-join {
        width: 100%;
        padding: 16px;
        background: linear-gradient(45deg, var(--t1-dark-red), var(--t1-red));
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 1.1rem;
        font-weight: 900;
        cursor: pointer;
        margin-top: 20px;
        transition: 0.3s;
        text-transform: uppercase;
    }

    .btn-join:hover {
        transform: scale(1.02);
        box-shadow: 0 0 20px rgba(226, 1, 45, 0.6);
    }

    .footer-links {
        margin-top: 25px;
        text-align: center;
        font-size: 0.85rem;
        color: #666;
    }

    .footer-links a {
        color: var(--t1-gold);
        text-decoration: none;
        margin-left: 10px;
    }
</style>
</head>
<body>

<div class="join-container">
    <div class="header">
        <h1>JOIN <span>T1</span></h1>
        <p>FOR THE UNSTOPPABLE ERA</p>
    </div>

    <form action="/user/join" method="post">
        <div class="form-group">
            <label for="id">AGENT ID</label>
            <input type="text" id="id" name="id" placeholder="사용할 아이디를 입력하세요" required>
        </div>

        <div class="form-group">
            <label for="password">ACCESS CODE</label>
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>
        </div>

        <div class="form-group">
            <label for="nickName">CODENAME (NICKNAME)</label>
            <input type="text" id="nickName" name="nickName" placeholder="활동할 닉네임을 입력하세요" required>
        </div>

        <div class="form-group">
            <label for="email">CONTACT EMAIL</label>
            <input type="email" id="email" name="email" placeholder="example@t1.gg" required>
        </div>

        <button type="submit" class="btn-join">Activate Account</button>
    </form>

    <div class="footer-links">
        Already have an account? <a href="/user/loginForm">Login</a>
    </div>
</div>

</body>
</html>