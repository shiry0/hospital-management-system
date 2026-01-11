    package Controll;

    import View.AddPatient;
    import View.AdminPannel;
    import View.AdminLoginPage;
    import View.PCheckup;  // Assuming this is your JPanel version
    import View.AddMed;
    import View.PatientReport;
    import View.UserLogin;
    import View.User_Panel;
    import javax.swing.JFrame;
    import javax.swing.JPanel;

    public class Navigator {
        private static JFrame currentFrame;

        // For JPanel forms
       private static void switchToPanel(JPanel panel, String title) {
        if (currentFrame != null) {
            currentFrame.dispose();
        }

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setContentPane(panel);

        frame.setVisible(true);              // show first
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // then maximize

        currentFrame = frame;
    }

        // For JFrame forms (like AdminPannel)
        private static void switchTo(JFrame newFrame) {
            if (currentFrame != null) {
                currentFrame.dispose();
            }
            newFrame.setVisible(true);
            currentFrame = newFrame;
        }



        // CORRECT: AdminPannel is a JFrame
        public static void showAdminPanel() {
            switchTo(new AdminPannel());
        }

        public static void showAddPatient() {
            switchToPanel(new AddPatient(), "Add Patient");
        }

        public static void showPCheckup() {
             switchToPanel(new PCheckup(), "Patient Check-Up");
        }

        public static void showAddMed(){
            switchToPanel(new AddMed(),"Medicine add");
        }
       public static void showPrescriptionPage(String patientId) {
        switchToPanel(new View.PrescriptionPage(patientId), "Prescription");
       }
       public static void showUserPanel(String patientId) {
       switchToPanel(new User_Panel(patientId), "User Panel");
        }
       public static void showPatientReport(String patientId) {
        switchToPanel(new View.PatientReport(patientId), "Patient Report");
        }  
       public static void showAdminLoginPage() {
            switchTo(new AdminLoginPage());
        }
        public static void showUserLogin() {
            switchTo(new UserLogin());
        }
       

    }