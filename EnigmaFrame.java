import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {
    private JTextField intPosition;
    private JTextArea input;
    private JTextArea output;
    private JComboBox<String> inner;
    private JComboBox<String> middle;
    private JComboBox<String> outer;
    private JButton encrypt;
    private JButton decrypt;

    private final String[] num = {
        "1", "2", "3", "4", "5"
    };

    public EnigmaFrame() {
        super(); //idk what goes in parenthesis yet

        intPosition = new JTextField("AAA", 5);
        input = new JTextArea(5, 30);
        output = new JTextArea(5, 30);
        inner = new JComboBox<>(num);
        middle = new JComboBox<>(num);
        outer = new JComboBox<>(num);
        output.setEditable(false);
    }

}

/*
public static void main(String args[]) {
        JFrame f = new JFrame();
        f.setTitle("GUI Enigma"); // sets title that appears on the top bar
        f.setSize(700, 500);          // sets the size (in pixels) of the frame
        f.setLocation(100, 100);      // sets the top-left corner of the window on the desktop
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes it so that closing window exits program
        f.setVisible(true);
}
*/