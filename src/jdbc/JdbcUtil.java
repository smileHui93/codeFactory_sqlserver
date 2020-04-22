package jdbc;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    
    public static Properties getProperty() {
        Properties prop = new Properties();     
        try{
            String path = JdbcUtil.class.getClassLoader().getResource("jdbc").getPath();
            //读取属性文件a.properties
            InputStream in = new BufferedInputStream (new FileInputStream(path+"/config.properties"));
            prop.load(in);     ///加载属性列表
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return prop;
    }
    
    public static Connection getConnection() {
        Properties prop = getProperty();
        Connection connection = null;
        try {
            Class.forName(prop.getProperty("driver"));
            connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
