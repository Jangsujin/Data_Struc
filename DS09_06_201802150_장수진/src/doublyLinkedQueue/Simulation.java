package doublyLinkedQueue;

public class Simulation {

	ExponentialRand rand = new ExponentialRand(2); // 지수분포를 평균 2로 하여 객체를 생성
	DoublyLinkedQueue queue1 = new DoublyLinkedQueue(); // queue1을 만듦
	DoublyLinkedQueue queue2 = new DoublyLinkedQueue(); // queue2를 만듦
	int id = 0; // Service 받는 객체의 번호. 1씩 증가시킬 것임
	int x = 4; // 시간을 나누는 수
	
	
	void run(){
		// 작업할 메소드
		int term = rand.nextInt(); // 객체 생성 시간 간격을 저장할 변수 term에 랜덤한 수를 넣음.(지수 분포 이용)
		int generation = 1; // 생성 시간을 1로 함.
		for(int t=1;t<=100;t++) {
			// 시간을 1부터 100까지 진행시키면서 
			if(term==generation) {
				// 시간 간격과 생성 시간이 같으면 if문 안으로 들어옴
				if(queue1.size()<=queue2.size()) {
					// queue1에 더 적거나 같은 수의 객체가 있으면
					queue1.add(id); // queue1에 객체를 넣음. (객체에 내용은 없으니 id만 넣음)
					System.out.println("[Time : "+t+"]"+" Service "+id+" arrived. Inserted Queue 1");
					// 들어왔음을 알려줌
				} else {
					// queue2에 더 적은 수의 객체가 있으면
					queue2.add(id); // queue2에 객체를 넣음. (객체에 내용은 없으니 id만 넣음)
					System.out.println("[Time : "+t+"]"+" Service "+id+" arrived. Inserted Queue 2");
					// 들어왔음을 알려줌
				}
				generation=1; // 생성 시간을 다시 1로 초기화하고
				term = rand.nextInt(); // 생성 시간 간격을 다시 조정
				id++; // 한 개의 객체가 생긴 것이므로, id를 1 늘림
			} else {
				generation++;
				// 시간 간격과 같은 generation을 찾기 위해 generation을 1 늘림
			}
			
			if(t%x==0) {
				// 시간 t를 x로 나눈 나머지가 0일 때 첫 번째 큐에서 객체를 삭제함.
				if(queue1.empty()) {
					continue;
					// queue1이 비어있다면, 제거할 것이 없으므로 continue하여 반복문을 진행시킴.
				}
				Object temp = queue1.remove();
				// 제거할 것이 있다면 queue1에서 remove하여 그 객체를 temp에 저장함.
				System.out.println("[Time : "+t+"]"+" Service ID : "+temp+" removed Queue ID : 1");
				// 제거되었음을 알려줌.
			}else if(t%x==1) {
				// 시간 t를 x로 나눈 나머지가 1일 때 두 번째 큐에서 객체를 삭제함.
				if(queue2.empty()){
					continue;
					// queue2가 비어있다면, 제거할 것이 없으므로 continue하여 반복문을 진행시킴.
				}
				Object temp = queue2.remove();
				// 제거할 것이 있다면 queue2에서 remove하여 그 객체를 temp에 저장함.
				System.out.println("[Time : "+t+"]"+" Service ID : "+temp+" removed Queue ID : 2");
				// 제거되었음을 알려줌.
			}
		}
		String result1, result2; // 마지막 출력을 안내하기 위한 결과 문자열 result1, result2를 만듦
		if(queue1.size()==0) {
			// queue1의 size가 0일 경우
			result1="남아 있는 원소가 없습니다."; // 남아 있는 원소가 없음을 문자열 result1에 저장시킴
		} else {
			// 아닐 경우
			result1 = "원소가 "+queue1.size()+"개 남아 있습니다."; // 원소 몇 개가 남았는지를 문자열 result2에 저장시킴
		}
		if(queue2.size()==0) {
			// queue2의 size가 0일 경우
			result2="남아 있는 원소가 없습니다."; // 남아 있는 원소가 없음을 문자열 result2에 저장시킴
		} else {
			// 아닐 경우
			result2 = "원소가 "+queue2.size()+"개 남아 있습니다."; // 원소 몇 개가 남았는지를 문자열 result2에 저장시킴
		}
		System.out.println("Queue 1에 "+result1); // queue1에 몇 개의 객체가 남아있는지를 알려줌
		System.out.println("Queue 2에 "+result2); // queue2에 몇 개의 객체가 남아있는지를 알려줌
	}
	public static void main(String args[]) {
		Simulation s = new Simulation(); // Simulation 객체를 만듦
		s.run(); // 메인 메소드에서  simulation 클래스에 있는 run()메소드를 진행시킴
	}
}
