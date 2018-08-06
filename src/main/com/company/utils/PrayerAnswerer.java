package com.company.utils;

import com.company.model.Patient;
import com.company.model.State;

import java.util.List;
import java.util.Random;

public class PrayerAnswerer {
    public static List<Patient> canIHazAmen(List<Patient> patients) {
       Random random = new Random();
       boolean randomNumber = 1+ random.nextInt(10000000)==0;
       if (randomNumber){


         patients.stream()
                 .filter(p -> p.getState().equals(State.X))
                 .findAny()
                 .get()
                 .setState(State.H);


       }
       return patients;

    }
}
