package queue;

public class SLinkedQueue {
	private Node rear; // ���������� ������ ��带 ����Ű�� ���� rear
	private Node front; // ó�� ���� ��带 ����Ű�� ���� front
	private int size=0; // ť�� size�� �����ϴ� ���� size�� 0���� �ʱ�ȭ
	class Node {
		// ��� Ŭ����
		Node next; // ���� ����� �ּҸ� �����ϴ� ���� next
		Object object; // �����͸� �����ϴ� ���� object
		
		Node(Object object){
			// ����� �����ڴ� object�� �Է¹޾�
			this.object = object;
			// �Է¹��� object�� �����Ǵ� ����� object�� �� 
		}
	}
	
	void add(Object o) {
		// ����
		if(rear == null) { 
			// rear�� null�̶�� ó������ ���ԵǴ� ���̹Ƿ�
			front = rear = new Node(o);
			// ���ο� ��带 ����� rear�� front�� ��� �� ��带 ����Ű�� ��.
			size++; // ��尡 �����Ǿ����Ƿ� size�� 1 �ø�
		}
		else {
			// ó������ ���ԵǴ� �� �ƴ϶��
			rear = rear.next = new Node(o);
			// rear.next�� ���ο� ��带 ����Ű�� �ϰ�, rear.next�� rear�� ����Ű�� �Ͽ� ������ ��带 rear�� ����Ű�� ��
			size++; // ��尡 �����Ǿ����Ƿ� size�� 1 �ø�
		}
	}
	Object remove() {
		// ����
		Object temp; // �����Ǵ� ����� �����͸� ������ ���� temp
		if(front==null) {
			// front�� null�̶�� ����� ��尡 ���� ���̹Ƿ�
			System.out.println("ť�� ����ֽ��ϴ�."); // ť�� ������� �ȳ���
			return null; // null�� ������
		}
		else {
			// ����� ��尡 �ִٸ�
			temp = front.object; // front�� �����͸� temp�� ����ϰ� �ϰ�
			front = front.next; // ��带 ������
			size--; // ��带 �����Ͽ����Ƿ� size�� 1 ����
			if(front==null) {
				// ���̰� �� �� front�� null�̶�� ���� ��尡 ���ٴ� ���̹Ƿ�
				rear = null; // rear�� null�� �������.
			}
		}
		return temp; // ������ ����� �����͸� ������
	}
	
	boolean empty() {
		// ť�� ����ִ����� Ȯ���ϴ� �޼ҵ�
		if(size==0) { // size�� 0�̶��
			return true; // ����ִٴ� �ǹ�
		}
		return false; // �ƴ϶�� false
	}
	
	Object first() {
		// ù ��° ��带 �������� �ʰ� ��ȯ���ִ� �޼ҵ�
		Object temp; // ����� �����͸� ������ ���� temp
		if(front==null) {
			// front�� null�̶�� ����� ��尡 ���� ���̹Ƿ�
			System.out.println("ť�� ����ֽ��ϴ�."); // ť�� ������� �ȳ���
			return null; // null�� ������
		}
		else {
			// ����� ��尡 �ִٸ�
			temp = front.object; // temp�� front�� object�� ������
		}
		return temp; // �� �տ� �ִ� ����� �����͸� ������
	}
	int size() {
		// size�� �������ִ� �޼ҵ�
		return size; // size�� ������
	}
}