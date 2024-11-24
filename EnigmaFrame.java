import javax.swing.*;


public static void main(String args[]) {
        JFrame f = new JFrame();
        f.setTitle("GUI Enigma"); // sets title that appears on the top bar
        f.setSize(700, 500);          // sets the size (in pixels) of the frame
        f.setLocation(100, 100);      // sets the top-left corner of the window on the desktop
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes it so that closing window exits program
        f.setVisible(true);
}