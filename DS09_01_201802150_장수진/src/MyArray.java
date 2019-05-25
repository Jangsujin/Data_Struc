
import java.util.Random;

public class MyArray {
	public MyArray(int size) {
		this.size = size;
		a = new int[size];
		Random rand = new Random();
		for(int i =0;i<size;i++) {
			a[i] = rand.nextInt(20);
		}
	}
	private int[] a;
	private int size;
	
	void removemultiples(int x) {
		System.out.println("배열 a에서 "+x+"의 배수를 모두 제거합니다.");
		
		for(int i=0;i<size-1;i++) {
			if(a[i]%x==0&&a[i]!=0) {
				System.arraycopy(a, i+1, a, i, size-i-1);
				size--;
				i = -1;
			}
		}
		if(a[size-1]%x==0 && a[size-1]!=0) {
			size--;
		}
	}	
	void doublelength() {
		System.out.println("배열 a의 공간을 두 배 확장합니다.");
		int [] b = new int[2*a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		a=b;
	}
	void print() {
		System.out.print("배열의 원소 : ");
		for(int i=0;i<size;i++) {
				System.out.print(a[i]+" ");
		}
		System.out.println(" | 배열의 크기 : "+a.length);	
	}
}

