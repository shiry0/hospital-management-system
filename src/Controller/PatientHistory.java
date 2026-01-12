/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;

import java.util.ArrayDeque;

import java.util.Queue;

/**
 *
 * @author upash
 */
public class PatientHistory {
    public static class CheckupRecord {
        public final String patientId;
        public final String timestamp;
        public final String details;

        public CheckupRecord(String patientId, String timestamp, String details) {
            this.patientId = patientId;
            this.timestamp = timestamp;
            this.details = details;
        }
    }

    private static final PatientHistory instance = new PatientHistory();
    public static PatientHistory getInstance() { return instance; }

    private final Queue<CheckupRecord> queue = new ArrayDeque<>();

    private PatientHistory() {}

    public void add(CheckupRecord r) {
        queue.offer(r);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getSize() {
        return queue.size();
    }

    public CheckupRecord getOldestCheckup() {
        return queue.peek();
    }

    public String getAllAsText() {
        StringBuilder sb = new StringBuilder();
        for (CheckupRecord r : queue) {
            sb.append("Patient: ").append(r.patientId).append("\n")
              .append("Time: ").append(r.timestamp).append("\n")
              .append("Details: ").append(r.details).append("\n")
              .append("----------------------\n");
        }
        return sb.toString().trim();
    }
}
