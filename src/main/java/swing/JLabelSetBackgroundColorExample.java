package swing;

	/*
	        Set Background Color of JLabel Example 
	        This java example shows how to set background color of JLabel using 
	        Java Swing JLabel class.
	*/
	 
	 
	import java.awt.Color;
	 
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="JLabelSetBackgroundColorExample" width=200 height=200>
	</applet>
	*/
	 
	public class JLabelSetBackgroundColorExample extends JApplet{
	        
	        public void init(){
	                
	                /*
	                 * To create JLabel use 
	                 * JLabel (String caption) constructor
	                 * of JLabel class.
	                 */
	                
	                JLabel label1 = new JLabel("JLabel Set Background Color Example.");
	                        
	                //this will create light blue color
	                Color customColor = new Color(10,10,100);
	                
	                /*
	                 * NOTE: By default JLabel is set to transparent mode. Calling setBackground
	                 * directly will not set the background color of JLabel.
	                 * 
	                 * In order to make the label set opaque, you need to call 
	                 * void setOpaque(boolean opaque)
	                 * method.
	                 */
	                
	                label1.setOpaque(true);
	                
	                /*
	                 * To set background color of JLabel text use,
	                 * void setBackground(Color color) 
	                 * method.
	                 */
	                
	                label1.setBackground(customColor);
	                
	                //add label to applet
	                add(label1);
	        }
	}
