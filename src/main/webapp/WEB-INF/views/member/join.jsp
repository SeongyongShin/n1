<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Register</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
              <div class="col-lg-3"></div>
              
              <div class="col-lg-6">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
              </div>
              
              
              <!-- 자바스크립트(제이쿼리) 를 사용하기전에 input 태그의 id속성을 확인하세요. -->
              <form class="user" action="joinForm" method="post" id="regForm">
                <!-- 아이디 -->
                <div class="form-group row">
                  <div class="col-sm-8 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" placeholder="아이디" name="id" id="id">
                  </div>
                  <div class="col-sm-4">
                  	<input type="button" class="btn btn-primary btn-user btn-block" value="중복체크" onclick="idCheck()">
                  </div>
                </div>
                
                <!-- 이름 -->
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" placeholder="이름" name="name" id="name">
                </div>
                
                <!-- 비밀번호 -->
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" placeholder="비밀번호" name="pw" id="pw">
                  </div>
                </div>
                
                <!-- 비밀번호 확인 -->
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" placeholder="비밀번호체크" id="pwCheck">
                  </div>
                </div>
				
				<input type="button" class="btn btn-primary btn-user btn-user btn-block" value="회원가입" onclick="joinCheck()">
               
              </form>
                           
              <hr>
              <div class="text-center">
                <a class="small" href="/MyWeb">메인으로</a><!-- 절대경로 -->
              </div>
              <div class="text-center">
                <a class="small" href="${pageContext.request.contextPath}/member/login">로그인</a>
              </div>
              <div class="col-lg-3"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- 여기에 스크립트를 작성합니다 -->
  <script type="text/javascript">
  	function idCheck(){
  		var id = $("#id").val();
  		//alert(id);
  		if(id.length < 4){
  			alert("4글자 이상 입력하세요")
  		}else{
			//비동기 통신을 사용해서 memberController로 요청을 보냄		
			$.ajax({
				type : "post",
				url : "checkId",
				data : {"id": id},
				success : function(result){ //ajax 통신에 성공했을 떄 호출될 자바스크립트 함수, result에는 실행결과가 매개변수로 들어감
					
					if(result == 1){
						alert("이미 존재하는 아이디입니다.");
					}else{
						alert("사용가능한 아이디입니다.");
						$("#id").attr("readonly",true); //attr : 속성, 변경할값 함수는 내부속성을 변경하는 함수
					}
				}
			});
  		}
  	}
  	
  	//회원가입 체크 
  	function joinCheck(){
  		//if($("#id").attr("readonly"))
  		var a = $("#id").attr("readonly")
  		var b = $("#name").val().length;
  		var c = $("#pw").val();
  		var d = $("#pwCheck").val();
  		
  		if(!a){alert("아이디 중복체크를 확인하세요");}
  		else if(b < 1){alert("이름을 입력하세요");}
  		else if(c.length < 4 ){alert("비밀번호는 4 글자 이상이어야합니다.");}
  		else if(c != d){
  			alert("두 비밀번호가 일치하지 않습니다.");
  			$("#pwCheck").focus();
  		}
  		else if(confirm("회원가입 하시겠습니까?")){ // 확인 : true 아니요 : false
  			$("#regForm").submit();
  		}
  	}
  </script>
  
  
  
  
  
  
  
  
  
  
  
    
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

</body>
</html>
    