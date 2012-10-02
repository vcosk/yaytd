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

import in.goahead.apps.yaytd.log.AppLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Class contains utility methods wrt., URL and corresponding stream handling.
 * @author Vikas K
 *
 */
public class URLUtils {
	
	private static AppLogger Logger = AppLogger.getLogger(URLUtils.class);
	
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
		File outputFileObj = new File(outputFile);
		boolean appendStreamData = false;
		long skipLength = 0;
		if(outputFileObj.exists()) {
			appendStreamData = true;
			skipLength = outputFileObj.length();
		}
		OutputStream outputStream = new FileOutputStream(outputFile, appendStreamData);
		if(inputStream.skip(skipLength) == skipLength) {
			DownloadStream(inputStream, outputStream);
		}
		outputStream.flush();
		outputStream.close();
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
//		InputStream is = null;
//		
//		Proxy proxy = getProxy();
//		
//		URL urlObj = new URL(url);
//		URLConnection connection = null;
//		if(proxy == null) {
//			connection = urlObj.openConnection();
//		}
//		else {
//			connection = urlObj.openConnection(proxy);
//		}
//		is = connection.getInputStream();		
//		return is;
		
		InputStream is = null; 
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		HttpEntity httpEntity = httpResponse.getEntity();
		if(httpEntity != null) {
			is = httpEntity.getContent();
		}
		
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
	
	public static void AppendStream(InputStream inputStream, String outputFileName, long skip) throws IOException {
		long actualSkip = 0;
		Logger.debug("Skip length: "+ skip + " Actual skip: " + actualSkip);
		actualSkip = inputStream.skip(skip);
		Logger.debug("Skip length: "+ skip + " Actual skip: " + actualSkip);
		if(actualSkip == skip) {
			Logger.debug("Skip length: "+ skip + " Actual skip: " + actualSkip);
			OutputStream os = new FileOutputStream(outputFileName, true);
			DownloadStream(inputStream, os);
			os.flush();
			os.close();
		}
		else {
			Logger.debug("Skip length: "+ skip + " Actual skip: " + actualSkip);
		}
		
	}
}
