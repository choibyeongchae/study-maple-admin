<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Bootstrap core JavaScript-->
    <script src="/static/vendor/jquery/jquery.min.js"></script>
    <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/static/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/static/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/static/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/static/js/demo/chart-area-demo.js"></script>
    <script src="/static/js/demo/chart-pie-demo.js"></script>
    <script src="/static/js/common.js"></script>
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		var path = location.pathname;
		var userInfo = '${userInfo}';
		var commonjs = new Commonjs();
		if (commonjs.isEmpty(userInfo)) {
			if (path != "/member/member_login") {
				location.href="/member/member_login";
			}
		}
		console.log(userInfo);
	})
</script>
</head>
</html>