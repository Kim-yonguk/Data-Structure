package heap;

import java.util.*;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	
	heap h=new heap();

	
	int data;
	int choice;
	System.out.println("Heap test");
	while(true){
	System.out.print("menu: 1.Insert 2.Delete 3.Print 4.Exit" + " : ");
	choice=sc.nextInt();
	
	
	switch(choice){
	case 1:
		System.out.print("input integer : ");
		data=sc.nextInt();
		
		h.insert(data);
		break;
		
	case 2:
		h.delete();
		h.print();
		break;
		
	case 3:
		h.print();
		break;
		
	case 4:
		System.exit(1);
		
	default:
		System.out.println("wrong input");
		break;
	}
	
	}
	
	}
	
}
