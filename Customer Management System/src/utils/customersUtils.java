package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.core.*;
import exception.CustomerException;
import static utils.CustomerValidation.*;

public class customersUtils {
	public static HashMap<String, Customer> populateCustomer() {
		HashMap<String, Customer> cust = new HashMap<>();
		cust.put("abc@123",
				new Customer("Tejas", "Taradgaonkar", "abc@123", "asdf", 1000, LocalDate.parse("1998-09-05"),
						LocalDate.parse("2023-10-15"), LocalDate.parse("2023-11-15"), Plan.valueOf("SILVER")));
		cust.put("xyz@123", new Customer("Sahil", "Chavan", "xyz@123", "qwer", 2000, LocalDate.parse("1999-05-24"),
				LocalDate.parse("2022-06-15"), LocalDate.parse("2022-12-15"), Plan.valueOf("GOLD")));
		return cust;
	}

	public static void customerSignIn(String email, String password, Map<String, Customer> cust)
			throws CustomerException {
		if (cust.containsKey(email)) {
			if (cust.get(email).getPassword().equals(password)) {
				System.out.println("Login Sucessfull!");
			} else {
				throw new CustomerException("Incorrect Password");
			}

		} else
			throw new CustomerException("Invalid email !");
	}

	public static void unsubscribeCustomer(String email, String password, Map<String, Customer> cust)
			throws CustomerException {
		if (cust.containsKey(email)) {
			if (cust.get(email).getPassword().equals(password)) {
				cust.remove(email);
				System.out.println("Customer Un-subscribed!");
			} else {
				throw new CustomerException("Incorrect Password");
			}

		} else
			throw new CustomerException("Invalid email !");
	}

	public static void changePassword(String email, String oldPassword, String newPassword, Map<String, Customer> cust)
			throws CustomerException {
		customerSignIn(email, oldPassword, cust);
		cust.get(email).setPassword(newPassword);
		System.out.println("Passwprd changed Sucessfully!");
	}

	public static void changePlan(String email, String password, String plan, double amount, Map<String, Customer> cust)
			throws CustomerException {
		customerSignIn(email, password, cust);
		Plan p = validatePlan(plan, amount);
		cust.get(email).setPlan(p);
		cust.get(email).setRegesterAmount(amount);
		cust.get(email).setPlanStartDate(LocalDate.now());
		cust.get(email).setPlanEndDate(LocalDate.now().plusMonths(p.getMonths()));
	}

	public static Customer createCustomer(String fName, String lName, String email, String password,
			double regesterAmount, String dob, String plan, Map<String, Customer> cust) throws CustomerException {
		validateDuplicateEmail(email, cust);
		Plan p = validatePlan(plan.toUpperCase(), regesterAmount);
		LocalDate date = LocalDate.parse(dob);
		LocalDate psd = LocalDate.now();
		LocalDate ped = psd.plusMonths(p.getMonths());
		return new Customer(fName, lName, email, password, regesterAmount, date, psd, ped, p);
	}
}
