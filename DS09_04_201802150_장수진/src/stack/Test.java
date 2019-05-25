package stack;

public class Test {
	public static void main(String args[]) {
		if(args.length==0) {
			System.out.println("아무 입력이 없습니다.");
			// 길이가 0이면 배열에 접근할 수 없으므로, 아무 입력이 없다는 안내문을 통해 오류 처리
		} else {
			LinkedStack stack = new LinkedStack(args[0]);
			// 띄어쓰기를 하지 않기 때문에 args[0]을 매개변수로 넘겨줌.
		}
	}
}
