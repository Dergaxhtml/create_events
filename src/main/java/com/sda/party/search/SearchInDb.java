package com.sda.party.search;

import java.sql.*;
import java.util.List;

public class SearchInDb {
    private static List<String> searchInDB(String keyword) {
        List<String> theStrings = new List<String>();
        String url = "jdbc:mysql://127.0.0.1:3306/partyzone?serverTimezone=CET";
        String query = "Select EVT_address from event where EVT_address like '%?%'" ;
        try {
            Connection connection = DriverManager.getConnection(...);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                theStrings.add(rs.getString("EVT_address"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();

        }
        return theStrings ;
    }
}
