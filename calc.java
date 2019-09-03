// Римские цифры обозначаются через английские буквы V,I и X.
package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Input: ");
			String s = input.nextLine();
			if(Arab.proverkaArab(s)){
				if(Deistvie.proverkaDeistviya(s)!='e'){
				Arab arab = new Arab();
				arab.st = s;
				arab.one = arab.prisvoenieOne(arab.st);
				arab.two = arab.prisvoenieTwo(arab.st);
				arab.deistvie = Deistvie.proverkaDeistviya(arab.st);
				System.out.println("Output: ");
				System.out.println(arab.schet(arab.one, arab.two, arab.deistvie));
				} else {
					System.out.println("Введена неверная строка.");
				}
			} else if(Rim.proverkaRim(s)){
				if(Deistvie.proverkaDeistviya(s)!='e'){
					Rim rim = new Rim();
					rim.st = s;
					rim.one = rim.prisvoenieOne(rim.st);
					rim.two = rim.prisvoenieTwo(rim.st);
					rim.deistvie = Deistvie.proverkaDeistviya(rim.st);
					System.out.println("Output: ");
					System.out.println(rim.schet(rim.one, rim.two, rim.deistvie));
				} else{
					System.out.println("Введена неверная строка.");
				}
			} else{
				System.out.println("Введена неверная строка.");
			}
	}
}

class  Deistvie{
	protected String st;
	protected int one;
	protected int two;
	protected char deistvie;
	static char proverkaDeistviya(String s){
		if(s.indexOf('+')>0){
			return '+';
		} else if(s.indexOf('-')>0){
			return '-';
		} else if(s.indexOf('/')>0){
			return '/';
		} else if(s.indexOf('*')>0){
			return '*';
		}
		return 'e';
	}
	int schet(int one, int two, char deistvie){
		int otvet=0;
		if(deistvie=='-'){
			otvet=one-two;
			return otvet;
		}
		if(deistvie=='+'){
			otvet=one+two;
			return otvet;
		}
		if(deistvie=='/'){
			otvet=one/two;
			return otvet;
		}
		if(deistvie=='*'){
			otvet=one*two;
			return otvet;
		}  
		return otvet;
	}
}

class Arab extends Deistvie{
	static boolean proverkaArab(String s){
		for(int i = 1; i<11; i++){
			if(s.startsWith(""+i)){
				for(int j = 1; j<11; j++){
					if(s.endsWith(""+j)){
						return true;
					}
				}
			}
		}
		return false;	
	}
	
	int prisvoenieOne(String s){
		for(int i = 1; i<11; i++){
			if(s.startsWith(""+i)){
				if(i==1){
					if(s.indexOf("0")==1 ){
						return 10;
					} else {
						return i;
					}
				}
				return i;
			}
		}
		return -1;
	}
	
	int prisvoenieTwo(String s){
		for(int i = 1; i<11; i++){
			if(s.endsWith(""+i)){
				if(i==1){
					if(s.indexOf("0")==s.length()-1){
						return 10;
					} else {
						return i;
					}
				}
				return i;
			}
		}
		return -1;
	}
}

class Rim extends Deistvie{
	static boolean proverkaRim(String s){
		if(s.indexOf('I')>0 || s.indexOf('X')>0 || s.indexOf('V')>0){
			for(int i = 0; i<10; i++){
				if(s.indexOf(i+"")>=0){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	int prisvoenieOne(String s){
		if(s.indexOf('X')==0){
			st = s.substring(1);
			return 10;
		}
		if(s.indexOf('X')==1 && s.indexOf('I')==0){
			st = s.substring(2);
			return 9;
		}
		if(s.indexOf('V')==0 && s.indexOf("III")==1){
			st = s.substring(4);
			return 8;
		}
		if(s.indexOf('V')==0 && s.indexOf("II")==1){
			st = s.substring(3);
			return 7;
		}
		if(s.indexOf('V')==0 && s.indexOf('I')==1){
			st = s.substring(2);
			return 6;
		}
		if(s.indexOf('V')==0){
			st = s.substring(1);
			return 5;
		}
		if(s.indexOf('V')==1 && s.indexOf('I')==0){
			st = s.substring(2);
			return 4;
		}
		if(s.indexOf("III")==0){
			st = s.substring(3);
			return 3;
		}
		if(s.indexOf("II")==0){
			st = s.substring(2);
			return 2;
		}
		if(s.indexOf('I')==0){
			st = s.substring(1);
			return 1;
		}
		return -1;
	}
	int prisvoenieTwo(String s){
		if(s.indexOf('V')==s.length()-4 && s.indexOf("III")==s.length()-3){
			return 8;
		}
		if(s.indexOf('V')==s.length()-3 && s.indexOf("II")==s.length()-2){
			return 7;
		}
		if(s.indexOf('V')==s.length()-2 && s.indexOf('I')==s.length()-1){
			return 6;
		}
		if(s.indexOf("III")==s.length()-3){
			return 3;
		}
		if(s.indexOf("II")==s.length()-2){
			return 2;
		}
		if(s.indexOf('I')==s.length()-1){
			return 1;
		}
		if(s.indexOf('V')==s.length()-1 && s.indexOf('I')==s.length()-2){
			return 4;
		}
		if(s.indexOf('V')==s.length()-1){
			return 5;
		}
		if(s.indexOf('X')==s.length()-1 && s.indexOf('I')==s.length()-2){
			return 9;
		}
		if(s.indexOf('X')==s.length()-1){
			return 10;
		}
		return -1;
	}
}
