package DuplicateElimination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import GeneralClass.Security.*;
public class JUserIneteraction extends JFrame{
    private JPanel panel;
    /*
    private JLabel textNameAdd;
    private JLabel textNameSearch;
    */
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
        this.buttonNameAdd = new JButton("Press to add a name");
        this.buttonNameSearch = new JButton("Press to search a name");
        this.namesSet = new HashSet<>();
        this.buttonNameAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namesSet.add(GeneralClass.Security.safeNameInput("Enter the name you want to add :"));
                System.out.println(namesSet);
            }
        });
        this.buttonNameSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JOptionPane.showMessageDialog(null,namesSet.contains(GeneralClass.Security.safeNameInput("Enter the name you want to search")) ? "The set contain the inputed name" : "The set does not contain the name");
            }
        });

        //this.panel.setLayout(new GridLayout(1, 2));
        this.panel.add(buttonNameAdd);
        this.panel.add(buttonNameSearch);
    }
    public static void main(String[] arg) {
        new JUserIneteraction();
    }
}
