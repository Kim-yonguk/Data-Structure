
public class Tree {

	Node head;
	Tree(){
		head=null;	//null�� �ʱ�ȭ
	}
	public void insertBST(int n){
		Node temp=new Node(n);	//���ڰ� n�� ������ �ӽó�� temp
		Node p,q=new Node(0);	//�񱳸� ���� �ӽ� ��� p,q
		
		if(head==null)	//���� head�� null�̸�
		{
			head=temp;	//temp�� head�� ����
		}
		else		//head�� null�� �ƴҶ�
		{
			p=head;	//p�� head
			int check;	//���ʿ� �ִ��� �����ʿ� �ִ��� Ȯ���� ����
			while(true)
			{
				if(p.num > temp.num)	//���� ������ �� ���� ���� Ŭ��
				{
					if(p.left==null){	//p�� ���ʳ�尡 �������
						check=1;
						break;
					}
					q=p;
					p=p.left;	//�������� �� ũ�� p�� �������� �̵�
				}
				else{	//���� ���� ���� ������ Ŭ �� p�� ���������� �̵�
					if(p.right==null){	//p�� �����ʳ�尡 �������
						check=2;
						break;
					}
					q=p;
					p=p.right;
				}
			}
			if(check==1)		//���ʿ� ������
			{
				p.left=temp;
			}
			else if(check==2)	//�����ʿ� ������
			{
				p.right=temp;
			}
		}	
	}
	
	
	
	void deleteBST(int n){
		Node p,q=new Node(0);	//���񱳸� ���� �ӽó�� 2������
	
		if(head==null)	//head�� ���������
		{
			System.out.println("Tree is empty");
		}
		else	//head�� ������� ������
		{
			p=head;
			boolean check=false;	//ã�Ҵ��� üũ�ϴ� boolean ����
			
			while(true)
			{
				if(p.num==n)
				{
					check=true;	//���� ã������ check�� true��
					break;
				}
				else if(p.num > n)	//p�� ���� ���ڰ����� Ŭ��
				{
					if((p.left==null))	//�ݺ��� ������ ���µ� ���ʳ�尡 ���������
					{
						System.out.println("Not found");
						break;
					}
					q=p;
					p=p.left;	//p�ǰ��� ���ڰ����� Ŭ�� p�� �������� �̵�
				}
				else if(p.num<n)	//p���� ���ڰ� ���� ������
				{
					if((p.right==null)) //p�� �������� ���������
					{
						System.out.println("Not found");
						break;
					}
					q=p;
					p=p.right;	//p�� ���������� �̵�
				}
			}	////�ݺ��� ����
			
			if(check)	//���� ã������
			{
				if(p.left==null && p.right==null){	//p�� ���ʰ� �������� �� ���������
					if(p==head)	//p�� head�϶�
					{
						head=null;
					}
					else	//p�� head�� �ƴҶ�
					{
						if(q.left==p)
							q.left=null;
						else if(q.right==p)
							q.right=null;
					}
					//delete p;
				}
				else if(p.left==null)	//p�� ������ ���������
				{
					if(p==head)	//p�� head �϶�
					{
						head=head.right;
					}
					else	//p�� head�� �ƴҶ�
					{
						if(q.left==p){
							q.left=p.right;
						}
						else if(q.right==p){
							q.right=p.right;
						}
					}
					//delete p
				}
				else if(p.right==null)	//p�� �������� ���������
				{
					if(p==head){	//p�� head�϶�
						head=head.left;
					}
					else{	//p�� head�� �ƴҶ�
						if(q.left==p)
						{
							q.left=p.left;
						}
						else if(q.right==p){
							q.right=p.left;
						}
						
					}
					//delete p;
				}
				else	///�������� ���
				{
					Node l,lp;
					l=p.left;
					lp=p;
					while(l.right!=null){	///l�� �������� ������� ������
						lp=l;
						l=l.right;
					}
					if(lp.left==l){
						lp.left=l.left;
					}
					else if(l.left==null)
					{
						lp.right=null;
					}
					else
						lp.right=l.left;
					
					p.num=l.num;
					//delete l;
					
				}
			}
		}
	}
	
	
	
	void searchBST(int n){	//���ڰ��� ���� ��带 ã�� �Լ�
		Node p;
		
		if(head==null)
		{
			System.out.println("Tree is empty");
		}
		else{
			p=head;
			
			while(true)
			{
				if(p.num==n)	//���� ��ġ�Ҷ�
				{
					System.out.println("Found");
					break;
				}
				else if(p.num>n)	//p���� ���ڰ����� Ŭ��
				{
					if((p.left==null)){
						System.out.println("Not found");
						break;
					}
					p=p.left;
				}
				else	//p���� ���ڰ����� ������
				{
					if((p.right==null)){
						System.out.println("Not found");
						break;
					}
					p=p.right;
				}
			}
		}
	}
	
	
	void drawBST(Node p,int level){
		if(p!=null && level<=7){
			drawBST(p.right,level+1);
			for(int i=1; i<=(level-1); i++)
			{
				System.out.print("  ");
			}
			System.out.print(p.num);
			if(p.left!=null && p.right!=null){
				System.out.println("<");
			}
			else if(p.right!=null){
				System.out.println("/");
			}
			else if(p.left!=null){
				System.out.println("\\");
			}
			else{
				System.out.println("");
			}
			drawBST(p.left,level+1);
		}
	}
	
	void drawTree(){
		drawBST(head,1);
	}
}
