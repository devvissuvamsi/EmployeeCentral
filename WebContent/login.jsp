<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Workforce Portal</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<div class="row">
		<div class="col-lg-3 col-md-2"></div>
		<div class="col-lg-6 col-md-8 login-box">
			<div class="col-lg-12 login-key">
				<i class="fa fa-key" aria-hidden="true"></i>
			</div>
			<div class="col-lg-12 login-title">WORKFORCE CENTRAL</div>

			<div class="col-lg-12 login-form">
				<div class="col-lg-12 login-form">
					<form action="login" method="post">
						<div class="form-group">
							<label class="form-control-label">USERNAME</label> <input
								type="text" name="username" class="form-control" required>
						</div>
						<div class="form-group">
							<label class="form-control-label">PASSWORD</label> <input
								type="password" name="userpass" class="form-control" i required>
						</div>

						<div class="col-lg-12 loginbttm">
							<div class="col-lg-6 login-btm login-text">
								<!-- Error Message -->
							</div>
							<div class="col-lg-6 login-btm login-button">
								<button type="submit" class="btn btn-outline-primary">LOGIN</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-lg-3 col-md-2"></div>
		</div>
	</div>
</body>
</html>