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

<script type="text/javascript">

$(document).ready(function()
	{

    $('#menu a').each(function()
    {
        id = $(this).attr('href');
        id = id.substring(id.lastIndexOf('/'));
        id = id.substring(0,id.indexOf('.'));
        $(this).attr('rel',id);
    });
    $('#home').show();
    $('#menu a').click( function(e)
    {
        e.preventDefault();
        $('.content').hide();
        $('#'+$(this).attr('rel')).show();
        location.hash = '#!/'+$(this).attr('rel');
        return false;
    });
});

</script>
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
	    	 System.out.println(userName);
	    	}
	    if(cookie.getName().equals("JSESSIONID")) 
	    	{
	    	sessionID = cookie.getValue();
	    	System.out.println(sessionID);
	    	}
	}
}
%>

<%-- <h3>Hi, Login successful. Your Session ID=<%=sessionID %></h3> --%>
<h3>Hello  <%=userName %>. Welcome to Training Partner System</h3>
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
			<div class="container">
			<jsp:useBean id="obj" class="com.trainingpartner.lists.AllDiaries" scope="page"/>
			<select class="form-control" placeholder=".input-medium" height>
			    <c:forEach var="item" items="${obj.items}">
			     <option>${item}</option>
			    </c:forEach>
			</select>
				<!-- <table class="table table-bordered">
				        <thead>
				          <tr>
				            <th></th>
				            <th>Diary Data</th>
				          </tr>
				        </thead>
				        <tbody>
				          <tr>
				            First Column
				            <td rowspan="2">
				            	   Default buttons with dropdown menu
						        <div class="btn-group">
						            <button data-toggle="dropdown" class="btn btn-default dropdown-toggle">Select existing diary<span class="caret"></span></button>
						            <ul class="dropdown-menu">
						                <li class="divider"></li>
						                <li><a href="#">Separated link</a></li>
						            </ul>
						        </div>
				            </td>
				            End of first column
				            <td>Mark</td>
				          </tr>
   
				        </tbody>
			      </table> -->
			</div>
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