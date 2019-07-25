package com.edu.assignment_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class Rent {
    /*
    显而易见，num即数量，day为天数，_前面表示车的序号
    将用户需要的传入数据库
     */
    private JTextField one_num;
    private JTextField one_day;
    private JTextField two_num;
    private JTextField two_day;
    private JTextField three_num;
    private JTextField three_day;
    private JTextField four_num;
    private JTextField four_day;
    private JTextField five_num;
    private JTextField five_day;
    private JTextField six_num;
    private JTextField six_day;
    private JTextField seven_num;
    private JTextField seven_day;
    private JTextField eight_num;
    private JTextField eight_day;

    private JButton 提交Button;
    private JPanel allForm;
    public static JFrame frame = null;
    //定义一个objSet数组，8行代表8个车，2列 分布代表数量和天数
    public static int objSet[][];

    public Rent() {
        提交Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objSet = new int[8][2];

                //添加到object
                add();

                //插入用户的库中
                insert();

                frame.setVisible(false);
                new Result().main(null);
            }
        });
    }


    public static void main(String[] args) {
        frame = new JFrame("Rent");
        frame.setContentPane(new Rent().allForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //出错判断，判断租车数量和天数是否大于等于0的整数，并且不能出现数量为0天数大于0的情况和天数为0数量大于0的情况,即判断是否有一个为0。是则返回，否则返回0
    private int judge(String str) {

        //首先判断是否为小数，即是否包含"."
        if (str.contains(".")) {
            return 0;
        } else {
            //转为Int型，判断是否大于0
            int var = Integer.parseInt(str);
            if (var > 0) {
                return var;
            } else {
                return 0;
            }
        }
    }

    //将需求添加进数组
    private void add() {
        //先将所以信息导入数组，再循环判断加入最终结果
        ArrayList<String> ls = new ArrayList<>();
        ls.add(one_num.getText());
        ls.add(one_day.getText());
        ls.add(two_num.getText());
        ls.add(two_day.getText());
        ls.add(three_num.getText());
        ls.add(three_day.getText());
        ls.add(four_num.getText());
        ls.add(four_day.getText());
        ls.add(five_num.getText());
        ls.add(five_day.getText());
        ls.add(six_num.getText());
        ls.add(six_day.getText());
        ls.add(seven_num.getText());
        ls.add(seven_day.getText());
        ls.add(eight_num.getText());
        ls.add(eight_day.getText());

        //将object初始化
        int m = 0,n = 0;
        for (m=0; m<8; m++)
            for (n=0; n<2; n++){
                objSet[m][n] = 0;
            }

        int count = 0;
        //如果 数量与天数都 >=0,则存入数组中
        for (int i = 0; i < 8; i++) {
                m = judge(ls.get(count++));

                n = judge(ls.get(count++));

                //因为之前已经初始化为0,则现在只用判断是否都大于0
                if (m*n>0){
                    objSet[i][0] = m;
                    objSet[i][1] = n;
                }
        }


    }

    private void insert() {
        Connection connection = null;
        PreparedStatement ps = null;

        //m表示数量，n表示天数
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","13452078118");

            String sql = "insert into user_need (need_id,need_num,need_day) values(?,?,?)";
            for (int i = 0; i < 8; i++) {

                ps = connection.prepareStatement(sql);

                ps.setInt(1,i);
                ps.setInt(2,objSet[i][0]);
                ps.setInt(3,objSet[i][1]);

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

