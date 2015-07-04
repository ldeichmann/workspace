import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;


public class Decrypter extends Thread {

	private Storage s;
	private Password pw;

	
	public Decrypter(Storage st) {
		this.s = st;
	}

	public static String md5(String s) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		return DatatypeConverter.printBase64Binary(md.digest(s.getBytes()));
	}
	
	public static String guessPwd(String user, String hash) {
//		System.out.println("Guessing " + user + " " + hash);
		char[] abc = "123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (char a : abc) {
			for (char b : abc) {
				for (char c : abc) {
					for (char d : abc) {
						String pwd = "" + a + b + c + d;
//						System.out.println(pwd);
						long start = System.currentTimeMillis();
						try {
							if (hash.equals(md5(user + pwd))) {
								return pwd;
							}
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						System.out.println("Dauer Hash+Base64 " + (System.currentTimeMillis() - start));
					}
				}
			}
		}
		return null;
	}
	
	public void run() {
		while ((pw = s.getPassword()) != null) {
			long start = System.currentTimeMillis();
			pw.setPassword(this.guessPwd(pw.getUsername(), pw.getEncPassword()));
			long end = System. currentTimeMillis();
			pw.setTime(end - start);
			s.addDecPassword(pw);
			System.out.println("found " + pw.getUsername() + " " + pw.getPassword() + " in " + pw.getTime());

		}
		
	}
	
}
