package closed_hashing;

public class Entry {
	String key; // �ܾ ������ key �ʵ�
	String value; // �ܾ��� �� ��ȣ�� ������ value �ʵ�
	Entry next; // ���� ��ü�� �ּҸ� ������ ���� next
	
	public Entry(String key, String value, Entry n) {
		this.key = key; // 
		this.value = value;
		this.next = n;
		// �����ڴ� key�� value�� ���� �ּҸ� �Է¹���
	}
}
