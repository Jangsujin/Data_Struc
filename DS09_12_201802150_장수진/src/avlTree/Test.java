package avlTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree avl = new AVLTree(14); // 단독 트리 생성
		avl.grow(17);
		avl.grow(11);
		avl.grow(7);
		avl.grow(53);
		avl.grow(4);
		avl.grow(13);
		avl.grow(12);
		avl.grow(8);
		// 트리에 추가
		System.out.println(avl); // avl 트리 출력
		System.out.println("");
		
		avl.remove(53);
		System.out.println("53 제거 : "+avl); // 53 제거 후 출력
		avl.remove(11);
		System.out.println("11 제거 : "+avl); // 11 제거 후 출력
		avl.remove(7);
		System.out.println(" 7 제거 : "+avl); // 7 제거 후 출력
		avl.remove(12);
		System.out.println("12 제거 : "+avl); // 12 제거 후 출력
		avl.remove(14);
		System.out.println("14 제거 : "+avl); // 14 제거 후 출력
		avl.remove(13);
		System.out.println("13 제거 : "+avl); // 13 제거 후 출력
	}
}