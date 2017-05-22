
public class Tree {

	Node head;
	Tree(){
		head=null;	//null로 초기화
	}
	public void insertBST(int n){
		Node temp=new Node(n);	//인자값 n을 저장할 임시노드 temp
		Node p,q=new Node(0);	//비교를 위한 임시 노드 p,q
		
		if(head==null)	//만약 head가 null이면
		{
			head=temp;	//temp를 head에 저장
		}
		else		//head가 null이 아닐때
		{
			p=head;	//p에 head
			int check;	//왼쪽에 넣는지 오른쪽에 넣는지 확인할 변수
			while(true)
			{
				if(p.num > temp.num)	//넣을 값보다 그 전의 값이 클때
				{
					if(p.left==null){	//p의 왼쪽노드가 비었을때
						check=1;
						break;
					}
					q=p;
					p=p.left;	//기존값이 더 크면 p를 왼쪽으로 이동
				}
				else{	//넣을 값이 기존 값보다 클 때 p를 오른쪽으로 이동
					if(p.right==null){	//p의 오른쪽노드가 비었을때
						check=2;
						break;
					}
					q=p;
					p=p.right;
				}
			}
			if(check==1)		//왼쪽에 넣을때
			{
				p.left=temp;
			}
			else if(check==2)	//오른쪽에 넣을때
			{
				p.right=temp;
			}
		}	
	}
	
	
	
	void deleteBST(int n){
		Node p,q=new Node(0);	//값비교를 위해 임시노드 2개생성
	
		if(head==null)	//head가 비어있을때
		{
			System.out.println("Tree is empty");
		}
		else	//head가 비어있지 않을때
		{
			p=head;
			boolean check=false;	//찾았는지 체크하는 boolean 변수
			
			while(true)
			{
				if(p.num==n)
				{
					check=true;	//값을 찾았을때 check를 true로
					break;
				}
				else if(p.num > n)	//p의 값이 인자값보다 클때
				{
					if((p.left==null))	//반복문 끝까지 갔는데 왼쪽노드가 비어있으면
					{
						System.out.println("Not found");
						break;
					}
					q=p;
					p=p.left;	//p의값이 인자값보다 클때 p를 왼쪽으로 이동
				}
				else if(p.num<n)	//p값이 인자값 보다 작을때
				{
					if((p.right==null)) //p의 오른쪽이 비어있을때
					{
						System.out.println("Not found");
						break;
					}
					q=p;
					p=p.right;	//p를 오른쪽으로 이동
				}
			}	////반복문 종료
			
			if(check)	//값을 찾았을때
			{
				if(p.left==null && p.right==null){	//p의 왼쪽과 오른쪽이 다 비어있을때
					if(p==head)	//p가 head일때
					{
						head=null;
					}
					else	//p가 head가 아닐때
					{
						if(q.left==p)
							q.left=null;
						else if(q.right==p)
							q.right=null;
					}
					//delete p;
				}
				else if(p.left==null)	//p의 왼쪽이 비어있을때
				{
					if(p==head)	//p가 head 일때
					{
						head=head.right;
					}
					else	//p가 head가 아닐때
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
				else if(p.right==null)	//p의 오른쪽이 비어있을때
				{
					if(p==head){	//p가 head일때
						head=head.left;
					}
					else{	//p가 head가 아닐때
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
				else	///나머지의 경우
				{
					Node l,lp;
					l=p.left;
					lp=p;
					while(l.right!=null){	///l의 오른쪽이 비어있지 않을때
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
	
	
	
	void searchBST(int n){	//인자값을 가진 노드를 찾는 함수
		Node p;
		
		if(head==null)
		{
			System.out.println("Tree is empty");
		}
		else{
			p=head;
			
			while(true)
			{
				if(p.num==n)	//값이 일치할때
				{
					System.out.println("Found");
					break;
				}
				else if(p.num>n)	//p값이 인자값보다 클때
				{
					if((p.left==null)){
						System.out.println("Not found");
						break;
					}
					p=p.left;
				}
				else	//p값이 인자값보다 작을때
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
