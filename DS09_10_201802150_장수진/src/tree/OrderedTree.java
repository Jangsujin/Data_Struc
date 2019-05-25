package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OrderedTree {
	private Object root; // Ʈ���� root
	private List subtrees; // Ʈ���� subtree - ����Ʈ���̱� ������ �ڷᱸ���� list
	private int size; // Ʈ���� ũ��
	
	public OrderedTree() {
		// ���� Ʈ��
	}
	public OrderedTree(Object root) {
		// �ܵ� Ʈ��
		this.root = root; // Ʈ���� root�� �Ķ���ͷ� �Ѱܹ��� root�� ��
		subtrees = new LinkedList(); // subtrees ��ü ����
		size = 1; // �ܵ� Ʈ���̱� ������ ũ��� 1
	}
	public OrderedTree(Object root, List trees) {
		// root�� subtree�� �� Ʈ���� ��� list�� �Ű������� �޴� ������
		this(root); // �ܵ� Ʈ�� ����
		for(Iterator it = trees.iterator(); it.hasNext();) {
			// trees�� �湮�ϴµ�, �� �̻� �湮�� �� ���� ������ �ݺ�
			Object object = it.next(); // ����Ʈ�� �ִ� ��ü�� object�� �ް�,
			if(object instanceof OrderedTree) {
				// object�� ���� Ÿ���� OrderedTree�� �� 
				OrderedTree tree = (OrderedTree)object;
				// object�� ObjectTree���·� ����ȯ�ϰ�, �̸� tree�� ��
				subtrees.add(tree); // tree�� subtrees�� ����
				size += tree.size(); // size�� tree�� ũ�⸦ ���� ��
			}
		}
	}
	
	public void levelorder() {
		// ���� ���� ��ȸ �޼ҵ�
		OrderedTree start = this; // �޼ҵ� ȣ���ϴ� �ָ� �������� ��.
		LinkedList<OrderedTree> queue = new LinkedList<>();
		// linkedlist�� �ڷ����� orderedTree�� �Ͽ� queue�� ����
		queue.add(start); // start�� queue�� ����
		while(queue.peek() != null) {
			// queue�� �� �̻� Ʈ���� �������� ���� ������ �ݺ�
			for(Iterator it = queue.peek().subtrees.iterator(); it.hasNext();) {
				// ť�� ù ��° Ʈ���� subtrees�� �湮�ϴµ�, �� �̻� �湮�� ���� ���� ������ �ݺ�
				Object object = it.next(); // Object ���·� ��ü�� �����ͼ�
				if(object instanceof OrderedTree) {
					// OrderedTree ���¶��
					queue.add((OrderedTree)object);
					// object�� OrderedTree ���·� ����ȯ�Ͽ� queue�� ����
				}
			}
			System.out.print(queue.poll().root+" ");
			// queue�� �� �� OrderedTree�� �����ϸ� ��ȯ�ϴµ�, �� Ʈ���� root�� ���
		}
	}
	
	public int size() {
		return size;
		// Ʈ���� ũ�⸦ ��ȯ�ϴ� �޼ҵ�
	}
}
