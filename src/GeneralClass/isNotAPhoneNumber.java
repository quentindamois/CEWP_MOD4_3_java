package GeneralClass;

public class isNotAPhoneNumber extends Exception{
    /**
     * This is isNotAPhoneNumber class. It is an extention of the Exception class.
     * It is trown when the stirng ananlyse does not correspond to the patter of the international phone number format.
     * */
    /**
     * This is the default construcitor of the isNotAPhoneNumber class.
     * */
    public isNotAPhoneNumber() {
        super("ERROR ! The string entered is not a phone number.");
    }
    /**
     * This constructor has a parameter to show the user the wrong phone number.
     * @param badPhoneNumber : It is the phone number inputed by the user.
     * */
    public isNotAPhoneNumber(String badPhoneNumber) {
        super("ERROR ! " + badPhoneNumber + "is not a phone number.");
    }
}
