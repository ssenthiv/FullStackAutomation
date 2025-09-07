package swing;

	/*
	        JLabel Set Tooltop Example
	        This java example shows how to set tooltip text for JLabel using 
	        setToolTipText method of Java Swing JLabel class.
	*/
	 
	 
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="JLabelSetToolTipExample" width=200 height=200>
	</applet>
	*/
	 
	public class JLabelSetToolTipExample extends JApplet{
	        
	        public void init(){
	                
	                /*
	                 * To create JLabel use 
	                 * JLabel (String caption) constructor
	                 * of JLabel class.
	                 */
	                
	                JLabel label1 = new JLabel("JLabel Set Tooltip Example");
	                        
	                //add label to applet
	                add(label1);
	                
	                /*
	                 * To set tooltip for JLabel use,
	                 * void setToolTipText(String tooltip)
	                 * method of JLabel class.
	                 */
	 
	                label1.setToolTipText("Demo Tooltip for JLabel");
	        }
	}

