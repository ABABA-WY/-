package Competition;

class Bank {
    private long[] balance;
    public Bank(long[] balance) {
        this.balance=balance.clone();
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1-1< balance.length&&account2-1 < balance.length&&account1-1>=0&&account2-1>=0){
            if(balance[account1-1]>=money){
                balance[account1-1] -= money;
                balance[account2-1] += money;
                return true;
            }
        }
        return false;
    }

    public boolean deposit(int account, long money) {
            if(account-1< balance.length&&account-1>=0){
                balance[account-1] += money;
                return true;
            }
            return false;
    }

    public boolean withdraw(int account, long money) {
        if(account-1 < balance.length&&account-1>=0&&balance[account-1] >= money){
            balance[account-1] -= money;
            return true;
        }
        return false;
    }
}