package com.edu.assignment_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Result {
    private JButton 确认Button;
    private JPanel outCome;
    /*
    jieguo >> 各个车辆的租用数目
    Max_people >> 总载人数
    Max_num >> 总载货量
    Max_fee >> 总租车费用
    Car_num >> 总租车总数
    Car_day >> 总租车天数
     */
    private  JLabel Max_people;
    private  JLabel Max_num;
    private  JLabel Max_fee;
    private  JLabel Car_num;
    private  JLabel Car_day;
    private JLabel jieguo;

    public static JFrame frame = null;

    //计算各个指标
    {
        int max_people = 0;
        double max_num = 0;
        int max_fee = 0;
        int car_num = 0;
        int car_day = 0;
        String text = "";
        for (int i=0; i<8; i++){
            max_people += Rent.objSet[i][0]*loadInformation.list.get(i).getPeopleLoad();
            max_num += Rent.objSet[i][0]*loadInformation.list.get(i).getNumLoad();
            max_fee += Rent.objSet[i][0]*loadInformation.list.get(i).getFee();
            car_num += Rent.objSet[i][0];
            car_day += Rent.objSet[i][1];


            //判断租车数目或者天数不为0进行显示
            //并对结果进行添加

            if (Rent.objSet[i][0]!=0 && Rent.objSet[i][1]!=0){
                text += loadInformation.list.get(i).getName()+"----数目----"+Rent.objSet[i][0]+"----天数----"+Rent.objSet[i][1]+"             \n";
            }
        }
        Max_people.setText(""+max_people);
        Max_num.setText(""+max_num);
        Max_fee.setText(""+ max_fee);
        Car_num.setText(""+car_num);
        Car_day.setText(""+car_day);
        jieguo.setText(text);
    }


    public Result() {
        确认Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Result");
        frame.setContentPane(new Result().outCome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}

