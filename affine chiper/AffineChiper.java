import java.util.Scanner;
public class AffineChiper {
	static int key1=7;
	static int key2=2;

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter your message (plaintext): ");
		String plaintext=scan.nextLine();
		System.out.println("Encrypted cipher code (ciphertext):"+encrypt(plaintext));
		String chipertext=encrypt(plaintext);
		System.out.println("Decrypted message (plaintext):"+decrypt(chipertext));
		scan.close();

	}
	
	public static String encrypt(String plaintext) {
		String encrypted="";
		for (int i=0; i<plaintext.length(); i++) {
			char ch1=Character.toLowerCase(plaintext.charAt(i));
			int numvalue1=(int)(ch1-97);
			int message1=(numvalue1*key1+key2)%26;
			char temp1=(char)(message1+65);
			encrypted=encrypted+temp1;
		}
		return encrypted;
	}
	
	public static String decrypt(String chipertext) {
		int inverse=0; int check=0; String decrypted=" ";
		for (int j=1; j<26; j++) {
			check=(key1*j)%26;
			if (check==1) {
				inverse=j;
			}
		}
		for (int k=0; k<chipertext.length(); k++) {
			char ch2=Character.toUpperCase(chipertext.charAt(k));
			int numvalue2=ch2-65;
			int message2=((numvalue2-key2)*inverse)%26;
			if (message2<0) {
				message2=message2+26;
			}
			char temp2=(char)(message2+97);
			decrypted=decrypted+temp2;
		}
		return decrypted;
	}

}
