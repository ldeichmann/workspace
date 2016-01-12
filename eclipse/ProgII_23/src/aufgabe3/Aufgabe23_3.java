package aufgabe3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.DatatypeConverter;

public class Aufgabe23_3 {

	public static String md5(String s) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		return DatatypeConverter.printBase64Binary(md.digest(s.getBytes()));
	}

	public static String guessPwd(String user, String hash) {
		// System.out.println("Guessing " + user + " " + hash);
		char[] abc = "123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (char a : abc) {
			for (char b : abc) {
				for (char c : abc) {
					for (char d : abc) {
						String pwd = "" + a + b + c + d;
						long start = System.currentTimeMillis();
						try {
							if (hash.equals(md5(user + pwd))) {
								System.out.println(pwd);
								return pwd;
							}
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// System.out.println("Dauer Hash+Base64 " +
						// (System.currentTimeMillis() - start));
					}
				}
			}
		}
		return null;
	}

	public static void main(String args[]) {

		URL text;
		try {
			text = new URL("http://www.nkode.io/assets/programming/pins.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					text.openStream()));
			long start = System. currentTimeMillis();
			Map<String, String> passwords = reader.lines().parallel()
			.skip(1).map(l -> l.split(", +"))
			.map(a -> Arrays. asList(a[0].replace("\"", ""), a[1].replace("\"", "")))
			.collect(Collectors.toMap(a -> a.get(0), a -> guessPwd(a.get(0), a.get(1)) // jeder Aufruf zeitaufwaendig
			));

			long end = System. currentTimeMillis();

			System. out.println("Processing time: " + (end - start) + " ms");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
