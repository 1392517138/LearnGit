package com.edu.assignment_2;/*
    将数据库中的内容导入一个数组中
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class loadInformation {

    //定义一个集合
    public static List<Car> list = new ArrayList<>();

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //连接数据库
        try {
            int id;
            String name;
            int fee;
            double numLoad;
            int peopleLoad;
            String sort;
            //通过加载，Driver下的registerDriver注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","13452078118");
            String sql = "select * from new_table";
            statement = conn.createStatement();
            //将查询结果放到这个集合中
            resultSet = statement.executeQuery(sql);


            //赋值给<car>数组
            while (resultSet.next()){
                id = resultSet.getInt(1);
                fee = resultSet.getInt(2);
                name = resultSet.getString(3);
                peopleLoad = resultSet.getInt(4);
                numLoad = resultSet.getDouble(5);
                sort = resultSet.getString(6);

                //添加到list中
                list.add(new Car(id,fee,name,peopleLoad,numLoad,sort));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
