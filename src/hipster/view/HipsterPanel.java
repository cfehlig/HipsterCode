package hipster.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import hipster.controller.HipsterController;
import hipster.model.Book;

public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;
	
	
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		bookPageCountLabel = new JLabel ("The page count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The Title");
		changeBookButton = new JButton("Change books");
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		
		
		
		phraseComboBox = new JComboBox<String>();
		
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.yellow);
		this.add(phraseComboBox);
		this.add(bookAuthorLabel);
		this.add(bookPageCountLabel);
		this.add(bookTitleLabel);
		this.add(bookPriceLabel);
		this.add(bookSubjectLabel);
		this.add(changeBookButton);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, bookPageCountLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookAuthorLabel, -22, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPriceLabel, 6, SpringLayout.SOUTH, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookPriceLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPageCountLabel, 6, SpringLayout.SOUTH, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookSubjectLabel, 4, SpringLayout.SOUTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookSubjectLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookAuthorLabel, 6, SpringLayout.SOUTH, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookTitleLabel, -135, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, bookTitleLabel, -24, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, changeBookButton, -12, SpringLayout.NORTH, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.EAST, changeBookButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 10, SpringLayout.WEST, this);
		
	}
	
	private void changeColor()
	{
		int red = (int) (Math.random()* 256);
		int green = (int) (Math.random()* 256);
		int blue = (int) (Math.random()* 256);
		setBackground(new Color(red, green, blue));
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random( ) * 256);
				setBackground(new Color(red, green, blue));
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
		});
		
		
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if(startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book subject:" + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book Author: " + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book Title: " + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Book Pages " + tempBooks[startClick].getPageCount());
					bookPriceLabel.setText("Book Price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
			}
				
		});
	}

}
