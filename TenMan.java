package services;

public class TenMan {

    public static void main(String[] args) {
        // Launch the main window for the UI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Initialize and display the Main Window
                MainWindow mainWindow = new MainWindow();
                mainWindow.initialize();  // Ensure the UI is initialized
            }
        });
    }
}
