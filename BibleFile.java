package com.bible.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.bible.counts.BibleCounts;
import com.bible.exceptions.BibleException;
import com.bible.processors.BibleFields;

public class BibleFile
{
	private final static Logger logger = Logger.getLogger( BibleFile.class );
	BufferedReader reader = null;

	public void open( String inputFilePath ) throws BibleException
	{
		try
		{
			reader = new BufferedReader( new FileReader( new File( inputFilePath ) ) );
		} 
		catch ( FileNotFoundException e )
		{
			logger.error( "File not found " + e.getMessage() );
			throw new BibleException( e.getMessage() );
		}
	}

	public void close() throws BibleException
	{
		if ( reader != null )
		{
			try
			{
				reader.close();
			} 
			catch ( IOException e )
			{
				logger.error( "Unable to close input file " + e.getMessage() );
				throw new BibleException( e.getMessage() );
			}
		}
	}

	public String getNextRecord() throws BibleException
	{
		String line = null;

		try
		{
			line = reader.readLine();
		} 
		catch ( IOException e )
		{
			logger.error( "Unable to get next record " + e.getMessage() );
			throw new BibleException( e.getMessage() );
		}
		return line;
	}
	
	public BibleFields processDetail( String line, StringBuffer rejects, int rowId )
	{
		BibleCounts counts = new BibleCounts();
		BibleFields bibleFields = new BibleFields();
		String[] fields = null;
		
		try
		{
			fields = line.split( "[|]" );
			bibleFields.setBook( fields[0] );
			bibleFields.setChapter( fields[1] );
			bibleFields.setVerse( fields[2] );
			bibleFields.setText( fields[3].replace( "~", "" ) );
			
		}
		catch( Exception e)
		{
			logger.error( "Error splitting file :: " + rowId + " error " + e.getMessage() );
			rejects.append( "Error splitting file :: " + rowId + " error " + e.getMessage() );
			
			counts.incrementTotalRejects();
			return null;
		}
		return bibleFields;
	}
}
