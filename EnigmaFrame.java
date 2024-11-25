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

        JPanel rotorPanel = new JPanel(new FlowLayout());
        rotorPanel.add(new JLabel("Inner"));
        rotorPanel.add(inner);
        rotorPanel.add(new JLabel("Middle"));
        rotorPanel.add(middle);
        rotorPanel.add(new JLabel("Out"));
        rotorPanel.add(outer);
        rotorPanel.add(new JLabel("Initial Positions"));
        rotorPanel.add(intPos);
        rotorPanel.add(encrypt);
        rotorPanel.add(decrypt);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input"), BorderLayout.NORTH);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output"), BorderLayout.NORTH);

        ConverterActionListener a = new EnigmaActionListener();

        encrypt.addActionListener(a); 
        decrypt.addActionListener(a);

        this.add(rotorPanel);
        this.add(inputPanel);
        this.add(outputPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        
    }

    private class EnigmaActionListener implements ActionListener {
        
    }

}
