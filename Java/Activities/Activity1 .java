package activities;

public class Activity1 {

	public static void main(String[] args) {
		Car carObj1 = new Car("Red", "Manual", 2020);
		Car carObj2 = new Car("White", "Automatic", 2022);		
				
				carObj2.displayCharacteristics();
				carObj1.accelarate();
				carObj1.brake();
				
				

	}

}
