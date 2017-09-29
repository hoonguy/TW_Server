package com.jh.tw;

import java.io.*;
import java.util.HashMap;

public class Utility {

    public void getAccess_table(DtoAccess data_acs) {
        String path = "C:\\apache-tomcat-8.5.20";
        String rfn = "db.ini";
        BufferedReader bfr = null;
        File infile = new File(path, rfn);

        try {
            bfr = new BufferedReader(new FileReader(infile));
            String line;

            while ((line = bfr.readLine()) != null) {
                String[] fRcv = line.split("\t");
                data_acs.setDb_name(fRcv[0]);       data_acs.setTbl_name(fRcv[1]);      data_acs.setTbl_acs_id(fRcv[2]);
                data_acs.setTbl_acs_pw(fRcv[3]);    data_acs.setTbl_acs_url(fRcv[4] + fRcv[0]);
            }
        } catch (FileNotFoundException fnf_e) {
            fnf_e.printStackTrace();
        } catch (IOException io_e) {
            io_e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException io_e) {
                    io_e.printStackTrace();
                }
            }
        }
    }
}
