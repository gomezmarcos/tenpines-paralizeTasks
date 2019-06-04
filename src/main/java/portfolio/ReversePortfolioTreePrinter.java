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

public class ReversePortfolioTreePrinter {

	private PortfolioTreePrinter printer;

	public ReversePortfolioTreePrinter(Portfolio portfolio,
			Hashtable<SummarizingAccount, String> accountNames) {
		printer = new PortfolioTreePrinter(portfolio, accountNames);
	}

	public List<String> lines() {
		List<String> reverseLines = new ArrayList<String>();
		List<String> lines = printer.lines();
		
		for (int i = lines.size()-1; i >=0; i--) {
			reverseLines.add(lines.get(i));
		}
		
		return reverseLines;		
	}
}
