package company.app;

public class App {

	public static void main(String[] args) {
		
		UserInterface ui = new UserInterface();
		
		// Variable that controls the execution/termination of the application
		boolean terminate = false;
		
		// Variable that holds the user's selected option
		int option = 0;
		
		// Print welcome message and menu options
		ui.printWelcomeMessage();
		ui.printMenuOptions();
		
		// Enter a loop of operations until the user chooses to exit the application
		while (!terminate) {
			
			switch (option) {
			
			case 0:
				option = ui.getUserMenuOption();
				if (option == -1) terminate = true;
				if (option == 9) {
					ui.printMenuOptions();
					option = 0;
				}
				break;
				
			case 1:
				ui.printAllEmployees();
				option = 0;
				break;
				
			case 2:
				ui.printEmployeeById();
				option = 0;
				break;
				
			case 3:
				ui.registerEmployee();
				option = 0;
				break;
				
			case 4:
				ui.updateEmployee();
				option = 0;
				break;
				
			case 5:
				ui.deleteEmployee();
				option = 0;
				break;
				
			case 6:
				terminate = true;
				break;
				
			default:
				System.err.println("Invalid option, please try again...");
				option = 0;
				break;
				
			}
			
		}
		
		// Print a goodbye message
		ui.printGoodbyeMessage();

	}

}
