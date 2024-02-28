package exam_mz;

import java.awt.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                final AnimatorWindow frame = new AnimatorWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "An error occurred", e);
            }
        });
    }
}
