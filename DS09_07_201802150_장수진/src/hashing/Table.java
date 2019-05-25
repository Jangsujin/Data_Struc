package hashing;

public class Table {
	String key; // 단어를 저장할 key 필드
	int value; // 단어의 빈도를 저장할 value 필드
	
	public Table(String key, int value) {
		this.key = key;
		this.value = value;
		// 생성자는 key와 value를 입력받음
	}

}
