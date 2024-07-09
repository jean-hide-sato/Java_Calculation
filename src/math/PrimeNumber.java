package math;

import java.util.*;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //create scanner
		int language = 0;
		ArrayList<Integer> divs = new ArrayList<>();
		String again = "y";
		int number = 0;
		
		while(language == 0) {
			System.out.print("Select the language number (1: English/2: 日本語/3: Portugues): ");
			try {
				language = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
			} 
			if (language < 1 || language > 3) {
				language = 0;
				System.out.println("Select a valid number!");
			}
		}

		while(again.intern() == "y") {
			switch (language) {
			case 1: default:
				System.out.print("Enter a number to check if it is a prime number: ");
				break;
			case 2:
				System.out.print("素数かどうか判定する数字を入力してください：　");
				break;
			case 3:
				System.out.print("Digite o numero para verificar se e primo: ");
				break;
			}
			
			try {
				number = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
				number = 0;
			}
			while (number <= 0) {	//In case the user uses 0 or negative number
				switch (language) {
				case 1: default:
					System.out.print("The entered value is invalid, please enter a number greather than 0 (zero): ");
					break;
				case 2:
					System.out.print("入力された数字はは無効です、0よりも大きい数字を入力して下さい：　");
					break;
				case 3:
					System.out.print("O valor digitado nao e um numero valido, digite um numero maior que 0 (zero): ");
					break;
				}
				try {
					number = sc.nextInt();
				} catch (InputMismatchException e) {
					sc.next();
				}
			}
			
			if (primecheck(number)) {
				switch (language) {
				case 1: default:
					System.out.println("The number " + number + " is a prime number");
					break;
				case 2:
					System.out.println(number + "は素数です");
					break;
				case 3:
					System.out.println("O numero " + number + " e um numero primo");
					break;
				}
			} else {
				divisibles(number, divs);
				switch (language) {
				case 1: default:
					System.out.println("The number " + number + " is not a prime number");
					System.out.print("Divisible by: ");
					break;
				case 2:
					System.out.println(number + "は素数ではありません");
					System.out.print("割り切れる数字: ");
					break;
				case 3:
					System.out.println("O numero " + number + " nao e um numero primo");
					System.out.print("Divisivel por: ");
					break;
				}
				for (int d : divs) {
					System.out.print (d + " ");
				}
			}
			
			//ask if want to do again
			switch (language) {
			case 1: default:
				System.out.print("\nCheck another number? (y/n) ");
				break;
			case 2:
				System.out.print("\n他の数字で試しますか？ (y/n) ");
				break;
			case 3:
				System.out.print("\nVerificar outro numero? (y/n) ");
				break;
			}
			again = sc.next();
			while (again.intern() != "n" && again.intern() != "y") {
				System.out.print("(y/n) ");
				again = sc.next();
			} 
			
			if(again.intern() == "n") {
				System.out.println("Thank you");
			}
		}
		sc.close(); //close the scanner 
	}
	
	public static boolean primecheck (int number) {
		if (number == 1 || number == 2) {
			return true;
		}
		int subnumber = number;
		int div = 3;
		
		if (number%2 == 0) return false;
		
		while (subnumber > div) {
			if (number%div == 0) {
				return false;
			}
			subnumber = number / div;
			div += 2;
		}
		return true;
	}

	public static void divisibles (int number, ArrayList<Integer> divs) {
		int num = number;
		int div = 2;
		divs.clear();
		
		while (num > div) {
			if (number%div == 0) {
				divs.add(div);
				if (div != number/div) {
					divs.add(number/div);					
				}
			}
			div ++;
			num = number/div;
			if (num*num == number) {
				divs.add(num);
			}
		}
		divs.sort( (a, b) -> a.compareTo(b) );
	}
}
