import java.io.File;
import java.util.Arrays;
import java.util.Comparator;


public class Aufgabe11_1 {

	/**
	 * Comparator returns Folders before Files and sorts them alphabetically,
	 * although non capital and capital letters are not the same
	 */
	static Comparator<File> fileFolderCmp = new Comparator<File>() {

	    @Override
	    public int compare(File f1, File f2) {
	       if (f1.isDirectory() == f2.isDirectory()) { // if both files or folders, sort alphabetically
	    	   return f1.getName().compareTo(f2.getName());
	       } else {
	    	   return f1.isDirectory() ? -1 : 1; // else sort folder before file
	       }
	    }
	};
	
	/**
	 * Rounds double to the last two decimals, doesn't actually round, just cuts off
	 * 
	 * @param val	double - is the double to be rounded off @NonNull
	 * @return		Returns a String representation of val with two decimals
	 */
	private static String roundOffTo2DecPlaces(double val)
	{
	    return String.format("%.2f", val);
	}
	
	/**
	 * Returns a tree representation of f and its contents
	 * 
	 * @param f		File - Folder to be displayed @NonNull
	 * @param 		showHidden boolean - whether or not do display hidden content @NonNull
	 * @return 		String representation of f as a tree
	 */
	public static String dirTree(File f, boolean showHidden) {
		
		if ( f.isDirectory() ) {
			return "|_ " +  f.getName() + "\n" + listFilesForFolder(f, showHidden, 1);
		} else {
			return "|_ " +  f.getName() + "\n";
		}
	}
	
	/**
	 * Recursive function returning the tree representation of given folder
	 * 
	 * @param folder		File to be analyzed, has to be a folder, not a file @NonNull
	 * @param showHidden	boolean - whether or not to show hidden files @NonNull
	 * @param depth 		int - the current depth of the recursion, initial value should be 1 @NonNull
	 * @return 				String representing the folder as a tree
	 */
	public static String listFilesForFolder(File folder, boolean showHidden, int depth) {
		
		String output = "";
		File[] entries = folder.listFiles();
		
		Arrays.sort(entries, fileFolderCmp);
		
		for (File fileEntry : entries) {
	        if (fileEntry.isDirectory() && ( showHidden ? true : !fileEntry.isHidden() )) {
	        	String spaces = new String(new char[depth]).replace("\0", "   ");
//	        	System.out.println(spaces + "|_ " + fileEntry.getName());
	            output = output + spaces + "|_ " + fileEntry.getName() + "\n" + listFilesForFolder(fileEntry, showHidden, depth+1);
	        } else if ( showHidden ? true : !fileEntry.isHidden() ) {
	        	String spaces = new String(new char[depth]).replace("\0", "   ");
//	            System.out.println(spaces  + "|_ " +  fileEntry.getName() + " (" + Math.floor(fileEntry.length() / 1024) + "kB)");
	            output = output + spaces  + "|_ " +  fileEntry.getName() + " (" + roundOffTo2DecPlaces((double)fileEntry.length() / 1024.0) + "kB)" + "\n" ;
	        }
	    }
		
		return output;
	}
	
	
	public static void main(String args[]) {
		
		File home = new File(System.getProperty("user.home") + File.separator + "Music");
		System.out.println(dirTree(home, false)); // Keine versteckten Dateien
				
	}
	
	
}
