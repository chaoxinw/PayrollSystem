package payrollpackage.generalTransactions;

import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.Transaction;

public abstract class ChangeEmployeeTransaction extends Transaction {
	private int itsEmpid;
	
	public ChangeEmployeeTransaction(int empid) {
		this.itsEmpid = empid;
	}
	
	public abstract void change(Employee e);
	
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(itsEmpid);
		if (!e.equals(null)) {
			change(e);
		}
	}

}
