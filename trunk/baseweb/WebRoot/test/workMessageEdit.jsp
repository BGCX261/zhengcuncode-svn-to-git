<%@ page contentType="text/html; charset=GBK"%>
<%
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base target="_self">
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title>无标题</title>
		<LINK href="../css/css.css" rel="stylesheet">
	</head>

	<body>
		<html:form action="/test/workMessageSave.do">			
			<html:hidden property="action" />	
			<html:hidden property="messId" />			
			<TABLE class="tableCM">
				<tr class="trCM">
					<td class="tdCMTitle">
						标题：
					</td>
					<td class="tdCMContent">
						<html:text property="cappTitle"></html:text>
						<font color="#FF0000">*</font>
					</td>
				</tr>				
			</TABLE>
			<p>
			</p>
			<table class="tableSubmit">
				<tr class="trSubmit">
					<td class="tdSubmitTitle">
						<input name="submitBt" id="submitBt" type="button" class="buttonCM"
							value="保存" onclick="submitMe('submit')">
						&nbsp;&nbsp;
						<input name="cancelBt" id="cancelBt" type="button" class="buttonCM"
							value="取消" onclick="javascript:window.close();">
					</td>
					<td class="tdSubmitContent"></td>
				</tr>
			</table>
		</html:form>
	</body>
	<script type="text/javascript">	
		function submitMe(action)
		{
			var f = document.forms[0];					
			f.action.value = action;
			f.submit();
		}	
	</script>
</html>
