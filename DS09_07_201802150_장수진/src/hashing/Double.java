package hashing;

public class Double {
	private Table[] table; // ��ü�� ���� ���̺�
	private float loadFactor; // ������
	private int used; // NIL�� ������ ���̺� ��뷮
	private int size; // NIL�� ������ ���̺� ��뷮
	private int collision = 0;
	// �浹 Ƚ�� - Ű�� ������ ���� value�� �ø� ���̹Ƿ� �ٸ� ��ü�� NIL�� ������ �� ����
	private final Table NIL = new Table(null, 0);
	// ���̺� �ִ� ��ü�� �����Ǿ��� �� ���� ��ü NIL
	
	public Double() {
		// ������
		table = new Table[11]; // �ʱ� ���̺� ũ�� 11
		loadFactor = 0.75F; // loadFactor�� �Ǽ� 0.75
	}
	
	public int get(String key) {
		// key���� ������ value�� ��ȯ�ϴ� �޼ҵ� get
		int h1 = hash1(key); // key���� �ؽ��Լ�1�� �־� ������ ��ȯ����
		int h2 = hash2(key); // key���� �ؽ��Լ�2�� �־� ������ ��ȯ����
		for(int i=0;i<table.length;i++) {
			// tableũ�� ���� �ݺ�
			int g = nextProbe(h1,h2,i); // �����ؽ� ����� ���� g�� ����
			if(table[g] == null) {
				// table�� g�ε��� ���� null�̶��
				break;
				// �� ���̺��� key ���� ���� ����. break�Ͽ� for���� ����
			}
			if(table[g] == NIL) {
				// table�� g�ε��� ���� NIL�̶��
				continue; // �� ���̺� �������� �𸣱� ������ ��� �ݺ�
			}
			if(table[g].key.equals(key)) {
				// table�� g�ε��� ���� key�� ã���� �ϴ� key�� ���� ���ٸ�
				return table[g].value; // �� �ε����� value�� ����
			}
		}
		return 0;
		// for���� ���������� ���� �� ���̺� �� key���� ���� ���̹Ƿ� 0�� ��ȯ
	}
	
	public void put(String key) {
		// key���� ������ table�� �� ��ü�� �����ϴ� �޼ҵ� put 
		int h1 = hash1(key); // key���� �ؽ��Լ�1�� �־� ������ ��ȯ����
		int h2 = hash2(key); // key���� �ؽ��Լ�2�� �־� ������ ��ȯ����
		if(used>loadFactor*table.length) {
			// used�� ���������� ũ��
			rehash(); // ���ؽ���
		}
		for(int i=0;i<table.length;i++) {
			// tableũ�� ���� �ݺ�
			int g = nextProbe(h1,h2,i); // �����ؽ� ����� ���� g�� ����
			if(table[g] == null) {
				// table�� g�ε��� ���� null�̶��
				table[g] = new Table(key, 1);
				// �� ���̺��� key�� ���� ��ü�� ���� ���̹Ƿ� value�� 1�� ��ü�� �ϳ� �����ϰ�, �� �ڸ��� ����
				size++;
				used++;
				// ���������Ƿ� size�� used�� 1�� ������Ŵ
				break; // �� �̻� �� ���� �����Ƿ� �ݺ����� ��������
			}
			if(table[g] == NIL) {
				// table�� g�ε��� ���� NIL�̶��
				collision++; // key���� �ƴϹǷ� �浹�� �Ͼ ���̹Ƿ� collision�� 1������Ű��,
				continue; // key���� �������� �𸣴ϱ� �ݺ��� ������
			}
			if(table[g].key.equals(key)) {
				// table�� g�ε��� ���� key�� �����ϰ��� �ϴ� key�� ���� ���ٸ�
				table[g].value++; // �� �ε����� value�� 1������Ŵ
				break; // �� �̻� �� ���� �����Ƿ� �ݺ����� ��������
			}
			if(!(table[g].key.equals(key))) {
				// table�� g�ε��� ���� key�� �����ϰ��� �ϴ� key�� ���� ���� �ʴٸ�
				collision++; // �浹�� �Ͼ ���̹Ƿ� collision�� 1������Ű��,
				continue; // ��� ������
			}
		}
	}
	private void rehash() {
		// �����ϰ��� �ϴ� ��ü�� ���� �������� �Ѿ��� ��� �����ϴ� �޼ҵ� rehash
		Table [] oldTable = table; // ���� ���̺� table�� oldTable�� �ϰ�,
		table = new Table[table.length*2 +1]; // table�� ũ�⸦ ����
		for(int i=0;i<oldTable.length;i++) {
			// oldTable�� ũ�⸸ŭ �ݺ�
			if(oldTable[i]==null || oldTable[i]==NIL) {
				// ���� i�ε��� ��ü�� null�̰ų� NIL�̸� 
				continue; // table�� �������� �ʰ� �������
			}
			int h1 = hash1(oldTable[i].key); // oldTable�� i�ε����� key���� �ؽ��Լ�1�� �־� ������ ��ȯ����
			int h2 = hash2(oldTable[i].key); // oldTable�� i�ε����� key���� �ؽ��Լ�2�� �־� ������ ��ȯ����
			
			for(int j=0;j<oldTable.length;j++) {
				// oldTable�� ũ�⸸ŭ �ݺ�
				int g = nextProbe(h1,h2,j); // �����ؽ� ����� ���� g�� ����
				if(table[g]==null) {
					// table�� g�ε����� ���� null�̸�
					table[g] = oldTable[i]; // oldTable�� i�ε����� �ִ� ���� table�� g�ε����� ����
					break; // �� �̻� �� ���� �����Ƿ� �ݺ����� ��������
				}
			}
		}
		used = size; // used�� size�� �ٲ�
	}
	public int getCollision() {
		return collision; // �浹Ƚ�� ��ȯ
	}
	private int hash1(String key) {
		return (key.hashCode()&0x7FFFFFFF)%table.length;
		// ù ��° �ؽ��Լ�
	}
	private int hash2(String key) {
		return 1+((key.hashCode()&0x7FFFFFFF)%(table.length-1));
		// �� ��° �ؽ��Լ�
	}
	private int nextProbe(int h1, int h2, int i) {
		return (h1+i*h2)%table.length;
		// �����ؽ�
	}
}