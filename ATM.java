import java.util.*;

class Deposit {
    Scanner sc = new Scanner(System.in);
    int ID1, ID, n;
    int amt, with = 0, trans, acc;
    String Password, Password1, sact = "", accoNO, username;
    public int bal = 0, dep = 0;

    public void Deposit() {
        System.out.println("Deposit");
        System.out.println("");

        System.out.print("Enter the amount to be deposit: ");
        dep = sc.nextInt();

        bal = bal + dep;

        String str2 = "amount deposit: " + dep + "\n";
        sact = sact.concat(str2);
        System.out.println("Amount deposited successfully!!!: ");
    }
}

class Transaction extends Deposit {
    public void Transaction() {
        System.out.println("");
        System.out.println("Transactions are");

        System.out.println("\n" + sact);
    }
}

class Withdraw extends Transaction {
    public void Withdraw() {
        System.out.println("");
        System.out.println(" Withdraw ");
        System.out.println("");

        System.out.print("Enter the amount to be withdraw : ");
        with = sc.nextInt();

        if (bal > with) {
            bal = bal - with;
            System.out.println("");
            System.out.println("Amount withdraw successfully!!!: ");
            String str1 = "amount withdrawal: " + with + "\n";
            sact = sact.concat(str1);
        } else {
            System.out.println("Sufficient Balance not available for the withdrawl!");
        }
    }
}

class Transfer extends Withdraw {
    public void Transfer() {
        System.out.println("");
        System.out.println(" Transfer ");
        System.out.println("");

        System.out.print("Enter the amount to be Transfer: ");
        trans = sc.nextInt();

        if (bal > trans) {
            bal = bal - trans;

            System.out.print("Enter the account number to whom amount to be transfer: ");
            acc = sc.nextInt();
            String str3 = "amount transfer to " + acc + " is " + trans + "\n";
            sact = sact.concat(str3);
            System.out.println("Amount transfer successfully!!! ");
        } else {
            System.out.println("Sufficient Balance not available for the Transfer!");
        }
    }
}

class Balance extends Transfer {
    public void Balance() {
        System.out.println(" Total balance ");
        System.out.println("");

        System.out.println("Balance: " + bal);
    }

}

class Register extends Balance {
    public void Register() {
        System.out.println(" Registration page ");
        System.out.println("");

        System.out.print("enter the bank account number: ");
        accoNO = sc.nextLine();

        System.out.print("enter the username::");
        username = sc.nextLine();

        System.out.print("Enter the User ID: ");
        ID = sc.nextInt();

        System.out.print("Enter the User password: ");
        Password = sc.next();

        System.out.println("");

        System.out.println("User Register Successfully!!!!");

        System.out.println("");

    }
}

class Login extends Register {

    public void Login() {

        System.out.println(" Login page ");
        System.out.println("");

        do {

            System.out.print("Enter the User ID: ");
            ID1 = sc.nextInt();

            if (ID == ID1) {
                do {
                    System.out.print("Enter the User password: ");
                    Password1 = sc.next();

                    if (Password.equals(Password1)) {

                        System.out.println("");
                        System.out.println("login successfully!!!!");

                    } else {
                        System.out.println("enter the correct password!");
                    }
                } while ((Password.equals(Password1)) == false);

            } else {
                System.out.println("Enter the valid User ID!!!!");
            }

        } while (ID1 != ID);

        System.out.println("");

    }

}

public class ATM {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println(" Welcome to ATM ");
        System.out.println("");

        System.out.println("1.Register \n2.Exit ");
        System.out.print("Enter your choice: ");
        int c = sc.nextInt();

        System.out.println("");

        Login reg = new Login();

        switch (c) {
            case 1:
                reg.Register();
                break;

            case 2:
                return;

            default:
                System.out.println("Enter the vaild choice");
                break;
        }

        reg.Login();

        do {
            System.out.println("");
            System.out.println(" Menu Dashboard ");
            System.out.println("");
            System.out.println(
                    " \n1.Transaction history \n2.Withdraw \n3.Deposit \n4.Transfer \n5.View balance \n6.Quit");
            System.out.print("Enter your choice:- ");
            n = sc.nextInt();
            System.out.println("");

            switch (n) {
                case 1:
                    reg.Transaction();
                    break;

                case 2:
                    reg.Withdraw();
                    break;

                case 3:
                    reg.Deposit();
                    break;

                case 4:
                    reg.Transfer();
                    break;

                case 5:
                    reg.Balance();
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter the vaild choice");
                    break;

            }
        } while (n != 6);

    }
}