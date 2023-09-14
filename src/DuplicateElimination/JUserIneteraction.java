package DuplicateElimination;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class JUserIneteraction extends JFrame{
    private JPanel panel;
    private JLabel textResult;
    private JLabel textNameAdd;
    private JLabel textNameSearch;
    private JTextField inputNameAdd;
    private JTextField inputNameSearch;
    private JButton buttonNameAdd;
    private JButton buttonNameSearch;
    private HashSet<String> namesSet;
    private final int WINDOW_WIDTH = 700;
    private final int WINDOW_HEIGHT = 700;
    public JUserIneteraction() {
        setTitle("Set of Name");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addContent();
        add(panel);
        setVisible(true);
    }
    public void addContent() {
        this.panel = new JPanel();
        this.textResult = new JLabel("");
        this.textNameAdd = new JLabel("Enter a name here to add it to the set of name :");
        this.textNameSearch = new JLabel("Enter a name here to search it in the set of name :");
        this.inputNameAdd = new JTextField();
        this.inputNameSearch = new JTextField();
        this.buttonNameAdd = new JButton();
        this.buttonNameSearch = new JButton();



        this.panel.setLayout(new GridLayout(3, 2));
        this.panel.add(textNameAdd);
        this.panel.add(textNameSearch);
        this.panel.add(inputNameAdd);
        this.panel.add(inputNameSearch);
        this.panel.add(buttonNameAdd);
        this.panel.add(buttonNameSearch);
    }
    public static void main(String[] arg) {
        new JUserIneteraction();
    }
}
