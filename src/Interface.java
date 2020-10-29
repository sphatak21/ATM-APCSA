import java.util.Scanner;

public class Interface {
    BankAccount acc;
    public static void main(String[] args){
        ATM atm = new ATM();
        Scanner in = new Scanner(System.in);
        login(in);
    }
    public static void depositInterface(Scanner in, BankAccount acc){
        double amount;
        while(true){
            System.out.print("Amount to deposit: ");
            try {
                amount = Double.parseDouble(in.nextLine());
            }
            catch (NumberFormatException er){
                amount = -1;
            }
            int status = acc.deposit(amount);
            if(status == 1){
                break;
            }
        }
        homeMenu(in, acc);
        System.out.println(acc.getFormattedBalance());
    }
    public static void  withdrawInterface(Scanner in, BankAccount acc){
        double amount;
        while(true){
            System.out.print("Amount to withdraw: ");
            try {
                amount = Double.parseDouble(in.nextLine());
            }
            catch (NumberFormatException er){
                amount = -1;
            }
            int status = acc.withdraw(amount);
            if(status == 1){
                break;
            }
        }
        homeMenu(in, acc);
        System.out.println(acc.getFormattedBalance());
    }
    public static void transferInterface(Scanner in, BankAccount acc){
        while(true){
            System.out.print("Destination: ");
            long destination;
            try {
                destination = Long.parseLong(in.nextLine());
            }
            catch (NumberFormatException er){
                destination = -1;
            }
            if(destination >= 0){
                System.out.print("Amount to deposit: ");
                double amount;
                try {
                    amount = Double.parseDouble(in.nextLine());
                }
                catch (NumberFormatException er){
                    amount = -1;
                }
                int status = acc.transfer(destination, amount);
                if(status == 1){
                    homeMenu(in, acc);
                    System.out.println(acc.getFormattedBalance());
                    System.out.println(ATM.lookup(destination).getFormattedBalance());
                    break;
                }
            }
        }


    }
    public static void homeMenu(Scanner in, BankAccount acc){
        String[] functions = new String[]{"Deposit", "Withdraw", "Transfer", "Quit"};
        for(int i = 0; i < functions.length; i++){
            int temp = i+1;
            System.out.println("["+temp+"] " + functions[i]);
        }
        int function;
        while(true){
            try{
                function = Integer.parseInt(in.nextLine());
            }catch(NumberFormatException er){
                function = -1;
            }
            if(function > 0 && function < 5){
                break;
            }
        }
            String functionUsed = " ";
            for(int i = 0; i < functions.length; i++){
                if(function == i + 1){
                    functionUsed = functions[i];
                }
            }
            if(functionUsed.equals("Deposit")){
                depositInterface(in, acc);
            }else if(functionUsed.equals("Withdraw")){
                withdrawInterface(in, acc);
            }else if(functionUsed.equals("Transfer")){
                transferInterface(in, acc);
            }else{
                login(in);
            }
        }
    public static void login(Scanner in){
        while(true){
            System.out.print("Account No.: ");
            long accNum;
            try {
                accNum = Long.parseLong(in.nextLine());
            }
            catch (NumberFormatException er) {
                accNum = -1;
            }
            if(accNum > 0){
                BankAccount acc = ATM.lookup(accNum);
                if(acc != null ){
                    homeMenu(in, acc);
                }
            }
        }

    }
}
