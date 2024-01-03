package utils;

import static utils.customersUtils.populateCustomer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.core.Customer;

public class IOUtils {
	
	public static void storeData(Map<String, Customer> cust) {
		try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("customer"))){
			
			oos.writeObject(cust);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static HashMap<String, Customer> restoreData(){
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream("customer"))){
			
		return (HashMap<String, Customer>) ois.readObject();
		} catch (IOException e) {
			
			e.printStackTrace();
			return populateCustomer();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
