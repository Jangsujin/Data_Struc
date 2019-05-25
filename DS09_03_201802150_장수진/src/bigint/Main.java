package bigint;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInt x = new BigInt(13579); // 정수로 BigInt 생성, x
		BigInt y = new BigInt("75313579"); // string으로 BigInt 생성, y 
		System.out.println(x); // x의 값을 출력
		System.out.println(x.compareMe(y)); // x와 y 비교
		System.out.println(x.multiple(4)); // x에 4 곱하기
	}
}
