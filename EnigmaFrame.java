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
        super("Enigma"); 

        intPosition = new JTextField("AAA", 5);
        input = new JTextArea(5, 30);
        output = new JTextArea(5, 30);
        inner = new JComboBox<>(num);
        middle = new JComboBox<>(num);
        outer = new JComboBox<>(num);
        encrypt = new JButton("Encrypt");  
        decrypt = new JButton("Decrypt"); 
        output.setEditable(false);

        JPanel rotorPanel = new JPanel(new FlowLayout());
        rotorPanel.add(new JLabel("Inner"));
        rotorPanel.add(inner);
        rotorPanel.add(new JLabel("Middle"));
        rotorPanel.add(middle);
        rotorPanel.add(new JLabel("Out"));
        rotorPanel.add(outer);
        rotorPanel.add(new JLabel("Initial Positions"));
        rotorPanel.add(intPosition);
        rotorPanel.add(encrypt);
        rotorPanel.add(decrypt);
        
        /*
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input     "), BorderLayout.WEST);
        inputPanel.add(input, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output  "), BorderLayout.WEST);
        outputPanel.add(output, BorderLayout.CENTER);
        */

               
        

       
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel inputLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputLabelPanel.add(new JLabel("Input   "));
        JPanel inputTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputTextPanel.add(input);
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputLabelPanel, BorderLayout.WEST);
        inputPanel.add(inputTextPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel outputLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outputLabelPanel.add(new JLabel("Output"));
        JPanel outputTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outputTextPanel.add(output);
        outputPanel.setLayout(new BorderLayout());
        outputPanel.add(outputLabelPanel, BorderLayout.WEST);
        outputPanel.add(outputTextPanel, BorderLayout.CENTER);
        
    

        EnigmaActionListener a = new EnigmaActionListener();

        encrypt.addActionListener(a); 
        decrypt.addActionListener(a);

        this.setLayout(new BorderLayout());
        this.add(rotorPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(outputPanel, BorderLayout.SOUTH);
        

        // this.add(rotorPanel);
        // this.add(inputPanel);
        // this.add(outputPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        
    }

    private class EnigmaActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean isEncrypt = e.getSource() == encrypt;

            try {

                int innerId = inner.getSelectedIndex() + 1;
                int middleId = middle.getSelectedIndex() + 1;
                int outerId = outer.getSelectedIndex() + 1;

                String positions = intPosition.getText().toUpperCase();
                if (positions.length() != 3 || !positions.matches("[A-Z]{3}")) {
                    output.setText("Error!");
                    return;
                }

                String inputText = input.getText().toUpperCase();
                if (inputText.isEmpty()) {
                    output.setText("Error!");
                    return;
                }

                Enigma enigma = new Enigma(innerId, middleId, outerId, positions);

                String result;
                if (isEncrypt) {
                    result = enigma.encrypt(inputText);
                } else {
                    result = enigma.decrypt(inputText);
                }

                output.setText(result);
            } catch (Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        }
    }

    /*
    public static void main(String[] args) {
        EnigmaFrame j = new EnigmaFrame();
        j.setVisible(true);
    }
    */
    

}
