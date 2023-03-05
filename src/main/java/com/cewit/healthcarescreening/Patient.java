package com.cewit.healthcarescreening;

import java.util.*;

/**
 *
 * @author murillo-edson
 */
public class Patient {

    int id;
    int age;
    int weight;
    int height;
    char sex;
    double BMI;
    Scanner Scale = new Scanner(System.in);

    public Patient(int id, int weight, int age, int height, char gender) {
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = gender;
        this.BMI = getBMI(weight, height);
    }

    Patient() {
        
    }

    public double getBMI(int weight, int height) {
        return (703 * weight) / (height * height);
    }
    
}
