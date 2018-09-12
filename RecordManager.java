package posist_code;


public class RecordManager{
	
	// Record Manager manages the dynamic list of records

	// points to first record in dynamic list
	static Record head ;
	// points to last record in dynamic list,helps in inserting new records
	static Record last;

	// function for adding new record in dynamic list,function 
	// returns current record for further manipulation
	// assumption , while creating record , we have to provide both owner and the ownerId
	public static Record addRecord(String owner , int id){
		Record temp = new Record(owner,id);
		if(last == null){
			head = temp;
			last = temp;
		}else{
			last.next = temp;
			last = temp;
		}
		return temp;
	}
}