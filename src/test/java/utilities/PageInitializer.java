package utilities;

import pages.SearchHomePage;

public class PageInitializer extends BaseClass{
	
	private static SearchHomePage search;
	
	
	
	
	public static void initialize() {
		
		search = new SearchHomePage();
		
		
		
	}
	public static SearchHomePage getSearchHomePage() {
		return search;
	}

}
