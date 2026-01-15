/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author upash
 */
public class DeletedPatient {


    private static final DeletedPatient instance = new DeletedPatient();
    public static DeletedPatient getInstance() { return instance; }

    // store full patient data (6 columns)
    private final Deque<String[]> stack = new ArrayDeque<>();

    private DeletedPatient() {}

    // PUSH full patient row
    public void push(String[] patient) {
        if (patient == null || patient.length < 6) return;
        stack.push(patient);
    }

    // POP full patient row
    public String[] pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public int getSize() {
        return stack.size();
    }

    public String getAllAsText() {
        StringBuilder sb = new StringBuilder();
        for (String[] p : stack) {
            sb.append("Patient ID: ").append(p[0])
              .append(" | Name: ").append(p[1])
              .append("\n");
        }
        return sb.toString().trim();
    }
}
