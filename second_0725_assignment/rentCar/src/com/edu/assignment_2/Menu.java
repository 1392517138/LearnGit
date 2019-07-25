package com.edu.assignment_2;

public class Menu {
    private static int i;
    public static void main(String[] args) {
        //1.载入数据

        new loadInformation().main(null);




        //2.启动图形化界面菜单，有展示与租车
        new Start().main(null);
    }
}
