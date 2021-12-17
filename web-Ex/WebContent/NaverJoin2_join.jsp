<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div id="">
        <!-- 스킵네비게이션 : 웹접근성대응 -->
        <div id="">
            <!-- a가 글자눌렀을 때 이동하는거 만들 때 사용하는거같음 -->
            <a href="#" onclick="">
                <span>본문으로 바로가기</span>
            </a>
        </div>
        <!-- 스킵네비게이션 -->
        <!-- header -->
        <div id="">
            <h1>
                <a href="http://www.naver.com">
                    <span>NAVER</span>
                </a>
            </h1>
        </div>
        <!-- //header -->
        <form id="" method="" action=""></form>
    </div>

    <br>
    <span>NAVER</span><br>
    <br>
    <span>Naver Sign Up</span><br>
    <br>
    <span>Username</span><br>
    <form action="">
        <p>
            <input type="email" required><span>@naver.com</span><br>
            <br>
            <span>password</span><br>
            <br>
            <input type="password" required><br>
            <br>
            <span>password Confirm</span><br>
            <br>
            <input type="password" required><span>설정하려는 비밀번호가 맞는지 확인하기 위해 다시 입력 해주</span><br>
            <br>
            <span>Name</span><br>
            <br>
            <input type="text" placeholder="First Name" required><br>
            <input type="text" placeholder="Last Name" required><br>
            <br>
            <span>DOB</span><br>
            <br>
            <input type="datetime"  required placeholder="Year(4dgt)" maxlength="4"><br>
            <select name="mm" id="sel"  required>
                <option value>Month</option>
                <option value="01">1</option>
                <option value="01">2</option>
                <option value="01">3</option>
                <option value="01">4</option>
                <option value="01">5</option>
                <option value="01">6</option>
                <option value="01">7</option>
                <option value="01">8</option>
                <option value="01">9</option>
                <option value="01">10</option>
                <option value="01">11</option>
                <option value="01">12</option>
            </select><br>
            <input type="datetime" required placeholder="Day" maxlength="2"><br>
            <br>
            <span>Gender</span><br>
            <select name="gender" id="gender" required>
                <option value="man">남자</option>
                <option value="woamn">여자</option>
                <option value="N">선택안함</option>
            </select><br>
            <br>
            <span>Recovery E-mail(Option)</span><br>
            <br>
            <input type="email" required placeholder="Optional"><br>
            <br>
            <span>Mobile Phone</span><br>
            <br>
            <select name="contryNumber" id="contryNumber" required>
                <option value="82">대한민국</option>
                <option value="1">미국</option>
                <option value="61">호주</option>
            </select><br>
            <input type="number" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required placeholder="Enter Phone Number">
            <a href="#">
                <span>Send Code</span>
            </a><br>
            <input type="number" required placeholder="Enter verification code"><span>인증받은 후 인증번호를 입력해야 합니다.</span><br>

            <button type="button">
                <span>Sign Up</span>
            </button>
            <a href="#">
                <span>naver</span>    
            </a>
            <span> Copyright C </span>
            <a href="#">
                <span>NAVER Corp. </span>
            </a>
            <span>All Rights Reserved.</span>
            
        </p>
    </form>
</body>
</html>