package posist_code;

import java.util.Scanner;

public class Record{
	// assumptions 
	// we are taking owner as string
	// each record has a genesis Node
	// each record has pointer to next record 
	static String owner ;
	static int ownerId ;
	static Node genesisNode ;
	Record next;
	static int nodeNum = 0;

	Record(String s,int id){
		owner = s;
		ownerId = id;
	    genesisNode = CreateGenesisNode(id, s);
		System.out.println("create child set of genesis node");
		createChildNodeSet(genesisNode);
	}
	
	public static Node CreateGenesisNode(int ownerId,String owner) {
		System.out.println("Create genesis Node");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter value of node");
		int val = sc.nextInt();
		System.out.println("enter data of node");
		String d = sc.nextLine();
		Node temp =  new Node(d, ownerId, val, owner);
		temp.parent = null;
		temp.nodeNumber = nodeNum;
		nodeNum++;
		return temp;
	}
	public static Node createNode(int ownerId,String owner) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter value of node");
		int val = sc.nextInt();
		System.out.println("enter data of node");
		String d = sc.nextLine();
		Node temp =  new Node(d, ownerId, val, owner);
		temp.nodeNumber = nodeNum;
		nodeNum++;
		return temp;
	}
	public static Node createNode(int ownerId,String owner,int v) {
		Scanner sc = new Scanner(System.in);
		
		int val = v;
		System.out.println("enter data of node");
		String d = sc.nextLine();
		Node temp =  new Node(d, ownerId, val, owner);
		temp.nodeNumber = nodeNum;
		nodeNum++;
		return temp;
	}
	
	public static void createChildNodeSet(Node n) {
		System.out.println("enter number of childer to be created");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num > genesisNode.value) {
			System.out.println("enter a valid value ");
		}else {
			// taking care that sum of child nodes values never exceed parent node
			for(int i=1;i<num;i++) {
				Node ch = createNode(ownerId, owner,genesisNode.value/num);
				ch.parent = genesisNode;
				genesisNode.child.add(ch);
			}
			Node ch = createNode(ownerId, owner,genesisNode.value%num);
			ch.parent = genesisNode;
			genesisNode.child.add(ch);
		}
	}

}