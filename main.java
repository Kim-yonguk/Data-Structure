import java.util.*;
public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree BST=new Tree();	///BST ��ü����
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			int choice;	///���θ޴� �Է¹��� ����
			System.out.print("1.Insert 2.Delete 3.Search 4.Print 5.Quit : ");
			choice=sc.nextInt();
			int num;
			switch(choice){
			case 1:
				System.out.print("Insert num : ");
				num=sc.nextInt();
				BST.insertBST(num);	//BST�� num�� value�� ���� ������
				break;
			case 2:
				System.out.print("Delete num : ");
				num=sc.nextInt();
				BST.deleteBST(num);	//BST�� num value ����  ������
				break;
			case 3:
				System.out.print("Search num : ");
				num=sc.nextInt();
				BST.searchBST(num);	//BST�� num value ���� ���˻�
				break;
			case 4:
				BST.drawTree();		//BST ���
				break;
			case 5:
				System.exit(1);
				
			}
		}
	}

}
