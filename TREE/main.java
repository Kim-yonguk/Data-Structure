import java.util.*;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	tree t = new tree();
	int len;
	char exp[]=new char[100];
	
	System.out.println("input : ");
	
	String s=sc.nextLine();
	//System.out.println(s);
	len=s.length();
	//System.out.println(len);
	
	for(int i=0; i<len; i++)
	{
		exp[i]=s.charAt(i);
	}

	for(int i=0; i<len; i++)
	{
		t.build(exp[i]);
	}
	System.out.print("inorder => ");
	t.showinorder();
	System.out.println("");
	
	System.out.print("preorder => ");
	t.showpreorder();
	System.out.println("");
	
	System.out.print("postorder => ");
	t.showpostorder();

	System.out.println("");
	
	System.out.print("output => ");
	t.showeval();
	
	
	}
}
