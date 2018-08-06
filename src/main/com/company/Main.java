package com.company;

import com.company.model.Patient;
import com.company.model.State;
import com.company.utils.PrayerAnswerer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Patient> patientList = createPatients(args[0]);
        String[] drugs = args[1].split(",");
        List<String> drugsList = Arrays.asList(drugs);
        Hospital hospital = new Hospital();
        List<Patient> patients = hospital.curePatients(patientList, drugsList);
        List<Patient> answeredPrayersListOrNot = PrayerAnswerer.canIHazAmen(patients);
        System.out.println(
                "F:"+answeredPrayersListOrNot.stream().filter(p->p.getState()==State.F).count()+","+
                "H:"+answeredPrayersListOrNot.stream().filter(p->p.getState()==State.H).count()+","+
                "D:"+answeredPrayersListOrNot.stream().filter(p->p.getState()==State.D).count()+","+
                "T:"+answeredPrayersListOrNot.stream().filter(p->p.getState()==State.T).count()+","+
                "X:"+answeredPrayersListOrNot.stream().filter(p->p.getState()==State.X).count()
        );
    }

    private static List<Patient> createPatients(String arg) {
        String[] patients = arg.split(",");

        List<String> input = Arrays.asList(patients);
        List<Patient> patientList = new ArrayList<>();
        input.forEach(p -> {
            Patient patient = new Patient();
            patient.setState(State.valueOf(p));
            patientList.add(patient);
        });
        return patientList;
    }
}
