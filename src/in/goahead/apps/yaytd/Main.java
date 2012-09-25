package in.goahead.apps.yaytd;

import in.goahead.apps.yaytd.log.AppLogger;
import in.goahead.apps.yaytd.util.URLEncodeDecode;

import java.net.URI;

public class Main {

	/**
	 * Main method to start the job.
	 * @param args csv file containing the list of comma separated
	 *  video id and download quality. 
	 */
	public static void main(String[] args) {
		try {
			String str = "http%3A%2F%2Fo-o---preferred---sn-h557sne6---v17---lscache8.c.youtube.com%2Fvideoplayback%3Fupn%3DEGCDwk-AlPU%26sparams%3Dcp%252Cgcr%252Cid%252Cip%252Cipbits%252Citag%252Cratebypass%252Csource%252Cupn%252Cexpire%26fexp%3D922401%252C920704%252C912806%252C913419%252C913558%252C913556%252C925109%252C919003%252C912706%26key%3Dyt1%26itag%3D22%26ipbits%3D8%26signature%3D479EC918FE32B418453402C6B19CECD90D959B13.9E1810F57AE1AB36148D42DE11C66779A4E142C5%26mv%3Dm%26sver%3D3%26mt%3D1348604474%26ratebypass%3Dyes%26source%3Dyoutube%26ms%3Dau%26gcr%3Din%26expire%3D1348629462%26ip%3D117.216.207.25%26cp%3DU0hTTVZNV19LTENOM19OR0FFOkk5Vkh3WERDSmJP%26id%3D085f4baf2f355eb0%26newshard%3Dyes&quality=hd720&fallback_host=tc.v7.cache2.c.youtube.com&type=video%2Fmp4%3B+codecs%3D%22avc1.64001F%2C+mp4a.40.2%22&itag=22";
			
			AppLogger.log(URLEncodeDecode.decodeURL(str));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
