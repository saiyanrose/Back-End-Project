<%@ page import="java.util.*" %>
<%@ page import="java.sql.* " %>
<%@page import="com.entity.*"%>
<jsp:include page="/includes/header.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);

String username=null,sessionId=null;
Cookie[] cookies=request.getCookies();

//session
if(request.getSession().getAttribute("username")==null){
	
	response.sendRedirect("AdminLogin.jsp");
	
}else{
	
	username=request.getSession().getAttribute("username").toString();
	sessionId=request.getSession().getId();
}

%>

<%=username %>
<%=sessionId %>

    <!-- Page Wrapper -->
    <div id="wrapper">

<jsp:include page="/includes/sidebar.jsp" /> 
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                           
                            <!-- Dropdown - Alerts -->
                           
                        </li>

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                        
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=session.getAttribute("username") %></span>
                                <img class="img-profile rounded-circle"
                                    src="assets/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Assign Class For A Subject</h1>  
                        
                    </div>   
					<hr> 
<!-- --------------------------------Database------------------------------------------------------------ -->                     

<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/test";%>
<%!String user = "root";%>
<%!String psw = "";%>

			<form action="<%=request.getContextPath()%>/OperationController?action=subjectclass" method="post">
			<%
				Connection con = null;
				PreparedStatement ps = null;
				
				try
				{
					Class.forName(driverName);
					con = DriverManager.getConnection(url,user,psw);
					String sql = "SELECT * FROM subjects";
					ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery(); 
				%>
				Class Id: <input type="text" name="classid" value="${param.classid }" required><br>
				<p>Select Subject :
				<select name="sub">

				<%
				while(rs.next())
				{
				String subname = rs.getString("subject_name"); 
				%>

				<option value="<%=subname %>"><%=subname %></option>
				
				<%
				}
				%>	
				</select><br>
				</p>
				<input type="submit" value="Assign">
				<%
				}
				catch(SQLException sqe)
				{ 
				out.println(sqe);
				}
				%>
				</form>                 
                                             
               
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
           
<jsp:include page="/includes/footer.jsp" /> 
            