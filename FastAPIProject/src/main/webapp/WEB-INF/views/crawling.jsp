<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron text-center">
	  <h1>데이터분석 SW엔지니어 양성과정</h1>
	  <p>스프링부트를 사용하여, 간단한 게시판을 만들어보자</p>
	</div>
	
	<div class="container">
		<div class="panel panel-default">
		  <div class="panel-heading">데이터분석과정 게시판</div>
		  <div class="panel-body">
			  	<table class="table table-bordered table-striped">
			  		<tr>
			  			<th>수집하고 싶은 데이터 검색</th>
			  			<td>
			  				<input id="data" class="form-control" type="text"/>
			  			</td>
			  		</tr>		
			  		
			  		<tr>
			  			<td colspan="2">
			  				<button class="btn btn-primary btn-sm">요청하기</button>
			  			</td>
			  		</tr>
			  		<tr>
			  			<td colspan="2" id = "img_content">
			  			
			  			</td>
			  		</tr>		  				  						  		
			  	</table>		  	
		  </div>
		</div>
	</div>
<script>
  // 1. 버튼을 클릭하면
  $("button").on("click", function () {
    // 2. input 태그에 입력한 데이터를 가지고 와서
    let data = $("#data").val();
    console.log("입력값:", data);

    // 3. 비동기 통신으로 python쪽에 요청을 보내기
    $.ajax({
      url: "http://127.0.0.1:8000/temp",
      data: { sendData: data },
      success: (res) => {
        console.log("성공", res); // 4. 성공했다면, 응답을 콘솔에 찍기
        let src = res.img_src;
        // jsp 파일에서 벡틱 사용할 때 역슬래시로 el 표현식을 한번 스킵
        // .java -> .class -> .html
        let img = `<img src='\${src}'>`
        $("#img_content").append(img);
      },
      error: (e) => {
        console.error("에러", e);
      }
    });
  });
</script>
</body>
</html>