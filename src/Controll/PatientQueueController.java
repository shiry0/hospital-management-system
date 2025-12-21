/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;

/**
 *
 * @author upash
 */

public class PatientQueueController {

    private static PatientQueueController instance;

    private final int QUEUE_SIZE = 20;
    private String[][] queue = new String[QUEUE_SIZE][6];
    private int front = -1, rear = -1;

    private PatientQueueController() {}

    public static PatientQueueController getInstance() {
        if (instance == null) {
            instance = new PatientQueueController();
        }
        return instance;
    }
    
    // Check if queue is empty
    public boolean isQueueEmpty() {
        return front == -1;
    }

    // Check if queue is full
    public boolean isQueueFull() {
        return (rear + 1) % QUEUE_SIZE == front;
    }

    // Add patient to queue (Enqueue)
    public boolean enqueuePatient(String id, String name, String gender,
                                  String contact, String address, String age) {

        // Validate input
        if (id.isEmpty() || name.isEmpty() || gender.isEmpty()) {
            return false;
        }

        // Check if queue is full
        if (isQueueFull()) {
            return false;
        }

        // Check for duplicate ID
        if (idExistsInQueue(id)) {
            return false;
        }

        // First element
        if (front == -1) {
            front = 0;
        }

        // Circular queue logic
        rear = (rear + 1) % QUEUE_SIZE;

        // Store patient data
        queue[rear][0] = id;
        queue[rear][1] = name;
        queue[rear][2] = gender;
        queue[rear][3] = contact;
        queue[rear][4] = address;
        queue[rear][5] = age;

        return true;
    }

    // Remove patient from queue (Dequeue)
    public String[] dequeuePatient() {
        if (isQueueEmpty()) {
            return null;
        }

        String[] patient = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % QUEUE_SIZE;
        }

        return patient;
    }

    // Peek at front patient
    public String[] peekFrontPatient() {
        if (isQueueEmpty()) {
            return null;
        }
        return queue[front];
    }

    // ============ FIXED METHODS - Copy arrays properly ============

// Get all patients in queue (FIXED - creates copies)
public String[][] getAllQueuePatients() {
    if (isQueueEmpty()) {
        return new String[0][6];
    }

    int count = getQueueSize();
    String[][] patients = new String[count][6];

    int index = 0;
    int i = front;

    while (true) {
        // Create a NEW array and copy values (CRITICAL FIX)
        patients[index] = new String[6];
        for (int col = 0; col < 6; col++) {
            patients[index][col] = queue[i][col];
        }
        index++;
        
        if (i == rear) break;
        i = (i + 1) % QUEUE_SIZE;
    }

    return patients;
}

// Sort queue by ID (ascending)
public void sortQueueById() {
    if (isQueueEmpty() || getQueueSize() == 1) return;

    String[][] patients = getAllQueuePatients();

    // Bubble sort by ID
    for (int i = 0; i < patients.length - 1; i++) {
        for (int j = 0; j < patients.length - i - 1; j++) {
            try {
                int id1 = Integer.parseInt(patients[j][0]);
                int id2 = Integer.parseInt(patients[j + 1][0]);

                if (id1 > id2) {
                    String[] temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            } catch (NumberFormatException e) {
                if (patients[j][0].compareTo(patients[j + 1][0]) > 0) {
                    String[] temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }
    }

    rebuildQueueDirect(patients);
}

// Sort queue by Name (ascending)
public void sortQueueByName() {
    if (isQueueEmpty() || getQueueSize() == 1) return;

    String[][] patients = getAllQueuePatients();

    // Bubble sort by Name
    for (int i = 0; i < patients.length - 1; i++) {
        for (int j = 0; j < patients.length - i - 1; j++) {
            if (patients[j][1].compareToIgnoreCase(patients[j + 1][1]) > 0) {
                String[] temp = patients[j];
                patients[j] = patients[j + 1];
                patients[j + 1] = temp;
            }
        }
    }

    rebuildQueueDirect(patients);
}

// Rebuild queue directly (FIXED - copies values, not references)
private void rebuildQueueDirect(String[][] patients) {
    // Reset queue
    front = -1;
    rear = -1;
    
    // Add each patient directly
    for (String[] patient : patients) {
        if (front == -1) {
            front = 0;
        }
        
        rear = (rear + 1) % QUEUE_SIZE;
        
        // Initialize new array for this slot (CRITICAL FIX)
        queue[rear] = new String[6];
        
        // Copy each value (not the reference)
        queue[rear][0] = patient[0];
        queue[rear][1] = patient[1];
        queue[rear][2] = patient[2];
        queue[rear][3] = patient[3];
        queue[rear][4] = patient[4];
        queue[rear][5] = patient[5];
    }
} 
public int getQueueSize() {
    if (isQueueEmpty()) return 0;

    if (rear >= front) {
        return rear - front + 1;
    } else {
        return QUEUE_SIZE - front + rear + 1;
    }
}
public boolean idExistsInQueue(String id) {
    if (isQueueEmpty()) return false;

    int i = front;
    while (true) {
        if (queue[i][0].equals(id)) {
            return true;
        }
        if (i == rear) break;
        i = (i + 1) % QUEUE_SIZE;
    }
    return false;
}

}



