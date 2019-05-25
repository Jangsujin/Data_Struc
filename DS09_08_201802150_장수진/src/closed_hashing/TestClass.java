package closed_hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Closed closed = new Closed(); // closed ��ü ����
		int i = 1; // �ٹ�ȣ�� ��Ÿ���� ���� i

		try {
			BufferedReader br = new BufferedReader(new FileReader("./text.txt"));
			// text ������ �ҷ���
			while (br.ready()) {
				String line = br.readLine(); // line���� ����
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // ������ ��ħǥ��� ������ ����
				while (parser.hasMoreTokens()) {
					// ��ū�� �����ִٸ�
					String x = parser.nextToken(); // �� ��ū�� String x�� �ϰ�
					closed.put(x, Integer.toString(i));
					// ��ū�� key��, i�� string���� �ٲ��Ŀ� value�� ����

				}
				i++; // ���� �ٲ�Ƿ� 1����
			}
			br.close(); // �� ������ ������ �ݾ���
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println("America�� value �� : "+closed.get("America"));
		System.out.println("answer�� value �� : "+closed.get("answer"));
		System.out.println("where�� value �� : "+closed.get("where"));
		System.out.println("disabled�� value �� : "+closed.get("disabled"));
		System.out.println("believed�� value �� : "+closed.get("believed"));
		System.out.println("we�� value �� : "+closed.get("we"));
		System.out.println("We�� value �� : "+closed.get("We"));
		System.out.println("free�� value �� : "+closed.get("free"));
		// ������ �ܾ�鿡 ���� value ���
	}
}