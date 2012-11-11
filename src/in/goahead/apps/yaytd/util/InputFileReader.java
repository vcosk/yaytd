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

import in.goahead.apps.yaytd.enums.VideoQuality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InputFileReader {

	public static Map<String, VideoQuality> ReadInputFile(String inputFile) throws Exception {
		if(inputFile == null) {
			inputFile = "videos.csv";
		}

		Map<String, VideoQuality> videoMap = new LinkedHashMap<String, VideoQuality>();
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String fileData = null;
		while((fileData = br.readLine()) != null) {
			String[] dataArray = fileData.split(",");
			String query = new URL(dataArray[0]).getQuery();
			String[] params = query.split("&");
			String videoId = null;
			for(String param : params) {
				if(param.startsWith(AppConstants.YOUTUBE_VIDEO_ID_PARAM)) {
					videoId = param.substring(param.indexOf(AppConstants.YOUTUBE_VIDEO_ID_PARAM)+AppConstants.YOUTUBE_VIDEO_ID_PARAM.length());
				}
			}

			if(videoId != null) {
				if(dataArray.length > 1) {
					videoMap.put(videoId, VideoQuality.ValueOf(dataArray[1]));
				}
				else {
					videoMap.put(videoId, VideoQuality.HD);
				}
			}
		}
		br.close();
		
		return videoMap;
	}
}
