package Controller;

import Models.Model;  // <-- NEW: Import your Model class

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

    // NEW: Enqueue directly from a Model object (perfect for AddPatient)
    public boolean enqueuePatient(Model patient) {
        if (patient == null) {
            return false;
        }
        return enqueuePatient(
            String.valueOf(patient.getId()),
            patient.getName(),
            patient.getGender(),
            patient.getContact(),
            patient.getAddress(),
            String.valueOf(patient.getAge())
        );
    }

    // Keep your existing enqueuePatient for backward compatibility
    public boolean enqueuePatient(String id, String name, String gender,
                                  String contact, String address, String age) {
        if (id.isEmpty() || name.isEmpty() || gender.isEmpty()) {
            return false;
        }
        if (isQueueFull()) {
            return false;
        }
        if (idExistsInQueue(id)) {
            return false;
        }

        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % QUEUE_SIZE;

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

    // Get all patients in queue
    public String[][] getAllQueuePatients() {
        if (isQueueEmpty()) {
            return new String[0][6];
        }
        int count = getQueueSize();
        String[][] patients = new String[count][6];
        int index = 0;
        int i = front;
        while (true) {
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

    private void rebuildQueueDirect(String[][] patients) {
        front = -1;
        rear = -1;
        for (String[] patient : patients) {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % QUEUE_SIZE;
            queue[rear] = new String[6];
            System.arraycopy(patient, 0, queue[rear], 0, 6);
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

    // Update Patient
    public boolean updatePatient(int logicalIndex, String[] patientData) {
        if (patientData[0].isEmpty() || patientData[1].isEmpty() || patientData[2].isEmpty()) {
            return false;
        }
        if (patientData[3].length() < 9) {
            return false;
        }
        if (isQueueEmpty()) {
            return false;
        }
        int queueSize = getQueueSize();
        if (logicalIndex < 0 || logicalIndex >= queueSize) {
            return false;
        }
        int physicalIndex = (front + logicalIndex) % QUEUE_SIZE;
        queue[physicalIndex] = new String[6];
        System.arraycopy(patientData, 0, queue[physicalIndex], 0, 6);
        return true;
    }

    // Dummy patients updated with proper String IDs
    public void addDummyPatients() {
        enqueuePatient("1", "Ram Sharma", "Male", "9800000001", "Kathmandu", "25");
        enqueuePatient("2", "Sita Rai", "Female", "9800000002", "Pokhara", "30");
        enqueuePatient("3", "Hari Thapa", "Male", "9800000003", "Lalitpur", "45");
        enqueuePatient("4", "Gita Karki", "Female", "9800000004", "Bhaktapur", "38");
        enqueuePatient("5", "Nabin KC", "Male", "9800000005", "Chitwan", "50");
    }
    public String[] findPatientById(String patientId) {
    if (isQueueEmpty()) return null;

    int i = front;
    while (true) {
        if (queue[i][0].equals(patientId)) {
            return queue[i];
        }
        if (i == rear) break;
        i = (i + 1) % QUEUE_SIZE;
    }
    return null;
}
    private String[][] lastBackup = null;

public void backupQueue() {
    lastBackup = getAllQueuePatients(); // snapshot
}

public boolean undoQueue() {
    if (lastBackup == null) return false;

    // clear queue by dequeuing everything
    int size = getQueueSize();
    for (int i = 0; i < size; i++) {
        dequeuePatient();
    }

    // restore
    for (String[] p : lastBackup) {
        enqueuePatient(p[0], p[1], p[2], p[3], p[4], p[5]);
    }

    lastBackup = null; // optional: only allow one undo
    return true;
}
public boolean undoLastDeletedPatient() {
    String[] p = DeletedPatient.getInstance().pop();
    if (p == null) return false;

    // If queue is full, you can't restore
    if (isQueueFull()) return false;

    // re-add patient to queue
    return enqueuePatient(p[0], p[1], p[2], p[3], p[4], p[5]);
}
}