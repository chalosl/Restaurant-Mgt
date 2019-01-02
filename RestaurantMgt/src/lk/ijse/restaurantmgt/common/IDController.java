/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.ijse.restaurantmgt.db.DBConnection;

/**
 *
 * @author CHALO
 */
public class IDController {

    public static String getLastID(String tableName, String colName) throws SQLException, ClassNotFoundException, IOException {
        String sql = "select " + colName + " from " + tableName + " order by 1 desc limit 1";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
}
    

