package payrollpackage.payrollDomain;
import java.util.Date;

import payrollpackage.affiliations.NoAffiliation;
import payrollpackage.generalTransactions.Paycheck;

public class Employee {
	private int itsEmpid;
	private String itsName;
	private String itsAddress;
	private PaymentClassification itsClassification;
	private Affiliation itsAffiliation;
	private PaymentMethod itsPaymentMethod;
	private PaymentSchedule itsSchedule;
	
	public Employee(int empid, String name, String address) {
		this.itsEmpid = empid;
		this.itsName = name;
		this.itsAddress = address;
		this.itsAffiliation = new NoAffiliation();
		this.itsClassification = null;
		this.itsSchedule = null;
		this.itsPaymentMethod = null;
	}
	
	public int getEmpid() {
		return itsEmpid;
	}

	public String getName() {
		return itsName;
	}
	public void setName(String itsName) {
		this.itsName = itsName;
	}

	public String getAddress() {
		return itsAddress;
	}
	public void setAddress(String itsAddress) {
		this.itsAddress = itsAddress;
	}
	
	public PaymentClassification getClassification() {
		return itsClassification;
	}

	public void setClassification(PaymentClassification itsClassification) {
		this.itsClassification = itsClassification;
	}

	public Affiliation getAffiliation() {
		return itsAffiliation;
	}
	public void setAffiliation(Affiliation itsAffiliation) {
		this.itsAffiliation = itsAffiliation;
	}

	public PaymentMethod getPaymentMethod() {
		return itsPaymentMethod;
	}
	public void setPaymentMethod(PaymentMethod itsPaymentMethod) {
		this.itsPaymentMethod = itsPaymentMethod;
	}
	

	public PaymentSchedule getSchedule() {
		return itsSchedule;
	}

	public void setSchedule(PaymentSchedule itsSchedule) {
		this.itsSchedule = itsSchedule;
	}

	public void payday(Paycheck pc) {
		double grossPay = itsClassification.calculatePay(pc);
		double deductions = itsAffiliation.calculateDeductions(pc);
		double netPay = grossPay - deductions;
		pc.setItsGrossPay(grossPay);
		pc.setItsDeduction(deductions);
		pc.setItsNetPay(netPay);
		
		System.out.println(grossPay);
		
		itsPaymentMethod.pay(pc);
	}
	
	public boolean isPayDate(Date payDate) {
		return itsSchedule.isPayDate(payDate);
	}
}
