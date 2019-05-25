package doublyLinkedQueue;

public class DoublyLinkedQueue {
	
	class Node{
		Object object; // object�� �����ϴ� ����
		Node prev = this; // prev�� null�� �ƴ϶� �ڱ� �ڽ��� ����Ű���� ��
		Node next = this; // next�� null�� �ƴ϶� �ڱ� �ڽ��� ����Ű���� ��
		Node(Object object, Node prev, Node next){
			// 3���� �Ű������� ������ ��� ������
			this.object = object; // ���ڷ� �Ѿ�� object �ʵ��� object�� ����
			this.prev = prev; // ���ڷ� �Ѿ��  prev �ʵ��� prev�� ����
			this.next = next; // ���ڷ� �Ѿ�� next �ʵ��� next�� ���� 
		}
		Node (Object object){
			// �Ű������� object�� ������ ������
			this.object = object; // ���ڷ� �Ѿ�� object �ʵ��� object�� ����
		}
	}
	
	Node head = new Node(null); // �� ��� ��带 ����
	private int size=0; // size�� 0���� �ʱ�ȭ
	
	void add(Object o) {
		// ��带 �߰��ϴ� add �޼ҵ�
		head.next = new Node(o,head,head.next);
		// object�� o�� ������, prev�� head, next�� head.next�� ������ ��ü�� �����, �� ��ü�� head.next�� �����ϵ��� �Ѵ�.
		// �տ��� �����ϴ� ���̴�.
		head.next.next.prev = head.next;
		/* ���ο� ��带 ����Ű�� head.next�� head.next.next.prev�� ����Ű���� �Ͽ�,
		  �� ��� ���� ���� head�� ����Ű�� �ִ� ����� prev�� �� ��带 ����Ű���� �Ѵ�.
		 head.next.next.prev = head.next = new Node(o,head,head.next); �νĸ���. �� �ٿ� ���� ����
		*/
		
		size++; // �� ��� �� ���� ���ԵǾ����Ƿ� ����� 1 �ø���.
	}
	
	Object remove() {
		// ��带 �����ϴ� remove �޼ҵ�
		if(empty()) {
			// ť�� ����ִٸ�
			System.out.println("ť�� ������ϴ�."); // ť�� ����ִٴ� �ȳ����� ����ϰ�
			return null; // null�� �����Ѵ�.
		}
		Object temp = head.prev.object; // head.prev�� object�� temp�� �����ϵ��� �Ѵ�.
		head.prev = head.prev.prev; // head.prev.prev�� head.prev�� �����ϵ��� �Ͽ� �� ���� ��� ������ �ϳ� �����.
		head.prev.next = head; // head�� head.prev.next�� �����ϵ��� �Ͽ� �� ���� ��� ������ �����.
		// �� ���� ��带 �����Ѵ�.
		size--; // ���������Ƿ� ����� 1 ���δ�.
		return temp; // �����صξ��� ������ ����� object�� �����Ѵ�.
	}
	
	boolean empty() {
		// ť�� ����ִ����� Ȯ���ϴ� empty �޼ҵ�
		if(size==0) {
			// size�� 0 �̶��
			return true; // ����ִ� ���̹Ƿ� true ����
		}
		return false; // �ƴҰ�� false ����
	}
	
	Object first() {
		// ť�� �� �տ� �ִ� ��� ��ȯ�ϴ� first �޼ҵ�
		if(!empty()) {
			// ������� �ʴٸ�
			return head.prev.object; // head.prev�� ���� �����ϴ� ���� �� �տ� �ִ� ����� object ����
		}
		return null; // �ƴҰ�� null ����
	}
	
	int size() {
		// size�� ��ȯ���ִ� size�޼ҵ�
		return size; // size�� ��ȯ
	}
}