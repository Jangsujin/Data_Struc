package closed_hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Closed closed = new Closed(); // closed 객체 생성
		int i = 1; // 줄번호를 나타내는 변수 i

		try {
			BufferedReader br = new BufferedReader(new FileReader("./text.txt"));
			// text 파일을 불러옴
			while (br.ready()) {
				String line = br.readLine(); // line으로 읽음
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // 각각의 마침표들로 문장을 끝냄
				while (parser.hasMoreTokens()) {
					// 토큰이 남아있다면
					String x = parser.nextToken(); // 그 토큰을 String x로 하고
					closed.put(x, Integer.toString(i));
					// 토큰을 key로, i를 string으로 바꾼후에 value로 삽입

				}
				i++; // 줄이 바뀌므로 1증가
			}
			br.close(); // 다 읽으면 파일을 닫아줌
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println("America의 value 값 : "+closed.get("America"));
		System.out.println("answer의 value 값 : "+closed.get("answer"));
		System.out.println("where의 value 값 : "+closed.get("where"));
		System.out.println("disabled의 value 값 : "+closed.get("disabled"));
		System.out.println("believed의 value 값 : "+closed.get("believed"));
		System.out.println("we의 value 값 : "+closed.get("we"));
		System.out.println("We의 value 값 : "+closed.get("We"));
		System.out.println("free의 value 값 : "+closed.get("free"));
		// 각각의 단어들에 대해 value 출력
	}
}