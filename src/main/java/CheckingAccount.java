public class CheckingAccount extends Account {

    public CheckingAccount(double amount, String name) {
        super(amount > 0 ? amount : -amount, name);
    }

    @Override
    public boolean pay(double amount) {
        if (correctAmount(amount) && limitAmount(amount)) {
            System.out.print(getName() + "(" + getAmount() + ") платеж на сумму " + amount + " ВЫПОЛНЕН! ");
            setAmount(getAmount() - amount);
            System.out.println("Баланс счета: " + getAmount());
            return true;
        } else {
            System.out.println(getName() + "(" + getAmount() + ") платеж на " + amount + " НЕ ПРОШЕЛ!!! Баланс счета: " + getAmount());
            return false;
        }
    }

    @Override
    public boolean transfer(Account account, double amount) {
        System.out.println("ПЕРЕВОД " + getName() + "(" + getAmount() + ") ->-> " + amount + " ->-> " + account.getName() + "(" + account.getAmount() + ")");
        if (correctAmount(amount) && limitAmount(amount)) {
            if (account.addMoney(amount)) {
                setAmount(getAmount() - amount);
                System.out.println("ПЕРЕВОД " + getName() + "(" + getAmount() + ") ->-> ВЫПОЛНЕН ->->" + account.getName() + "(" + account.getAmount() + ")");
                return true;
            }
        }
        System.out.println("ПЕРЕВОД " + getName() + "(" + getAmount() + ") ->-> НЕ ПРОШЕЛ!!! ->->" + account.getName() + "(" + account.getAmount() + ")");
        return false;
    }

    @Override
    public boolean addMoney(double amount) {
        if (correctAmount(amount)) {
            System.out.print(getName() + "(" + getAmount() + ") пополнен на " + amount + "! ");
            setAmount(getAmount() + amount);
            System.out.println("Баланс счета: " + getAmount());
            return true;
        } else {
            System.out.println("Не удалось пополнить " + getName() + "! Баланс счета: " + getAmount());
            return false;
        }
    }
}
