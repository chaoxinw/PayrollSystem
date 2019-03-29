package payrollpackage.methodTransactions;

import payrollpackage.generalTransactions.ChangeEmployeeTransaction;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
	
	public ChangeMethodTransaction(int empid) {
		super(empid);
	}
	
	public abstract PaymentMethod getMethod();
	
	public void change(Employee e) {
		e.setPaymentMethod(getMethod());
	}
	
	
}
