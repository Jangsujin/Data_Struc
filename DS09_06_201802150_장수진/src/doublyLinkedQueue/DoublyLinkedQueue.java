package doublyLinkedQueue;

public class DoublyLinkedQueue {
	
	class Node{
		Object object; // object를 저장하는 변수
		Node prev = this; // prev는 null이 아니라 자기 자신을 가리키도록 함
		Node next = this; // next도 null이 아니라 자기 자신을 가리키도록 함
		Node(Object object, Node prev, Node next){
			// 3개의 매개변수를 가지는 노드 생성자
			this.object = object; // 인자로 넘어온 object 필드의 object로 저장
			this.prev = prev; // 인자로 넘어온  prev 필드의 prev로 저장
			this.next = next; // 인자로 넘어온 next 필드의 next로 저장 
		}
		Node (Object object){
			// 매개변수로 object만 가지는 생성자
			this.object = object; // 인자로 넘어온 object 필드의 object로 저장
		}
	}
	
	Node head = new Node(null); // 빈 헤드 노드를 만듦
	private int size=0; // size는 0으로 초기화
	
	void add(Object o) {
		// 노드를 추가하는 add 메소드
		head.next = new Node(o,head,head.next);
		// object로 o를 가지고, prev는 head, next는 head.next를 가지는 객체를 만들고, 이 객체를 head.next가 참조하도록 한다.
		// 앞에서 삽입하는 것이다.
		head.next.next.prev = head.next;
		/* 새로운 노드를 가리키는 head.next를 head.next.next.prev가 가리키도록 하여,
		  새 노드 삽입 전에 head가 가리키고 있던 노드의 prev가 새 노드를 가리키도록 한다.
		 head.next.next.prev = head.next = new Node(o,head,head.next); 인식못함. 한 줄에 쓰지 말기
		*/
		
		size++; // 새 노드 한 개가 삽입되었으므로 사이즈를 1 늘린다.
	}
	
	Object remove() {
		// 노드를 삭제하는 remove 메소드
		if(empty()) {
			// 큐가 비어있다면
			System.out.println("큐가 비었습니다."); // 큐가 비어있다는 안내문을 출력하고
			return null; // null을 리턴한다.
		}
		Object temp = head.prev.object; // head.prev의 object를 temp가 저장하도록 한다.
		head.prev = head.prev.prev; // head.prev.prev를 head.prev가 참조하도록 하여 맨 뒤의 노드 참조를 하나 지운다.
		head.prev.next = head; // head를 head.prev.next가 참조하도록 하여 맨 두의 노드 참조를 지운다.
		// 맨 뒤의 노드를 삭제한다.
		size--; // 삭제했으므로 사이즈를 1 줄인다.
		return temp; // 저장해두었던 마지막 노드의 object를 리턴한다.
	}
	
	boolean empty() {
		// 큐가 비어있는지를 확인하는 empty 메소드
		if(size==0) {
			// size가 0 이라면
			return true; // 비어있는 것이므로 true 리턴
		}
		return false; // 아닐경우 false 리턴
	}
	
	Object first() {
		// 큐의 맨 앞에 있는 노드 반환하는 first 메소드
		if(!empty()) {
			// 비어있지 않다면
			return head.prev.object; // head.prev에 가서 삭제하는 곳에 맨 앞에 있는 노드의 object 리턴
		}
		return null; // 아닐경우 null 리턴
	}
	
	int size() {
		// size를 반환해주는 size메소드
		return size; // size를 반환
	}
}