package queue;

public class ExponentialRandom extends java.util.Random{
	private double mean;
	
	public ExponentialRandom(double mean) {
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

// 지수 분포는 이해하지 못해서, 교재에 있는 코드를 사용하였다.