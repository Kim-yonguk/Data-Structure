
public class node {
	
	char data;
	node left;
	node right;
	int prio;
	
	node(char value){
		data=value;
		left=null;
		right=null;
		prio=5;
	}
	node()
	{
		data='\0';
		left=null;
		right=null;
		prio=5;
	}
}
