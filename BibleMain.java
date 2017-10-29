package com.bible.main;

import java.time.Clock;
import java.util.HashMap;
import org.apache.log4j.Logger;
import com.bible.config.BibleConfigurator;
import com.bible.constants.BibleConstants;
import com.bible.exceptions.BibleException;
import com.bible.processors.BibleProcessor;
import com.bible.validate.Validate;

public class BibleMain
{
	private final static Logger logger = Logger.getLogger( BibleMain.class );

	public static void main( String[] args ) throws BibleException
	{
		Validate validateFilePath = new Validate();
		BibleConfigurator configurator = new BibleConfigurator();
		
		Clock clock = Clock.systemDefaultZone();
		long startTime = clock.millis();
		
		String inputFileName = null;
		String configFileName = null;
		int returnCode = 0;

		if ( args.length < 2 )
		{
			logger.error( "Invalid command line argument." );
			returnCode = 10;
		} 
		else
		{
			inputFileName = args[ 0 ];
			configFileName = args[ 1 ];

			logger.info( "***********************************************  Processing STARTED *********************************************** " );
			logger.info( "Input file name :: " + inputFileName );
			logger.info( "Configuration file name :: " + configFileName );

			HashMap< String, String > configMap = new HashMap< String, String >();

			try
			{
				configMap = configurator.loadConfigurations( configMap, configFileName );
				
				if ( validateFilePath.validateArguments( configFileName, configMap ) && validateFilePath.validateArguments( inputFileName, configMap ) )
				{
					if( configMap != null )
					{
						configMap.put( BibleConstants.INPUT_FILE_PATH, inputFileName );
						logger.debug( BibleConstants.CONFIGURATION_VALUES + configMap.values() );
						
						BibleProcessor processor = new BibleProcessor();
						processor.processInputFile( inputFileName, configMap );
					}
					else
					{
						logger.error( "ConfigMap is null" );
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
				logger.error( "A Bible exception occurred :: " + e.getMessage() );
				returnCode = 40;
			}
			catch ( Exception e )
			{
				logger.error( "An exception occurred :: " + e.getMessage() );
				returnCode = 30;
			}
		}
		long endTime = clock.millis();
		logger.info( "PERFMON :: TOTAL TIME :: " + ( endTime - startTime ) + " :: ms" );
		logger.info( "Return code :: " + returnCode );
		logger.info( "*********************************************** Processing FINISHED *********************************************** " );
		System.exit( returnCode );
	}
}
