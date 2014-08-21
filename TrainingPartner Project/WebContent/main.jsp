<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Training Partner !</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.js"></script>
<script type="text/javascript" src="js/TrainingPartnerScripts.js"></script>

<style type="text/css">
    .bs-example
    {
    	margin: 20px;
    }
    .content 
    {
    display: none;
	}
</style>
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null)
{
    response.sendRedirect("/TrainingPartnerProject/loginError.jsp");
}
else 	
user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null)
{
	for(Cookie cookie : cookies)
	{
	    if(cookie.getName().equals("user")) 
	    	{
	    	 userName = cookie.getValue();
	    	}
	    if(cookie.getName().equals("JSESSIONID")) 
	    	{
	    	sessionID = cookie.getValue();
	    	}
	}
}
%>

<%-- <h3>Hi, Login successful. Your Session ID=<%=sessionID %></h3> --%>
<h3 id="name_header">Hello <%=userName %></h3>
<%-- <br>
User=<%=user %> --%>
<br>

<div class="bs-example">
    <div class="panel panel-default">
        <!-- Begin of  main Panel-->
        <div class="panel-body">
        
        <nav class="navbar navbar-default" role="navigation">
				  <div class="container-fluid">
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div id="menu" class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				  		 <li>
				  			 <a href="home.html">Training Diaries</a>
				  		 </li>
				        <li>
				       		 <a href="one.html">Training Programs</a>
				        </li>
				         <li>
				       		 <a href="two.html">Trainings</a>
				        </li>
						 <li>
				       		 <a href="three.html">Account Data</a>
				        </li>

				      </ul>
			
				    </div><!-- /.navbar-collapse -->
				   
				  </div><!-- /.container-fluid -->
		</nav>
         <!-- Contents of Navigation Panel -->
     	 
       		 <div id="home" class="content">
			  <div class="panel-group" id="accordion">
				  <div class="panel panel-default">
				    <div class="panel-heading">
				      <h4 class="panel-title">
				        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
				          Create new diary
				        </a><i class="indicator glyphicon glyphicon-chevron-up  pull-right"></i>
				      </h4>
				    </div>
				    <div id="collapseTwo" class="panel-collapse collapse">
				      <div class="panel-body">
				   <!-- Begin of 'Save new diary' form -->
				    			  <form class="form col-md-12 center-block" action="SaveDiary" method="post">
						            
							            <div class="form-group">
							            Diary Name
							              <input type="text" name="diaryName" class="form-control input-lg" placeholder="Diary Name">
							            </div>
							            
							            <div class="form-group">
							            Diary Creation Date (RRRR-MM-DD)
							              <input type="text" name="diaryCreationDate" class="form-control input-lg" id="date" placeholder="Diary Creation Date (RRRR-MM-DD)">
							            </div>
							               
							            <div class="form-group">
							            Diary Description
							              <input type="text" name="diaryDescription" class="form-control input-lg" placeholder="Diary Description">
							            </div>
							            
							            <div class="form-group">
							            Diary Author
							              <input type="text" name="diaryCreator" class="form-control input-lg" id="author" placeholder="Diary Author">
							            </div>
							  
						            <div class="form-group">
						              <button class="btn btn-primary btn-lg btn-block" >Save new training diary</button> 
						            </div>
						            
					     		 </form>
				 <!-- End of 'Save new diary' form -->
				  
				      </div>
				    </div>
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading">
				      <h4 class="panel-title">
				        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
				          Edit existing diary content
				        </a><i class="indicator glyphicon glyphicon-chevron-up pull-right"></i>
				      </h4>
				    </div>
				    <div id="collapseThree" class="panel-collapse collapse">
				      <div class="panel-body">
				        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				      </div>
				    </div>
				  </div>
				</div> 
				All diaries table
			</div>
			
			<div id="one" class="content">
						    Content 2.
			</div> 
			<div id="two" class="content">
						    Content 3.
			</div> 
			<div id="three" class="content">
						    Content 4.
			</div> 
			
		
		<!-- End of ontents of Navigation Panel -->
        </div> 
        <!-- End of main Panel -->
		<!--Footer of main Panel with logout button  -->       
        <div class="panel-footer clearfix">
            <div class="pull-right">
            <form action="LogoutServlet" method="post">
				<input class="btn btn-primary" type="submit" value="Logout" >
			</form>
           <!--      <a href="#" class="btn btn-primary">Learn More</a>
                <a href="#" class="btn btn-default">Go Back</a> -->
            </div>
        </div>
        <!--End of footer Panel -->
    </div>
</div>

</body>
</html>