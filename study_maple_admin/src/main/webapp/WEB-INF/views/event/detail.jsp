<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">

	var eventNo = '${param.seq}';

	$(function() {
		
		$("#even_stardate").datepicker({
	           dateFormat: 'yymmdd' //달력 날짜 형태
	           ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	           ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
	           ,changeYear: true //option값 년 선택 가능
	           ,changeMonth: true //option값  월 선택 가능                
	           ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
	           ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
	           ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
	           ,buttonText: "선택" //버튼 호버 텍스트              
	           ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
	           ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
	           ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
	           ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
	           ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
	           ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
	           ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	    });
		
		$("#even_enddate").datepicker({
	           dateFormat: 'yymmdd' //달력 날짜 형태
	           ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	           ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
	           ,changeYear: true //option값 년 선택 가능
	           ,changeMonth: true //option값  월 선택 가능                
	           ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
	           ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
	           ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
	           ,buttonText: "선택" //버튼 호버 텍스트              
	           ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
	           ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
	           ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
	           ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
	           ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
	           ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
	           ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	    });
		
		$("#summernote").summernote({
			height: 300, 
			minHeight: null, 
			maxHeight: null, 
			lang : 'ko-KR', 
			onImageUpload: function(files, editor, welEditable) {
				sendFile(files[0], editor, welEditable); 
			}
		});
		
		if (!commonjs.isEmpty(eventNo)) {
			getData();
		}
		
	})
			
	
	function getData() {
		$.ajax({
			type : "get",
			url : "/event/core/getInfo",
			data : {
				"eventno" : eventNo
			},
			cache : false,
			dataType : 'json',
			aync : false,
			success : function(data) {
				if (data.code == 200) {
					$("select[name=even_code]").val(data.obj.even_code).prop("selected", true);
					$("#even_name").val(data.obj.even_name);
					$("#even_stardate").val(data.obj.even_stardate);
					$("#even_enddate").val(data.obj.even_enddate);
					$("#summernote").summernote('code',data.obj.even_contents);
					$("#save-event").hide();
					$("#update-event").show();
				}
			},
			error : function(e) {
				alert("데이터 조회에 실패하였습니다.");
			}
		});
	}
	
	function saveData() {
		
		if (commonjs.isEmpty($("select[name=even_code]").val())) {
			$("select[name=even_code]").focus();
			alert("이벤트 타입을 선택 해 주세요");
			return;
		}
		
		if (commonjs.isEmpty($("#even_name").val())) {
			alert("이벤트명을 입력 해 주세요");
			$("#even_name").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#even_stardate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#even_enddate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_enddate").focus();
			return;
		}
		
		if (Number($("#even_stardate").val()) > Number($("#even_enddate").val())) {
			alert("이벤트 진행일을 확인 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		$.ajax({
			type : "POST",
			url : "/event/core/save",
			data : $("#eventForm").serialize(),
			cache : false,
			dataType : 'json',
			aync: false,
			success : function(data) {
				if (data.code == 200) {
					alert(data.message);
					location.href = "/event/list";
				}
			},
			error : function(error) {
				alert("이벤트 등록에 실패하였습니다.");
			}
		});
	}
	
	function updateData() {
		
		if (commonjs.isEmpty($("select[name=even_code]").val())) {
			$("select[name=even_code]").focus();
			alert("이벤트 타입을 선택 해 주세요");
			return;
		}
		
		if (commonjs.isEmpty($("#even_name").val())) {
			alert("이벤트명을 입력 해 주세요");
			$("#even_name").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#even_stardate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#even_enddate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_enddate").focus();
			return;
		}
		
		if (Number($("#even_stardate").val()) > Number($("#even_enddate").val())) {
			alert("이벤트 진행일을 확인 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		$.ajax({
			type : "POST",
			url : "/event/core/update",
			data : $("#eventForm").serialize(),
			cache : false,
			dataType : 'json',
			aync: false,
			success : function(data) {
				if (data.code == 200) {
					alert(data.message);
					location.reload();
				}
			},
			error : function(error) {
				alert("이벤트 등록에 실패하였습니다.");
			}
		});
	}
</script>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="../include/sideBar.jsp"/>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

				<jsp:include page="../include/header.jsp"/>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Event Regist</h1>
                    <br>

					<form class="user" id = "eventForm">
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
							<input type="hidden" value = "${param.seq }" name ="eventno"/>
								<select class =  "custom-select" name = "even_code">
									<option value = EV0101 selected>waiting</option>
									<option value = "EV0102">progress</option>
								</select>	
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="even_name" name="even_name" placeholder="even_name">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="even_stardate" placeholder="even_stardate" name="even_stardate">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="even_enddate" placeholder="even_enddate" name="even_enddate">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<textarea id = "summernote" name = "even_contents"></textarea>
							</div>
						</div>

						<a href="#" onclick="saveData();"
							class="btn btn-primary btn-user btn-block" id = "save-event">Save Event
						</a>
						<a href="#" onclick="updateData();"
							class="btn btn-primary btn-user btn-block" id = "update-event">update Event
						</a>
						<a href="/event/list"
							class="btn btn-primary btn-user btn-block">Back list
						</a>
					</form>

				</div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            
            <jsp:include page="../include/footer.jsp"/>
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

</body>

</html>