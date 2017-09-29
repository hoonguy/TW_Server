<%@ page contentType="text/html;charset=euc-kr" language="java" %>
<%@ page import="com.jh.tw.*, java.io.*, java.util.*" %>
<%@ page import="java.sql.Connection" %>
<%
    String  id = request.getParameter("id");
    String  pw = request.getParameter("pw");
    String  type = request.getParameter("type");

    DtoAccess   data_acs = new DtoAccess();
    DtoMember   data = new DtoMember();
    Account     account = new Account();
    Utility     utility = new Utility();

    Connection connection = null;
    DaoTw dao = DaoTw.getInstance();

    utility.getAccess_table(data_acs);
    data.setMem_id(id); data.setMem_pw(pw);

    connection = dao.getConn(data_acs);

    switch (type) {
        case "login" :
            if (account.login(connection, data, data_acs)) { out.print("Your Access is Verified"); }
            else { out.print("Access is denied"); }
            dao.getClose(connection);
            break;
        case "signin" :
            dao.insert(connection, data, data_acs);
            break;
    }

%>