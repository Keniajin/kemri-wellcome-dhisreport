<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="en-gb">
<head>
	<tiles:insertAttribute name="meta" />
	<title>
		<tiles:insertAttribute name="title" />
	</title>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="common-scripts" />
</head>
<body class="nobg" data-loading-translation="Loading" data-content-width="2" data-blocks-animation="1" data-mobile-width="480" data-tablet-width="800">
	<script type="text/javascript">
		var prefix = "${prefix}";
		var context = "${context}";
	</script>
	<div id="mainWrapper">
		<!-- header logo etc -->
		
        <header>
        	<div id="header">
        		<img src="<c:url value="/resources/images/logo.png"/>" alt="KEMRI/Wellcome Trust Programme Logo" />
        	</div>        	       	
        </header>
         <!-- end header -->  
         <!-- navigation -->   
         <nav>
        	<tiles:insertAttribute name="menu" />
        </nav> 
        <!-- end navigation -->   
         <!-- start container -->
		<section style="margin-top:90px;">
			<!-- Start content -->
			<div id="content">
           		<tiles:insertAttribute name="content" />
           	</div>
			<!-- End content -->
		</section>
		<!-- end container -->	
		<!-- footer -->
	     <footer>
	     	<div id="footer">
	     		<a href="http://www.kemri-wellcome.org">&copy;2013 KEMRI/Wellcome Trust Programme</a>
	     	</div>
	     </footer>    
	     <!-- end footer --> 			
	</div>		
</body>
</html>