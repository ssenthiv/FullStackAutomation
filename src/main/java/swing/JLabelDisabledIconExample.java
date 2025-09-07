package swing;

	/*
	        JLabel Disabled Icon Example 
	        This java example shows how to get and set icon when JLabel is disabled using 
	        setDisabled and getDisabled methods of Java Swing JLabel class.
	*/
	 
	 
	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="JLabelDisabledIconExample" width=200 height=200>
	</applet>
	*/
	public class JLabelDisabledIconExample extends JApplet{
	        
	        public void init(){
	                
	                /*
	                 * To create JLabel use 
	                 * JLabel (String caption) constructor
	                 * of JLabel class.
	                 */
	                
	                JLabel label1 = new JLabel("JLabel Disabled Icon Example.");
	                        
	                //add label to applet
	                add(label1);
	 
	                /*
	                 * To set icon when particular JLabel is disabled use,
	                 * void setDisabledIcon(Icon icon)
	                 * method.
	                 */
	                label1.setDisabledIcon(new ImageIcon("E:\\Installables\\eclipse\\Workspace\\images\\watch40x43.gif"));
	                
	                /*
	                 * To get Icon which is displayed when JLabel is disabled use,
	                 * Icon getDisabledIcon()
	                 * method of JLabel class.
	                 */
	                
	                Icon icon = label1.getDisabledIcon();
	              //  label1.disable();
	        }
	}
