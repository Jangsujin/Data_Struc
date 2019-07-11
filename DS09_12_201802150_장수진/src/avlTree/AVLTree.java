package avlTree;

public class AVLTree {
	private int key, height; // 데이터인 key, 트리의 높이 height 변수
	private AVLTree left, right; // 왼쪽과 오른쪽 서브트리를 나타내는 AVLTree형 변수 left, right
	public static final AVLTree NIL = new AVLTree(); // 공백트리인 AVLTree NIL
	
	public AVLTree(int key) {
		// 단독트리 생성자
		this.key = key; // key값은 입력받은 key
		left = right= NIL; // left와 right를 NIL로 해줌 (단독트리는 서브트리가 공백)
	}
	public AVLTree() {
		// 공백트리 생성자
		left=right=this; // left와 right를 모두 공백트리로 해줌
		height = -1; // 높이는 -1 (단독트리의 경우 높이가 0이기 때문)
	}
	public AVLTree(int key, AVLTree left, AVLTree right) {
		// key값과 왼쪽, 오른쪽 서브트리를 다 갖는 생성자 
		this.key = key; // key값은 입력받은 key
		this.left = left; // 왼쪽 서브트리는 입력받은 left
		this.right = right; // 오른쪽 서브트리는 입력받은 right
		height = 1 + Math.max(left.height, right.height);
		// 높이는 왼쪽과 오른쪽 서브트리 중 더 높은 트리에 1을 더한 값
	}
	
	public String toString() {
		// AVLTree 출력메소드 재정의
		if(this==NIL) return ""; // NIL인 경우에는 아무것도 출력하지 않음
		return left+" "+ key +" "+right; // 왼쪽 key 오른쪽 순으로 출력하도록 하여 중위순회하듯 출력
	}
	
	public AVLTree grow(int key) {
		// 트리에 추가
		if(this == NIL) {
			// 만약 공백트리였다면
			return new AVLTree(key); // 단독트리를 생성하여 반환 (덧붙여질 것)
		}
		if(key == this.key) return this; // 만약 현재 노드의 키 값과 추가하고자 하는 키 값이 같을 경우 자신 반환
		if(key < this.key) {
			// 현재 노드의 키 값보다 추가하고자 하는 키 값이 작을 경우 왼쪽에 추가해야 하므로
			left = left.grow(key); // 왼쪽 서브트리에서 grow 메소드를 다시 호출해주고, 이를 left가 받도록 함. (수정된 트리가 다시 받아질 수 있도록 함)
		}
		else {
			// 현재 노드의 키 값보다 추가하고자 하는  키 값이 클 경우 오른쪽에 추가해야 하므로
			right = right.grow(key); // 오른쪽 서브트리에서 grow 메소드를 다시 호출해주고, 이를 right가 받도록 함. (수정된 트리가 다시 받아질 수 있도록 함)
		}
		rebalance(); // rebalance 메소드를 호출하여 균형이 무너졌는 지 확인
		height = 1 + Math.max(left.height, right.height); // 높이를 수정함 (양쪽 비교 후 더 높은 서브트리의 높이에 1 추가)
		return this; // 자신을 반환함. (수정된 트리를 다시 받을 수 있도록 하기 위함)
	}
	
	public AVLTree remove(int key) {
		// 트리에서 제거
		AVLTree root = this;
		if(root == NIL) return root;
		if(root.key == key) {
			// 얘를 삭제해야 함.
			if((root.left == NIL) || (root.right == NIL)) {
				// 자식을 하나 갖고 있거나 둘 갖고 있거나
				if(root.left != NIL) {
					// 왼쪽 자식 하나
					root.key = root.left.key; // 현재 노드의 키를 왼쪽 자식의 키로 하고
					root.left = root.left.left; // 현재 노드의 왼쪽 서브트리를 왼쪽 자식의 왼쪽 서브트리로 하고
					root.right = root.left.right; // 현재 노드의 오른쪽 서브트리를 왼쪽 자식의 오른쪽 서브트리로 함
					// -> 현재 노드의 왼쪽 서브트리를 자신의 위치로 그대로 올림
				} else if(root.right !=NIL) {
					// 오른쪽 자식 하나
					root.key = root.right.key; // 현재 노드의 키를 오른쪽 자식의 키로 하고
					root.left = root.right.left; // 현재 노드의 왼쪽 서브트리를 오른쪽 자식의 왼쪽 서브트리로 하고
					root.right = root.right.right; // 현재 노드의 오른쪽 서브트리를 오른쪽 자식의 오른쪽 서브트리로 함
					// -> 현재 노드의 오른쪽 서브트리를 자신의 위치로 그대로 올림
				}
				else {
					// 자식이 없음
					root = NIL; // root를 NIL로 하여 별도의 처리 없이 삭제 가능
				}
			}
			else {
				// 양쪽 자식이 다 있음
				AVLTree temp = minimum(root.right); // root의 right의 최솟값을 반환받아 temp에 저장
				root.key = temp.key; // root의 key를 temp의 key로 바꿈
				root.right = root.right.remove(temp.key); // root의 right에서 temp를 삭제한 후, 그것을 root의 right에 연결시켜줌.
				// (지워서 수정된 트리를 연결시켜줘야하므로 root.right가 수정된 트리를 받도록 해줘야 함.)
				
			}
		}
		if(key < root.key) {
			// key가 root의 key보다 작을 경우
			root.left = root.left.remove(key); // 왼쪽 서브트리에서 remove를 다시 호출한 후, 그것을 root의 left에 연결시켜줌.
		}
		else {
			// key가 root의 key보다 클 경우
			root.right = root.right.remove(key); // 오른쪽 서브트리에서 remove를 다시 호출한 후, 그것을 root의 right에 연결시켜줌.
		}
		rebalance(); // rebalance 메소드를 호출하여 균형이 무너졌는 지 확인
		height = 1 + Math.max(left.height, right.height); // 높이를 수정함 (양쪽 비교 후 더 높은 서브트리의 높이에 1 추가)
		return root; // 자신을 반환함. (수정된 트리를 다시 받을 수 있도록 하기 위함)
	}
	
	public AVLTree minimum(AVLTree Node) {
		// 최솟값을 찾는 메소드 - 왼쪽으로 더 이상 이동할 수 없을 때 그 값이 최솟값
		if(Node.left != NIL) {
			// Node의 왼쪽 서브트리가 NIL이 아니라면
			return minimum(Node.left); // Node의 left를 Node로 하여 메소드 다시 호출
		} else {
			// Node의 왼쪽 서브트리가 NIL이라면
			return Node; // 현재 노드가 최솟값이라는 의미이므로 Node를 반환
		}	
	}
	
	private void rebalance() {
		// 균형이 맞는지 맞지 않는지를 확인하고 수정하는 메소드
		if(right.height > left.height+1) {
			// right의 높이가 left의 높이보다 2 이상 크면
			if(right.left.height> right.right.height) {
				// 오른쪽 서브트리의 왼쪽 서브트리 높이가 오른쪽 서브트리의 오른쪽 서브트리 높이보다 크면
				right.rotateRight(); // 오른쪽 서브트리를 루트로 하여 오른쪽 회전을 함
				// -> 복합 오른쪽-왼쪽 회전 (중 오른쪽 회전 먼저)
			}
			rotateLeft();// 왼쪽 회전
		}
		else if(left.height > right.height+1) {
			// left의 높이가 right의 높이보다 2이상 크면
			if(left.right.height > left.left.height) {
				// 왼쪽 서브트리의 오른쪽 서브트리 높이가 왼쪽 서브트리의 왼쪽 서브트리 높이보다 크면
				left.rotateLeft(); // 왼쪽 서브트리를 루트로 하여 왼쪽 회전을 함
				// -> 복합 왼쪽-오른쪽 회전 (중 왼쪽 회전 먼저)
			}
			rotateRight(); // 오른쪽 회전
		}
	}
	private void rotateLeft() {
		// 왼쪽 회전
		left = new AVLTree(key, left, right.left);
		// 왼쪽 서브트리로 사용할 트리를 새로 만들어 연결
		key = right.key; // 키 값을 오른쪽 서브트리의 키 값으로 함
		right = right.right; // 오른쪽 서브트리는 오른쪽 서브트리의 오른쪽 서브트리로 함
	}
	private void rotateRight() {
		// 오른쪽 회전
		right = new AVLTree(key, left.right, right);
		// 오른쪽 서브트리로 사용할 트리를 새로 만들어 연결
		key = left.key; // 키 값을 왼쪽 서브트리의 키 값으로 함
		left = left.left; // 왼족 서브트리는 왼쪽 서브트리의 왼쪽 서브트리로 함
	}
}