import java.text.DecimalFormat;

public class BankAccount {
    private double balance;
    private AccountOwner accountOwner;
    private long accountNumber;
    public BankAccount(AccountOwner accountOwner, double balance){
        this.balance = balance;
        this.accountOwner = accountOwner;
        this.accountNumber = setaccountNumber();
    }
    public AccountOwner getAccountOwner(){
        return accountOwner;
    }
    public long getAccountNumber(){
        return this.accountNumber;
    }
    public String getMaskedAccountNumber(){
        long num = accountNumber;
        String numstr = String.valueOf(num);
        String maskednumstr = "";
        for(int i = 0; i < numstr.length() - 4; i++){
            maskednumstr += "*";
        }
        maskednumstr += numstr.substring(numstr.length()-4, numstr.length());
        return maskednumstr;
    }
    public int transfer(long destination, double amount){
        BankAccount destinationAcc = ATM.lookup(destination);
        if(destinationAcc == null){
            return 4;
        }else if(amount < 0){
            return 2;
        }else if(amount > this.balance){
            return 3;
        }
        this.withdraw(amount);
        destinationAcc.deposit(amount);
        return 1;
    }

    public int withdraw(double withdrawal) {
        if(withdrawal < 0){
            return 2;
        }else if(withdrawal > this.balance){
            return 3;
        }
        this.balance -= withdrawal;
        return 1;
    }
    public int deposit(double deposit){
        if(deposit <= 0){
            return 2;
        }
        this.balance += deposit;
        return 1;
    }
    public String getFormattedBalance(){

        int i = 0;
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String formattedBalance = "$" + String.valueOf(formatter.format(this.balance));
        return formattedBalance;
    }
    public long setaccountNumber(){
        long accnum;
        while (true){
            accnum = (long) (Math.random() * Math.pow(10, 9));
            BankAccount potential = ATM.lookup(accnum);
            if(potential == null){
                return accnum;
            }
        }
    }
}
