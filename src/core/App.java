/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import controllers.Controller;
import controllers.UserController;
import javax.swing.SwingUtilities;
import models.Model;
import models.User;
import views.LoginFrame;
import views.View;

/**
 * This class creates and manages other controllers, It does the database
 * connection stuff, constructs the MainFrame, and displays the GUI of the app.
 *
 * @author otsaan
 */
public class App {

    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserController userController = new UserController();

                LoginFrame loginFrame = new LoginFrame();
                loginFrame.addObserver(userController);

                loginFrame.setVisible(true);
            }
        });

        /* 
         * This is the recommended way to create a Swing
         * event dispatch thread -- i.e. to run a Swing
         * program.
         */
        /*SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
         runApp();
         }
         });*/
    }

    public static void runApp() {

        UserController userController = new UserController();

        LoginFrame loginFrame = new LoginFrame();
        loginFrame.addObserver(userController);

        loginFrame.setVisible(true);

        // once the user logged in successfully then >> View.setVisible(true)
        //Controller controller = new Controller(view, model);
    }

}
