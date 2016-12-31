package db_hud;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class RevertDialog extends Dialog {

	protected static Object result;
	protected static Shell shlConfirmSettingsReset;
	protected static Display display;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public RevertDialog(Shell parent, int style) {
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
		shlConfirmSettingsReset.open();
		shlConfirmSettingsReset.layout();
		display = shlConfirmSettingsReset.getDisplay();
		while (!shlConfirmSettingsReset.isDisposed()) {
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
		shlConfirmSettingsReset = new Shell(display, SWT.NONE | SWT.ON_TOP);
		shlConfirmSettingsReset.setActive();
		shlConfirmSettingsReset.setFocus();
		shlConfirmSettingsReset.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlConfirmSettingsReset.setSize(400, 120);
		shlConfirmSettingsReset.setText("Confirm Settings Reset");

		Label lblAreYouSure = new Label(shlConfirmSettingsReset, SWT.NONE);
		lblAreYouSure.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblAreYouSure.setBounds(13, 22, 374, 15);
		lblAreYouSure.setText("Are you sure you want to revert your settings? Note: Restart Required.");

		Label lblthisActionCannot = new Label(shlConfirmSettingsReset, SWT.NONE);
		lblthisActionCannot.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblthisActionCannot.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.ITALIC));
		lblthisActionCannot.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblthisActionCannot.setBounds(126, 43, 151, 15);
		lblthisActionCannot.setText("(This action cannot be undone)");

		Button btnRevertSettings = new Button(shlConfirmSettingsReset, SWT.NONE);
		btnRevertSettings.setBounds(224, 74, 90, 25);
		btnRevertSettings.setText("Revert Settings");
		btnRevertSettings.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					Settings.resetSettings();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				File jarFile = new File("reset/reset.jar");
				File exeFile = new File("reset/reset.exe");
				if (jarFile.exists()) {
					String runJar = "reset/reset.jar";
					try {
						Runtime.getRuntime().exec(runJar);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else if (exeFile.exists()) {
					String runExe = "reset/reset.exe";
					try {
						Runtime.getRuntime().exec(runExe);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				System.exit(0);
			}
		});

		Button btnCancel = new Button(shlConfirmSettingsReset, SWT.NONE);
		btnCancel.setBounds(80, 74, 75, 25);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shlConfirmSettingsReset.close();
			}
		});

	}
}
