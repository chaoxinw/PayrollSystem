package payrollpackage.schedules;
import java.util.Calendar;
import java.util.Date;

import payrollpackage.payrollDomain.PaymentSchedule;

public class BiweeklySchedule extends PaymentSchedule {
	private int cnt = 0;
	
	public BiweeklySchedule() {
		
	}
	
	public boolean isPayDate(Date date) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			cnt++;
			if ((cnt % 2) != 0) {
				// odd
				return true;
			}
		}
		return false;
	}
}
