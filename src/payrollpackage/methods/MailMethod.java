package payrollpackage.methods;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.PaymentMethod;

public class MailMethod extends PaymentMethod {
	private String itsAddress;
	
	public MailMethod(String address) {
		this.itsAddress = address;
	}

	@Override
	public void pay(Paycheck pc) {
		// TODO Auto-generated method stub
		System.out.format("Using Mail Method to pay %g on %s\n", pc.getItsNetPay(), pc.getItsPayDate().toString());
		
	}

}
