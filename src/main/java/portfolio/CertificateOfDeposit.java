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

public class CertificateOfDeposit implements AccountTransaction {

	private final double value;
	private final int numberOfDays;
	private final double tna;

	public CertificateOfDeposit(double value, int numberOfDays, double tna) {
				this.value = value;
				this.numberOfDays = numberOfDays;
				this.tna = tna;
	}

	@Override
	public void accept(AccountTransactionVisitor aVisitor) {
		aVisitor.visitCertificateOfDeposit(this);
	}

	public double value() {
		return value;
	}

	public static CertificateOfDeposit registerFor(double value, int numberOfDays, double tna,
			ReceptiveAccount account) {
		
		CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit(value,numberOfDays,
				tna);
		account.register(certificateOfDeposit);
		
		return certificateOfDeposit;
	}

	public double earnings() {
		return value*(tna/360)*numberOfDays;
	}

	public int numberOfDays() {
		return numberOfDays;
	}

	public double tna() {
		return tna;
	}

}
