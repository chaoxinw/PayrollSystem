package payrollpackage.generalTransactions;

import payrollpackage.payrollDomain.Employee;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
	private String itsAddress;
	
	public ChangeAddressTransaction(int empid, String address) {
		super(empid);
		this.itsAddress = address;
	}
	
	public void change(Employee e) {
		e.setAddress(itsAddress);
	}

}
