package payrollpackage.generalTransactions;

import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Transaction;

public class DeleteEmployeeTransaction extends Transaction{
	
	private int itsEmpid;
	
	public DeleteEmployeeTransaction(int empid) {
		this.itsEmpid = empid;
	}
	
	public void execute() {
		PayrollDatabase.deleteEmployee(itsEmpid);
	}
	
	
}
