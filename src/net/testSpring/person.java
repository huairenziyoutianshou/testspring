package net.testSpring;

public class person {

	private helloMessage hellomessage;
	
	public person() {
		
	}
	public person(helloMessage hellomessage) {
		this.hellomessage = hellomessage;
	}
	
	public helloMessage getHellomessage() {
		return hellomessage;
		
	}
	public void  setHelloMessage(helloMessage hellomessage) {
		this.hellomessage = hellomessage;
	}
	public String sayHello() {
		return this.hellomessage.sayHello();
		
	}
	
}
