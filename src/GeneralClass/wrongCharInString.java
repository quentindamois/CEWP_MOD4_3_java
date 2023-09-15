package GeneralClass;



public class wrongCharInString extends Exception {
    /**
     * This the wrong charInString class. It is an extention of the class Exception.
     * The expetion is thrown when a incohernet charcter is found in a String.
     * */
    /**
     * this is the default builder of the wrongCharInString class.
     * */
    public wrongCharInString() {
        super("ERROR ! Wrong kind type of character inserted inside.\nPLease enter something logical.");
    }
    /**
     * THis constructior has parameter in order to show the user what character was wrong.
     * @param letter : wrong char found in the string.
     * */
    public wrongCharInString(char letter) {
        super("ERROR ! " + letter + " shouldn't not be inserted in the String.");
    }
}
