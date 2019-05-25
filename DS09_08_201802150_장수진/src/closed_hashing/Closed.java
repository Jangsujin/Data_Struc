package closed_hashing;

public class Closed {
	private Entry[] entry; // 객체를 넣을 테이블
	private float loadFactor; // 적재율
	private int size; // 테이블 사용량
	
	public Closed() {
		// 생성자
		entry = new Entry[101]; // 초기 테이블 크기 101
		loadFactor = 0.75F; // loadFactor는 실수 0.75
	}
	
	public String get(String key) {
		// key값을 넣으면 value를 반환하는 메소드 get
		int h = hash(key); // key값을 해시함수에 넣어 정수를 반환받음
		for(Entry e = entry[h];e!=null;e=e.next) {
			// entry[h]의 처음부터 끝까지 반복
			if(e.key.equals(key)) {
				return e.value;
				// 만약 e의 key값과 같은 key값이라면 e.value를 리턴
			}
		}
		return null; // 만약 못찾았을 경우 이 테이블에 없는 것이므로 null 리턴
	}
	
	public void put(String key, String value) {
		// key값과 value값을 넣으면 entry에 그 객체를 삽입하는 메소드 put 
		int h = hash(key); // key값을 해시함수에 넣어 정수를 반환받음
		if(size>loadFactor*entry.length) {
			// used가 적재율보다 크면
			rehash(); // 재해싱함
		}
		for(Entry e = entry[h];e!=null; e = e.next) {
			// entry[h]의 처음부터 끝까지 반복
			if(e.key.equals(key)) {
				// e의 key값과 같은 key값이라면
				e.value += ", " + value;
				// value 누적
				return; // 더 이상 할 것이 없으므로 put메소드 끝냄
			}
		}
		entry[h] = new Entry(key, value, entry[h]);
		// 여기에 온 것이라면 처음 들어오는 key이므로 앞에 삽입
		size++; // 삽입을 한 것이라면 size를 1증가
	}
	private void rehash() {
		// 삽입하고자 하는 객체의 수가 적재율을 넘었을 경우 실행하는 메소드 rehash
		Entry [] oldEntry = entry; // 원래 테이블 entry를 oldEntry로 하고,
		entry = new Entry[oldEntry.length*2 +1]; // entry의 크기를 증가
		for(int i=0;i<oldEntry.length;i++) {
			// oldEntry의 크기만큼 반복
			for(Entry old = oldEntry[i]; old!=null;) {
				// oldEntry에 마지막까지 반복
				Entry e = old; // entry e를 old로 하고
				old = old.next; // old는 한 칸 앞으로 전진함. oldEntry[i]가 진행하는 경로를 기억하고자 하는 것
				int h = hash(e.key); // e의 key를 해시함수에 넣어 정수를 반환받음
				e.next = entry[h];
				entry[h] = e;
				// 크기를 늘린 테이블에서 앞에 삽입
			}
		}
	}
	
	private int hash(String key) {
		return (key.hashCode()&0x7FFFFFFF)%entry.length;
		// 해시함수
	}
}