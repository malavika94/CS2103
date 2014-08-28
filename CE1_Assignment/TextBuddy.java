public class TextBuddy {
	
	private static final String WELCOME_MESSAGE = "Welcome to TextBuddy. mytextfile.txt"
			+ "is ready for use.";
	private static final String MESSAGE_ADDED = "added to mytextfile.txt"
			+ ""%1$s"";
	private static final String MESSAGE_CLEAR = "All content deleted from %1$s";
	private static final String MESSAGE_ADD = "Added \"%1$s\"";
	private static final String MESSAGE_EMPTY_DATA = "\"%1$s\" is empty.";
	private static final String MESSAGE_DELETE = "Deleted \"%1$s\"";
	private static final String MESSAGE_COMMAND = "command: ";
	private static final String MESSAGE_NO_SPACE = "No more space to store"; 
	//Maximum of 10 strings can be save only in the array using this textbuddy
	
	private static final String ERROR_INVALID_COMMAND = "Error: Invalid command. Command \"%1$s\" does not exist";
	private static final String ERROR_DOESNT_EXIST = "Error: Unable to delete \"%1$s\"";
	private static final String ERROR_CANT_ADD = "Error: Unable to add \"%1$s\"";
	
	enum COMMAND_TYPE {
		ADD_TEXT, REMOVE_TEXT, CLEAR_ALL, INVALID, EXIT
	};
	
	private static final int SLOT_UNAVAILABLE = -1;
	private static final int NOT_FOUND = -2;
	
	public static void main(String[] args) {
	}
}
