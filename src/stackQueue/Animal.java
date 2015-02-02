package stackQueue;

public class Animal {
	int order;
	String name;
	
	public Animal(String n){
		name = n;
	}
	public void setOrder(int o){
		order = o;
	}
	public int getOrder(){
		return order;
	}
	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder();
	}
}
