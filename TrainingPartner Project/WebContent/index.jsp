<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Traing Partner - Welcome !</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
	</head>
	<body>
<!--login modal-->

<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><!-- Some button  in the right corner--></button>
          <h1 class="text-center">Sign In to proceed further</h1>
      </div>
      <div class="modal-body">
          
       <!-- <form action="MainServlet" method="post">  
			Name:<input type="text" name="username"/><br/><br/>  
			Password:<input type="password" name="password"/><br/><br/>  
			<input type="submit" value="login"/>  
	   </form>   -->
      <form class="form col-md-12 center-block" action="MainServlet" method="post">
      
	            <div class="form-group">
	              <input type="text" name="username" class="form-control input-lg" placeholder="Email">
	            </div>
	            
	            <div class="form-group">
	              <input type="password" name="password" class="form-control input-lg" placeholder="Password">
	            </div>
	            
	            <div class="form-group">
	              <button class="btn btn-primary btn-lg btn-block" >Sign In</button> 
	            </div>
      </form>
          <span class="pull-right">
	            
	           </span>
          
      </div>
    
      <div class="modal-footer">
          <div class="col-md-12">
               <button class="btn btn-primary btn-lg btn-block" onclick="document.location.href='register.jsp'" >Register</button> 
                <br>  
        		<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
		  </div>	
      </div>
  </div>
  </div>
</div>
<!--end of login modal-->

	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>
	</body>
</html>