package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OrderedTree {
	private Object root; // 트리의 root
	private List subtrees; // 트리의 subtree - 순서트리이기 때문에 자료구조는 list
	private int size; // 트리의 크기
	
	public OrderedTree() {
		// 공백 트리
	}
	public OrderedTree(Object root) {
		// 단독 트리
		this.root = root; // 트리의 root는 파라미터로 넘겨받은 root로 함
		subtrees = new LinkedList(); // subtrees 객체 만듦
		size = 1; // 단독 트리이기 때문에 크기는 1
	}
	public OrderedTree(Object root, List trees) {
		// root와 subtree로 할 트리가 담긴 list를 매개변수로 받는 생성자
		this(root); // 단독 트리 생성
		for(Iterator it = trees.iterator(); it.hasNext();) {
			// trees를 방문하는데, 더 이상 방문할 수 없을 때까지 반복
			Object object = it.next(); // 리스트에 있는 객체를 object로 받고,
			if(object instanceof OrderedTree) {
				// object의 실제 타입이 OrderedTree일 때 
				OrderedTree tree = (OrderedTree)object;
				// object를 ObjectTree형태로 형변환하고, 이를 tree로 함
				subtrees.add(tree); // tree를 subtrees에 삽입
				size += tree.size(); // size는 tree의 크기를 더한 값
			}
		}
	}
	
	public void levelorder() {
		// 레벨 순서 순회 메소드
		OrderedTree start = this; // 메소드 호출하는 애를 시작으로 함.
		LinkedList<OrderedTree> queue = new LinkedList<>();
		// linkedlist의 자료형을 orderedTree로 하여 queue를 생성
		queue.add(start); // start를 queue에 삽입
		while(queue.peek() != null) {
			// queue에 더 이상 트리가 남아있지 않을 때까지 반복
			for(Iterator it = queue.peek().subtrees.iterator(); it.hasNext();) {
				// 큐의 첫 번째 트리의 subtrees를 방문하는데, 더 이상 방문할 곳이 없을 때까지 반복
				Object object = it.next(); // Object 형태로 객체를 가져와서
				if(object instanceof OrderedTree) {
					// OrderedTree 형태라면
					queue.add((OrderedTree)object);
					// object를 OrderedTree 형태로 형변환하여 queue에 삽입
				}
			}
			System.out.print(queue.poll().root+" ");
			// queue의 맨 앞 OrderedTree를 제거하며 반환하는데, 그 트리의 root를 출력
		}
	}
	
	public int size() {
		return size;
		// 트리의 크기를 반환하는 메소드
	}
}
