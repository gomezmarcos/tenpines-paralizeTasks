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

public class InvestmentEarnings implements AccountTransactionVisitor {

	private SummarizingAccount account;
	private double value;

	public InvestmentEarnings(SummarizingAccount account) {
		this.account = account;
	}

	public double value() {
		sleep();
		value = 0.0;
		account.visitTransactionsWith(this);
	
		return value;
	}
	
	@SuppressWarnings("static-access")
	private void sleep(){
		try {
			Thread.currentThread().sleep(1200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
		
	@Override
	public void visitCertificateOfDeposit(
			CertificateOfDeposit certificateOfDeposit) {
		value += certificateOfDeposit.earnings();
	}

	@Override
	public void visitDeposit(Deposit deposit) {
	}

	@Override
	public void visitWithdraw(Withdraw withdraw) {
	}

	@Override
	public void visitTransferDeposit(TransferDeposit transferDeposit) {
	}

	@Override
	public void visitTransferWithdraw(TransferWithdraw transferWithdraw) {
	}	

}
