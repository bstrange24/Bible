package com.bible.gui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextAreaFrame// extends JFrame
{
	public List< String > d = null;
	JTextArea textFrame = null;
	public TextAreaFrame( List< String > output )
	{
		this.d = output;
	}

	public void display()
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run()
			{
				JFrame frame = new JFrame();
				textFrame = new JTextArea();
				frame.add( textFrame );
				frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				frame.setSize( 1000, 1000 );
				frame.setVisible( true );
				frame.setTitle( "Matching Verses" );
			}
		} );
		
		
		String output = "";
		
		for ( String o : this.d )
		{
			output += "\n" + o;
		}
		textFrame.setText( output );
	}
}