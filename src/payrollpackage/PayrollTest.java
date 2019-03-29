package payrollpackage;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import payrollpackage.affiliationTransactions.ChangeMemberTransaction;
import payrollpackage.affiliationTransactions.ServiceChargeTransaction;
import payrollpackage.classificationTransactions.ChangeHourlyTransaction;
import payrollpackage.classificationTransactions.TimeCardTransaction;
import payrollpackage.classifications.HourlyClassification;
import payrollpackage.generalTransactions.AddCommissionedEmployee;
import payrollpackage.generalTransactions.AddHourlyEmployee;
import payrollpackage.generalTransactions.AddSalariedEmployee;
import payrollpackage.generalTransactions.Paycheck;
import payrollpackage.generalTransactions.PaydayTransaction;
import payrollpackage.payrollDatabase.PayrollDatabase;
import payrollpackage.payrollDomain.Employee;
import payrollpackage.payrollDomain.PaymentClassification;
import payrollpackage.payrollDomain.PaymentSchedule;
import payrollpackage.schedules.WeeklySchedule;

public class PayrollTest {
	
	public static void main(String[] args) {
		
		
		//testChangeHourlyTransaction();
		testHourlyUnionMemberServiceCharge();
	}
	
	public static void testAddEmployee() {
		int empid = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empid, "Alex", "melbourne", 1000.00);
		t.execute();
		
		Employee e = PayrollDatabase.getEmployee(empid);
		assert("Alex" == e.getName());
	}
	
	
	
	public static void testChangeHourlyTransaction() {
		int empid = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empid, "Lance", "Home", 2500, 3.2);
		t.execute();
		
		ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empid, 27.52);
		cht.execute();
		
		Employee e = PayrollDatabase.getEmployee(empid);
		assert(!e.equals(null));
		
		PaymentClassification pc = e.getClassification();
		assert(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;
		assert(27.52 == hc.getHourlyRate());
		
		PaymentSchedule ps = e.getSchedule();
		assert(ps instanceof WeeklySchedule);
		
	}
	
	public static void testHourlyUnionMemberServiceCharge() {
		int empid = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empid, "Bob", "Home", 20.5);
		t.execute();
		
		int memberId = 7720;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empid, memberId, 9.4);
		cmt.execute();
		
		Calendar myCalendar = new GregorianCalendar(2019, 1, 8);
		Date payDate = myCalendar.getTime();
		Calendar c = Calendar.getInstance(); 
		c.setTime(payDate); 
		c.add(Calendar.DATE, -1);
		Date date2 = c.getTime();
		
		
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, date2, 19.2);
		sct.execute();
		
		TimeCardTransaction tct = new TimeCardTransaction(date2, 8, empid);
		tct.execute();
		
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
		
		Paycheck pc = pt.getPaycheck(empid);
		
		assert(pc != null);
		assert(pc.getItsGrossPay() == 8*20.5);
		assert(9.4+19.2 == pc.getItsDeduction());
		assert((8*20.5 - (9.4+19.2)) == pc.getItsNetPay());
	}

}
