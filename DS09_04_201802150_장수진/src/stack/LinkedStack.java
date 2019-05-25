package stack;

public class LinkedStack {
	
	class Node{
		// 노드 클래스
		int op; // 인덱스를 저장할 int형 op변수
		Node next; // 다음 노드의 주소를 저장할 Node형 next변수
		Node(int op){
			this.op = op;
			// 생성자
		}
	}
	Node top; // Node형으로 top 저장할 변수
	int size=0; // stack에 쌓인 인덱스의 개수를 저장할 size 변수
	
	void push(int op){
		// stack에 쌓을 push 메소드 
		if(top==null) {
			top = new Node(op); // top이 비어있다면 거기에 연결
			size++; // stack에 한 개 쌓였으므로 size 1 늘림
		}
		else {
			Node temp = new Node(op); // temp에 새로 노드 생성
			temp.next = top; // top의 주소를 temp의 next에 저장
			top = temp; // top이 temp를 가리키도록 함
			size++; // stack에 한 개 쌓였으므로 size 1 늘림
		}
	}
	int pop() {
		// stack에서 뺄 pop 메소드
		int temp = top.op; // temp에 top에 있는 index 저장
		
		top = top.next; // top이 top의 다음 노드를 가리키게 함.
		size--; // stack에서 한 개를 뺐으므로 size 1 줄임
		return temp; // temp를 리턴함
	}
	boolean isEmpty() {
		if(top==null) { // top이 null이면 비어있는 것이므로
			return true; // true 리턴
		}
		return false; // 아닐경우 false 리턴
	}
	
	public LinkedStack(String args){
		// string args를 매개변수로 넘겨받는 생성자 
		String[] expression = new String[args.length()];
		// expression 배열을 args의 길이만큼 공간을 할당한다.
			
		for(int i=0;i<args.length();i++) {
			expression[i] = args.charAt(i)+"";
			// 문자열 args를 문자들로 나누고, string으로 바꾸어 배열 expression에 저장
		}
		for(int i=0;i<expression.length;i++) {
			if(expression[i].equals("(")) {
				// expression에 "("가 있으면 
				push(i); // "("의 인덱스를 push 한다.
			}
			if(expression[i].equals(")")) {
				// expression에 ")"가 있으면
				if(!isEmpty()) {
					System.out.println(pop()+","+i);
					// stack이 비어있지 않을 때 가장 가까운"("의 인덱스를 pop하고, "("과 ")"의 인덱스를 출력한다.
				}
				else {
					System.out.println("괄호쓰기가 맞지 않음");
					// 만약 stack이 비어있다면 짝이 맞지 않으므로 틀렸다는 안내문을 출력
					return ; // 끝낸다.
				}
			}
		}
		if(isEmpty()) {
			// 반복문을 다 돌고 나왔을 때, stack이 비어있다면 괄호쓰기가 맞는 것이므로
			System.out.println("괄호쓰기가 맞음"); // 맞았다는 안내문을 출력한다.
		}
		else {
			System.out.println("괄호쓰기가 맞지 않음"); // 그렇지 않으면 틀렸다는 안내문을 출력한다.
		}	
	}
}