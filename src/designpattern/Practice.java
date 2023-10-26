package designpattern;

import java.util.ArrayList;
import java.util.List;

interface Account {
    public double getBalance();
}

class SalaryAccount implements Account {
    private String accountNo;
    private float balance;

    public SalaryAccount(String accountNo, float balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }
}

class SavingAccount implements Account {
    private String accountNo;
    private float balance;

    public SavingAccount(String accountNo, float balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }
}

class CompositeAccount implements Account {
    private float totBalance;
    List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public double getBalance() {
        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }
}

public class Practice {
    public static void main(String[] args) throws Exception {
        CompositeAccount compositeAccount = new CompositeAccount();

        compositeAccount.addAccount(new SalaryAccount("123", 650));
        compositeAccount.addAccount(new SavingAccount("456", 900));
        compositeAccount.addAccount(new SavingAccount("1122", 800));

        System.out.println(compositeAccount.getBalance());
    }
}
