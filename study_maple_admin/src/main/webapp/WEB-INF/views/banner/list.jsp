<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">
	$(function() {

	})
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
                    <h1 class="h3 mb-2 text-gray-800">Item List</h1>
                    <br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>Banner No</th>
                                            <th>Banner Type</th>
                                            <th>Banner Title</th>
                                            <th>Banner stardate</th>
                                            <th>Banner endate</th>
                                            <th>createDate</th>
                                        </tr>
                                    </thead>
                                    <tbody id = "tbody">
                                    	<c:forEach var = "list" items = "${bannerList }">
                                    		<tr>
	                                    		<td><a href = '/banner/detail?seq=${list.benner_seq }'>${list.benner_seq }</a></td>
	                                    		<td>${list.benner_type }</td>
	                                    		<td>${list.benner_title }</td>
	                                    		<td>${list.benner_stardate }</td>
	                                    		<td>${list.benner_endate }</td>
	                                    		<td>${list.createDate }</td>
                                    		</tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <a href="/banner/detail" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        Create Notice
                    </a>

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