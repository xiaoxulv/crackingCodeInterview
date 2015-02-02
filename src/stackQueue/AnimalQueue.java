package stackQueue;

import java.util.LinkedList;
import java.util.Queue;



public class AnimalQueue {
	Queue<Dog> dogs = new LinkedList<Dog>();
	Queue<Cat> cats = new LinkedList<Cat>();
	int order = 0;
	public void enqueueAni(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog)
			dogs.add((Dog) a);
		else if (a instanceof Cat)
			cats.add((Cat) a);
	}
	public Dog dequeueDog(){
		return dogs.poll();
	}
	public Cat dequeueCat(){
		return cats.poll();
	}
	public Animal dequeueAni(){
		if(dogs.size() == 0) return dequeueCat();
		else if(cats.size() == 0) return dequeueDog();
		Dog d = dogs.peek();
		Cat c = cats.peek();
		System.out.println(d.order);
		System.out.println(c.order);
		if(d.isOlderThan(c))
			return dequeueDog();
		else 
			return dequeueCat();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Dog("asd");
		Animal b = new Cat("sdf");
		AnimalQueue q = new AnimalQueue();
		q.enqueueAni(a);
		q.enqueueAni(b);
		System.out.println(a.getOrder());
		System.out.println(b.getOrder());
		System.out.println(q.dequeueAni().name);
		//System.out.println(q.dequeueDog().name);
	
	}

}
