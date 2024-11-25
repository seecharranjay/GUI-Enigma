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
        public void actionPerformed(ActionEvent e) {
        boolean isEncrypt = e.getSource() == encryptButton;

        try {

            int innerId = innerRotor.getSelectedIndex() + 1;
            int middleId = middleRotor.getSelectedIndex() + 1;
            int outerId = outerRotor.getSelectedIndex() + 1;

            String positions = initialPositions.getText().toUpperCase();
            if (positions.length() != 3 || !positions.matches("[A-Z]{3}")) {
                outputText.setText("Error!");
                return;
            }

            String input = inputText.getText().toUpperCase();
            if (input.isEmpty()) {
                outputText.setText("Error!");
                return;
            }

            Enigma enigma = new Enigma(innerId, middleId, outerId, positions);

            String output;
            if (isEncrypt) {
                output = enigma.encrypt(input);
            } else {
                output = enigma.decrypt(input);
            }

            outputText.setText(output);
        } catch (Exception ex) {
            outputText.setText("Error: " + ex.getMessage());
        }
    }
    }
    

}
