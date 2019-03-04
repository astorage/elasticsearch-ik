package org.wltea.analyzer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IkDicDAO {
    /**
     * 查询数据库中所有的扩展字典
     * @return
     */
    public List<String> queryExtWord() {
        List<String> extWordList = new ArrayList<>();
        String sql =  "select dic from ext_word";
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = MysqlConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String dic = resultSet.getString("dic");
                extWordList.add(dic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                MysqlConnectionFactory.release(connection);
            }
        }
        return extWordList;
    }

    /**
     * 查询数据库中所有的stop字典
     * @return
     */
    public List<String> queryStopWord() {
        List<String> stopWordList = new ArrayList<>();
        String sql =  "select dic from stop_word";
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = MysqlConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String dic = resultSet.getString("dic");
                stopWordList.add(dic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                MysqlConnectionFactory.release(connection);
            }
        }
        return stopWordList;
    }

//    public static void main(String[] args) {
//        IkDicDAO ikDicDAO = new IkDicDAO();
//        List<String> extWordList = ikDicDAO.queryExtWord();
//        System.out.println(extWordList);
//        List<String> stopList = ikDicDAO.queryStopWord();
//        System.out.println(stopList);
//    }
}
