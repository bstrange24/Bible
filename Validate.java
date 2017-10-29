package com.bible.validate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import com.bible.constants.BibleConstants;

public class Validate
{
	private final static Logger logger = Logger.getLogger( Validate.class );

	public boolean validateArguments( String filePath, HashMap< String, String > configMap ) throws IOException
	{
		File file = new File( filePath );
		String getParent = file.getParent();

		if ( getParent.equals( configMap.get( BibleConstants.INPUT_FILE_PATH ) ) )
		{
			return true;
		} 
		else if ( getParent.equals( configMap.get( BibleConstants.CONFIG_FILE_PATH ) ) )
		{
			return true;
		}
		else
		{
			logger.error( BibleConstants.INVALID_PATH_ERROR );
			return false;
		}
	}
}
