package binary;

public class Binary {
	// Binary Ŭ����
	static String Func(int bi){ // �������� �������� �ٲٴ� �޼ҵ� Func
		if(bi==1) {
			// bi�� 1�̸� ���ڿ� 1�� ��ȯ
			return "1";
		}
		else {
			// ���� Ż���� ���� �ƴ� ���
			return Func(bi/2) + ((bi%2)==0 ? "0" : "1");
			/*
			 * �������� 2�� ���� �������� �������� ��ġ�� ���� �������̱� ������,
			 * �������� �α� ���� Func()�� bi�� 2�� ���� ���� �Ķ���ͷ� �ѱ� �Լ��� �� (String ��ȯ�̱� ������ +�� ���ս�Ŵ)
			 * bi�� 2�γ��� �������� 0�̶�� ���ڿ� 0��, 1�̶�� ���ڿ� 1�� ���ս�Ŵ
			 */
		}
	}
	static int Func2(int i, int count) {
		// ���� 1�� ������ 2�� ���� Ƚ���� ����ϴ� �޼ҵ� Func2 
		if(i==1) {
			// ���� 1�̶�� Ƚ���� ������Ų count�� ��ȯ
			return count;
		}
		else {
			// ���� Ż���� ���� �ƴ� ���
			return Func2(i/2, count+1);
			// i�� 2�� ���� ���� ��� �������� �α� ���� ù ��° �Ķ���ͷ� �ѱ��, �� �� ���������Ƿ� count�� 1 ������Ŵ
		}
	}
	
	public static void main(String args[]) {
		System.out.println(Func(20));
		// 17�� �������� �ٲپ� ���
		System.out.println(Func2(20,0));
		// 17�� 2�� ���� Ƚ���� ���
	}
}