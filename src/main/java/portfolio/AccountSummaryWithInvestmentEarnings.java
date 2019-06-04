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

public class AccountSummaryWithInvestmentEarnings implements AccountSummaryInterface {

	private SummarizingAccount account;

	public AccountSummaryWithInvestmentEarnings(SummarizingAccount account) {
		this.account = account;
	}

	public List<String> lines() {
		return new AccountSummaryMO(this).invoke();
	}

	@Override
	public SummarizingAccount getAccount() {
		return account;
	}
}