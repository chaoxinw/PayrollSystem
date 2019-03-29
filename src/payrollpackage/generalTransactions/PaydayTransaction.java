package payrollpackage.generalTransactions;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.Transaction;

public class PaydayTransaction extends Transaction {
	
	private Date itsPayDate;
	private HashMap<Integer, Paycheck> itsPaychecks = new HashMap<Integer, Paycheck>();
	
	public PaydayTransaction(Date date) {
		this.itsPayDate = date;
	}
	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ArrayList<Integer> empids = new ArrayList<Integer>();
		PayrollDatabase.getAllEmployeeIds(empids);
		
		Iterator<Integer> itr = empids.iterator();
		
		while(itr.hasNext()) {
			int empid = itr.next();
			Employee e = PayrollDatabase.getEmployee(empid);
			if (e != null) {
				if (e.isPayDate(itsPayDate)) {
					System.out.println("It is pay date");
					
					Paycheck pc = new Paycheck(itsPayDate);
					
					itsPaychecks.put(empid, pc);
					e.payday(pc);
					//order problem??
				} else {
					System.out.println("It is not pay date");
				}
				
			} else {
				System.out.println("e is null");
			}
		}
		
	}
	
	public Paycheck getPaycheck(int empid) {
		return itsPaychecks.get(empid);
	}
	
	

}
