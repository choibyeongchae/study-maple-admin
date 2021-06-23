<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">
	var boardSeq = '${param.seq}';
	$(function() {
		
		$("#summernote").summernote({
			height: 300, 
			minHeight: null, 
			maxHeight: null, 
			lang : 'ko-KR', 
			onImageUpload: function(files, editor, welEditable) {
				sendFile(files[0], editor, welEditable); 
			}
		});
		
		if (!commonjs.isEmpty(boardSeq)) {
			getData();
		}
	})
	
	function getData() {
		$.ajax({
			type : "get",
			url : "/board/core/noticeDetail",
			data : {
				"boardSeq" : boardSeq
			},
			cache : false,
			dataType : 'json',
			aync : false,
			success : function(data) {
				if (data.code == 200) {
					$("#boader_title").val(data.obj.boader_title);
					$("#summernote").summernote('code',data.obj.boader_contents);
					$("#board-save-btn").hide();
					$("#board-update-btn").show();
				}
			},
			error : function(e) {
				alert("데이터 조회에 실패하였습니다.");
			}
		});
	}
	
	function saveData() {
		
		if (commonjs.isEmpty($("#boader_title").val())) {
			$("#boader_title").focus();
			alert("공지사항 제목을 입력 해 주세요");
			return false;
		}
		
		$.ajax({
			type : "POST",
			url : "/board/core/save",
			data : $("#boardForm").serialize(),
			cache : false,
			dataType : 'json',
			aync: false,
			success : function(data) {
				if (data.code == 200) {
					alert(data.message);
					location.href = "/board/list";
				}
			},
			error : function(error) {
				alert("공지사항 등록에 실패하였습니다.");
			}
		});
	}
	
	function updateData() {
		
		if (commonjs.isEmpty($("#boader_title").val())) {
			$("#boader_title").focus();
			alert("공지사항 제목을 입력 해 주세요");
			return false;
		}
		
		$.ajax({
			type : "POST",
			url : "/board/core/update",
			data : $("#boardForm").serialize(),
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
				alert("공지사항 수정에 실패하였습니다.");
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
                    <h1 class="h3 mb-2 text-gray-800">Notice Regist</h1>
                    <br>

					<form class="user" id = "boardForm">
						<input type = "hidden" name = "boader_seq" value = "${param.seq }" />
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="boader_title" placeholder="boader_title" name="boader_title">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<textarea id = "summernote" name = "boader_contents" ></textarea>
							</div>
						</div>

						<a href="#" onclick="saveData();"
							class="btn btn-primary btn-user btn-block" id = "board-save-btn">Save Notice
						</a>
						
						<a href="#" onclick="updateData();"
							class="btn btn-primary btn-user btn-block" id = "board-update-btn" style = "display:none;">update Notice
						</a>
						
						<a href="/board/list"
							class="btn btn-primary btn-user btn-block" id = "board-update-btn">Go list
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