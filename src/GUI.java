import java.awt.GridLayout;

import javax.swing.*;

public class GUI extends JFrame{
    Account act = new Account(this);
    JPanel top = new JPanel();
    JPanel middle = new JPanel();
    JPanel bottom = new JPanel();
    JLabel topLabel = new JLabel("Welcome, click Start.");
    JButton checkBalanceButton = new JButton("Check Balance");
    JButton withdrawButton = new JButton("Withdraw");
    JButton depositButton = new JButton("Deposit");
    JButton exitButton = new JButton("Exit");
    JButton goButton = new JButton("GO");
    JButton startButton = new JButton("Start");
    JTextField tf = new JTextField(10);
    public GUI() {
        super("atm gui app");
        initialSetup();
        setFrameLayout();
        addElement(null, null, topLabel, top);
        addElement(checkBalanceButton, null, null, middle);
        addElement(withdrawButton, null, null, middle);
        addElement(depositButton, null, null, middle);
        addElement(exitButton, null, null, middle);
        addElement(null, tf, null, bottom);
        addElement(goButton, null, null, bottom);
        addElement(startButton, null, null, bottom);
        checkBalanceButton.setVisible(false);
        withdrawButton.setVisible(false);
        depositButton.setVisible(false);
        exitButton.setVisible(false);
        goButton.setVisible(false);
        populateALs();
        
        add(top);
        add(middle);
        add(bottom);
        
        

        setVisible(true);
    }
    public void initialSetup() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
    }
    public void addElement(JButton button, JTextField tf, JLabel label, JPanel panel) {
        try {
            panel.add(button);
        } catch (Exception e) {
            // ignore error
        }
        try {
            panel.add(tf);
        } catch (Exception e) {
            // ignore error
        }
        try {
            panel.add(label);
        } catch (Exception e) {
            // ignore error
        }
        try {
            panel.add(panel);
        } catch (Exception e) {
            // ignore error
        }
    }
    private void setFrameLayout() {
        GridLayout grid = new GridLayout(3, 1);
        setLayout(grid);
    }
    private void populateALs() {
        checkBalanceButton.addActionListener(act);
        withdrawButton.addActionListener(act);
        depositButton.addActionListener(act);
        exitButton.addActionListener(act);
        goButton.addActionListener(act);
        startButton.addActionListener(act);
    }

}
