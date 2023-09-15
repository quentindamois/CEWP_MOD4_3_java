package GeneralClass;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Security {
    /**
     * This is the scercurity class. The class stored static method used to handle exeption.
     * */
    /**
     * This is the safeIntInput method. It prevents NumberFormatExeption to appear when inputing an int.
     * @param question : this string is displayed in the screen when the user is asked to input an int.
     * @return res : the int inputed by the user.
     * */
    public static int safeIntInput(String question) {
        int res;
        try {
            String tempoInput = JOptionPane.showInputDialog(question);
            if (tempoInput == null) throw new wantToExit();
            res = Integer.parseInt(tempoInput);
        }
        catch (wantToExit mistake) {
            res = 0;
            JOptionPane.showMessageDialog(null,mistake.getMessage());
            System.exit(0);
        }
        catch (NumberFormatException expetionNumberCustomer) {
            JOptionPane.showMessageDialog(null,"ERROR !\nYou must input an interger !");
            res = safeIntInput(question);
        }
        return res;
    }
    /**
     * This is the safeNameInput method. It prevents the user to enter an incoherent name or address.
     * @param question : this string is displayed in the screen when the user is asked to input a String.
     * @return res : the String inputed by the user.
     * */
    public static String safeNameInput(String question)  {
        String res;
        try {
        Pattern pattern = Pattern.compile("[^A-z\s0-9\\-ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØŒŠþÙÚÛÜÝŸàáâãäåæçèéêëìíîïðñòóôõöøœšÞùúûüýÿ]");
            res = JOptionPane.showInputDialog(question);
            if (res == null) throw new wantToExit();
            Matcher matcher = pattern.matcher(res);
            if (matcher.find()) throw new wrongCharInString();
        }
        catch (wantToExit mistake) {
            res = "";
            JOptionPane.showMessageDialog(null,mistake.getMessage());
            System.exit(0);
        }
        catch (wrongCharInString mistake) {
            JOptionPane.showMessageDialog(null, mistake.getMessage());
            res = safeNameInput(question);
        }
        return res;
    }
    /**
     * This is the safePhoneNumberInput method. It prevents the user to enter an incoherent phone number.
     * @param question : this string is displayed in the screen when the user is asked to input a String.
     * @return res : the String inputed by the user.
     * */
    public static String safePhoneNumberInput(String question) {
        String res;
        try {
            Pattern pattern = Pattern.compile("\\+\\d{0,1}-{0,1}\\d{1,3}\\s\\d{1,3}\\s\\d{2}\\s\\d{2}\\s\\d{2}\\s\\d{2}||\\+\\d{0,1}-{0,1}\\d{1,3}\\s\\d{1,3}\\s\\d{3,4}\\s\\d{4}");
            res = JOptionPane.showInputDialog(question);
            if (res == null) throw new wantToExit();
            Matcher matcher = pattern.matcher(res);
            if (!matcher.find()) throw new isNotAPhoneNumber();
        }
        catch(wantToExit mistake) {
            res = "";
            JOptionPane.showMessageDialog(null, mistake.getMessage());
            System.exit(0);
        }
        catch(isNotAPhoneNumber mistake) {
            JOptionPane.showMessageDialog(null, mistake.getMessage());
            res = safePhoneNumberInput(question);
        }
        return res;
    }
    /**
     * This is the safeBooleanInput method. It prevents the user to enter anything than true or false.
     * @param question : this string is displayed in the screen when the user is asked to input a String.
     * @return res : the String inputed by the user.
     * */
    public static boolean safeBooleanInput(String question) {
        boolean res;
        try {
            Pattern pattern = Pattern.compile("true|false");
            String tempoInput = JOptionPane.showInputDialog(question);
            if (tempoInput == null) throw new wantToExit();
            Matcher macther = pattern.matcher(tempoInput);
            if (!macther.find()) throw new NumberFormatException();
            res = Boolean.parseBoolean(tempoInput);
        }
        catch(wantToExit mistake) {
            res = false;
            JOptionPane.showMessageDialog(null, mistake.getMessage());
            System.exit(0);
        }
        catch(NumberFormatException mistake) {
            JOptionPane.showMessageDialog(null, "ERROR ! You must enter true or false.\nBecareful it is case sensitive.");
            res = safeBooleanInput(question);
        }
        return res;
    }
    /**
     * This is the display tring method.
     * This static methor take a set of string and return a String containing every entity in the set separated by ", ".
     * */
    public static String displayStringSet(HashSet<String> displayedSet) {
        String StringNameSet = "";
        for(String firstname : displayedSet) {
            StringNameSet += firstname + ", ";
        }
        System.out.println(StringNameSet);
        StringBuilder res = new StringBuilder(StringNameSet);
        System.out.println(StringNameSet);
        return res.substring(0, res.length() - 2);
    }
    }



