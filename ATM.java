public class ATM {
  private int balance;
  private int pin;
  
  //---------------------------------------------------------------------------------------------------------------------//
  // Constructor: Initializes ATM with a starting balance and a pin
  public ATM(int balance, int pin) {
    this.balance = balance;
    this.pin = pin;
  }
  //---------------------------------------------------------------------------------------------------------------------//
  // This method displays the main ATM menu options to the user
  public void displayMenu() {
    System.out.println("1. Check balance");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Change pin");
    System.out.println("5. Exit");
  }
  //---------------------------------------------------------------------------------------------------------------------//
  // Deposit method: Adds money to the balance
  public void deposit(int amount) {
    balance += amount;
    System.out.println("Successfully deposited: " + amount);
  }
  //---------------------------------------------------------------------------------------------------------------------//
  // Withdraw method: Subtracts money if balance is sufficient
  public void Withdraw(int amount) {
    if (balance < amount) {
      System.out.println("Insufficient Funds!");
      return;
    }
    balance -= amount;
    System.out.println("Successfully withdrawn: " + amount);
  }
  //---------------------------------------------------------------------------------------------------------------------//
  // Method to return the current balance
  public int getBalance() {
    return balance;
  }
  //---------------------------------------------------------------------------------------------------------------------//
  // Method to validate entered pin with the stored pin
  public boolean validatePin(int pin) {
    return this.pin == pin;
  }
  //---------------------------------------------------------------------------------------------------------------------//
  // Method to update/change pin
  public void changePin(int newPin) {
    pin = newPin;
    System.out.println("PIN changed successfully!");
  }
  //---------------------------------------------------------------------------------------------------------------------//
  // Main method: Program execution starts here
  public static void main(String[] args) {
    // Create an ATM object with initial balance 1000 and pin 1234
    ATM atm = new ATM(1000, 1234);

    // Ask user to enter the pin
    System.out.print("Enter the pin: ");
    int pin = Integer.parseInt(System.console().readLine());

    // Check if the entered pin is correct
    if (atm.validatePin(pin)) {
      int option = 0;

      // Loop until user chooses option 5 (Exit)
      while (option != 5) {
        // Display menu
        atm.displayMenu();

        // Read user choice
        option = Integer.parseInt(System.console().readLine());

        // Perform action based on choice
        switch (option) {
          case 1:
            // Show current balance
            System.out.println("Balance: " + atm.getBalance());
            break;

          case 2:
            // Deposit money
            System.out.print("Enter Amount: ");
            int amount = Integer.parseInt(System.console().readLine());
            atm.deposit(amount);
            break;

          case 3:
            // Withdraw money
            System.out.print("Enter Amount: ");
            amount = Integer.parseInt(System.console().readLine());
            atm.Withdraw(amount);
            break;

          case 4:
            // Change pin
            System.out.print("Enter New Pin: ");
            int newPin = Integer.parseInt(System.console().readLine());
            atm.changePin(newPin);
            break;

          case 5:
            // Exit program
            System.out.println("Thank you for using ATM!");
            break;

          default:
            System.out.println("Invalid option! Try again.");
        }
      }
    } else {
      // If pin is incorrect
      System.out.println("You have entered Invalid pin!");
    }
  }
}
