package db_hud;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class UpdateUI extends Dialog {

	protected static Object result;
	protected static Shell updateUI;
	public static String updateText;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public UpdateUI(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public static Object open() {
		try {
			createContents();
		} catch (Exception e) {
			e.printStackTrace();
			HUD_Maker.logger.info("ERROR: " + e.toString());
		}
		updateUI.open();
		updateUI.layout();
		Display display = updateUI.getDisplay();
		while (!updateUI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private static void createContents() throws Exception {
		updateUI = new Shell(updateUI, SWT.BORDER | SWT.TITLE);
		updateUI.setMinimumSize(new Point(135, 30));
		updateUI.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		updateUI.setSize(450, 320 + Update.getYPlus());
		updateUI.setText("Update Available!");

		Label lblChangelog = new Label(updateUI, SWT.NONE);
		lblChangelog.setFont(SWTResourceManager.getFont("Trebuchet MS", 12, SWT.NORMAL));
		lblChangelog.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChangelog.setBounds(25, 25, 85, 23);
		lblChangelog.setText("Changelog:");

		ScrolledComposite scrolledComposite = new ScrolledComposite(updateUI, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledComposite.setBounds(25, 54, 395, 180 + Update.getYPlus());
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Composite Composite = new Composite(scrolledComposite, SWT.NONE);
		Composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Browser browser = new Browser(Composite, SWT.NONE);
		// Label changeInfo = new Label(updateInfo, SWT.NONE);
		browser.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		browser.setBounds(0, 0, 391, 176 + Update.getYPlus());
		browser.setText(updateText);

		scrolledComposite.setContent(Composite);
		scrolledComposite.setMinSize(Composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		Button btnUpdateNow = new Button(updateUI, SWT.NONE);
		btnUpdateNow.setBounds(345, 255 + Update.getYPlus(), 75, 25);
		btnUpdateNow.setText("Update Now");
		btnUpdateNow.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				update();
			}
		});

		Button btnUpdateLater = new Button(updateUI, SWT.NONE);
		btnUpdateLater.setBounds(25, 255 + Update.getYPlus(), 75, 25);
		btnUpdateLater.setText("Update Later");
		btnUpdateLater.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateUI.close();
			}
		});
	}

	private static void update() {
		File jarFile = new File("update.jar");
		File exeFile = new File("update.exe");

		if (jarFile.exists()) {
			String run = "update.jar";
			try {
				Runtime.getRuntime().exec(run);
			} catch (Exception ex) {
				ex.printStackTrace();
				HUD_Maker.logger.info("ERROR: " + ex.toString());
			}
		} else if (exeFile.exists()) {
			String runExe = "update.exe";
			try {
				Runtime.getRuntime().exec(runExe);
			} catch (Exception ex) {
				ex.printStackTrace();
				HUD_Maker.logger.info("ERROR: " + ex.toString());
			}
		}
		System.exit(0);
	}

}
