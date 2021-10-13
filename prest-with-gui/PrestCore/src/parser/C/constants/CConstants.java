package parser.C.constants;

import javax.swing.JFrame;

public class CConstants extends JFrame {

	/** Class fields */
	private static final long serialVersionUID = -158067136481622615L;

	/** Which view is currently being displayed */
	/** Constant for indicating file view state of the gui */
	public static final boolean FILE_VIEW = true;
	/** Constant for indicating module view state of the gui */
	public static final boolean MODULE_VIEW = false;
	/** Which header to use when writing a header to a file */
	public static final boolean FILE_METRICS_HEADER = true;
	public static final boolean MODULE_METRICS_HEADER = false;
	/** The name of the options file. */
	public static final String OPTIONS_FILE_NAME = "options.opt";
	/** The title of this frame */
	public static final String MAIN_FRAME_TITLE = "Metrics Extractor";
	/** The text of the file menu */
	public static final String FILE_MENU_TEXT = "File";
	/** The text of the new project menu item */
	public static final String NEW_PROJECT_JMI_TEXT = "New Project...";
	/** The text of the open project menu item */
	public static final String OPEN_PROJECT_JMI_TEXT = "Open Project...";
	/** The text of the add source folder menu item */
	public static final String ADD_SOURCE_FOLDER_JMI_TEXT = "Add Source Folder...";
	/** The text of the close project menu item */
	public static final String CLOSE_PROJECT_JMI_TEXT = "Close Project";
	/** The text of the delete project menu item */
	public static final String DELETE_PROJECT_JMI_TEXT = "Delete Project";
	/** The text of the exit program menu item */
	public static final String EXIT_PROGRAM_JMI_TEXT = "Exit";
	/** The text of the project information dialog */
	public static final String PROJECT_INFORMATION_DIALOG_TEXT = "Project Information";
	/** The text for the OK buttons */
	public static final String OK_BUTTON_TEXT = "OK";
	/** The text for the CANCEL buttons */
	public static final String CANCEL_BUTTON_TEXT = "Cancel";
	/** The text for the BROWSE buttons */
	public static final String BROWSE_BUTTON_TEXT = "Browse...";
	/**
	 * The text for the location label in the project information dialog
	 */
	public static final String LOCATION_LABEL_TEXT = "Directory of Source Files:";
	/**
	 * The text for the project name label in the project information dialog
	 */
	public static final String PROJECT_NAME_LABEL_TEXT = "Project Name:";
	/** The text for the change view button in the file view */
	public static final String CHANGE_VIEW_BUTTON_FILE_TEXT = "Switch to Module View";
	/** The text for the change view button in the module view */
	public static final String CHANGE_VIEW_BUTTON_MODULE_TEXT = "Switch to File View";
	/** The text for the view menu */
	public static final String VIEW_MENU_TEXT = "View";
	/** The text for the project info menu item */
	public static final String PROJECT_INFO_JMI_TEXT = "Project Information";
	/** The text for the customize columns menu item */
	public static final String CUSTOMIZE_COLUMNS_JMI_TEXT = "Customize Columns...";
	/** The text for the help menu */
	public static final String HELP_MENU_TEXT = "Help";
	/** The text for the about menu item */
	public static final String ABOUT_JMI_TEXT = "About";
	/** The text for the project help menu item */
	public static final String PROJECT_HELP_JMI_TEXT = "Project Help";
	/**
	 * The column names in the current version. Add another name in this array
	 * for adding new metrics to the program. Caution!!! The implementation of
	 * the Module class has to be changed in accordance with this change (i.e.
	 * the value for this metrics must be supported by the MOdule objects)
	 */
	public static final String COLUMN_NAMES[] = { "total_loc", "blank_loc",
			"comment_loc", "code_and_comment_loc", "executable_loc",
			"unique_operands", "unique_operators", "total_operands",
			"total_operators", "halstead_vocabulary", "halstead_length",
			"halstead_volume", "halstead_level", "halstead_difficulty",
			"halstead_effort", "halstead_error", "halstead_time",
			"branch_count", "decision_count", "call_pairs", "condition_count",
			"multiple_condition_count", "cyclomatic_complexity",
			"cyclomatic_density", "decision_density", "design_complexity",
			"design_density", "norm_cyclomatic_complexity", "formal_parameters" };

	/**
	 * There are a total of 30 columns in File Metrics Table and 31 columns in
	 * Module Metrics Table, however the first column in File Metrics Table
	 * (name), and the first two columns in Module Metrics Table (name, file
	 * name) are always visible.
	 */
	public static int MAX_COLUMNS = COLUMN_NAMES.length;

	/**
	 * Minimum table height for all the tables it is used to make sure that at
	 * least one row is visible
	 */
	public static final int MIN_TABLE_HEIGHT = 25;
}