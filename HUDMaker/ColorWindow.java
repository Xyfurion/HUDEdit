package db_hud;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class ColorWindow extends Dialog {

	protected static Object result;
	protected static Shell colorUI;
	protected static Composite colorPreview;
	protected static Scale scRed;
	protected static Scale scGreen;
	protected static Scale scBlue;
	protected static Scale scAlpha;
	public static int R;
	public static int G;
	public static int B;
	public static int A;
	public static Label mRed;
	public static Label mGreen;
	public static Label mBlue;
	public static Label mAlpha;
	private static Button btnOkay;
	private static Button btnCancel;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ColorWindow(Shell parent, int style) {
		super(parent, style);
		setText("Color Options");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	protected int getShellStyle()
	{
	    return super.getStyle() & (~SWT.RESIZE);
	}
	public static Object open() {
		colorUI = new Shell(SWT.BORDER | SWT.CLOSE | SWT.SYSTEM_MODAL | SWT.ON_TOP);
		colorUI.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		colorUI.setSize(580, 324);
		colorUI.setText("Color Options");
		colorUI.setImage(HUD_Maker.icon);
		createContents();
		colorUI.open();
		colorUI.layout();
		Display display = colorUI.getDisplay();
		colorUI.setActive();
		colorUI.setFocus();
		
		colorPreview.setBackground(SWTResourceManager.getColor(Options.cr.ColorR, Options.cr.ColorG, Options.cr.ColorB));
		scRed.setSelection(Options.cr.ColorR);
		scGreen.setSelection(Options.cr.ColorG);
		scBlue.setSelection(Options.cr.ColorB);
		scAlpha.setSelection(Options.cr.ColorA);
		mRed.setText(Integer.toString(Options.cr.ColorR));
		mGreen.setText(Integer.toString(Options.cr.ColorG));
		mBlue.setText(Integer.toString(Options.cr.ColorB));
		mAlpha.setText(Integer.toString(Options.cr.ColorA));
		
		while (!colorUI.isDisposed()) {
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
		
		colorPreview = new Composite(colorUI, SWT.BORDER);
		colorPreview.setBounds(10, 23, 85, 226);
		
		scRed = new Scale(colorUI, SWT.NONE);
		scRed.setMaximum(255);
		scRed.setMinimum(0);
		scRed.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		scRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scRed.setBounds(244, 34, 324, 42);
		scRed.setIncrement(1);
		scRed.setPageIncrement(10);
		scRed.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				R = scRed.getSelection();
				mRed.setText(Integer.toString(scRed.getSelection()));
				colorPreview.setBackground(SWTResourceManager.getColor(R, G, B));
			}
		});
		
		mRed = new Label(colorUI, SWT.NONE);
		mRed.setAlignment(SWT.RIGHT);
		mRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		mRed.setBounds(180, 47, 55, 15);
		mRed.setText("0");

		scGreen = new Scale(colorUI, SWT.NONE);
		scGreen.setMaximum(255);
		scGreen.setMinimum(0);
		scGreen.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		scGreen.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scGreen.setBounds(244, 84, 324, 42);
		scGreen.setIncrement(1);
		scGreen.setPageIncrement(10);
		scGreen.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				G = scGreen.getSelection();
				mGreen.setText(Integer.toString(scGreen.getSelection()));
				colorPreview.setBackground(SWTResourceManager.getColor(R, G, B));
			}
		});
		
		mGreen = new Label(colorUI, SWT.NONE);
		mGreen.setAlignment(SWT.RIGHT);
		mGreen.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		mGreen.setText("0");
		mGreen.setBounds(180, 97, 55, 15);
		
		scBlue = new Scale(colorUI, SWT.NONE);
		scBlue.setMaximum(255);
		scBlue.setMinimum(0);
		scBlue.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		scBlue.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scBlue.setBounds(244, 138, 324, 42);
		scBlue.setIncrement(1);
		scBlue.setPageIncrement(10);
		scBlue.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				B = scBlue.getSelection();
				mBlue.setText(Integer.toString(scBlue.getSelection()));
				colorPreview.setBackground(SWTResourceManager.getColor(R, G, B));
			}
		});
		
		mBlue = new Label(colorUI, SWT.NONE);
		mBlue.setAlignment(SWT.RIGHT);
		mBlue.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		mBlue.setText("0");
		mBlue.setBounds(180, 151, 55, 15);
		
		scAlpha = new Scale(colorUI, SWT.NONE);
		scAlpha.setMaximum(255);
		scAlpha.setMinimum(0);
		scAlpha.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		scAlpha.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scAlpha.setBounds(244, 192, 324, 42);
		scAlpha.setIncrement(1);
		scAlpha.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				A = scAlpha.getSelection();
				mAlpha.setText(Integer.toString(scAlpha.getSelection()));
			}
		});
		
		btnOkay = new Button(colorUI, SWT.NONE);
		btnOkay.setBounds(300, 261, 80, 30);
		btnOkay.setText("Okay");
		btnOkay.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				Options.cr.ColorR = R;
				Options.cr.ColorG = G;
				Options.cr.ColorB = B;
				Options.cr.ColorA = A;
				Options.colorPreview.setBackground(SWTResourceManager.getColor(R, G, B));
				colorUI.close();
			}
		});
		
		btnCancel = new Button(colorUI, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.setBounds(195, 261, 80, 30);
		btnCancel.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				Options.colorPreview.setBackground(SWTResourceManager.getColor(Options.cr.ColorR, Options.cr.ColorG, Options.cr.ColorB));
				R = Options.cr.ColorR;
				G = Options.cr.ColorG;
				B = Options.cr.ColorB;
				A = Options.cr.ColorA;
				colorUI.close();
			}
		});
		
		mAlpha = new Label(colorUI, SWT.NONE);
		mAlpha.setAlignment(SWT.RIGHT);
		mAlpha.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		mAlpha.setText("0");
		mAlpha.setBounds(180, 206, 55, 15);
		
		Label lblRed = new Label(colorUI, SWT.NONE);
		lblRed.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRed.setBounds(123, 47, 55, 15);
		lblRed.setText("Red");
		
		Label lblGreen = new Label(colorUI, SWT.NONE);
		lblGreen.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblGreen.setText("Green");
		lblGreen.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGreen.setBounds(123, 97, 55, 15);
		
		Label lblBlue = new Label(colorUI, SWT.NONE);
		lblBlue.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblBlue.setText("Blue");
		lblBlue.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBlue.setBounds(123, 151, 55, 15);
		
		Label lblAlpha = new Label(colorUI, SWT.NONE);
		lblAlpha.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblAlpha.setText("Alpha");
		lblAlpha.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblAlpha.setBounds(123, 206, 55, 15);
		
		
	}
}
