package hipster.view;

import java.swing.JFrame;
import hipster.Controller.hipsterController;
import javax.swing.JOptionPane;

public class HipsterFrame extends JFrame
{
	private HipsterController baseController;
	private HipsterPanel basePanel;
	
	public HipsteerFrame(HipsterController baseController)
	this.baseController = baseController;
	basePanel = new HipsterPanel(baseController);
	setupFrame();
	}
	
	public String Response(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public HipsterController getBaseController()
	{
		return baseController;

}
