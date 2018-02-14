package com.bible.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextAreaFrame// extends JFrame
{
	public List< String > outputList = null;
	JTextArea textFrame = null;
	JFrame frame = null;

	private JMenuItem Exit = new JMenuItem( "Exit" );

	public TextAreaFrame( List< String > output )
	{
		Exit.addActionListener( new ExitListener() );

		WindowListener exitListener = new WindowAdapter()
		{
			@Override
			public void windowClosing( WindowEvent e )
			{
				int confirm = JOptionPane.showOptionDialog( frame, "Are You Sure to Close this Application?",
						"Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
						null );
				if ( confirm == JOptionPane.YES_OPTION )
					System.exit( 1 );
			}
		};

		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run()
			{
				frame = new JFrame( "Match" );
				textFrame = new JTextArea();
				frame.add( textFrame );

				// frame.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
				frame.addWindowListener( exitListener );
				frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

				frame.setSize( 1000, 1000 );
				frame.setVisible( true );
				frame.setTitle( "Matching Verses" );
			}
		} );

		this.outputList = output;
	}

	private class ExitListener implements ActionListener
	{
		@Override
		public void actionPerformed( ActionEvent e )
		{
			int confirm = JOptionPane.showOptionDialog( frame, "Are You Sure to Close this Application?",
					"Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null );
			if ( confirm == JOptionPane.YES_OPTION )
			{
				System.exit( 1 );
			}
		}
	}

	public void display() throws BibleException
	{
		String output = "";

		try
		{
			for ( String o : this.outputList )
			{
				output += "\n" + o;
			}
			
			textFrame.setText( output );
		} 
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			throw new BibleException( e.getMessage() );
		}
	}
}