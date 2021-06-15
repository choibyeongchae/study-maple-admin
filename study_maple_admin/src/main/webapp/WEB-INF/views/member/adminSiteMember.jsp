<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">

$(function() {
	getList();
})

function getList() {
	$.ajax({
		type : "get",
		url : "/member/adminMemberList",
		cache : false,
		contentType : 'application/json',
		aync: false,
		success : function(data) {
			if (data.code == 200) {
				var list = data.obj;
				var tbodyList = "";
				for (var item of list) {
					tbodyList = "<tr>";
					tbodyList += "<td>"+item.mbr_name+"</td>";
					tbodyList += "<td>"+item.mbr_email+"</td>";
					tbodyList += "<td>"+item.mbr_phone+"</td>";
					tbodyList += "<td>"+item.mbr_role+"</td>";
					tbodyList += "<td>"+item.createDate+"</td>";
					tbodyList += "</tr>";
				}
				$("#tbody").html(tbodyList);
			}
		},
		error : function(jqXHR, status, e) {
			alert('회원조회에 실패하였습니다.');
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
                    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Birth</th>
                                            <th>Role</th>
                                            <th>CreateDate</th>
                                        </tr>
                                    </thead>
                                    <tbody id = "tbody">
                                    	<c:forEach var = "list" items = "${adminMemberList }">
                                    		<td>${list.mbr_name }</td>
                                    		<td>${list.mbr_email }</td>
                                    		<td>${list.mbr_born }</td>
                                    		<td>${list.mbr_role }</td>
                                    		<td>${list.createDate }</td>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

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