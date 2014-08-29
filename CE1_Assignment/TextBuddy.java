import java.util.Scanner;

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
	//private static final String MESSAGE_NO_SPACE = "No more space to store"; 
	//Maximum of 10 strings can be save only in the array using this textbuddy
	
	private static final String ERROR_INVALID_COMMAND = "Error: Invalid command. Command \"%1$s\" does not exist";
	private static final String ERROR_DOESNT_EXIST = "Error: Unable to delete \"%1$s\"";
	private static final String ERROR_CANT_ADD = "Error: Unable to add \"%1$s\"";
	
	enum COMMAND_TYPE {
		ADD_TEXT, REMOVE_TEXT, CLEAR_ALL, INVALID, EXIT
	};
	
	private static final int SLOT_UNAVAILABLE = -1;
	private static final int NOT_FOUND = -2;
	
	private static final int PARAM_START = 0;
	private static final int NUM_TEXT = 10;
	private static final String[] textList = new String[NUM_TEXT];
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		showToUser(WELCOME_MESSAGE);
		while (true) {
			showToUser(MESSAGE_COMMAND);
			String userCommand = sc.nextLine();
			showToUser(executeCommand(userCommand));
		}
	}
	
	private static void showToUser(String text){
		System.out.print(text);
	}
	
	private static void exit() {
		System.exit(0);
	}
	
	public static String executeCommand(String userCommand){
		if (userCommand.trim().equals("")){
			return String.format(MESSAGE_INVALID_COMMAND, userCommand);
		}
		String commandTypeString = getFirstWord(userCommand);
		COMMAND_TYPE commandType = determineCommandType(commandTypeString);
		
		switch (commandType) {
			case  ADD_TEXT: {
				return addText(userCommand);
			}
			case REMOVE_TEXT: {
				return removeText(userCommand);
			}
			case CLEAR_ALL: {
				return clearAllText(userCommand);
			}
			case INVALID: {
				return String.format(ERROR_INVALID_COMMAND, userCommand);
			}
			case EXIT: {
				exit();
			}
			default: {
				throw new Error("Unrecognized command type");
			}
		}
	}
	
	private static COMMAND_TYPE determineCommandType(String commandTypeString){
		if (commandTypeString == null){
			throw new Error("Command cannot be null!");
		}
		
		if (commandTypeString.equalsIgnoreCase("add")) {
			return COMMAND_TYPE.ADD_TEXT;
		}
		else if (commandTypeString.equalsIgnoreCase("delete")) {
			return COMMAND_TYPE.REMOVE_TEXT;
		}
		else if (commandTypeString.equalsIgnoreCase("clear")) {
			return COMMAND_TYPE.CLEAR_ALL;
		}
		else if (commandTypeString.equalsIgnoreCase("exit")) {
			return COMMAND_TYPE.EXIT;
		}
		else {
			return COMMAND_TYPE.INVALID;
		}
	}
	
	private static String addText(String userCommand){
		String textToBeAdded = removeFirstWord(userCommand);
		int i = 0;
		while (i<NUM_TEXT){
			if (textList[i] != null){
				i++;
			}
			else {
				textList[i] = textToBeAdded;
				return String.format(MESSAGE_ADD, textToBeAdded);
			}
		}
		return String.format(ERROR_CANT_ADD, textToBeAdded);
	}
	
	private static String removeText (String userCommand) {
		String textToBeRemoved = removeFirstWord(userCommand);
		int i = 0;
		while (i<NUM_TEXT){
			if (textToBeRemoved.equals(textList[i])){
				textList[i] = null;
			}
			else {
				return String.format(ERROR_DOESNT_EXIST, textToBeRemoved);
			}
		}
	}
	
	private static String clearAllText (String userCommand){
		String clearAll = removeFirstWord(userCommand);
		for (int i=0; i<NUM_TEXT; i++) {
			textList[i] = null;
		}
	}
	
	private static String removeFirstWord(String userCommand) {
		return userCommand.replace(getFirstWord(userCommand), "").trim();
	}
	
	private static String getFirstWord(String userCommand) {
		String commandTypeString = userCommand.trim().split("\\s+")[0];
		return commandTypeString;
	}
	
	

}
