package com.bible.app;

import org.apache.log4j.Logger;

public class SendNotification
{
	public final static Logger logger = Logger.getLogger( SendNotification.class );
	
	public String server;
	public String rejectFileLocation;
	public String smtpServer;
	public String inputFile;
	
}
