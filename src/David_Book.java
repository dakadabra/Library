
public class David_Book {

		public enum location {
			inTransit, inRepair, lost, in, out
		}
		
		String title;
		
		public enum language {
		English, French, Spanish, Mandarin;
		}
		
		String authorFirst = "J. K.";
		String authorLast = "Rowling";
		String pages = "100";
		boolean virtual = false;
		String ISBN = "0-000";
		String numberCopies = "0";
		boolean borrowed = false;
		int bookNumber = 0;
		
		public David_Book (String b, String d, String e,
				String f, boolean g, String h, String i, boolean j, int k) {
			//location = a;
			title = b;
			//language = c;
			authorFirst = d;
			authorLast = e;
			pages = f;
			virtual = g;
			ISBN = h;
			numberCopies = i;
			borrowed = j;
			bookNumber = k;
		}
}