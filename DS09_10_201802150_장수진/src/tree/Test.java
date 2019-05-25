package tree;

import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedTree tree_77, tree_44, tree_99, tree_33, tree_55;
		// �ڽ��� ���� ��ü �̸� ����
		
		OrderedTree tree_22 = new OrderedTree(22); // root�� 22�� �ܵ� Ʈ�� ����
		OrderedTree tree_66 = new OrderedTree(66); // root�� 66�� �ܵ� Ʈ�� ����
		OrderedTree tree_88 = new OrderedTree(88); // root�� 88�� �ܵ� Ʈ�� ����
		
		List subtreeOf_33 = new LinkedList(); // root�� 33���� �ϴ� Ʈ���� subtree�� ���� list ��ü
		subtreeOf_33.add(tree_22); // subtree list�� root�� 22�� Ʈ���� ����
		tree_33 = new OrderedTree(33, subtreeOf_33);
		// subtree�� subtreeOf_33 list�� ����ִ� Ʈ���� ���� root�� 33�� Ʈ�� ����
		
		List subtreeOf_55 = new LinkedList(); // root�� 55�� �ϴ� Ʈ���� subtree�� ���� list ��ü
		subtreeOf_55.add(tree_66); // subtree list�� root�� 66�� Ʈ���� ����
		tree_55 = new OrderedTree(55, subtreeOf_55);
		// subtree�� subtreeOf_55 list�� ����ִ� Ʈ���� ���� root�� 55�� Ʈ�� ����
		
		List subtreeOf_44 = new LinkedList(); // root�� 44�� �ϴ� Ʈ���� subtree�� ���� list ��ü
		subtreeOf_44.add(tree_33); // subtree list�� root�� 33�� Ʈ���� ����
		subtreeOf_44.add(tree_55); // subtree list�� root�� 55�� Ʈ���� ����
		tree_44 = new OrderedTree(44, subtreeOf_44);
		// subtree�� subtreeOf_44 list�� ����ִ� Ʈ���� ���� root�� 44�� Ʈ�� ����
		
		List subtreeOf_99 = new LinkedList(); // root�� 99�� �ϴ� Ʈ���� subtree�� ���� list ��ü
		subtreeOf_99.add(tree_88); // subtree list�� root�� 88�� Ʈ���� ����
		tree_99 = new OrderedTree(99, subtreeOf_99);
		// subtree�� subtreeOf_99 list�� ����ִ� Ʈ���� ���� root�� 99�� Ʈ�� ����
		
		List subtreeOf_77 = new LinkedList(); // root�� 77�� �ϴ� Ʈ���� subtree�� ���� list ��ü
		subtreeOf_77.add(tree_44); // subtree list�� root�� 44�� Ʈ���� ����
		subtreeOf_77.add(tree_99); // subtree list�� root�� 99�� Ʈ���� ����
		tree_77 = new OrderedTree(77, subtreeOf_77);
		// subtree�� subtreeOf_77 list�� ����ִ� Ʈ���� ���� root�� 77�� Ʈ�� ����
		
		System.out.print("���� ���� ��ȸ : ");
		tree_77.levelorder(); // ���� ���� ��ȸ �޼ҵ� ȣ��
	}
}