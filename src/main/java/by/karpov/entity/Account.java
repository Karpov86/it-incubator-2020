package by.karpov.entity;

import java.util.Objects;

public class Account extends BaseEntity {

    private int account;
    private User user;

    private Account() {
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account account1 = (Account) o;
        return account == account1.account &&
                Objects.equals(user, account1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), account, user);
    }

    @Override
    public String toString() {
        return "Account{" +
                "account=" + account +
                ", user=" + user +
                '}';
    }

    public static class Builder {

        private final Account newAccount;

        public Builder() {
            newAccount = new Account();
        }

        public Builder setId(int id) {
            newAccount.setId(id);
            return this;
        }

        public Builder setAccount(int account) {
            newAccount.account = account;
            return this;
        }

        public Builder setUser(User user) {
            newAccount.user = user;
            return this;
        }

        public Account build() {
            return newAccount;
        }
    }
}
