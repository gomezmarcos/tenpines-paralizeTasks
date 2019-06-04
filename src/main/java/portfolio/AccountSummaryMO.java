package portfolio;

import java.util.List;

class AccountSummaryMO {

    private AccountSummaryInterface accountSummaryWithInvestmentEarnings;
    private SummarizingAccount account;

    public AccountSummaryMO(AccountSummaryInterface accountSummaryInterface) {
        this.accountSummaryWithInvestmentEarnings = accountSummaryInterface;
    }

    public List<String> invoke() {
        account = accountSummaryWithInvestmentEarnings.getAccount();
        AccountSummary summary = new AccountSummary(account);
        double[] investmentEarningsValue = new double[1];

        Thread thread = new Thread(()-> investmentEarningsValue[0] = new InvestmentEarnings(accountSummaryWithInvestmentEarnings.getAccount()).value());
        thread.start();

        List<String> lines = summary.lines();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lines.add("Ganancias por " + investmentEarningsValue[0]);

        return lines;
    }
}
