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

package in.goahead.apps.yaytd;

import in.goahead.apps.yaytd.log.AppLogger;
import in.goahead.apps.yaytd.util.URLEncodeDecode;
import in.goahead.apps.yaytd.util.URLUtils;
import in.goahead.apps.yaytd.util.VideoInfoParser;

import java.net.URI;

public class Main {
	
	private static AppLogger Logger = AppLogger.getLogger(Main.class);

	/**
	 * Main method to start the job.
	 * @param args csv file containing the list of comma separated
	 *  video id and download quality. 
	 */
	public static void main(String[] args) {
		try {
			java.io.FileInputStream f = new java.io.FileInputStream("D:/Work/yaytd/get_video_info_1080");
			Logger.debug(VideoInfoParser.parseInfoFile(URLUtils.InputStreamToString(f), "MP4","H"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
