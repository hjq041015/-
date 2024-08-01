package com.google.demo5;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private int source;


    public Student(int studentId ,String name, int age,int source) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.source = source;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSource() {
        return source;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name='" + name + '\'' + ", age=" + age + ", source=" + source + '}';
    }
}
