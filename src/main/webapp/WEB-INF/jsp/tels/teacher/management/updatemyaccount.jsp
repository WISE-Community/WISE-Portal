<%@ include file="../include.jsp" %> 

<!--
  * Copyright (c) 2006 Encore Research Group, University of Toronto
  * 
  * This library is free software; you can redistribute it and/or
  * modify it under the terms of the GNU Lesser General Public
  * License as published by the Free Software Foundation; either
  * version 2.1 of the License, or (at your option) any later version.
  *
  * This library is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  * Lesser General Public License for more details.
  *
  * You should have received a copy of the GNU Lesser General Public
  * License along with this library; if not, write to the Free Software
  * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
-->

<!-- $Id: overview.jsp 997 2007-09-05 16:52:39Z archana $ -->

<!DOCTYPE html>

<html lang="en">
<head>

<link href="<spring:theme code="globalstyles"/>" media="screen" rel="stylesheet"  type="text/css" />
<link href="<spring:theme code="stylesheet"/>" media="screen" rel="stylesheet"  type="text/css" />
<link href="<spring:theme code="teacherprojectstylesheet" />" media="screen" rel="stylesheet" type="text/css" />

<title><spring:message code="teacher.management.updatemyaccount.title"/></title>
</head>

<body>

<div id="pageWrapper">

	<%@ include file="../headerteacher.jsp"%>
	
	<div id="page">
			
		<div id="pageContent">
			
			<div class="contentPanel">
			
				<div class="panelHeader"><spring:message code="teacher.management.updatemyaccount.header" /></div>
				
				<div class="panelContent">
					<div class="sectionHead"><spring:message code="teacher.management.updatemyaccount.accountInfo" /></div>
					<div class="sectionContent"> 
						<h5><a href="changepassword.html"><spring:message code="teacher.management.updatemyaccount.changePassword"/></a> - <spring:message code="teacher.management.updatemyaccount.changePasswordInfo"/></h5>
						<h5><a href="updatemyaccountinfo.html"><spring:message code="teacher.management.updatemyaccount.editRegistration"/></a> - <spring:message code="teacher.management.updatemyaccount.editRegistrationInfo"/></h5>
					</div>
				</div>
				<!-- <div class="panelContent">
					<div class="sectionHead">Preferences</div>
					<div class="sectionContent">
						<h5><a href="#"><spring:message code="teacher.management.updatemyaccount.editPrefernces"/></a> - <spring:message code="teacher.management.updatemyaccount.editPreferncesInfo"/></h5>
						<h5><a href="#"><spring:message code="teacher.management.updatemyaccount.editLanguage"/></a> - <spring:message code="teacher.management.updatemyaccount.editLanguageInfo"/></h5>
 					</div> -->
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>   <!-- End of page-->
	
	<%@ include file="../../footer.jsp"%>
</div>
	
</body>
</html>