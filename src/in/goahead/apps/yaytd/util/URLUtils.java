/*
 * This file is part of Yet Another Youtube Downloader (yaytd).

    Youtube Downloader (yaytd) 
    is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Youtube Downloader (yaytd)
     is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Youtube Downloader (yaytd).
    If not, see <http://www.gnu.org/licenses/>.
 */

package in.goahead.apps.yaytd.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/**
 * Class contains utility methods wrt., URL and corresponding stream handling.
 * @author Vikas K
 *
 */
public class URLUtils {
	
	/**
	 * Method converts a given input stream to a string.
	 * @param inputStream InputStream to be read.
	 * @return The string version of the input stream.
	 * @throws IOException
	 */
	public static String InputStreamToString(InputStream inputStream) throws IOException {
		StringBuilder returnStringBuilder = null;
		
		if(inputStream != null) {
			returnStringBuilder = new StringBuilder();
			int readByteInt;
			while((readByteInt = inputStream.read()) != -1) {
				returnStringBuilder.append((char)readByteInt);
			}
		}
		
		return returnStringBuilder==null?null:returnStringBuilder.toString();
	}
	
	/**
	 * Method writes the InputStream to given OutputStream.
	 * @param inputStream InputStream to be written.
	 * @param outputStream Destination stream. 
	 * @throws IOException
	 */
	public static void DownloadStream(InputStream inputStream, OutputStream outputStream) throws IOException {
		if(inputStream != null && outputStream != null) {
			int readIntByte;
			while((readIntByte = inputStream.read()) != -1) {
				outputStream.write(readIntByte);
			}
		}
	}
	
	/**
	 * Method writes the InputStream to the given file.
	 * @param inputStream InputStream to be written.
	 * @param outputFile Destination File. 
	 * @throws IOException
	 */
	public static void DownloadStream(InputStream inputStream, String outputFile) throws IOException {
		OutputStream outputStream = new FileOutputStream(outputFile);
		DownloadStream(inputStream, outputStream);
	}
	
	/**
	 * Method writes the InputStream to the given file.
	 * @param inputStream InputStream to be written.
	 * @param outputDirectory Destination Folder.
	 * @param outputFileName Destination file name.
	 * @throws IOException
	 */
	public static void DownloadStream(InputStream inputStream, String outputDirectory, String outputFileName) throws IOException {
		DownloadStream(inputStream, outputDirectory+"/"+outputFileName);
	}
	
	public static InputStream OpenURL(String url) throws MalformedURLException, IOException {
		InputStream is = null;
		
		Proxy proxy = getProxy();
		
		URL urlObj = new URL(url);
		URLConnection connection = null;
		if(proxy == null) {
			connection = urlObj.openConnection();
		}
		else {
			connection = urlObj.openConnection(proxy);
		}
		is = connection.getInputStream();		
		return is;
	}
	
	public static Proxy getProxy() {
		Proxy proxy = null;
		String proxyType = System.getProperty("YAYTD.PROXY_TYPE");
		String proxyServer = System.getProperty("YAYTD.PROXY_SERVER");
		String proxyPort = System.getProperty("YAYTD.PROXY_PORT");
		
		try {
		if(proxyType != null && proxyServer != null && proxyPort != null) {
			proxy = new Proxy(Proxy.Type.valueOf(proxyType), new InetSocketAddress(proxyServer, Integer.parseInt(proxyPort)));
		}
		}
		catch(IllegalArgumentException ile) {
			ile.printStackTrace();
		}
		
		return proxy;
	}
}
