package interceptor;

import java.util.Scanner;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Interceptor2annotation
public class Interceptor2interceptor {

	@AroundInvoke
	public Object login(InvocationContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("login ?");
		String login = sc.nextLine();
		System.out.println("pass ?");
		String pass = sc.nextLine();
		sc.close();
		if (login.equalsIgnoreCase("root") || pass.equalsIgnoreCase("root")) {
			System.out.println("connecté");
			return context.proceed();
		} else {
			System.out.println("erreur de connection");
			return null;
		}

	}

}
