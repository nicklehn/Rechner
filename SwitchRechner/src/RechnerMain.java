import java.util.Scanner;
import java.text.DecimalFormat;

public class RechnerMain {

	public static void main(String[] args) {
		
		operation(input());
		
	}

	
	public static double[] input() {
		
		Scanner scanner = new Scanner(System.in);
		
		double[] numbers = new double[10];
		
		try {
			
		int j;
		System.out.println("Anzahl ihrer Zahlen: ");
		j = scanner.nextInt();
		
		numbers = new double[j];
		
		for(int i=0;i<numbers.length;i++) {
			
			System.out.println("Geben Sie die " + (i+1) + ". Zahl ein:");
			numbers[i] = scanner.nextDouble();
			
		}
		
		}
		
		catch(Exception InputMismatchException) {
			System.out.println("Falsche Eingabe!");
			System.out.println("Versuchen Sie es erneut:");
			System.out.println("");
			input();
		}
		
		return numbers;
		
	}
	
	public static void operation(double[] numbers) {
		
		DecimalFormat df = new DecimalFormat();
		Scanner scanner = new Scanner(System.in);
		
		String operator;
		
		System.out.println("Wählen Sie ihre Operation aus: ");
		operator = scanner.next();
		
		try {
			
		switch(operator) {
		case "+":
			double result1=numbers[0];
			for (int i=0; i<numbers.length-1;i++) {
				result1+=numbers[i+1];
				System.out.println(result1-numbers[i+1] + " + " + numbers[i+1] + " = " + result1);
			}
			break;
		case "-":
			double result2=numbers[0];
			for (int i=0; i<numbers.length-1;i++) {
				result2-=numbers[i+1];
				System.out.println(result2+numbers[i+1] + " - " + numbers[i+1] + " = " + result2);
			}
			break;
		case "*":
			double result3=numbers[0];
			for (int i=0; i<numbers.length-1;i++) {
				result3*=numbers[i+1];
				System.out.println(df.format(result3/numbers[i+1]) + " * " + df.format(numbers[i+1]) + " = " + df.format(result3));
			}
			break;
		case ":":
			double result4=numbers[0];
			for (int i=0; i<numbers.length-1;i++) {					
				result4/=numbers[i+1];
				System.out.println(df.format(result4*numbers[i+1]) + " : " + df.format(numbers[i+1]) + " = " + df.format(result4));
			}
			break;
		case "^":
			if (numbers.length > 2) {
				System.out.println("Operation nur mit 2 Zahlen möglich: ");
				System.out.println("");
				operation(numbers);
			}
			else 
				System.out.println(numbers[0] + " ^ " + numbers[1] + " = " + df.format((Math.pow(numbers[0], numbers[1]))));
			break;
		case "sqrt":
			if (numbers.length > 1) {
				System.out.println("Operation nur mit 1 Zahl möglich: ");
				System.out.println("");
				operation(numbers);
			}
			else
				System.out.println(" \2u221A " + numbers[0] + " = " + df.format(Math.sqrt(numbers[0])));
			break;
		default:
			System.out.println("Kein Gültiger Operator! Gültige Operatoren:");
			System.out.println("+ -> Addieren");
			System.out.println("- -> Subtrahieren");
			System.out.println("* -> Multiplizieren");
			System.out.println(": -> Dividieren");
			System.out.println("^ -> Hoch");
			System.out.println("sqrt -> Wurzel");
			System.out.println("");
			operation(numbers);
		
		}
		
		}
		
		catch(Exception e) {
			System.out.println("Falsche Eingabe! Neu eingeben:");
			operation(numbers);
		}
		
	}
	
}
