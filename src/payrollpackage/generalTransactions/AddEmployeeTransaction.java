package payrollpackage.generalTransactions;

import payrollpackage.methods.HoldMethod;
import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentMethod;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.payrollDomain.Transaction;

public abstract class AddEmployeeTransaction extends Transaction {
	
	private int itsEmpid;
	private String itsName;
	private String itsAddress;
	
	public AddEmployeeTransaction(int empid, String name, String address) {
		this.itsEmpid = empid;
		this.itsName = name;
		this.itsAddress = address;
	}
	
	
	public void execute() {
		PaymentClassification pc = getClassification();
		PaymentSchedule ps = getSchedule();
		
		
		PaymentMethod pm = new HoldMethod();
		
		Employee e = new Employee(itsEmpid, itsName, itsAddress);
		e.setClassification(pc);
		e.setSchedule(ps);
		e.setPaymentMethod(pm);
		//add to database
		PayrollDatabase.addEmployee(itsEmpid, e);
		
		//System.out.println("executed...");
	}

	
	public abstract PaymentClassification getClassification();
	public abstract PaymentSchedule getSchedule();
}
