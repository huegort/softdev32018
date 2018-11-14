package ie.gmit.week10.enums;

public class TestMonth {

	public static void main(String[] args) {
		Month current = Month.JAN;
		
		for (Month c : Month.values()) {
			if (c == Month.FEB) {
				System.out.print("*");
			}
			System.out.print(c+":");
			switch (c) {
			case JAN: 
				System.out.println("brrrrr");
				break;
			case FEB: 
				System.out.println("romantic in 14");
				break;
			case MAR: 
				System.out.println("Spring must be coming soone");
			}
			
		}
		
	}

}
