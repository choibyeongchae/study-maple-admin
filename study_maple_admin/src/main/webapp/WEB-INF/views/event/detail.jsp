<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">
	$(function() {
		$("#even_stardate").datepicker();
		$("#even_enddate").datepicker();
		$("#summernote").summernote({
			height: 300, 
			minHeight: null, 
			maxHeight: null, 
			lang : 'ko-KR', 
			onImageUpload: function(files, editor, welEditable) {
				sendFile(files[0], editor, welEditable); 
			}
		});
	})
	
	function saveData() {
		$.ajax({
			type : "POST",
			url : "/event/core/saveEvent",
			data : $("#eventForm").serialize(),
			cache : false,
			contentType : 'application/json',
			aync: false,
			success : function(data) {
				if (data.code == 200) {
					
				}
			},
			error : function(error) {
				alert("아이템 생성에 실패하였습니다.");
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
								<select class =  "custom-select" name = "item_type">
									<option value = EV0101 selected>waiting</option>
									<option value = "EV0102">progress</option>
									<option value = "EV0103">other</option>
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
								<input type="text" class="form-control form-control-user"
									id="even_title" placeholder="even_title" name="even_title">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<textarea id = "summernote" ></textarea>
							</div>
						</div>

						<a href="#" onclick="saveData();"
							class="btn btn-primary btn-user btn-block">Save Event
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