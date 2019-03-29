package payrollpackage.schedules;
import java.util.Calendar;
import java.util.Date;

import payrollpackage.payrollDomain.PaymentSchedule;

public class WeeklySchedule extends PaymentSchedule {
	
	public WeeklySchedule() {
		
	}
	
	public boolean isPayDate(Date date) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		return c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
	}
	
	
}
