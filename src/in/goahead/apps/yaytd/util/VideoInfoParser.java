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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Set;

import in.goahead.apps.yaytd.VideoObj;
import in.goahead.apps.yaytd.enums.Params;
import in.goahead.apps.yaytd.enums.VideoQuality;
import in.goahead.apps.yaytd.log.AppLogger;
import in.goahead.apps.yaytd.util.AppConstants;

public class VideoInfoParser {
	
	private static AppLogger Logger = AppLogger.getLogger(VideoInfoParser.class);
	
	public static VideoObj parseInfoFile(String infoDataString, String videoType, String quality) throws UnsupportedEncodingException {
		VideoObj videoObj = new VideoObj();
		videoObj.setRequestedQuality(quality);
		videoObj.setFormat(videoType);
		
		String[] infoDataArray = infoDataString.split(AppConstants.PARAMS_SEPARATOR);
		boolean error = false;;
		int exitCounter = 0;
		
		for(String infoData : infoDataArray) {
			//Logger.debug(infoData);
			String[] infoElementArray = infoData.split(AppConstants.DATA_SEPARATOR);
			switch(Params.ValuOf(infoElementArray[0])) {
				case status:
					if(infoElementArray[1].equals(AppConstants.SUCCESS)) {
						continue;
					}
					else {
						error = true;
					}
					break;
				case errorcode:
					if(error) {
						videoObj.setErrorCode(Integer.parseInt(infoElementArray[1]));
						if(++exitCounter == 2) break;
					}
					break;
				case reason:
					if(error) {
						videoObj.setErrorMessage(infoElementArray[1]);
						if(++exitCounter == 2) break;
					}
					break;
				case title:
					videoObj.setTitle(infoElementArray[1].replaceAll("\\+", "%20"));
					break;
				case video_id:
					videoObj.setObjectID(infoElementArray[1]);
					break;
				case fmt_list:
					loadVideoQualityAvailable(URLDecoder.decode(infoElementArray[1], "UTF-8"), videoObj);
					break;
				case url_encoded_fmt_stream_map:
					loadVideoURLs(URLDecoder.decode(infoElementArray[1], "UTF-8"), videoObj);
					break;
				default:
			}
		}
		
		if(!error) {
			Set<VideoQuality> mp4KeySet = videoObj.getQualityLinkMapMP4().keySet();
			for(VideoQuality v : mp4KeySet) {
				videoObj.addLinkMP4(v, videoObj.getLinkMP4(v)+AppConstants.TITLE_PARAM+videoObj.getTitle());
			}
			
			Set<VideoQuality> flvKeySet = videoObj.getQualityLinkMapFLV().keySet();
			for(VideoQuality v : flvKeySet) {
				videoObj.addLinkFLV(v, videoObj.getLinkFLV(v)+AppConstants.TITLE_PARAM+videoObj.getTitle());
			}
		}
		
		return videoObj;
	}
	
	private static void loadVideoURLs(String URLs, VideoObj videoObj) throws UnsupportedEncodingException {
		String[] urlArrays = URLs.split(AppConstants.URL_SEPARATOR);
		for(String urlP : urlArrays) {
			//String url = URLEncodeDecode.decodeURL(urlP);
			String url = URLDecoder.decode(urlP,"UTF-8");
			url = url.replaceFirst(AppConstants.URL_PARAM, "").replaceAll("\\+", "%20").replace("&sig=", "&signature=");
			
			if(url.contains(AppConstants.MP4_VIDEO)) {
				if(url.contains(AppConstants.VIDEO_1080)) {
					videoObj.addLinkMP4(VideoQuality.HD, url);
				}
				else if(url.contains(AppConstants.VIDEO_720)) {
					videoObj.addLinkMP4(VideoQuality.FHD, url);
				}
				else if(url.contains(AppConstants.VIDEO_480)) {
					videoObj.addLinkMP4(VideoQuality.HIGH, url);
				}
				else if(url.contains(AppConstants.VIDEO_360)) {
					videoObj.addLinkMP4(VideoQuality.MEDIUM, url);
				}
				else if(url.contains(AppConstants.VIDEO_240)) {
					videoObj.addLinkMP4(VideoQuality.LOW, url);
				}
			}
			else if(url.contains(AppConstants.FLV_VIDEO)) {
				
				if(url.contains(AppConstants.VIDEO_1080)) {
					videoObj.addLinkFLV(VideoQuality.HD, url);
				}
				else if(url.contains(AppConstants.VIDEO_720)) {
					videoObj.addLinkFLV(VideoQuality.FHD, url);
				}
				else if(url.contains(AppConstants.VIDEO_480)) {
					videoObj.addLinkFLV(VideoQuality.HIGH, url);
				}
				else if(url.contains(AppConstants.VIDEO_360)) {
					videoObj.addLinkFLV(VideoQuality.MEDIUM, url);
				}
				else if(url.contains(AppConstants.VIDEO_240)) {
					videoObj.addLinkFLV(VideoQuality.LOW, url);
				}
			}
			
		}
	}
	
	private static void loadVideoQualityAvailable(String availabe, VideoObj videoObj) {
		if(availabe.contains("1280x720")) {
			videoObj.addQualityMP4(VideoQuality.HD);
			videoObj.addQualityFLV(VideoQuality.HD);
		}		
		else if(availabe.contains("854x480")) {
			videoObj.addQualityMP4(VideoQuality.HIGH);
			videoObj.addQualityFLV(VideoQuality.HIGH);
		}	
		else if(availabe.contains("640x360")) {
			videoObj.addQualityMP4(VideoQuality.MEDIUM);
			videoObj.addQualityFLV(VideoQuality.MEDIUM);
		}
		else if(availabe.contains("320x240")) {
				videoObj.addQualityMP4(VideoQuality.LOW);
				videoObj.addQualityFLV(VideoQuality.LOW);
		}	
	}
}
