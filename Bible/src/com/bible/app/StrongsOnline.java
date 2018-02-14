package com.bible.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StrongsOnline
{
	private final static Logger logger = Logger.getLogger( StrongsOnline.class );

	public List< String > getUrl( String searchWord, String testament ) throws BibleException
	{
		List< String > searchWordlinks = new ArrayList<>();

		String url;
		if ( testament.equals( "Old" ) )
		{
			url = "http://biblez.com/searchhebrew.php?q=" + searchWord;
			print( "Fetching %s...", url );
		}
		else
		{
			url = "http://biblez.com/searchgreek.php?q=" + searchWord;
			print( "Fetching %s...", url );
		}

		try
		{
			Document doc = Jsoup.connect( url ).get();
			Elements links = doc.select( "a[href]" );

			print( "\nLinks: (%d)", links.size() );
			for ( Element link : links )
			{
				print( "\nLink: (%s)", link );
				if ( testament.equals( "Old" ) )
				{
					if ( link.attr( "abs:href" ).contains( "http://biblehub.com/str/hebrew" ) )
					{
						print( " * a: <%s>  (%s)", link.attr( "abs:href" ), trim( link.text(), 35 ) );
						searchWordlinks.add( link.attr( "abs:href" ) );
					}
				}
				else
				{
					if ( link.attr( "abs:href" ).contains( "http://biblehub.com/str/greek" ) )
					{
						print( " * a: <%s>  (%s)", link.attr( "abs:href" ), trim( link.text(), 35 ) );
						searchWordlinks.add( link.attr( "abs:href" ) );
					}
				}
			}
		}
		catch ( Exception e )
		{
			logger.error( "Error when connecting with search word :: " + e.getMessage() );
			throw new BibleException( e.getMessage() );
		}
		return searchWordlinks;
	}

	public void processSearchUrls( List<String> urls, String testament ) throws BibleException
	{
		for ( String url : urls )
		{
			//String url = urls.get( 0 );
			print( "Fetching %s...", url );
			try
			{
				Document doc = Jsoup.connect( url ).get();
				logger.info( doc.getAllElements().text() );
				if ( testament.equals( "Old" ) )
				{
					Elements cont = doc.getElementsByClass( "tophdg" );
					for ( int i = 0; i < cont.size(); i++ )
					{
						Element para = cont.get( i );
						System.out.println( para.text() );
						System.out.println( para.nextSibling().toString() );
					}
				}
				else
				{
					Elements cont = doc.getElementsByClass( "tophdg" );
					for ( int i = 0; i < cont.size(); i++ )
					{
						Element para = cont.get( i );
						System.out.println( para.text() + " " + para.nextSibling().toString() );
					}
					System.out.println();
				}
			}
			catch ( Exception e )
			{
				logger.error( "Error when connecting to search url(s) :: " + e.getMessage() );
				throw new BibleException( e.getMessage() );
			}
		}
	}

	public static void print( String msg, Object... args )
	{
		logger.info( String.format( msg, args ) );
	}

	public static String trim( String s, int width )
	{
		if ( s.length() > width )
			return s.substring( 0, width - 1 ) + ".";
		else
			return s;
	}
}
