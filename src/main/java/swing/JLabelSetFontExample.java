package swing;

	/*
	        JLabel Set Font Example 
	        This java example shows how to set custom font for JLabel using 
	        Java Swing JLabel class.
	*/
	 
	 
	import java.awt.Font;
	 
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="JLabelSetFontExample" width=200 height=200>
	</applet>
	*/
	 
	public class JLabelSetFontExample extends JApplet{
	 
	        public void init(){
	                
	                /*
	                 * To create JLabel use 
	                 * JLabel (String caption) constructor
	                 * of JLabel class.
	                 */
	                
	                JLabel label1 = new JLabel("JLabel Set Font Example.");
	                        
	                /*
	                 * To set custom font for JLabel use,
	                 * void setFont(Font font)
	                 * method.
	                 */
	                
                 //create new Font
	                Font font = new Font("Courier", Font.BOLD,16);
	                
	                //set font for JLabel
	                label1.setFont(font);
	                
	                //add label to applet
	                add(label1);
	        }
	}


