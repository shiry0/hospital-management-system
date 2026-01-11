/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author upash
 */
public class DeletedPatient {

    private static final DeletedPatient instance = new DeletedPatient();
    public static DeletedPatient getInstance() { return instance; }

    private DeletedPatient() {}

    // simple text lines; you can store objects later if you want
    private final List<String> deletedLogs = new ArrayList<>();

    public void add(String patientId, String patientName) {
        deletedLogs.add("Patient ID: " + patientId + " | Name: " + patientName);
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(deletedLogs);
    }
}
