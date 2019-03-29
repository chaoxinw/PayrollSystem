package payrollpackage.methodTransactions;

import payrollpackage.methods.DirectMethod;
import payrollpackage.payrollDomain.PaymentMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction {
	private String itsBank;
	private int itsAccount;
	
	public ChangeDirectTransaction(int empid, String bank, int account) {
		super(empid);
		this.itsBank = bank;
		this.itsAccount = account;
	}

	@Override
	public PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return new DirectMethod(itsBank, itsAccount);
	}
	
	

}
