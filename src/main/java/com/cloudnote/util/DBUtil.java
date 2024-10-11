package com.cloudnote.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    /**
     * 這是 JAVA 自己配置的 Util 方法 以下是讓我產出一個 Properties 空文件也就是 .properties
     * 也就是得到 配置文件對象
     **/

    private static Properties properties = new Properties();

    // 接下來才做 db.properties 讀取
    static {

        try {
            // 加載配置文件(輸入流)
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            // 通過 load() 方法將輸入流的內容加載到 配置文件對象 中
            properties.load(in);
            // 通過 配置文件對象的 getProperty() 方法獲取 db.properties 驅動名並加載
            Class.forName(properties.getProperty("jdbcName"));

        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    /**
     * 獲取數據庫連接
     * 調取數據庫方法
     **/

    // 這個 Connection 是 JDBC 接口 直接 import 後也不用 override 就可以用
    public  static Connection getConnection(){
        Connection connection = null;

        try {

            // 得到數據庫連接內的屬性
            String dbUrl = properties.getProperty("dbUrl");
            String dbName = properties.getProperty("dbName");
            String dbPwd = properties.getProperty("dbPwd");
            // 得到數據庫連接
            connection = DriverManager.getConnection(dbUrl,dbName,dbPwd);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
        return connection;
    }

    /**
     * 關閉資源以進行資源管理 :
     * 內含 結果集 欲編譯對象 數據庫對象
     * 關閉數據庫方法
     **/

    public static void close (ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){

        // 如果上述屬性為空直接調用此方法就會報錯，所以需要進行基本判斷: 如果資源對象不為空，則關閉
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                resultSet.close();
            }
            if (connection != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
