package bigint;

public class BigInt {
	int size; // BigInt�� size�� �����ϱ� ���� ����
	private Node start; // ó�� ��带 �����ϴ� ��� start ���� ����
	
	class Node {
		private int digit; // �Է¹��� digit�� �����ϱ� ���� ����
		private Node next; // ���� ����� �ּҸ� �����ϱ� ���� ����
		Node(int digit){
			this.digit = digit;
			// ����� ������. �Է¹��� digit�� �� ����� digit�� �Ѵ�.
		}
	}
	private int digit(String s, int i) {
		// ���ڿ��� �Է¹޾��� �� 1�ڸ��� �߶� ����ϱ� ���� �޼ҵ�
		String ss = s.substring(i, i+1); // i���� i+1������ �߶� ss�� �Ѵ�.
		return Integer.parseInt(ss); // ss�� ����ȭ���Ѽ� ����
	}
	
	 
	public BigInt(int n) {
		// int�� �Է¹޾Ƽ� BigInt�� ����� ������
		if(n<0) throw new IllegalArgumentException(n+"<0"); // n�� 0���� ������ ����
		start = new Node(n%10); // �Է¹��� n�� 10���� ���� �������� digit���� ���� ��带 ����� start�� ����Ű�� �Ѵ�.
		Node p = start; // ��� p ������ ����� start�� �����ϵ��� �Ѵ�.
		n /= 10; // n�� 10���� ���� ���� n�� �ٽ� �ִ´�.
		size = 1; // �� ���� ��带 ������� ������ size�� 1�� ��.
		while(n>0) {
			// n�� 0���� Ŭ ������ �ݺ�
			p = p.next = new Node(n%10); // p.next�� n�� 10���� ���� �������� digit���� ������ ��带 �����, p�� �� ĭ ������Ų��.
			n /= 10; // n�� 10���� ���� ���� n�� �ִ´�.
			size++; // ��带 �� �� ��������Ƿ� size�� 1 �ø���.
		}
	}
	public BigInt(String s) {
		// string���� �Է¹޾Ƽ� BigInt�� ����� ������
		size = s.length(); // size�� �Է¹��� s�� �����̹Ƿ� s�� ���̸� size�� �Ѵ�.
		if(s.length()==0) {
			throw new IllegalArgumentException("empty string"); // s�� ���̰� 0�̸� ����
		}
		start = new Node(digit(s, s.length()-1)); // �Է¹��� string�� ������ ���ڸ� digit���� ���� ��带 ����� start�� ����Ű�� �Ѵ�.
		Node p = start; // ��� p ������ ����� start�� �����ϵ��� �Ѵ�.
		for(int i = s.length()-2;i>=0;i--) {
			p = p.next = new Node(digit(s,i));
			/*
			 * �Է¹��� string�� ���ڸ� ���� ���� �� �� �ڸ���, �� ������ ��带 �����.
			 * �� �� p�� �� ĭ ������Ų��.
			 * �� ���� i�� �ϳ� �ٿ� �������� �̵��Ͽ� �� �� �ڸ���. - �ݺ�
			 */
			 
		
		}
	}
	public int compareMe(BigInt y) {
		// �� BigInt�� ���ϴ� compareMe �޼ҵ�
		Node p = start; // ��� p ������ ����� start�� ����Ű�� �Ѵ�.
		Node q = y.start; // ��� q ������ ����� y�� start�� ����Ű�� �Ѵ�.

		if(size != y.size ) return size > y.size ? 1:-1;
		/*
		 * �޼ҵ带 �θ��� BigInt�� size�� �Ű�������  �Ѿ�� BigInt�� size�� ���� �ʴٸ�
		 * ���׿����ڸ� ���� size�� ���ϰ� �޼ҵ带 �θ� BigInt�� size�� �� ũ�� 1�� ����, �� �ݴ�� -1�� �����Ѵ�.
		 */
		else {
			// ���� ���� size�� ���ٸ� ���� ���� ���ؾ� �ϹǷ� p�� q�� �̵���Ű�� ���� ���Ѵ�.
			while(size!=0) {
				// size�� 0�� �ƴ� ������ �ݺ�
				p = start; // p�� start�� ����Ű�� �Ѵ�.
				q = y.start; // q�� start�� ����Ű�� �Ѵ�.
				for(int i=0;i<size-1;i++) {
					p=p.next;
					q=q.next;
					// size-1�� �ݺ��Ͽ� p�� q�� �ڽ��� BigInt�� ������ ��带 ����Ű���� �Ѵ�. 
				}
				if(p.digit!=q.digit) return p.digit>q.digit ? 1:-1;
				// p�� q�� digit�� �ٸ��ٸ� ���׿����ڸ� �̿��Ͽ� ���ϴµ�, p�� digit�� q�� digit���� ũ�� 1�� ����, �� �ݴ�� -1�� �����Ѵ�.
				size--; // ���� ��찡 �ƴ϶�� ���ٴ� ���̹Ƿ� �� ���� �ڸ��� ���ؾ� �ϹǷ� size�� 1�ٿ� �ٽ� �ݺ��Ѵ�.
			}
		}
		return 0; // ���� ��쿡 �ɸ��� �ʴ´ٸ�, �� BigInt�� ���ٴ� ���̹Ƿ� 0�� ����Ѵ�.
	}
		
	public BigInt multiple(int k) {
		// BigInt�� k�� �ϴ� multiple �޼ҵ�
		System.out.println("multiple("+k+") ȣ��");
		// multiple �޼ҵ带 ȣ���ߴٴ� �ȳ��� ���
		Node p = start; // ��� p ������ ����� start�� ����Ű�� �Ѵ�.
		BigInt mul = new BigInt((p.digit*k)%10);
		/*
		 *  BigInt mul�� �����.
		 *  p.digit�� k�� ���ϰ�, 10���� ���� �������� ù ����� digit���� ���´�.
		 */
		Node q = mul.start; // ��� q�� BigInt mul�� start�� ����Ų��.
		int carry = (p.digit*k)/10; // carry�� �ڸ��ø���. p.digit�� k�� ���� ���� 10���� ���� ���� �����Ѵ�. 
		p=p.next; // p�� �� ĭ ������Ų��.
		while(p !=null) {
			// p�� null�� �ƴҶ����� �ݺ�
			q.next = new Node((p.digit*k+carry)%10);
			// p.digit�� k�� ���� �Ͱ� carry�� ���� ���� 10���� ���� �������� digit���� ���� ��带 �����Ͽ� q.next�� ����Ű���� �Ѵ�.
			carry = (p.digit*k+carry)/10; // carry�� �ٽ� ����Ѵ�.
			p = p.next; // p�� �� ĭ ������Ų��.
			q = q.next; // q�� �� ĭ ������Ų��.
		}
		if(p==null&&carry>0) {
			q.next = new Node(carry);
			/*
			 * ���� p�� null�ε� carry�� 0���� Ŀ�� q�� ��尡 �� �� �� �ʿ��� ���
			 * carry�� digit���� ���� ��带 �ϳ� �� ������ q.next�� ����Ű���� �Ѵ�.
			 */
		}
		return mul; // BigInt mul�� �������ش�.
	}
	
	public String toString() {
		// BigInt ��ü�� ����ϱ� ���� toString �޼ҵ带 �������Ѵ�.
		Node p = start;
		String s = ""; // ���ڿ��� ������ ���� s�� �����.
		for(p=start;p!=null;p=p.next) {
			s = Integer.toString(p.digit)+s;
			// ���� �ڸ������� ����Ǿ� �����Ƿ� ���� ��带 �տ� ���ս�Ű�� ���ڿ� s�� �����. 
		}
		return "���� ����� ���� : "+s; // BigInt�� ���� ����Ѵ�.
	}
}