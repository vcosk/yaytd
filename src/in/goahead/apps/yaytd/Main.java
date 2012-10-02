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

import in.goahead.apps.yaytd.enums.VideoQuality;
import in.goahead.apps.yaytd.log.AppLogger;
import in.goahead.apps.yaytd.util.AppConstants;
import in.goahead.apps.yaytd.util.InputFileReader;
import in.goahead.apps.yaytd.util.URLUtils;
import in.goahead.apps.yaytd.util.VideoInfoParser;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class Main {

	private static AppLogger Logger = AppLogger.getLogger(Main.class);

	/**
	 * Main method to start the job.
	 * @param args csv file containing the list of comma separated
	 *  video id and download quality. 
	 */
	public static void main(String[] args) {
		try {
			//java.io.FileInputStream f = new java.io.FileInputStream("D:/Work/yaytd/get_video_info_1080");
			//Logger.debug(VideoInfoParser.parseInfoFile(URLUtils.InputStreamToString(f), "MP4","H"));
			Map<String, VideoQuality> videosToDownload = InputFileReader.ReadInputFile(null);
			for(String vid : videosToDownload.keySet()) {
				String videoInfo = URLUtils.InputStreamToString(URLUtils.OpenURL(AppConstants.YOUTUBE_VIDEO_INFO_URL + vid));
				VideoObj videoObj = VideoInfoParser.parseInfoFile(videoInfo);
				VideoQuality quality = videosToDownload.get(vid);
				String downloadURL = videoObj.getLinkMP4(quality);
				Logger.debug(videoObj);
				if(downloadURL == null) {
					downloadURL = videoObj.getLinkMP4(VideoQuality.FHD);
				}
				//				Logger.debug(videoObj);
				//				Logger.debug(downloadURL);
				//				Logger.debug(URLDecoder.decode(videoObj.getTitle(), "UTF-8")+"_"+videosToDownload.get(vid));
				//				InputStream videoStream = URLUtils.OpenURL(downloadURL);				
				//				URLUtils.DownloadStream(videoStream, videoObj.getTitle()+"_"+videosToDownload.get(vid));				
				//				videoStream.close();

				if(downloadURL != null) {
					InputStream videoStream = URLUtils.OpenURL(downloadURL);
					String outputFileName = videoObj.getTitle()+"_"+videosToDownload.get(vid)+".mp4";
					Logger.debug("Downloading..");
//					File f = new File(outputFileName);
//					if(f.exists()) {
//						Logger.debug("Append");
//						long currentFileSize = f.length();
//						URLUtils.AppendStream(videoStream, outputFileName, currentFileSize);
//					}
//					else {
//						Logger.debug("Create");
						URLUtils.DownloadStream(videoStream, outputFileName);
						videoStream.close();
//					}
					Logger.debug("Downloaded");					
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

		}
	}
}
