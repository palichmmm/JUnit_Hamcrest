public abstract class Account {

    private double amount;
    private String name;

    public Account(double amount, String name) {
        this.amount = amount;
        this.name = name;
        System.out.println("Открыт " + this.name + " на сумму " + this.amount);
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean correctAmount(double amount) {
        return !(amount <= 0);
    }

    public boolean limitAmount(double amount) {
        return this.amount - amount >= 0;
    }

    abstract public  boolean pay(double amount);

    abstract public boolean transfer(Account account, double amount);

    abstract public boolean addMoney(double amount);
}