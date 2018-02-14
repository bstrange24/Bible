package com.bible.app;

import java.io.File;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;


public class BibleConfigurator
{
	private final static Logger logger = Logger.getLogger( BibleConfigurator.class );
	
	public HashMap < String, String > loadConfigurations( HashMap < String, String > configMap, String configurationFile ) throws BibleException, JAXBException
	{
		logger.debug( BibleConstants.ENTER_LOAD_CONFIGURATION );
		try
		{
			logger.info( BibleConstants.PARSING_CONFIGURATION_PROPERTIES );
			
			JAXBContext jaxbContent = JAXBContext.newInstance( BibleConfiguratorProperties.class );
			Unmarshaller jaxbUnmarshaller = jaxbContent.createUnmarshaller();
			File file = new File( configurationFile );
			BibleConfiguratorProperties configuration = ( BibleConfiguratorProperties ) jaxbUnmarshaller.unmarshal( file );
			
			configMap.put( BibleConstants.MAIL_TO, configuration.getMailTo() );
			configMap.put( BibleConstants.NEW_INPUT_FILE_PATH, configuration.getNewInputPath() );
			configMap.put( BibleConstants.OLD_INPUT_FILE_PATH, configuration.getOldInputPath() );
			configMap.put( BibleConstants.NIV_INPUT_FILE_PATH, configuration.getNivInputPath() );
			configMap.put( BibleConstants.CONFIG_FILE_PATH, configuration.getConfigFilePath() );
			configMap.put( BibleConstants.REJECT_FILE_PATH, configuration.getRejectFilePath() );
			
			logger.info( BibleConstants.CONFIGURATION_VALUES_LOADED );
		}
		catch ( Exception e )
		{
			logger.error( BibleConstants.UNABLE_TO_PARSE_CONFIGURATION_ERROR + e.getMessage() );
			throw new BibleException(e.getMessage());
		}
		logger.debug( BibleConstants.LEAVING_LOAD_CONFIGURATION );
		return configMap;
	}
}
