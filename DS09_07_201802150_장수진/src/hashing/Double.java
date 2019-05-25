package hashing;

public class Double {
	private Table[] table; // 객체를 넣을 테이블
	private float loadFactor; // 적재율
	private int used; // NIL을 포함한 테이블 사용량
	private int size; // NIL을 제외한 테이블 사용량
	private int collision = 0;
	// 충돌 횟수 - 키와 동일한 것은 value를 늘릴 것이므로 다른 객체나 NIL을 만났을 때 증가
	private final Table NIL = new Table(null, 0);
	// 테이블에 있는 객체가 삭제되었을 때 넣을 객체 NIL
	
	public Double() {
		// 생성자
		table = new Table[11]; // 초기 테이블 크기 11
		loadFactor = 0.75F; // loadFactor는 실수 0.75
	}
	
	public int get(String key) {
		// key값을 넣으면 value를 반환하는 메소드 get
		int h1 = hash1(key); // key값을 해시함수1에 넣어 정수를 반환받음
		int h2 = hash2(key); // key값을 해시함수2에 넣어 정수를 반환받음
		for(int i=0;i<table.length;i++) {
			// table크기 동안 반복
			int g = nextProbe(h1,h2,i); // 이중해싱 방법을 통해 g를 얻음
			if(table[g] == null) {
				// table의 g인덱스 값이 null이라면
				break;
				// 이 테이블에는 key 값이 없는 것임. break하여 for문을 나감
			}
			if(table[g] == NIL) {
				// table의 g인덱스 값이 NIL이라면
				continue; // 이 테이블에 있을지도 모르기 때문에 계속 반복
			}
			if(table[g].key.equals(key)) {
				// table의 g인덱스 값의 key와 찾고자 하는 key의 값이 같다면
				return table[g].value; // 그 인덱스의 value를 리턴
			}
		}
		return 0;
		// for문을 빠져나왔을 때는 이 테이블에 그 key값이 없는 것이므로 0을 반환
	}
	
	public void put(String key) {
		// key값을 넣으면 table에 그 객체를 삽입하는 메소드 put 
		int h1 = hash1(key); // key값을 해시함수1에 넣어 정수를 반환받음
		int h2 = hash2(key); // key값을 해시함수2에 넣어 정수를 반환받음
		if(used>loadFactor*table.length) {
			// used가 적재율보다 크면
			rehash(); // 재해싱함
		}
		for(int i=0;i<table.length;i++) {
			// table크기 동안 반복
			int g = nextProbe(h1,h2,i); // 이중해싱 방법을 통해 g를 얻음
			if(table[g] == null) {
				// table의 g인덱스 값이 null이라면
				table[g] = new Table(key, 1);
				// 이 테이블에는 key를 가진 객체가 없는 것이므로 value가 1인 객체를 하나 생성하고, 그 자리에 넣음
				size++;
				used++;
				// 삽입했으므로 size와 used를 1씩 증가시킴
				break; // 더 이상 할 것이 없으므로 반복문을 빠져나감
			}
			if(table[g] == NIL) {
				// table의 g인덱스 값이 NIL이라면
				collision++; // key값이 아니므로 충돌이 일어난 것이므로 collision을 1증가시키고,
				continue; // key값이 있을지도 모르니까 반복을 진행함
			}
			if(table[g].key.equals(key)) {
				// table의 g인덱스 값의 key와 삽입하고자 하는 key의 값이 같다면
				table[g].value++; // 그 인덱스의 value를 1증가시킴
				break; // 더 이상 할 것이 없으므로 반복문을 빠져나감
			}
			if(!(table[g].key.equals(key))) {
				// table의 g인덱스 값의 key와 삽입하고자 하는 key의 값이 같지 않다면
				collision++; // 충돌이 일어난 것이므로 collision을 1증가시키고,
				continue; // 계속 진행함
			}
		}
	}
	private void rehash() {
		// 삽입하고자 하는 객체의 수가 적재율을 넘었을 경우 실행하는 메소드 rehash
		Table [] oldTable = table; // 원래 테이블 table을 oldTable로 하고,
		table = new Table[table.length*2 +1]; // table의 크기를 증가
		for(int i=0;i<oldTable.length;i++) {
			// oldTable의 크기만큼 반복
			if(oldTable[i]==null || oldTable[i]==NIL) {
				// 만약 i인덱스 객체가 null이거나 NIL이면 
				continue; // table에 삽입하지 않고 계속진행
			}
			int h1 = hash1(oldTable[i].key); // oldTable의 i인덱스의 key값을 해시함수1에 넣어 정수를 반환받음
			int h2 = hash2(oldTable[i].key); // oldTable의 i인덱스의 key값을 해시함수2에 넣어 정수를 반환받음
			
			for(int j=0;j<oldTable.length;j++) {
				// oldTable의 크기만큼 반복
				int g = nextProbe(h1,h2,j); // 이중해싱 방법을 통해 g를 얻음
				if(table[g]==null) {
					// table의 g인덱스의 값이 null이면
					table[g] = oldTable[i]; // oldTable의 i인덱스에 있는 값을 table의 g인덱스에 넣음
					break; // 더 이상 할 것이 없으므로 반복문을 빠져나감
				}
			}
		}
		used = size; // used를 size로 바꿈
	}
	public int getCollision() {
		return collision; // 충돌횟수 반환
	}
	private int hash1(String key) {
		return (key.hashCode()&0x7FFFFFFF)%table.length;
		// 첫 번째 해시함수
	}
	private int hash2(String key) {
		return 1+((key.hashCode()&0x7FFFFFFF)%(table.length-1));
		// 두 번째 해시함수
	}
	private int nextProbe(int h1, int h2, int i) {
		return (h1+i*h2)%table.length;
		// 이중해싱
	}
}