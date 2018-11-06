package ie.gmit.week09.strings;

public class MainA {

	public static void main(String[] args) {
		String a = "hello world";
		String b = "hello " + "world";
		String c = b + "";
		
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a.equals(c));

	}

}
