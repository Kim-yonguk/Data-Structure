
public class tree {
	
	node root;
	char[][] prec=new char[5][2];
	
	tree() { root=null; }
	
	
	public void build(char data){
		node a=new node(data);
		
		prec[0][0]='^';
		prec[0][1]=3;
		prec[1][0]='*';
		prec[1][1]=2;
		prec[2][0]='/';
		prec[2][1]=2;
		prec[3][0]='+';
		prec[3][1]=1;
		prec[4][0]='-';
		prec[4][1]=1;
		
		int i;
		for(i=0; i<5; i++)
		{
			if(a.data ==prec[i][0])
			{
				a.prio=prec[i][1];
				break;
			}
		}
		if(i==5)
		{
			Operand(a);
		}
		else
			Operator(a);
		
	}
	void inorder(node p)
	{
		if(p!=null){
		inorder(p.left);
		System.out.print(p.data);
		inorder(p.right);
		}
	}
	void postorder(node p)
	{
		if(p!=null){
		postorder(p.left);
		postorder(p.right);
		System.out.print(p.data);
		}
	}
	void preorder(node p)
	{
		if(p!=null){
		System.out.print(p.data);
		preorder(p.left);
		preorder(p.right);
		}
	}
	void Operand(node a)
	{
		node b=root;
		if(root == null)
		{
			root=a;
		}
		else{
			while(b.right != null)
			{
				b=b.right;
			}
			b.right=a;
		}
	}
	void Operator(node a)
	{
		if(root.prio >= a.prio){
			a.left=root;
			root=a;
		}
		else
		{
			a.left=root.right;
			root.right=a;
		}
	}
	
	
	
	int eval(node a)
	{
		int value = 0;
		int left;
		int right;
		
		if(a != null)
		{
			if(a.data >= '0' && a.data <='9')
				value=a.data-'0';
			else
			{
				left=eval(a.left);
				right=eval(a.right);
				switch(a.data)
				{
				case'+': value = left + right;	break;
				case'-': value = left - right;	break;
				case'*': value = left*right;	break;
				case'/': value = left / right;	break;
				}
			}
			return value;
		}
		else 
			System.out.println("empty tree");
		
		return value;
	}
	
	void showinorder()
	{
		inorder(root);
	}
	void showpreorder()
	{
		preorder(root);
	}
	void showpostorder()
	{
		postorder(root);
	}

	void showeval()
	{
		System.out.print(eval(root));
	}
}
