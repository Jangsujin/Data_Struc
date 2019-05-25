package binary;

public class Binary {
	// Binary 클래스
	static String Func(int bi){ // 십진수를 이진수로 바꾸는 메소드 Func
		if(bi==1) {
			// bi가 1이면 문자열 1을 반환
			return "1";
		}
		else {
			// 아직 탈출할 때가 아닌 경우
			return Func(bi/2) + ((bi%2)==0 ? "0" : "1");
			/*
			 * 십진수를 2로 나눈 나머지를 역순으로 배치한 것이 이진수이기 때문에,
			 * 역순으로 두기 위해 Func()에 bi를 2로 나눈 값을 파라미터로 넘긴 함수를 둠 (String 반환이기 때문에 +로 접합시킴)
			 * bi를 2로나눈 나머지가 0이라면 문자열 0을, 1이라면 문자열 1을 접합시킴
			 */
		}
	}
	static int Func2(int i, int count) {
		// 몫이 1일 때까지 2로 나눈 횟수를 출력하는 메소드 Func2 
		if(i==1) {
			// 몫이 1이라면 횟수를 누적시킨 count를 반환
			return count;
		}
		else {
			// 아직 탈출할 때가 아닌 경우
			return Func2(i/2, count+1);
			// i를 2로 나눈 값을 계속 피제수로 두기 위해 첫 번째 파라미터로 넘기고, 한 번 나눠졌으므로 count를 1 증가시킴
		}
	}
	
	public static void main(String args[]) {
		System.out.println(Func(20));
		// 17을 이진수로 바꾸어 출력
		System.out.println(Func2(20,0));
		// 17을 2로 나눈 횟수를 출력
	}
}