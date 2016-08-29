package hr.vvg.spring.locale;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SupportedLanguages {
	
	public List<Locale> getLangs() {
		
		List<Locale> langs = new ArrayList<Locale>();
		langs.add(new Locale("hr"));
		langs.add(new Locale("en"));
		
		return langs;
		
	}

}
