package tree;

import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedTree tree_77, tree_44, tree_99, tree_33, tree_55;
		// 자식을 갖는 객체 이름 지정
		
		OrderedTree tree_22 = new OrderedTree(22); // root가 22인 단독 트리 생성
		OrderedTree tree_66 = new OrderedTree(66); // root가 66인 단독 트리 생성
		OrderedTree tree_88 = new OrderedTree(88); // root가 88인 단독 트리 생성
		
		List subtreeOf_33 = new LinkedList(); // root를 33으로 하는 트리의 subtree를 담을 list 객체
		subtreeOf_33.add(tree_22); // subtree list에 root가 22인 트리를 넣음
		tree_33 = new OrderedTree(33, subtreeOf_33);
		// subtree로 subtreeOf_33 list에 담겨있는 트리를 갖고 root가 33인 트리 생성
		
		List subtreeOf_55 = new LinkedList(); // root를 55로 하는 트리의 subtree를 담을 list 객체
		subtreeOf_55.add(tree_66); // subtree list에 root가 66인 트리를 넣음
		tree_55 = new OrderedTree(55, subtreeOf_55);
		// subtree로 subtreeOf_55 list에 담겨있는 트리를 갖고 root가 55인 트리 생성
		
		List subtreeOf_44 = new LinkedList(); // root를 44로 하는 트리의 subtree를 담을 list 객체
		subtreeOf_44.add(tree_33); // subtree list에 root가 33인 트리를 넣음
		subtreeOf_44.add(tree_55); // subtree list에 root가 55인 트리를 넣음
		tree_44 = new OrderedTree(44, subtreeOf_44);
		// subtree로 subtreeOf_44 list에 담겨있는 트리를 갖고 root가 44인 트리 생성
		
		List subtreeOf_99 = new LinkedList(); // root를 99로 하는 트리의 subtree를 담을 list 객체
		subtreeOf_99.add(tree_88); // subtree list에 root가 88인 트리를 넣음
		tree_99 = new OrderedTree(99, subtreeOf_99);
		// subtree로 subtreeOf_99 list에 담겨있는 트리를 갖고 root가 99인 트리 생성
		
		List subtreeOf_77 = new LinkedList(); // root를 77로 하는 트리의 subtree를 담을 list 객체
		subtreeOf_77.add(tree_44); // subtree list에 root가 44인 트리를 넣음
		subtreeOf_77.add(tree_99); // subtree list에 root가 99인 트리를 넣음
		tree_77 = new OrderedTree(77, subtreeOf_77);
		// subtree로 subtreeOf_77 list에 담겨있는 트리를 갖고 root가 77인 트리 생성
		
		System.out.print("레벨 순서 순회 : ");
		tree_77.levelorder(); // 레벨 순서 순회 메소드 호출
	}
}