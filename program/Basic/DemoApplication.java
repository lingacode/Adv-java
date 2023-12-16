class Demo1{
	static{
		System.out.println("Demo1::static block");
	}
	public Demo1(){
		System.out.println("Demo1::0-param constructer");
	}
} //class

class Test1{
	public Test1(){
		System.out.println("Test1::0-param constructer");
	}
	static{
		System.out.println("Test1::static block");
	}
} //class

public class DemoApplication{
	static{
		System.out.println("DemoApplication:static block");
	}//static block
	public static void main(String[] args)throws Exception{
		System.out.println("DemoApplication:main(-)method ---start");
	Demo1 d1 = new Demo1();
		Demo1 d2 = new Demo1();
		
		Class.forName("Test1");
		
			Class.forName("Demo1");
		
		System.out.println("DemoApplication:main(-) method ---end");
	} //main
} //class