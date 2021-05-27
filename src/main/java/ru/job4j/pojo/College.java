package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Алексей");
        student.setGroup("Стажер");
        student.setCreated(new Date());

        System.out.println("ФИО: " + student.getName() + ". Группа: " + student.getGroup() + ". Дата поступления: " + student.getCreated());
    }
}
