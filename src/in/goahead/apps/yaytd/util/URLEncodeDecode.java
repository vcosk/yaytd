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

import java.util.HashMap;
import java.util.Map;

public class URLEncodeDecode {
	
	/**
	 * 
	 */
	private static char ENCODING_INDICATOR = '%';
	
	/**
	 * Map containing encoded string to decoded string.
	 */
	public static Map<String, String> DecodeMap = new HashMap<String, String>(95); 
	
	/**
	 * Map containing decoded string to encoded string.
	 */
	public static Map<String, String> EncodeMap = new HashMap<String, String>(95);
	
	/**
	 * Method initialises the map used for decoding.
	 */
	private static void initDecodeMap() {
		DecodeMap.put("%20", " ");
		DecodeMap.put("%21", "!");
		DecodeMap.put("%22", "\"");
		DecodeMap.put("%23", "#");
		DecodeMap.put("%24", "$");
		DecodeMap.put("%25", "%");
		DecodeMap.put("%26", "&");
		DecodeMap.put("%27", "'");
		DecodeMap.put("%28", "(");
		DecodeMap.put("%29", ")");
		DecodeMap.put("%2A", "*");
		DecodeMap.put("%2B", "+");
		DecodeMap.put("%2C", ",");
		DecodeMap.put("%2D", "-");
		DecodeMap.put("%2E", ".");
		DecodeMap.put("%2F", "/");
		DecodeMap.put("%30", "0");
		DecodeMap.put("%31", "1");
		DecodeMap.put("%32", "2");
		DecodeMap.put("%33", "3");
		DecodeMap.put("%34", "4");
		DecodeMap.put("%35", "5");
		DecodeMap.put("%36", "6");
		DecodeMap.put("%37", "7");
		DecodeMap.put("%38", "8");
		DecodeMap.put("%39", "9");
		DecodeMap.put("%3A", ":");
		DecodeMap.put("%3B", ";");
		DecodeMap.put("%3C", "<");
		DecodeMap.put("%3D", "=");
		DecodeMap.put("%3E", ">");
		DecodeMap.put("%3F", "?");
		DecodeMap.put("%40", "@");
		DecodeMap.put("%41", "A");
		DecodeMap.put("%42", "B");
		DecodeMap.put("%43", "C");
		DecodeMap.put("%44", "D");
		DecodeMap.put("%45", "E");
		DecodeMap.put("%46", "F");
		DecodeMap.put("%47", "G");
		DecodeMap.put("%48", "H");
		DecodeMap.put("%49", "I");
		DecodeMap.put("%4A", "J");
		DecodeMap.put("%4B", "K");
		DecodeMap.put("%4C", "L");
		DecodeMap.put("%4D", "M");
		DecodeMap.put("%4E", "N");
		DecodeMap.put("%4F", "O");
		DecodeMap.put("%50", "P");
		DecodeMap.put("%51", "Q");
		DecodeMap.put("%52", "R");
		DecodeMap.put("%53", "S");
		DecodeMap.put("%54", "T");
		DecodeMap.put("%55", "U");
		DecodeMap.put("%56", "V");
		DecodeMap.put("%57", "W");
		DecodeMap.put("%58", "X");
		DecodeMap.put("%59", "Y");
		DecodeMap.put("%5A", "Z");
		DecodeMap.put("%5B", "[");
		DecodeMap.put("%5C", "\\");
		DecodeMap.put("%5D", "]");
		DecodeMap.put("%5E", "^");
		DecodeMap.put("%5F", "_");
		DecodeMap.put("%60", "`");
		DecodeMap.put("%61", "a");
		DecodeMap.put("%62", "b");
		DecodeMap.put("%63", "c");
		DecodeMap.put("%64", "d");
		DecodeMap.put("%65", "e");
		DecodeMap.put("%66", "f");
		DecodeMap.put("%67", "g");
		DecodeMap.put("%68", "h");
		DecodeMap.put("%69", "i");
		DecodeMap.put("%6A", "j");
		DecodeMap.put("%6B", "k");
		DecodeMap.put("%6C", "l");
		DecodeMap.put("%6D", "m");
		DecodeMap.put("%6E", "n");
		DecodeMap.put("%6F", "o");
		DecodeMap.put("%70", "p");
		DecodeMap.put("%71", "q");
		DecodeMap.put("%72", "r");
		DecodeMap.put("%73", "s");
		DecodeMap.put("%74", "t");
		DecodeMap.put("%75", "u");
		DecodeMap.put("%76", "v");
		DecodeMap.put("%77", "w");
		DecodeMap.put("%78", "x");
		DecodeMap.put("%79", "y");
		DecodeMap.put("%7A", "z");
		DecodeMap.put("%7B", "{");
		DecodeMap.put("%7C", "|");
		DecodeMap.put("%7D", "}");
		DecodeMap.put("%7E", "~");
	}
	
	/**
	 * Method initialises the map used for decoding.
	 */
	private static void initEncodeMap() {
		EncodeMap.put(" ", "%20");
		EncodeMap.put("!", "%21");
		EncodeMap.put("\"", "%22");
		EncodeMap.put("#", "%23");
		EncodeMap.put("$", "%24");
		EncodeMap.put("%", "%25");
		EncodeMap.put("&", "%26");
		EncodeMap.put("'", "%27");
		EncodeMap.put("(", "%28");
		EncodeMap.put(")", "%29");
		EncodeMap.put("*", "%2A");
		EncodeMap.put("+", "%2B");
		EncodeMap.put(",", "%2C");
		EncodeMap.put("-", "%2D");
		EncodeMap.put(".", "%2E");
		EncodeMap.put("/", "%2F");
		EncodeMap.put("0", "%30");
		EncodeMap.put("1", "%31");
		EncodeMap.put("2", "%32");
		EncodeMap.put("3", "%33");
		EncodeMap.put("4", "%34");
		EncodeMap.put("5", "%35");
		EncodeMap.put("6", "%36");
		EncodeMap.put("7", "%37");
		EncodeMap.put("8", "%38");
		EncodeMap.put("9", "%39");
		EncodeMap.put(":", "%3A");
		EncodeMap.put(";", "%3B");
		EncodeMap.put("<", "%3C");
		EncodeMap.put("=", "%3D");
		EncodeMap.put(">", "%3E");
		EncodeMap.put("?", "%3F");
		EncodeMap.put("@", "%40");
		EncodeMap.put("A", "%41");
		EncodeMap.put("B", "%42");
		EncodeMap.put("C", "%43");
		EncodeMap.put("D", "%44");
		EncodeMap.put("E", "%45");
		EncodeMap.put("F", "%46");
		EncodeMap.put("G", "%47");
		EncodeMap.put("H", "%48");
		EncodeMap.put("I", "%49");
		EncodeMap.put("J", "%4A");
		EncodeMap.put("K", "%4B");
		EncodeMap.put("L", "%4C");
		EncodeMap.put("M", "%4D");
		EncodeMap.put("N", "%4E");
		EncodeMap.put("O", "%4F");
		EncodeMap.put("P", "%50");
		EncodeMap.put("Q", "%51");
		EncodeMap.put("R", "%52");
		EncodeMap.put("S", "%53");
		EncodeMap.put("T", "%54");
		EncodeMap.put("U", "%55");
		EncodeMap.put("V", "%56");
		EncodeMap.put("W", "%57");
		EncodeMap.put("X", "%58");
		EncodeMap.put("Y", "%59");
		EncodeMap.put("Z", "%5A");
		EncodeMap.put("[", "%5B");
		EncodeMap.put("\\", "%5C");
		EncodeMap.put("]", "%5D");
		EncodeMap.put("^", "%5E");
		EncodeMap.put("_", "%5F");
		EncodeMap.put("`", "%60");
		EncodeMap.put("a", "%61");
		EncodeMap.put("b", "%62");
		EncodeMap.put("c", "%63");
		EncodeMap.put("d", "%64");
		EncodeMap.put("e", "%65");
		EncodeMap.put("f", "%66");
		EncodeMap.put("g", "%67");
		EncodeMap.put("h", "%68");
		EncodeMap.put("i", "%69");
		EncodeMap.put("j", "%6A");
		EncodeMap.put("k", "%6B");
		EncodeMap.put("l", "%6C");
		EncodeMap.put("m", "%6D");
		EncodeMap.put("n", "%6E");
		EncodeMap.put("o", "%6F");
		EncodeMap.put("p", "%70");
		EncodeMap.put("q", "%71");
		EncodeMap.put("r", "%72");
		EncodeMap.put("s", "%73");
		EncodeMap.put("t", "%74");
		EncodeMap.put("u", "%75");
		EncodeMap.put("v", "%76");
		EncodeMap.put("w", "%77");
		EncodeMap.put("x", "%78");
		EncodeMap.put("y", "%79");
		EncodeMap.put("z", "%7A");
		EncodeMap.put("{", "%7B");
		EncodeMap.put("|", "%7C");
		EncodeMap.put("}", "%7D");
		EncodeMap.put("~", "%7E");
	}
	
	/*
	 * Reference maps are loaded on class load. 
	 */
	static {
		initEncodeMap();
		initDecodeMap();
	}
	
	public static String decodeURL(String encodeString) {
		StringBuilder decodedString = null;
		
		if(encodeString != null) {
			decodedString = new StringBuilder();
			for(int charIndex=0; charIndex < encodeString.length()-2; charIndex++) {
				char currentChar = encodeString.charAt(charIndex);
				if(currentChar == ENCODING_INDICATOR) {
					String encodedChar = encodeString.substring(charIndex, charIndex+3);
					if(DecodeMap.containsKey(encodedChar)) {
						decodedString.append(DecodeMap.get(encodedChar));
						charIndex+=2;
						continue;
					}
				}
				decodedString.append(currentChar);

			}
			if(encodeString.length() > 1) {
				decodedString.append(encodeString.substring(encodeString.length()-2));
			}
		}
		
		return decodedString==null?null:decodedString.toString();
	}
	
	public static String encodeURL(String decodeString) {
		StringBuilder encodedString = null;
		
		if(decodeString != null) {
			encodedString = new StringBuilder();
			for(int charIndex=0; charIndex < decodeString.length(); charIndex++) {
				char currentChar = decodeString.charAt(charIndex);
					if(EncodeMap.containsKey(currentChar)) {
						encodedString.append(EncodeMap.get(currentChar));
					}
			}
		}
		
		return encodedString==null?null:encodedString.toString();
	}
}
