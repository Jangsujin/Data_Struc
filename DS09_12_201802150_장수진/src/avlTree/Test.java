package avlTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree avl = new AVLTree(14); // �ܵ� Ʈ�� ����
		avl.grow(17);
		avl.grow(11);
		avl.grow(7);
		avl.grow(53);
		avl.grow(4);
		avl.grow(13);
		avl.grow(12);
		avl.grow(8);
		// Ʈ���� �߰�
		System.out.println(avl); // avl Ʈ�� ���
		System.out.println("");
		
		avl.remove(53);
		System.out.println("53 ���� : "+avl); // 53 ���� �� ���
		avl.remove(11);
		System.out.println("11 ���� : "+avl); // 11 ���� �� ���
		avl.remove(7);
		System.out.println(" 7 ���� : "+avl); // 7 ���� �� ���
		avl.remove(12);
		System.out.println("12 ���� : "+avl); // 12 ���� �� ���
		avl.remove(14);
		System.out.println("14 ���� : "+avl); // 14 ���� �� ���
		avl.remove(13);
		System.out.println("13 ���� : "+avl); // 13 ���� �� ���
	}
}