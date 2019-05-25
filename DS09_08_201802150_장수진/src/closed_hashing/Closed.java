package closed_hashing;

public class Closed {
	private Entry[] entry; // ��ü�� ���� ���̺�
	private float loadFactor; // ������
	private int size; // ���̺� ��뷮
	
	public Closed() {
		// ������
		entry = new Entry[101]; // �ʱ� ���̺� ũ�� 101
		loadFactor = 0.75F; // loadFactor�� �Ǽ� 0.75
	}
	
	public String get(String key) {
		// key���� ������ value�� ��ȯ�ϴ� �޼ҵ� get
		int h = hash(key); // key���� �ؽ��Լ��� �־� ������ ��ȯ����
		for(Entry e = entry[h];e!=null;e=e.next) {
			// entry[h]�� ó������ ������ �ݺ�
			if(e.key.equals(key)) {
				return e.value;
				// ���� e�� key���� ���� key���̶�� e.value�� ����
			}
		}
		return null; // ���� ��ã���� ��� �� ���̺� ���� ���̹Ƿ� null ����
	}
	
	public void put(String key, String value) {
		// key���� value���� ������ entry�� �� ��ü�� �����ϴ� �޼ҵ� put 
		int h = hash(key); // key���� �ؽ��Լ��� �־� ������ ��ȯ����
		if(size>loadFactor*entry.length) {
			// used�� ���������� ũ��
			rehash(); // ���ؽ���
		}
		for(Entry e = entry[h];e!=null; e = e.next) {
			// entry[h]�� ó������ ������ �ݺ�
			if(e.key.equals(key)) {
				// e�� key���� ���� key���̶��
				e.value += ", " + value;
				// value ����
				return; // �� �̻� �� ���� �����Ƿ� put�޼ҵ� ����
			}
		}
		entry[h] = new Entry(key, value, entry[h]);
		// ���⿡ �� ���̶�� ó�� ������ key�̹Ƿ� �տ� ����
		size++; // ������ �� ���̶�� size�� 1����
	}
	private void rehash() {
		// �����ϰ��� �ϴ� ��ü�� ���� �������� �Ѿ��� ��� �����ϴ� �޼ҵ� rehash
		Entry [] oldEntry = entry; // ���� ���̺� entry�� oldEntry�� �ϰ�,
		entry = new Entry[oldEntry.length*2 +1]; // entry�� ũ�⸦ ����
		for(int i=0;i<oldEntry.length;i++) {
			// oldEntry�� ũ�⸸ŭ �ݺ�
			for(Entry old = oldEntry[i]; old!=null;) {
				// oldEntry�� ���������� �ݺ�
				Entry e = old; // entry e�� old�� �ϰ�
				old = old.next; // old�� �� ĭ ������ ������. oldEntry[i]�� �����ϴ� ��θ� ����ϰ��� �ϴ� ��
				int h = hash(e.key); // e�� key�� �ؽ��Լ��� �־� ������ ��ȯ����
				e.next = entry[h];
				entry[h] = e;
				// ũ�⸦ �ø� ���̺��� �տ� ����
			}
		}
	}
	
	private int hash(String key) {
		return (key.hashCode()&0x7FFFFFFF)%entry.length;
		// �ؽ��Լ�
	}
}