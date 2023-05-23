<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleFilmDataControllerProxyid" scope="session" class="wtp.FilmDataControllerProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleFilmDataControllerProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleFilmDataControllerProxyid.getEndpoint();
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
        sampleFilmDataControllerProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        wtp.FilmDataController getFilmDataController10mtemp = sampleFilmDataControllerProxyid.getFilmDataController();
if(getFilmDataController10mtemp == null){
%>
<%=getFilmDataController10mtemp %>
<%
}else{
        if(getFilmDataController10mtemp!= null){
        String tempreturnp11 = getFilmDataController10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String title_1id=  request.getParameter("title16");
            java.lang.String title_1idTemp = null;
        if(!title_1id.equals("")){
         title_1idTemp  = title_1id;
        }
        String year_2id=  request.getParameter("year18");
        int year_2idTemp  = Integer.parseInt(year_2id);
        String director_3id=  request.getParameter("director20");
            java.lang.String director_3idTemp = null;
        if(!director_3id.equals("")){
         director_3idTemp  = director_3id;
        }
        String stars_4id=  request.getParameter("stars22");
            java.lang.String stars_4idTemp = null;
        if(!stars_4id.equals("")){
         stars_4idTemp  = stars_4id;
        }
        String review_5id=  request.getParameter("review24");
            java.lang.String review_5idTemp = null;
        if(!review_5id.equals("")){
         review_5idTemp  = review_5id;
        }
        java.lang.String addFilmData13mtemp = sampleFilmDataControllerProxyid.addFilmData(title_1idTemp,year_2idTemp,director_3idTemp,stars_4idTemp,review_5idTemp);
if(addFilmData13mtemp == null){
%>
<%=addFilmData13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addFilmData13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 26:
        gotMethod = true;
        String id_6id=  request.getParameter("id29");
        int id_6idTemp  = Integer.parseInt(id_6id);
        java.lang.String deleteFilmData26mtemp = sampleFilmDataControllerProxyid.deleteFilmData(id_6idTemp);
if(deleteFilmData26mtemp == null){
%>
<%=deleteFilmData26mtemp %>
<%
}else{
        String tempResultreturnp27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteFilmData26mtemp));
        %>
        <%= tempResultreturnp27 %>
        <%
}
break;
case 31:
        gotMethod = true;
        String format_7id=  request.getParameter("format34");
            java.lang.String format_7idTemp = null;
        if(!format_7id.equals("")){
         format_7idTemp  = format_7id;
        }
        java.lang.String getAllFilmData31mtemp = sampleFilmDataControllerProxyid.getAllFilmData(format_7idTemp);
if(getAllFilmData31mtemp == null){
%>
<%=getAllFilmData31mtemp %>
<%
}else{
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllFilmData31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
}
break;
case 36:
        gotMethod = true;
        String searchStr_8id=  request.getParameter("searchStr39");
            java.lang.String searchStr_8idTemp = null;
        if(!searchStr_8id.equals("")){
         searchStr_8idTemp  = searchStr_8id;
        }
        String format_9id=  request.getParameter("format41");
            java.lang.String format_9idTemp = null;
        if(!format_9id.equals("")){
         format_9idTemp  = format_9id;
        }
        java.lang.String searchFilmData36mtemp = sampleFilmDataControllerProxyid.searchFilmData(searchStr_8idTemp,format_9idTemp);
if(searchFilmData36mtemp == null){
%>
<%=searchFilmData36mtemp %>
<%
}else{
        String tempResultreturnp37 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(searchFilmData36mtemp));
        %>
        <%= tempResultreturnp37 %>
        <%
}
break;
case 43:
        gotMethod = true;
        String format_10id=  request.getParameter("format46");
            java.lang.String format_10idTemp = null;
        if(!format_10id.equals("")){
         format_10idTemp  = format_10id;
        }
        String id_11id=  request.getParameter("id48");
        int id_11idTemp  = Integer.parseInt(id_11id);
        java.lang.String getFilmByID43mtemp = sampleFilmDataControllerProxyid.getFilmByID(format_10idTemp,id_11idTemp);
if(getFilmByID43mtemp == null){
%>
<%=getFilmByID43mtemp %>
<%
}else{
        String tempResultreturnp44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getFilmByID43mtemp));
        %>
        <%= tempResultreturnp44 %>
        <%
}
break;
case 50:
        gotMethod = true;
        String id_12id=  request.getParameter("id53");
        int id_12idTemp  = Integer.parseInt(id_12id);
        String title_13id=  request.getParameter("title55");
            java.lang.String title_13idTemp = null;
        if(!title_13id.equals("")){
         title_13idTemp  = title_13id;
        }
        String year_14id=  request.getParameter("year57");
        int year_14idTemp  = Integer.parseInt(year_14id);
        String director_15id=  request.getParameter("director59");
            java.lang.String director_15idTemp = null;
        if(!director_15id.equals("")){
         director_15idTemp  = director_15id;
        }
        String stars_16id=  request.getParameter("stars61");
            java.lang.String stars_16idTemp = null;
        if(!stars_16id.equals("")){
         stars_16idTemp  = stars_16id;
        }
        String review_17id=  request.getParameter("review63");
            java.lang.String review_17idTemp = null;
        if(!review_17id.equals("")){
         review_17idTemp  = review_17id;
        }
        java.lang.String updateFilmData50mtemp = sampleFilmDataControllerProxyid.updateFilmData(id_12idTemp,title_13idTemp,year_14idTemp,director_15idTemp,stars_16idTemp,review_17idTemp);
if(updateFilmData50mtemp == null){
%>
<%=updateFilmData50mtemp %>
<%
}else{
        String tempResultreturnp51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateFilmData50mtemp));
        %>
        <%= tempResultreturnp51 %>
        <%
}
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