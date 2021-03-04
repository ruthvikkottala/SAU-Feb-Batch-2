<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleProductServiceImplProxyid" scope="session" class="com.au.app.services.ProductServiceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleProductServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleProductServiceImplProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleProductServiceImplProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.au.app.services.ProductServiceImpl getProductServiceImpl10mtemp = sampleProductServiceImplProxyid.getProductServiceImpl();
if(getProductServiceImpl10mtemp == null){
%>
<%=getProductServiceImpl10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String id_1id=  request.getParameter("id24");
        int id_1idTemp  = Integer.parseInt(id_1id);
        com.au.app.Product getProduct15mtemp = sampleProductServiceImplProxyid.getProduct(id_1idTemp);
if(getProduct15mtemp == null){
%>
<%=getProduct15mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getProduct15mtemp != null){
java.lang.String typename18 = getProduct15mtemp.getName();
        String tempResultname18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename18));
        %>
        <%= tempResultname18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">price:</TD>
<TD>
<%
if(getProduct15mtemp != null){
%>
<%=getProduct15mtemp.getPrice()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getProduct15mtemp != null){
%>
<%=getProduct15mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 26:
        gotMethod = true;
        com.au.app.Product[] getAllProducts26mtemp = sampleProductServiceImplProxyid.getAllProducts();
if(getAllProducts26mtemp == null){
%>
<%=getAllProducts26mtemp %>
<%
}else{
        String tempreturnp27 = null;
        if(getAllProducts26mtemp != null){
        java.util.List listreturnp27= java.util.Arrays.asList(getAllProducts26mtemp);
        tempreturnp27 = listreturnp27.toString();
        }
        %>
        <%=tempreturnp27%>
        <%
}
break;
case 29:
        gotMethod = true;
        String id_2id=  request.getParameter("id32");
        int id_2idTemp  = Integer.parseInt(id_2id);
        boolean deleteProduct29mtemp = sampleProductServiceImplProxyid.deleteProduct(id_2idTemp);
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteProduct29mtemp));
        %>
        <%= tempResultreturnp30 %>
        <%
break;
case 34:
        gotMethod = true;
        String name_4id=  request.getParameter("name39");
            java.lang.String name_4idTemp = null;
        if(!name_4id.equals("")){
         name_4idTemp  = name_4id;
        }
        String price_5id=  request.getParameter("price41");
        int price_5idTemp  = Integer.parseInt(price_5id);
        String id_6id=  request.getParameter("id43");
        int id_6idTemp  = Integer.parseInt(id_6id);
        %>
        <jsp:useBean id="com1au1app1Product_3id" scope="session" class="com.au.app.Product" />
        <%
        com1au1app1Product_3id.setName(name_4idTemp);
        com1au1app1Product_3id.setPrice(price_5idTemp);
        com1au1app1Product_3id.setId(id_6idTemp);
        boolean addProduct34mtemp = sampleProductServiceImplProxyid.addProduct(com1au1app1Product_3id);
        String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addProduct34mtemp));
        %>
        <%= tempResultreturnp35 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>