package utils;

import java.util.Map;
import com.core.*;
import exception.CustomerException;

public class CustomerValidation {

	public static void validateDuplicateEmail(String email, Map<String, Customer> cust) throws CustomerException {
		if (cust.get(email) != null)
			throw new CustomerException("Email id already exists");
	}

	public static Plan validatePlan(String plan, double amount) throws CustomerException {
		Plan p = Plan.valueOf(plan.toUpperCase());
		if (p.getCharges() == amount)
			return p;
		else
			throw new CustomerException("Invalid amount for plan.");

	}
}
