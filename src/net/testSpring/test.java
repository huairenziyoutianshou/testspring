package net.testSpring;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		helloChina china = new helloChina();
		String str = china.sayHello();
		System.out.println(str);
		
		helloWorld world = new helloWorld();
		System.out.println(world.sayHello());
		
		
		helloMessage message = new helloChina();
		System.out.println(message.sayHello());
		helloMessage message1 = new helloWorld();
		System.out.println(message1.sayHello());
	}

}
