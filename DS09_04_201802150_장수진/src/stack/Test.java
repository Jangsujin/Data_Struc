package stack;

public class Test {
	public static void main(String args[]) {
		if(args.length==0) {
			System.out.println("�ƹ� �Է��� �����ϴ�.");
			// ���̰� 0�̸� �迭�� ������ �� �����Ƿ�, �ƹ� �Է��� ���ٴ� �ȳ����� ���� ���� ó��
		} else {
			LinkedStack stack = new LinkedStack(args[0]);
			// ���⸦ ���� �ʱ� ������ args[0]�� �Ű������� �Ѱ���.
		}
	}
}
