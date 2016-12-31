package resetRes;

import java.io.File;

public class MainResReset {

	public static void main(String args[]) {
		File jarFile = new File("../../HUDEdit.jar");
		File exeFile = new File("../../HUDEdit.exe");

		if (jarFile.exists()) {
			String run = "../../HUDEdit.jar";
			try {
				Runtime.getRuntime().exec(run);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (exeFile.exists()) {
			String runExe = "../../HUDEdit.exe";
			try {
				Runtime.getRuntime().exec(runExe);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.exit(0);
	}
}
