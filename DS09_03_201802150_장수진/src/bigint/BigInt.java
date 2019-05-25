package bigint;

public class BigInt {
	int size; // BigInt의 size를 저장하기 위한 변수
	private Node start; // 처음 노드를 저장하는 노드 start 변수 만듦
	
	class Node {
		private int digit; // 입력받은 digit를 저장하기 위한 변수
		private Node next; // 다음 노드의 주소를 저장하기 위한 변수
		Node(int digit){
			this.digit = digit;
			// 노드의 생성자. 입력받은 digit를 이 노드의 digit로 한다.
		}
	}
	private int digit(String s, int i) {
		// 문자열로 입력받았을 때 1자리씩 잘라 사용하기 위한 메소드
		String ss = s.substring(i, i+1); // i부터 i+1전까지 잘라 ss로 한다.
		return Integer.parseInt(ss); // ss를 정수화시켜서 리턴
	}
	
	 
	public BigInt(int n) {
		// int로 입력받아서 BigInt를 만드는 생성자
		if(n<0) throw new IllegalArgumentException(n+"<0"); // n이 0보다 작으면 예외
		start = new Node(n%10); // 입력받은 n을 10으로 나눈 나머지를 digit으로 갖는 노드를 만들어 start가 가리키게 한다.
		Node p = start; // 노드 p 변수를 만들어 start가 참조하도록 한다.
		n /= 10; // n을 10으로 나눈 몫을 n에 다시 넣는다.
		size = 1; // 한 개의 노드를 만들었기 때문에 size를 1로 함.
		while(n>0) {
			// n이 0보다 클 때까지 반복
			p = p.next = new Node(n%10); // p.next에 n을 10으로 나눈 나머지를 digit으로 가지는 노드를 만들고, p를 한 칸 전진시킨다.
			n /= 10; // n을 10으로 나눈 몫을 n에 넣는다.
			size++; // 노드를 한 개 만들었으므로 size를 1 늘린다.
		}
	}
	public BigInt(String s) {
		// string으로 입력받아서 BigInt를 만드는 생성자
		size = s.length(); // size는 입력받은 s의 길이이므로 s의 길이를 size로 한다.
		if(s.length()==0) {
			throw new IllegalArgumentException("empty string"); // s의 길이가 0이면 예외
		}
		start = new Node(digit(s, s.length()-1)); // 입력받은 string의 마지막 문자를 digit으로 갖는 노드를 만들어 start가 가리키게 한다.
		Node p = start; // 노드 p 변수를 만들어 start가 참조하도록 한다.
		for(int i = s.length()-2;i>=0;i--) {
			p = p.next = new Node(digit(s,i));
			/*
			 * 입력받은 string의 문자를 뒤의 것을 한 개 자르고, 그 정수로 노드를 만든다.
			 * 그 후 p를 한 칸 전진시킨다.
			 * 그 다음 i를 하나 줄여 왼쪽으로 이동하여 한 개 자른다. - 반복
			 */
			 
		
		}
	}
	public int compareMe(BigInt y) {
		// 두 BigInt를 비교하는 compareMe 메소드
		Node p = start; // 노드 p 변수를 만들어 start를 가리키게 한다.
		Node q = y.start; // 노드 q 변수를 만들어 y의 start를 가리키게 한다.

		if(size != y.size ) return size > y.size ? 1:-1;
		/*
		 * 메소드를 부르는 BigInt의 size와 매개변수로  넘어온 BigInt의 size가 같지 않다면
		 * 삼항연산자를 통해 size를 비교하고 메소드를 부른 BigInt의 size가 더 크면 1을 리턴, 그 반대면 -1을 리턴한다.
		 */
		else {
			// 만약 둘의 size가 같다면 값을 직접 비교해야 하므로 p와 q를 이동시키며 값을 비교한다.
			while(size!=0) {
				// size가 0이 아닐 때까지 반복
				p = start; // p가 start를 가리키게 한다.
				q = y.start; // q가 start를 가리키게 한다.
				for(int i=0;i<size-1;i++) {
					p=p.next;
					q=q.next;
					// size-1번 반복하여 p와 q가 자신의 BigInt의 마지막 노드를 가리키도록 한다. 
				}
				if(p.digit!=q.digit) return p.digit>q.digit ? 1:-1;
				// p와 q의 digit가 다르다면 삼항연산자를 이용하여 비교하는데, p의 digit이 q의 digit보다 크면 1을 리턴, 그 반대면 -1을 리턴한다.
				size--; // 위의 경우가 아니라면 같다는 것이므로 그 다음 자리를 비교해야 하므로 size를 1줄여 다시 반복한다.
			}
		}
		return 0; // 위의 경우에 걸리지 않는다면, 두 BigInt가 같다는 것이므로 0을 출력한다.
	}
		
	public BigInt multiple(int k) {
		// BigInt를 k배 하는 multiple 메소드
		System.out.println("multiple("+k+") 호출");
		// multiple 메소드를 호출했다는 안내문 출력
		Node p = start; // 노드 p 변수를 만들어 start를 가리키게 한다.
		BigInt mul = new BigInt((p.digit*k)%10);
		/*
		 *  BigInt mul을 만든다.
		 *  p.digit에 k를 곱하고, 10으로 나눈 나머지를 첫 노드의 digit으로 갖는다.
		 */
		Node q = mul.start; // 노드 q는 BigInt mul의 start를 가리킨다.
		int carry = (p.digit*k)/10; // carry는 자리올림수. p.digit에 k를 곱한 것을 10으로 나눈 몫을 저장한다. 
		p=p.next; // p를 한 칸 전진시킨다.
		while(p !=null) {
			// p가 null이 아닐때까지 반복
			q.next = new Node((p.digit*k+carry)%10);
			// p.digit에 k를 곱한 것과 carry를 더한 것을 10으로 나눈 나머지를 digit으로 갖는 노드를 생성하여 q.next가 가리키도록 한다.
			carry = (p.digit*k+carry)/10; // carry를 다시 계산한다.
			p = p.next; // p를 한 칸 전진시킨다.
			q = q.next; // q를 한 칸 전진시킨다.
		}
		if(p==null&&carry>0) {
			q.next = new Node(carry);
			/*
			 * 만약 p가 null인데 carry가 0보다 커서 q의 노드가 한 개 더 필요한 경우
			 * carry를 digit으로 갖는 노드를 하나 더 생성해 q.next가 가리키도록 한다.
			 */
		}
		return mul; // BigInt mul을 리턴해준다.
	}
	
	public String toString() {
		// BigInt 객체를 출력하기 위한 toString 메소드를 재정의한다.
		Node p = start;
		String s = ""; // 문자열을 저장할 변수 s를 만든다.
		for(p=start;p!=null;p=p.next) {
			s = Integer.toString(p.digit)+s;
			// 일의 자리수부터 연결되어 있으므로 뒤의 노드를 앞에 접합시키며 문자열 s를 만든다. 
		}
		return "현재 저장된 숫자 : "+s; // BigInt의 값을 출력한다.
	}
}