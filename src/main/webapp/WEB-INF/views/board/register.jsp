<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">게시글 등록</div>
      <div class="card-body">



        <form role="form" action="regist" method="post" id="regform">
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name='title' id='title'>
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' id='content'></textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name='writer' id='writer'>
          </div>
          <button type="button" class="btn btn-primary" onClick="register()">등록</button>
          <button type="button" class="btn btn-primary" >취소</button>
          <!-- 
          <button type="submit" class="btn btn-primary">등록</button>
          <button type="button" class="btn btn-primary">취소</button> -->
        </form>



      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->
<%@ include file="../include/footer.jsp" %>
<script>
	function register(){
		//jquery, 선택자를 통해 태그에 접근가능 $("#아이디")
		//var a = $("#title").val();
		//alert(a);
		/*
		if($("#title").val() == ""){
			//alert("제목을 입력하세요")
			$("#myModal").modal("show");
		}else if($("#content").val() == ""){
			//alert("내용을 입력하세요")
			$("#myModal").modal("show");
		}else if($("#writer").val() == ""){
			//alert("작성자를 입력하세요")
			$("#myModal").modal("show");
		}else{
			$("#regform").submit();
		}
		*/
		$("#regform").submit();
	}
</script>
<!-- 모달창, 화면에 미리 만들어놓고 숨겨놓은 다음 호출해서 사용하는 형태로 동작 -->
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">필수 사항</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          	모든 항목을 입력하세요
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  


</body>
</html>