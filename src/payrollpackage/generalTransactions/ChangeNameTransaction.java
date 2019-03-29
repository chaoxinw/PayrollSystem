package payrollpackage.generalTransactions;

import payrollpackage.payrollDomain.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {
	private String itsName;
	
	public ChangeNameTransaction(int empid, String name) {
		super(empid);
		this.itsName = name;
	}
	
	public void change(Employee e) {
		e.setName(itsName);
	}

}
