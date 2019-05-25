package doublyLinkedQueue;

public class ExponentialRand extends java.util.Random {
private double mean;
	
	public ExponentialRand(double mean) {
		super(System.currentTimeMillis());
		this.mean = mean;
	}
	
	public double nextDouble() {
		return -mean*Math.log(1.0-super.nextDouble());
	}
	public int nextInt() {
		return (int)Math.ceil(nextDouble());
	}
}

//���� ������ �������� ���ؼ�, ���翡 �ִ� �ڵ带 ����Ͽ���.