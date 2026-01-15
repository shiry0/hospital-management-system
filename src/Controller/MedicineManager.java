/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;
import Model.Medicine;
import java.util.*;
///**
// * Singleton class to manage medicines across the application
// * @author upash
// */
public class MedicineManager {
    private static MedicineManager instance;

    private final Queue<Medicine> medQueue;
    private final Stack<Medicine> medStack;

    private MedicineManager() {
        medQueue = new LinkedList<>();
        medStack = new Stack<>();

        // ✅ Dummy data
        addMedicine(new Medicine("Paracetamol", "500mg", "Fever, Pain", "Take after meals"));
        addMedicine(new Medicine("Amoxicillin", "250mg", "Bacterial infections", "Complete full course"));
        addMedicine(new Medicine("Ibuprofen", "400mg", "Pain, Inflammation", "Take with food"));
    }

    public static MedicineManager getInstance() {
        if (instance == null) instance = new MedicineManager();
        return instance;
    }

    // ✅ store in BOTH Queue and Stack
    public void addMedicine(Medicine m) {
        medQueue.offer(m);   // FIFO
        medStack.push(m);    // LIFO
    }

    public List<Medicine> getAllMedicinesFIFO() {
        return new ArrayList<>(medQueue);
    }

    public List<Medicine> getAllMedicinesLIFO() {
        Stack<Medicine> temp = (Stack<Medicine>) medStack.clone();
        List<Medicine> list = new ArrayList<>();
        while (!temp.isEmpty()) list.add(temp.pop());
        return list;
    }
    public boolean removeMedicine(String name, String dose) {
    boolean removedQueue = medQueue.removeIf(m ->
            m.getName().equals(name) && m.getDose().equals(dose)
    );

    boolean removedStack = medStack.removeIf(m ->
            m.getName().equals(name) && m.getDose().equals(dose)
    );

    return removedQueue || removedStack;
}

}
