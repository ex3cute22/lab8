import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

class Car{
    private String name;
    private int year;
    private int price;
    private Support supportCar = new Support();
    public static int count = 0;

    public void init(){
        name = " ";
        year = 0;
        price = 0;
        count++;
    }
    
    public void init(String name, int year, int price){
        this.name = name;
        this.year = year;
        this.price = price;
        count++;
    }

    public void read() {
        try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Input name: ");
			name = scan.nextLine();
			System.out.println("Input year: ");
			year = scan.nextInt();
			System.out.println("Input price: ");
			price = scan.nextInt();
		} catch (Exception error) {
			error.printStackTrace();
		}
    }

    public void addTag(){
        name += " (purchased)";
    }

    public void display(){
        try {
			PrintStream ps = new PrintStream(System.out, true, "Windows-1251");
			ps.println("Name: " + name + "\n" + "Year: " + year + "\n" + "Price: " + price);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public int getPrice(){
        return price;
    }
    public void showRate(){
        supportCar.getRate(this);
    }
    public static void RemoveItem(){
        count--;
    }
    public static int InfoCount(){
        return count;
    }

}
class Support{
    void getRate(Car car){
        System.out.println("Rate " + car.getName() +": " + ((float) car.getYear() * 200) / car.getPrice() );
    }
}


public class Main{
    public static void main(String[] args) {
        Car cars[] = new Car[5];
        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car();
            cars[i].init();
        } 
        System.out.println(Car.InfoCount());
        Car.RemoveItem();
        System.out.println(Car.InfoCount());

}
}