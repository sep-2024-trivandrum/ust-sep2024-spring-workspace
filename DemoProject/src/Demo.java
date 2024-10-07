import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo {

	public static void main(String[] args) {
		
		// first way - conventional way
		Operation add1 = new Addition();
		System.out.println("Sum is : " + add1.operate(6, 3));

		Operation product1 = new Multiplication();
		System.out.println("Product is : " + product1.operate(4, 2));
		
		System.out.println("---------------------------");
		// second way - using anonymous classes
		
		Operation add2 = new Operation() {
			@Override
			public int operate(int num1, int num2) {
				return (num1 + num2);
			}
		};
		System.out.println("Sum is : " + add2.operate(1, 2));
		
		Operation product2 = new Operation() {
			@Override
			public int operate(int num1, int num2) {
				return (num1 * num2);
			}
		};
		System.out.println("Product is : " + product2.operate(4, 2));
		
		System.out.println("---------------------------");
		// third way - using lambda expressions
		
		Operation add3 = (num1, num2) -> (num1 + num2);
		System.out.println("Sum is : " + add3.operate(2, 2));
		
		Operation product3 = (n1, n2) -> (n1 * n2);
		System.out.println("Product is : " + product3.operate(4, 2));
		
		BiFunction<Integer, Integer, Integer> add4 = (num1, num2) -> (num1 + num2);
		System.out.println("Sum is : " + add4.apply(6, 2));
		
		// odd or even
		
		Predicate<Integer> oddEven = number -> (number % 2 == 0);
		System.out.println("Is Even? : " + oddEven.test(8));
		
		Function<Integer, String> oddEven2 = number -> ((number % 2 == 0)?"Even":"Odd");
		System.out.println("Is 5 Even? : " + oddEven2.apply(5));
		
		Predicate<Integer> isPrime = (num) -> {
			for(int i=2;i<num/2;i++) {
				if(num%i == 0) {
					return false;
				}
			}
			return true;
		};
		
		System.out.println("IsPrime 7 : " + isPrime.test(7));
		
		Function<String, String> isPalindrome = str -> (str.equals(new StringBuffer(str).reverse().toString())?"Palindrome":"Not Palindrome");
		System.out.println("Is Palindrome mad? " + isPalindrome.apply("mad"));
		
	}

}
