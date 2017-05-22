import java.util.*;
public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree BST=new Tree();	///BST 객체생성
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			int choice;	///메인메뉴 입력받을 변수
			System.out.print("1.Insert 2.Delete 3.Search 4.Print 5.Quit : ");
			choice=sc.nextInt();
			int num;
			switch(choice){
			case 1:
				System.out.print("Insert num : ");
				num=sc.nextInt();
				BST.insertBST(num);	//BST에 num의 value를 가진 노드삽입
				break;
			case 2:
				System.out.print("Delete num : ");
				num=sc.nextInt();
				BST.deleteBST(num);	//BST에 num value 가진  노드삭제
				break;
			case 3:
				System.out.print("Search num : ");
				num=sc.nextInt();
				BST.searchBST(num);	//BST에 num value 가진 노드검색
				break;
			case 4:
				BST.drawTree();		//BST 출력
				break;
			case 5:
				System.exit(1);
				
			}
		}
	}

}
