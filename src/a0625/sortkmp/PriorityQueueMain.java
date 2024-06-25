package a0625.sortkmp;

import java.util.Comparator;
import java.util.PriorityQueue;



public class PriorityQueueMain {
	
	static class Car implements Comparable<Car> {
		String name;
		int year;
		public Car(String name, int year) {
			this.name = name;
			this.year = year;
		}
		@Override
		public String toString() {
			return "Car [name=" + name + ", year=" + year + "]";
		}
		@Override
		public int compareTo(Car o) {
			return name.compareTo(o.name);
		}
	}
	
	public static void main(String[] args) {
		//최소힙
		//PriorityQueue<Integer> pq = new PriorityQueue<>();
		//최대힙
		//PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<>( (o1,o2) -> {return o2 - o1; }  );
		
		pq.offer(22);
		pq.offer(11);
		pq.offer(33);
		pq.offer(22);
		pq.offer(1);
		pq.offer(3);
		
		System.out.println(pq);
		
		while(!pq.isEmpty()) System.out.println(pq.poll());
		System.out.println();
		
		//PriorityQueue<Car> pcq = new PriorityQueue<>((o1,o2)->{return -Integer.compare(o1.year, o2.year);});
		PriorityQueue<Car> pcq = new PriorityQueue<>( (o1,o2) ->  {
			if (o1.name == o2.name ) { return Integer.compare(o1.year, o2.year);}
			return o1.name.compareTo(o2.name);
			 }
		);
		pcq.offer(new Car("아반떼",2015));
		pcq.offer(new Car("그랜저",2014));
		pcq.offer(new Car("소나타",2012));
		pcq.offer(new Car("아반떼",2011));
		pcq.offer(new Car("그랜저",2015));
		pcq.offer(new Car("아반떼",2017));
		pcq.offer(new Car("아반떼",2018));
		
		System.out.println(pcq);
		while(!pcq.isEmpty()) System.out.println(pcq.poll());
		
		
	}

}
