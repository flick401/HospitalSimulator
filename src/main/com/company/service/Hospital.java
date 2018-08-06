package com.company;

import com.company.model.Drug;
import com.company.model.Patient;
import com.company.model.State;

import java.util.List;

public class Hospital {
    /*Aspirin cures Fever;
● Antibiotic cures Tuberculosis;
● Insulin prevents diabetic subject from dying, does not cure Diabetes;
● If insulin is mixed with antibiotic, healthy people catch Fever;
● Paracetamol cures Fever;
● Paracetamol kills subject if mixed with aspirin;
● One time in a million the Flying Flying Spaghetti Monster shows his noodly power
and resurrects a dead patient (Dead becomes Healthy).*/
    public List<Patient> curePatients(List<Patient> patients, List<String> drugs) {
        if (!drugs.isEmpty() && !drugs.contains("")) {
            drugs.forEach(drug -> {
                switch (Drug.valueOf(drug)) {
                    case An:
                        patients.forEach(patient -> {
                            if (!drugs.contains("I") && patient.getState().equals(State.T)) {
                                patient.setState(State.H);
                            } else {
                                patient.setState(State.X);
                            }
                        });
                    case AS:
                        patients.forEach(patient -> {
                            if (!drugs.contains("P") && patient.getState().equals(State.F)) {
                                patient.setState(State.H);
                            } else {
                                patient.setState(State.X);
                            }
                        });
                    case I:
                        patients.forEach(patient -> {
                            if (drugs.contains("An") && patient.getState().equals(State.D)) {
                                patient.setState(State.X);
                            }
                        });
                    case P:
                        patients.forEach(patient -> {
                            if (!drugs.contains("As") && patient.getState().equals(State.F)) {
                                patient.setState(State.H);
                            } else {
                                patient.setState(State.X);
                            }
                        });
                }


            });
        } if (!drugs.contains("D")){
            patients.stream().filter(patient -> patient.getState().equals(State.D)).forEach(patient -> patient.setState(State.X));

        }

        return patients;
    }
}
