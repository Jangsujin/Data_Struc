package LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList list = new MyLinkedList(10);
		// s를 10으로 하여 객체를 생성한다.
		list.print(); // print하여 리스트의 내용을 출력한다.
		list.removemultiples(3); // 3의 배수를 지운다.
		list.print(); // print하여 리스트의 내용을 출력한다.
		list.reverse(); // 노드에 저장된 값을 뒤집는다.
		list.print(); // print하여 리스트의 내용을 출력한다.

	}

}
