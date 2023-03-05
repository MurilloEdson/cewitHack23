package com.cewit.healthcarescreening;

import com.google.cloud.firestore.DocumentSnapshot;

/**
 *
 * @author murillo-edson
 */
public class Screening {
    
    String name;
    String disease;
    int minAge;
    int maxAge;
    char patientSex;
    int height;
    int weight;
    double BMI;
    
    Screening() {
        this.name = "";
        this.disease = "";
        this.maxAge = 0;
        this.minAge = 0;
        this.weight = 0;
        this.height = 0;
        this.BMI = BMI;
    }
    
    public Screening(DocumentSnapshot ds){
        this.name = ds.getString("Name");
        this.disease = ds.getString("Disease");
        this.maxAge = ds.getDouble("maxAge").intValue();
        this.minAge = ds.getDouble("minAge").intValue();
        this.weight = ds.getDouble("weight").intValue();
        this.height = ds.getDouble("height").intValue();
        this.BMI = SecondaryController.pat.BMI;

        if (BMI < 18.5) {
            System.out.println("Underweight");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            System.out.println("Normal");
        } else if (BMI >= 25.0 && BMI <= 29.9) {
        System.out.println("Overweight");
        } else {
        System.out.println("Obese");
        }
    }

    
}
