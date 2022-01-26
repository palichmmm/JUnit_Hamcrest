public class SavingsAccount extends Account {

    public SavingsAccount(double amount, String name) {
        super(amount > 0 ? amount : -amount, name);
    }
    public boolean pay(double amount) {
        System.out.println("Нельзя платить со " + getName() + "!");
        return false;
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
