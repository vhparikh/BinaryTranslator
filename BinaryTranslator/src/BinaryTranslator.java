//Created by Vatsal Parikh
//Inspired by Mr. Galbraith's video tutorials
//Date 9/17/19
//this program converts binary numbers to decimal and decimal numbers to binary and you can input from a file or from the console
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTranslator {

	public BinaryTranslator() {
		System.out.println("Please enter \"file\" to enter a file or \"input\" to use console");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String numberInput = "";
		if(input.equals("file")) {
			try {
				System.out.println("Enter your file name.");
				input = scanner.nextLine();
				Scanner fileScanner = new Scanner(new File(input));
				numberInput = fileScanner.nextLine();
			}catch(IOException ex){
				System.out.println("File not found.");
				scanner.close();
				System.exit(1);
			}
		}else {
			System.out.println("Enter your number");
			numberInput = scanner.nextLine();
		}
		System.out.println("If you are translating from decimal to binary, type \"dtb\".");
		System.out.println("If you are translating from binary to decimal, type \"btd\".");
		input = scanner.nextLine();
		if(input.equals("dtb")) {//convert decimal to binary
			String answer = "";
			int number = Integer.parseInt(numberInput);//parse number input to integer
			while(number > 0) {
				if(number % 2 == 1) {//if number divided by 2 has a remainder of 1 then:
					answer = "1" + answer;
				}else {//else add 0 to the number
					answer = "0" + answer;
				}
				number = number / 2;
			}
			System.out.println("Your answer in binary is: " + answer);
		}else {//convert binary to decimal
			int answer = 0;
			int indexLength = numberInput.length() - 1;//this is stored to find the highest power in the binary number later
			for(int a = 0; a < numberInput.length(); a++) {
				int highPower = (char)(Math.pow(2, indexLength));//finding the highest power in the binary number
				int character = numberInput.charAt(a) - 48;//converts decimal back to 1 or 0
				int number = character * highPower;//find the value of this digit in the binary number
				answer += number;//add the number to the answer
				indexLength--;//go down on number to find the next highest power in the binary number
			}
			System.out.println("Your answer in decimal is: " + answer);
		}
		scanner.close();//closes scanner
	}
	
	public static void main(String[] args) {
		new BinaryTranslator();
	}

}
