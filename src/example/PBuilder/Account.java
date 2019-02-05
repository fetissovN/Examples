package example.PBuilder;

class Main {
    public static void main(String[] args) {
        Account account = Account.newBuilder().setToken("asd").setUserId("3").build();
        System.out.println(account);
    }
}

public class Account {

    private String userId;
    private String token;

    private Account() {
        // private constructor
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public static Builder newBuilder() {
        return new Account().new Builder();
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setUserId(String userId) {
            Account.this.userId = userId;

            return this;
        }

        public Builder setToken(String token) {
            Account.this.token = token;

            return this;
        }

        public Account build() {
            return Account.this;
        }

    }
}