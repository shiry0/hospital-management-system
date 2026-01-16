    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Controller;
    import View.HomePage;
    import View.User_Panel;
    import View.AdminLoginPage;
    import View.UserLogin;
    import Models.Model;
    import Models.Model.allConstants;
    import java.awt.Color;
import javax.swing.JFrame;
    /**
     *
     * @author upash
     */
    public class Controll {


    private static void showFullScreenPanel(javax.swing.JPanel panel, String title) {

    JFrame frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setUndecorated(true);          // before visible
    frame.setContentPane(panel);

    frame.setVisible(true);              // show first
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // then maximize
}

        private AdminLoginPage view;

        public Controll(AdminLoginPage view) {
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
            AdminLoginPage loginView = new AdminLoginPage();
            loginView.setVisible(true);

        }
        
public static void showAddPatient() {
    showFullScreenPanel(new View.AddPatient(), "Add Patient Page");
}

public static void showAddMed() {
    showFullScreenPanel(new View.AddMed(), "Add Medicine Page");
}

public static void showPCheckup() {
    showFullScreenPanel(new View.PCheckup(), "Check Up Page");
}

public static void showPerscriptionPage() {
    showFullScreenPanel(new View.PrescriptionPage(""), "Prescription Page");
}
 
    }

