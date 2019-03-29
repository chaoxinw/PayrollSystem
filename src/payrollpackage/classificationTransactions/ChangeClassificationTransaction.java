package payrollpackage.classificationTransactions;

import payrollpackage.generalTransactions.ChangeEmployeeTransaction;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
	
	public ChangeClassificationTransaction(int empid) {
		super(empid);
	}
	
	public abstract PaymentClassification getClassification();
	public abstract PaymentSchedule getSchedule();
	
	public void change(Employee e) {
		e.setClassification(getClassification());
		e.setSchedule(getSchedule());
	}

}
