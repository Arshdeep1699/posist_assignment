package posist_code;

import java.util.ArrayList;
import java.util.Date;


public class Node{
	Date timeStamp;
	static String data; // encrypted with hash of [ownerId,value,owner_name]
	int nodeNumber; // unique incremental int val
	String nodeId;
	String referenceNodeId;
	String childReferenceNodeId;
	String genesisReferenceNodeId;
	String hashValue;
	int value ;
	Node parent ;
	ArrayList<Node> child = new ArrayList<>();
	
	// function to generate hash of [ownerId,value,owner_name]
	// gives key for for each node  
	public static int getkey(int ownerId, int value, String owner_name){
		int sum = 0;
		for(int i=0;i<owner_name.length();i++){
			sum += (int)owner_name.charAt(i);
		}
		sum = sum % (ownerId+value);
		return sum;
	}
	Node(String d, int ownerId, int value, String owner_name){
		timeStamp = new Date();
		this.value = value ;
		data = EncryptionHelper.encrypt(d,getkey(ownerId,value,owner_name));
		referenceNodeId = parent.toString();
		childReferenceNodeId = child.toString();
		
	}
	public static String getData(int key) {
		return EncryptionHelper.decrypt(data, key);
	}


}
