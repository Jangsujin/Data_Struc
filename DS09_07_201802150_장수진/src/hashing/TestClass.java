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
		// ������ �������� ���� ��ü ����
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("./text.txt"));
			// text ������ �ҷ���
			while(br.ready()) {
				String line = br.readLine(); // line���� ����
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // ������ ��ħǥ��� ������ ����
				while(parser.hasMoreTokens()) {
					// ��ū�� �����ִٸ�
					String x = parser.nextToken(); // �� ��ū�� String x�� �ϰ�
					lin.put(x);
					quad.put(x);
					doub.put(x);
					// ������ �ؽ����̺�� ��ū�� ����
					
				}
			}
			br.close(); // �� ������ ������ �ݾ���
		} catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("***** �� ���̺��� ���� �ܾ���� �� (value) : <America, answer, where, disabled, believed>");
		// ���� �ܾ���� ã�� ��
		System.out.println("America : "+"��������("+lin.get("America")+"), ��������("+quad.get("America")+"), �����ؽ�("+doub.get("America")+")");
		System.out.println("answer : "+"��������("+lin.get("answer")+"), ��������("+quad.get("answer")+"), �����ؽ�("+doub.get("answer")+")");
		System.out.println("where : "+"��������("+lin.get("where")+"), ��������("+quad.get("where")+"), �����ؽ�("+doub.get("where")+")");
		System.out.println("disabled : "+"��������("+lin.get("disabled")+"), ��������("+quad.get("disabled")+"), �����ؽ�("+doub.get("disabled")+")");
		System.out.println("believed : "+"��������("+lin.get("believed")+"), ��������("+quad.get("believed")+"), �����ؽ�("+doub.get("believed")+")");
		// ��������, ��������, �����ؽ��� ���� ������ �ܾ �� �� ���Դ����� �ľ�
		System.out.println("");
		System.out.println("�浹 Ƚ�� : "+"��������("+lin.getCollision()+"), ��������("+quad.getCollision()+"), �����ؽ�("+doub.getCollision()+")");
		// ������ �������� ���� �浹 Ƚ�� ���
	}

}
