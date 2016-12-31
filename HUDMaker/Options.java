package db_hud;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.wb.swt.SWTResourceManager;

public class Options extends Dialog{

	public Options(Shell parent) {
		super(parent);
	}

	public static Shell Options_UI;
	
	public static Object result;
	
	public static Display d2;
	public static Shell s2;
	
	public static int mode = 0;
	
	public static Spinner pox;
	public static Spinner poy;
	public static Spinner sox;
	public static Spinner soy;
	public static Spinner value;
	
	public static Display displayOp;
	
	public static Cursor cursor_hand = new Cursor(displayOp, SWT.CURSOR_HAND);
	public static Cursor cursor_normal = new Cursor(displayOp, SWT.CURSOR_HAND);
	
	public static Composite colorPreview;
	public static Composite sidePanel;
	public static ScrolledComposite sidePanelComp;
	
	public static String selection;
	
	public static Boolean isMouseDown=false;
	
	public static int type;
	public static int opacity = 255;
	public static int xPos=0;
	public static int yPos=0;
	
	public static int showOS = 0;
	
	//public static int compX = 1280, compY = 720;
	//public static int sizeX = 1280, sizeY = 720;
	//public static int plusX = 14;
	//public static int plusY = 0;
	//public static int mPlusX = 0;
	//public static int mPlusY = 0;
	
	public static Combo HUD_Asset;
	public static Combo Attach_H;
	public static Combo Attach_V;
	public static Combo Align_H;
	public static Combo Align_V;
	public static Combo select_preset;
	
	public static Button btn_color;
	public static Button btn_load;
	public static Button btn_save;
	public static Button btn_modeInGame;
	public static Button btn_modeWarmup;
	public static Button btn_modeSpectator;
	public static Button btn_reset;
	public static Button btn_resetAll;
	public static Button btn_settings;
	
	public static String icon_minimizePath = "bin/db_hud/assets/images/icon_Minimize_DARK.png";
	public static Image icon_minimize;
	public static String icon_closePath = "bin/db_hud/assets/images/icon_Close_DARK.png";
	public static Image icon_close;
	
	public static String image_HUDOptionsPath = "bin/db_hud/assets/images/HUDOptions.png";
	public static Image image_HUDOptions;
	
	public static Scanner ShooterUI;
	
	public static String[] newShooterUI;
	
	public static Asset cr; //Current Reference
	
	public static final String Top = "HA_TOP";
	public static final String Center = "HA_CENTER";
	public static final String Bottom = "HA_BOTTOM";
	public static final String Right = "HA_RIGHT";
	public static final String Left = "HA_LEFT";
	
	public static final String cTop = "Top";
	public static final String cCenter = "Center";
	public static final String cBottom = "Bottom";
	public static final String cRight = "Right";
	public static final String cLeft = "Left";
	
	//Declaring Assets
	
	//HUD
	
	public static Asset ScopeInfo = new Asset();
	public static Asset CnslMsgLog = new Asset();
	public static Asset SpcCnslMsgLog = new Asset();
	public static Asset ChatInput = new Asset();
	public static Asset SpcChatInput = new Asset();
	public static Asset IncapMenu = new Asset();
	public static Asset ObjPro = new Asset();
	public static Asset ObjProNtf = new Asset();
	public static Asset ObjClock = new Asset();
	public static Asset MiniMap = new Asset();
	public static Asset ObitMsg = new Asset();
	public static Asset IntFillBar = new Asset();
	public static Asset XpCounter = new Asset();
	public static Asset GameplayNtf = new Asset();
	public static Asset Subtitles = new Asset();
	public static Asset ObjNtf = new Asset();
	public static Asset GameInfo = new Asset();
	public static Asset SpcInfo = new Asset();
	public static Asset Detected = new Asset();
	public static Asset WeaponAmmo = new Asset();
	public static Asset AbilityCooldown = new Asset();
	public static Asset CarryBomb = new Asset();
	public static Asset PlayerHealth = new Asset();
	public static Asset ShieldBar = new Asset();
	public static Asset ReadyUp = new Asset();
	public static Asset BadgeNtf = new Asset();
	public static Asset DeathInfoCard = new Asset();
	public static Asset SpcGameWaveTimer = new Asset();
	public static Asset GameWaveTimer = new Asset();
	public static Asset ObjPos = new Asset();
	public static Asset SpcObjPos = new Asset();
	public static Asset ActionMenu = new Asset();
	public static Asset SpcActionMenu = new Asset();
	public static Asset CharSelect = new Asset();
	public static Asset SpcCard = new Asset();
	public static Asset ExeGameStat = new Asset();
	public static Asset ExeCountDown = new Asset();
	public static Asset ExeRoundNtf = new Asset();
	public static Asset ExeRoundIntro = new Asset();
	public static Asset DebPos = new Asset();
	public static Asset ExeBadge = new Asset();
	
	//Color
	
	public static Asset AllyColor = new Asset();
	public static Asset AllyColor2 = new Asset();
	public static Asset EnemyColor = new Asset();
	public static Asset NeutralColor = new Asset();
	public static Asset NeutralColor2 = new Asset();
	public static Asset AIColor = new Asset();
	public static Asset PrimaryObjColor = new Asset();
	public static Asset AmmoColor = new Asset();
	public static Asset LowAmmoColor = new Asset();
	public static Asset LowAmmoColor2 = new Asset();
	public static Asset NoAmmoColor = new Asset();
	//public static Asset GrenadeBlinkColor = new Asset();
	//public static Asset GrenadeBlinkColor2 = new Asset();
	//public static Asset GrenadeOOVColor1 = new Asset();
	//public static Asset GrenadeOOVColor2 = new Asset();
	public static Asset PrimaryPerformerColor = new Asset();
	public static Asset MapIconPrimaryColor = new Asset();
	public static Asset MapIconSecondaryColor = new Asset();
	public static Asset AlliedColor = new Asset();
	public static Asset EnemyColor2 = new Asset();
	public static Asset HighlightedBGColor = new Asset();
	public static Asset DefaultBGColor = new Asset();
	//public static Asset BlinkColor = new Asset();
	
	public static ArrayList<Asset> hudAssets = new ArrayList<>();
	
	public static Display display;
	
	//private static Label lblDirtyBombHud;
	private static Label Xyfurion;
	
	public static Asset asset;
	public static Combo combo_Color;
	public static Combo combo_Value;
	private static Button btn_modeExecution;
	
	public static Object open() {
		defaultVariables();
		createContents();
		Options_UI.open();
		Options_UI.layout();
		Options_UI.setVisible(false);
		
		Settings.open();
		
		display = Options_UI.getDisplay();
		while (!Options_UI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
	
	protected static void defaultVariables(){
		//Setting the Default variables
		
		//Type 1 has posX, posY, Align, Attach
		//Type 2 has posX, posY, sosX, sosY, Align, Attach
		//Type 3 has Other Value (blink speed, Amount, etc...)
		//Type 4 has Color (RGBa)
		ScopeInfo.Name = "ScopeInfoPosition"; ScopeInfo.posX = 0; ScopeInfo.posY = 500; ScopeInfo.AlignH = Center; ScopeInfo.AlignV = Top; ScopeInfo.AttachH = Center; ScopeInfo.AttachV = Top; //hudAssets.add(ScopeInfo);
		CnslMsgLog.Name = "ConsoleMessageLogPosition"; CnslMsgLog.posX = 39; CnslMsgLog.posY = 200; CnslMsgLog.AlignH = Left; CnslMsgLog.AlignV = Bottom; CnslMsgLog.AttachH = Left; CnslMsgLog.AttachV = Bottom; hudAssets.add(CnslMsgLog);
		SpcCnslMsgLog.Name = "SpectatorConsoleMessageLog"; SpcCnslMsgLog.posX = 39; SpcCnslMsgLog.posY = 35; SpcCnslMsgLog.AlignH = Left; SpcCnslMsgLog.AlignV = Top; SpcCnslMsgLog.AttachH = Left; SpcCnslMsgLog.AttachV = Top; hudAssets.add(SpcCnslMsgLog);
		ChatInput.Name = "ChatInputPosition"; ChatInput.posX = 39; ChatInput.posY = 180; ChatInput.AlignH = Left; ChatInput.AlignV = Bottom; ChatInput.AttachH = Left; ChatInput.AttachV = Bottom; hudAssets.add(ChatInput);
		SpcChatInput.Name = "SpectatorChatInputPosition"; SpcChatInput.posX = 39; SpcChatInput.posY = 185; SpcChatInput.AlignH = Left; SpcChatInput.AlignV = Top; SpcChatInput.AttachH = Left; SpcChatInput.AttachV = Top; hudAssets.add(SpcChatInput);
		IncapMenu.Name = "IncapMenuPosition"; IncapMenu.posX = 0; IncapMenu.posY = 0; IncapMenu.AlignH = Center; IncapMenu.AlignV = Bottom; IncapMenu.AttachH = Center; IncapMenu.AttachV = Top; //hudAssets.add(IncapMenu);
		ObjPro.Name = "ObjectiveProgressionPosition"; ObjPro.posX = 25; ObjPro.posY = 100; ObjPro.AlignH = Left; ObjPro.AlignV = Top; ObjPro.AttachH = Left; ObjPro.AttachV = Top; //hudAssets.add(ObjPro);
		ObjProNtf.Name = "ObjectivePorgressionNotificationPosition"; ObjProNtf.posX = 0; ObjProNtf.posY = -100; ObjProNtf.AlignH = Center; ObjProNtf.AlignV = Center; ObjProNtf.AttachH = Center; ObjProNtf.AttachV = Center; //hudAssets.add(ObjProNtf); 
		ObjClock.Name = "ObjectiveClockPosition"; ObjClock.posX = 0; ObjClock.posY = 25; ObjClock.AlignH = Center; ObjClock.AlignV = Top; ObjClock.AttachH = Center; ObjClock.AttachV = Top; //hudAssets.add(ObjClock);
		MiniMap.Name = "MinimapPosition"; MiniMap.posX = 39; MiniMap.posY = 13; MiniMap.AlignH = Left; MiniMap.AlignV = Bottom; MiniMap.AttachH = Left; MiniMap.AttachV = Bottom; hudAssets.add(MiniMap);
		ObitMsg.Name = "ObituaryMessageLogPosition"; ObitMsg.posX = 20; ObitMsg.posY = 60; ObitMsg.AlignH = Right; ObitMsg.AlignV = Top; ObitMsg.AttachH = Right; ObitMsg.AttachV = Top; hudAssets.add(ObitMsg);
		IntFillBar.Name = "InteractionFillbarPosition"; IntFillBar.posX = 0; IntFillBar.posY = 0; IntFillBar.AlignH = Center; IntFillBar.AlignV = Center; IntFillBar.AttachH = Center; IntFillBar.AttachV = Center; //hudAssets.add(IntFillBar);
		XpCounter.Name = "ExpCounterPosition"; XpCounter.posX = 0; XpCounter.posY = 200; XpCounter.sosX = -1; XpCounter.sosY = -1; XpCounter.AlignH = Center; XpCounter.AlignV = Top; XpCounter.AttachH = Center; XpCounter.AttachV = Center; hudAssets.add(XpCounter);
		GameplayNtf.Name = "GameplayNotificationPosition"; GameplayNtf.posX = 0; GameplayNtf.posY = -20; GameplayNtf.sosX = -1; GameplayNtf.sosY = -1; GameplayNtf.AlignH = Center; GameplayNtf.AlignV = Top; GameplayNtf.AttachH = Center; GameplayNtf.AttachV = Top; //hudAssets.add(GameplayNtf);
		Subtitles.Name = "SubtitlesPosition"; Subtitles.posX = 0; Subtitles.posY = 122; Subtitles.AlignH = Center; Subtitles.AlignV = Center; Subtitles.AttachH = Center; Subtitles.AttachV = Top; hudAssets.add(Subtitles);
		ObjNtf.Name = "ObjectiveProgressionNotification"; ObjNtf.posX = 0; ObjNtf.posY = 150; ObjNtf.sosX = -1; ObjNtf.sosY = -1; ObjNtf.AlignH = Center; ObjNtf.AlignV = Top; ObjNtf.AttachH = Center; ObjNtf.AttachV = Top; hudAssets.add(ObjNtf);
		GameInfo.Name = "GameInfoPosition"; GameInfo.posX = 0; GameInfo.posY = 0; GameInfo.AlignH = Center; GameInfo.AlignV = Top; GameInfo.AttachH = Center; GameInfo.AttachV = Top; //hudAssets.add(GameInfo);
		SpcInfo.Name = "SpectatorInfoPosition"; SpcInfo.posX = 0; SpcInfo.posY = 150; SpcInfo.sosX = -1; SpcInfo.sosY = -1; SpcInfo.AlignH = Center; SpcInfo.AlignV = Bottom; SpcInfo.AttachH = Center; SpcInfo.AttachV = Bottom; //hudAssets.add(SpcInfo);
		Detected.Name = "DetectedNotificationPosition"; Detected.posX = 0; Detected.posY = 100; Detected.AlignH = Center; Detected.AlignV = Center; Detected.AttachH = Center; Detected.AttachV = Bottom; hudAssets.add(Detected);
		WeaponAmmo.Name = "WeaponAmmoPosition"; WeaponAmmo.posX = 20; WeaponAmmo.posY = 57; WeaponAmmo.sosX = -1; WeaponAmmo.sosY = -1; WeaponAmmo.AlignH = Right; WeaponAmmo.AlignV = Bottom; WeaponAmmo.AttachH = Right; WeaponAmmo.AttachV = Bottom; hudAssets.add(WeaponAmmo);
		AbilityCooldown.Name = "AbilityCooldownPosition"; AbilityCooldown.posX = 20; AbilityCooldown.posY = 113; AbilityCooldown.sosX = -1; AbilityCooldown.sosY = -1; AbilityCooldown.AlignH = Right; AbilityCooldown.AlignV = Bottom; AbilityCooldown.AttachH = Right; AbilityCooldown.AttachV = Bottom; hudAssets.add(AbilityCooldown);
		CarryBomb.Name = "CarryBombPosition"; CarryBomb.posX = 20; CarryBomb.posY = 122; CarryBomb.sosX = -1; CarryBomb.sosY = -1; CarryBomb.AlignH = Right; CarryBomb.AlignV = Bottom; CarryBomb.AttachH = Right; CarryBomb.AttachV = Bottom; //hudAssets.add(CarryBomb);
		PlayerHealth.Name = "PlayerHealthPosition"; PlayerHealth.posX = 20; PlayerHealth.posY = 12; PlayerHealth.sosX = -1; PlayerHealth.sosY = -1; PlayerHealth.AlignH = Right; PlayerHealth.AlignV = Bottom; PlayerHealth.AttachH = Right; PlayerHealth.AttachV = Bottom; hudAssets.add(PlayerHealth);
		ShieldBar.Name = "ShieldBarPosition"; ShieldBar.posX = 0; ShieldBar.posY = 100; ShieldBar.sosX = -1; ShieldBar.sosY = -1; ShieldBar.AlignH = Center; ShieldBar.AlignV = Bottom; ShieldBar.AttachH = Center; ShieldBar.AttachV = Bottom; hudAssets.add(ShieldBar);
		ReadyUp.Name = "ReadyUpPosition"; ReadyUp.posX = 0;  ReadyUp.posY = 0; ReadyUp.AlignH = Center; ReadyUp.AlignV = Top; ReadyUp.AttachH = Center; ReadyUp.AttachV = Top;  hudAssets.add(ReadyUp);
		BadgeNtf.Name = "BadgeNotificationPosition"; BadgeNtf.posX = 0; BadgeNtf.posY = 0; BadgeNtf.AlignH = Center; BadgeNtf.AlignV = Top; BadgeNtf.AttachH = Center; BadgeNtf.AttachV = Top; hudAssets.add(BadgeNtf);
		DeathInfoCard.Name = "DeathInfoCardrd Position"; DeathInfoCard.posX = 0; DeathInfoCard.posY = 0; DeathInfoCard.AlignH = Center; DeathInfoCard.AlignV = Bottom; DeathInfoCard.AttachH = Center; DeathInfoCard.AttachV = Bottom; //hudAssets.add(DeathInfoCard);
		SpcGameWaveTimer.Name = "SpectatorGameWaveTimerPosition"; SpcGameWaveTimer.posX = 0; SpcGameWaveTimer.posY = 60; SpcGameWaveTimer.AlignH = Center; SpcGameWaveTimer.AlignV = Top; SpcGameWaveTimer.AttachH = Center; SpcGameWaveTimer.AttachV = Top; hudAssets.add(SpcGameWaveTimer);
		GameWaveTimer.Name = "GameWaveTimerPosition"; GameWaveTimer.posX = 40; GameWaveTimer.posY = 60; GameWaveTimer.AlignH = Left; GameWaveTimer.AlignV = Top; GameWaveTimer.AttachH = Left; GameWaveTimer.AttachV = Top; hudAssets.add(GameWaveTimer);
		ObjPos.Name = "ObjectivePosition"; ObjPos.posX = 40; ObjPos.posY = 105; ObjPos.AlignH = Left; ObjPos.AlignV = Top; ObjPos.AttachH = Left; ObjPos.AttachV = Top; hudAssets.add(ObjPos);
		SpcObjPos.Name = "SpectatorObjectivePosition"; SpcObjPos.posX = 0; SpcObjPos.posY = 60; SpcObjPos.AlignH = Center; SpcObjPos.AlignV = Top; SpcObjPos.AttachH = Center; SpcObjPos.AttachV = Top; hudAssets.add(SpcObjPos);
		ActionMenu.Name = "ActionMenuPosition"; ActionMenu.posX = 10; ActionMenu.posY = 10; ActionMenu.AlignH = Left; ActionMenu.AlignV = Top; ActionMenu.AttachH = Left; ActionMenu.AttachV = Top; hudAssets.add(ActionMenu);
		SpcActionMenu.Name = "SpectatorActionMenuPosition"; SpcActionMenu.posX = 10; SpcActionMenu.posY = 10; SpcActionMenu.AlignH = Left; SpcActionMenu.AlignV = Top; SpcActionMenu.AttachH = Left; SpcActionMenu.AttachV = Top; hudAssets.add(SpcActionMenu);
		CharSelect.Name = "CharacterSelectionPosition"; CharSelect.posX = 0; CharSelect.posY = 0; CharSelect.AlignH = Center; CharSelect.AlignV = Bottom; CharSelect.AttachH = Center; CharSelect.AttachV = Bottom; hudAssets.add(CharSelect);
		SpcCard.Name = "SpectatorCardPosition"; SpcCard.posX = 0; SpcCard.posY = 0; SpcCard.AlignH = Center; SpcCard.AlignV = Bottom; SpcCard.AttachH = Center; SpcCard.AttachV = Bottom; hudAssets.add(SpcCard);
		ExeGameStat.Name = "ExecutionGameStatusPosition"; ExeGameStat.posX = 0; ExeGameStat.posY = 0; ExeGameStat.AlignH = Center; ExeGameStat.AlignV = Top; ExeGameStat.AttachH = Center; ExeGameStat.AttachV = Top; hudAssets.add(ExeGameStat);
		ExeCountDown.Name = "ExecutionCountdownPosition"; ExeCountDown.posX = 0; ExeCountDown.posY = 0; ExeCountDown.AlignH = Center; ExeCountDown.AlignV = Top; ExeCountDown.AttachH = Center; ExeCountDown.AttachV = Top; hudAssets.add(ExeCountDown);
		ExeRoundNtf.Name = "ExecutionRoundNotificationPosition"; ExeRoundNtf.posX = 0; ExeRoundNtf.posY = 0; ExeRoundNtf.AlignH = Center; ExeRoundNtf.AlignV = Center; ExeRoundNtf.AttachH = Center; ExeRoundNtf.AttachV = Center;  hudAssets.add(ExeRoundNtf);
		ExeRoundIntro.Name = "ExecutionRoundIntroPosition"; ExeRoundIntro.posX = 0; ExeRoundIntro.posY = 0; ExeRoundIntro.AlignH = Left; ExeRoundIntro.AlignV = Bottom; ExeRoundIntro.AttachH = Left; ExeRoundIntro.AttachV = Bottom; hudAssets.add(ExeRoundIntro);
		DebPos.Name = "DebilitatedNotificationPosition"; DebPos.posX = 0; DebPos.posY = 120; DebPos.AlignH = Center; DebPos.AlignV = Center; DebPos.AttachH = Center; DebPos.AttachV = Bottom; hudAssets.add(DebPos);
		ExeBadge.Name = "ExecutionBadgeNotificationPosition"; ExeBadge.posX = 0; ExeBadge.posY = 80; ExeBadge.AlignH = Center; ExeBadge.AlignV = Top; ExeBadge.AttachH = Center; ExeBadge.AttachV = Top; hudAssets.add(ExeBadge);
				
		//Original
		
		ScopeInfo.OposX = 0; ScopeInfo.OposY = 500; ScopeInfo.OAlignH = Center; ScopeInfo.OAlignV = Top; ScopeInfo.OAttachH = Center; ScopeInfo.OAttachV = Top; 
		CnslMsgLog.OposX = 0; CnslMsgLog.OposY = 0; CnslMsgLog.OAlignH = Left; CnslMsgLog.OAlignV = Bottom; CnslMsgLog.OAttachH = Left; CnslMsgLog.OAttachV = Top;
		SpcCnslMsgLog.OposX = 0; SpcCnslMsgLog.OposY = 0; SpcCnslMsgLog.OAlignH = Left; SpcCnslMsgLog.OAlignV = Top; SpcCnslMsgLog.OAttachH = Left; SpcCnslMsgLog.OAttachV = Bottom;
		ChatInput.OposX = 0; ChatInput.OposY = -2; ChatInput.OAlignH = Left; ChatInput.OAlignV = Bottom; ChatInput.OAttachH = Left; ChatInput.OAttachV = Top;
		SpcChatInput.OposX = 0; SpcChatInput.OposY = -2; SpcChatInput.OAlignH = Left; SpcChatInput.OAlignV = Bottom; SpcChatInput.OAttachH = Left; SpcChatInput.OAttachV = Top;
		IncapMenu.OposX = 0; IncapMenu.OposY = 0; IncapMenu.OAlignH = Center; IncapMenu.OAlignV = Bottom; IncapMenu.OAttachH = Center; IncapMenu.OAttachV = Top;
		ObjPro.OposX = 25; ObjPro.OposY = 100; ObjPro.OAlignH = Left; ObjPro.OAlignV = Top; ObjPro.OAttachH = Left; ObjPro.OAttachV = Top;
		ObjProNtf.OposX = 0; ObjProNtf.OposY = -100; ObjProNtf.OAlignH = Center; ObjProNtf.OAlignV = Center; ObjProNtf.OAttachH = Center; ObjProNtf.OAttachV = Center; 
		ObjClock.OposX = 0; ObjClock.OposY = 25; ObjClock.OAlignH = Center; ObjClock.OAlignV = Top; ObjClock.OAttachH = Center; ObjClock.OAttachV = Top;
		MiniMap.OposX = 39; MiniMap.OposY = 13; MiniMap.OAlignH = Left; MiniMap.OAlignV = Bottom; MiniMap.OAttachH = Left; MiniMap.OAttachV = Bottom;
		ObitMsg.OposX = 20; ObitMsg.OposY = 60; ObitMsg.OAlignH = Right; ObitMsg.OAlignV = Top; ObitMsg.OAttachH = Right; ObitMsg.OAttachV = Top;
		IntFillBar.OposX = 0; IntFillBar.OposY = 0; IntFillBar.OAlignH = Center; IntFillBar.OAlignV = Center; IntFillBar.OAttachH = Center; IntFillBar.OAttachV = Center;
		XpCounter.OposX = 0; XpCounter.OposY = 200; XpCounter.OsosX = -1; XpCounter.OsosY = -1; XpCounter.OAlignH = Center; XpCounter.OAlignV = Top; XpCounter.OAttachH = Center; XpCounter.OAttachV = Center;
		GameplayNtf.OposX = 0; GameplayNtf.OposY = -20; GameplayNtf.OsosX = -1; GameplayNtf.OsosY = -1; GameplayNtf.OAlignH = Center; GameplayNtf.OAlignV = Top; GameplayNtf.OAttachH = Center; GameplayNtf.OAttachV = Top;
		Subtitles.OposX = 0; Subtitles.OposY = 0; Subtitles.OAlignH = Left; Subtitles.OAlignV = Center; Subtitles.OAttachH = Center; Subtitles.OAttachV = Top;
		ObjNtf.OposX = 0; ObjNtf.OposY = 150; ObjNtf.OsosX = -1; ObjNtf.OsosY = -1; ObjNtf.OAlignH = Center; ObjNtf.OAlignV = Top; ObjNtf.OAttachH = Center; ObjNtf.OAttachV = Top;
		GameInfo.OposX = 0; GameInfo.OposY = 0; GameInfo.OAlignH = Center; GameInfo.OAlignV = Top; GameInfo.OAttachH = Center; GameInfo.OAttachV = Top;
		SpcInfo.OposX = 0; SpcInfo.OposY = 150; SpcInfo.OsosX = -1; SpcInfo.OsosY = -1; SpcInfo.OAlignH = Center; SpcInfo.OAlignV = Bottom; SpcInfo.OAttachH = Center; SpcInfo.OAttachV = Bottom;
		Detected.OposX = 0; Detected.OposY = 100; Detected.OAlignH = Center; Detected.OAlignV = Center; Detected.OAttachH = Center; Detected.OAttachV = Bottom;
		WeaponAmmo.OposX = 20; WeaponAmmo.OposY = 57; WeaponAmmo.OsosX = -1; WeaponAmmo.OsosY = -1; WeaponAmmo.OAlignH = Right; WeaponAmmo.OAlignV = Bottom; WeaponAmmo.OAttachH = Right; WeaponAmmo.OAttachV = Bottom;
		AbilityCooldown.OposX = 20; AbilityCooldown.OposY = 93; AbilityCooldown.OsosX = -1; AbilityCooldown.OsosY = -1; AbilityCooldown.OAlignH = Right; AbilityCooldown.OAlignV = Bottom; AbilityCooldown.OAttachH = Right; AbilityCooldown.OAttachV = Bottom;
		CarryBomb.OposX = 20; CarryBomb.OposY = 122; CarryBomb.OsosX = -1; CarryBomb.OsosY = -1; CarryBomb.OAlignH = Right; CarryBomb.OAlignV = Bottom; CarryBomb.OAttachH = Right; CarryBomb.OAttachV = Bottom;
		PlayerHealth.OposX = 20; PlayerHealth.OposY = 12; PlayerHealth.OsosX = -1; PlayerHealth.OsosY = -1; PlayerHealth.OAlignH = Right; PlayerHealth.OAlignV = Bottom; PlayerHealth.OAttachH = Right; PlayerHealth.OAttachV = Bottom;
		ShieldBar.OposX = 0; ShieldBar.OposY = 100; ShieldBar.OsosX = -1; ShieldBar.OsosY = -1; ShieldBar.OAlignH = Center; ShieldBar.OAlignV = Bottom; ShieldBar.OAttachH = Center; ShieldBar.OAttachV = Bottom;
		ReadyUp.OposX = 0;  ReadyUp.OposY = 0; ReadyUp.OAlignH = Center; ReadyUp.OAlignV = Top; ReadyUp.OAttachH = Center; ReadyUp.OAttachV = Top; 
		BadgeNtf.OposX = 0; BadgeNtf.OposY = 0; BadgeNtf.OAlignH = Center; BadgeNtf.OAlignV = Center; BadgeNtf.OAttachH = Center; BadgeNtf.OAttachV = Top;
		DeathInfoCard.OposX = 0; DeathInfoCard.OposY = 0; DeathInfoCard.OAlignH = Center; DeathInfoCard.OAlignV = Bottom; DeathInfoCard.OAttachH = Center; DeathInfoCard.OAttachV = Bottom;
		SpcGameWaveTimer.OposX = 0; SpcGameWaveTimer.OposY = 60; SpcGameWaveTimer.OAlignH = Center; SpcGameWaveTimer.OAlignV = Top; SpcGameWaveTimer.OAttachH = Center; SpcGameWaveTimer.OAttachV = Top;
		GameWaveTimer.OposX = 0; GameWaveTimer.OposY = 60; GameWaveTimer.OAlignH = Left; GameWaveTimer.OAlignV = Top; GameWaveTimer.OAttachH = Left; GameWaveTimer.OAttachV = Top;
		ObjPos.OposX = 40; ObjPos.OposY = 105; ObjPos.OAlignH = Left; ObjPos.OAlignV = Top; ObjPos.OAttachH = Left; ObjPos.OAttachV = Top;
		SpcObjPos.OposX = 0; SpcObjPos.OposY = 60; SpcObjPos.OAlignH = Center; SpcObjPos.OAlignV = Top; SpcObjPos.OAttachH = Center; SpcObjPos.OAttachV = Top;
		ActionMenu.OposX = 10; ActionMenu.OposY = 10; ActionMenu.OAlignH = Left; ActionMenu.OAlignV = Top; ActionMenu.OAttachH = Left; ActionMenu.OAttachV = Top;
		SpcActionMenu.OposX = 10; SpcActionMenu.OposY = 10; SpcActionMenu.OAlignH = Left; SpcActionMenu.OAlignV = Top; SpcActionMenu.OAttachH = Left; SpcActionMenu.OAttachV = Top;
		CharSelect.OposX = 0; CharSelect.OposY = 0; CharSelect.OAlignH = Center; CharSelect.OAlignV = Center; CharSelect.OAttachH = Center; CharSelect.OAttachV = Bottom;
		SpcCard.OposX = 0; SpcCard.OposY = 0; SpcCard.OAlignH = Center; SpcCard.OAlignV = Bottom; SpcCard.OAttachH = Center; SpcCard.OAttachV = Bottom;
		ExeGameStat.OposX = 0; ExeGameStat.OposY = 0; ExeGameStat.OAlignH = Center; ExeGameStat.OAlignV = Top; ExeGameStat.OAttachH = Center; ExeGameStat.OAttachV = Top;
		ExeCountDown.OposX = 0; ExeCountDown.OposY = 0; ExeCountDown.OAlignH = Center; ExeCountDown.OAlignV = Top; ExeCountDown.OAttachH = Center; ExeCountDown.OAttachV = Top;
		ExeRoundNtf.OposX = 0; ExeRoundNtf.OposY = 0; ExeRoundNtf.OAlignH = Center; ExeRoundNtf.OAlignV = Center; ExeRoundNtf.OAttachH = Center; ExeRoundNtf.OAttachV = Center; 
		ExeRoundIntro.OposX = 0; ExeRoundIntro.OposY = 0; ExeRoundIntro.OAlignH = Left; ExeRoundIntro.OAlignV = Bottom; ExeRoundIntro.OAttachH = Left; ExeRoundIntro.OAttachV = Bottom;
		DebPos.OposX = 0; DebPos.OposY = 120; DebPos.OAlignH = Center; DebPos.OAlignV = Center; DebPos.OAttachH = Center; DebPos.OAttachV = Bottom;
		ExeBadge.OposX = 0; ExeBadge.OposY = 80; ExeBadge.OAlignH = Center; ExeBadge.OAlignV = Top; ExeBadge.OAttachH = Center; ExeBadge.OAttachV = Top;
		
		//Color
		
		AllyColor.ColorR = 0; AllyColor.ColorG = 150; AllyColor.ColorB = 200; AllyColor.ColorA = 255;
		AllyColor2.ColorR = 255; AllyColor2.ColorG = 255; AllyColor2.ColorB = 255; AllyColor2.ColorA = 255;
		AlliedColor.ColorR = 0; AlliedColor.ColorG = 150; AlliedColor.ColorB = 200; AlliedColor.ColorA = 255;
		EnemyColor.ColorR = 240; EnemyColor.ColorG = 95; EnemyColor.ColorB = 65; EnemyColor.ColorA = 255;
		NeutralColor.ColorR = 255; NeutralColor.ColorG = 255; NeutralColor.ColorB = 255; NeutralColor.ColorA = 255;
		NeutralColor2.ColorR = 122; NeutralColor2.ColorG = 122; NeutralColor2.ColorB = 122; NeutralColor2.ColorA = 255;
		AIColor.ColorR = 240; AIColor.ColorG = 95; AIColor.ColorB = 65; AIColor.ColorA = 255;
		PrimaryObjColor.ColorR = 220; PrimaryObjColor.ColorG = 220; PrimaryObjColor.ColorB = 30; PrimaryObjColor.ColorA = 255;
		AmmoColor.ColorR = 255; AmmoColor.ColorG = 255; AmmoColor.ColorB = 255; AmmoColor.ColorA = 255;
		LowAmmoColor.ColorR = 0; LowAmmoColor.ColorG = 181; LowAmmoColor.ColorB = 222; LowAmmoColor.ColorA = 255;
		LowAmmoColor2.ColorR = 0; LowAmmoColor2.ColorG = 40; LowAmmoColor2.ColorB = 49; LowAmmoColor2.ColorA = 255;
		NoAmmoColor.ColorR = 55; NoAmmoColor.ColorG = 55; NoAmmoColor.ColorB = 55; NoAmmoColor.ColorA = 255;
		//GrenadeBlinkColor.ColorR = 255; GrenadeBlinkColor.ColorG = 0; GrenadeBlinkColor.ColorB = 0; GrenadeBlinkColor.ColorA = 255;
		//GrenadeBlinkColor2.ColorR = 255; GrenadeBlinkColor2.ColorG = 0; GrenadeBlinkColor2.ColorB = 0; GrenadeBlinkColor2.ColorA = 0;
		//GrenadeOOVColor1.ColorR = 55; GrenadeOOVColor1.ColorG = 55; GrenadeOOVColor1.ColorB = 55; GrenadeOOVColor1.ColorA = 255;
		//GrenadeOOVColor2.ColorR = 55; GrenadeOOVColor2.ColorG = 55; GrenadeOOVColor2.ColorB = 55; GrenadeOOVColor2.ColorA = 0;
		PrimaryPerformerColor.ColorR = 220; PrimaryPerformerColor.ColorG = 220; PrimaryPerformerColor.ColorB = 30; PrimaryPerformerColor.ColorA = 255;
		MapIconPrimaryColor.ColorR = 252; MapIconPrimaryColor.ColorG = 238; MapIconPrimaryColor.ColorB = 33; MapIconPrimaryColor.ColorA = 255;
		MapIconSecondaryColor.ColorR = 255; MapIconSecondaryColor.ColorG = 255; MapIconSecondaryColor.ColorB = 255; MapIconSecondaryColor.ColorA = 255;
		AlliedColor.ColorR = 0; AlliedColor.ColorG = 182; AlliedColor.ColorB = 222; AlliedColor.ColorA = 255;
		EnemyColor2.ColorR = 255; EnemyColor2.ColorG = 73; EnemyColor2.ColorB = 33; EnemyColor2.ColorA = 255;
		HighlightedBGColor.ColorR = 241; HighlightedBGColor.ColorG = 71; HighlightedBGColor.ColorB = 0; HighlightedBGColor.ColorA = 255;
		DefaultBGColor.ColorR = 0; DefaultBGColor.ColorG = 0; DefaultBGColor.ColorB = 0; DefaultBGColor.ColorA = 255;
		//BlinkColor.ColorR = 0; BlinkColor.ColorG = 0; BlinkColor.ColorB = 0; BlinkColor.ColorA = 255;
		
		//Other Values
	}
	
	/*public static class Save implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
			s2 = new Shell(d2);
			FileDialog fd = new FileDialog(s2, SWT.SAVE);
			fd.setText("Save Preset");
			fd.setFilterPath("C:/");
			fd.setFileName("ShooterUI");
			fd.setOverwrite(true);
			String[] fileExt = {"*.ini"};
			fd.setFilterExtensions(fileExt);
			selection = fd.open();
			d2 = new Display();
			.println(selection);
	       	}
	      @Override
	      public void widgetDefaultSelected(SelectionEvent e) {}
	}*/
	
	public static void SoS(){
		if (showOS == 1){
			if (HUD_Maker.cl != null){
    			for (int i = 0; i < HUD_Maker.assets.size(); i++){
    					Label label = HUD_Maker.assets.get(i);
    					label.setVisible(false);
    					HUD_Maker.cl.setVisible(true);
    			}
    			Options.btn_modeExecution.setEnabled(false);
				Options.btn_modeSpectator.setEnabled(false);
				Options.btn_modeInGame.setEnabled(false);
				Options.btn_modeWarmup.setEnabled(false);
    		}
		}else{
			for (int i = 0; i < HUD_Maker.assets.size(); i++){
    			Label label = HUD_Maker.assets.get(i);
    			label.setVisible(true);
    		}
			Options.btn_modeExecution.setEnabled(true);
			Options.btn_modeSpectator.setEnabled(true);
			Options.btn_modeInGame.setEnabled(true);
			Options.btn_modeWarmup.setEnabled(true);
			HUD_Maker.mode();
		}
	}
	
	public static void noneSelected(){
		cr = null;
		HUD_Maker.cl = null;
		pox.setSelection(0);
		poy.setSelection(0);
		sox.setSelection(0);
		soy.setSelection(0);
		Align_H.setText("-- Select Align_H --");
		Align_V.setText("-- Select Align_V --");
		Attach_H.setText("-- Select Attach_H --");
		Attach_V.setText("-- Select Attach_V --");
		colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		
		pox.setEnabled(false);
		poy.setEnabled(false);
		Attach_H.setEnabled(false);
		Attach_V.setEnabled(false);
		Align_H.setEnabled(false);
		Align_V.setEnabled(false);
		sox.setEnabled(false);
		soy.setEnabled(false);
		btn_color.setEnabled(false);
		value.setEnabled(false);
	}
	
	public static void otherSelected(){
		HUD_Asset.setText("-- Select Asset --");
		value.setSelection(cr.Value);
		
		HUD_Maker.cl = null;
		colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		
		pox.setEnabled(false);
		poy.setEnabled(false);
		Attach_H.setEnabled(false);
		Attach_V.setEnabled(false);
		Align_H.setEnabled(false);
		Align_V.setEnabled(false);
		sox.setEnabled(false);
		soy.setEnabled(false);
		btn_color.setEnabled(false);
		value.setEnabled(true);
		
		HUD_Maker.cl = null;
	
		pox.setSelection(0);
		poy.setSelection(0);
		Attach_H.setText("-- Select Attach_H --");
		Attach_V.setText("-- Select Attach_V --");
		Align_H.setText("-- Select Align_H --");
		Align_V.setText("-- Select Align_V --");
		sox.setSelection(0);
		soy.setSelection(0);
		btn_color.setEnabled(false);
		value.setEnabled(true);
	}
	
	public static void colorSelected(){
		HUD_Asset.setText("-- Select Asset --");
		pox.setEnabled(false);
		poy.setEnabled(false);
		Attach_H.setEnabled(false);
		Attach_V.setEnabled(false);
		Align_H.setEnabled(false);
		Align_V.setEnabled(false);
		sox.setEnabled(false);
		soy.setEnabled(false);
		value.setEnabled(false);
		btn_color.setEnabled(true);
		HUD_Maker.cl = null;
		
		pox.setSelection(0);
		poy.setSelection(0);
		Attach_H.setText("-- Select Attach_H --");
		Attach_V.setText("-- Select Attach_V --");
		Align_H.setText("-- Select Align_H --");
		Align_V.setText("-- Select Align_V --");
		sox.setSelection(0);
		soy.setSelection(0);
		value.setSelection(0);
		
		colorPreview.setBackground(SWTResourceManager.getColor(cr.ColorR, cr.ColorG, cr.ColorB));
		ColorWindow.R = cr.ColorR;
		ColorWindow.G = cr.ColorG;
		ColorWindow.B = cr.ColorB;
		ColorWindow.A = cr.ColorA;
		
	}
	
	public static void createContents() {
		
		image_HUDOptions = new Image(display, image_HUDOptionsPath);
		
		Options_UI = new Shell(SWT.ON_TOP);
		Options_UI.setBackground(SWTResourceManager.getColor(255, 255, 255));
		Options_UI.setSize(260, 560);
		Options_UI.setAlpha(opacity);
		
		sidePanelComp = new ScrolledComposite(Options_UI, SWT.V_SCROLL);
		sidePanelComp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		sidePanelComp.setBounds(0, 28, 260, 530);
		sidePanelComp.setExpandHorizontal(true);
		sidePanelComp.setExpandVertical(true);
		sidePanelComp.setMinHeight(1140);
		
		sidePanel = new Composite(sidePanelComp, SWT.NONE);
		sidePanel.setLocation(0, 0);
		sidePanel.setSize(260, 1140);
		sidePanel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		sidePanel.setBackgroundMode(SWT.INHERIT_FORCE);
		
		sidePanelComp.setContent(sidePanel);
		
		colorPreview = new Composite(sidePanel, SWT.BORDER);
		colorPreview.setLocation(135, 686);
		colorPreview.setSize(75, 25);
		colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		colorPreview.setLayout(null);
		
		HUD_Asset = new Combo(sidePanel, SWT.READ_ONLY);
		HUD_Asset.setLocation(50, 73);
		HUD_Asset.setSize(160, 23);
		HUD_Asset.setItems(new String[] {"-- Select Asset --",
				"Ability Cooldown",
				"Action Menu",
				"Badge Notification",
				"Character Select",
				"Chat Input",
				"Debilitated Notification",
				"Detected Notification",
				"Execution Badge Notification",
				//"Execution Countdown",
				"Execution Game Status",
				"Execution Round Intro",
				//"Execution Round Notification",
				"Gamewave Timer",
				"Health",
				//"Interaction Fillbar",
				"Message Log",
				"MiniMap",
				"Obituary Message Log",
				"Objective Notification",
				"Objective",
				"Phantom Shield Bar",
				"Ready Up",
				"Spectator Action Menu",
				"Spectator Card",
				"Spectator Message Log",
				"Spectator Gamewave Timer",
				"Spectator Chat Input",
				"Spectator Objective",
				"Subtitles",
				"Weapon Ammo",
				"XP Counter",
				"Spectator Action Menu"});
		HUD_Asset.setText("-- Select Asset --");
		HUD_Asset.addSelectionListener(new SelectionAdapter(){
			//Checking for Selection and Changing field values
			public void widgetSelected(SelectionEvent e){
				
				//Getting Asset and setting Current Reference cr
				//Normal HUD Assets
				//if (HUD_Asset.getText().equals("Scope Info")){cr = ScopeInfo; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				if (HUD_Asset.getText().equals("Message Log")){cr = CnslMsgLog; type = 1; HUD_Maker.cl = HUD_Maker.img_MessageLog; HUD_Maker.imageSelected = 18;}
				else if (HUD_Asset.getText().equals("-- Select Asset --")){cr = null; type = 0; HUD_Maker.cl = null; HUD_Maker.imageSelected = 0;}
				else if (HUD_Asset.getText().equals("Spectator Message Log")){cr = SpcCnslMsgLog; type = 1; HUD_Maker.cl = HUD_Maker.img_MessageLogSpec; HUD_Maker.imageSelected = 19;}
				else if (HUD_Asset.getText().equals("Chat Input")){cr = ChatInput; type = 1; HUD_Maker.cl = HUD_Maker.img_ChatInput; HUD_Maker.imageSelected = 9;}
				else if (HUD_Asset.getText().equals("Spectator Chat Input")){cr = SpcChatInput; type = 1; HUD_Maker.cl = HUD_Maker.img_ChatInputSpec; HUD_Maker.imageSelected = 10;}
				//else if (HUD_Asset.getText().equals("Incap Menu")){cr = IncapMenu; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				//else if (HUD_Asset.getText().equals("Objective Progression")){cr = ObjPro; type = 1; HUD_Maker.cl = HUD_Maker.img_ObjectiveNotification; HUD_Maker.imageSelected = 2;}
				//else if (HUD_Asset.getText().equals("Objective Progression Notification")){cr = ObjProNtf; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				//else if (HUD_Asset.getText().equals("Game Info")){cr = GameInfo; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				//else if (HUD_Asset.getText().equals("Objective Clock")){cr = ObjClock; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("MiniMap")){cr = MiniMap; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2; type = 1;}
				else if (HUD_Asset.getText().equals("Obituary Message Log")){cr = ObitMsg; type = 1; HUD_Maker.cl = HUD_Maker.img_Obituary; HUD_Maker.imageSelected = 20;}
				//else if (HUD_Asset.getText().equals("Interaction Fillbar")){cr = IntFillBar; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("XP Counter")){cr = XpCounter; type = 2; HUD_Maker.cl = HUD_Maker.img_XP; HUD_Maker.imageSelected = 27;}
				//else if (HUD_Asset.getText().equals("Gameplay Notification")){cr = GameplayNtf; type = 2; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("Subtitles")){cr = Subtitles; type = 1; HUD_Maker.cl = HUD_Maker.img_Subtitles; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("Objective Notification")){cr = ObjNtf; type = 2; HUD_Maker.cl = HUD_Maker.img_ObjectiveNotification; HUD_Maker.imageSelected = 21;}
				//else if (HUD_Asset.getText().equals("Spectator Info")){cr = SpcInfo; type = 2; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("Detected Notification")){cr = Detected; type = 1; HUD_Maker.cl = HUD_Maker.img_Detected; HUD_Maker.imageSelected = 12;}
				else if (HUD_Asset.getText().equals("Weapon Ammo")){cr = WeaponAmmo; type = 2; HUD_Maker.cl = HUD_Maker.img_WeaponAmmo; HUD_Maker.imageSelected = 26;}
				else if (HUD_Asset.getText().equals("Ability Cooldown")){cr = AbilityCooldown; HUD_Maker.cl = HUD_Maker.img_Ability; HUD_Maker.imageSelected = 1; type = 2;}
				//else if (HUD_Asset.getText().equals("Bomb Carry")){cr = CarryBomb; type = 2; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("Health")){cr = PlayerHealth; type = 2; HUD_Maker.cl = HUD_Maker.img_Health; HUD_Maker.imageSelected = 17;}
				else if (HUD_Asset.getText().equals("Phantom Shield Bar")){cr = ShieldBar; type = 2; HUD_Maker.cl = HUD_Maker.img_Armor; HUD_Maker.imageSelected = 6;}
				else if (HUD_Asset.getText().equals("Ready Up")){cr = ReadyUp; type = 1; HUD_Maker.cl = HUD_Maker.img_ReadyUp; HUD_Maker.imageSelected = 22;}
				else if (HUD_Asset.getText().equals("Badge Notification")){cr = BadgeNtf; type = 1; HUD_Maker.cl = HUD_Maker.img_Badge; HUD_Maker.imageSelected = 7;}
				//else if (HUD_Asset.getText().equals("Death Info Card")){cr = DeathInfoCard; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("Spectator Gamewave Timer")){cr = SpcGameWaveTimer; type = 1; HUD_Maker.cl = HUD_Maker.img_GameWaveSpec; HUD_Maker.imageSelected = 16;}
				else if (HUD_Asset.getText().equals("Gamewave Timer")){cr = GameWaveTimer; type = 1; HUD_Maker.cl = HUD_Maker.img_GameWave; HUD_Maker.imageSelected = 15;}
				else if (HUD_Asset.getText().equals("Objective")){cr = ObjPos; HUD_Maker.cl = HUD_Maker.img_Objective; HUD_Maker.imageSelected = 3; type = 1;}
				else if (HUD_Asset.getText().equals("Spectator Objective")){cr = SpcObjPos; type = 1; HUD_Maker.cl = HUD_Maker.img_ObjectiveSpec; HUD_Maker.imageSelected = 5;}
				else if (HUD_Asset.getText().equals("Action Menu")){cr = ActionMenu; HUD_Maker.cl = HUD_Maker.img_ActionMenu; HUD_Maker.imageSelected = 4; type = 1;}
				else if (HUD_Asset.getText().equals("Spectator Action Menu")){cr = SpcActionMenu; type = 1; HUD_Maker.cl = HUD_Maker.img_ActionMenuSpec; HUD_Maker.imageSelected = 28;}
				else if (HUD_Asset.getText().equals("Character Select")){cr = CharSelect; type = 1; HUD_Maker.cl = HUD_Maker.img_CharacterSelect; HUD_Maker.imageSelected = 8;}
				else if (HUD_Asset.getText().equals("Spectator Card")){cr = SpcCard; type = 1; HUD_Maker.cl = HUD_Maker.img_SpectatorCard; HUD_Maker.imageSelected = 24;}
				else if (HUD_Asset.getText().equals("Execution Game Status")){cr = ExeGameStat; type = 1; HUD_Maker.cl = HUD_Maker.img_ExeGameStat; HUD_Maker.imageSelected = 14;}
				//else if (HUD_Asset.getText().equals("Execution Countdown")){cr = ExeCountDown; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				//else if (HUD_Asset.getText().equals("Execution Round Notification")){cr = ExeRoundNtf; type = 1; HUD_Maker.cl = HUD_Maker.img_Minimap; HUD_Maker.imageSelected = 2;}
				else if (HUD_Asset.getText().equals("Execution Round Intro")){cr = ExeRoundIntro; type = 1; HUD_Maker.cl = HUD_Maker.img_RoundIntro; HUD_Maker.imageSelected = 23;}
				else if (HUD_Asset.getText().equals("Debilitated Notification")){cr = DebPos; type = 1; HUD_Maker.cl = HUD_Maker.img_Debilitated; HUD_Maker.imageSelected = 11;}
				else if (HUD_Asset.getText().equals("Execution Badge Notification")){cr = ExeBadge; type = 1;  HUD_Maker.cl = HUD_Maker.img_ExeBadge; HUD_Maker.imageSelected = 13;}
				
				else{type = 0;}
				combo_Color.setText("-- Select Color Asset --");;
				combo_Value.setText("-- Select Value Asset --");
				
				switch (type){
				case 0:
					noneSelected();
					break;
					
				case 1:
					System.out.println(cr.Name);
					if (cr.AlignH == Left){cr.cAlignH = cLeft;}
					else if (cr.AlignH == Center){cr.cAlignH = cCenter;}
					else if (cr.AlignH == Right){cr.cAlignH = cRight;}
					
					if (cr.AlignV == Top){cr.cAlignV = cTop;}
					else if (cr.AlignV == Center){cr.cAlignV = cCenter;}
					else if (cr.AlignV == Bottom){cr.cAlignV = cBottom;}
					
					if (cr.AttachH == Left){cr.cAttachH = cLeft;}
					else if (cr.AttachH == Center){cr.cAttachH = cCenter;}
					else if (cr.AttachH == Right){cr.cAttachH = cRight;}
					
					if (cr.AttachV == Top){cr.cAttachV = cTop;}
					else if (cr.AttachV == Center){cr.cAttachV = cCenter;}
					else if (cr.AttachV == Bottom){cr.cAttachV = cBottom;}
					
					System.out.println(cr.AlignH + ", " + cr.cAlignH);
					System.out.println(cr.AlignV + ", " + cr.cAlignV);
					System.out.println(cr.AttachH + ", " + cr.cAttachH);
					System.out.println(cr.AttachV + ", " + cr.cAttachV);
					
					pox.setSelection(cr.posX);
					poy.setSelection(cr.posY);
					Align_H.setText(cr.cAlignH);
					Align_V.setText(cr.cAlignV);
					Attach_H.setText(cr.cAttachH);
					Attach_V.setText(cr.cAttachV);
					colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
					
					cr.OAttachH = cr.AttachH;
					cr.OAttachV = cr.AttachV;
					cr.OAlignH = cr.AlignH;
					cr.OAlignV = cr.AlignV;
					cr.OposX = cr.posX;
					cr.OposY = cr.posY;
					
					pox.setEnabled(true);
					poy.setEnabled(true);
					Attach_H.setEnabled(true);
					Attach_V.setEnabled(true);
					Align_H.setEnabled(true);
					Align_V.setEnabled(true);
					sox.setEnabled(false);
					soy.setEnabled(false);
					btn_color.setEnabled(false);
					value.setEnabled(false);
					
					
					break;
					
				case 2:
					System.out.println(cr.Name);
					if (cr.AlignH == Left){cr.cAlignH = cLeft;}
					else if (cr.AlignH == Center){cr.cAlignH = cCenter;}
					else if (cr.AlignH == Right){cr.cAlignH = cRight;}
					
					if (cr.AlignV == Top){cr.cAlignV = cTop;}
					else if (cr.AlignV == Center){cr.cAlignV = cCenter;}
					else if (cr.AlignV == Bottom){cr.cAlignV = cBottom;}
					
					if (cr.AttachH == Left){cr.cAttachH = cLeft;}
					else if (cr.AttachH == Center){cr.cAttachH = cCenter;}
					else if (cr.AttachH == Right){cr.cAttachH = cRight;}
					
					if (cr.AttachV == Top){cr.cAttachV = cTop;}
					else if (cr.AttachV == Center){cr.cAttachV = cCenter;}
					else if (cr.AttachV == Bottom){cr.cAttachV = cBottom;}
					
					pox.setSelection(cr.posX);
					poy.setSelection(cr.posY);
					sox.setSelection(cr.sosX);
					soy.setSelection(cr.sosY);
					Align_H.setText(cr.cAlignH);
					Align_V.setText(cr.cAlignV);
					Attach_H.setText(cr.cAttachH);
					Attach_V.setText(cr.cAttachV);
					colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
					
					cr.OAttachH = cr.AttachH;
					cr.OAttachV = cr.AttachV;
					cr.OAlignH = cr.AlignH;
					cr.OAlignV = cr.AlignV;
					cr.OposX = cr.posX;
					cr.OposY = cr.posY;
					cr.OsosX = cr.sosX;
					cr.OsosY = cr.sosY;
					
					pox.setEnabled(true);
					poy.setEnabled(true);
					Attach_H.setEnabled(true);
					Attach_V.setEnabled(true);
					Align_H.setEnabled(true);
					Align_V.setEnabled(true);
					sox.setEnabled(true);
					soy.setEnabled(true);
					btn_color.setEnabled(false);
					value.setEnabled(false);
					
					break;				
				}
				
			}
		});
		
		combo_Value = new Combo(sidePanel, SWT.READ_ONLY);
		combo_Value.setItems(new String[] {"-- Select Value Asset --"});
		combo_Value.setBounds(50, 557, 160, 23);
		combo_Value.setText("-- Select Value Asset --");
		
		combo_Color = new Combo(sidePanel, SWT.READ_ONLY);
		combo_Color.setItems(new String[] {"-- Select Color Asset --",
				"Ally Color 1",
				"Ally Color 2",
				"Enemy Color",
				"Enemy Color 2",
				"Neutral Color 1"
				,"Neutral Color 2",
				"AI Color",
				"Primary Objective Color",
				"Ammo Color",
				"Low Ammo Color 1",
				"Low Ammo Color 2",
				"No Ammo Color",
				"Primary Performer Color",
				"Map Icon Color 1",
				"Map Icon Color 2",
				"Allied Color",
				"Highlighted BG Color",
				"Default BG Color"});
		combo_Color.setBounds(50, 654, 160, 23);
		combo_Color.setText("-- Select Color Asset --");
		combo_Color.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if (combo_Color.getText().equals("Ally Color 1")){cr = AllyColor; type = 4;}
				else if (combo_Color.getText().equals("Ally Color 2")){cr = AllyColor2; type = 4;}
				else if (combo_Color.getText().equals("Enemy Color")){cr = EnemyColor; type = 4;}
				else if (combo_Color.getText().equals("Enemy Color 2")){cr = EnemyColor2; type = 4;}
				else if (combo_Color.getText().equals("Neutral Color 1")){cr = NeutralColor; type = 4;}
				else if (combo_Color.getText().equals("Neutral Color 2")){cr = NeutralColor2; type = 4;}
				else if (combo_Color.getText().equals("AI Color")){cr = AIColor; type = 4;}
				else if (combo_Color.getText().equals("Primary Objective Color")){cr = PrimaryObjColor; type = 4;}
				else if (combo_Color.getText().equals("Ammo Color")){cr = AmmoColor; type = 4;}
				else if (combo_Color.getText().equals("Low Ammo Color 1")){cr = LowAmmoColor; type = 4;}
				else if (combo_Color.getText().equals("Low Ammo Color 2")){cr = LowAmmoColor2; type = 4;}
				else if (combo_Color.getText().equals("No Ammo Color")){cr = NoAmmoColor; type = 4;}
				//else if (combo_Color.getText().equals("Grenade Blink Color 1")){cr = GrenadeBlinkColor; type = 4;}
				//else if (combo_Color.getText().equals("Grenade Blink Color 2")){cr = GrenadeBlinkColor2; type = 4;}
				//else if (combo_Color.getText().equals("Grenade Out of View Color 1")){cr = GrenadeOOVColor1; type = 4;}
				//else if (combo_Color.getText().equals("Grenade Out of View Color 2")){cr = GrenadeOOVColor2; type = 4;}
				else if (combo_Color.getText().equals("Primary Performer Color")){cr = PrimaryPerformerColor; type = 4;}
				else if (combo_Color.getText().equals("Map Icon Color 1")){cr = MapIconPrimaryColor; type = 4;}
				else if (combo_Color.getText().equals("Map Icon Color 2")){cr = MapIconSecondaryColor; type = 4;}
				else if (combo_Color.getText().equals("Allied Color")){cr = AlliedColor; type = 4;}
				//else if (combo_Color.getText().equals("Blink Color")){cr = BlinkColor; type = 4;}
				else if (combo_Color.getText().equals("Highlighted BG Color")){cr = HighlightedBGColor; type = 4;}
				else if (combo_Color.getText().equals("Default BG Color")){cr = DefaultBGColor; type = 4;}
				else {type = 0;}
				
				if(type == 4){colorSelected();}
				else {noneSelected();}
			}
		});
		
		Attach_H = new Combo(sidePanel, SWT.READ_ONLY);
		Attach_H.setLocation(118, 157);
		Attach_H.setSize(92, 23);
		Attach_H.setEnabled(false);
		Attach_H.setItems(new String[] {"-- Select Attach_H --", "Left", "Center", "Right"});
		Attach_H.setText("-- Select Attach_H --");
		Attach_H.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if (Attach_H.getText().equals("Left")){cr.AttachH = Left;}
				else if (Attach_H.getText().equals("Center")){cr.AttachH = Center;}
				else if (Attach_H.getText().equals("Right")){cr.AttachH = Right;}
				
				HUD_Maker.setProperties();
				//System.out.println(cr.AttachH);
				//System.out.println(cr.OAttachH);
			}
		});
		
		Attach_V = new Combo(sidePanel, SWT.READ_ONLY);
		Attach_V.setLocation(118, 187);
		Attach_V.setSize(92, 23);
		Attach_V.setEnabled(false);
		Attach_V.setItems(new String[] {"-- Select Attach_V --", "Top", "Center", "Bottom"});
		Attach_V.setText("-- Select Attach_V --");
		Attach_V.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if (Attach_V.getText().equals("Top")){cr.AttachV = Top;}
				else if (Attach_V.getText().equals("Center")){cr.AttachV = Center;}
				else if (Attach_V.getText().equals("Bottom")){cr.AttachV = Bottom;}
				
				HUD_Maker.setProperties();
				//System.out.println(cr.AttachV);
			}
		});
		
		Align_H = new Combo(sidePanel, SWT.READ_ONLY);
		Align_H.setLocation(118, 257);
		Align_H.setSize(92, 23);
		Align_H.setEnabled(false);
		Align_H.setItems(new String[] {"-- Select Align_H --", "Left", "Center", "Right"});
		Align_H.setText("-- Select Align_H --");
		Align_H.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if (Align_H.getText().equals("Left")){cr.AlignH = Left;}
				else if (Align_H.getText().equals("Center")){cr.AlignH = Center;}
				else if (Align_H.getText().equals("Right")){cr.AlignH = Right;}
				
				HUD_Maker.setProperties();
				//System.out.println(cr.AlignH);
			}
		});
		
		Align_V = new Combo(sidePanel, SWT.READ_ONLY);
		Align_V.setLocation(118, 287);
		Align_V.setSize(92, 23);
		Align_V.setEnabled(false);
		Align_V.setItems(new String[] {"-- Select Align_V --","Top", "Center", "Bottom"});
		Align_V.setText("-- Select Align_V --");
		Align_V.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if (Align_V.getText().equals("Top")){cr.AlignV = Top;}
				else if (Align_V.getText().equals("Center")){cr.AlignV = Center;}
				else if (Align_V.getText().equals("Bottom")){cr.AlignV = Bottom;}
				
				HUD_Maker.setProperties();
				//System.out.println(cr.AlignV);
			}
		});
		
		value = new Spinner(sidePanel, SWT.BORDER);
		value.setLocation(134, 593);
		value.setSize(76, 21);
		value.setEnabled(false);
		value.setMinimum(-9999);
		value.setMaximum(9999);
		value.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent mod){
				Spinner text = (Spinner) mod.widget;
				System.out.println(text.getText());
				
				HUD_Maker.setProperties();
				
				if (cr != null){cr.Value=value.getSelection();}
				//if (poy.getText() == ""){poy.setSelection("0");}
			}
		});

		pox = new Spinner(sidePanel, SWT.BORDER);
		pox.setLocation(134, 357);
		pox.setSize(76, 21);
		pox.setEnabled(false);
		//pox.setEditable(true);
		pox.setSelection(0);
		pox.setMinimum(-9999);
		pox.setMaximum(9999);
		pox.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent mod){
				Spinner text = (Spinner) mod.widget;
				System.out.println(text.getText());
				
				if (cr != null){cr.posX=pox.getSelection();}
				HUD_Maker.setProperties();
				//if (pox.getText() == ""){pox.setSelection("0");}
			}
		});
		
		poy = new Spinner(sidePanel, SWT.BORDER);
		poy.setLocation(134, 387);
		poy.setSize(76, 21);
		poy.setEnabled(false);
		//poy.setEditable(true);
		poy.setSelection(0);
		poy.setMinimum(-9999);
		poy.setMaximum(9999);
		poy.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent mod){
				Spinner text = (Spinner) mod.widget;
				System.out.println(text.getText());
				
				if (cr != null){cr.posY=poy.getSelection();}
				HUD_Maker.setProperties();
				//if (poy.getText() == ""){poy.setSelection("0");}
			}
		});
		
		sox = new Spinner(sidePanel, SWT.BORDER);
		sox.setLocation(155, 457);
		sox.setSize(55, 21);
		sox.setEnabled(false);
		//poy.setEditable(true);
		sox.setSelection(0);
		sox.setMinimum(-9999);
		sox.setMaximum(9999);
		sox.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent mod){
				Spinner text = (Spinner) mod.widget;
				System.out.println(text.getText());
				
				HUD_Maker.setProperties();
				
				if (cr != null){cr.sosX=sox.getSelection();}
				//if (poy.getText() == ""){poy.setSelection("0");}
			}
		});
		
		soy = new Spinner(sidePanel, SWT.BORDER);
		soy.setLocation(155, 487);
		soy.setSize(55, 21);
		soy.setEnabled(false);
		//poy.setEditable(true);
		soy.setSelection(0);
		soy.setMinimum(-9999);
		soy.setMaximum(9999);
		soy.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent mod){
				Spinner text = (Spinner) mod.widget;
				System.out.println(text.getText());
				
				HUD_Maker.setProperties();
				
				if (cr != null){cr.sosY=soy.getSelection();}
				//if (poy.getText() == ""){poy.setSelection("0");}
			}
		});
		
		select_preset = new Combo(sidePanel, SWT.READ_ONLY);
		select_preset.setLocation(50, 869);
		select_preset.setSize(160, 23);
		select_preset.setItems(new String[] {"Default"});
		select_preset.setText("Default");
		select_preset.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
			}
		});
		
		btn_modeInGame = new Button(sidePanel, SWT.RADIO);
		btn_modeInGame.setLocation(50, 754);
		btn_modeInGame.setSize(93, 16);
		btn_modeInGame.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mode = 1;
				for (int i = 0; i < 2; i++){
					String imageScenePath = "bin/db_hud/assets/images/imageScene.png";
					Image imageScene = new Image(display, imageScenePath);
					
					ImageData imageData = HUD_Maker.image_scene.getImageData();
					imageData = imageData.scaledTo(HUD_Maker.compX, HUD_Maker.compY);
					ImageLoader imageLoader = new ImageLoader();
			        imageLoader.data = new ImageData[] {imageData};
			        imageLoader.save(imageScenePath, 1);
			        HUD_Maker.HUD_Preview.setBackgroundImage(imageScene);		
				}
				HUD_Maker.mode();
			}
		});
		btn_modeInGame.setSelection(true);
		btn_modeInGame.setText("In Game");
		btn_modeInGame.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		btn_modeWarmup = new Button(sidePanel, SWT.RADIO);
		btn_modeWarmup.setLocation(50, 792);
		btn_modeWarmup.setSize(105, 16);
		btn_modeWarmup.setText("Warm Up");
		btn_modeWarmup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btn_modeWarmup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mode = 2;
				for (int i = 0; i < 2; i++){
					String imageSceneWarmUpPath = "bin/db_hud/assets/images/imageSceneWarmUp.png";
					Image imageSceneWarmUp = new Image(display, imageSceneWarmUpPath);
					
					ImageData imageData = HUD_Maker.image_sceneWarmUp.getImageData();
					imageData = imageData.scaledTo(HUD_Maker.compX, HUD_Maker.compY);
					ImageLoader imageLoader = new ImageLoader();
			        imageLoader.data = new ImageData[] {imageData};
			        imageLoader.save(imageSceneWarmUpPath, 1);
			        HUD_Maker.HUD_Preview.setBackgroundImage(imageSceneWarmUp);	
				}
				HUD_Maker.mode();
			}
		});
		
		
		btn_modeSpectator = new Button(sidePanel, SWT.RADIO);
		btn_modeSpectator.setLocation(50, 772);
		btn_modeSpectator.setSize(90, 16);
		btn_modeSpectator.setText("Spectator");
		btn_modeSpectator.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btn_modeSpectator.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mode = 3;
				for (int i = 0; i < 2; i++){
					String imageSceneSpectatorPath = "bin/db_hud/assets/images/imageSceneSpectator.png";
					Image imageSceneSpectator = new Image(display, imageSceneSpectatorPath);
					
					ImageData imageData = HUD_Maker.image_sceneSpectator.getImageData();
					imageData = imageData.scaledTo(HUD_Maker.compX, HUD_Maker.compY);
					ImageLoader imageLoader = new ImageLoader();
			        imageLoader.data = new ImageData[] {imageData};
			        imageLoader.save(imageSceneSpectatorPath, 1);
			        HUD_Maker.HUD_Preview.setBackgroundImage(imageSceneSpectator);	
				}
				HUD_Maker.mode();
			}
		});
		
		btn_modeExecution = new Button(sidePanel, SWT.RADIO);
		btn_modeExecution.setText("Execution");
		btn_modeExecution.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btn_modeExecution.setBounds(50, 812, 105, 16);
		btn_modeExecution.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btn_modeExecution.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mode = 4;
				for (int i = 0; i < 2; i++){String imageSceneExecutionPath = "bin/db_hud/assets/images/imageSceneExe.png";
				Image imageSceneExecution = new Image(display, imageSceneExecutionPath);
				
				ImageData imageData = HUD_Maker.image_sceneExecution.getImageData();
				imageData = imageData.scaledTo(HUD_Maker.compX, HUD_Maker.compY);
				ImageLoader imageLoader = new ImageLoader();
		        imageLoader.data = new ImageData[] {imageData};
		        imageLoader.save(imageSceneExecutionPath, 1);
		        HUD_Maker.HUD_Preview.setBackgroundImage(imageSceneExecution);	
				}
				HUD_Maker.mode();
			}
		});
		
		btn_save = new Button(sidePanel, SWT.PUSH);
		btn_save.setLocation(133, 906);
		btn_save.setSize(78, 25);
		btn_save.setText("Save Preset");
		//btn_save.addSelectionListener(new Save());
		btn_save.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event e){
				
				switch(e.type){
					case SWT.Selection:
						//Read File and store in String[] ShooterUIini
						String iniString = "";
					try {
						ShooterUI = new Scanner(new File("bin/db_hud/assets/ShooterUI.ini"));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
						HUD_Maker.logger.info("ERROR: " + e1.toString());
						
					}
					List<String> FShooterUI = new LinkedList<String>();
					while(ShooterUI.hasNext()){
						iniString = ShooterUI.nextLine().trim();
					    FShooterUI.add(iniString);
					}
					ShooterUI.close();
					newShooterUI = FShooterUI.toArray(new String[0]);
					    
					    
					//Prints String[] for ini file
					/*for(String s : ShooterUIini){
					    System.out.println(s);
					}*/
					//Modify Strings and Write to new File
					    
					for(int i = 0; i < newShooterUI.length; i++)
					  {
					     // if(newShooterUI[i].startsWith("ScopeInfoPosition")){newShooterUI[i] = ScopeInfo.Name + "=" + "(Align=(H=" + ScopeInfo.AlignH + ", V=" + ScopeInfo.AlignV + "), Attach=(H=" + ScopeInfo.AttachH + ", V=" + ScopeInfo.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ScopeInfo.posX + ",Y=" + ScopeInfo.posY + "))";;}
					      if (newShooterUI[i].startsWith("ConsoleMessageLogPosition")){newShooterUI[i] = CnslMsgLog.Name + "=" + "(Align=(H=" + CnslMsgLog.AlignH + ", V=" + CnslMsgLog.AlignV + "), Attach=(H=" + CnslMsgLog.AttachH + ", V=" + CnslMsgLog.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + CnslMsgLog.posX*HUD_Maker.assetRatio + ",Y=" + CnslMsgLog.posY*HUD_Maker.assetRatio + "))";}
					      else if (newShooterUI[i].startsWith("SpectatorConsoleMessageLogPosition")){newShooterUI[i] = SpcCnslMsgLog.Name + "=" + "(Align=(H=" + SpcCnslMsgLog.AlignH + ", V=" + SpcCnslMsgLog.AlignV + "), Attach=(H=" + SpcCnslMsgLog.AttachH + ", V=" + SpcCnslMsgLog.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + SpcCnslMsgLog.posX*HUD_Maker.assetRatio + ",Y=" + SpcCnslMsgLog.posY*HUD_Maker.assetRatio + "))";}
					      else if (newShooterUI[i].startsWith("ChatInputPosition")){newShooterUI[i] = ChatInput.Name + "=" + "(Align=(H=" + ChatInput.AlignH + ", V=" + ChatInput.AlignV + "), Attach=(H=" + ChatInput.AttachH + ", V=" + ChatInput.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ChatInput.posX*HUD_Maker.assetRatio + ",Y=" + ChatInput.posY*HUD_Maker.assetRatio + "))";}
					      else if (newShooterUI[i].startsWith("SpectatorChatInputPosition")){newShooterUI[i] = SpcChatInput.Name + "=" + "(Align=(H=" + SpcChatInput.AlignH + ", V=" + SpcChatInput.AlignV + "), Attach=(H=" + SpcChatInput.AttachH + ", V=" + SpcChatInput.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + SpcChatInput.posX*HUD_Maker.assetRatio + ",Y=" + SpcChatInput.posY*HUD_Maker.assetRatio + "))";}
				          //else if (newShooterUI[i].startsWith("IncapMenuPosition")){newShooterUI[i] = IncapMenu.Name + "=" + "(Align=(H=" + IncapMenu.AlignH + ", V=" + IncapMenu.AlignV + "), Attach=(H=" + IncapMenu.AttachH + ", V=" + IncapMenu.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + IncapMenu.posX*HUD_Maker.assetRatio + ",Y=" + IncapMenu.posY*HUD_Maker.assetRatio + "))";}
				          //else if (newShooterUI[i].startsWith("ObjectiveProgressionPosition")){newShooterUI[i] = ObjPro.Name + "=" + "(Align=(H=" + ObjPro.AlignH + ", V=" + ObjPro.AlignV + "), Attach=(H=" + ObjPro.AttachH + ", V=" + ObjPro.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ObjPro.posX*HUD_Maker.assetRatio + ",Y=" + ObjPro.posY*HUD_Maker.assetRatio + "))";}
				          //else if (newShooterUI[i].startsWith("ObjectiveProgressionNotificationPosition")){newShooterUI[i] = ObjProNtf.Name + "=" + "(Align=(H=" + ObjProNtf.AlignH + ", V=" + ObjProNtf.AlignV + "), Attach=(H=" + ObjProNtf.AttachH + ", V=" + ObjProNtf.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ObjProNtf.posX*HUD_Maker.assetRatio + ",Y=" + ObjProNtf.posY*HUD_Maker.assetRatio + "))";}
				          //else if (newShooterUI[i].startsWith("ObjectiveClockPosition")){newShooterUI[i] = ObjClock.Name + "=" + "(Align=(H=" + ObjClock.AlignH + ", V=" + ObjClock.AlignV + "), Attach=(H=" + ObjClock.AttachH + ", V=" + ObjClock.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ObjClock.posX*HUD_Maker.assetRatio + ",Y=" + ObjClock.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("MinimapPosition")){newShooterUI[i] = MiniMap.Name + "=" + "(Align=(H=" + MiniMap.AlignH + ", V=" + MiniMap.AlignV + "), Attach=(H=" + MiniMap.AttachH + ", V=" + MiniMap.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + MiniMap.posX*HUD_Maker.assetRatio + ",Y=" + MiniMap.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ObituaryMessageLogPosition")){newShooterUI[i] = ObitMsg.Name + "=" + "(Align=(H=" + ObitMsg.AlignH + ", V=" + ObitMsg.AlignV + "), Attach=(H=" + ObitMsg.AttachH + ", V=" + ObitMsg.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ObitMsg.posX*HUD_Maker.assetRatio + ",Y=" + ObitMsg.posY*HUD_Maker.assetRatio + "))";}
				          //else if (newShooterUI[i].startsWith("InteractionFillbarPosition")){newShooterUI[i] = IntFillBar.Name + "=" + "(Align=(H=" + IntFillBar.AlignH + ", V=" + IntFillBar.AlignV + "), Attach=(H=" + IntFillBar.AttachH + ", V=" + IntFillBar.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + IntFillBar.posX*HUD_Maker.assetRatio + ",Y=" + IntFillBar.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ExpCounter")){newShooterUI[i] = XpCounter.Name + "=" + "(Align=(H=" + XpCounter.AlignH + ", V=" + XpCounter.AlignV + "), Attach=(H=" + XpCounter.AttachH + ", V=" + XpCounter.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + XpCounter.posX*HUD_Maker.assetRatio + ",Y=" + XpCounter.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + XpCounter.sosX + ", Y=" + XpCounter.sosY + "))";}
				          //else if (newShooterUI[i].startsWith("GameplayNotificationPosition")){newShooterUI[i] = GameplayNtf.Name + "=" + "(Align=(H=" + GameplayNtf.AlignH + ", V=" + GameplayNtf.AlignV + "), Attach=(H=" + GameplayNtf.AttachH + ", V=" + GameplayNtf.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + GameplayNtf.posX*HUD_Maker.assetRatio + ",Y=" + GameplayNtf.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("SubtitlesPosition")){newShooterUI[i] = Subtitles.Name + "=" + "(Align=(H=" + Subtitles.AlignH + ", V=" + Subtitles.AlignV + "), Attach=(H=" + Subtitles.AttachH + ", V=" + Subtitles.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + Subtitles.posX*HUD_Maker.assetRatio + ",Y=" + Subtitles.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ObjectiveNotificationPosition")){newShooterUI[i] = ObjNtf.Name + "=" + "(Align=(H=" + ObjNtf.AlignH + ", V=" + ObjNtf.AlignV + "), Attach=(H=" + ObjNtf.AttachH + ", V=" + ObjNtf.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ObjNtf.posX*HUD_Maker.assetRatio + ",Y=" + ObjNtf.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + ObjNtf.sosX + ", Y=" + ObjNtf.sosY + "))";}
				         // else if (newShooterUI[i].startsWith("GameInfoPosition")){newShooterUI[i] = GameInfo.Name + "=" + "(Align=(H=" + GameInfo.AlignH + ", V=" + GameInfo.AlignV + "), Attach=(H=" + GameInfo.AttachH + ", V=" + GameInfo.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + GameInfo.posX*HUD_Maker.assetRatio + ",Y=" + GameInfo.posY*HUD_Maker.assetRatio + "))";}
				         // else if (newShooterUI[i].startsWith("SpectatorInfoPosition")){newShooterUI[i] = SpcInfo.Name + "=" + "(Align=(H=" + SpcInfo.AlignH + ", V=" + SpcInfo.AlignV + "), Attach=(H=" + SpcInfo.AttachH + ", V=" + SpcInfo.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + SpcInfo.posX*HUD_Maker.assetRatio + ",Y=" + SpcInfo.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + SpcInfo.sosX + ", Y=" + SpcInfo.sosY + "))";}
				          else if (newShooterUI[i].startsWith("DetectedNotificationPosition")){newShooterUI[i] = Detected.Name + "=" + "(Align=(H=" + Detected.AlignH + ", V=" + Detected.AlignV + "), Attach=(H=" + Detected.AttachH + ", V=" + Detected.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + Detected.posX*HUD_Maker.assetRatio + ",Y=" + Detected.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("WeaponAmmoPosition")){newShooterUI[i] = WeaponAmmo.Name + "=" + "(Align=(H=" + WeaponAmmo.AlignH + ", V=" + WeaponAmmo.AlignV + "), Attach=(H=" + WeaponAmmo.AttachH + ", V=" + WeaponAmmo.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + WeaponAmmo.posX*HUD_Maker.assetRatio + ",Y=" + WeaponAmmo.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + WeaponAmmo.sosX + ", Y=" + WeaponAmmo.sosY + "))";}
				          else if (newShooterUI[i].startsWith("AbilityCooldownPosition")){newShooterUI[i] = AbilityCooldown.Name + "=" + "(Align=(H=" + AbilityCooldown.AlignH + ", V=" + AbilityCooldown.AlignV + "), Attach=(H=" + AbilityCooldown.AttachH + ", V=" + AbilityCooldown.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + AbilityCooldown.posX*HUD_Maker.assetRatio + ",Y=" + AbilityCooldown.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + AbilityCooldown.sosX + ", Y=" + AbilityCooldown.sosY + "))";}
				         // else if (newShooterUI[i].startsWith("CarryBombPosition")){newShooterUI[i] = CarryBomb.Name + "=" + "(Align=(H=" + CarryBomb.AlignH + ", V=" + CarryBomb.AlignV + "), Attach=(H=" + CarryBomb.AttachH + ", V=" + CarryBomb.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + CarryBomb.posX*HUD_Maker.assetRatio + ",Y=" + CarryBomb.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + CarryBomb.sosX + ", Y=" + CarryBomb.sosY + "))";}
				          else if (newShooterUI[i].startsWith("PlayerHealthPosition")){newShooterUI[i] = PlayerHealth.Name + "=" + "(Align=(H=" + PlayerHealth.AlignH + ", V=" + PlayerHealth.AlignV + "), Attach=(H=" + PlayerHealth.AttachH + ", V=" + PlayerHealth.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + PlayerHealth.posX*HUD_Maker.assetRatio + ",Y=" + PlayerHealth.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + PlayerHealth.sosX + ", Y=" + PlayerHealth.sosY + "))";}
				          else if (newShooterUI[i].startsWith("ShieldBarPosition")){newShooterUI[i] = ShieldBar.Name + "=" + "(Align=(H=" + ShieldBar.AlignH + ", V=" + ShieldBar.AlignV + "), Attach=(H=" + ShieldBar.AttachH + ", V=" + ShieldBar.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ShieldBar.posX*HUD_Maker.assetRatio + ",Y=" + ShieldBar.posY*HUD_Maker.assetRatio + "), ShadowOffset=(X=" + ShieldBar.sosX + ", Y=" + ShieldBar.sosY + "))";}
				          else if (newShooterUI[i].startsWith("ReadyUpPosition")){newShooterUI[i] = ReadyUp.Name + "=" + "(Align=(H=" + ReadyUp.AlignH + ", V=" + ReadyUp.AlignV + "), Attach=(H=" + ReadyUp.AttachH + ", V=" + ReadyUp.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ReadyUp.posX*HUD_Maker.assetRatio + ",Y=" + ReadyUp.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("BadgeNotificationPosition")){newShooterUI[i] = BadgeNtf.Name + "=" + "(Align=(H=" + BadgeNtf.AlignH + ", V=" + BadgeNtf.AlignV + "), Attach=(H=" + BadgeNtf.AttachH + ", V=" + BadgeNtf.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + BadgeNtf.posX*HUD_Maker.assetRatio + ",Y=" + BadgeNtf.posY*HUD_Maker.assetRatio + "))";}
				         // else if (newShooterUI[i].startsWith("DeathInfoCardPosition")){newShooterUI[i] = DeathInfoCard.Name + "=" + "(Align=(H=" + DeathInfoCard.AlignH + ", V=" + DeathInfoCard.AlignV + "), Attach=(H=" + DeathInfoCard.AttachH + ", V=" + DeathInfoCard.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + DeathInfoCard.posX*HUD_Maker.assetRatio + ",Y=" + DeathInfoCard.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("SpectatorGameWaveTimerPosition")){newShooterUI[i] = SpcGameWaveTimer.Name + "=" + "(Align=(H=" + SpcGameWaveTimer.AlignH + ", V=" + SpcGameWaveTimer.AlignV + "), Attach=(H=" + SpcGameWaveTimer.AttachH + ", V=" + SpcGameWaveTimer.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + SpcGameWaveTimer.posX*HUD_Maker.assetRatio + ",Y=" + SpcGameWaveTimer.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("GameWaveTimerPosition")){newShooterUI[i] = GameWaveTimer.Name + "=" + "(Align=(H=" + GameWaveTimer.AlignH + ", V=" + GameWaveTimer.AlignV + "), Attach=(H=" + GameWaveTimer.AttachH + ", V=" + GameWaveTimer.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + GameWaveTimer.posX*HUD_Maker.assetRatio + ",Y=" + GameWaveTimer.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ObjectivePosition")){newShooterUI[i] = ObjPos.Name + "=" + "(Align=(H=" + ObjPos.AlignH + ", V=" + ObjPos.AlignV + "), Attach=(H=" + ObjPos.AttachH + ", V=" + ObjPos.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ObjPos.posX*HUD_Maker.assetRatio + ",Y=" + ObjPos.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("SpectatorObjectivePosition")){newShooterUI[i] = SpcObjPos.Name + "=" + "(Align=(H=" + SpcObjPos.AlignH + ", V=" + SpcObjPos.AlignV + "), Attach=(H=" + SpcObjPos.AttachH + ", V=" + SpcObjPos.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + SpcObjPos.posX*HUD_Maker.assetRatio + ",Y=" + SpcObjPos.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ActionMenuPosition")){newShooterUI[i] = ActionMenu.Name + "=" + "(Align=(H=" + ActionMenu.AlignH + ", V=" + ActionMenu.AlignV + "), Attach=(H=" + ActionMenu.AttachH + ", V=" + ActionMenu.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ActionMenu.posX*HUD_Maker.assetRatio + ",Y=" + ActionMenu.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("SpectatorActionMenuPosition")){newShooterUI[i] = SpcActionMenu.Name + "=" + "(Align=(H=" + SpcActionMenu.AlignH + ", V=" + SpcActionMenu.AlignV + "), Attach=(H=" + SpcActionMenu.AttachH + ", V=" + SpcActionMenu.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + SpcActionMenu.posX*HUD_Maker.assetRatio + ",Y=" + SpcActionMenu.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("CharacterSelectPostion")){newShooterUI[i] = CharSelect.Name + "=" + "(Align=(H=" + CharSelect.AlignH + ", V=" + CharSelect.AlignV + "), Attach=(H=" + CharSelect.AttachH + ", V=" + CharSelect.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + CharSelect.posX*HUD_Maker.assetRatio + ",Y=" + CharSelect.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("SpectatorCardPosition")){newShooterUI[i] = SpcCard.Name + "=" + "(Align=(H=" + SpcCard.AlignH + ", V=" + SpcCard.AlignV + "), Attach=(H=" + SpcCard.AttachH + ", V=" + SpcCard.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + SpcCard.posX*HUD_Maker.assetRatio + ",Y=" + SpcCard.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ExecutionGameStatusPosition")){newShooterUI[i] = ExeGameStat.Name + "=" + "(Align=(H=" + ExeGameStat.AlignH + ", V=" + ExeGameStat.AlignV + "), Attach=(H=" + ExeGameStat.AttachH + ", V=" + ExeGameStat.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ExeGameStat.posX*HUD_Maker.assetRatio + ",Y=" + ExeGameStat.posY*HUD_Maker.assetRatio + "))";}
				         // else if (newShooterUI[i].startsWith("ExecutionCountdownPosition")){newShooterUI[i] = ExeCountDown.Name + "=" + "(Align=(H=" + ExeCountDown.AlignH + ", V=" + ExeCountDown.AlignV + "), Attach=(H=" + ExeCountDown.AttachH + ", V=" + ExeCountDown.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ExeCountDown.posX*HUD_Maker.assetRatio + ",Y=" + ExeCountDown.posY*HUD_Maker.assetRatio + "))";}
				          //else if (newShooterUI[i].startsWith("ExecutionRoundNotificationPosition")){newShooterUI[i] = ExeRoundNtf.Name + "=" + "(Align=(H=" + ExeRoundNtf.AlignH + ", V=" + ExeRoundNtf.AlignV + "), Attach=(H=" + ExeRoundNtf.AttachH + ", V=" + ExeRoundNtf.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ExeRoundNtf.posX*HUD_Maker.assetRatio + ",Y=" + ExeRoundNtf.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ExecutionRoundIntroPosition")){newShooterUI[i] = ExeRoundIntro.Name + "=" + "(Align=(H=" + ExeRoundIntro.AlignH + ", V=" + ExeRoundIntro.AlignV + "), Attach=(H=" + ExeRoundIntro.AttachH + ", V=" + ExeRoundIntro.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ExeRoundIntro.posX*HUD_Maker.assetRatio + ",Y=" + ExeRoundIntro.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("DebilitatedNotificationPosition")){newShooterUI[i] = DebPos.Name + "=" + "(Align=(H=" + DebPos.AlignH + ", V=" + DebPos.AlignV + "), Attach=(H=" + DebPos.AttachH + ", V=" + DebPos.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + DebPos.posX*HUD_Maker.assetRatio + ",Y=" + DebPos.posY*HUD_Maker.assetRatio + "))";}
				          else if (newShooterUI[i].startsWith("ExecutionBadgeNotificationPosition")){newShooterUI[i] = ExeBadge.Name + "=" + "(Align=(H=" + ExeBadge.AlignH + ", V=" + ExeBadge.AlignV + "), Attach=(H=" + ExeBadge.AttachH + ", V=" + ExeBadge.AttachV + ", HA=\"\", VA=\"\"), PixelOffset=(X=" + ExeBadge.posX*HUD_Maker.assetRatio + ",Y=" + ExeBadge.posY*HUD_Maker.assetRatio + "))";}
					      //Color
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDIFFObjectAlly]")){newShooterUI[i+1] = "m_PrimaryColor=(R= " + AllyColor.ColorR + ", G= " + AllyColor.ColorG + ", B= " + AllyColor.ColorB + ", A= " + AllyColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDIFFObjectAlly]")){newShooterUI[i+2] = "m_SecondaryColour=(R= " + AllyColor2.ColorR + ", G= " + AllyColor2.ColorG + ", B= " + AllyColor2.ColorB + ", A= " + AllyColor2.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDIFFObjectEnemy]")){newShooterUI[i+1] = "m_PrimaryColor=(R= " + EnemyColor.ColorR + ", G= " + EnemyColor.ColorG + ", B= " + EnemyColor.ColorB + ", A= " + EnemyColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDConsoleMessageLog]")){newShooterUI[i+1] = "m_NeutralColor=(R= " + NeutralColor.ColorR + ", G= " + NeutralColor.ColorG + ", B= " + NeutralColor.ColorB + ", A= " + NeutralColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIMenuChatLog]")){newShooterUI[i+1] = "m_NeutralColor=(R= " + NeutralColor.ColorR + ", G= " + NeutralColor.ColorG + ", B= " + NeutralColor.ColorB + ", A= " + NeutralColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDGameInfoScore]")){newShooterUI[i+1] = "m_NeutralColor=(R= " + NeutralColor2.ColorR + ", G= " + NeutralColor2.ColorG + ", B= " + NeutralColor2.ColorB + ", A= " + NeutralColor2.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDIFFObjectAI]")){newShooterUI[i+8] = "m_PrimaryColor=(R= " + AIColor.ColorR + ", G= " + AIColor.ColorG + ", B= " + AIColor.ColorB + ", A= " + AIColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDIFFPrimaryObjective]")){newShooterUI[i+1] = "m_PrimaryColor=(R= " + PrimaryObjColor.ColorR + ", G= " + PrimaryObjColor.ColorG + ", B= " + PrimaryObjColor.ColorB + ", A= " + PrimaryObjColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDWeaponAmmo]")){newShooterUI[i+2] = "m_AmmoColor=(R= " + AmmoColor.ColorR + ", G= " + AmmoColor.ColorG + ", B= " + AmmoColor.ColorB + ", A= " + AmmoColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDWeaponAmmo]")){newShooterUI[i+3] = "m_LowAmmoColor=(R= " + LowAmmoColor.ColorR + ", G= " + LowAmmoColor.ColorG + ", B= " + LowAmmoColor.ColorB + ", A= " + LowAmmoColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDWeaponAmmo]")){newShooterUI[i+4] = "m_LowAmmoColor2=(R= " + LowAmmoColor2.ColorR + ", G= " + LowAmmoColor2.ColorG + ", B= " + LowAmmoColor2.ColorB + ", A= " + LowAmmoColor2.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDWeaponAmmo]")){newShooterUI[i+1] = "m_NoAmmoColor=(R= " + NoAmmoColor.ColorR + ", G= " + NoAmmoColor.ColorG + ", B= " + NoAmmoColor.ColorB + ", A= " + NoAmmoColor.ColorA + ")";}
				          //else if (newShooterUI[i].contains("[ShooterGame.SGUIHUDGrenadeIndicator]")){newShooterUI[i+8] = "m_BlinkColor1=(R= " + GrenadeBlinkColor.ColorR + ", G= " + GrenadeBlinkColor.ColorG + ", B= " + GrenadeBlinkColor.ColorB + ", A= " + GrenadeBlinkColor.ColorA + ")";}
				          //else if (newShooterUI[i].contains("[ShooterGame.SGUIHUDGrenadeIndicator]")){newShooterUI[i+9] = "m_BlinkColor2=(R= " + GrenadeBlinkColor2.ColorR + ", G= " + GrenadeBlinkColor2.ColorG + ", B= " + GrenadeBlinkColor2.ColorB + ", A= " + GrenadeBlinkColor2.ColorA + ")";}
				          //else if (newShooterUI[i].contains("[ShooterGame.SGUIHUDGrenadeIndicator]")){newShooterUI[i+10] = "m_GrenadeOutOfView1=(R= " + GrenadeOOVColor1.ColorR + ", G= " + GrenadeOOVColor1.ColorG + ", B= " + GrenadeOOVColor1.ColorB + ", A= " + GrenadeOOVColor1.ColorA + ")";}
				          //else if (newShooterUI[i].contains("[ShooterGame.SGUIHUDGrenadeIndicator]")){newShooterUI[i+11] = "m_GrenadeOutOfView2=(R= " + GrenadeOOVColor2.ColorR + ", G= " + GrenadeOOVColor2.ColorG + ", B= " + GrenadeOOVColor2.ColorB + ", A= " + GrenadeOOVColor2.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDIFFObjectPrimaryPerformer]")){newShooterUI[i+1] = "m_PrimaryColor=(R= " + PrimaryPerformerColor.ColorR + ", G= " + PrimaryPerformerColor.ColorG + ", B= " + PrimaryPerformerColor.ColorB + ", A= " + PrimaryPerformerColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDMinimapIcon]")){newShooterUI[i+8] = "m_PrimaryColor=(R= " + MapIconPrimaryColor.ColorR + ", G= " + MapIconPrimaryColor.ColorG + ", B= " + MapIconPrimaryColor.ColorB + ", A= " + MapIconPrimaryColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("[ShooterGame.SGUIHUDMinimapIcon]")){newShooterUI[i+8] = "m_SecondaryColor=(R= " + MapIconSecondaryColor.ColorR + ", G= " + MapIconSecondaryColor.ColorG + ", B= " + MapIconSecondaryColor.ColorB + ", A= " + MapIconSecondaryColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("m_AlliedColor")){newShooterUI[i] = "m_AlliedColor=(R= " + AlliedColor.ColorR + ", G= " + AlliedColor.ColorG + ", B= " + AlliedColor.ColorB + ", A= " + AlliedColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("m_EnemyColor")){newShooterUI[i] = "m_EnemyColor=(R= " + EnemyColor2.ColorR + ", G= " + EnemyColor2.ColorG + ", B= " + EnemyColor2.ColorB + ", A= " + EnemyColor2.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("m_HighlightedBGColor")){newShooterUI[i] = "m_HighlightedBGColor=(R= " + HighlightedBGColor.ColorR + ", G= " + HighlightedBGColor.ColorG + ", B= " + HighlightedBGColor.ColorB + ", A= " + HighlightedBGColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("m_DeafultBGColor")){newShooterUI[i] = "m_DeafaultBGColor=(R= " + DefaultBGColor.ColorR + ", G= " + DefaultBGColor.ColorG + ", B= " + DefaultBGColor.ColorB + ", A= " + DefaultBGColor.ColorA + ")";}
				          //else if (newShooterUI[i].contains("m_BlinkColor")){newShooterUI[i] = "m_BlinkColor=(R= " + BlinkColor.ColorR + ", G= " + BlinkColor.ColorG + ", B= " + BlinkColor.ColorB + ", A= " + BlinkColor.ColorA + ")";}
				          else if (newShooterUI[i].startsWith("m_TeamColor")){newShooterUI[i] = "m_TeamColor=(R= " + AlliedColor.ColorR + ", G= " + AlliedColor.ColorG + ", B= " + AlliedColor.ColorB + ", A= " + AlliedColor.ColorA + ")";}

					      
					      else {}
				       }
					
				    try {
				    	s2 = new Shell(d2, SWT.ON_TOP);
						FileDialog fd = new FileDialog(s2, SWT.SAVE);
						fd.setText("Save Preset");
						fd.setFilterPath("C:/");
						fd.setFileName("ShooterUI");
						fd.setOverwrite(true);
						String[] fileExt = {"*.ini"};
						fd.setFilterExtensions(fileExt);
						selection = fd.open();
						//d2 = new Display();
						System.out.println(selection);
						HUD_Maker.logger.info(selection);
						File file = new File(selection);
							// if file doesn't exist, then create it
						if (!file.exists()) {
							file.createNewFile();
						}
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						for(String s : newShooterUI){
				    		System.out.println(s);
					    	bw.write(s);
					    	bw.newLine();
						}
						bw.close();
						//file.setReadOnly();
						System.out.println("Done");
						HUD_Maker.logger.info("Done.");
						
					} catch (Exception e2) {
						while (s2.isDisposed()) {
					          if (d2.readAndDispatch()){
					            d2.sleep();
					          }
					        }
					      //d2.dispose();
						e2.printStackTrace();
						HUD_Maker.logger.info("ERROR: " + e2.toString());
					}
					    
				}
			}
		});
		
		btn_load = new Button(sidePanel, SWT.NONE);
		btn_load.setLocation(50, 906);
		btn_load.setSize(78, 25);
		btn_load.setEnabled(false);
		btn_load.setText("Load Preset");
		
		btn_color = new Button(sidePanel, SWT.NONE);
		btn_color.setLocation(50, 686);
		btn_color.setSize(80, 25);
		btn_color.setEnabled(false);
		btn_color.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ColorWindow.open();
			}
		});
		btn_color.setText("Color Options");
		
		btn_reset = new Button(sidePanel, SWT.NONE);
		btn_reset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {	
				cr.reset();
			}
		});
		btn_reset.setLocation(50, 936);
		btn_reset.setSize(78, 25);
		btn_reset.setEnabled(true);
		btn_reset.setText("Reset");
		
		
		btn_resetAll = new Button(sidePanel, SWT.NONE);
		btn_resetAll.setLocation(133, 936);
		btn_resetAll.setSize(78, 25);
		btn_resetAll.setEnabled(true);
		btn_resetAll.setText("Reset All");
		btn_resetAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				for (int i = 0; i < hudAssets.size(); i++){
					asset = hudAssets.get(i);
					System.out.println(asset.Name);
					asset.resetAll();
					//cr.reset();
				}
			}
		});
		
		btn_settings = new Button(sidePanel, SWT.NONE);
		btn_settings.setText("Settings");
		btn_settings.setBounds(50, 967, 160, 25);
		btn_settings.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Settings.settings.setVisible(true);
				Settings.settings.setFocus();
				Settings.settings.setActive();
			}
		});
		
		Label lbl_HudAsset = new Label(sidePanel, SWT.NONE);
		lbl_HudAsset.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lbl_HudAsset.setLocation(50, 49);
		lbl_HudAsset.setSize(125, 15);
		lbl_HudAsset.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_HudAsset.setText("HUD Asset Selected");
		
		Label lbl_Attach = new Label(sidePanel, SWT.NONE);
		lbl_Attach.setLocation(85, 130);
		lbl_Attach.setSize(90, 20);
		lbl_Attach.setAlignment(SWT.CENTER);
		lbl_Attach.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_Attach.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lbl_Attach.setText("Attachment");
		
		Label lbl_Align = new Label(sidePanel, SWT.NONE);
		lbl_Align.setLocation(85, 230);
		lbl_Align.setSize(90, 20);
		lbl_Align.setAlignment(SWT.CENTER);
		lbl_Align.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_Align.setText("Alignment");
		lbl_Align.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		
		Label lbl_pixelOffset = new Label(sidePanel, SWT.NONE);
		lbl_pixelOffset.setLocation(85, 330);
		lbl_pixelOffset.setSize(90, 20);
		lbl_pixelOffset.setAlignment(SWT.CENTER);
		lbl_pixelOffset.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_pixelOffset.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lbl_pixelOffset.setText("Pixel Offset");
		
		Label lbl_pox = new Label(sidePanel, SWT.NONE);
		lbl_pox.setLocation(45, 361);
		lbl_pox.setSize(74, 15);
		lbl_pox.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_pox.setText("Pixel Offset X");
		
		Label lbl_poy = new Label(sidePanel, SWT.NONE);
		lbl_poy.setLocation(45, 391);
		lbl_poy.setSize(74, 15);
		lbl_poy.setText("Pixel Offset Y");
		lbl_poy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lbl_shadowOffset = new Label(sidePanel, SWT.NONE);
		lbl_shadowOffset.setLocation(75, 430);
		lbl_shadowOffset.setSize(110, 20);
		lbl_shadowOffset.setAlignment(SWT.CENTER);
		lbl_shadowOffset.setText("Shadow Offset");
		lbl_shadowOffset.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lbl_shadowOffset.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lbl_sos = new Label(sidePanel, SWT.NONE);
		lbl_sos.setLocation(45, 461);
		lbl_sos.setSize(97, 15);
		lbl_sos.setText("Shadow Offset X");
		lbl_sos.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lbl_soy = new Label(sidePanel, SWT.NONE);
		lbl_soy.setLocation(45, 491);
		lbl_soy.setSize(89, 15);
		lbl_soy.setText("Shadow Offset Y");
		lbl_soy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lbl_Presets = new Label(sidePanel, SWT.NONE);
		lbl_Presets.setLocation(96, 845);
		lbl_Presets.setSize(60, 23);
		lbl_Presets.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_Presets.setAlignment(SWT.CENTER);
		lbl_Presets.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lbl_Presets.setText("Presets");
		
		Label lbl_AtH = new Label(sidePanel, SWT.NONE);
		lbl_AtH.setLocation(50, 161);
		lbl_AtH.setSize(55, 15);
		lbl_AtH.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_AtH.setText("Horizontal");
		
		Label lbl_AtV = new Label(sidePanel, SWT.NONE);
		lbl_AtV.setLocation(50, 191);
		lbl_AtV.setSize(38, 15);
		lbl_AtV.setText("Vertical");
		lbl_AtV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lbl_AV = new Label(sidePanel, SWT.NONE);
		lbl_AV.setLocation(50, 291);
		lbl_AV.setSize(38, 15);
		lbl_AV.setText("Vertical");
		lbl_AV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lbl_AH = new Label(sidePanel, SWT.NONE);
		lbl_AH.setLocation(50, 261);
		lbl_AH.setSize(55, 15);
		lbl_AH.setText("Horizontal");
		lbl_AH.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblMode = new Label(sidePanel, SWT.NONE);
		lblMode.setLocation(108, 729);
		lblMode.setSize(38, 15);
		lblMode.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblMode.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMode.setText("Mode");
		
		Label lbl_Other = new Label(sidePanel, SWT.NONE);
		lbl_Other.setLocation(106, 530);
		lbl_Other.setSize(46, 21);
		lbl_Other.setAlignment(SWT.CENTER);
		lbl_Other.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lbl_Other.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_Other.setText("Other");
		
		Label lbl_Value = new Label(sidePanel, SWT.NONE);
		lbl_Value.setLocation(50, 597);
		lbl_Value.setSize(55, 15);
		lbl_Value.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_Value.setText("Value");
		
		/*lblDirtyBombHud = new Label(sidePanel, SWT.NONE);
		lblDirtyBombHud.setImage(image_HUDOptions);
		//lblDirtyBombHud.setFont(SWTResourceManager.getFont("DirtyBomb_DD_Black", 12, SWT.BOLD));
		lblDirtyBombHud.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		//lblDirtyBombHud.setBackground(null);
		lblDirtyBombHud.setBounds(22, 10, 200, 25);
		//lblDirtyBombHud.setText("HUD Options");
		System.out.println(lblDirtyBombHud.getImage());*/
		
		
		Label lblDirtyBombHud = new Label(sidePanel, SWT.NONE);
		lblDirtyBombHud.setAlignment(SWT.CENTER);
		lblDirtyBombHud.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDirtyBombHud.setBounds(22, 13, 200, 25);
		lblDirtyBombHud.setImage(image_HUDOptions);
		System.out.println(lblDirtyBombHud.getImage());
		
		Label lbl_color = new Label(sidePanel, SWT.NONE);
		lbl_color.setBounds(100, 626, 54, 22);
		lbl_color.setAlignment(SWT.CENTER);
		lbl_color.setText("Color");
		lbl_color.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lbl_color.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Xyfurion = new Label(sidePanel, SWT.NONE);
		Xyfurion.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		Xyfurion.setAlignment(SWT.CENTER);
		Xyfurion.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Xyfurion.setBounds(50, 1019, 160, 15);
		Xyfurion.setText("Developed by Xyfurion");
		btn_reset.addListener(SWT.Selection, new Listener(){
			public void handleEvent (Event event){
				//if (cr.OAttachH == Right){cr.cAttachH = "Right"; Attach_H.setText("Right"); cr.AttachH = Right;}
				//else if (cr.OAttachH == Center){cr.cAttachH = "Center"; Attach_H.setText("Center"); cr.AttachH = Center;}
				//else if (cr.OAttachH == Left){cr.cAttachH = "Left"; Attach_H.setText("Left"); cr.AttachH = Left;}
			}
		});
		
		Label link_forum = new Label(sidePanel, SWT.NONE);
		link_forum.setAlignment(SWT.CENTER);
		link_forum.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		link_forum.setForeground(SWTResourceManager.getColor(255,128,0));
		link_forum.setBounds(105, 1040, 50, 15);
		link_forum.setText("Forums");
		link_forum.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {}
			public void mouseDown(MouseEvent e) {}
			public void mouseUp(MouseEvent e) {
				Program.launch("http://forums.dirtybomb.nexon.net/profile/Xyfurion");
			}
			
		    });
		link_forum.addListener(SWT.MouseEnter, new Listener(){
			public void handleEvent(Event event) {
				link_forum.setCursor(cursor_hand);
			}
			
		});
		link_forum.addListener(SWT.MouseExit, new Listener(){
			public void handleEvent(Event event) {
				link_forum.setCursor(cursor_normal);
			}
		});
		
		Label link_twitter = new Label(sidePanel, SWT.NONE);
		link_twitter.setAlignment(SWT.RIGHT);
		link_twitter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		link_twitter.setForeground(SWTResourceManager.getColor(255,128,0));
		link_twitter.setBounds(160, 1040, 50, 15);
		link_twitter.setText("Twitter");
		link_twitter.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {}
			public void mouseDown(MouseEvent e) {}
			public void mouseUp(MouseEvent e) {
				Program.launch("https://twitter.com/Xyfurion");
			}
			
		    });
		link_twitter.addListener(SWT.MouseEnter, new Listener(){
			public void handleEvent(Event event) {
				link_twitter.setCursor(cursor_hand);
			}
			
		});
		link_twitter.addListener(SWT.MouseExit, new Listener(){
			public void handleEvent(Event event) {
				link_twitter.setCursor(cursor_normal);
			}
		});
		
		Label link_reddit = new Label(sidePanel, SWT.NONE);
		link_reddit.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		link_reddit.setForeground(SWTResourceManager.getColor(255,128,0));
		link_reddit.setBounds(50, 1040, 50, 15);
		link_reddit.setText("Reddit");
		link_reddit.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {}
			public void mouseDown(MouseEvent e) {}
			public void mouseUp(MouseEvent e) {
				Program.launch("https://www.reddit.com/user/Xyfurion/");
			}
			
		    });
		link_reddit.addListener(SWT.MouseEnter, new Listener(){
			public void handleEvent(Event event) {
				link_reddit.setCursor(cursor_hand);
			}
			
		});
		link_reddit.addListener(SWT.MouseExit, new Listener(){
			public void handleEvent(Event event) {
				link_reddit.setCursor(cursor_normal);
			}
		});
		
		Button btnSOSelected = new Button(sidePanel, SWT.CHECK);
		btnSOSelected.setBounds(50, 106, 160, 16);
		btnSOSelected.setText("Show Only Selected");
		btnSOSelected.addSelectionListener(new SelectionAdapter(){
		    public void widgetSelected(SelectionEvent e) {
		    	if (btnSOSelected.getSelection()){showOS = 1; SoS();}
		    	else{showOS = 0; SoS();}
		    	//Note: if asset is deselected, show all other assets
		    }
		});
		
		icon_close = new Image(d2, icon_closePath);
		
		Label lblMinimize = new Label(Options_UI, SWT.NONE);
		lblMinimize.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMinimize.setBounds(230, 0, 25, 25);
		lblMinimize.setImage(icon_close);
		lblMinimize.addMouseListener(new MouseListener(){
			public void mouseUp(MouseEvent e){
				//Options_UI.setMinimized(true);
				Options_UI.setVisible(false);
			}

			public void mouseDoubleClick(MouseEvent e) {}

			public void mouseDown(MouseEvent e) {}
		});
		lblMinimize.addListener(SWT.MouseEnter, new Listener(){
			public void handleEvent(Event event) {
				lblMinimize.setBackground(SWTResourceManager.getColor(255,0,0));
			}
			
		});
		lblMinimize.addListener(SWT.MouseExit, new Listener(){
			public void handleEvent(Event event) {
				lblMinimize.setBackground(SWTResourceManager.getColor(255,255,255));
			}
		});
		
		Composite dragbar = new Composite(Options_UI, SWT.NONE);
		dragbar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		dragbar.setBounds(0, 0, 230, 25);
		dragbar.addMouseListener(new MouseListener(){
			public void mouseDoubleClick(MouseEvent e) {
				Options_UI.setMinimized(true);
			}

			public void mouseDown(MouseEvent e) {
				isMouseDown=true;
                xPos=e.x;
                yPos=e.y;
			}

			public void mouseUp(MouseEvent e) {
				isMouseDown = false;
			}
		});
		dragbar.addMouseMoveListener(new MouseMoveListener(){
			public void mouseMove(MouseEvent e) {
				if(isMouseDown == true){
                    Options_UI.setLocation(Options_UI.getLocation().x+(e.x-xPos),Options_UI.getLocation().y+(e.y-yPos));
				}
			}
		});
	}
}
