
public class absoluteCharacters {

	public static String getString() {
		
		return "Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor " +
				"incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis " +
				"nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat" +
				". Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu " +
				"fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt " +
				"in culpa qui officia deserunt mollit anim id est laborum.\n\n" +
				"Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie " +
				"consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et " +
				"accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit " +
				"augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, " +
				"consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut " +
				"laoreet dolore magna aliquam erat volutpat.\n\n" +
				"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit " +
				"lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure " +
				"dolor in hendrerit in vulputate velit esse molestie consequat, vel illum " +
				"dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio " +
				"dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te " +
				"feugait nulla facilisi.\n\n" +
				"Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet " +
				"doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet " +
				", consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut " +
				"laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, " +
				"quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex " +
				"ea commodo consequat.";
	}
	
	public static String addLetter(char c, String db) {
		
		String[] dbArray = db.split(" ");
		
		for(int i = 0; i < dbArray.length; i++) {
			if (dbArray[i].charAt(0) == c) {
				int value = Integer.parseInt(dbArray[i+1]);
				value++;
				dbArray[i+1] = Integer.toString(value);
				break;
			}
		}
		String returnString = "";
		for(int i = 0; i < dbArray.length; i++) {
			if ( i == 0 ) {
				returnString = dbArray[i];
			} else {
				returnString = returnString + " " + dbArray[i];
			}
		}
		
		return returnString;
	}
	
	public static void printDatabase(String db) {
		
		String[] dbArray = db.split(" ");
		
		for(int i = 0; i < dbArray.length; i = i+2) {
			System.out.println(dbArray[i] + ": " + dbArray[i+1]);
		}	
		
	}
	
	public static void main(String args[]) {
		
		// create initial database
		String database = "a 0 b 0 c 0 d 0 e 0 f 0 g 0 h 0 i 0 j 0 k 0 l 0 m 0 n 0 o 0 p 0 q 0 r 0 s 0 t 0 u 0 v 0 w 0 x 0 y 0 z 0";

		String inputString = getString();
		for(int i = 0; i < inputString.length(); i++)
		{
		   char c = inputString.charAt(i);
		   database = addLetter(Character.toLowerCase(c), database);
		}
		
		printDatabase(database);
		
	}
	
}
