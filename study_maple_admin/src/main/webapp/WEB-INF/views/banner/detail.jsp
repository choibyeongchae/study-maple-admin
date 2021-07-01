<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">

	var bennerNo = '${param.seq}';

	$(function() {
		
		$("#benner_stardate").datepicker({
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
		
		$("#benner_endate").datepicker({
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
		
		if (!commonjs.isEmpty(bennerNo)) {
			getData();
		}
		
	})
			
	
	function getData() {
		$.ajax({
			type : "get",
			url : "/banner/core/getInfo",
			data : {
				"bannerNo" : bennerNo
			},
			cache : false,
			dataType : 'json',
			aync : false,
			success : function(data) {
				if (data.code == 200) {
					$("select[name=banner_restype]").val(data.obj.banner_restype).prop("selected", true);
					$("select[name=benner_type]").val(data.obj.benner_type).prop("selected", true);
					$("#benner_title").val(data.obj.benner_title);
					$("#benner_stardate").val(data.obj.benner_stardate);
					$("#benner_endate").val(data.obj.benner_endate);
					$("#imgnm").text(data.obj.benner_imagenm);
					$("input[name=imgnm]").val(data.obj.benner_imagenm);
					$("#imglink").attr("href","/static/upload/"+data.obj.benner_imagenm);
					$("#save-banner").hide();
					$("#update-banner").show();
				}
			},
			error : function(e) {
				alert("데이터 조회에 실패하였습니다.");
			}
		});
	}
	
	function saveData() {
		
		if (commonjs.isEmpty($("select[name=banner_restype]").val())) {
			$("select[name=even_code]").focus();
			alert("이벤트 타입을 선택 해 주세요");
			return;
		}
		
		if (commonjs.isEmpty($("#benner_title").val())) {
			alert("이벤트명을 입력 해 주세요");
			$("#even_name").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#benner_stardate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#benner_endate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_enddate").focus();
			return;
		}
		
		if (Number($("#benner_stardate").val()) > Number($("#benner_endate").val())) {
			alert("이벤트 진행일을 확인 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#benner_image").val())) {
			alert("파일을 선택 해 주세요");
			return;
		}
		
		var formData = new FormData($("#bannerForm")[0]);
		
		$.ajax({
			type : "POST",
			enctype: 'multipart/form-data',
			url : "/banner/core/save",
			data : formData,
			cache : false,
		    processData: false,    // 반드시 작성
		    contentType: false,
			aync: false,
			success : function(data) {
				if (data.code == 200) {
					alert(data.message);
					location.href = "/banner/list";
				}
			},
			error : function(error) {
				alert("배너 등록에 실패하였습니다.");
			}
		});
	}
	
	function updateData() {
		
		if (commonjs.isEmpty($("select[name=banner_restype]").val())) {
			$("select[name=even_code]").focus();
			alert("이벤트 타입을 선택 해 주세요");
			return;
		}
		
		if (commonjs.isEmpty($("#benner_title").val())) {
			alert("이벤트명을 입력 해 주세요");
			$("#even_name").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#benner_stardate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		if (commonjs.isEmpty($("#benner_endate").val())) {
			alert("이벤트 시작일을 선택 해 주세요");
			$("#even_enddate").focus();
			return;
		}
		
		if (Number($("#benner_stardate").val()) > Number($("#benner_endate").val())) {
			alert("이벤트 진행일을 확인 해 주세요");
			$("#even_stardate").focus();
			return;
		}
		
		var formData = new FormData($("#bannerForm")[0]);
		
		$.ajax({
			type : "POST",
			enctype: 'multipart/form-data',
			url : "/banner/core/update",
			data : formData,
			cache : false,
		    processData: false,    // 반드시 작성
		    contentType: false,
			aync: false,
			success : function(data) {
				if (data.code == 200) {
					alert(data.message);
					location.reload();
				}
			},
			error : function(error) {
				alert("배너 수정에 실패하였습니다.");
			}
		});
	}
	
	function fileSelect() {
		$("input[name=imgnm]").val("");
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
                    <h1 class="h3 mb-2 text-gray-800">Banner Regist</h1>
                    <br>

					<form class="user" id = "bannerForm">
					 	<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
							<input type="hidden" value = "${param.seq }" name ="bannerno"/>
							<input type="hidden" value = "" name = "imgnm" />
							<input type="hidden" value = "" name = "checkimage" />
								<select class =  "custom-select" name = "banner_restype">
									<option value = "RS" selected>reserve</option>
									<option value = "OG">ongoing</option>
								</select>	
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<select class =  "custom-select" name = "benner_type">
									<option value = "image" selected>image</option>
									<option value = "video">video</option>
								</select>	
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="benner_title" name="benner_title" placeholder="benner_title">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="benner_stardate" placeholder="benner_stardate" name="benner_stardate">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="benner_endate" placeholder="benner_endate" name="benner_endate">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="file" class="form-control form-control-user"
									id="benner_image" placeholder="benner_image" name="benner_image" onchange='fileSelect()' />
								<a href = "#" id = "imglink"><span id = "imgnm"></span></a>
							</div>
						</div>

						<a href="#" onclick="saveData();"
							class="btn btn-primary btn-user btn-block" id = "save-banner">Save Banner
						</a>
						<a href="#" onclick="updateData();"
							class="btn btn-primary btn-user btn-block" id = "update-banner" style = "display : none;">Update Banner
						</a>
						<a href="/banner/list"
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