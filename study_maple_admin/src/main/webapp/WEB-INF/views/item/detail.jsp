<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">
var itemseq = '${param.seq}';
	$(function() {
		if (!commonjs.isEmpty(itemseq)) {
			getData();
		}
	})
	
	function getData() {

		$.ajax({
			type : "get",
			url : "/item/core/itemDetail",
			data : {
				"itemseq" : itemseq
			},
			cache : false,
			contentType : 'application/json',
			aync : false,
			success : function(data) {
				if (data.code == 200) {
					$("select[name=item_type]").val(data.obj.item_type).prop("selected", true);
	
					$("select[name=item_type]").attr('disabled',true);
					
					$("input[name=item_name]").val(data.obj.item_name);
	
					$("input[name=item_desc]").val(data.obj.item_desc);
	
					$("input[name=item_takelevel]").val(data.obj.item_takelevel);
	
					$("select[name=item_job]").val(data.obj.item_job).prop("selected", true);
	
					$("input[name=item_str]").val(data.obj.item_str);
	
					$("input[name=item_dex]").val(data.obj.item_dex);
	
					$("input[name=item_int]").val(data.obj.item_int);
	
					$("input[name=item_luk]").val(data.obj.item_luk);
	
					$("input[name=item_strapos]").val(data.obj.item_strapos);
	
					$("input[name=item_ficat]").val(data.obj.item_ficat);
	
					$("input[name=item_attack]").val(data.obj.item_attack);
	
					$("input[name=item_mattack]").val(data.obj.item_mattack);
	
					$("input[name=item_upgarde]").val(data.obj.item_upgarde);
	
					$("#btn-create").hide();
					$("#btn-update").show();
				}
			},
			error : function(e) {
				alert("데이터 조회에 실패하였습니다.");
			}
		});
	}

	function saveData() {

		if (commonjs.isEmpty($('select[name=item_type]').val())) {
			alert("아이템 타입을 선택 해 주세요!");
			$('select[name=item_type]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_name]').val())) {
			alert("아이템 이름을 입력 해 주세요");
			$('input[name=item_name]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_desc]').val())) {
			alert('아이템 설명을 입력 해 주세요');
			$('input[name=item_desc]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_takelevel]').val())) {
			alert('아이템 착용레벨을 입력 해 주세요');
			$('input[name=item_takelevel]').focus();
			return false;
		}

		if (commonjs.isNumber($('input[name=item_takelevel]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_takelevel]').focus();
			return false;
		}

		if (commonjs.isEmpty($('select[name=item_job]').val())) {
			alert('아이템 착용직업을 선택 해 주세요');
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_str]').val())) {
			alert('아이템 착용 최소 str을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_str]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_str]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_dex]').val())) {
			alert('아이템 착용 최소 dex을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_dex]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_dex]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_int]').val())) {
			alert('아이템 착용 최소 int을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_int]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_int]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_luk]').val())) {
			alert('아이템 착용 최소 luk을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_luk]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_luk]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_strapos]').val())) {
			alert('아이템 스타포스를 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_strapos]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_starpos]').focus();
			return false;
		}

		if ($('select[name=item_type]').val() == "Equipment") {
			if (commonjs.isEmpty($('input[name=item_ficat]').val())) {
				alert('아이템 ficat를 입력 해 주세요');
				return false;
			}
		}

		if (commonjs.isEmpty($('input[name=item_attack]').val())) {
			alert('아이템 공격력을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_attack]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_attack]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_mattack]').val())) {
			alert('아이템 마력을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_mattack]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_mattack]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_upgarde]').val())) {
			alert('아이템 강화수치를 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_upgarde]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_upgarde]').focus();
			return false;
		}

		$.ajax({
			type : "POST",
			url : "/item/core/saveItem",
			data : $("#itemForm").serialize(),
			cache : false,
			dataType : 'json',
			aync : false,
			success : function(data) {
				if (data.code == 200) {
					alert(data.message);
					location.href = "/item/list";
				}
			},
			error : function(error) {
				alert("아이템 생성에 실패하였습니다.");
			}
		});
	}

	function updateData() {

		if (commonjs.isEmpty($('select[name=item_type]').val())) {
			alert("아이템 타입을 선택 해 주세요!");
			$('select[name=item_type]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_name]').val())) {
			alert("아이템 이름을 입력 해 주세요");
			$('input[name=item_name]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_desc]').val())) {
			alert('아이템 설명을 입력 해 주세요');
			$('input[name=item_desc]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_takelevel]').val())) {
			alert('아이템 착용레벨을 입력 해 주세요');
			$('input[name=item_takelevel]').focus();
			return false;
		}

		if (commonjs.isNumber($('input[name=item_takelevel]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_takelevel]').focus();
			return false;
		}

		if (commonjs.isEmpty($('select[name=item_job]').val())) {
			alert('아이템 착용직업을 선택 해 주세요');
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_str]').val())) {
			alert('아이템 착용 최소 str을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_str]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_str]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_dex]').val())) {
			alert('아이템 착용 최소 dex을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_dex]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_dex]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_int]').val())) {
			alert('아이템 착용 최소 int을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_int]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_int]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_luk]').val())) {
			alert('아이템 착용 최소 luk을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_luk]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_luk]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_strapos]').val())) {
			alert('아이템 스타포스를 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_strapos]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_starpos]').focus();
			return false;
		}

		if ($('select[name=item_type]').val() == "Equipment") {
			if (commonjs.isEmpty($('input[name=item_ficat]').val())) {
				alert('아이템 ficat를 입력 해 주세요');
				return false;
			}
		}

		if (commonjs.isEmpty($('input[name=item_attack]').val())) {
			alert('아이템 공격력을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_attack]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_attack]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_mattack]').val())) {
			alert('아이템 마력을 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_mattack]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_mattack]').focus();
			return false;
		}

		if (commonjs.isEmpty($('input[name=item_upgarde]').val())) {
			alert('아이템 강화수치를 입력 해 주세요');
			return false;
		}

		if (commonjs.isNumber($('input[name=item_upgarde]').val())) {
			alert('숫자만 입력 해 주세요');
			$('input[name=item_upgarde]').focus();
			return false;
		}

		$.ajax({
			type : "POST",
			url : "/item/core/updateItem",
			data : $("#itemForm").serialize(),
			cache : false,
			dataType : 'json',
			aync : false,
			success : function(data) {
				if (data.code == 200) {
					alert("아이템 수정에 성공하였습니다.");
					location.reload();
				}
			},
			error : function(error) {
				alert("아이템 수정에 실패하였습니다.");
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
						<input type = "hidden" value = "${param.seq }" name = "item_seq" />
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
							class="btn btn-primary btn-user btn-block" id = "btn-create">Create Item
						</a>
						
						<a href="#" onclick="updateData();"
							class="btn btn-primary btn-user btn-block" id = "btn-update" style = "display : none;">Update Item
						</a>
						
						<a href="/item/list" class="btn btn-primary btn-user btn-block" id = "btn-list">back list
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