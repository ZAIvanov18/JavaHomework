import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = readListOfIntegers(sc);
		
		String input = sc.nextLine();
		
		while (!input.equals("End")) {
			
			String[] token = input.split(" ");

			if (token[0].equals("Add")) {
				list.add(Integer.parseInt(token[1]));
			} 
			else if(token[0].equals("Insert")) {
				
				if(Integer.parseInt(token[2]) < list.size()) {
					list.add(Integer.parseInt(token[2]), Integer.parseInt(token[1]));
				}
				else {
					System.out.println("Invalid index");
				}
			}
			else if(token[0].equals("Remove")) {
				
				if(Integer.parseInt(token[1]) < list.size()) {
					list.remove(Integer.parseInt(token[1]));
				}
				else {
					System.out.println("Invalid index");
				}
			}
			else if(token[1].equals("left")) {
				
				int count = Integer.parseInt(token[2]);
				
				for(int i = 0; i < count; i++) {
					int temp = list.get(0);
					
					for(int j = 0; j < list.size() - 1; j++) {
						list.set(j, list.get(j+1));
					}
					
					list.set(list.size() - 1, temp);
				}
			}
			else if(token[1].equals("right")) {
				int count = Integer.parseInt(token[2]);
				
				for(int i = 0; i < count; i++) {
					int temp = list.get(list.size() - 1);
					
					for(int j = list.size() - 2; j >= 0; j--) {
						list.set(j + 1, list.get(j));
					}
					
					list.set(0, temp);
				}
			}
			input = sc.nextLine(); 
		}
		
		for (Integer elements : list) {
			System.out.print(elements + " ");
		}
	}
	
	private static List<Integer> readListOfIntegers(Scanner scanner) {

		return Arrays.stream(scanner.nextLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

}