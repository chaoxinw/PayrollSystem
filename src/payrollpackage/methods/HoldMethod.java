package payrollpackage.methods;

import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.payrollDomain.PaymentMethod;

public class HoldMethod extends PaymentMethod{

	@Override
	public void pay(Paycheck pc) {
		// TODO Auto-generated method stub
		System.out.format("Using Hold Method to pay %g on %s\n", pc.getItsNetPay(), pc.getItsPayDate().toString());
	}

}
