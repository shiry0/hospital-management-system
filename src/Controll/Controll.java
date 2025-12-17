/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;
import View.HomePage;
import View.LoginPage;
import View.Register;
import Model.Model;
import Model.Model.allConstants;
import java.awt.Color;
/**
 *
 * @author upash
 */
public class Controll {

    private LoginPage view;

    public Controll(LoginPage view) {
        this.view = view;
        initController();
    }

    private void initController() {
        
    }
    


    private void login() {
        String password = view.getPassword();

        if(password.equals(allConstants.LOGIN_KEY)) {
            javax.swing.JOptionPane.showMessageDialog(view, "Login successful!");
            HomePage home = new HomePage();
            home.setVisible(true);
            view.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(view, "Invalid password. Try again.");
        }
    }

    public static void main(String[] args) {
        LoginPage loginView = new LoginPage();
        loginView.setVisible(true);
        
    }
        
}

