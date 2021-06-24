<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>
<script type="text/javascript">
	$(function() {
		//$("#dataTable_filter").remove();
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
                    <h1 class="h3 mb-2 text-gray-800">Event List</h1>
                    <br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Event No</th>
                                            <th>Event name</th>
                                            <th>Progress status</th>
                                            <th>Progress Time</th>
                                            <th>Registration Date</th>
                                            <th>Create Date</th>
                                        </tr>
                                    </thead>
                                    <tbody id = "tbody">
                                    	<c:forEach var = "list" items = "${eventList }">
                                    		<tr>
                                    		<td><a href = '/event/detail?seq=${list.even_op }'>${list.even_op }</a></td>
                                    		<td>${list.even_name }</td>
                                    		<c:choose>
                                    			<c:when test="${list.even_code eq 'EV0101'}">
                                    				<td>Wating</td>
                                    			</c:when>
                                    			<c:when test="${list.even_code eq 'EV0102'}">
                                    				<td>ongoing</td>
                                    			</c:when>
                                    			<c:when test="${list.even_code eq 'EV0103'}">
                                    				<td>end</td>
                                    			</c:when>
                                    		</c:choose>
                                    		<td>${list.even_stardate }</td>
                                    		<td>${list.even_enddate }</td>
                                    		<td>${list.createDate }</td>
                                    		</tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
					<a href="/event/detail" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        Create Event
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