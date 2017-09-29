package com.jh.tw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
    Account Class : Login work processing and return login success or failure
*/

public class Account {

    public boolean login(Connection conn, DtoMember data, DtoAccess data_acs) {
        Statement   stmt = null;
        String      rtnMsg = null;
        ResultSet   rs;
        String      qry = "select id from" + data_acs.getTbl_name() + "where id = " + data.getMem_id() + "and pw = " + data.getMem_pw();
        boolean     isLogin = false;

        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(qry); rs.last();
            if (rs.getRow() == 1) {
                isLogin = true;
            }
        } catch (Exception e) { e.printStackTrace();
        } finally {
            if (stmt != null) {
                try { stmt.close(); }
                catch (SQLException sql_e) { sql_e.printStackTrace(); }
            }
        }
        return isLogin;
    }

}
