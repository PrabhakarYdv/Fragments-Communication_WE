package com.prabhakar.fragmentscommunication_we;

import java.io.Serializable;

public class Model implements Serializable {
    String name;
    int age;
    String grade;
    String percentage;

    public Model(String name, int age, String grade, String percentage) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getPercentage() {
        return percentage;
    }
}
