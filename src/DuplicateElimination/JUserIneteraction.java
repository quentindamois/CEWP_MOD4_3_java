package DuplicateElimination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import GeneralClass.Security;
import GeneralClass.Security.*;
public class JUserIneteraction extends JFrame{
    /**
     * This is the JUserIneteraction class. This is a subclass of JFrame.
     * This frame hoed the two button letting the user add name to the set of name or search a name in the set of name.
     * */
    /**
     * panel is a field on which store the button.
     * */
    private JPanel panel;
    /**
     * This is the button display a input window that let the user add a name.
     * */
    private JButton buttonNameAdd;
    /**
     * This button diasplay a window that let user input a first name to be search in the name.
     * */
    private JButton buttonNameSearch;
    /**
     * This set store all the name inputed by the user.
     * */
    private HashSet<String> namesSet;
    /**
     * WINDOW_HEIGHT is an int constant used to define the window height.
     * */
    private final int WINDOW_WIDTH = 350;
    /**
     * This is the constructor of the class RollingDice that is used to start the method that roll dice.
     * */
    private final int WINDOW_HEIGHT = 75;
    /**
     * The constructor JUserIneteraction generate the window with the two button.
     * */
    public JUserIneteraction() {
        setTitle("Set of Name");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addContent();
        add(panel);
        setVisible(true);
    }
    /**
     * This function create the panel and add the two buttons to panel.
     * It also add the event listener to the button.
     * */
    public void addContent() {
        this.panel = new JPanel();
        this.buttonNameAdd = new JButton("Press to add a name");
        this.buttonNameSearch = new JButton("Press to search a name");
        this.namesSet = new HashSet<>();
        /**
         * To add an actionListener we implement the interface with a anonymous class.
         * */
        this.buttonNameAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * This method use the static method safeNameInput to ask a name to the user
                 * and adding it tot the set.
                 * */
                String nameToBeInputed = GeneralClass.Security.safeNameInput("Enter the name you want to add :");
                namesSet.add(nameToBeInputed);
                JOptionPane.showMessageDialog(null, nameToBeInputed + " was inputed in the set.");
            }
        });
        /**
         * To add an actionListener we implement the interface with a anonymous class.
         * */
        this.buttonNameSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * This method first use safeNameInput to let a user enter a name.
                 * The string inputed by the user is used in the contain method to see if the fist name is in the set.
                 * Depending on the boolean value returned one of two string is displayed by the JOptionPane.showMessageDialog.
                 * To display the content of the set we use displayStringSet from GeneralClass.Security.
                 * */
                  JOptionPane.showMessageDialog(null,namesSet.contains(GeneralClass.Security.safeNameInput("Enter the name you want to search")) ? "The set contain the inputed name" : "The set does not contain the name\nThe set contain : " + Security.displayStringSet(namesSet) + ".");
            }
        });

        this.panel.add(buttonNameAdd);
        this.panel.add(buttonNameSearch);
    }
    /**
     * The method main generation a JuserIneteraction() object.
     * */
    public static void main(String[] arg) {
        new JUserIneteraction();
    }
}
