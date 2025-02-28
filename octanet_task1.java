import java.util.ArrayList;
import java.util.Scanner;
//  ATM class that contains all functionalities atm machine
class Atm{
    private String pin;
    private double balance;
    private ArrayList<String> tH;
    // Constructor to initialize ATM with a PIN and an initial balance.
    Atm(String pin,int balance){
        this.pin=pin;
        this.balance=balance;
        this.tH = new ArrayList<>();
        
    }
    //  Withdraws a specified amount from the account if funds are sufficient.
    public void withdraw(double x){
        if(x>0 && x<=balance){
            balance=balance-x;
            System.out.println("withdraw successfully"+ x);
            tH.add("withdraw amount"+ x);
        }
        else if(x>balance){
            System.out.println("Insufficient balance");
        }
        else{
            System.out.println("Invalid withdraw amount");
        }
    }
    // Displays the current balance.
    public  void balanceinquiry(){
        System.out.println("Your current balance:"+ balance);
        tH.add("balance Inquiry");
    }
    // Deposits a specified amount into the account.
    public void deposit(double x){
        balance=balance+x;
        System.out.println("deposit successfully"+ x);
        tH.add("deposited amount"+ x);
        
    }
    // Changes the user's PIN after verification.
    public void pinchange(String oldpin,String newpin){
        if(oldpin.equals(this.pin)){
            this.pin=newpin;
            System.out.println("pin is changed successfully");
            tH.add("pin change");
        }
        else{
            System.out.println("Incorrect old pin");
        }
    }
    // Displays the transaction history.
    public void transactionhistory(){
        System.out.println("transaction history");
        for(String tran : tH){
            System.out.println("- "+ tran);
        }
    }
} 
public class octanet_task1
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Atm atm = new Atm("0123",10000);
	    while(true){
	        System.out.println("\nATM Machine");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    atm.balanceinquiry();
                    break;
                case 2:
                    System.out.println("Enter the deposit amount");
                    double a = sc.nextDouble();
                    atm.deposit(a);
                    break;
                case 3:
                    System.out.println("Enter the withdraw amaount");
                    double k = sc.nextDouble();
                    atm.withdraw(k);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    String op = sc.next();
                    System.out.print("Enter new PIN: ");
                    String np = sc.next();
                    atm.pinchange(op, np);
                    break;
                case 5:
                    atm.transactionhistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
	    }
		
	}
}