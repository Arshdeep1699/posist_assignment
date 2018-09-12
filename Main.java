package posist_code;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// here we will create a record manager
		// then we will records to record manager
		// each record will have some infomation
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter num of records you want to create");
		int num = sc.nextInt();
		if(num == 0) {
			System.out.println("no records created");
			return;
		}
		RecordManager recMgr = new RecordManager();
		
		// check that each new owner is unique
		HashMap<Integer, String> ownersList = new HashMap<Integer,String>(); 
		  
		
		while( num != 0) {
			int flag = 1;
			String s="";
			int id=0;
			
			while(flag != 0) {
				System.out.println("enter owner name (STRING)");
				s = sc.nextLine();
				System.out.println("enter owner id (INTEGER)");
			    id = sc.nextInt();
				if(ownersList.get(id) == null) {
					ownersList.put(id, s);
					flag = 0;
				}else {
					System.out.println("owner present , please try different owner id ");
				}
			}
			
			Record temp = recMgr.addRecord(s, id);
			num--;
		}
		
		System.out.println("all records successfully created ");
		

	}

}
