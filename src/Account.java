import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Account implements ActionListener{
    private int id;
    private double balance;
    private int stage = 0;
    GUI gui;
    Account[] actArr = new Account[10];
    public Account(GUI gui) {
        this.gui = gui;
    }
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Start" && stage == 0) {
            for (int i = 0; i < 10; i++) {
                actArr[i] = new Account(i, 100);
                }
            stage = 1;
            gui.topLabel.setText("Enter id between 0 and 9");
            gui.goButton.setVisible(true);
            gui.startButton.setVisible(false);
        }
        else if (e.getActionCommand() == "Start" && stage == 3) {
            stage = 1;
            gui.topLabel.setText("Enter id between 0 and 9");
            gui.goButton.setVisible(true);
            gui.startButton.setVisible(false);
        }
        if (e.getActionCommand() == "GO" && stage == 1) {
            try {
                int tfValue = Integer.parseInt(gui.tf.getText());
                if (tfValue < 0 || tfValue > 9) {
                    gui.topLabel.setText("invalid id");
                }
                else {
                    gui.topLabel.setText("If depositing or withdrawing, enter amount then corresponding button.");
                    stage = 2;
                    id = tfValue;
                    gui.tf.setText("");
                    gui.checkBalanceButton.setVisible(true);
                    gui.withdrawButton.setVisible(true);
                    gui.depositButton.setVisible(true);
                    gui.exitButton.setVisible(true);
                    gui.goButton.setVisible(false);
                }
        } catch (Exception a) {
                gui.topLabel.setText("You didn't enter a number, please re enter");;
            }        // TODO
        }
        else if (e.getActionCommand() == "Check Balance" && stage == 2) {
                gui.topLabel.setText("Balance: " + Double.toString(actArr[id].balance) + "$");
            }
        else if (e.getActionCommand() == "Withdraw" && stage == 2) {
                try {
                    double tfValue = Double.parseDouble(gui.tf.getText());
                    if (tfValue < actArr[id].balance) {
                        gui.topLabel.setText("Withdrawing: " + tfValue);
                        actArr[id].balance = actArr[id].balance - tfValue;
                        gui.tf.setText("");
                    }
                    else {
                        gui.topLabel.setText("You don't have enough in your account type in lesser amount and " + 
                        "re-click withdraw.");
                    }



                } catch (Exception e2) {
                    gui.topLabel.setText("You didn't enter a number. Try again");
                }
            }
        else if (e.getActionCommand() == "Deposit" && stage == 2) {
                try {
                    double tfValue = Double.parseDouble(gui.tf.getText());
                    if (tfValue > 0) {
                        gui.topLabel.setText("Depositing: " + tfValue);
                        actArr[id].balance = actArr[id].balance + tfValue;
                        gui.tf.setText("");
                    }
                    else {
                        gui.topLabel.setText("You can't deposit a negative number. re-enter and click deposit.");
                    }
                } catch(Exception e3) {
                    gui.topLabel.setText("You didn't enter a number.");
                }
            }
        else if (e.getActionCommand() == "Exit") {
                stage = 3;
                gui.checkBalanceButton.setVisible(false);
                gui.withdrawButton.setVisible(false);
                gui.depositButton.setVisible(false);
                gui.exitButton.setVisible(false);
                gui.startButton.setVisible(true);
                gui.topLabel.setText("Click Start");

        }

        }
        
    }
    

