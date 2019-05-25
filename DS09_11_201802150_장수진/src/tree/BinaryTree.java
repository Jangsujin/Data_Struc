package tree;

public class BinaryTree {
	private int key; // Ʈ���� ���� ���� key
	private BinaryTree left, right; // ����, ������ ����Ʈ��
	
	public BinaryTree() {
		// ���ڰ� ���� ������. �ʱ�ȭ ��Ŵ
		key = -1; // key ���� -1�� ��
		left = null;
		right = null;
		// left, right ����Ʈ���� null�� �ʱ�ȭ
		
	}
	public BinaryTree(int key) {
		// ���ڰ� �� ���� ������
		this(); // ���ڰ� ���� ������ ȣ��
		this.key = key; // �Է¹��� key ���� root�� �ϴ� �ܵ� Ʈ�� ����
	}
	public BinaryTree(int key, BinaryTree left, BinaryTree right) {
		// ���ڰ� �� ���� ������
		this(key); // �Է¹��� key ���� root�� �ϴ� �ܵ� Ʈ���� �����ϰ�
		this.left = left; // �̰��� ���� ����Ʈ���� �Է¹��� left��
		this.right = right; // �̰��� ������ ����Ʈ���� �Է¹��� right�� ��
	}
	
	public void insert(int x) {
		if(this.key == -1) {
			this.key = x;
		} // �� ó�� ������ ����� ��ġ�� ���ٸ� �� ���� x�� �ٲ���.
		if(this.key > x) {
			// �����ϰ��� �ϴ� x�� ���� ���� ����� key ������ �۴ٸ�, ���ʿ� ����
			if(this.left == null) {
				// ���� ����� left�� ����ִٸ�
				left = new BinaryTree(x);
				// ���� ����� left�� x�� key�� ������ Ʈ�� ����
				return; // �Լ� ����
			} else {
				// ���� null�� �ƴ϶��
				left.insert(x); // �������� �������� ����� ȣ��
				
			}
		} else if(this.key < x) {
			// �����ϰ��� �ϴ� x�� ���� ���� ����� key ������ ũ�ٸ�, �����ʿ� ����
			if(this.right == null) {
				// ���� ����� right�� ����ִٸ�
				right = new BinaryTree(x);
				// ���� ����� right�� x�� key�� ������ Ʈ�� ����
				return; // �Լ� ����
			} else {
				// ���� null�� �ƴ϶��
				right.insert(x); // ���������� �������� ����� ȣ��
			}
		}
		if(this.key == x) {
			// ���� ����� key ���� �����ϰ��� �ϴ� x�� ���� ���ٸ�
			return; // ������ ���� �ʰ� �Լ� ����
		}
	}
	public void postorder() {
		// ���� ��ȸ
		if(this.left != null) {
			// ������ null�� �ƴϸ�
			left.postorder(); // �������� �������� ����� ȣ��
		}
		if(this.right != null) {
			// �������� null�� �ƴϸ�
			right.postorder(); // ���������� �������� ����� ȣ��
		}
		System.out.println("Key "+this.key+"�� �湮�߽��ϴ�.");
		// ������ ���� �˻��߱� ������ �� ���� ���� ������ key ���� ���
	}
	public int height() {
		int h=0; // ���̸� ������ �� ���� h
		
		if(this.left == null && this.right == null){
			return 0;
			// left�� right�� null�̸� ���� 0�� ������ - leaf��� ����
		}
		else {
			if(this.left !=null) {
				// ���� ����Ʈ���� null�� �ƴϸ�
				h = left.height();
				// left�� height�� h�� ������
			}
			if(this.right != null) {
				// ������ ����Ʈ���� null�� �ƴϸ�
				h = (right.height() > h) ? right.height() : h;
				/* right�� height�� h�� ���Ͽ�
				 * (��, left�� height�� ���Ͽ�)
				 * �� ū ���� h�� ��.
				 */
			}
			return h + 1;
			// �� ū ��(h)�� +1�� �� ���� ���� ��带 root�� �ϴ� Ʈ���� ����
		}
	}
}
