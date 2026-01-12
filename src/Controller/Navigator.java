    package Controll;

    import View.AddPatient;
    import View.AdminPannel;
    import View.AdminLoginPage;
    import View.PCheckup;  // Assuming this is your JPanel version
    import View.AddMed;
    import View.PatientReport;
import View.PrescriptionPage;
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

        private static void switchToPanelWindow(JPanel panel, String title, int width, int height) {
    

    JFrame frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setContentPane(panel);

    frame.setSize(width, height);
    frame.setLocationRelativeTo(null); // center on screen
    frame.setResizable(false);         // optional
    frame.setVisible(true);

    currentFrame = frame;
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
        switchToPanel(new PrescriptionPage(patientId), "Prescription");
       }
       public static void showUserPanel(String patientId) {
       switchToPanel(new User_Panel(patientId), "User Panel");
        }
       public static void showPatientReport(String patientId) {
    switchToPanelWindow(
        new PatientReport(patientId),
        "Patient Report",
        700,   // width
        1000     // height
    );
}
       public static void showAdminLoginPage() {
            switchTo(new AdminLoginPage());
        }
        public static void showUserLogin() {
            switchTo(new UserLogin());
        }
       

    }