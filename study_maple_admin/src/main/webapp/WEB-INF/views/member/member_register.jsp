<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../include/head.jsp"/>

<script type="text/javascript">

	function signup() {
		var jsonObj = new Object();
		jsonObj.username = $("input[name='username']").val();
		jsonObj.userId = $("input[name='userId']").val();
		jsonObj.password = $("input[name='password']").val();
		jsonObj.tel = $("input[name='tel']").val();
		jsonObj.birth = $("input[name='birth']").val();
		jsonObj.zip = $("input[name='zip']").val();
		
		if (commonjs.isEmpty($("input[name='username']").val())) {
			alert("이름을 입력 해 주세요");
			$("input[name='username']").focus();
			return false;
		}
		
		if (commonjs.isEmpty($("input[name='userId']").val())) {
			alert("Id를 입력 해 주세요");
			$("input[name='userId']").focus();
			return false;
		}
		
		if (commonjs.isEmpty($("input[name='password']").val())) {
			alert("password를 입력 해 주세요");
			$("input[name='password']").focus();
			return false;
		}
		
		if (commonjs.isEmpty($("input[name='repassword']").val())) {
			alert("password 확인을 입력 해 주세요");
			$("input[name='repassword']").focus();
			return false;
		}
		
		if (commonjs.isEmpty($("input[name='tel']").val())) {
			alert("전화번호를 입력 해 주세요");
			$("input[name='tel']").focus();
			return false;
		}
		
		if (commonjs.isEmpty($("input[name='birth']").val())) {
			alert("생년월일을 입력 해 주세요");
			$("input[name='birth']").focus();
			return false;
		}
		
		if (commonjs.isEmpty($("input[name='zip']").val())) {
			alert("우편번호를 입력 해 주세요");
			$("input[name='zip']").focus();
			return false;
		}
		
		if (commonjs.isEmpty($("input[name='address']").val())) {
			alert("주소를 입력 해 주세요");
			$("input[name='address']").focus();
			return false;
		}
		
		if ($("input[name='password']").val() != $("input[name='repassword']").val()) {
			alert("password가 일치하지 않습니다.");
			$("input[name='repassword']").focus();
			return false;
		}
		
		$.ajax({
			type : "POST",
			url : "/member/signup",
			data : JSON.stringify(jsonObj),
			//data : $(".user").serialize(),
			cache : false,
			contentType : 'application/json',
			aync: false,
			success : function(data) {
				if (data.code == 200) {
					alert(data.message);
					location.href="/member/login";
				} else {
					alert('회원가입에 실패하였습니다.');
				}
			},
			error : function(jqXHR, status, e) {
				alert('회원가입에 실패하였습니다');
			}
		});
	}
</script>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name = "username" id="exampleFirstName"
                                            placeholder="Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        name = "userId" placeholder="Email Address">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Password" name = "password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="Repeat Password" name = "repassword">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Tel" name = "tel">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Birth" name = "birth">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="zip" name = "zip">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Address" name = "address">
                                </div>
                                <a href="#" onclick="signup();" class="btn btn-primary btn-user btn-block">
                                    Register Account
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="/member/member_login">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</body>

</html>