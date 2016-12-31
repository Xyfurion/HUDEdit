package db_hud;

import org.eclipse.wb.swt.SWTResourceManager;

public class Asset {

	public String Name;

	public int posX;
	public int OposX;
	public int posY;
	public int OposY;

	public int sosX;
	public int OsosX;
	public int sosY;
	public int OsosY;

	public int imageX;
	public int imageY;

	public String AlignH;
	public String OAlignH;
	public String AlignV;
	public String OAlignV;

	public String AttachH;
	public String OAttachH;
	public String AttachV;
	public String OAttachV;

	public String cAlignH;
	public String OcAlignH;
	public String cAlignV;
	public String OcAlignV;
	public String cAttachH;
	public String OcAttachH;
	public String cAttachV;
	public String OcAttachV;

	public int ColorR;
	public int OColorR;
	public int ColorG;
	public int OColorG;
	public int ColorB;
	public int OColorB;
	public int ColorA;
	public int OColorA;

	public int Value;
	public int OValue;

	public void reset() {
		if (Options.type == 1) {
			Options.cr.AlignH = Options.cr.OAlignH;
			if (Options.cr.OAlignH == Options.Right) {
				Options.Align_H.setText("Right");
			} else if (Options.cr.OAlignH == Options.Center) {
				Options.Align_H.setText("Center");
			} else if (Options.cr.OAlignH == Options.Left) {
				Options.Align_H.setText("Left");
			}

			Options.cr.AlignV = Options.cr.OAlignV;
			if (Options.cr.OAlignV == Options.Top) {
				Options.Align_V.setText("Top");
			} else if (Options.cr.OAlignV == Options.Center) {
				Options.Align_V.setText("Center");
			} else if (Options.cr.OAlignV == Options.Bottom) {
				Options.Align_V.setText("Bottom");
			}

			Options.cr.AttachV = Options.cr.OAttachH;
			if (Options.cr.OAttachH == Options.Right) {
				Options.Attach_H.setText("Right");
			} else if (Options.cr.OAttachH == Options.Center) {
				Options.Attach_H.setText("Center");
			} else if (Options.cr.OAttachH == Options.Left) {
				Options.Attach_H.setText("Left");
			}

			Options.cr.AttachV = Options.cr.OAttachV;
			if (Options.cr.OAttachV == Options.Top) {
				Options.Attach_V.setText("Top");
			} else if (Options.cr.OAttachV == Options.Center) {
				Options.Attach_V.setText("Center");
			} else if (Options.cr.OAttachV == Options.Bottom) {
				Options.Attach_V.setText("Bottom");
			}

			Options.cr.posX = Options.cr.OposX;
			Options.pox.setSelection(Options.cr.OposX);

			Options.cr.posY = Options.cr.OposY;
			Options.poy.setSelection(Options.cr.OposY);

		} else if (Options.type == 2) {
			Options.cr.AlignH = Options.cr.OAlignH;
			if (Options.cr.OAlignH == Options.Right) {
				Options.Align_H.setText("Right");
			} else if (Options.cr.OAlignH == Options.Center) {
				Options.Align_H.setText("Center");
			} else if (Options.cr.OAlignH == Options.Left) {
				Options.Align_H.setText("Left");
			}

			Options.cr.AlignV = Options.cr.OAlignV;
			if (Options.cr.OAlignV == Options.Top) {
				Options.Align_V.setText("Top");
			} else if (Options.cr.OAlignV == Options.Center) {
				Options.Align_V.setText("Center");
			} else if (Options.cr.OAlignV == Options.Bottom) {
				Options.Align_V.setText("Bottom");
			}

			Options.cr.AttachV = Options.cr.OAttachH;
			if (Options.cr.OAttachH == Options.Right) {
				Options.Attach_H.setText("Right");
			} else if (Options.cr.OAttachH == Options.Center) {
				Options.Attach_H.setText("Center");
			} else if (Options.cr.OAttachH == Options.Left) {
				Options.Attach_H.setText("Left");
			}

			Options.cr.AttachV = Options.cr.OAttachV;
			if (Options.cr.OAttachV == Options.Top) {
				Options.Attach_V.setText("Top");
			} else if (Options.cr.OAttachV == Options.Center) {
				Options.Attach_V.setText("Center");
			} else if (Options.cr.OAttachV == Options.Bottom) {
				Options.Attach_V.setText("Bottom");
			}

			Options.cr.posX = Options.cr.OposX;
			Options.pox.setSelection(Options.cr.OposX);

			Options.cr.posY = Options.cr.OposY;
			Options.poy.setSelection(Options.cr.OposY);

			Options.cr.sosX = Options.cr.OsosX;
			Options.sox.setSelection(Options.cr.OsosX);

			Options.cr.sosY = Options.cr.OsosY;
			Options.soy.setSelection(Options.cr.OsosY);
		} else if (Options.type == 3) {
			Options.cr.Value = Options.cr.OValue;
			Options.value.setSelection(Options.cr.Value);
		} else if (Options.type == 4) {
			Options.cr.ColorR = Options.cr.OColorR;
			Options.cr.ColorG = Options.cr.OColorG;
			Options.cr.ColorB = Options.cr.OColorB;
			Options.cr.ColorA = Options.cr.OColorA;
			Options.colorPreview.setBackground(
					SWTResourceManager.getColor(Options.cr.ColorR, Options.cr.ColorG, Options.cr.ColorB));
			ColorWindow.R = Options.cr.ColorR;
			ColorWindow.G = Options.cr.ColorG;
			ColorWindow.B = Options.cr.ColorB;
			ColorWindow.A = Options.cr.ColorA;
			ColorWindow.mRed.setText(Integer.toString(Options.cr.ColorR));
			ColorWindow.mGreen.setText(Integer.toString(Options.cr.ColorG));
			ColorWindow.mBlue.setText(Integer.toString(Options.cr.ColorB));
			ColorWindow.mAlpha.setText(Integer.toString(Options.cr.ColorA));
			ColorWindow.scRed.setSelection(Options.cr.ColorR);
			ColorWindow.scGreen.setSelection(Options.cr.ColorG);
			ColorWindow.scBlue.setSelection(Options.cr.ColorB);
			ColorWindow.scAlpha.setSelection(Options.cr.ColorA);
		}
	}

	public void resetAll() {
		if (Options.type == 1) {
			Options.asset.AlignH = Options.asset.OAlignH;
			Options.asset.AlignV = Options.asset.OAlignV;
			Options.asset.AttachV = Options.asset.OAttachH;
			Options.asset.AttachV = Options.asset.OAttachV;
			Options.asset.posX = Options.asset.OposX;
			Options.asset.posY = Options.asset.OposY;

		} else if (Options.type == 2) {
			Options.asset.AlignH = Options.asset.OAlignH;
			Options.asset.AlignV = Options.asset.OAlignV;
			Options.asset.AttachV = Options.asset.OAttachH;
			Options.asset.AttachV = Options.asset.OAttachV;
			Options.asset.posX = Options.asset.OposX;
			Options.asset.posY = Options.asset.OposY;
			Options.asset.sosX = Options.asset.OsosX;
			Options.asset.sosY = Options.asset.OsosY;
		} else if (Options.type == 3) {
			Options.asset.Value = Options.asset.OValue;
		} else if (Options.type == 4) {
			Options.asset.ColorR = Options.asset.OColorR;
			Options.asset.ColorG = Options.asset.OColorG;
			Options.asset.ColorB = Options.asset.OColorB;
			Options.asset.ColorA = Options.asset.OColorA;
		}
	}
}