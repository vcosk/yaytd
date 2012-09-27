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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
}