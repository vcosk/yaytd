package in.goahead.apps.yaytd.util;

import in.goahead.apps.yaytd.log.AppLogger;

public class ApplicationUtil {
	
	private static AppLogger logger = AppLogger.getLogger(ApplicationUtil.class);
	
	public static String createValidFileName(String currentName) {		
		String outputFileName = null;
		String[] invalidFileCharecters = {"\\\\","/","\\?","\\*","<",">","\\|"}; 
		if(currentName !=null) {
			outputFileName = URLEncodeDecode.decodeURL(currentName);
			for(String testChareter : invalidFileCharecters) {
				outputFileName = outputFileName.replaceAll(testChareter, "_");
			}
		}
		return outputFileName;
	}
}
