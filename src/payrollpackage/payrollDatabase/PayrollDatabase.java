package payrollpackage.payrollDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import payrollpackage.payrollDomain.Employee;

//Simple database implementation for now

public class PayrollDatabase {
	public static HashMap<Integer, Employee> itsEmployees = new HashMap<Integer, Employee>();
	public static HashMap<Integer, Employee> itsUnionMembers = new HashMap<Integer, Employee>();
	
	public PayrollDatabase() {}
	
	public static Employee getEmployee(int empid) {
		return itsEmployees.get(empid);
	}
	public static void addEmployee(int empid, Employee e) {
		itsEmployees.put(empid, e);
	}
	public static void deleteEmployee(int empid) {
		itsEmployees.remove(empid);
	}
	
	public static Employee getUnionMember(int memberId) {
		return itsUnionMembers.get(memberId);
	}
	public static void addUnionMember(int memberId, Employee e) {
		itsUnionMembers.put(memberId, e);
	}
	
	public static void removeUnionMember(int memberId) {
		itsUnionMembers.remove(memberId);
	}
	
	public static void getAllEmployeeIds(ArrayList<Integer> empids) {
		Iterator<Entry<Integer, Employee>> it = itsEmployees.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        empids.add((Integer) pair.getKey());
	        System.out.println((Integer) pair.getKey());
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	}
}
