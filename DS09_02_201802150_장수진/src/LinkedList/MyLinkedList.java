package LinkedList;

import java.util.ArrayList;
import java.util.Random;

public class MyLinkedList {
	private Node start;
	
	class Node {
		// ��� Ŭ������ �����Ѵ�.
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
		} // �����ڴ� data�� ���ڷ� �޾� �� ��ü�� data�� �ϵ��� �Ѵ�.
	}
	
	public MyLinkedList(int s) {
		Random rand = new Random();
		if(start==null) {
			start = new Node(rand.nextInt(20));
			/* start�� null�� �� start�� Node�� �ּҰ��� ����ϵ����Ѵ�.
				ó�������ϴ� ���̱� ������ �ݵ�� ���⼭ �� ���� ��带 �����ϰ� �ȴ�.
			*/
		}
		Node p = start; // ��� p�� start�� �����ϵ��� �Ѵ�.
		for(int i = 0; i<s-1; i++) {
			// �տ��� �� ���� ��带 �����߱� ������ s-1���� ��常�� �߰��� �����Ѵ�.
			p.next = new Node(rand.nextInt(20));
			p = p.next;
			// p�� �� ĭ ������ �����ϰ� �Ѵ�.
		}
	}
	
	void removemultiples(int x) {
		System.out.println("removemultiples("+x+") ȣ��");
		// removemultiples�� ȣ���Ѵٴ� �ȳ����� ����Ѵ�.
		while(true) {
			// ��� �ݺ���Ų��.
			if((start.data%x==0)&(start.data!=0)) {
				// ���� start�� �����Ͱ� x�� ����̰�, 0�� �ƴ϶��
				start = start.next;
				// start�� start�� next �ּҸ� �����ϵ��� �Ѵ�.
			}
			if((start.data%x!=0)|(start.data==0)) {
				// ���� start�� �����Ͱ� x�� ����� �ƴϰų� start�� data�� 0�̶��
				break;
				// �ݺ����� ����������.
			}
		}
		for(Node p = start;p.next!=null;p=p.next) {
			// ��� p�� �������� start�� �ϰ�, p�� �����ϰ� �ִ� ��� ������ �ִ� ��尡 ���������� �ݺ��Ѵ�.
			if((p.next.data%x==0)&(p.next.data!=0)) {
				// ���� p�� �����ϰ� �ִ� ���� ����� �����Ͱ� x�� ����̰�, 0�� �ƴ� ��
				if(p.next.next==null) {
					// p.next.next�� null�̸� p.next�� ������ ����̰�, �� ��带 ���־��ϴ� ���̱� ������ 
					p.next=null;
					// p.next�� null�� �� ��
					break; // for���� �����Ų��.
				}
				while(true) {
					if((p.next.data%x!=0)|p.next.data==0) {
						// ���� p�� �����ϰ� �ִ� ���� ����� �����Ͱ� x�� ����̰�, 0�� �ƴ� ��
						break;
						// while���� ����������.
					}
					if(p.next.next==null) {
						// p.next.next�� null�̸� p.next�� ������ ����̰�, �� ��带 ���־��ϴ� ���̱� ������
						p.next=null;
						// p.next�� null�� �� ��
						break; // while���� ����������.
					}
					p.next = p.next.next;
					// p.next�� p.next.next�� �����ϵ��� �Ͽ� x�� ��� ��带 ���ش�.
				}		
			}
			if(p.next==null) {
				// p.next�� null�̶��
				break; // for���� �����Ų��.
			}
		}
	}
	
	void reverse() {
		System.out.println("reverse() ȣ��");
		// reverse�� ȣ���Ѵٴ� �ȳ����� ����Ѵ�.
		ArrayList<Integer> list = new ArrayList<>();
		// ArrayList ��ü�� �����.
		while(start.next!=null) {
			// start.next�� null�� �ƴ� ������ �ݺ��Ѵ�.
			Node p = start; // ��� p�� start �ּҰ��� �����Ѵ�.
			for(;p.next.next!=null;p=p.next) {
			} // for���� ������ �� ������ �� ��带 p�� �����ϴ� ���·� �����.
			list.add(p.next.data); // p.next�� �����͸� arraylist�� ��´�.
			p.next = null; // p.next�� null�� �Ͽ� �� �� ��� �ϳ��� �ڸ���.
		}
		list.add(start.data); // ù ��° ����� �����͸� arraylist�� ��´�.
		start.data = list.get(0);
		// ù ��° ��尡 list�� ù ��° ������, �� ���Ḯ��Ʈ�� �������� �ִ� ������ ���� ������ �Ѵ�.
		Node p = start; // ��� p�� start�� ���� �ּҸ� ����Ű���� �Ѵ�.
		for(int i=1;i<list.size();i++) {
			p.next = new Node(list.get(i));
			// p.next�� arraylist�� i��° ���Ҹ� data�� ������ ��带 �����.
			p = p.next; // p�� ������ ���ư����� �Ѵ�.
		}
	}
	
	void print() {
		System.out.print("���� ����Ʈ�� ���� : "+start.data);
		// ���� ����Ʈ�� ������ ����Ѵٴ� �ȳ����� start�� �����ϴ� ����� data�� ����Ѵ�.
		for(Node p = start.next;p!=null;p=p.next) {
			// start�� �����ϴ� ����� �����ʹ� ����Ͽ����Ƿ�, �� ������带 ���������� �Ѵ�.
			System.out.print(" -> "+ p.data); // p�� data�� ����Ѵ�.
		}
		System.out.println(""); // �ٹٲ��� ���ش�.
	}
}