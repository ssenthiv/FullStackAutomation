package swing;

	/*
	        Set JLabel Border Example 
	        This java example shows how to create a border for JLabel using 
	        Java Swing JLabel class.
	*/
	 
	 
	import java.awt.Color;
	import javax.swing.BorderFactory;
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	import javax.swing.border.Border;
	 
	/*
	<applet code="JLabelSetBorderExample" width=200 height=200>
	</applet>
	*/
	 
	 
	 
	public class JLabelSetBorderExample extends JApplet{
	 
	        public void init(){
	                
	                /*
	                 * To create JLabel use 
	                 * JLabel (String caption) constructor
	                 * of JLabel class.
	                 */
	                
	                JLabel label1 = new JLabel("JLabel Create Border Example.");
	                        
	                //add label to applet
	                add(label1);
	                
	                /*
	                 * Create new custom border for JLabel
	                 */
	                Border border = BorderFactory.createLineBorder(Color.blue);
	                
	                /*
	                 * To set JLabel's border use,
	                 * void setBorder(Border b)
	                 * method.
	                 */
	                
	                label1.setBorder(border);
	        }
	}
