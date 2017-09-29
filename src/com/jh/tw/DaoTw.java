package com.jh.tw;

import java.sql.*;

public class DaoTw {

    private final String jdbc_drv = "com.mysql.jdbc.Driver";

    private static DaoTw instance;
    public static DaoTw getInstance() {
        if (instance == null) instance = new DaoTw();
        return instance;
    }

    public Connection getConn(DtoAccess data_acs) {
        Connection connection = null;

        try {
            Class.forName(jdbc_drv);
            connection = DriverManager.getConnection(data_acs.getTbl_acs_url(), data_acs.getTbl_acs_id(), data_acs.getTbl_acs_pw());
        } catch (ClassNotFoundException cnfe_e) { cnfe_e.printStackTrace();
        } catch (SQLException sql_e) { sql_e.printStackTrace();
        }
        return connection;
    }

    public void getClose(Connection conn) {
        try { conn.close(); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public int insert(Connection conn, DtoMember data, DtoAccess data_acs) {
        PreparedStatement   psmt = null;
        String  qry = "insert into " + data_acs.getTbl_name() + " values(?,?,?,?,?,?,?)";
        int     rtnCode = 0;

        try {
            psmt = conn.prepareStatement(qry);
            psmt.setString(1, data.getMem_code());
            psmt.setString(2, data.getPspt_name());
            psmt.setString(3, data.getCountry());
            psmt.setString(4, data.getSex());
            psmt.setString(5, data.getPicture());
            psmt.setString(6, data.getMem_id());
            psmt.setString(7, data.getMem_pw());
            rtnCode = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psmt != null) {
                try { psmt.close(); }
                catch (SQLException insert_sql_e) { insert_sql_e.printStackTrace(); }
            }
        }
        return rtnCode;
    }

}
