package taster;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.core.Customer;
import com.core.Plan;

import static utils.customersUtils.*;
import static utils.IOUtils.*;

public class Taste {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Customer> customer = restoreData();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Enter option 1. Sign up (customer registration)\r\n" + "2. Sign in (login)\r\n"
							+ "3. Change password\r\n" + "4. Un subscribe customer\r\n" + "5. Display all customers. \n"
							+ "6. Change plan \n"
							+ "7. Display Customers who have not paid subscription from past 3 months  \n"
							+ "8. Sort Customer According to First and Last Name \n"
							+ "9. Do Firt word of first And last name capital \n"
							+ "10. Remove customer which which ha choosn plan Silver" 
							+ "0. Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("First Name, Last Name, Email, Password, Regester Amount, dob and Plan");
						Customer c = createCustomer(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), sc.next(), customer);
						customer.put(c.getEmail(), c);
						break;
					case 2:
						System.out.println();
						customerSignIn(sc.next(), sc.next(), customer);

						break;
					case 3:
						System.out.println("Please enter email, Old Password and new password");
						changePassword(sc.next(), sc.next(), sc.next(), customer);
						break;
					case 4:
						System.out.println("Please enter email and password to unsubscribe customer");
						unsubscribeCustomer(sc.next(), sc.next(), customer);
						break;
					case 5:
						customer.values().forEach(System.out::println);
						break;

					case 6:
						System.out.println("Please enter Email, password, Plan and Plan amount");
						changePlan(sc.next(), sc.next(), sc.next(), sc.nextDouble(), customer);
						System.out.println("Plan changed sucessfully");
						break;
					case 7:
						customer.values().stream()
								.filter(s -> Period.between(s.getPlanEndDate(), LocalDate.now()).toTotalMonths() >= 3)
								.forEach(s -> System.out.println(s.getfName() + " " + s.getlName()));
						break;
					case 8:
						customer.values()
						.stream()
						.sorted((s1, s2) -> {
							int no = s1.getfName().compareTo(s2.getfName());
							if (no == 0) {
								return s1.getlName().compareTo(s2.getlName());
							} else
								return no;
						});
						break;
					case 9:
						customer.values()
						.stream()
						.forEach(s-> s.setfName(s.getfName().replaceFirst(s.getfName().substring(0, 1), s.getfName().substring(0, 1).toUpperCase())));
						
						break;
					
					case 10:
						Iterator<Customer> it= customer.values().iterator();
						while(it.hasNext()) {
							if(it.next().getPlan()==Plan.SILVER) {
								it.remove();
							}
							
						}
						break;
					case 0:
						storeData(customer);
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

	}

}
