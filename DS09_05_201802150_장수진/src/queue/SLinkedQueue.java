package queue;

public class SLinkedQueue {
	private Node rear; // 마지막으로 삽입한 노드를 가리키는 변수 rear
	private Node front; // 처음 들어온 노드를 가리키는 변수 front
	private int size=0; // 큐의 size를 저장하는 변수 size를 0으로 초기화
	class Node {
		// 노드 클래스
		Node next; // 다음 노드의 주소를 저장하는 변수 next
		Object object; // 데이터를 저장하는 변수 object
		
		Node(Object object){
			// 노드의 생성자는 object를 입력받아
			this.object = object;
			// 입력받은 object를 생성되는 노드의 object로 함 
		}
	}
	
	void add(Object o) {
		// 삽입
		if(rear == null) { 
			// rear가 null이라면 처음으로 삽입되는 것이므로
			front = rear = new Node(o);
			// 새로운 노드를 만들어 rear와 front가 모두 그 노드를 가리키게 함.
			size++; // 노드가 생성되었으므로 size를 1 늘림
		}
		else {
			// 처음으로 삽입되는 게 아니라면
			rear = rear.next = new Node(o);
			// rear.next가 새로운 노드를 가리키게 하고, rear.next를 rear가 가리키게 하여 마지막 노드를 rear가 가리키게 함
			size++; // 노드가 생성되었으므로 size를 1 늘림
		}
	}
	Object remove() {
		// 삭제
		Object temp; // 삭제되는 노드의 데이터를 저장할 변수 temp
		if(front==null) {
			// front가 null이라면 저장된 노드가 없는 것이므로
			System.out.println("큐가 비어있습니다."); // 큐가 비었음을 안내함
			return null; // null을 리턴함
		}
		else {
			// 저장된 노드가 있다면
			temp = front.object; // front의 데이터를 temp가 기억하게 하고
			front = front.next; // 노드를 삭제함
			size--; // 노드를 삭제하였으므로 size를 1 줄임
			if(front==null) {
				// 줄이고 난 후 front가 null이라면 남은 노드가 없다는 뜻이므로
				rear = null; // rear도 null로 만들어줌.
			}
		}
		return temp; // 삭제한 노드의 데이터를 리턴함
	}
	
	boolean empty() {
		// 큐가 비어있는지를 확인하는 메소드
		if(size==0) { // size가 0이라면
			return true; // 비어있다는 의미
		}
		return false; // 아니라면 false
	}
	
	Object first() {
		// 첫 번째 노드를 삭제하지 않고 반환해주는 메소드
		Object temp; // 노드의 데이터를 저장할 변수 temp
		if(front==null) {
			// front가 null이라면 저장된 노드가 없는 것이므로
			System.out.println("큐가 비어있습니다."); // 큐가 비었음을 안내함
			return null; // null을 리턴함
		}
		else {
			// 저장된 노드가 있다면
			temp = front.object; // temp에 front의 object를 저장함
		}
		return temp; // 맨 앞에 있는 노드의 데이터를 리턴함
	}
	int size() {
		// size를 리턴해주는 메소드
		return size; // size를 리턴함
	}
}