package doublyLinkedQueue;

public class Simulation {

	ExponentialRand rand = new ExponentialRand(2); // ���������� ��� 2�� �Ͽ� ��ü�� ����
	DoublyLinkedQueue queue1 = new DoublyLinkedQueue(); // queue1�� ����
	DoublyLinkedQueue queue2 = new DoublyLinkedQueue(); // queue2�� ����
	int id = 0; // Service �޴� ��ü�� ��ȣ. 1�� ������ų ����
	int x = 4; // �ð��� ������ ��
	
	
	void run(){
		// �۾��� �޼ҵ�
		int term = rand.nextInt(); // ��ü ���� �ð� ������ ������ ���� term�� ������ ���� ����.(���� ���� �̿�)
		int generation = 1; // ���� �ð��� 1�� ��.
		for(int t=1;t<=100;t++) {
			// �ð��� 1���� 100���� �����Ű�鼭 
			if(term==generation) {
				// �ð� ���ݰ� ���� �ð��� ������ if�� ������ ����
				if(queue1.size()<=queue2.size()) {
					// queue1�� �� ���ų� ���� ���� ��ü�� ������
					queue1.add(id); // queue1�� ��ü�� ����. (��ü�� ������ ������ id�� ����)
					System.out.println("[Time : "+t+"]"+" Service "+id+" arrived. Inserted Queue 1");
					// �������� �˷���
				} else {
					// queue2�� �� ���� ���� ��ü�� ������
					queue2.add(id); // queue2�� ��ü�� ����. (��ü�� ������ ������ id�� ����)
					System.out.println("[Time : "+t+"]"+" Service "+id+" arrived. Inserted Queue 2");
					// �������� �˷���
				}
				generation=1; // ���� �ð��� �ٽ� 1�� �ʱ�ȭ�ϰ�
				term = rand.nextInt(); // ���� �ð� ������ �ٽ� ����
				id++; // �� ���� ��ü�� ���� ���̹Ƿ�, id�� 1 �ø�
			} else {
				generation++;
				// �ð� ���ݰ� ���� generation�� ã�� ���� generation�� 1 �ø�
			}
			
			if(t%x==0) {
				// �ð� t�� x�� ���� �������� 0�� �� ù ��° ť���� ��ü�� ������.
				if(queue1.empty()) {
					continue;
					// queue1�� ����ִٸ�, ������ ���� �����Ƿ� continue�Ͽ� �ݺ����� �����Ŵ.
				}
				Object temp = queue1.remove();
				// ������ ���� �ִٸ� queue1���� remove�Ͽ� �� ��ü�� temp�� ������.
				System.out.println("[Time : "+t+"]"+" Service ID : "+temp+" removed Queue ID : 1");
				// ���ŵǾ����� �˷���.
			}else if(t%x==1) {
				// �ð� t�� x�� ���� �������� 1�� �� �� ��° ť���� ��ü�� ������.
				if(queue2.empty()){
					continue;
					// queue2�� ����ִٸ�, ������ ���� �����Ƿ� continue�Ͽ� �ݺ����� �����Ŵ.
				}
				Object temp = queue2.remove();
				// ������ ���� �ִٸ� queue2���� remove�Ͽ� �� ��ü�� temp�� ������.
				System.out.println("[Time : "+t+"]"+" Service ID : "+temp+" removed Queue ID : 2");
				// ���ŵǾ����� �˷���.
			}
		}
		String result1, result2; // ������ ����� �ȳ��ϱ� ���� ��� ���ڿ� result1, result2�� ����
		if(queue1.size()==0) {
			// queue1�� size�� 0�� ���
			result1="���� �ִ� ���Ұ� �����ϴ�."; // ���� �ִ� ���Ұ� ������ ���ڿ� result1�� �����Ŵ
		} else {
			// �ƴ� ���
			result1 = "���Ұ� "+queue1.size()+"�� ���� �ֽ��ϴ�."; // ���� �� ���� ���Ҵ����� ���ڿ� result2�� �����Ŵ
		}
		if(queue2.size()==0) {
			// queue2�� size�� 0�� ���
			result2="���� �ִ� ���Ұ� �����ϴ�."; // ���� �ִ� ���Ұ� ������ ���ڿ� result2�� �����Ŵ
		} else {
			// �ƴ� ���
			result2 = "���Ұ� "+queue2.size()+"�� ���� �ֽ��ϴ�."; // ���� �� ���� ���Ҵ����� ���ڿ� result2�� �����Ŵ
		}
		System.out.println("Queue 1�� "+result1); // queue1�� �� ���� ��ü�� �����ִ����� �˷���
		System.out.println("Queue 2�� "+result2); // queue2�� �� ���� ��ü�� �����ִ����� �˷���
	}
	public static void main(String args[]) {
		Simulation s = new Simulation(); // Simulation ��ü�� ����
		s.run(); // ���� �޼ҵ忡��  simulation Ŭ������ �ִ� run()�޼ҵ带 �����Ŵ
	}
}
