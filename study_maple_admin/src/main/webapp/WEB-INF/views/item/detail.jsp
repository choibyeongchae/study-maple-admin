<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">
	$(function() {
		
	})
	
	function saveData() {
		$.ajax({
			type : "POST",
			url : "/item/core/saveItem",
			data : $("#itemForm").serialize(),
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
                    <h1 class="h3 mb-2 text-gray-800">Item Regist</h1>
                    <br>

					<form class="user" id = "itemForm">
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<select class =  "custom-select" name = "item_type">
									<option value = "Equipment" selected>Equipment</option>
									<option value = "Consumption">Consumption</option>
									<option value = "other">other</option>
								</select>	
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_name" name="item_name" placeholder="Item_name">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_desc" placeholder="Item_desc" name="item_desc">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_takelevel" placeholder="Item_takelevel" name="item_takelevel">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<select id = "item_job" class = 'custom-select' name = "item_job">
									<option value = "arms" selected>Arms</option>
									<option value = "wizard">Wizard</option>
									<option value = "archer">Archer</option>
									<option value ="thief">Thief</option>
								</select>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_str" placeholder="Item_str" name="item_str">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_dex" placeholder="Item_dex" name="item_dex">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_int" placeholder="Item_int" name="item_int">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_luk" placeholder="Item_luk" name="item_luk">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_strapos" placeholder="item_strapos" name="item_strapos">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_ficat" placeholder="Item_ficat" name="item_ficat">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_attack" placeholder="Item_attack" name="item_attack">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_mattack" placeholder="Item_mattack" name="item_mattack">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user"
									id="item_upgarde" placeholder="Item_upgarde" name="item_upgarde">
							</div>
						</div>
						
						<a href="#" onclick="saveData();"
							class="btn btn-primary btn-user btn-block">Create Item
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