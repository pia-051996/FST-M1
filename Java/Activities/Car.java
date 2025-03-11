package activities;

public class Car {
	String color;
	String transmission;
	int make;
	int tyres = 4;
	int doors = 4;
	//constructor
	public Car(String color, String transmission, int make) {
		
	this.color = color;
	this.transmission = transmission;
	this.make = make;
	}
		
	
	public void displayCharacteristics() {
		System.out.println("Color of the car is: " + this.color);
		System.out.println("The transmissoon type is: " + this.transmission);
		System.out.println("Car is made in the year: "+ this.make);
		System.out.println("No. of tyres: " + tyres);
		System.out.println("No. of doors: " + doors);
	}
		
	public void accelarate() {
		System.out.println("Car moves forward");
	}
	
	public void brake () {
		System.out.println(" Car stops");
		
	}
}
	
