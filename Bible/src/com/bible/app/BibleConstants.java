package com.bible.app;

public class BibleConstants
{
	// Config file
	public static final String MAIL_TO = "mailTo";
	public static final String NEW_INPUT_FILE_PATH = "newInputPath";
	public static final String OLD_INPUT_FILE_PATH = "oldInputPath";
	public static final String NIV_INPUT_FILE_PATH = "nivInputPath";
	public static final String CONFIG_FILE_PATH = "configPath";
	public static final String REJECT_FILE_PATH = "rejectPath";
	public static final String SERVER = "rejectPath";
	public static final String SMTP_SERVER = "rejectPath";

    // Files
    public static final String NEW_TESTAMEMT_FILE_NAME = "New Testament input file name :: ";
    public static final String OLD_TESTAMEMT_FILE_NAME = "Old Testament input file name :: ";
    public static final String NIV_TESTAMEMT_FILE_NAME = "NIV input file name :: ";

	// Configuration
	public static final String CONFIGURATION_VALUES = "Config values :: ";
	public static final String PARSING_CONFIGURATION_PROPERTIES = "... PARSING CONFIGURATION FILE...";
	public static final String CONFIGURATION_VALUES_LOADED = "... CONFIGURATION LOADED ...";
    public static final String CONFIGURATION_FILE_NAME = "Configuration file name :: ";

	// Errors
	public static final String UNABLE_TO_PARSE_CONFIGURATION_ERROR = "Unable to parse configuration file ";
	public static final String INVALID_PATH_ERROR = "Invalid input file or config file path";
	public static final String INVALID_ARGUMENTS_ERROR = "Please provide valid input file and paramters";
    public static final String RECORD_ID = "Record id :: ";
    public static final String RECORD_REJECT_REASON = " rejected because :: ";
    public static final String ERROR_PROCESSING_INPUT_FILE = "Error processing file :: ";

	
	// Entering and Leaving
	public static final String ENTER_LOAD_CONFIGURATION = "Entering Load Configurations";
	public static final String LEAVING_LOAD_CONFIGURATION = "Leaving Load Configurations";
	public static final String ENTER_PROCESS_INPUT_FILE = "Entering processInputFile";
	public static final String LEAVING_PROCESS_INPUT_FILE = "Leaving processInputFile";
	public static final String BIBLE_EXCEPTION_OCCURRED = "A Bible exception occurred :: ";
	public static final String EXCEPTION_OCCURRED = "An exception occurred :: ";
	public static final String CONFIG_MAP_IS_NULL = "ConfigMap is null";
	public static final String INVALID_CMD_ARGUMENTS = "Invalid command line argument.";

	// Logger Statements
	public static final String PROCESSING_STARTED = "***********************************************  Processing STARTED *********************************************** ";
	public static final String PROCESSING_FINISHED = "*********************************************** Processing FINISHED *********************************************** ";
    public static final String PERFMON_TOTAL_TIMING = "PERFMON :: TOTAL TIME :: ";
    public static final String MILLI_SECONDS = " :: ms";
    public static final String RETURN_CODE = "Return code :: ";
    public static final String NEW = "New";
    public static final String OLD = "Old";
    // User interaction
    public static final String ENTER_SEARCH_WORD = "Enter word to search for:";
    public static final String ENTER_TESTAMENT = "Enter Testament:";

    // Counts
    public static final String RECORD_COUNTS = "Record counts :: ";

}
