package hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linear lin = new Linear();
		Quadratic quad = new Quadratic();
		Double doub = new Double();
		// 각각의 조사방법에 대한 객체 생성
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("./text.txt"));
			// text 파일을 불러옴
			while(br.ready()) {
				String line = br.readLine(); // line으로 읽음
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // 각각의 마침표들로 문장을 끝냄
				while(parser.hasMoreTokens()) {
					// 토큰이 남아있다면
					String x = parser.nextToken(); // 그 토큰을 String x로 하고
					lin.put(x);
					quad.put(x);
					doub.put(x);
					// 각각의 해시테이블로 토큰을 삽입
					
				}
			}
			br.close(); // 다 읽으면 파일을 닫아줌
		} catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("***** 각 테이블에서 다음 단어들의 값 (value) : <America, answer, where, disabled, believed>");
		// 위의 단어들을 찾을 것
		System.out.println("America : "+"선형조사("+lin.get("America")+"), 제곱조사("+quad.get("America")+"), 이중해싱("+doub.get("America")+")");
		System.out.println("answer : "+"선형조사("+lin.get("answer")+"), 제곱조사("+quad.get("answer")+"), 이중해싱("+doub.get("answer")+")");
		System.out.println("where : "+"선형조사("+lin.get("where")+"), 제곱조사("+quad.get("where")+"), 이중해싱("+doub.get("where")+")");
		System.out.println("disabled : "+"선형조사("+lin.get("disabled")+"), 제곱조사("+quad.get("disabled")+"), 이중해싱("+doub.get("disabled")+")");
		System.out.println("believed : "+"선형조사("+lin.get("believed")+"), 제곱조사("+quad.get("believed")+"), 이중해싱("+doub.get("believed")+")");
		// 선형조사, 제곱조사, 이중해싱을 통해 각각의 단어가 몇 번 나왔는지를 파악
		System.out.println("");
		System.out.println("충돌 횟수 : "+"선형조사("+lin.getCollision()+"), 제곱조사("+quad.getCollision()+"), 이중해싱("+doub.getCollision()+")");
		// 각각의 조사방법에 대한 충돌 횟수 출력
	}

}
