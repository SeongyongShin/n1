<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<input type=text name=apple id=apple value=하이/><br>
	<input type=text name=melon id=melon value=바이/><br>
	<input type=text name=peach id=peach value=바바/><br>
	<button type=button onclick=check()>확인</button>	


 <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
	//1. 사용자 정의합수 check()를 만든다.
	//2. check() 메서드 안의 applem, melon, peach 의 값 저장
	//3. 비동기통신을 할 수 있는 메서드를 작성해서 실행을 시킨다. 값을 컨트롤러 안에서 출력 
	//4. 형식 {"key":값,"key":값}
		 function check(){
		  		var apple = $("#apple").val();
		  		var melon = $("#melon").val();
		  		var peach = $("#peach").val();
					//비동기 통신을 사용해서 memberController로 요청을 보냄		
					$.ajax({
						type : "post",
						url : "check",
						data : {"apple": apple, "melon": melon, "peach": peach},
						success : function(result){ //ajax 통신에 성공했을 떄 호출될 자바스크립트 함수, result에는 실행결과가 매개변수로 들어감
							alert(result);
						}
					});}
</script>
</body>
</html>