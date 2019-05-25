package tree;

public class BinaryTree {
	private int key; // 트리에 담을 정보 key
	private BinaryTree left, right; // 왼쪽, 오른쪽 서브트리
	
	public BinaryTree() {
		// 인자가 없는 생성자. 초기화 시킴
		key = -1; // key 값을 -1로 함
		left = null;
		right = null;
		// left, right 서브트리를 null로 초기화
		
	}
	public BinaryTree(int key) {
		// 인자가 한 개인 생성자
		this(); // 인자가 없는 생성자 호출
		this.key = key; // 입력받은 key 값을 root로 하는 단독 트리 생성
	}
	public BinaryTree(int key, BinaryTree left, BinaryTree right) {
		// 인자가 세 개인 생성자
		this(key); // 입력받은 key 값을 root로 하는 단독 트리를 생성하고
		this.left = left; // 이것의 왼쪽 서브트리를 입력받은 left로
		this.right = right; // 이것의 오른쪽 서브트리를 입력받은 right로 함
	}
	
	public void insert(int x) {
		if(this.key == -1) {
			this.key = x;
		} // 맨 처음 생성된 노드의 위치에 갔다면 그 값을 x로 바꿔줌.
		if(this.key > x) {
			// 삽입하고자 하는 x의 값이 현재 노드의 key 값보다 작다면, 왼쪽에 삽입
			if(this.left == null) {
				// 현재 노드의 left가 비어있다면
				left = new BinaryTree(x);
				// 현재 노드의 left에 x를 key로 가지는 트리 생성
				return; // 함수 종료
			} else {
				// 만약 null이 아니라면
				left.insert(x); // 왼쪽으로 내려가서 재귀적 호출
				
			}
		} else if(this.key < x) {
			// 삽입하고자 하는 x의 값이 현재 노드의 key 값보다 크다면, 오른쪽에 삽입
			if(this.right == null) {
				// 현재 노드의 right가 비어있다면
				right = new BinaryTree(x);
				// 현재 노드의 right에 x를 key로 가지는 트리 생성
				return; // 함수 종료
			} else {
				// 만약 null이 아니라면
				right.insert(x); // 오른쪽으로 내려가서 재귀적 호출
			}
		}
		if(this.key == x) {
			// 현재 노드의 key 값과 삽입하고자 하는 x의 값이 같다면
			return; // 삽입을 하지 않고 함수 종료
		}
	}
	public void postorder() {
		// 후위 순회
		if(this.left != null) {
			// 왼쪽이 null이 아니면
			left.postorder(); // 왼쪽으로 내려가서 재귀적 호출
		}
		if(this.right != null) {
			// 오른쪽이 null이 아니면
			right.postorder(); // 오른쪽으로 내려가서 재귀적 호출
		}
		System.out.println("Key "+this.key+"를 방문했습니다.");
		// 왼쪽을 먼저 검사했기 때문에 맨 밑의 왼쪽 노드부터 key 값을 출력
	}
	public int height() {
		int h=0; // 높이를 저장해 둘 변수 h
		
		if(this.left == null && this.right == null){
			return 0;
			// left와 right가 null이면 높이 0을 리턴함 - leaf노드 도달
		}
		else {
			if(this.left !=null) {
				// 왼쪽 서브트리가 null이 아니면
				h = left.height();
				// left의 height를 h에 저장함
			}
			if(this.right != null) {
				// 오른쪽 서브트리가 null이 아니면
				h = (right.height() > h) ? right.height() : h;
				/* right의 height를 h와 비교하여
				 * (즉, left의 height와 비교하여)
				 * 더 큰 값을 h로 함.
				 */
			}
			return h + 1;
			// 더 큰 쪽(h)에 +1을 한 값이 현재 노드를 root로 하는 트리의 높이
		}
	}
}
