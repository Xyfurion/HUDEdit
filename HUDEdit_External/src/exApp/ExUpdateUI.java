package exApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;

/**
 *
 * @author Thomas Otero (H3R3T1C)
 */
public class ExUpdateUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread worker;
	private final String root = "update/";

	public String[] stringArr;

	private JTextArea outText;
	private JButton cancel;
	private JButton launch;
	private JScrollPane sp;
	private JPanel pan1;
	private JPanel pan2;

	public ExUpdateUI() throws IOException {
		readVersion();
		saveSettings();
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		initComponents();
		outText.setText("Contacting Download Server. This may take a minute.");
		download();
		rewriteSettings();
	}

	public void readSettings() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("/bin/settings.cfg"));
		String str;

		List<String> list = new ArrayList<String>();
		while ((str = in.readLine()) != null) {
			list.add(str);
		}
		stringArr = list.toArray(new String[0]);
		in.close();
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		pan1 = new JPanel();
		pan1.setBackground(Color.WHITE);
		pan1.setLayout(new BorderLayout());

		pan2 = new JPanel();
		pan2.setBackground(Color.WHITE);
		pan2.setLayout(new FlowLayout());

		outText = new JTextArea();
		sp = new JScrollPane();
		sp.setViewportView(outText);

		launch = new JButton("Launch App");
		launch.setEnabled(false);
		launch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				launch();
			}
		});
		pan2.add(launch);

		cancel = new JButton("Close");
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pan2.add(cancel);
		pan1.add(sp, BorderLayout.CENTER);
		pan1.add(pan2, BorderLayout.SOUTH);

		getContentPane().add(pan1);
		pack();
		this.setSize(500, 400);
	}

	private void download() {
		worker = new Thread(new Runnable() {
			public void run() {
				try {
					downloadFile(getDownloadLinkFromHost());
					unzip();
					copyFiles(new File(root), new File("").getAbsolutePath());
					cleanup();
					launch.setEnabled(true);
					outText.setText(outText.getText() + "\nUpdate Finished!");
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "An error occured while preforming update!");
				}
			}
		});
		worker.start();
	}

	private void launch() {
		File jarFile = new File("HUDEdit.jar");
		File exeFile = new File("HUDEdit.exe");

		if (jarFile.exists()) {
			String run = "HUDEdit.jar";
			try {
				Runtime.getRuntime().exec(run);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (exeFile.exists()) {
			String runExe = "HUDEdit.exe";
			try {
				Runtime.getRuntime().exec(runExe);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			System.err.println("");
		}
		System.exit(0);
	}

	private void cleanup() {
		outText.setText(outText.getText() + "\nPreforming clean up...");
		File f = new File("update.zip");
		f.delete();
		remove(new File(root));
		new File(root).delete();
	}

	private void remove(File f) {
		File[] files = f.listFiles();
		for (File ff : files) {
			if (ff.isDirectory()) {
				remove(ff);
				ff.delete();
			} else {
				ff.delete();
			}
		}
	}

	private void copyFiles(File f, String dir) throws IOException {
		File[] files = f.listFiles();
		for (File ff : files) {
			if (ff.isDirectory()) {
				new File(dir + "/" + ff.getName()).mkdir();
				copyFiles(ff, dir + "/" + ff.getName());
			} else {
				copy(ff.getAbsolutePath(), dir + "/" + ff.getName());
			}

		}
	}

	public void copy(String srFile, String dtFile) throws FileNotFoundException, IOException {

		File f1 = new File(srFile);
		File f2 = new File(dtFile);

		InputStream in = new FileInputStream(f1);

		OutputStream out = new FileOutputStream(f2);

		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	private void unzip() throws IOException {
		int BUFFER = 2048;
		BufferedOutputStream dest = null;
		BufferedInputStream is = null;
		ZipEntry entry;
		ZipFile zipfile = new ZipFile("update.zip");
		@SuppressWarnings("rawtypes")
		Enumeration e = zipfile.entries();
		(new File(root)).mkdir();
		while (e.hasMoreElements()) {
			entry = (ZipEntry) e.nextElement();
			outText.setText(outText.getText() + "\nExtracting: " + entry);
			if (entry.isDirectory())
				(new File(root + entry.getName())).mkdir();
			else {
				(new File(root + entry.getName())).createNewFile();
				is = new BufferedInputStream(zipfile.getInputStream(entry));
				int count;
				byte data[] = new byte[BUFFER];
				FileOutputStream fos = new FileOutputStream(root + entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = is.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
				is.close();
			}
		}
		zipfile.close();
	}

	private void downloadFile(String link) throws MalformedURLException, IOException {
		URL url = new URL(link);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		long max = conn.getContentLength();
		outText.setText(outText.getText() + "\n" + "Downloding file...\nUpdate Size(compressed): " + max + " Bytes");
		BufferedOutputStream fOut = new BufferedOutputStream(new FileOutputStream(new File("../update.zip")));
		byte[] buffer = new byte[32 * 1024];
		int bytesRead = 0;
		@SuppressWarnings("unused")
		int in = 0;
		while ((bytesRead = is.read(buffer)) != -1) {
			in += bytesRead;
			fOut.write(buffer, 0, bytesRead);
		}
		fOut.flush();
		fOut.close();
		is.close();
		outText.setText(outText.getText() + "\nDownload Complete!");

	}

	private String getDownloadLinkFromHost() throws MalformedURLException, IOException {
		String path = "http://xyfurion.comli.com/HUDEdit/url.html";
		URL url = new URL(path);

		InputStream html = null;

		html = url.openStream();

		int c = 0;
		StringBuilder buffer = new StringBuilder("");

		while (c != -1) {
			c = html.read();
			buffer.append((char) c);

		}
		return buffer.substring(buffer.indexOf("[url]") + 5, buffer.indexOf("[/url]"));
	}

	static File file = new File("bin/settings.cfg");
	static String string;
	static List<String> list = new ArrayList<String>();
	static String[] stringArray;
	static String[] split;
	static String versionRead = "No Version";

	public static void readVersion() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new FileReader(file.getPath()));
		while ((string = in.readLine()).startsWith("build-version")) {
			split = string.split(": ");
			versionRead = split[1];
			System.out.println(versionRead);
		}
	}

	public static void saveSettings() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new FileReader(file.getPath()));
		while ((string = in.readLine()) != null) {
			list.add(string);
		}
		stringArray = list.toArray(new String[0]);
	}

	public static void rewriteSettings() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("bin/settings.cfg"));
		for (String line : stringArray) {
			writer.write(line);
			writer.newLine();
		}

		BufferedWriter versionWriter = new BufferedWriter(new FileWriter("bin/settings.cfg"));
		versionWriter.write("build-version: " + versionRead);
		versionWriter.close();
		writer.close();
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ExUpdateUI().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}