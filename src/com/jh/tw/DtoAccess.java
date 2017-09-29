package com.jh.tw;

public class DtoAccess {
    private String  db_name, tbl_name, tbl_acs_id, tbl_acs_pw, tbl_acs_url;

    public String getDb_name() { return db_name; }
    public String getTbl_name() { return tbl_name; }
    public String getTbl_acs_id() { return tbl_acs_id; }
    public String getTbl_acs_pw() { return tbl_acs_pw; }
    public String getTbl_acs_url() { return tbl_acs_url; }

    public void setDb_name(String db_name) { this.db_name = db_name; }
    public void setTbl_name(String tbl_name) { this.tbl_name = tbl_name; }
    public void setTbl_acs_id(String tbl_acs_id) { this.tbl_acs_id = tbl_acs_id; }
    public void setTbl_acs_pw(String tbl_acs_pw) { this.tbl_acs_pw = tbl_acs_pw; }
    public void setTbl_acs_url(String tbl_acs_url) { this.tbl_acs_url = tbl_acs_url; }
}
