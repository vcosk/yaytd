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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoObj {
	
	private String URL;
	private String ObjectID;
	private VideoQuality VideoQuality;
	private VideoQuality RequestedQuality;
	private List<VideoQuality> availableQualityMP4 = new ArrayList<VideoQuality>();
	private List<VideoQuality> availableQualityFLV = new ArrayList<VideoQuality>();
	private String Title;
	private Map<VideoQuality, String> QualityLinkMapFLV = new HashMap<VideoQuality, String>();
	private Map<VideoQuality, String> QualityLinkMapMP4 = new HashMap<VideoQuality, String>();
	private String Format;
	private int ErrorCode;
	private String ErrorMessage;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("URL: "+ URL).append("\n");
		sb.append("ObjectID: "+ ObjectID).append("\n");
		sb.append("VideoQuality: "+ VideoQuality).append("\n");
		sb.append("RequestedQuality: "+ RequestedQuality).append("\n");
		sb.append("Title: "+ Title).append("\n");
		sb.append("URL: "+ URL).append("\n");
		sb.append("Format: "+ Format).append("\n");
		sb.append("ErrorCode: "+ ErrorCode).append("\n");
		sb.append("availableQualityMP4: "+ availableQualityMP4).append("\n");
		sb.append("availableQualityFLV: "+ availableQualityFLV).append("\n");
		sb.append("QualityLinkMapFLV: "+ QualityLinkMapFLV).append("\n");
		sb.append("QualityLinkMapMP4: "+ QualityLinkMapMP4).append("\n");
		
		return sb.toString();
	}
	
	public String getURL() {
		return URL;
	}
	
	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getObjectID() {
		return ObjectID;
	}

	public void setObjectID(String objectID) {
		ObjectID = objectID;
	}

	public VideoQuality getVideoQuality() {
		return VideoQuality;
	}

	public void setVideoQuality(VideoQuality videoQuality) {
		VideoQuality = videoQuality;
	}

	public VideoQuality getRequestedQuality() {
		return RequestedQuality;
	}

	public void setRequestedQuality(VideoQuality requestedQuality) {
		RequestedQuality = requestedQuality;
	}

	public List<VideoQuality> getAvailableQualityMP4() {
		return availableQualityMP4;
	}

	public void setAvailableQualityM4(List<VideoQuality> availableQuality) {
		this.availableQualityMP4 = availableQuality;
	}
	
	public List<VideoQuality> getAvailableQualityFLV() {
		return availableQualityFLV;
	}

	public void setAvailableQualityFLV(List<VideoQuality> availableQuality) {
		this.availableQualityFLV = availableQuality;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Map<VideoQuality, String> getQualityLinkMapFLV() {
		return QualityLinkMapFLV;
	}

	public void setQualityLinkMapFLV(Map<VideoQuality, String> qualityLinkMap) {
		QualityLinkMapFLV = qualityLinkMap;
	}
	
	public Map<VideoQuality, String> getQualityLinkMapMP4() {
		return QualityLinkMapMP4;
	}

	public void setQualityLinkMapMP4(Map<VideoQuality, String> qualityLinkMap) {
		QualityLinkMapMP4 = qualityLinkMap;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
	
	public void addQualityFLV(VideoQuality quality) {
		this.availableQualityFLV.add(quality);
	}
	
	public void addQualityMP4(VideoQuality quality) {
		this.availableQualityMP4.add(quality);
	}
	
	public void addLinkFLV(VideoQuality quality, String URL) {
		this.QualityLinkMapFLV.put(quality, URL);
	}
	
	public String getLinkFLV(VideoQuality quality) {
		return this.QualityLinkMapFLV.get(quality);
	}
	
	public void addLinkMP4(VideoQuality quality, String URL) {
		this.QualityLinkMapMP4.put(quality, URL);
	}
	
	public String getLinkMP4(VideoQuality quality) {
		return this.QualityLinkMapMP4.get(quality);
	}

	public int getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
}
