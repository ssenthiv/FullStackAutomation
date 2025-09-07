package swing;

	/*
	        Create JLabel With Image Icon and Text Example 
	        This java example shows how to create a label with image icon 
	        and text using Java Swing JLabel class.
	*/
	 
	 
	import javax.swing.ImageIcon;
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="JLabelWithIconTextExample" width=200 height=200>
	</applet>
	*/
	 
	public class JLabelWithIconTextExample extends JApplet{
	        
	        public void init(){
	                
	                /*
	                 * Create an icon from an image using 
	                 * ImageIcon(String imagePath, String description)
	                 * constructor.
	                 */
	                
	                ImageIcon icon1 = new ImageIcon("E:\\Installables\\eclipse\\Workspace\\images\\watch40x43.gif");
	           //     ImageIcon icon2 = new ImageIcon("E:\\Personal\\photos\\own_collection\\Docs_header.gif");
	                
	                /*
	                 * To create a JLabel with image icon and text use,
	                 * JLabel(String text, Icon icon, int horizontalAlignment)
	                 * constructor of JLabel class. 
	                 */
	                
	                JLabel copyLabel1 = new JLabel("Watch", icon1, JLabel.CENTER);
	               // JLabel copyLabel2 = new JLabel("Shunmugasundaram", icon2, JLabel.RIGHT);
	                
	                /*
	                 * Add label to an applet
	                 */
	                
	                add(copyLabel1);
	                //add(copyLabel2);
	                
	                
	                
	        }
	}

