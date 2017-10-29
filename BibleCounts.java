package com.bible.counts;

public class BibleCounts
{
	public static int totalLines = 0;
	public static int totalRejects = 0;
	
	public void incrementTotalLines()
	{
		BibleCounts.totalLines++;
		this.setTotalLines( totalLines );
	}
	
	public int getTotalLines()
	{
		return totalLines;
	}
	
	public void setTotalLines( int totatLines )
	{
		BibleCounts.totalLines = totatLines;
	}
	
	public void incrementTotalRejects()
	{
		BibleCounts.totalRejects++;
		this.setTotalLines( totalRejects );
	}
	
	public int getTotalRejects()
	{
		return totalRejects;
	}
	
	public void setTotalRejects( int totalRejects )
	{
		BibleCounts.totalRejects = totalRejects;
	}
}
