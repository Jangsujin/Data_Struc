package LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList list = new MyLinkedList(10);
		// s�� 10���� �Ͽ� ��ü�� �����Ѵ�.
		list.print(); // print�Ͽ� ����Ʈ�� ������ ����Ѵ�.
		list.removemultiples(3); // 3�� ����� �����.
		list.print(); // print�Ͽ� ����Ʈ�� ������ ����Ѵ�.
		list.reverse(); // ��忡 ����� ���� �����´�.
		list.print(); // print�Ͽ� ����Ʈ�� ������ ����Ѵ�.

	}

}
