<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="ext-4.2.1GPL/resources/css/ext-all.css"/>
    <script type="text/javascript" src="ext-4.2.1GPL/resources/ext-all-debug.js"></script>
	
	<title>Getting Started with Extjs</title>

	<script type="text/javascript">

	Ext.application({
	    name: 'HelloExt',
	    launch: function() {
	        Ext.create('Ext.container.Viewport', 
	        {
	            layout: 'fit',
	            items: [
	                {
	                    title: 'Hello Ext',
	                    html : 'Hello! Welcome to Ext JS.'
	                }
	            ]
	        });
	    }
	});
	</script>
	
</head>
<body>

</body>
</html>