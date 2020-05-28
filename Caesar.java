package chipher;

import java.util.ArrayList;
import java.util.Scanner;

public class Caesar {

	String message;
	int shift = 0;

	public Caesar() {
		message = "";

	}

	public String messages() {
		boolean correct = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Type your message you want encrypted ");
		message = scan.nextLine();
		message  = message.toLowerCase();
		while(correct == false) {
			System.out.println("Type how many letters you want shifted up to 25 letters");
			shift = scan.nextInt();
			if(shift >= 0 && shift <= 25) {
				correct = true;
			}
		}
		encrypt();
		//dycrypt();
		return message;

	}
	private void encrypt() {
		ArrayList<Integer> values = new ArrayList<>();
		String encryption = "";


		for(int i = 0; i< message.length(); i++) {

			if(message.charAt(i) != ' ') {

				if(message.charAt(i)+shift > 122) {

					int spot = message.charAt(i) +shift;
					spot = (spot - 122)+96;
					values.add(spot);

				}
				else {

					values.add( message.charAt(i) +shift);
				}

			}
			else {
				values.add(32);
			}
		}

		for(int j = 0; j < values.size(); j ++ ) {
			char c;
			int a = values.get(j);
			c = (char)a;
			encryption += Character.toString(c);
		}
		message = encryption;

	}
	private void dycrypt() {
		ArrayList<Integer> values = new ArrayList<>();
		String encryption = "";


		for(int i = 0; i< message.length(); i++) {

			if(message.charAt(i) != ' ') {

				if(message.charAt(i)-shift < 97) {

					int spot = message.charAt(i) -shift;
					spot = spot + 26;
					values.add(spot);

				}
				else {

					values.add( message.charAt(i) -shift);
				}

			}
			else {
				values.add(32);
			}
		}

		for(int j = 0; j < values.size(); j ++ ) {
			char c;
			int a = values.get(j);
			c = (char)a;
			encryption += Character.toString(c);
		}
		message = encryption;




	}
}
