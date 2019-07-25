package com.edu.assignment_2;

public class Car {
    /*

    定义车的属性

    id>>车序号
    name>>车名字
    fee>>车费用 (元*车*天)
    numLoad>>最大载货(吨)
    peopleLoad>>最大载人(人)
    sort>>车的类别
     */
    public   int id;
    private  String name;
    private  int fee;
    private  double numLoad;
    private  int peopleLoad;
    private  String sort;

    public Car(int id, int fee, String name, int peopleLoad, double numLoad, String sort) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.peopleLoad = peopleLoad;
        this.numLoad = numLoad;
        this.sort = sort;
    }

    public  int getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public  int getFee() {
        return fee;
    }

    public  double getNumLoad() {
        return numLoad;
    }

    public  int getPeopleLoad() {
        return peopleLoad;
    }

    public  String getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return "com.edu.assignment_2.Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", numLoad=" + numLoad +
                ", peopleLoad=" + peopleLoad +
                ", sort='" + sort + '\'' +
                '}';
    }
}
