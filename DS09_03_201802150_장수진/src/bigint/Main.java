package bigint;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInt x = new BigInt(13579); // ������ BigInt ����, x
		BigInt y = new BigInt("75313579"); // string���� BigInt ����, y 
		System.out.println(x); // x�� ���� ���
		System.out.println(x.compareMe(y)); // x�� y ��
		System.out.println(x.multiple(4)); // x�� 4 ���ϱ�
	}
}
