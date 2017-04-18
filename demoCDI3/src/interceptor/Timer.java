package interceptor;

import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Timed
public class Timer {
	@AroundInvoke
	public Object getTime(InvocationContext context) throws Exception {
		System.out.println("avant");
		Date d1 = new Date();
		// on effectue la suite de la procédure avant la seconde mesure
		Object retval = context.proceed();
		System.out.println("après");
		Date d2 = new Date();
		long time1 = d1.getTime();
		long time2 = d2.getTime();
		long diff = time2 - time1;
		System.out.println("tps TTT = " + diff + " ms");
		return retval;

	}
}
