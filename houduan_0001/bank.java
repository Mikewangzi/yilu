public class bank {
    public static void main(String[] args) {
        bankAccount Account = new bankAccount("3123124", 500);
        try {
            Account.withdraw(600);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
class bankAccount {
    private final String accountNumber;
    private double money;

    public bankAccount(String accountNumber, double money) {
        this.accountNumber = accountNumber;
        this.money = money;
    }
    public void withdraw(double account) throws InsufficientBalanceException{
        if(account > money){
            throw new InsufficientBalanceException(accountNumber, account);
        }else{
            money -= account;
            System.out.println("成功提取金额：" + account + "，账户余额为：" + money);
        }
    }

}
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String accountNumber, double account) {
        super("账号号码=" + accountNumber + "余额不足 " + "尝试提取的金额=" + account);
    }
}
