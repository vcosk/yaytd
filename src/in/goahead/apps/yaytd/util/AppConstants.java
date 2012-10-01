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

public class AppConstants {
	public static String PARAMS_SEPARATOR = "&";
	public static String STATUS = "status";
	public static String SUCCESS = "ok";
	public static String FAILURE = "fail";
	public static String VIDEO_TITLE_INFO = "title";
	public static String URL_INFO = "url_encoded_fmt_stream_map";
	public static String ENCODING_INDICATOR = "%";
	public static String DATA_SEPARATOR = "=";
	public static String URL_SEPARATOR = ",";
	public static String MP4_VIDEO = "type=video/mp4";
	public static String FLV_VIDEO = "type=video/x-flv";
	public static String URL_PARAM = "itag.*url=";
	public static String URL_END_PARAM = "+codecs=";
	public static String URL_REPLACE_PARAM = "%20codecs=";
	public static String VIDEO_1080	 = "quality=hd1080";
	public static String VIDEO_720 = "quality=hd720";
	public static String VIDEO_480 = "quality=large";
	public static String VIDEO_360 = "quality=medium";
	public static String VIDEO_240 = "quality=small";
	public static String TITLE_PARAM = "&title=";
	
	public static String YOUTUBE_VIDEO_INFO_URL = "http://www.youtube.com/get_video_info?video_id=";
	public static String YOUTUBE_VIDEO_ID_PARAM = "v=";
}
