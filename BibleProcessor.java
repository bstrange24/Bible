package com.bible.processors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import com.bible.constants.BibleConstants;
import com.bible.counts.BibleCounts;
import com.bible.exceptions.BibleException;
import com.bible.file.BibleFile;
import com.bible.gui.TextAreaFrame;
import com.bible.url.StrongsOnline;

public class BibleProcessor
{
	private final static Logger logger = Logger.getLogger( BibleProcessor.class );
	
	public void processInputFile( String inputFileName, HashMap <String, String> configMap ) throws IOException, BibleException
	{
		logger.debug( BibleConstants.ENTER_PROCESS_INPUT_FILE );
		StringBuffer rejects = new StringBuffer();
		BibleCounts counts = new BibleCounts();
		BibleFile file = new BibleFile();
		List< BibleFields > text = new ArrayList< BibleFields >();
		BibleFields record = null;
		String currentLine = null;
		List< String > output = new ArrayList< String >();
		
		try
		{
			file.open( inputFileName );
			int rowId = 0;

			while ( ( currentLine = file.getNextRecord() ) != null )
			{
				rowId += 1;
				counts.incrementTotalLines();
				
				record = file.processDetail( currentLine, rejects, rowId );
				
				if( record != null)
				{
					record.setRowId( rowId );
					text.add( record );
				}
			}
			
			String searchWord = JOptionPane.showInputDialog( "Enter word to search for:" );
			
			for( BibleFields lines : text )
			{
				if( lines.getText().contains( searchWord ))
				{
					String display = lines.getBook() + " " + lines.getChapter() + ":" + lines.getVerse() + " " + lines.getText();
					output.add( display );
					logger.info( lines.getBook() + " " + lines.getChapter() + ":" + lines.getVerse() + lines.getText() );
				}
			}
			
			TextAreaFrame print = new TextAreaFrame( output );
			print.display();
			//String searcWord = JOptionPane.showInputDialog( "Enter word to search for:" );
			
			//StrongsOnline strongsOnline = new StrongsOnline();
			//strongsOnline.getStrongsUrl( searchWord );
		} 
		catch ( Exception e )
		{
			logger.error( "Error processing file :: " + e.getMessage() );
			throw new BibleException(e.getMessage());
		}
		//System.out.println( "Record counts :: " + counts.getTotalLines() );
		//logger.debug( BibleConstants.LEAVING_PROCESS_INPUT_FILE );
	}
}
