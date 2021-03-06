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

public class TransferNet implements AccountTransactionVisitor {

	private SummarizingAccount account;
	private double value;

	public TransferNet(SummarizingAccount account) {
		this.account = account;
	}

	public double value(){
		value = 0.0;
		account.visitTransactionsWith(this);
		return value;
	}

	@Override
	public void visitDeposit(Deposit deposit) {
	}

	@Override
	public void visitWithdraw(Withdraw withdraw) {
	}

	@Override
	public void visitCertificateOfDeposit(
			CertificateOfDeposit certificateOfDeposit) {
	}

	@Override
	public void visitTransferDeposit(TransferDeposit transferDeposit) {
		value += transferDeposit.value();
	}

	@Override
	public void visitTransferWithdraw(TransferWithdraw transferWithdraw) {
		value -= transferWithdraw.value();
	}

}
