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
package in.goahead.apps.yaytd.enums;

public enum Params {
	NULL,status,errorcode,reason,video_id,fmt_list,title,url_encoded_fmt_stream_map;
	public static Params ValuOf(String params) {
		Params p = NULL;
		
		try {
			p = valueOf(params);
		}
		catch(IllegalArgumentException iae) {
			p = NULL;
		}
		return p;
	}
}
