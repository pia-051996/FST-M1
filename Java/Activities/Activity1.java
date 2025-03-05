package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car carObj = new Car("Red", "Auto", 2020);
		carObj.displayCharacteristics();
		carObj.accelarate();
		carObj.brake();
		
		Car carObj2 = new Car("Blue", "Manual", 2025);
		carObj2.displayCharacteristics();
		carObj2.accelarate();
		carObj2.brake();
	}

}
