import MainFrame.MainFrame;
import icons.Play;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            MainFrame mainFrame = new MainFrame();
            Play c=new Play("background.mp3");
            c.start();

        });
    }
}
