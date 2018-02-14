package com.bible.app;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;

public class NIVProcessor
{
	private final static Logger logger = Logger.getLogger( NIVProcessor.class );
	
	public void processInputFile( String nivInputFileName, HashMap< String, String > configMap ) throws BibleException
	{
		logger.debug( BibleConstants.ENTER_PROCESS_INPUT_FILE );
		StringBuffer rejects = new StringBuffer();
		StringBuffer sbDisplay = new StringBuffer();
		BibleCounts recordCounts = new BibleCounts();
		BibleFile file = new BibleFile();
		//List< String > output = new ArrayList<>();
		//List< String > searchUrls;
		List< String > nivRecordList;
		BibleFields record = null;
		int rowId = 0;

		try ( BufferedReader brNiv = Files.newBufferedReader( Paths.get( nivInputFileName ) ) )
		{
			nivRecordList = brNiv.lines().collect( Collectors.toList() );
			recordCounts.setTotalLines( nivRecordList.size() );

			//String searchWord = JOptionPane.showInputDialog( BibleConstants.ENTER_SEARCH_WORD );
			//String testament = JOptionPane.showInputDialog( BibleConstants.ENTER_TESTAMENT );

			//if ( testament.equalsIgnoreCase( BibleConstants.NEW ) )
			//{
				for ( String eachRecord : nivRecordList )
				{
					rowId += 1;
					record = file.processNIVDetail( eachRecord, rejects, rowId );

					//if ( record.getText().contains( searchWord ) )
					//{
						sbDisplay.append( record.getBook() );
						sbDisplay.append( " " );
						sbDisplay.append( record.getChapter() );
						sbDisplay.append( ":" );
						sbDisplay.append( record.getVerse() );
						sbDisplay.append( " " );
						sbDisplay.append( record.getText() );

						//String display = record.getBook() + " " + record.getChapter() + ":" + record.getVerse() + " " + record.getText();
						//output.add( display );
						//logger.debug( record.getBook() + " " + record.getChapter() + ":" + record.getVerse() + record.getText() );
						//System.out.println( record.getBook() + " " + record.getChapter() + ":" + record.getVerse() + record.getText() );
						logger.debug( sbDisplay.toString() );
						System.out.println( sbDisplay.toString() );
						// This will clear the buffer
						sbDisplay.delete( 0, sbDisplay.length());
					//}
				}
				System.out.println();
			//}

			/*for ( BibleFields lines : text )
			{
				if ( lines.getText().contains( searchWord ) )
				{
					String display = lines.getBook() + " " + lines.getChapter() + ":" + lines.getVerse() + " " + lines.getText();
					output.add( display );
				}
				logger.debug( lines.getBook() + " " + lines.getChapter() + ":" + lines.getVerse() + lines.getText() );
				// System.out.println( lines.getBook() + " " + lines.getChapter() + ":" + lines.getVerse() + lines.getText() ); }
			} */

			/*TextAreaFrame print = new TextAreaFrame( output );
			print.display();
			String searcWord = JOptionPane.showInputDialog( "Enter word to search for:" );

			SwingUtilities.invokeLater( new Runnable() {
			@Override public void run() { TextAreaFrame cf = new TextAreaFrame(output); }
			} );*/

			/*if ( !searchWord.contains( " " ) )
			{
				StrongsOnline strongsOnline = new StrongsOnline();
				searchUrls = strongsOnline.getUrl( searchWord, testament );
				strongsOnline.processSearchUrls( searchUrls, testament );
			}*/
		}
		catch ( Exception e )
		{
			rejects.append( BibleConstants.RECORD_ID + record.getRowId() + BibleConstants.RECORD_REJECT_REASON + e.getMessage() + "\n" );
			logger.error( BibleConstants.ERROR_PROCESSING_INPUT_FILE + e.getMessage() );
			e.printStackTrace();
			throw new BibleException( e.getMessage() );
		}
		logger.debug( BibleConstants.RECORD_COUNTS + recordCounts.getTotalLines() );
		logger.debug( BibleConstants.LEAVING_PROCESS_INPUT_FILE );
	}
}
