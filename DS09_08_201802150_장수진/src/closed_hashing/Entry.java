package closed_hashing;

public class Entry {
	String key; // 단어를 저장할 key 필드
	String value; // 단어의 줄 번호를 저장할 value 필드
	Entry next; // 다음 객체의 주소를 저장할 변수 next
	
	public Entry(String key, String value, Entry n) {
		this.key = key; // 
		this.value = value;
		this.next = n;
		// 생성자는 key와 value와 다음 주소를 입력받음
	}
}
