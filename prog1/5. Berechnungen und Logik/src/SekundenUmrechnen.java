import java.util.Scanner;

public class SekundenUmrechnen {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Welchen Sekundenwert wollen Sie zerlegen?");
		while (!scan.hasNextInt()) {
		   System.out.println("That's not an int! It's a space station!");
		   scan.nextLine();
		}
		int seconds = scan.nextInt();
		scan.close();		
		
		if (seconds > 0) { 
		
			int year = (seconds / 31536000);
			int days = ((seconds % 31536000) / 86400);
			int hours = (((seconds % 31536000) % 86400) / 3600);
			int minutes = ((((seconds % 31536000) % 86400) % 3600) / 60);
			int msec = ((((seconds % 31536000) % 86400) % 3600) % 60);
			
			System.out.println("Years: " + year + "\nDays: " + days + "\nHours: " + hours + "\nMinutes: " + minutes + "\nSeconds: " + msec);
		} else {
			System.out.println("Doctor, your Tardis broke! We can't go backwards!");
		}
	}
}