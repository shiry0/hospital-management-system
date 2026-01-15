package Model;

import java.util.LinkedList;

public class Model {
    // Permanent patient list (as before)
    public static LinkedList<Model> PatientList = new LinkedList<>();
    
    // NEW: Stack for LIFO operations (e.g., undo, recent patients, etc.)
    public static LinkedList<Model> PatientStack = new LinkedList<>();

    private int id;
    private String name;
    private String gender;
    private String contact;
    private int age;
    private String address;

    public Model(int id, String name, String gender, String contact, int age, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.age = age;
        this.address = address;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }
    public int getAge() { return age; }
    public String getAddress() { return address; }

    // --- PatientList methods (unchanged) ---
    public static void addPatient(Model patient) {
        PatientList.add(patient);
    }

    public static LinkedList<Model> getAllPatients() {
        return PatientList;
    }

    public static Model getPatientById(int id) {
        for (Model p : PatientList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // --- NEW: Stack Operations ---

    /** Push a patient onto the stack (LIFO) */
    public static void pushPatient(Model patient) {
        PatientStack.addLast(patient);  // addLast = push
    }

    /** Pop (remove and return) the most recently added patient */
    public static Model popPatient() {
        if (PatientStack.isEmpty()) {
            return null;
        }
        return PatientStack.removeLast();  // removeLast = pop
    }

    /** Peek at the top patient without removing */
    public static Model peekPatient() {
        if (PatientStack.isEmpty()) {
            return null;
        }
        return PatientStack.getLast();
    }

    /** Check if stack is empty */
    public static boolean isStackEmpty() {
        return PatientStack.isEmpty();
    }

    /** Get current stack size */
    public static int getStackSize() {
        return PatientStack.size();
    }

    /** Clear the entire stack */
    public static void clearStack() {
        PatientStack.clear();
    }

    /** Get all patients in stack (top to bottom) */
    public static LinkedList<Model> getStackPatients() {
        return new LinkedList<>(PatientStack);  // return copy for safety
    }

    // Your existing constants
    public class allConstants {
        public static final String LOGIN_KEY = "1234";
        public static final String USER_KEY = "Admin";
    }
}