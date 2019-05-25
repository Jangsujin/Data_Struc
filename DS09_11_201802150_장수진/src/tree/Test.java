package tree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree1 = new BinaryTree(); // 트리1을 생성
		binaryTree1.insert(1); // 1 삽입
		binaryTree1.insert(3); // 3 삽입
		binaryTree1.insert(5); // 5 삽입
		binaryTree1.insert(7); // 7 삽입
		binaryTree1.insert(9); // 9 삽입
		
		binaryTree1.postorder(); // 트리1 후위순회
		System.out.println("트리의 높이는 "+binaryTree1.height()); // 트리1 높이 출력
		System.out.println("");
		
		BinaryTree binaryTree2 = new BinaryTree(); // 트리2를 생성
		binaryTree2.insert(77); // 77 삽입
		binaryTree2.insert(44); // 44 삽입
		binaryTree2.insert(55); // 55 삽입
		binaryTree2.insert(99); // 99 삽입
		binaryTree2.insert(33); // 33 삽입
		binaryTree2.insert(66); // 66 삽입
		binaryTree2.insert(88); // 88 삽입
		binaryTree2.insert(22); // 22 삽입
		
		binaryTree2.postorder(); // 트리2 후위순회
		System.out.println("트리의 높이는 "+binaryTree2.height()); // 트리2 높이 출력
	}
}