package db_hud;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Spinner;

public class Settings extends Dialog {

	public static Display display;

	public static Object result;
	public static Shell settings;
	public static Boolean isMouseDown = false;
	public static int xPos;
	public static int yPos;

	public static String[] rSplitted;
	public static String[] wSplitted;

	public static Boolean showGrid = true;
	public static Boolean snapGrid = true;
	public static Boolean showCenter = true;
	public static Boolean sG = true;
	public static Boolean matchResWnd = true;
	public static Boolean keepDefault = false;
	public static int resRatio = 169;
	public static int gridSize = 20;
	public static int optionsAlpha;
	public static int windowX;
	public static int windowY;
	public static int optionsY;
	public static String buildVersion = "2.0.0";

	public static File configFile = new File("bin/settings.cfg");
	public static String[] configText = {
			"build-version: 2.0.0", 
			"resolution-x: 1280", 
			"resolution-y: 720",
			"match-res-wnd: true", 
			"keep-default: false", 
			"window-x: 1280", 
			"window-y: 720", 
			"options-y: 550",
			"options-alpha: 255", 
			"show-grid: true", 
			"show-center: true", 
			"snap-grid: true", 
			"grid-size: 20" };

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public Settings(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public static Object open() {
		createContents();
		settings.open();
		settings.layout();
		display = settings.getDisplay();
		settings.setVisible(false);

		while (!settings.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	public static void settingsRead() {
		if (!configFile.exists()) {
			List<String> lines = Arrays.asList(configText);
			Path path = Paths.get(configFile.getPath());
			try {
				Files.write(path, lines, Charset.forName("UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
				HUD_Maker.logger.info("ERROR: " + e.toString());
			}
		}
		try {
			FileReader fr = new FileReader(configFile.getPath());
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				rSplitted = line.split(": ");
				System.out.println(rSplitted[0] + ": " + rSplitted[1]);
				if (rSplitted[0].equals("build-version")) {
					buildVersion = rSplitted[1];
				} else if (rSplitted[0].equals("resolution-ratio")) {
					resRatio = Integer.parseInt(rSplitted[1]);
				} else if (rSplitted[0].equals("resolution-x")) {
					HUD_Maker.compX = Integer.parseInt(rSplitted[1]);
				} else if (rSplitted[0].equals("resolution-y")) {
					HUD_Maker.compY = Integer.parseInt(rSplitted[1]);
				} else if (rSplitted[0].equals("match-res-wnd")) {
					matchResWnd = Boolean.parseBoolean(rSplitted[1]);
				} else if (rSplitted[0].equals("keep-default")) {
					keepDefault = Boolean.parseBoolean(rSplitted[1]);
				} else if (rSplitted[0].equals("window-x")) {
					windowX = Integer.parseInt(rSplitted[1]);
				} else if (rSplitted[0].equals("window-y")) {
					windowY = Integer.parseInt(rSplitted[1]);
				} else if (rSplitted[0].equals("options-y")) {
					optionsY = Integer.parseInt(rSplitted[1]);
				} else if (rSplitted[0].equals("options-alpha")) {
					optionsAlpha = Integer.parseInt(rSplitted[1]);
				} else if (rSplitted[0].equals("show-grid")) {
					showGrid = Boolean.parseBoolean(rSplitted[1]);
				} else if (rSplitted[0].equals("show-center")) {
					showCenter = Boolean.parseBoolean(rSplitted[1]);
				} else if (rSplitted[0].equals("snap-grid")) {
					snapGrid = Boolean.parseBoolean(rSplitted[1]);
				} else if (rSplitted[0].equals("grid-size")) {
					gridSize = Integer.parseInt(rSplitted[1]);
				}
			}
			System.out.println(keepDefault + "*");
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file '" + configFile.getPath() + "'");
			HUD_Maker.logger.info("Unable to open file '" + configFile.getPath() + "'");
		} catch (IOException e) {
			System.out.println("Error reading file '" + configFile.getPath() + "'");
			HUD_Maker.logger.info("Error reading file '" + configFile.getPath() + "'");
		}
	}

	public static void settingsWrite() throws IOException {
		try {
			FileWriter fw = new FileWriter(configFile.getPath());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("build-version: " + buildVersion);
			bw.newLine();
			bw.write("resolution-ratio: " + resRatio);
			bw.newLine();
			bw.write("resolution-y: " + HUD_Maker.compY);
			bw.newLine();
			bw.write("resolution-x: " + HUD_Maker.compX);
			bw.newLine();
			bw.write("match-res-wnd: " + matchResWnd);
			bw.newLine();
			bw.write("keep-default: " + keepDefault);
			bw.newLine();
			bw.write("window-x: " + windowX);
			bw.newLine();
			bw.write("window-y: " + windowY);
			bw.newLine();
			bw.write("options-y: " + optionsY);
			bw.newLine();
			bw.write("options-alpha: " + optionsAlpha);
			bw.newLine();
			bw.write("show-grid: " + showGrid);
			bw.newLine();
			bw.write("show-center: " + showCenter);
			bw.newLine();
			bw.write("snap-grid: " + snapGrid);
			bw.newLine();
			bw.write("grid-size: " + gridSize);
			bw.newLine();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file '" + configFile.getPath() + "'");
			HUD_Maker.logger.info("Unable to open file '" + configFile.getPath() + "'");
		} catch (IOException e) {
			System.out.println("Error reading file '" + configFile.getPath() + "'");
			HUD_Maker.logger.info("Error reading file '" + configFile.getPath() + "'");
		}
	}

	/**
	 * Create contents of the dialog.
	 */
	public static void createContents() {
		settings = new Shell(settings, SWT.NONE | SWT.ON_TOP);
		settings.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		settings.setSize(361, 389);
		settings.setText("Settings");
		settings.setFocus();
		settings.setActive();

		Button btnShowGrid = new Button(settings, SWT.CHECK);
		btnShowGrid.setSelection(true);
		btnShowGrid.setBounds(245, 44, 93, 16);
		btnShowGrid.setText("Show Grid");
		btnShowGrid.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnShowGrid.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if (btn.getSelection() == true) {
					HUD_Maker.showGrid();
					showGrid = true;
				} else {
					HUD_Maker.hideGrid();
					showGrid = false;
				}
			}
		});
		if (showGrid == true) {
			btnShowGrid.setSelection(true);
		} else {
			btnShowGrid.setSelection(false);
		}

		Label lblGridSettings = new Label(settings, SWT.NONE);
		lblGridSettings.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGridSettings.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblGridSettings.setBounds(22, 44, 114, 21);
		lblGridSettings.setText("Grid Settings");
		lblGridSettings.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnSnapToGrid = new Button(settings, SWT.CHECK);
		btnSnapToGrid.setSelection(true);
		btnSnapToGrid.setBounds(245, 84, 93, 16);
		btnSnapToGrid.setText("Snap to Grid");
		btnSnapToGrid.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnSnapToGrid.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if (btn.getSelection() == true) {
					sG = true;
				} else {
					sG = false;
				}
			}
		});
		if (snapGrid == true) {
			btnSnapToGrid.setSelection(true);
		} else {
			btnSnapToGrid.setSelection(false);
		}

		Button btnShowCenter = new Button(settings, SWT.CHECK);
		btnShowCenter.setSelection(true);
		btnShowCenter.setBounds(245, 64, 93, 16);
		btnShowCenter.setText("Show Center");
		btnShowCenter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnShowCenter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if (btn.getSelection() == true) {
					showCenter = true;
				} else {
					showCenter = false;
				}
			}
		});
		if (showCenter == true) {
			btnShowCenter.setSelection(true);
		} else {
			btnShowCenter.setSelection(false);
		}

		Label lblResWind = new Label(settings, SWT.NONE);
		lblResWind.setText("Resolution and Window");
		lblResWind.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblResWind.setBounds(22, 141, 147, 21);
		lblResWind.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnRevertSettings = new Button(settings, SWT.NONE);
		btnRevertSettings.setBounds(103, 343, 93, 25);
		btnRevertSettings.setText("Revert Settings");
		btnRevertSettings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RevertDialog.open();
			}
		});

		Button btnChangeRes = new Button(settings, SWT.NONE);
		btnChangeRes.setBounds(194, 138, 144, 25);
		btnChangeRes.setText("Change Resolution");
		btnChangeRes.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnChangeRes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				keepDefault = false;
				try {
					settingsWrite();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					HUD_Maker.logger.info("ERROR: " + e1.toString());
				}

				File jarFile = new File("bin/reset/reset.jar");
				File exeFile = new File("bin/reset/reset.exe");

				if (jarFile.exists()) {
					String runJar = ("bin/reset/reset.jar");
					try {
						Runtime.getRuntime().exec(runJar);
					} catch (Exception ex) {
						ex.printStackTrace();
						HUD_Maker.logger.info("ERROR: " + ex.toString());
					}
				} else if (exeFile.exists()) {
					String runExe = "bin/reset/reset.exe";
					try {
						Runtime.getRuntime().exec(runExe);
					} catch (Exception ex) {
						ex.printStackTrace();
						HUD_Maker.logger.info("ERROR: " + ex.toString());
					}
				}
				System.exit(0);
			}
		});

		Label lblWindowSize = new Label(settings, SWT.NONE);
		lblWindowSize.setBounds(22, 178, 75, 15);
		lblWindowSize.setText("Window Size");
		lblWindowSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Spinner spOpWinH = new Spinner(settings, SWT.BORDER);
		spOpWinH.setMaximum(9999);
		spOpWinH.setMinimum(Options.Options_UI.getSize().y);
		spOpWinH.setBounds(273, 299, 65, 22);
		spOpWinH.setSelection(optionsY);

		Spinner winH = new Spinner(settings, SWT.BORDER);
		winH.setBounds(194, 175, 65, 22);
		winH.setSelection(windowY);

		Spinner winW = new Spinner(settings, SWT.BORDER);
		winW.setBounds(273, 175, 65, 22);
		winW.setSelection(windowX);

		Label lblOpWinOpacity = new Label(settings, SWT.NONE);
		lblOpWinOpacity.setBounds(22, 210, 133, 15);
		lblOpWinOpacity.setText("Options Window Opacity");
		lblOpWinOpacity.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label opacity = new Label(settings, SWT.NONE);
		opacity.setBounds(22, 254, 27, 15);
		opacity.setText("255");
		opacity.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Scale scale = new Scale(settings, SWT.NONE);
		scale.setPageIncrement(5);
		scale.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scale.setMaximum(255);
		scale.setMinimum(100);
		scale.setSelection(255);
		scale.setBounds(55, 242, 283, 42);
		scale.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				opacity.setText(Integer.toString(scale.getSelection()));
			}
		});

		Label lblGridSize = new Label(settings, SWT.NONE);
		lblGridSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGridSize.setBounds(22, 109, 55, 15);
		lblGridSize.setText("Grid Size:");

		Spinner gridsize = new Spinner(settings, SWT.BORDER);
		gridsize.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		gridsize.setBounds(291, 106, 47, 22);
		gridsize.setSelection(gridSize);

		Label lblOpWinH = new Label(settings, SWT.NONE);
		lblOpWinH.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblOpWinH.setBounds(22, 302, 147, 15);
		lblOpWinH.setText("Options Window Height");

		Button btnOkay = new Button(settings, SWT.NONE);
		btnOkay.setBounds(263, 343, 75, 25);
		btnOkay.setText("Okay");
		btnOkay.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (showGrid == true) {
					HUD_Maker.showGrid();
				} else {
					HUD_Maker.hideGrid();
				}

				if (showCenter == true) {
					HUD_Maker.lineH.setVisible(true);
					HUD_Maker.lineV.setVisible(true);
				} else {
					HUD_Maker.lineH.setVisible(false);
					HUD_Maker.lineV.setVisible(false);
				}

				if (sG == true) {
					snapGrid = true;
				} else {
					snapGrid = false;
				}

				optionsY = spOpWinH.getSelection();

				windowY = winH.getSelection();

				windowX = winW.getSelection();

				optionsAlpha = scale.getSelection();

				gridSize = gridsize.getSelection();

				try {
					// set all the values
					Options.Options_UI.setAlpha(optionsAlpha);
					settingsWrite();
				} catch (IOException e1) {
					e1.printStackTrace();
					HUD_Maker.logger.info("ERROR: " + e1.toString());
				}
				settings.setVisible(false);
			}
		});

		Button btnCancel = new Button(settings, SWT.NONE);
		btnCancel.setBounds(22, 343, 75, 25);
		btnCancel.setText("Close");
		btnCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				settings.setVisible(false);
				// Reset to what the options were before (NOT DEFAULT!!!)
			}
		});

		Composite dragbar = new Composite(settings, SWT.NONE);
		dragbar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		dragbar.setBounds(0, 0, 359, 25);
		dragbar.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
				settings.setMinimized(true);
			}

			public void mouseDown(MouseEvent e) {
				isMouseDown = true;
				xPos = e.x;
				yPos = e.y;
			}

			public void mouseUp(MouseEvent e) {
				isMouseDown = false;
			}
		});
		dragbar.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				if (isMouseDown == true) {
					settings.setLocation(settings.getLocation().x + (e.x - xPos),
							settings.getLocation().y + (e.y - yPos));
				}
			}
		});

	}

	public static void resetSettings() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("bin/settings.cfg"));
		try {
			configFile.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
			HUD_Maker.logger.info("ERROR: " + ex.toString());
		}
		// Loop over the elements in the string array and write each line.
		for (String line : configText) {
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}

}
