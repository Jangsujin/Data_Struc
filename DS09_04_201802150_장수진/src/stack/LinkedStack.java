package stack;

public class LinkedStack {
	
	class Node{
		// ��� Ŭ����
		int op; // �ε����� ������ int�� op����
		Node next; // ���� ����� �ּҸ� ������ Node�� next����
		Node(int op){
			this.op = op;
			// ������
		}
	}
	Node top; // Node������ top ������ ����
	int size=0; // stack�� ���� �ε����� ������ ������ size ����
	
	void push(int op){
		// stack�� ���� push �޼ҵ� 
		if(top==null) {
			top = new Node(op); // top�� ����ִٸ� �ű⿡ ����
			size++; // stack�� �� �� �׿����Ƿ� size 1 �ø�
		}
		else {
			Node temp = new Node(op); // temp�� ���� ��� ����
			temp.next = top; // top�� �ּҸ� temp�� next�� ����
			top = temp; // top�� temp�� ����Ű���� ��
			size++; // stack�� �� �� �׿����Ƿ� size 1 �ø�
		}
	}
	int pop() {
		// stack���� �� pop �޼ҵ�
		int temp = top.op; // temp�� top�� �ִ� index ����
		
		top = top.next; // top�� top�� ���� ��带 ����Ű�� ��.
		size--; // stack���� �� ���� �����Ƿ� size 1 ����
		return temp; // temp�� ������
	}
	boolean isEmpty() {
		if(top==null) { // top�� null�̸� ����ִ� ���̹Ƿ�
			return true; // true ����
		}
		return false; // �ƴҰ�� false ����
	}
	
	public LinkedStack(String args){
		// string args�� �Ű������� �Ѱܹ޴� ������ 
		String[] expression = new String[args.length()];
		// expression �迭�� args�� ���̸�ŭ ������ �Ҵ��Ѵ�.
			
		for(int i=0;i<args.length();i++) {
			expression[i] = args.charAt(i)+"";
			// ���ڿ� args�� ���ڵ�� ������, string���� �ٲپ� �迭 expression�� ����
		}
		for(int i=0;i<expression.length;i++) {
			if(expression[i].equals("(")) {
				// expression�� "("�� ������ 
				push(i); // "("�� �ε����� push �Ѵ�.
			}
			if(expression[i].equals(")")) {
				// expression�� ")"�� ������
				if(!isEmpty()) {
					System.out.println(pop()+","+i);
					// stack�� ������� ���� �� ���� �����"("�� �ε����� pop�ϰ�, "("�� ")"�� �ε����� ����Ѵ�.
				}
				else {
					System.out.println("��ȣ���Ⱑ ���� ����");
					// ���� stack�� ����ִٸ� ¦�� ���� �����Ƿ� Ʋ�ȴٴ� �ȳ����� ���
					return ; // ������.
				}
			}
		}
		if(isEmpty()) {
			// �ݺ����� �� ���� ������ ��, stack�� ����ִٸ� ��ȣ���Ⱑ �´� ���̹Ƿ�
			System.out.println("��ȣ���Ⱑ ����"); // �¾Ҵٴ� �ȳ����� ����Ѵ�.
		}
		else {
			System.out.println("��ȣ���Ⱑ ���� ����"); // �׷��� ������ Ʋ�ȴٴ� �ȳ����� ����Ѵ�.
		}	
	}
}