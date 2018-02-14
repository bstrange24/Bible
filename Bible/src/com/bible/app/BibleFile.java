package com.bible.app;

import org.apache.log4j.Logger;

public class BibleFile
{
	private final static Logger logger = Logger.getLogger( BibleFile.class );

	public BibleFields processKJVDetail( String line, StringBuffer rejects, int rowId )
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
	
	public BibleFields processNIVDetail( String line, StringBuffer rejects, int rowId )
	{
		BibleCounts counts = new BibleCounts();
		BibleFields bibleFields = new BibleFields();
		String[] fields;
		String[] firstWord;
		String finalFirstWord;

		try
		{
			//fields = line.split( "[0-9]+[A-Za-z]" );
			fields = line.split( " " );
			firstWord = fields[0].split( "^[0-9]+" ); // [A-Za-z]" );
			if ( firstWord.length > 1 )
			{
				finalFirstWord = firstWord[ 1 ];
				bibleFields.setBook( fields[ 0 ] );
				//bibleFields.setChapter( fields[1] );
				//bibleFields.setVerse( fields[2] );
				//bibleFields.setText( fields[3].replace( "~", "" ) );
			}
			else
			{
				bibleFields.setBook( firstWord[ 0 ] );
				//bibleFields.setBook( fields[ 0 ] );
				//bibleFields.setChapter( fields[1] );
				//bibleFields.setVerse( fields[2] );
				//bibleFields.setText( fields[3].replace( "~", "" ) );
			}
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
