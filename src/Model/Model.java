/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import View.HomePage;
import View.AdminLoginPage;
import View.UserLogin;
import View.AddPatient;
import Controll.Controll;
import Controll.PatientQueueController;
        
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author upash
 */

public class Model {
    
     LinkedList<Model>PatientList = new LinkedList<>();
    
    private int id;
    private String name;
    private String gender;
    private String contact;
    private int age;
    private String address;

    // Constructor
    public Model(int id, String name, String gender,
                 String contact, int age, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contact = contact;
        this.age = age;
        this.address = address;
    }

    // Getters
    public int getId() { 
        return id;
    }
    public String getName() { 
        return name;
    }
    public String getGender() { 
        return gender;
    }
    public String getContact() {
        return contact;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() { 
        return address;
    }

    // Setters
    public void setContact(String contact) {
        this.contact = contact;
    }


        
    
    public class allConstants {
    public static final String LOGIN_KEY = "1234";
    public static final String USER_KEY = "Admin";
        
    }
     


    
}
