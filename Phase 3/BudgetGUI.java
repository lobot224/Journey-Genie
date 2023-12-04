import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetGUI {
    private static Budget myBudget = new Budget();
    private static JFrame mainFrame;
    private static JFrame setBudgetFrame;
    private static JFrame editBudgetFrame;

    public static void main() {
        SwingUtilities.invokeLater(() -> {
            mainFrame = new JFrame("Budget Manager");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(300, 150);

            JPanel panel = new JPanel();
            mainFrame.getContentPane().add(panel, BorderLayout.CENTER);
            placeComponents(panel);

            mainFrame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton setBudgetButton = new JButton("Set Initial Budget");
        JButton editBudgetButton = new JButton("Edit Budget");
        JButton viewBudgetButton = new JButton("View Budget"); // New button

        panel.add(setBudgetButton);
        panel.add(editBudgetButton);
        panel.add(viewBudgetButton);

        setBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBudgetDialog();
            }
        });

        editBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBudgetDialog();
            }
        });

        viewBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBudget();
            }
        });
    }

    private static void setBudgetDialog() {
        setBudgetFrame = new JFrame("Set Initial Budget");
        setBudgetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBudgetFrame.setSize(300, 150);

        JPanel panel = new JPanel();
        setBudgetFrame.getContentPane().add(panel, BorderLayout.CENTER);
        placeSetBudgetComponents(panel);

        setBudgetFrame.setVisible(true);
    }

    private static void placeSetBudgetComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter Initial Budget:");
        JTextField budgetField = new JTextField();

        JButton confirmButton = new JButton("Set Budget");

        panel.add(label);
        panel.add(budgetField);
        panel.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String budgetText = budgetField.getText();
                try {
                    double budget = Double.parseDouble(budgetText);
                    myBudget.setBudget(budget);
                    JOptionPane.showMessageDialog(setBudgetFrame, "Budget set successfully!");
                    setBudgetFrame.dispose();
                    initializeMainFrame();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(setBudgetFrame, "Invalid input. Please enter a valid number.");
                }
            }
        });
    }

    private static void editBudgetDialog() {
        editBudgetFrame = new JFrame("Edit Budget");
        editBudgetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editBudgetFrame.setSize(300, 150);

        JPanel panel = new JPanel();
        editBudgetFrame.getContentPane().add(panel, BorderLayout.CENTER);
        placeEditBudgetComponents(panel);

        editBudgetFrame.setVisible(true);
    }

    private static void placeEditBudgetComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter additional amount you would like to add:");
        JTextField editField = new JTextField();

        JButton confirmButton = new JButton("Update Budget");

        panel.add(label);
        panel.add(editField);
        panel.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String editAmountText = editField.getText();
                try {
                    double editAmount = Double.parseDouble(editAmountText);
                    myBudget.updateBudget(editAmount);
                    JOptionPane.showMessageDialog(editBudgetFrame, "Budget updated successfully!");
                    editBudgetFrame.dispose();
                    initializeMainFrame();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(editBudgetFrame, "Invalid input. Please enter a valid number.");
                }
            }
        });
    }

    private static void viewBudget() {
        JOptionPane.showMessageDialog(mainFrame, "Current Budget: $" + myBudget.getBudget());
    }

    public static void initializeMainFrame() {
        mainFrame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        mainFrame.getContentPane().add(panel, BorderLayout.CENTER);
        placeComponents(panel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
