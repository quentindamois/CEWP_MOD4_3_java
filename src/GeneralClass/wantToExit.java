package GeneralClass;

public class wantToExit extends Exception {
    /**
     * This is the wantToExit class. This class extends the exception class. It is thrown when a string variable is null.
     * */
    /**
     * This is the default constructor of the wantToExit class.
     * */
    public wantToExit() {
        super("You are exiting the program, goodbye.");
    }
}
