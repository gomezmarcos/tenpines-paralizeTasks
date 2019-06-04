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
import java.util.List;

public class AccountSummary implements AccountTransactionVisitor {

	private SummarizingAccount account;
	private ArrayList<String> lines;

	public AccountSummary(SummarizingAccount account) {
		this.account = account;
	}

	public List<String> lines() {
		sleep();
		lines = new ArrayList<String>();
		account.visitTransactionsWith(this);
		
		return lines;
	}

	@SuppressWarnings("static-access")
	private void sleep(){
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	
	@Override
	public void visitDeposit(Deposit deposit) {
		lines.add("Depósito por " + deposit.value() );
	}

	@Override
	public void visitWithdraw(Withdraw withdraw) {
		lines.add("Extracción por " + withdraw.value() );
	}

	@Override
	public void visitCertificateOfDeposit(
			CertificateOfDeposit certificateOfDeposit) {
		lines.add(
				"Plazo fijo por " + certificateOfDeposit.value()+ 
				" durante " + certificateOfDeposit.numberOfDays()+
				" días a una tna de " + certificateOfDeposit.tna());
	}

	@Override
	public void visitTransferDeposit(TransferDeposit transferDeposit) {
		lines.add("Transferencia por " + transferDeposit.value () );
	}

	@Override
	public void visitTransferWithdraw(TransferWithdraw transferWithdraw) {
		lines.add("Transferencia por " + -transferWithdraw.value () );
	}	
}
