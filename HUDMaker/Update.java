package db_hud;

import java.io.InputStream;
import java.net.URL;

public class Update {
	private final static String versionURL = "http://xyfurion.comli.com/HUDEdit/version.html";
	private final static String historyURL = "http://xyfurion.comli.com/HUDEdit/changelog.html";
	private final static String yPlusURL = "http://xyfurion.comli.com/HUDEdit/yPlus.html";

	public static String getVersion() throws Exception {
		String data = getData(versionURL);
		return data.substring(data.indexOf("[version]") + 9, data.indexOf("[/version]"));
	}

	public static String getChangelog() throws Exception {
		String data = getData(historyURL);
		return data.substring(data.indexOf("[changelog]") + 11, data.indexOf("[/changelog]"));
	}

	public static int getYPlus() throws Exception {
		String data = getData(yPlusURL);
		return Integer.parseInt(data.substring(data.indexOf("[yplus]") + 7, data.indexOf("[/yplus]")));
	}

	private static String getData(String address) throws Exception {
		URL url = new URL(address);
		InputStream html = null;
		html = url.openStream();
		int c = 0;
		StringBuffer buffer = new StringBuffer("");
		while (c != -1) {
			c = html.read();
			buffer.append((char) c);
		}
		return buffer.toString();
	}

}
