package payrollpackage.schedules;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import payrollpackage.payrollDomain.PaymentSchedule;

public class MonthlySchedule extends PaymentSchedule {
	
	public MonthlySchedule() {
		
	}
	
	public boolean isPayDate(Date payDate) {
		return isLastDayOfMonth(payDate);
	}
	
	public boolean isLastDayOfMonth(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int m1 = localDate.getMonthValue();
		
		Date date2 = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, 1);
		date2 = c.getTime();
		
		LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int m2 = localDate2.getMonthValue();
		
		return (m1 != m2);
	}

}
