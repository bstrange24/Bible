package com.bible.app;

import java.time.Clock;
import java.util.HashMap;
import org.apache.log4j.Logger;

public class BibleMain
{
	private final static Logger logger = Logger.getLogger( BibleMain.class );

	public static void main( String[] args )
	{
		Validate validateFilePath = new Validate();
		BibleConfigurator configurator = new BibleConfigurator();

		Clock clock = Clock.systemDefaultZone();
		long startTime = clock.millis();

		String newInputFileName;
		String oldInputFileName;
		String nivInputFileName;
		String configFileName;
		int returnCode = 0;

		if ( args.length < 3 )
		{
			logger.error( BibleConstants.INVALID_CMD_ARGUMENTS );
			returnCode = 10;
		}
		else
		{
			newInputFileName = args[ 0 ];
			oldInputFileName = args[ 1 ];
			nivInputFileName = args[ 2 ];
			configFileName = args[ 3 ];

			logger.info( BibleConstants.PROCESSING_STARTED );
			logger.info( BibleConstants.NEW_TESTAMEMT_FILE_NAME + newInputFileName );
			logger.info( BibleConstants.OLD_TESTAMEMT_FILE_NAME + oldInputFileName );
			logger.info( BibleConstants.NIV_TESTAMEMT_FILE_NAME + nivInputFileName );
			logger.info( BibleConstants.CONFIGURATION_FILE_NAME + configFileName );

			HashMap< String, String > configMap = new HashMap<>();

			try
			{
				configMap = configurator.loadConfigurations( configMap, configFileName );

				if ( validateFilePath.validateArguments( configFileName, configMap ) && validateFilePath.validateArguments( newInputFileName, configMap ) && validateFilePath.validateArguments( oldInputFileName, configMap ) )
				{
					if ( configMap != null )
					{
						configMap.put( BibleConstants.NEW_INPUT_FILE_PATH, newInputFileName );
						configMap.put( BibleConstants.OLD_INPUT_FILE_PATH, oldInputFileName );
						configMap.put( BibleConstants.NIV_INPUT_FILE_PATH, nivInputFileName );
						logger.debug( BibleConstants.CONFIGURATION_VALUES + configMap.values() );

						KJVProcessor kjvProcessor = new KJVProcessor();
						kjvProcessor.processInputFile( newInputFileName, oldInputFileName, nivInputFileName, configMap );

						//NIVProcessor nivProcessor = new NIVProcessor();
						//nivProcessor.processInputFile( nivInputFileName, configMap );
					}
					else
					{
						logger.error( BibleConstants.CONFIG_MAP_IS_NULL );
						returnCode = 60;
					}
				}
				else
				{
					logger.error( BibleConstants.INVALID_ARGUMENTS_ERROR );
					returnCode = 20;
				}
			}
			catch ( BibleException e )
			{
				logger.error( BibleConstants.BIBLE_EXCEPTION_OCCURRED + e.getMessage() );
				returnCode = 40;
			}
			catch ( Exception e )
			{
				logger.error( BibleConstants.EXCEPTION_OCCURRED + e.getMessage() );
				returnCode = 30;
			}
		}

		logger.info( BibleConstants.PERFMON_TOTAL_TIMING + ( clock.millis() - startTime ) + BibleConstants.MILLI_SECONDS );
		logger.info( BibleConstants.RETURN_CODE + returnCode );
		logger.info( BibleConstants.PROCESSING_FINISHED );
		System.exit( returnCode );
	}
}
