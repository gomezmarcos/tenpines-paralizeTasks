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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PortfolioTreePrinter implements SummurizingAccountVisitor {

	private final Portfolio portfolio;
	private final Hashtable<SummarizingAccount, String> accountNames;
	private ArrayList<String> lines;
	private int spaces;

	public PortfolioTreePrinter(Portfolio portfolio,
			Hashtable<SummarizingAccount, String> accountNames) {
		this.portfolio = portfolio;
		this.accountNames = accountNames;
	}

	public List<String> lines() {
		lines = new ArrayList<String>();
		spaces = 0;
		
		portfolio.accept(this);
		
		return lines;
	}

	@Override
	public void visitPortfolio(Portfolio portfolio) {
		lineFor(portfolio);
		spaces += 1;
		portfolio.visitAccountsWith(this);
		spaces -= 1;
	}

	private void lineFor(SummarizingAccount summarizingAccount) {
		String line = "";
		for (int i = 0; i < spaces; i++) {
			line = line + " ";
		}
		line = line + accountNames.get(summarizingAccount);
		lines.add(line);
	}

	@Override
	public void visitReceptiveAccount(ReceptiveAccount receptiveAccount) {
		lineFor(receptiveAccount);
	}

}
