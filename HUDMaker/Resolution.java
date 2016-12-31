package db_hud;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

public class Resolution extends Dialog {

	public static Object result;
	public static Shell resDialog;
	public static Combo combo_ratio;
	public static Combo combo_res;
	public static Button btnOkay;
	public static Display display;

	private static Spinner width;
	private static Spinner height;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */

	public Resolution(Shell parent) {
		super(parent);
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public static Object open() {

		createContents();
		resDialog.open();
		resDialog.layout();
		display = resDialog.getDisplay();
		while (!resDialog.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;

	}

	/**
	 * Create contents of the dialog.
	 */
	private static void createContents() {
		resDialog = new Shell(resDialog);
		resDialog.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		resDialog.setSize(450, 300);
		resDialog.setText("Select Resolution");
		resDialog.setImage(HUD_Maker.icon);
		
		Label lbl_selectRes = new Label(resDialog, SWT.NONE);
		lbl_selectRes.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_selectRes.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lbl_selectRes.setBounds(164, 23, 106, 15);
		lbl_selectRes.setText("Select Resolution");

		Label lbl_ratio = new Label(resDialog, SWT.NONE);
		lbl_ratio.setBounds(96, 63, 55, 15);
		lbl_ratio.setText("Ratio");
		lbl_ratio.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lbl_res = new Label(resDialog, SWT.NONE);
		lbl_res.setText("Resolution");
		lbl_res.setBounds(96, 97, 66, 15);
		lbl_res.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		combo_res = new Combo(resDialog, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo_res.setEnabled(false);
		combo_res.setBounds(168, 92, 169, 23);

		combo_ratio = new Combo(resDialog, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo_ratio.setItems(new String[] { "4:3", "5:3", "5:4", "16:9", "16:10" });
		combo_ratio.setBounds(168, 60, 169, 23);
		combo_ratio.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (combo_ratio.getText().equals("4:3")) {
					combo_res.setEnabled(true);
					combo_res.setItems(
							new String[] { "800 x 600", "1024 x 768", "1152 x 864", "1280 x 960", "1600 x 1200" });
				}

				else if (combo_ratio.getText().equals("5:3")) {
					combo_res.setEnabled(true);
					combo_res.setItems(new String[] { "1280 x 768" });
				}

				else if (combo_ratio.getText().equals("5:4")) {
					combo_res.setEnabled(true);
					combo_res.setItems(new String[] { "720 x 560", "1280 x 1024" });
				} else if (combo_ratio.getText().equals("16:9")) {
					combo_res.setEnabled(true);
					combo_res.setItems(new String[] { "1280 x 720", "1360 x 768", "1366 x 768", "1536 x 864",
							"1600 x 900", "1920 x 1080", "2560 x 1440", "3840 x 2160" });
				} else if (combo_ratio.getText().equals("16:10")) {
					combo_res.setEnabled(true);
					combo_res.setItems(
							new String[] { "1280 x 800", "1440 x 900", "1680 x 1050", "1920 x 1200", "2560 x 1600" });
				} else {
					combo_res.setEnabled(false);
				}
			}
		});
		
		combo_ratio.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!combo_ratio.getText().equals(null)) {
					btnOkay.setEnabled(true);
				}
			}
		});

		Label lblWindowSize = new Label(resDialog, SWT.NONE);
		lblWindowSize.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblWindowSize.setBounds(96, 171, 75, 15);
		lblWindowSize.setText("Window Size");
		lblWindowSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		width = new Spinner(resDialog, SWT.BORDER);
		width.setEnabled(false);
		width.setBounds(173, 168, 76, 21);
		width.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));

		height = new Spinner(resDialog, SWT.BORDER);
		height.setEnabled(false);
		height.setBounds(262, 168, 76, 21);
		height.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));

		Button btnDefault = new Button(resDialog, SWT.CHECK);
		btnDefault.setBounds(96, 213, 121, 16);
		btnDefault.setText("Use this as default");
		btnDefault.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDefault.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if (btn.getSelection() == true) {
					Settings.keepDefault = true;
					System.out.println(Settings.keepDefault);
					try {
						Settings.settingsWrite();
					} catch (IOException e1) {
						e1.printStackTrace();
						HUD_Maker.logger.info("ERROR: " + e1.toString());
					}
				} else {
					Settings.keepDefault = false;
					System.out.println(Settings.keepDefault);
					try {
						Settings.settingsWrite();
					} catch (IOException e1) {
						e1.printStackTrace();
						HUD_Maker.logger.info("ERROR: " + e1.toString());
					}
				}
			}
		});

		Button linkResToWindow = new Button(resDialog, SWT.CHECK);
		linkResToWindow.setSelection(true);
		linkResToWindow.setEnabled(false);
		linkResToWindow.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		linkResToWindow.setBounds(96, 142, 219, 16);
		linkResToWindow.setText("Match Resolution with Window Size");
		linkResToWindow.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		linkResToWindow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if (btn.getSelection() == true) {
					height.setEnabled(false);
					width.setEnabled(false);
					height.setSelection(0);
					width.setSelection(0);
				} else {
					height.setEnabled(true);
					width.setEnabled(true);
				}
			}
		});

		btnOkay = new Button(resDialog, SWT.NONE);
		btnOkay.setEnabled(false);
		btnOkay.setBounds(262, 209, 75, 25);
		btnOkay.setText("Okay");
		btnOkay.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				// Window Width and Height
				// if (width.getSelection() != 0){HUD_Maker.sizeX =
				// width.getSelection();}
				// if (height.getSelection() != 0){HUD_Maker.sizeY =
				// height.getSelection();}
				// 4:3 Ratio
				if (combo_res.getText().equals("800 x 600")) {
					HUD_Maker.compX = 800;
					HUD_Maker.compY = 600;
					Settings.resRatio = 43;
				} else if (combo_res.getText().equals("1024 x 768")) {
					HUD_Maker.compX = 1024;
					HUD_Maker.compY = 768;
					Settings.resRatio = 43;
				} else if (combo_res.getText().equals("1152 x 864")) {
					HUD_Maker.compX = 1152;
					HUD_Maker.compY = 864;
					Settings.resRatio = 43;
				} else if (combo_res.getText().equals("1280 x 960")) {
					HUD_Maker.compX = 1280;
					HUD_Maker.compY = 960;
					Settings.resRatio = 43;
				} else if (combo_res.getText().equals("1600 x 1200")) {
					HUD_Maker.compX = 1600;
					HUD_Maker.compY = 1200;
					Settings.resRatio = 43;
				}
				// 5:3 Ratio
				else if (combo_res.getText().equals("1280 x 768")) {
					HUD_Maker.compX = 1280;
					HUD_Maker.compY = 768;
					Settings.resRatio = 53;
				}
				// 5:4 Ratio
				else if (combo_res.getText().equals("720 x 560")) {
					HUD_Maker.compX = 720;
					HUD_Maker.compY = 560;
					Settings.resRatio = 54;
				} else if (combo_res.getText().equals("1280 x 1024")) {
					HUD_Maker.compX = 1280;
					HUD_Maker.compY = 1024;
					Settings.resRatio = 54;
				}
				// 16:9 Ratio
				else if (combo_res.getText().equals("1280 x 720")) {
					HUD_Maker.compX = 1280;
					HUD_Maker.compY = 720;
					Settings.resRatio = 169;
				} else if (combo_res.getText().equals("1360 x 768")) {
					HUD_Maker.compX = 1360;
					HUD_Maker.compY = 768;
					Settings.resRatio = 169;
				} else if (combo_res.getText().equals("1366 x 768")) {
					HUD_Maker.compX = 1366;
					HUD_Maker.compY = 768;
					Settings.resRatio = 169;
				} else if (combo_res.getText().equals("1536 x 864")) {
					HUD_Maker.compX = 1536;
					HUD_Maker.compY = 864;
					Settings.resRatio = 169;
				} else if (combo_res.getText().equals("1600 x 900")) {
					HUD_Maker.compX = 1600;
					HUD_Maker.compY = 900;
					Settings.resRatio = 169;
				} else if (combo_res.getText().equals("1920 x 1080")) {
					HUD_Maker.compX = 1920;
					HUD_Maker.compY = 1080;
					Settings.resRatio = 169;
				} else if (combo_res.getText().equals("2560 x 1440")) {
					HUD_Maker.compX = 2560;
					HUD_Maker.compY = 1440;
					Settings.resRatio = 169;
				} else if (combo_res.getText().equals("3840 x 2160")) {
					HUD_Maker.compX = 3840;
					HUD_Maker.compY = 2160;
					Settings.resRatio = 169;
				}
				// 16:10 Ratio
				else if (combo_res.getText().equals("1280 x 800")) {
					HUD_Maker.compX = 1280;
					HUD_Maker.compY = 800;
					Settings.resRatio = 1610;
				} else if (combo_res.getText().equals("1440 x 900")) {
					HUD_Maker.compX = 1440;
					HUD_Maker.compY = 900;
					Settings.resRatio = 1610;
				} else if (combo_res.getText().equals("1680 x 1050")) {
					HUD_Maker.compX = 1680;
					HUD_Maker.compY = 1050;
					Settings.resRatio = 1610;
				} else if (combo_res.getText().equals("1920 x 1200")) {
					HUD_Maker.compX = 1920;
					HUD_Maker.compY = 1200;
					Settings.resRatio = 1610;
				} else if (combo_res.getText().equals("2560 x 1600")) {
					HUD_Maker.compX = 2560;
					HUD_Maker.compY = 1600;
					Settings.resRatio = 1610;
				}

				else {
					HUD_Maker.compX = 1280;
					HUD_Maker.compY = 720;
				}

				try {
					Settings.settingsWrite();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					HUD_Maker.logger.info("ERROR: " + e1.toString());
				}

				resDialog.close();
				display.dispose();
			}
		});

	}
}
