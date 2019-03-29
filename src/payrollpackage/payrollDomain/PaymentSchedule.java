package payrollpackage.payrollDomain;
import java.util.Date;

public abstract class PaymentSchedule {
	public abstract boolean isPayDate(Date payDate);
}
