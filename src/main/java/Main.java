public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(1000, "Расчетный счет");
        CreditAccount creditAccount = new CreditAccount(100, "Кредитный счет");
        SavingsAccount savingsAccount = new SavingsAccount(2000, "Сберегательный счет");
        System.out.println();

        checkingAccount.addMoney(200);
        creditAccount.addMoney(50);
        savingsAccount.addMoney(50);
        System.out.println();

        savingsAccount.transfer(creditAccount, 20);
        System.out.println();

        checkingAccount.transfer(creditAccount, 30);
        System.out.println();

        creditAccount.transfer(checkingAccount, 700);
        System.out.println();

        savingsAccount.transfer(checkingAccount, 4000);
        System.out.println();

        checkingAccount.pay(200);
        creditAccount.pay(100);
        savingsAccount.pay(500);
    }
}
