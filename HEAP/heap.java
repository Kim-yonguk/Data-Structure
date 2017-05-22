package heap;

public class heap {


	private static final int max=200;
	private Element[] heap;
	private int n;
	
	private class Element {
		private int item;

		Element(int item) {
			this.item = item;
		}
	}
	
	
	heap(){
		heap = new Element[max];
		n = 0;
	}
	
	public boolean heap_full(int n){
		if(n==max-1){
			System.out.println("the heap is full");
			return true;
		}
		else{
			return false;
		}
	}
	public boolean heap_empty(int n){
		if(n==0)
		{
			return true;
		}
		else{
			return false;
		}
	}
	public void insert(int item){
		Element element = new Element(item);
		int i;
		if(heap_full(n)){
			System.out.println("the heap is full");
		}
		else{
		
		i=++n;
	
		while((i!=1)&&(element.item>heap[i/2].item)){
			heap[i]=heap[i/2];
			i/=2;
		}
		//heap[i].item = item;
		heap[i]=element;
		
		}
	}
	public int delete(){
		
		int parent,child;
		Element element,temp;
		
		if(heap_empty(n)){
			System.out.println("the heap is empty");
			return -1;
			
		}
		element=heap[1];
		
		temp=heap[n--];
		
		parent=1;
		child=2;
		
		while(child<=n){
			if((child<n)&&heap[child].item<heap[child+1].item)
				child++;
				
			if(temp.item>=heap[child].item)
				break;
			
			heap[parent]=heap[child];
			parent=child;
			child=child*2;
		}
		heap[parent]=temp;	
		return element.item;
		
	}
	public void print(){
		if(heap_empty(n)){
			System.out.println("heap is empty");
		}
		else{

			for(int i=1	; i<n+1; i++)
			{
				System.out.print(heap[i].item+" ");
			}
			
		}
		System.out.println("");
	}
}
