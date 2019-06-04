/*
 * Developed by 10Pines SRL
 * License: 
 * This work is licensed under the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License. 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ 
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, 
 * California, 94041, USA.
 *  
 */
package portfolio;

import java.util.List;

public class AccountSummaryWithAllInvestmentInformation {

	private SummarizingAccount account;

	public AccountSummaryWithAllInvestmentInformation(SummarizingAccount account) {
		this.account = account;
	}

	public List<String> lines() {
		AccountSummaryWithInvestmentEarnings summary = new AccountSummaryWithInvestmentEarnings(account);
		final double[] investmentEarningsValue = new double[1];
		Thread thread = new Thread(() -> investmentEarningsValue[0] = new InvestmentNet(account).value());
		thread.start();

		List<String> lines = summary.lines();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lines.add("Inversiones por " + investmentEarningsValue[0]);
	
		return lines;
	}
}
