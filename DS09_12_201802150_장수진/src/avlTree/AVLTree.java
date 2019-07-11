package avlTree;

public class AVLTree {
	private int key, height; // �������� key, Ʈ���� ���� height ����
	private AVLTree left, right; // ���ʰ� ������ ����Ʈ���� ��Ÿ���� AVLTree�� ���� left, right
	public static final AVLTree NIL = new AVLTree(); // ����Ʈ���� AVLTree NIL
	
	public AVLTree(int key) {
		// �ܵ�Ʈ�� ������
		this.key = key; // key���� �Է¹��� key
		left = right= NIL; // left�� right�� NIL�� ���� (�ܵ�Ʈ���� ����Ʈ���� ����)
	}
	public AVLTree() {
		// ����Ʈ�� ������
		left=right=this; // left�� right�� ��� ����Ʈ���� ����
		height = -1; // ���̴� -1 (�ܵ�Ʈ���� ��� ���̰� 0�̱� ����)
	}
	public AVLTree(int key, AVLTree left, AVLTree right) {
		// key���� ����, ������ ����Ʈ���� �� ���� ������ 
		this.key = key; // key���� �Է¹��� key
		this.left = left; // ���� ����Ʈ���� �Է¹��� left
		this.right = right; // ������ ����Ʈ���� �Է¹��� right
		height = 1 + Math.max(left.height, right.height);
		// ���̴� ���ʰ� ������ ����Ʈ�� �� �� ���� Ʈ���� 1�� ���� ��
	}
	
	public String toString() {
		// AVLTree ��¸޼ҵ� ������
		if(this==NIL) return ""; // NIL�� ��쿡�� �ƹ��͵� ������� ����
		return left+" "+ key +" "+right; // ���� key ������ ������ ����ϵ��� �Ͽ� ������ȸ�ϵ� ���
	}
	
	public AVLTree grow(int key) {
		// Ʈ���� �߰�
		if(this == NIL) {
			// ���� ����Ʈ�����ٸ�
			return new AVLTree(key); // �ܵ�Ʈ���� �����Ͽ� ��ȯ (���ٿ��� ��)
		}
		if(key == this.key) return this; // ���� ���� ����� Ű ���� �߰��ϰ��� �ϴ� Ű ���� ���� ��� �ڽ� ��ȯ
		if(key < this.key) {
			// ���� ����� Ű ������ �߰��ϰ��� �ϴ� Ű ���� ���� ��� ���ʿ� �߰��ؾ� �ϹǷ�
			left = left.grow(key); // ���� ����Ʈ������ grow �޼ҵ带 �ٽ� ȣ�����ְ�, �̸� left�� �޵��� ��. (������ Ʈ���� �ٽ� �޾��� �� �ֵ��� ��)
		}
		else {
			// ���� ����� Ű ������ �߰��ϰ��� �ϴ�  Ű ���� Ŭ ��� �����ʿ� �߰��ؾ� �ϹǷ�
			right = right.grow(key); // ������ ����Ʈ������ grow �޼ҵ带 �ٽ� ȣ�����ְ�, �̸� right�� �޵��� ��. (������ Ʈ���� �ٽ� �޾��� �� �ֵ��� ��)
		}
		rebalance(); // rebalance �޼ҵ带 ȣ���Ͽ� ������ �������� �� Ȯ��
		height = 1 + Math.max(left.height, right.height); // ���̸� ������ (���� �� �� �� ���� ����Ʈ���� ���̿� 1 �߰�)
		return this; // �ڽ��� ��ȯ��. (������ Ʈ���� �ٽ� ���� �� �ֵ��� �ϱ� ����)
	}
	
	public AVLTree remove(int key) {
		// Ʈ������ ����
		AVLTree root = this;
		if(root == NIL) return root;
		if(root.key == key) {
			// �긦 �����ؾ� ��.
			if((root.left == NIL) || (root.right == NIL)) {
				// �ڽ��� �ϳ� ���� �ְų� �� ���� �ְų�
				if(root.left != NIL) {
					// ���� �ڽ� �ϳ�
					root.key = root.left.key; // ���� ����� Ű�� ���� �ڽ��� Ű�� �ϰ�
					root.left = root.left.left; // ���� ����� ���� ����Ʈ���� ���� �ڽ��� ���� ����Ʈ���� �ϰ�
					root.right = root.left.right; // ���� ����� ������ ����Ʈ���� ���� �ڽ��� ������ ����Ʈ���� ��
					// -> ���� ����� ���� ����Ʈ���� �ڽ��� ��ġ�� �״�� �ø�
				} else if(root.right !=NIL) {
					// ������ �ڽ� �ϳ�
					root.key = root.right.key; // ���� ����� Ű�� ������ �ڽ��� Ű�� �ϰ�
					root.left = root.right.left; // ���� ����� ���� ����Ʈ���� ������ �ڽ��� ���� ����Ʈ���� �ϰ�
					root.right = root.right.right; // ���� ����� ������ ����Ʈ���� ������ �ڽ��� ������ ����Ʈ���� ��
					// -> ���� ����� ������ ����Ʈ���� �ڽ��� ��ġ�� �״�� �ø�
				}
				else {
					// �ڽ��� ����
					root = NIL; // root�� NIL�� �Ͽ� ������ ó�� ���� ���� ����
				}
			}
			else {
				// ���� �ڽ��� �� ����
				AVLTree temp = minimum(root.right); // root�� right�� �ּڰ��� ��ȯ�޾� temp�� ����
				root.key = temp.key; // root�� key�� temp�� key�� �ٲ�
				root.right = root.right.remove(temp.key); // root�� right���� temp�� ������ ��, �װ��� root�� right�� ���������.
				// (������ ������ Ʈ���� �����������ϹǷ� root.right�� ������ Ʈ���� �޵��� ����� ��.)
				
			}
		}
		if(key < root.key) {
			// key�� root�� key���� ���� ���
			root.left = root.left.remove(key); // ���� ����Ʈ������ remove�� �ٽ� ȣ���� ��, �װ��� root�� left�� ���������.
		}
		else {
			// key�� root�� key���� Ŭ ���
			root.right = root.right.remove(key); // ������ ����Ʈ������ remove�� �ٽ� ȣ���� ��, �װ��� root�� right�� ���������.
		}
		rebalance(); // rebalance �޼ҵ带 ȣ���Ͽ� ������ �������� �� Ȯ��
		height = 1 + Math.max(left.height, right.height); // ���̸� ������ (���� �� �� �� ���� ����Ʈ���� ���̿� 1 �߰�)
		return root; // �ڽ��� ��ȯ��. (������ Ʈ���� �ٽ� ���� �� �ֵ��� �ϱ� ����)
	}
	
	public AVLTree minimum(AVLTree Node) {
		// �ּڰ��� ã�� �޼ҵ� - �������� �� �̻� �̵��� �� ���� �� �� ���� �ּڰ�
		if(Node.left != NIL) {
			// Node�� ���� ����Ʈ���� NIL�� �ƴ϶��
			return minimum(Node.left); // Node�� left�� Node�� �Ͽ� �޼ҵ� �ٽ� ȣ��
		} else {
			// Node�� ���� ����Ʈ���� NIL�̶��
			return Node; // ���� ��尡 �ּڰ��̶�� �ǹ��̹Ƿ� Node�� ��ȯ
		}	
	}
	
	private void rebalance() {
		// ������ �´��� ���� �ʴ����� Ȯ���ϰ� �����ϴ� �޼ҵ�
		if(right.height > left.height+1) {
			// right�� ���̰� left�� ���̺��� 2 �̻� ũ��
			if(right.left.height> right.right.height) {
				// ������ ����Ʈ���� ���� ����Ʈ�� ���̰� ������ ����Ʈ���� ������ ����Ʈ�� ���̺��� ũ��
				right.rotateRight(); // ������ ����Ʈ���� ��Ʈ�� �Ͽ� ������ ȸ���� ��
				// -> ���� ������-���� ȸ�� (�� ������ ȸ�� ����)
			}
			rotateLeft();// ���� ȸ��
		}
		else if(left.height > right.height+1) {
			// left�� ���̰� right�� ���̺��� 2�̻� ũ��
			if(left.right.height > left.left.height) {
				// ���� ����Ʈ���� ������ ����Ʈ�� ���̰� ���� ����Ʈ���� ���� ����Ʈ�� ���̺��� ũ��
				left.rotateLeft(); // ���� ����Ʈ���� ��Ʈ�� �Ͽ� ���� ȸ���� ��
				// -> ���� ����-������ ȸ�� (�� ���� ȸ�� ����)
			}
			rotateRight(); // ������ ȸ��
		}
	}
	private void rotateLeft() {
		// ���� ȸ��
		left = new AVLTree(key, left, right.left);
		// ���� ����Ʈ���� ����� Ʈ���� ���� ����� ����
		key = right.key; // Ű ���� ������ ����Ʈ���� Ű ������ ��
		right = right.right; // ������ ����Ʈ���� ������ ����Ʈ���� ������ ����Ʈ���� ��
	}
	private void rotateRight() {
		// ������ ȸ��
		right = new AVLTree(key, left.right, right);
		// ������ ����Ʈ���� ����� Ʈ���� ���� ����� ����
		key = left.key; // Ű ���� ���� ����Ʈ���� Ű ������ ��
		left = left.left; // ���� ����Ʈ���� ���� ����Ʈ���� ���� ����Ʈ���� ��
	}
}