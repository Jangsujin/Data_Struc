package LinkedList;

import java.util.ArrayList;
import java.util.Random;

public class MyLinkedList {
	private Node start;
	
	class Node {
		// 노드 클래스를 생성한다.
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
		} // 생성자는 data를 인자로 받아 이 객체의 data로 하도록 한다.
	}
	
	public MyLinkedList(int s) {
		Random rand = new Random();
		if(start==null) {
			start = new Node(rand.nextInt(20));
			/* start가 null일 때 start가 Node의 주소값을 기억하도록한다.
				처음생성하는 것이기 때문에 반드시 여기서 한 개의 노드를 생성하게 된다.
			*/
		}
		Node p = start; // 노드 p가 start를 참조하도록 한다.
		for(int i = 0; i<s-1; i++) {
			// 앞에서 한 개의 노드를 생성했기 때문에 s-1개의 노드만을 추가로 생성한다.
			p.next = new Node(rand.nextInt(20));
			p = p.next;
			// p가 한 칸 앞으로 전진하게 한다.
		}
	}
	
	void removemultiples(int x) {
		System.out.println("removemultiples("+x+") 호출");
		// removemultiples를 호출한다는 안내문을 출력한다.
		while(true) {
			// 계속 반복시킨다.
			if((start.data%x==0)&(start.data!=0)) {
				// 만약 start의 데이터가 x의 배수이고, 0이 아니라면
				start = start.next;
				// start가 start의 next 주소를 저장하도록 한다.
			}
			if((start.data%x!=0)|(start.data==0)) {
				// 만약 start의 데이터가 x의 배수가 아니거나 start의 data가 0이라면
				break;
				// 반복문을 빠져나간다.
			}
		}
		for(Node p = start;p.next!=null;p=p.next) {
			// 노드 p의 시작점을 start로 하고, p가 참조하고 있는 노드 다음에 있는 노드가 없을때까지 반복한다.
			if((p.next.data%x==0)&(p.next.data!=0)) {
				// 만약 p가 참조하고 있는 다음 노드의 데이터가 x의 배수이고, 0이 아닐 때
				if(p.next.next==null) {
					// p.next.next가 null이면 p.next가 마지막 노드이고, 그 노드를 없애야하는 것이기 때문에 
					p.next=null;
					// p.next를 null로 한 후
					break; // for문을 종료시킨다.
				}
				while(true) {
					if((p.next.data%x!=0)|p.next.data==0) {
						// 만약 p가 참조하고 있는 다음 노드의 데이터가 x의 배수이고, 0이 아닐 때
						break;
						// while문을 빠져나간다.
					}
					if(p.next.next==null) {
						// p.next.next가 null이면 p.next가 마지막 노드이고, 그 노드를 없애야하는 것이기 때문에
						p.next=null;
						// p.next를 null로 한 후
						break; // while문을 빠져나간다.
					}
					p.next = p.next.next;
					// p.next가 p.next.next를 참조하도록 하여 x의 배수 노드를 없앤다.
				}		
			}
			if(p.next==null) {
				// p.next가 null이라면
				break; // for문을 종료시킨다.
			}
		}
	}
	
	void reverse() {
		System.out.println("reverse() 호출");
		// reverse를 호출한다는 안내문을 출력한다.
		ArrayList<Integer> list = new ArrayList<>();
		// ArrayList 객체를 만든다.
		while(start.next!=null) {
			// start.next가 null이 아닐 때까지 반복한다.
			Node p = start; // 노드 p에 start 주소값을 저장한다.
			for(;p.next.next!=null;p=p.next) {
			} // for문을 나왔을 때 마지막 전 노드를 p가 참조하는 상태로 만든다.
			list.add(p.next.data); // p.next의 데이터를 arraylist에 담는다.
			p.next = null; // p.next를 null로 하여 맨 뒤 노드 하나를 자른다.
		}
		list.add(start.data); // 첫 번째 노드의 데이터를 arraylist에 담는다.
		start.data = list.get(0);
		// 첫 번째 노드가 list의 첫 번째 데이터, 즉 연결리스트의 마지막에 있던 데이터 값을 가지게 한다.
		Node p = start; // 노드 p가 start가 가진 주소를 가리키도록 한다.
		for(int i=1;i<list.size();i++) {
			p.next = new Node(list.get(i));
			// p.next에 arraylist의 i번째 원소를 data로 가지는 노드를 만든다.
			p = p.next; // p가 앞으로 나아가도록 한다.
		}
	}
	
	void print() {
		System.out.print("현재 리스트의 구조 : "+start.data);
		// 현재 리스트의 구조를 출력한다는 안내문과 start가 참조하는 노드의 data를 출력한다.
		for(Node p = start.next;p!=null;p=p.next) {
			// start가 참조하는 노드의 데이터는 출력하였으므로, 그 다음노드를 시작점으로 한다.
			System.out.print(" -> "+ p.data); // p의 data를 출력한다.
		}
		System.out.println(""); // 줄바꿈을 해준다.
	}
}