/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.HashMap;
import java.util.Map;

public class PrescriptionStore {

    // ---------- Singleton ----------
    private static final PrescriptionStore instance = new PrescriptionStore();
    public static PrescriptionStore getInstance() {
        return instance;
    }

    private PrescriptionStore() {}

    // ---------- Data model ----------
    public static class Record {
        public final String doctorPrescription;
        public final String medicineDetails;

        public Record(String doctorPrescription, String medicineDetails) {
            this.doctorPrescription = doctorPrescription;
            this.medicineDetails = medicineDetails;
        }
    }

    // patientId -> record
    private final Map<String, Record> data = new HashMap<>();

    // ---------- CRUD ----------
    public void save(String patientId, String doctorRec, String medicineDetails) {
        data.put(patientId, new Record(doctorRec, medicineDetails));
    }

    public Record get(String patientId) {
        return data.get(patientId);
    }

    public boolean has(String patientId) {
        return data.containsKey(patientId);
    }

    public void delete(String patientId) {
        data.remove(patientId);
    }
}
