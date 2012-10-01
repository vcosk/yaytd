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

public enum VideoQuality {

	HD, FHD,HIGH, MEDIUM, LOW;

	public static VideoQuality ValueOf(String q) {
		VideoQuality v = HD;
		if(q != null) {
			if(q.equalsIgnoreCase("F")) {
				v = FHD;
			}
			else if(q.equalsIgnoreCase("H")) {
				v = HIGH;
			}
			else if(q.equalsIgnoreCase("M")) {
				v = MEDIUM;
			} 
			else if(q.equalsIgnoreCase("S") || q.equalsIgnoreCase("L")) {
				v = LOW;
			}
			else {
				try {
					v=valueOf(q);
				}
				catch(IllegalArgumentException ile) {
					v=HD;
				}
			}
		}
		return v;
	}
}
