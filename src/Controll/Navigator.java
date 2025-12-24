/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;

/**
 *
 * @author upash
 */
// File: controller/Navigator.java


import View.AddPatient;
import View.AdminPannel;
import View.AdminLoginPage;
import View.CheckUp;
import View.UserLogin;
// Add imports for all your View classes

import javax.swing.JFrame;

public class Navigator {
    private static JFrame currentFrame;

    // Hide current and show new frame
    private static void switchTo(JFrame newFrame) {
        if (currentFrame != null) {
            currentFrame.dispose();
        }
        newFrame.setVisible(true);
        currentFrame = newFrame;
    }

    public static void showAdminLogin() {
        switchTo(new AdminLoginPage());
    }

    public static void showAdminPanel() {
        switchTo(new AdminPannel());
    }

    public static void showAddPatient() {
        switchTo(new AddPatient());
    }

    public static void showCheckUp() {
        switchTo(new CheckUp());
    }

    public static void showUserLogin() {
        switchTo(new UserLogin());
    }

    // Optional: go back to login on logout
    public static void logout() {
        switchTo(new AdminLoginPage());
    }
}
