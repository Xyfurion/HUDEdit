package db_hud;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Button;

/**
 * 
 * @author Xyfurion Licensed Under Creative Commons License (ND, NC), Apache 2.0
 *         License You may NOT use this source code for any commercial use. You
 *         may copy, use, and display if and only if credit is given to Author.
 *         You may NOT alter and redistribute without explicit permission from
 *         Author. Started work: 17th December 2015. Dev Version 1.0 Completion:
 *         29th January 2016.
 *
 */

public class HUD_Maker {

	public static Label img_Anchor;

	public static Button btnTest;

	public static Label cl;

	public static Label lineH;
	public static Label lineV;

	public static ArrayList<Label> assets;

	public static Label img_Ability;
	public static Label img_Minimap;
	public static Label img_ActionMenu;
	public static Label img_ActionMenuSpec;
	public static Label img_Objective;
	public static Label img_ObjectiveSpec;
	public static Label img_Armor;
	public static Label img_Badge;
	public static Label img_CharacterSelect;
	public static Label img_ChatInput;
	public static Label img_ChatInputSpec;
	public static Label img_Debilitated;
	public static Label img_Detected;
	public static Label img_ExeBadge;
	public static Label img_ExeGameStat;
	public static Label img_GameWave;
	public static Label img_GameWaveSpec;
	public static Label img_Health;
	public static Label img_MessageLog;
	public static Label img_MessageLogSpec;
	public static Label img_Obituary;
	public static Label img_ObituarySpec;
	public static Label img_ObjectiveNotification;
	public static Label img_ReadyUp;
	public static Label img_RoundIntro;
	public static Label img_SpectatorCard;
	public static Label img_Subtitles;
	public static Label img_WeaponAmmo;
	public static Label img_XP;

	public static int compX = 1280, compY = 720;
	public static int sizeX = 1280, sizeY = 720;
	public static int xPos = 0;
	public static int yPos = 0;
	// public static int imgPosX = 0;
	// public static int imgPosY = 0;
	// public static int positionX;
	// public static int positionY;

	// public static int gridSize = 20;

	public static int imageSelected = 0;

	public static int imgX;
	public static int imgY;
	public static int location = 0;
	public static int alignLocation = 0;
	public static int section = 0;
	public static int gridIncrement = 25;

	public static Boolean isMouseDown = false;
	public static Boolean imgIsMouseDown = false;

	// public static Boolean showGrid = true;
	// public static Boolean showCenter = true;
	// public static Boolean snapGrid = true;

	public static Display display;
	// public static Display d = new Display();
	// public static Shell s = new Shell(d);

	protected static Shell App_UI;
	public static Composite HUD_Preview;
	public static ScrolledComposite frame;

	// public static String version;
	public static String fontpath_din = "bin/db_hud/assets/Din_regular.ttf";
	public static String icon_Path = "bin/db_hud/assets/HUDEdit_Icon.ico";
	public static String icon_closePath = "bin/db_hud/assets/images/icon_Close.png";
	public static String icon_fullScreenPath = "bin/db_hud/assets/images/icon_FullScreen.png";
	public static String icon_smallScreenPath = "bin/db_hud/assets/images/icon_SmallScreen.png";
	public static String icon_minimizePath = "bin/db_hud/assets/images/icon_Minimize.png";
	public static String icon_advSettingsPath = "bin/db_hud/assets/images/icon_Gear.png";
	public static String icon_anchorPath = "bin/db_hud/assets/images/icon_anchor.png";
	public static String image_scenePath = "bin/db_hud/assets/images/image_scene.png";
	public static String image_sceneWarmUpPath = "bin/db_hud/assets/images/image_sceneWarmUp.png";
	public static String image_sceneSpectatorPath = "bin/db_hud/assets/images/image_sceneSpectator.png";
	public static String image_sceneExecutionPath = "bin/db_hud/assets/images/image_sceneExe.png";
	// Asset Image Paths
	public static String imagePath_Ability = "bin/db_hud/assets/images/image_ability.png";
	public static String imagePath_AbilityHover = "bin/db_hud/assets/images/image_ability_hover.png";
	public static String imagePath_AbilitySelected = "bin/db_hud/assets/images/image_ability_selected.png";
	public static String imagePath_Minimap = "bin/db_hud/assets/images/image_minimap.png";
	public static String imagePath_MinimapHover = "bin/db_hud/assets/images/image_minimap_hover.png";
	public static String imagePath_MinimapSelected = "bin/db_hud/assets/images/image_minimap_selected.png";
	public static String imagePath_Actionmenu = "bin/db_hud/assets/images/image_actionMenu.png";
	public static String imagePath_ActionmenuHover = "bin/db_hud/assets/images/image_actionMenu_hover.png";
	public static String imagePath_ActionmenuSelected = "bin/db_hud/assets/images/image_actionMenu_selected.png";
	public static String imagePath_Objective = "bin/db_hud/assets/images/image_objective.png";
	public static String imagePath_ObjectiveHover = "bin/db_hud/assets/images/image_objective_hover.png";
	public static String imagePath_ObjectiveSelected = "bin/db_hud/assets/images/image_objective_selected.png";
	public static String imagePath_Armor = "bin/db_hud/assets/images/image_armor.png";
	public static String imagePath_ArmorHover = "bin/db_hud/assets/images/image_armor_hover.png";
	public static String imagePath_ArmorSelected = "bin/db_hud/assets/images/image_armor_selected.png";
	public static String imagePath_Badge = "bin/db_hud/assets/images/image_badge.png";
	public static String imagePath_BadgeHover = "bin/db_hud/assets/images/image_badge_hover.png";
	public static String imagePath_BadgeSelected = "bin/db_hud/assets/images/image_badge_selected.png";
	public static String imagePath_CharacterSelect = "bin/db_hud/assets/images/image_characterSelect.png";
	public static String imagePath_CharacterSelectHover = "bin/db_hud/assets/images/image_characterSelect_hover.png";
	public static String imagePath_CharacterSelectSelected = "bin/db_hud/assets/images/image_characterSelect_selected.png";
	public static String imagePath_ChatInput = "bin/db_hud/assets/images/image_chatInput.png";
	public static String imagePath_ChatInputHover = "bin/db_hud/assets/images/image_chatInput_hover.png";
	public static String imagePath_ChatInputSelected = "bin/db_hud/assets/images/image_chatInput_selected.png";
	public static String imagePath_Debilitated = "bin/db_hud/assets/images/image_debilitated.png";
	public static String imagePath_DebilitatedHover = "bin/db_hud/assets/images/image_debilitated_hover.png";
	public static String imagePath_DebilitatedSelected = "bin/db_hud/assets/images/image_debilitated_selected.png";
	public static String imagePath_Detected = "bin/db_hud/assets/images/image_detected.png";
	public static String imagePath_DetectedHover = "bin/db_hud/assets/images/image_detected_hover.png";
	public static String imagePath_DetectedSelected = "bin/db_hud/assets/images/image_detected_selected.png";
	public static String imagePath_ExeBadge = "bin/db_hud/assets/images/image_exeBadge.png";
	public static String imagePath_ExeBadgeHover = "bin/db_hud/assets/images/image_exeBadge_hover.png";
	public static String imagePath_ExeBadgeSelected = "bin/db_hud/assets/images/image_exeBadge_selected.png";
	public static String imagePath_ExeGameStat = "bin/db_hud/assets/images/image_exeGameStat.png";
	public static String imagePath_ExeGameStatHover = "bin/db_hud/assets/images/image_exeGameStat_hover.png";
	public static String imagePath_ExeGameStatSelected = "bin/db_hud/assets/images/image_exeGameStat_selected.png";
	public static String imagePath_GameWave = "bin/db_hud/assets/images/image_gamewave.png";
	public static String imagePath_GameWaveHover = "bin/db_hud/assets/images/image_gamewave_hover.png";
	public static String imagePath_GameWaveSelected = "bin/db_hud/assets/images/image_gamewave_selected.png";
	public static String imagePath_GameWaveSpec = "bin/db_hud/assets/images/image_gamewaveSpec.png";
	public static String imagePath_GameWaveSpecHover = "bin/db_hud/assets/images/image_gamewaveSpec_hover.png";
	public static String imagePath_GameWaveSpecSelected = "bin/db_hud/assets/images/image_gamewaveSpec_selected.png";
	public static String imagePath_Health = "bin/db_hud/assets/images/image_health.png";
	public static String imagePath_HealthHover = "bin/db_hud/assets/images/image_health_hover.png";
	public static String imagePath_HealthSelected = "bin/db_hud/assets/images/image_health_selected.png";
	public static String imagePath_MessageLog = "bin/db_hud/assets/images/image_msgLog.png";
	public static String imagePath_MessageLogHover = "bin/db_hud/assets/images/image_msgLog_hover.png";
	public static String imagePath_MessageLogSelected = "bin/db_hud/assets/images/image_msgLog_selected.png";
	public static String imagePath_MessageLogSpec = "bin/db_hud/assets/images/image_msgLogSpec.png";
	public static String imagePath_MessageLogSpecHover = "bin/db_hud/assets/images/image_msgLogSpec_hover.png";
	public static String imagePath_MessageLogSpecSelected = "bin/db_hud/assets/images/image_msgLogSpec_selected.png";
	public static String imagePath_Obituary = "bin/db_hud/assets/images/image_obituary.png";
	public static String imagePath_ObituaryHover = "bin/db_hud/assets/images/image_obituary_hover.png";
	public static String imagePath_ObituarySelected = "bin/db_hud/assets/images/image_obituary_selected.png";
	public static String imagePath_ObituarySpec = "bin/db_hud/assets/images/image_obituarySpec.png";
	public static String imagePath_ObituarySpecHover = "bin/db_hud/assets/images/image_obituarySpec_hover.png";
	public static String imagePath_ObituarySpecSelected = "bin/db_hud/assets/images/image_obituarySpec_selected.png";
	public static String imagePath_ObjectiveSpec = "bin/db_hud/assets/images/image_objectiveSpec.png";
	public static String imagePath_ObjectiveSpecHover = "bin/db_hud/assets/images/image_objectiveSpec_hover.png";
	public static String imagePath_ObjectiveSpecSelected = "bin/db_hud/assets/images/image_objectiveSpec_selected.png";
	public static String imagePath_ObjectiveNotification = "bin/db_hud/assets/images/image_objNtf.png";
	public static String imagePath_ObjectiveNotificationHover = "bin/db_hud/assets/images/image_objNtf_hover.png";
	public static String imagePath_ObjectiveNotificationSelected = "bin/db_hud/assets/images/image_objNtf_selected.png";
	public static String imagePath_ReadyUp = "bin/db_hud/assets/images/image_readyUp.png";
	public static String imagePath_ReadyUpHover = "bin/db_hud/assets/images/image_readyUp_hover.png";
	public static String imagePath_ReadyUpSelected = "bin/db_hud/assets/images/image_readyUp_selected.png";
	public static String imagePath_RoundIntro = "bin/db_hud/assets/images/image_roundIntro.png";
	public static String imagePath_RoundIntroHover = "bin/db_hud/assets/images/image_roundIntro_hover.png";
	public static String imagePath_RoundIntroSelected = "bin/db_hud/assets/images/image_roundIntro_selected.png";
	public static String imagePath_SpectatorCard = "bin/db_hud/assets/images/image_specCard.png";
	public static String imagePath_SpectatorCardHover = "bin/db_hud/assets/images/image_specCard_hover.png";
	public static String imagePath_SpectatorCardSelected = "bin/db_hud/assets/images/image_specCard_selected.png";
	public static String imagePath_Subtitles = "bin/db_hud/assets/images/image_subtitles.png";
	public static String imagePath_SubtitlesHover = "bin/db_hud/assets/images/image_subtitles_hover.png";
	public static String imagePath_SubtitlesSelected = "bin/db_hud/assets/images/image_subtitles_selected.png";
	public static String imagePath_WeaponAmmo = "bin/db_hud/assets/images/image_weaponAmmo.png";
	public static String imagePath_WeaponAmmoHover = "bin/db_hud/assets/images/image_weaponAmmo_hover.png";
	public static String imagePath_WeaponAmmoSelected = "bin/db_hud/assets/images/image_weaponAmmo_selected.png";
	public static String imagePath_Xp = "bin/db_hud/assets/images/image_xp.png";
	public static String imagePath_XpHover = "bin/db_hud/assets/images/image_xp_hover.png";
	public static String imagePath_XpSelected = "bin/db_hud/assets/images/image_xp_selected.png";

	public static ArrayList<Label> line_H;
	public static ArrayList<Label> line_V;

	public static Image icon;
	public static Image icon_close;
	public static Image icon_fullScreen;
	public static Image icon_smallScreen;
	public static Image icon_minimize;
	public static Image icon_advSettings;
	public static Image icon_anchor;
	public static Image image_scene;
	public static Image image_sceneWarmUp;
	public static Image image_sceneSpectator;
	public static Image image_sceneExecution;
	// Asset Images
	public static Image image_Ability;
	public static Image image_AbilitySelected;
	public static Image image_AbilityHover;
	public static Image image_Minimap;
	public static Image image_MinimapSelected;
	public static Image image_MinimapHover;
	public static Image image_ActionMenu;
	public static Image image_ActionMenuSelected;
	public static Image image_ActionMenuHover;
	public static Image image_Objective;
	public static Image image_ObjectiveSelected;
	public static Image image_ObjectiveHover;
	public static Image image_Armor;
	public static Image image_ArmorSelected;
	public static Image image_ArmorHover;
	public static Image image_Badge;
	public static Image image_BadgeSelected;
	public static Image image_BadgeHover;
	public static Image image_CharacterSelect;
	public static Image image_CharacterSelectSelected;
	public static Image image_CharacterSelectHover;
	public static Image image_ChatInput;
	public static Image image_ChatInputSelected;
	public static Image image_ChatInputHover;
	public static Image image_Debilitated;
	public static Image image_DebilitatedSelected;
	public static Image image_DebilitatedHover;
	public static Image image_Detected;
	public static Image image_DetectedSelected;
	public static Image image_DetectedHover;
	public static Image image_ExeBadge;
	public static Image image_ExeBadgeSelected;
	public static Image image_ExeBadgeHover;
	public static Image image_ExeGameStat;
	public static Image image_ExeGameStatSelected;
	public static Image image_ExeGameStatHover;
	public static Image image_GameWave;
	public static Image image_GameWaveSelected;
	public static Image image_GameWaveHover;
	public static Image image_GameWaveSpec;
	public static Image image_GameWaveSpecSelected;
	public static Image image_GameWaveSpecHover;
	public static Image image_Health;
	public static Image image_HealthSelected;
	public static Image image_HealthHover;
	public static Image image_ObjectiveSpec;
	public static Image image_ObjectiveSpecSelected;
	public static Image image_ObjectiveSpecHover;
	public static Image image_MessageLog;
	public static Image image_MessageLogSelected;
	public static Image image_MessageLogHover;
	public static Image image_MessageLogSpec;
	public static Image image_MessageLogSpecSelected;
	public static Image image_MessageLogSpecHover;
	public static Image image_Obituary;
	public static Image image_ObituarySelected;
	public static Image image_ObituaryHover;
	public static Image image_ObituarySpec;
	public static Image image_ObituarySpecSelected;
	public static Image image_ObituarySpecHover;
	public static Image image_ObjectiveNotification;
	public static Image image_ObjectiveNotificationSelected;
	public static Image image_ObjectiveNotificationHover;
	public static Image image_ReadyUp;
	public static Image image_ReadyUpSelected;
	public static Image image_ReadyUpHover;
	public static Image image_RoundIntro;
	public static Image image_RoundIntroSelected;
	public static Image image_RoundIntroHover;
	public static Image image_Subtitles;
	public static Image image_SubtitlesSelected;
	public static Image image_SubtitlesHover;
	public static Image image_SpectatorCard;
	public static Image image_SpectatorCardSelected;
	public static Image image_SpectatorCardHover;
	public static Image image_WeaponAmmo;
	public static Image image_WeaponAmmoSelected;
	public static Image image_WeaponAmmoHover;
	public static Image image_XP;
	public static Image image_XPSelected;
	public static Image image_XPHover;

	// Asset Attach Position
	public static int At_Left;
	public static int At_CenterX;
	public static int At_Right;
	public static int At_Top;
	public static int At_CenterY;
	public static int At_Bottom;
	// Asset Align Position
	public static int Al_Left;
	public static int Al_CenterX;
	public static int Al_Right;
	public static int Al_Top;
	public static int Al_CenterY;
	public static int Al_Bottom;

	public static int valueX;
	public static int valueY;
	
	public static int xValue;
	public static int yValue;
	
	public static float assetRatio;

	public static Logger logger = Logger.getLogger("Log");
	public static FileHandler fh;
	public static ConsoleHandler handler = new ConsoleHandler();
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	public static Calendar cal = Calendar.getInstance();

	public static KeyAdapter keyAdapter;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @throws IOException
	 */

	/* -- START MAIN -- */
	public static void main(String[] args) throws IOException {
		Settings.settingsRead();

		try {
			// This block configure the logger with handler and formatter
			fh = new FileHandler("logs/hudedit_log_" + dateFormat.format(cal.getTime()) + ".log");
			logger.setLevel(Level.ALL);
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (SecurityException e) {
			e.printStackTrace();
			HUD_Maker.logger.info("ERROR: " + e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			HUD_Maker.logger.info("ERROR: " + e.toString());
		}

		try {
			if (!Update.getVersion().equals(Settings.buildVersion)) {
				UpdateUI.updateText = Update.getChangelog();
				System.out.println("");
				UpdateUI.open();
				System.out.println(Update.getVersion() + " - " + Settings.buildVersion);
			} else {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Open Res dialog
		if (Settings.keepDefault == true) {
		} else {
			Resolution.open();
		}
		sizeX = compX;
		sizeY = compY;
		System.out.println(System.getProperty("user.dir"));
		logger.info(System.getProperty("user.dir"));

		assetRatio = 720F / compY;
		System.out.println("Asset Ratio: " + assetRatio);
		logger.info("Asset Ratio: " + assetRatio);

		display = new Display();
		// final Shell shell = new Shell(display);
		icon = new Image(display, icon_Path);
		icon_close = new Image(display, icon_closePath);
		icon_fullScreen = new Image(display, icon_fullScreenPath);
		icon_smallScreen = new Image(display, icon_smallScreenPath);
		icon_minimize = new Image(display, icon_minimizePath);
		icon_advSettings = new Image(display, icon_advSettingsPath);
		icon_anchor = new Image(display, icon_anchorPath);
		image_scene = new Image(display, image_scenePath);
		image_sceneWarmUp = new Image(display, image_sceneWarmUpPath);
		image_sceneSpectator = new Image(display, image_sceneSpectatorPath);
		image_sceneExecution = new Image(display, image_sceneExecutionPath);

		// Asset Images
		image_Ability = new Image(display, imagePath_Ability);
		image_AbilityHover = new Image(display, imagePath_AbilityHover);
		image_AbilitySelected = new Image(display, imagePath_AbilitySelected);
		image_Minimap = new Image(display, imagePath_Minimap);
		image_MinimapHover = new Image(display, imagePath_MinimapHover);
		image_MinimapSelected = new Image(display, imagePath_MinimapSelected);
		image_ActionMenu = new Image(display, imagePath_Actionmenu);
		image_ActionMenuHover = new Image(display, imagePath_ActionmenuHover);
		image_ActionMenuSelected = new Image(display, imagePath_ActionmenuSelected);
		image_Objective = new Image(display, imagePath_Objective);
		image_ObjectiveHover = new Image(display, imagePath_ObjectiveHover);
		image_ObjectiveSelected = new Image(display, imagePath_ObjectiveSelected);
		image_ObjectiveSpec = new Image(display, imagePath_ObjectiveSpec);
		image_ObjectiveSpecHover = new Image(display, imagePath_ObjectiveSpecHover);
		image_ObjectiveSpecSelected = new Image(display, imagePath_ObjectiveSpecSelected);
		image_Badge = new Image(display, imagePath_Badge);
		image_BadgeHover = new Image(display, imagePath_BadgeHover);
		image_BadgeSelected = new Image(display, imagePath_BadgeSelected);
		image_CharacterSelect = new Image(display, imagePath_CharacterSelect);
		image_CharacterSelectHover = new Image(display, imagePath_CharacterSelectHover);
		image_CharacterSelectSelected = new Image(display, imagePath_CharacterSelectSelected);
		image_ChatInput = new Image(display, imagePath_ChatInput);
		image_ChatInputHover = new Image(display, imagePath_ChatInputHover);
		image_ChatInputSelected = new Image(display, imagePath_ChatInputSelected);
		image_Debilitated = new Image(display, imagePath_Debilitated);
		image_DebilitatedHover = new Image(display, imagePath_DebilitatedHover);
		image_DebilitatedSelected = new Image(display, imagePath_DebilitatedSelected);
		image_Detected = new Image(display, imagePath_Detected);
		image_DetectedHover = new Image(display, imagePath_DetectedHover);
		image_DetectedSelected = new Image(display, imagePath_DetectedSelected);
		image_Armor = new Image(display, imagePath_Armor);
		image_ArmorHover = new Image(display, imagePath_ArmorHover);
		image_ArmorSelected = new Image(display, imagePath_ArmorSelected);
		image_ExeBadge = new Image(display, imagePath_ExeBadge);
		image_ExeBadgeHover = new Image(display, imagePath_ExeBadgeHover);
		image_ExeBadgeSelected = new Image(display, imagePath_ExeBadgeSelected);
		image_ExeGameStat = new Image(display, imagePath_ExeGameStat);
		image_ExeGameStatHover = new Image(display, imagePath_ExeGameStatHover);
		image_ExeGameStatSelected = new Image(display, imagePath_ExeGameStatSelected);
		image_GameWave = new Image(display, imagePath_GameWave);
		image_GameWaveHover = new Image(display, imagePath_GameWaveHover);
		image_GameWaveSelected = new Image(display, imagePath_GameWaveSelected);
		image_GameWaveSpec = new Image(display, imagePath_GameWaveSpec);
		image_GameWaveSpecHover = new Image(display, imagePath_GameWaveSpecHover);
		image_GameWaveSpecSelected = new Image(display, imagePath_GameWaveSpecSelected);
		image_Health = new Image(display, imagePath_Health);
		image_HealthHover = new Image(display, imagePath_HealthHover);
		image_HealthSelected = new Image(display, imagePath_HealthSelected);
		image_MessageLog = new Image(display, imagePath_MessageLog);
		image_MessageLogHover = new Image(display, imagePath_MessageLogHover);
		image_MessageLogSelected = new Image(display, imagePath_MessageLogSelected);
		image_MessageLogSpec = new Image(display, imagePath_MessageLogSpec);
		image_MessageLogSpecHover = new Image(display, imagePath_MessageLogSpecHover);
		image_MessageLogSpecSelected = new Image(display, imagePath_MessageLogSpecSelected);
		image_Obituary = new Image(display, imagePath_Obituary);
		image_ObituaryHover = new Image(display, imagePath_ObituaryHover);
		image_ObituarySelected = new Image(display, imagePath_ObituarySelected);
		image_ObituarySpec = new Image(display, imagePath_ObituarySpec);
		image_ObituarySpecHover = new Image(display, imagePath_ObituarySpecHover);
		image_ObituarySpecSelected = new Image(display, imagePath_ObituarySpecSelected);
		image_ObjectiveNotification = new Image(display, imagePath_ObjectiveNotification);
		image_ObjectiveNotificationHover = new Image(display, imagePath_ObjectiveNotificationHover);
		image_ObjectiveNotificationSelected = new Image(display, imagePath_ObjectiveNotificationSelected);
		image_ReadyUp = new Image(display, imagePath_ReadyUp);
		image_ReadyUpHover = new Image(display, imagePath_ReadyUpHover);
		image_ReadyUpSelected = new Image(display, imagePath_ReadyUpSelected);
		image_RoundIntro = new Image(display, imagePath_RoundIntro);
		image_RoundIntroHover = new Image(display, imagePath_RoundIntroHover);
		image_RoundIntroSelected = new Image(display, imagePath_RoundIntroSelected);
		image_SpectatorCard = new Image(display, imagePath_SpectatorCard);
		image_SpectatorCardHover = new Image(display, imagePath_SpectatorCardHover);
		image_SpectatorCardSelected = new Image(display, imagePath_SpectatorCardSelected);
		image_Subtitles = new Image(display, imagePath_Subtitles);
		image_SubtitlesHover = new Image(display, imagePath_SubtitlesHover);
		image_SubtitlesSelected = new Image(display, imagePath_SubtitlesSelected);
		image_WeaponAmmo = new Image(display, imagePath_WeaponAmmo);
		image_WeaponAmmoHover = new Image(display, imagePath_WeaponAmmoHover);
		image_WeaponAmmoSelected = new Image(display, imagePath_WeaponAmmoSelected);
		image_XP = new Image(display, imagePath_Xp);
		image_XPHover = new Image(display, imagePath_XpHover);
		image_XPSelected = new Image(display, imagePath_XpSelected);

		// Other
		line_H = new ArrayList<Label>();
		line_V = new ArrayList<Label>();

		assets = new ArrayList<Label>();

		// Declare and initialize window
		try {
			HUD_Maker window = new HUD_Maker();
			window.open();
		} catch (Exception e) {
			System.exit(0);
			e.printStackTrace();
		}
	}

	/* -- END MAIN -- */

	/*
	 * To Do List (OLD): -- DEV VERSION 1-- - Change posX and posY to absolute
	 * value (not relative coordinates) - Create Color Window - Add all Assets -
	 * Add Color Window and Color Stuff - Adjust values based on trial and error
	 * testing, and by math - Create Save Function - All Basic Stuff - Refine
	 * Resolution Window
	 * 
	 * --ANY TIME GAME HUD IS CHANGED DUE TO UPDATE, FIX DEFAULT TO MATCH GAME
	 * DEFAULT--
	 * 
	 * --MINIVERSION(S)-- - Bug fixes - Minor changes - Reset Function, Reset
	 * All Function (?) - Other small functions
	 * 
	 * --VERSION 1--
	 * 
	 * - New Functions: Load Preset, Reset, Reset All, Presets, Change
	 * Resolution, Preview, Check for Updates... - Rework GUI - Make Preview
	 * functional - When Right Click on Asset in Editor, Menu should appear to
	 * change alignment, attachment, etc... - Modes (Spectator, incapacitated,
	 * Execution)
	 * 
	 * --VERSION 2-- - GUI Update (Insert Custom Look and Feel?) - More Features
	 * To Be Determined - Bug fixes... - Additional Expansion (Colors, HUD
	 * Assets, Resolutions, Change up GUI)
	 * 
	 * --UPDATE AS THE GAME UPDATES--
	 * 
	 */

	// Open the window
	public void open() {
		display = Display.getDefault();
		createContents();
		App_UI.open();
		App_UI.layout();
		// lblDirtyBombHud.setText("HUD Options");
		if (App_UI.isDisposed() == false) {
			Options.open();
		}
		if (Options.Options_UI.isDisposed() == true) {
			System.exit(0);
		}
		if (Settings.settings.isDisposed() == true) {
			System.exit(0);
		}

		while (!App_UI.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	public static void hideGrid() {
		for (int i = 0; i < line_H.size(); i++) {
			Label line = line_H.get(i);
			line.setVisible(false);
		}
		for (int i = 0; i < line_V.size(); i++) {
			Label line = line_V.get(i);
			line.setVisible(false);
		}
	}

	public static void showGrid() {
		for (int i = 0; i < line_H.size(); i++) {
			Label line = line_H.get(i);
			line.setVisible(true);
		}
		for (int i = 0; i < line_V.size(); i++) {
			Label line = line_V.get(i);
			line.setVisible(true);
		}
	}

	// Create contents of the window
	// color code (255,200,19) = Gold

	// 1 2 3
	// 4 5 6
	// 7 8 9

	public static void Offset() {
		if (imageSelected != 0) {

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top) {
				section = 1;
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top) {
				section = 2;
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top) {
				section = 3;
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center) {
				section = 4;
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center) {
				section = 5;
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center) {
				section = 6;
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom) {
				section = 7;
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom) {
				section = 8;
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom) {
				section = 9;
			}

			switch (section) {
			case 1:
				Options.cr.posX = cl.getLocation().x;
				Options.cr.posY = cl.getLocation().y;
				break;

			case 2:
				Options.cr.posX = cl.getLocation().x - compX / 2;
				Options.cr.posY = cl.getLocation().y;
				break;

			case 3:
				Options.cr.posX = compX - imgX - cl.getLocation().x;
				Options.cr.posY = cl.getLocation().y;
				break;

			case 4:
				Options.cr.posX = cl.getLocation().x;
				Options.cr.posY = cl.getLocation().y - compY / 2;
				break;

			case 5:
				Options.cr.posX = cl.getLocation().x - compX / 2;
				Options.cr.posY = cl.getLocation().y - compY / 2;
				break;

			case 6:
				Options.cr.posX = compX - imgX - cl.getLocation().x;
				Options.cr.posY = cl.getLocation().y - compY / 2;
				break;

			case 7:
				Options.cr.posX = cl.getLocation().x;
				Options.cr.posY = compY - imgY - cl.getLocation().y;
				break;

			case 8:
				Options.cr.posX = cl.getLocation().x - compX / 2;
				Options.cr.posY = compY - imgY - cl.getLocation().y;
				break;

			case 9:
				Options.cr.posX = compX - imgX - cl.getLocation().x;
				Options.cr.posY = compY - imgY - cl.getLocation().y;
				break;

			}
			System.out.println("PosX: " + Options.cr.posX + ", PosY: " + Options.cr.posY);
		}
	}

	public static int getLocation(Label label) {

		if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top) {
			location = 1;
		} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top) {
			location = 2;
		} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top) {
			location = 3;
		} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center) {
			location = 4;
		} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center) {
			location = 5;
		} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center) {
			location = 6;
		} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom) {
			location = 7;
		} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom) {
			location = 8;
		} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom) {
			location = 9;
		}

		return location;
	}

	public static int getAlignLocation(Label label) {

		if (Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
			alignLocation = 1;
		} else if (Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
			alignLocation = 2;
		} else if (Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
			alignLocation = 3;
		} else if (Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
			alignLocation = 4;
		} else if (Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
			alignLocation = 5;
		} else if (Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
			alignLocation = 6;
		} else if (Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
			alignLocation = 7;
		} else if (Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
			alignLocation = 8;
		} else if (Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
			alignLocation = 9;
		}

		return alignLocation;
	}

	public static void setProperties() {
		if (imageSelected != 0) {

			// Left Top

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			}

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			}

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY - 10);
			}

			// Left Center

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			// Left Bottom

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			}

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			}

			if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Left && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX - 10, 0 - Options.cr.posY + compY - 10);
			}

			// Center Top

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			}

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			}

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY - 10);
			}

			// Center Center

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			// Center Bottom

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX + compX / 2, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			}

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX / 2 + compX / 2, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			}

			if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Center && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 + Options.cr.posX - imgX + compX / 2, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 + Options.cr.posX + compX / 2 - 10, 0 - Options.cr.posY + compY - 10);
			}

			// Right Top

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			}

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			}

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 + Options.cr.posY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 + Options.cr.posY - imgY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Top
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 + Options.cr.posY - imgY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY - 10);
			}

			// Right Center

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 + Options.cr.posY + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 + Options.cr.posY - imgY / 2 + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Center
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 + Options.cr.posY - imgY + compY / 2);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 + Options.cr.posY + compY / 2 - 10);
			}

			// Right Bottom

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Left && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX + compX, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			}

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Center && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX - imgX / 2 + compX, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			}

			if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Top) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 - Options.cr.posY + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Center) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 - Options.cr.posY - imgY / 2 + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			} else if (Options.cr.AttachH == Options.Right && Options.cr.AttachV == Options.Bottom
					&& Options.cr.AlignH == Options.Right && Options.cr.AlignV == Options.Bottom) {
				cl.setLocation(0 - Options.cr.posX - imgX + compX, 0 - Options.cr.posY - imgY + compY);
				img_Anchor.setLocation(0 - Options.cr.posX + compX - 10, 0 - Options.cr.posY + compY - 10);
			}
		}
	}

	protected static void setFields() {

		switch (Options.type) {
		case 0:
			Options.HUD_Asset.setText("-- Select Asset --");
			Options.Align_H.setText("-- Select Align_H --");
			Options.Align_V.setText("-- Select Align_V --");
			Options.Attach_H.setText("-- Select Attach_H --");
			Options.Attach_V.setText("-- Select Attach_V --");
			Options.pox.setSelection(0);
			Options.poy.setSelection(0);
			Options.sox.setSelection(0);
			Options.soy.setSelection(0);
			Options.value.setSelection(0);
			Options.colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));

			Options.pox.setEnabled(false);
			Options.poy.setEnabled(false);
			Options.Attach_H.setEnabled(false);
			Options.Attach_V.setEnabled(false);
			Options.Align_H.setEnabled(false);
			Options.Align_V.setEnabled(false);
			Options.sox.setEnabled(false);
			Options.soy.setEnabled(false);
			Options.btn_color.setEnabled(false);
			Options.value.setEnabled(false);

			break;
		case 1:
			System.out.println(Options.cr.Name);
			if (Options.cr.AlignH == Options.Left) {
				Options.cr.cAlignH = Options.cLeft;
			} else if (Options.cr.AlignH == Options.Center) {
				Options.cr.cAlignH = Options.cCenter;
			} else if (Options.cr.AlignH == Options.Right) {
				Options.cr.cAlignH = Options.cRight;
			}

			if (Options.cr.AlignV == Options.Top) {
				Options.cr.cAlignV = Options.cTop;
			} else if (Options.cr.AlignV == Options.Center) {
				Options.cr.cAlignV = Options.cCenter;
			} else if (Options.cr.AlignV == Options.Bottom) {
				Options.cr.cAlignV = Options.cBottom;
			}

			if (Options.cr.AttachH == Options.Left) {
				Options.cr.cAttachH = Options.cLeft;
			} else if (Options.cr.AttachH == Options.Center) {
				Options.cr.cAttachH = Options.cCenter;
			} else if (Options.cr.AttachH == Options.Right) {
				Options.cr.cAttachH = Options.cRight;
			}

			if (Options.cr.AttachV == Options.Top) {
				Options.cr.cAttachV = Options.cTop;
			} else if (Options.cr.AttachV == Options.Center) {
				Options.cr.cAttachV = Options.cCenter;
			} else if (Options.cr.AttachV == Options.Bottom) {
				Options.cr.cAttachV = Options.cBottom;
			}

			System.out.println(Options.cr.AlignH + ", " + Options.cr.cAlignH);
			System.out.println(Options.cr.AlignV + ", " + Options.cr.cAlignV);
			System.out.println(Options.cr.AttachH + ", " + Options.cr.cAttachH);
			System.out.println(Options.cr.AttachV + ", " + Options.cr.cAttachV);

			Options.pox.setSelection(Options.cr.posX);
			Options.poy.setSelection(Options.cr.posY);
			Options.Align_H.setText(Options.cr.cAlignH);
			Options.Align_V.setText(Options.cr.cAlignV);
			Options.Attach_H.setText(Options.cr.cAttachH);
			Options.Attach_V.setText(Options.cr.cAttachV);
			Options.colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));

			Options.cr.OAttachH = Options.cr.AttachH;
			Options.cr.OAttachV = Options.cr.AttachV;
			Options.cr.OAlignH = Options.cr.AlignH;
			Options.cr.OAlignV = Options.cr.AlignV;
			Options.cr.OposX = Options.cr.posX;
			Options.cr.OposY = Options.cr.posY;

			Options.pox.setEnabled(true);
			Options.poy.setEnabled(true);
			Options.Attach_H.setEnabled(true);
			Options.Attach_V.setEnabled(true);
			Options.Align_H.setEnabled(true);
			Options.Align_V.setEnabled(true);
			Options.sox.setEnabled(false);
			Options.soy.setEnabled(false);
			Options.btn_color.setEnabled(false);
			Options.value.setEnabled(false);

			break;

		case 2:
			System.out.println(Options.cr.Name);
			if (Options.cr.AlignH == Options.Left) {
				Options.cr.cAlignH = Options.cLeft;
			} else if (Options.cr.AlignH == Options.Center) {
				Options.cr.cAlignH = Options.cCenter;
			} else if (Options.cr.AlignH == Options.Right) {
				Options.cr.cAlignH = Options.cRight;
			}

			if (Options.cr.AlignV == Options.Top) {
				Options.cr.cAlignV = Options.cTop;
			} else if (Options.cr.AlignV == Options.Center) {
				Options.cr.cAlignV = Options.cCenter;
			} else if (Options.cr.AlignV == Options.Bottom) {
				Options.cr.cAlignV = Options.cBottom;
			}

			if (Options.cr.AttachH == Options.Left) {
				Options.cr.cAttachH = Options.cLeft;
			} else if (Options.cr.AttachH == Options.Center) {
				Options.cr.cAttachH = Options.cCenter;
			} else if (Options.cr.AttachH == Options.Right) {
				Options.cr.cAttachH = Options.cRight;
			}

			if (Options.cr.AttachV == Options.Top) {
				Options.cr.cAttachV = Options.cTop;
			} else if (Options.cr.AttachV == Options.Center) {
				Options.cr.cAttachV = Options.cCenter;
			} else if (Options.cr.AttachV == Options.Bottom) {
				Options.cr.cAttachV = Options.cBottom;
			}

			Options.pox.setSelection(Options.cr.posX);
			Options.poy.setSelection(Options.cr.posY);
			Options.sox.setSelection(Options.cr.sosX);
			Options.soy.setSelection(Options.cr.sosY);
			Options.Align_H.setText(Options.cr.cAlignH);
			Options.Align_V.setText(Options.cr.cAlignV);
			Options.Attach_H.setText(Options.cr.cAttachH);
			Options.Attach_V.setText(Options.cr.cAttachV);
			Options.colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));

			Options.cr.OAttachH = Options.cr.AttachH;
			Options.cr.OAttachV = Options.cr.AttachV;
			Options.cr.OAlignH = Options.cr.AlignH;
			Options.cr.OAlignV = Options.cr.AlignV;
			Options.cr.OposX = Options.cr.posX;
			Options.cr.OposY = Options.cr.posY;
			Options.cr.OsosX = Options.cr.sosX;
			Options.cr.OsosY = Options.cr.sosY;

			Options.pox.setEnabled(true);
			Options.poy.setEnabled(true);
			Options.Attach_H.setEnabled(true);
			Options.Attach_V.setEnabled(true);
			Options.Align_H.setEnabled(true);
			Options.Align_V.setEnabled(true);
			Options.sox.setEnabled(true);
			Options.soy.setEnabled(true);
			Options.btn_color.setEnabled(false);
			Options.value.setEnabled(false);

			break;
		case 3:
			Options.value.setSelection(Options.cr.Value);

			Options.colorPreview.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));

			Options.pox.setEnabled(false);
			Options.poy.setEnabled(false);
			Options.Attach_H.setEnabled(false);
			Options.Attach_V.setEnabled(false);
			Options.Align_H.setEnabled(false);
			Options.Align_V.setEnabled(false);
			Options.sox.setEnabled(false);
			Options.soy.setEnabled(false);
			Options.btn_color.setEnabled(false);
			Options.value.setEnabled(true);
			break;
		case 4:
			Options.pox.setEnabled(false);
			Options.poy.setEnabled(false);
			Options.Attach_H.setEnabled(false);
			Options.Attach_V.setEnabled(false);
			Options.Align_H.setEnabled(false);
			Options.Align_V.setEnabled(false);
			Options.sox.setEnabled(false);
			Options.soy.setEnabled(false);
			Options.value.setEnabled(false);
			Options.btn_color.setEnabled(true);

			Options.colorPreview.setBackground(
					SWTResourceManager.getColor(Options.cr.ColorR, Options.cr.ColorG, Options.cr.ColorB));
			ColorWindow.R = Options.cr.ColorR;
			ColorWindow.G = Options.cr.ColorG;
			ColorWindow.B = Options.cr.ColorB;
			ColorWindow.A = Options.cr.ColorA;

			break;

		}

	}

	private static void setLabelProperties(Label label, int imageSizeX, int imageSizeY, int imagePositionX,
			int imagePositionY, Image image, Image image_Hover, Image image_Selected, int type, int imageNumber,
			Asset hudAsset, String assetName) {

		MouseMoveListener mouseMove = new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				if (imgIsMouseDown == true) {
					if (Settings.snapGrid == true) {

						label.setLocation(
								label.getLocation().x + (e.x) - (label.getLocation().x + (e.x)) % Settings.gridSize
										- imageSizeX / 2,
								label.getLocation().y + (e.y) - (label.getLocation().y + (e.y)) % Settings.gridSize
										- imageSizeY / 2);
						Offset();
						setFields();
					} else {

						label.setLocation(label.getLocation().x + (e.x) - imageSizeX / 2,
								label.getLocation().y + (e.y) - imageSizeY / 2);
						Offset();
						setFields();
					}
				}
			}
		};

		label.setAlignment(SWT.CENTER);
		label.setSize(imageSizeX, imageSizeY);
		// SetLocation(ATTACHX-WIDTH-POSX, ATTACHY-HEIGHT-POSY)
		label.setLocation(imagePositionX, imagePositionY);
		label.setImage(image);
		assets.add(label);
		label.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if (e.button == 1) { // Left Click
					imgIsMouseDown = true;

				}
			}

			public void mouseUp(MouseEvent e) {
				if (e.button == 1) { // Left Click

					imgIsMouseDown = false;
					if (imageSelected != imageNumber) {

						try {
							// Clear Previous Label
							Options.type = 0;
							Options.cr = null;
							img_Anchor.setLocation(-20, -20);
							imageSelected = 0;
							label.setImage(image);
							cl = null;
							xValue = 0;
							yValue = 0;
							setFields();
							btnTest.removeKeyListener(keyAdapter);
							label.removeMouseMoveListener(mouseMove);
						} catch (Exception ex) {
							ex.printStackTrace();
							logger.info("ERROR: " + ex.toString());
						}

						Options.type = type;
						imageSelected = imageNumber;
						label.setImage(image_Selected);
						if (Options.mode == 3) {
							img_Obituary.setImage(image_ObituarySpecSelected);
						}
						Options.cr = hudAsset;
						int hudAssetX = hudAsset.posX;
						int hudAssetY = hudAsset.posY;
						label.addMouseMoveListener(mouseMove);
						Options.HUD_Asset.setText(assetName);
						cl = label;
						imgX = imageSizeX;
						imgY = imageSizeY;
						Options.SoS();
						setFields();
						setProperties();
						mode();
						keyAdapter = new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent event) {
								System.out.println(xValue + " - CHECK LOCATION X");
								System.out.println(yValue + " - CHECK LOCATION Y");
								
								if (event.keyCode == SWT.ARROW_UP) {
									label.setLocation(label.getLocation().x, label.getLocation().y - 1);
									img_Anchor.setLocation(img_Anchor.getLocation().x, img_Anchor.getLocation().y - 1);
									yValue--;
								}
								if (((event.stateMask & SWT.CTRL) == SWT.CTRL) && (event.keyCode == SWT.ARROW_UP)) {
									label.setLocation(label.getLocation().x, label.getLocation().y - Settings.gridSize);
									img_Anchor.setLocation(img_Anchor.getLocation().x, img_Anchor.getLocation().y - Settings.gridSize);
									yValue -= Settings.gridSize;
								}

								if (event.keyCode == SWT.ARROW_DOWN) {
									label.setLocation(label.getLocation().x, label.getLocation().y + 1);
									img_Anchor.setLocation(img_Anchor.getLocation().x, img_Anchor.getLocation().y + 1);
									yValue++;
								}
								if (((event.stateMask & SWT.CTRL) == SWT.CTRL) && (event.keyCode == SWT.ARROW_DOWN)) {
									label.setLocation(label.getLocation().x, label.getLocation().y + Settings.gridSize);
									img_Anchor.setLocation(img_Anchor.getLocation().x, img_Anchor.getLocation().y + Settings.gridSize);
									yValue += Settings.gridSize;
								}

								if (event.keyCode == SWT.ARROW_LEFT) {
									label.setLocation(label.getLocation().x - 1, label.getLocation().y);
									img_Anchor.setLocation(img_Anchor.getLocation().x - 1, img_Anchor.getLocation().y);
									xValue--;
								}
								if (((event.stateMask & SWT.CTRL) == SWT.CTRL) && (event.keyCode == SWT.ARROW_LEFT)) {
									label.setLocation(label.getLocation().x - Settings.gridSize, label.getLocation().y);
									img_Anchor.setLocation(img_Anchor.getLocation().x - Settings.gridSize, img_Anchor.getLocation().y);
									xValue -= Settings.gridSize;
								}

								if (event.keyCode == SWT.ARROW_RIGHT) {
									label.setLocation(label.getLocation().x + 1, label.getLocation().y);
									img_Anchor.setLocation(img_Anchor.getLocation().x + 1, img_Anchor.getLocation().y);
									xValue++;
								}
								if (((event.stateMask & SWT.CTRL) == SWT.CTRL) && (event.keyCode == SWT.ARROW_RIGHT)) {
									label.setLocation(label.getLocation().x + Settings.gridSize, label.getLocation().y);
									img_Anchor.setLocation(img_Anchor.getLocation().x + Settings.gridSize, img_Anchor.getLocation().y);
									xValue += Settings.gridSize;
								}
								
								if(Options.cr.AttachH == Options.Left){valueX = hudAssetX + xValue;}
								else if(Options.cr.AttachH == Options.Center){valueX = hudAssetX + xValue;}
								else if(Options.cr.AttachH == Options.Right){valueX = hudAssetX + -1*xValue;}
								
								if(Options.cr.AttachV == Options.Top){valueY = hudAssetY + yValue;}
								else if(Options.cr.AttachV == Options.Center){valueY = hudAssetY + yValue;}
								else if(Options.cr.AttachV == Options.Bottom){valueY = hudAssetY + -1*yValue;}
								
								System.out.println(valueX + " & " + valueY);
								
								hudAsset.posX = valueX;
								System.out.println(hudAsset.posX);
								Options.pox.setSelection(hudAsset.posX);
								
								hudAsset.posY = valueY;
								System.out.println(hudAsset.posY);
								Options.poy.setSelection(hudAsset.posY);
							}
						};
						btnTest.addKeyListener(keyAdapter);
						
					} else {
						Options.type = 0;
						Options.cr = null;
						img_Anchor.setLocation(-20, -20);
						imageSelected = 0;
						label.setImage(image);
						cl = null;
						setFields();
						btnTest.removeKeyListener(keyAdapter);
						xValue = 0;
						yValue = 0;
					}
				}

				else if (e.button == 3) {
					Options.Options_UI.setVisible(true);
					Options.Options_UI.setActive();
				}
			}
		});

		label.addMouseMoveListener(mouseMove);

		label.addListener(SWT.MouseEnter, new Listener() {
			public void handleEvent(Event event) {
				label.addMouseMoveListener(mouseMove);
				if (imageSelected != imageNumber) {
					label.setImage(image_Hover);
					if (Options.mode == 3) {
						img_Obituary.setImage(image_ObituarySpecHover);
					}
					label.removeMouseMoveListener(mouseMove);
				} else {
				}
			}
		});
		label.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event event) {
				try {
					label.removeMouseMoveListener(mouseMove);
				} catch (Exception e) {
					e.printStackTrace();
					logger.info(e.toString());
				}
				if (imageSelected != imageNumber) {
					label.setImage(image);
				} else {
				}
			}
		});
		label.setVisible(false);
		mode();
	}

	protected static void createContents() {

		// Options.open();
		// Options.Options_UI.setVisible(false);

		App_UI = new Shell(SWT.NONE | SWT.ON_TOP);
		App_UI.setBackground(SWTResourceManager.getColor(255, 255, 255));
		App_UI.setSize(compX + 2, compY + 2);
		// App_UI.setSize(1305, 745);
		App_UI.setImage(icon);
		App_UI.setText("Dirty Bomb HUD Maker " + Settings.buildVersion);
		App_UI.setBackgroundMode(SWT.INHERIT_DEFAULT);

		HUD_Preview = new Composite(App_UI, SWT.NONE);
		HUD_Preview.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		HUD_Preview.setBackground(SWTResourceManager.getColor(55, 55, 55));
		HUD_Preview.setBounds(0, 0, compX, compY);
		HUD_Preview.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseUp(MouseEvent e) {
				if (e.button == 3) {
					Options.Options_UI.setVisible(true);
					Options.Options_UI.setActive();
				}
			}
		});

		btnTest = new Button(HUD_Preview, SWT.NONE);
		btnTest.setBounds(5, 5, -20, -20);
		btnTest.setText("Move");

		for (int i = 0; i < 2; i++) {
			String imageScenePath = "bin/db_hud/assets/images/imageScene.png";
			Image imageScene = new Image(display, imageScenePath);

			ImageData imageData = image_scene.getImageData();
			imageData = imageData.scaledTo(compX, compY);
			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { imageData };
			imageLoader.save(imageScenePath, 1);
			HUD_Preview.setBackgroundImage(imageScene);
		}

		Label lblclose = new Label(HUD_Preview, SWT.NONE);
		lblclose.setBounds(compX - 30, 4, 25, 25);
		lblclose.setImage(icon_close);
		lblclose.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {
				App_UI.close();
				Options.Options_UI.close();
				Settings.settings.close();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}
		});
		lblclose.addListener(SWT.MouseEnter, new Listener() {
			public void handleEvent(Event event) {
				lblclose.setBackground(SWTResourceManager.getColor(255, 0, 0));
			}

		});
		lblclose.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event event) {
				lblclose.setBackground(null);
				App_UI.setBackgroundMode(SWT.INHERIT_FORCE);
			}
		});

		Label lblScreenMode = new Label(HUD_Preview, SWT.NONE);
		lblScreenMode.setBounds(compX - 55, 4, 25, 25);
		lblScreenMode.setImage(icon_fullScreen);
		lblScreenMode.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {
				System.out.println("FullScreen");
				logger.info("-Fullscreen-");
				if (App_UI.getFullScreen() == false) {
					App_UI.setFullScreen(true);
					lblScreenMode.setImage(icon_smallScreen);
				} else {
					App_UI.setFullScreen(false);
					lblScreenMode.setImage(icon_fullScreen);
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}
		});
		lblScreenMode.addListener(SWT.MouseEnter, new Listener() {
			public void handleEvent(Event event) {
				lblScreenMode.setBackground(SWTResourceManager.getColor(0, 200, 255));
			}

		});
		lblScreenMode.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event event) {
				lblScreenMode.setBackground(null);
				App_UI.setBackgroundMode(SWT.INHERIT_FORCE);
			}
		});

		Label lblMinimize = new Label(HUD_Preview, SWT.NONE);
		lblMinimize.setBounds(compX - 80, 4, 25, 25);
		lblMinimize.setImage(icon_minimize);
		lblMinimize.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {
				if (App_UI.getFullScreen() == true) {
					App_UI.setFullScreen(false);
					lblScreenMode.setImage(icon_fullScreen);
					App_UI.setMinimized(true);
				} else {
					App_UI.setMinimized(true);
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}
		});
		lblMinimize.addListener(SWT.MouseEnter, new Listener() {
			public void handleEvent(Event event) {
				lblMinimize.setBackground(SWTResourceManager.getColor(0, 200, 255));
			}

		});
		lblMinimize.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event event) {
				lblMinimize.setBackground(null);
				App_UI.setBackgroundMode(SWT.INHERIT_FORCE);
			}
		});

		Label advSettings = new Label(HUD_Preview, SWT.NONE);
		advSettings.setBounds(3, compY - 30, 25, 25);
		advSettings.setImage(icon_advSettings);
		advSettings.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {
				Options.Options_UI.setVisible(true);
				Options.Options_UI.setActive();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}
		});
		advSettings.addListener(SWT.MouseEnter, new Listener() {
			public void handleEvent(Event event) {
				advSettings.setBackground(SWTResourceManager.getColor(180, 255, 230));
			}

		});
		advSettings.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event event) {
				advSettings.setBackground(null);
			}
		});

		// Asset Images

		img_Anchor = new Label(HUD_Preview, SWT.NONE);
		img_Anchor.setAlignment(SWT.CENTER);
		img_Anchor.setSize(20, 20);
		img_Anchor.setLocation(-20, -20);
		img_Anchor.setImage(icon_anchor);

		img_Ability = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Ability, 220, 185, compX - 220 - 20, compY - 185 - 113, image_Ability,
				image_AbilityHover, image_AbilitySelected, 2, 1, Options.AbilityCooldown, "Ability Cooldown");

		img_Minimap = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Minimap, 240, 165, 39, compY - 165 - 13, image_Minimap, image_MinimapHover,
				image_MinimapSelected, 1, 2, Options.MiniMap, "MiniMap");

		img_Objective = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Objective, 272, 36, 40, 105, image_Objective, image_ObjectiveHover,
				image_ObjectiveSelected, 1, 3, Options.ObjPos, "Objective");

		img_ObjectiveSpec = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ObjectiveSpec, 272, 36, compX / 2 - 272 / 2, 60, image_ObjectiveSpec,
				image_ObjectiveSpecHover, image_ObjectiveSpecSelected, 1, 5, Options.SpcObjPos, "Spectator Objective");

		img_ChatInput = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ChatInput, 400, 20, 39, compY - 200, image_ChatInput, image_ChatInputHover,
				image_ChatInputSelected, 1, 9, Options.ChatInput, "Chat Input");

		img_ChatInputSpec = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ChatInputSpec, 400, 20, 39, 180, image_ChatInput, image_ChatInputHover,
				image_ChatInputSelected, 1, 10, Options.SpcChatInput, "Spectator Chat Input");

		img_Debilitated = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Debilitated, 228, 30, compX / 2 - 228 / 2, compY - 30 - 120, image_Debilitated,
				image_DebilitatedHover, image_DebilitatedSelected, 1, 11, Options.DebPos, "Debilitated Notification");

		img_Detected = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Detected, 160, 30, compX / 2 - 160 / 2, compY - 30 - 100, image_Detected,
				image_DetectedHover, image_DetectedSelected, 1, 12, Options.Detected, "Detected Notification");

		img_ExeBadge = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ExeBadge, 180, 180, compX / 2 - 180 / 2, 80, image_ExeBadge, image_ExeBadgeHover,
				image_ExeBadgeSelected, 1, 13, Options.ExeBadge, "Execution Badge Notification");

		img_Badge = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Badge, 250, 250, compX / 2 - 250 / 2, 0, image_Badge, image_BadgeHover,
				image_BadgeSelected, 1, 7, Options.BadgeNtf, "Badge Notification");

		img_GameWave = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_GameWave, 160, 35, 40, 60, image_GameWave, image_GameWaveHover, image_GameWaveSelected,
				1, 15, Options.GameWaveTimer, "Gamewave Timer");

		img_GameWaveSpec = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_GameWaveSpec, 573, 35, compX / 2 - 573 / 2, 0, image_GameWaveSpec,
				image_GameWaveSpecHover, image_GameWaveSpecSelected, 1, 16, Options.SpcGameWaveTimer,
				"Spectator Gamewave Timer");

		img_Health = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Health, 200, 45, compX - 200 - 20, compY - 45 - 12, image_Health, image_HealthHover,
				image_HealthSelected, 2, 17, Options.PlayerHealth, "Health");

		img_MessageLog = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_MessageLog, 400, 150, 39, compY-350, image_MessageLog, image_MessageLogHover,
				image_MessageLogSelected, 1, 18, Options.CnslMsgLog, "Message Log");

		img_MessageLogSpec = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_MessageLogSpec, 400, 150, 0, 185, image_MessageLogSpec,
				image_MessageLogSpecHover, image_MessageLogSpecSelected, 1, 19, Options.SpcCnslMsgLog,
				"Spectator Message Log");

		img_Obituary = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Obituary, 400, 150, compX - 400 - 20, 60, image_Obituary, image_ObituaryHover,
				image_ObituarySelected, 1, 20, Options.ObitMsg, "Obituary Message Log");

		img_ObjectiveNotification = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ObjectiveNotification, 700, 70, compX / 2 - 700 / 2, 150, image_ObjectiveNotification,
				image_ObjectiveNotificationHover, image_ObjectiveNotificationSelected, 2, 21, Options.ObjNtf,
				"Objective Notification");

		img_ReadyUp = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ReadyUp, 218, 105, compX / 2 - 218 / 2, 0, image_ReadyUp, image_ReadyUpHover,
				image_ReadyUpSelected, 1, 22, Options.ReadyUp, "Ready Up");

		img_RoundIntro = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_RoundIntro, 480, 110, 0, compY - 110, image_RoundIntro, image_RoundIntroHover,
				image_RoundIntroSelected, 1, 23, Options.ExeRoundIntro, "Execution Round Intro");

		img_Subtitles = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Subtitles, 300, 35, compX / 2 - 300 / 2, 122, image_Subtitles, image_SubtitlesHover,
				image_SubtitlesSelected, 1, 25, Options.Subtitles, "Subtitles");

		img_WeaponAmmo = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_WeaponAmmo, 180, 55, compX - 180 - 20, compY - 55 - 57, image_WeaponAmmo,
				image_WeaponAmmoHover, image_WeaponAmmoSelected, 2, 26, Options.WeaponAmmo, "Weapon Ammo");

		img_XP = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_XP, 220, 80, compX / 2 - 220 / 2, compY / 2 - 80 / 2 + 200, image_XP, image_XPHover,
				image_XPSelected, 2, 27, Options.XpCounter, "XP Counter");

		img_Armor = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_Armor, 453, 82, compX / 2 - 453 / 2, compY - 82 - 100, image_Armor, image_ArmorHover,
				image_ArmorSelected, 2, 6, Options.ShieldBar, "Phantom Shield Bar");

		img_SpectatorCard = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_SpectatorCard, 416, 121, compX / 2 - 416 / 2, compY - 121, image_SpectatorCard,
				image_SpectatorCardHover, image_SpectatorCardSelected, 1, 24, Options.SpcCard, "Spectator Card");

		img_CharacterSelect = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_CharacterSelect, 782, 327, compX / 2 - 782 / 2, compY - 327, image_CharacterSelect,
				image_CharacterSelectHover, image_CharacterSelectSelected, 1, 8, Options.CharSelect,
				"Character Select");

		img_ActionMenuSpec = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ActionMenuSpec, 526, 173, 10, 10, image_ActionMenu, image_ActionMenuHover,
				image_ActionMenuSelected, 1, 28, Options.SpcActionMenu, "Spectator Action Menu");

		img_ActionMenu = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ActionMenu, 526, 173, 10, 10, image_ActionMenu, image_ActionMenuHover,
				image_ActionMenuSelected, 1, 4, Options.ActionMenu, "Action Menu");

		img_ExeGameStat = new Label(HUD_Preview, SWT.NONE);
		setLabelProperties(img_ExeGameStat, 1056, 120, compX / 2 - 1056 / 2, 0, image_ExeGameStat,
				image_ExeGameStatHover, image_ExeGameStatSelected, 1, 14, Options.ExeGameStat, "Execution Game Status");

		Options.mode = 1;
		mode();

		Label lblVersion = new Label(HUD_Preview, SWT.NONE);
		lblVersion.setAlignment(SWT.RIGHT);
		lblVersion.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblVersion.setBounds(compX - 130, compY - 20, 123, 15);
		lblVersion.setText("Build Version: " + Settings.buildVersion);

		for (int y = 0; y < compY; y += Settings.gridSize) {
			Label LineH = new Label(HUD_Preview, SWT.SEPARATOR | SWT.HORIZONTAL);
			LineH.setBounds(0, y, compX, 1);
			line_H.add(LineH);
			if (Settings.showGrid == true) {
				LineH.setVisible(true);
			} else {
				LineH.setVisible(false);
			}
		}

		for (int x = 0; x < compX; x += Settings.gridSize) {
			Label LineV = new Label(HUD_Preview, SWT.SEPARATOR | SWT.VERTICAL);
			LineV.setBounds(x, 0, 1, compY);
			line_V.add(LineV);
			if (Settings.showGrid == true) {
				LineV.setVisible(true);
			} else {
				LineV.setVisible(false);
			}
		}

		lineH = new Label(HUD_Preview, SWT.SEPARATOR | SWT.HORIZONTAL);
		lineH.setBounds(0, compY / 2, compX, 2);

		lineV = new Label(HUD_Preview, SWT.SEPARATOR | SWT.VERTICAL);
		lineV.setBounds(compX / 2, 0, 2, compY);
		if (Settings.showCenter == true) {
			lineV.setVisible(true);
			lineH.setVisible(true);
		} else {
			lineV.setVisible(false);
			lineH.setVisible(false);
		}
		Composite dragbar = new Composite(HUD_Preview, SWT.NONE);
		dragbar.setBounds(0, 0, compX, 25);
		dragbar.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
				App_UI.setMinimized(true);
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
					App_UI.setLocation(App_UI.getLocation().x + (e.x - xPos), App_UI.getLocation().y + (e.y - yPos));
				}
			}
		});

		Label lblTitle = new Label(dragbar, SWT.NONE);
		lblTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTitle.setBounds(5, 5, 118, 15);
		lblTitle.setText("Dirty Bomb HUDEdit");
		lblTitle.addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
				App_UI.setMinimized(true);
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
		lblTitle.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				if (isMouseDown == true) {
					App_UI.setLocation(App_UI.getLocation().x + (e.x - xPos), App_UI.getLocation().y + (e.y - yPos));
				}
			}
		});
	}

	public static void mode() {
		if (Options.mode == 1) {
			img_Ability.setVisible(true);
			img_Minimap.setVisible(true);
			img_Objective.setVisible(true);
			img_ActionMenu.setVisible(true);
			img_ActionMenuSpec.setVisible(false);
			img_ObjectiveSpec.setVisible(false);
			img_Armor.setVisible(true);
			img_Badge.setVisible(true);
			img_CharacterSelect.setVisible(true);
			img_ChatInput.setVisible(true);
			img_ChatInputSpec.setVisible(false);
			img_Debilitated.setVisible(true);
			img_Detected.setVisible(true);
			img_ExeBadge.setVisible(false);
			img_ExeGameStat.setVisible(false);
			img_GameWave.setVisible(true);
			img_GameWaveSpec.setVisible(false);
			img_Health.setVisible(true);
			img_MessageLog.setVisible(true);
			img_MessageLogSpec.setVisible(false);
			img_Obituary.setVisible(true);
			img_ObjectiveNotification.setVisible(true);
			img_ReadyUp.setVisible(false);
			img_RoundIntro.setVisible(false);
			img_SpectatorCard.setVisible(false);
			img_Subtitles.setVisible(false);
			img_WeaponAmmo.setVisible(true);
			img_XP.setVisible(true);
		}

		else if (Options.mode == 3) {
			img_Ability.setVisible(false);
			img_Minimap.setVisible(true);
			img_Objective.setVisible(false);
			img_ActionMenu.setVisible(false);
			img_ActionMenuSpec.setVisible(true);
			img_ObjectiveSpec.setVisible(true);
			img_Armor.setVisible(true);
			img_Badge.setVisible(true);
			img_CharacterSelect.setVisible(false);
			img_ChatInput.setVisible(false);
			img_ChatInputSpec.setVisible(true);
			img_Debilitated.setVisible(true);
			img_Detected.setVisible(true);
			img_ExeBadge.setVisible(false);
			img_ExeGameStat.setVisible(false);
			img_GameWave.setVisible(false);
			img_GameWaveSpec.setVisible(true);
			img_Health.setVisible(true);
			img_MessageLog.setVisible(false);
			img_MessageLogSpec.setVisible(true);
			img_Obituary.setVisible(true);
			img_Obituary.setImage(image_ObituarySpec);
			img_ObjectiveNotification.setVisible(true);
			img_ReadyUp.setVisible(false);
			img_RoundIntro.setVisible(false);
			img_SpectatorCard.setVisible(true);
			img_Subtitles.setVisible(false);
			img_WeaponAmmo.setVisible(true);
			img_XP.setVisible(true);
		}

		else if (Options.mode == 2) {
			img_Ability.setVisible(false);
			img_Minimap.setVisible(false);
			img_Objective.setVisible(false);
			img_ActionMenu.setVisible(false);
			img_ActionMenuSpec.setVisible(false);
			img_ObjectiveSpec.setVisible(false);
			img_ActionMenuSpec.setVisible(false);
			img_Armor.setVisible(false);
			img_Badge.setVisible(false);
			img_CharacterSelect.setVisible(false);
			img_ChatInput.setVisible(false);
			img_ChatInputSpec.setVisible(false);
			img_Debilitated.setVisible(false);
			img_Detected.setVisible(false);
			img_ExeBadge.setVisible(false);
			img_ExeGameStat.setVisible(false);
			img_GameWave.setVisible(false);
			img_GameWaveSpec.setVisible(false);
			img_Health.setVisible(false);
			img_MessageLog.setVisible(false);
			img_MessageLogSpec.setVisible(false);
			img_Obituary.setVisible(false);
			img_ObjectiveNotification.setVisible(false);
			img_ReadyUp.setVisible(true);
			img_RoundIntro.setVisible(false);
			img_SpectatorCard.setVisible(false);
			img_Subtitles.setVisible(true);
			img_WeaponAmmo.setVisible(false);
			img_XP.setVisible(false);
		}

		else if (Options.mode == 4) {
			img_Ability.setVisible(true);
			img_Minimap.setVisible(true);
			img_Objective.setVisible(false);
			img_ActionMenu.setVisible(true);
			img_ActionMenuSpec.setVisible(false);
			img_ActionMenuSpec.setVisible(false);
			img_ObjectiveSpec.setVisible(false);
			img_Armor.setVisible(true);
			img_Badge.setVisible(false);
			img_CharacterSelect.setVisible(true);
			img_ChatInput.setVisible(true);
			img_ChatInputSpec.setVisible(false);
			img_Debilitated.setVisible(true);
			img_Detected.setVisible(true);
			img_ExeBadge.setVisible(true);
			img_ExeGameStat.setVisible(true);
			img_GameWave.setVisible(false);
			img_GameWaveSpec.setVisible(false);
			img_Health.setVisible(true);
			img_MessageLog.setVisible(true);
			img_MessageLogSpec.setVisible(false);
			img_Obituary.setVisible(true);
			img_ObjectiveNotification.setVisible(true);
			img_ReadyUp.setVisible(false);
			img_RoundIntro.setVisible(true);
			img_SpectatorCard.setVisible(true);
			img_Subtitles.setVisible(false);
			img_WeaponAmmo.setVisible(true);
			img_XP.setVisible(true);
		}
	}
}
