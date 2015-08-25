<%@ page contentType="text/html; charset=GBK" %>
<%@ page import = "java.util.*,com.bizlogic.common.*"%>
<%@ taglib uri="/WEB-INF/taglib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/taglib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/taglib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglib/attribute.tld" prefix="attribute" %>

<html>
<head>
<title><bean:message key="saleEdit.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<LINK href="pub/stylesheet.css" rel=stylesheet>
<script language="javascript" src="pub/calendar.js"></script>
</head>
<body>
<html:form action="SaleSave.do" focus="orderTypeId">
<html:hidden property="functionName"/>
<html:hidden property="orderTypeId"/>
<html:hidden property="instanceId"/>
<html:hidden property="executionId"/>
<html:hidden property="activityId"/>
<html:hidden property="definitionId"/>
<html:hidden property="processId"/>
<html:hidden property="check"/>
<html:hidden property="change"/>
<html:hidden property="orderStatus"/>
<html:hidden property="orderId"/>
<html:hidden property="referenceOrderId"/>
<html:hidden property="totalQuantity"/>
<html:hidden property="totalAmount"/>
<html:hidden property="userId"/>
<html:hidden property="referenceCompanyId"/>
<input type="hidden" name="formName" value="orderEditForm">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="18" background="images/navigatorbg.gif" class="font6">ҳ�浼��: ���ݹ���-&gt;���۵��༭</td>  
    </tr>
  </table>
  <html:errors/>
  <br>
  <table width="98%" border="0" align="center" cellpadding="4" cellspacing="1" class="t2">
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">����</td>
      <td><html:hidden property="id" write="true"/></td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">���ۿͻ�</td>
      <td>
        <logic:notPresent name="orderEditForm" property="id">
        <select name="referenceCompanyId">
          <option value="99990001">�ͻ�һ</option>
          <option value="99020001">�ͻ���</option>
        </select>
        </logic:notPresent>
        <logic:present name="orderEditForm" property="id">
          <html:hidden property="referenceCompanyId"/>
          <html:hidden property="referenceCompanyName" write="true"/>
        </logic:present>
      </td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">�����ֿ�</td>
      <td>
        <logic:notPresent name="orderEditForm" property="id">
        <select name="warehouseId">
          <option value="0000000000001769">���</option>
          <option value="0000000000001769">��ת��</option>
        </select>
        </logic:notPresent>
        <logic:present name="orderEditForm" property="id">
          <html:hidden property="warehouseId"/>
          <html:hidden property="warehouseName" write="true"/>
        </logic:present>
      </td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">��������</td>
      <td>
        <html:text property="dateDeliver" size="12" readonly="true"/>
        <img name="date_img"src="images/date.gif" width="20" height="18" align="absmiddle" onclick="do_show_calendar('orderEditForm.dateDeliver')" style="cursor:hand;">
      </td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">¼����</td>
      <td>
        <html:hidden property="userId"/>
        <html:hidden property="userName" write="true"/>
      </td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">״̬</td>
      <td>
        �༭
        <html:hidden property="orderStatus"/>
      </td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">�����ܽ��</td>
      <td>
        15300.00
      </td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">Ʊ���ܽ��</td>
      <td>
        15300.00
      </td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">������ַ</td>
      <td><html:textarea property="description"  cols="63" rows="5"/></td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">ǩ����</td>
      <td><html:text property="description"/></td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">�´���</td>
      <td><html:text property="description"/></td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">��ϵ��</td>
      <td><html:text property="description"/></td>
    </tr>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">��ϵ�绰</td>
      <td><html:text property="description"/></td>
    </tr>
    <attribute:display attributeArrayName="attributes"/>
    <tr class="t4">
      <td width="146" height="28" align="right" class="t3">˵��</td>
      <td><html:textarea property="description"  cols="63" rows="5"/></td>
    </tr>
  </table>
  <br>
  <table width="98%" border="0" cellspacing="1" cellpadding="0" align="center">
     <tr><td height="5"></td></tr>
	 <tr>
      <input type="submit" class="button" value="����" onclick="javascript:document.forms[0].submit();return false;">
      <logic:equal name="orderEditForm" property="id" value="">			
        <input name="close" type="submit" class="button" value="����" onclick="javascript:window.location='Sale.do?functionName=back';return false">
      </logic:equal>
	  <logic:notEqual name="orderEditForm" property="id" value="">
   		<input name="return" type="submit" class="button" value="����" onclick="javascript:window.location='SaleItem.do?functionName=back&orderId=<bean:write name="orderEditForm" property="id"/>&orderTypeId=<bean:write name="orderEditForm" property="orderTypeId"/>';return false;">
	  </logic:notEqual>
      </td>
    </tr>
  </table>
</html:form>
</body>
</html>
<script language="javascript">
function openwindow(url)
{
  window.open(url,'AL','resizable=1,scrollbars=1,status=no,toolbar=no,location=no,menu=no,width=620,height=500' );
}
function change1()
{
    f1=document.forms[0];
    f1.action=f1.action+"?function=type";
    f1.submit();
}

function selectCompany()
{
        var WinURL='CompanySearch.do?formName=orderEditForm';
        var SMWnd=window.open(WinURL,"ActionSecondWin","width=700,height=400,resizable=yes,bar=no,scrollbars=yes");
        SMWnd.opener = self;
        SMWnd.focus();
}


</script>