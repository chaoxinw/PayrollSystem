package payrollpackage.methods;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.PaymentMethod;

public class DirectMethod extends PaymentMethod {
	private String itsBank;
	private int itsAccount;
	
	public DirectMethod(String bank, int account) {
		this.itsBank = bank;
		this.itsAccount = account;
	}

	@Override
	public void pay(Paycheck pc) {
		// TODO Auto-generated method stub
		
		System.out.format("Using Direct Method to pay %g on %s\n", pc.getItsNetPay(), pc.getItsPayDate().toString());
	}

}
