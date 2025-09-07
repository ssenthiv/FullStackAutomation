package swing;

	/*
	        Create JLabel With Image Icon Example 
	        This java example shows how to create a label with image icon using 
	        Java Swing JLabel class.
	*/
	 
	 
	import javax.swing.ImageIcon;
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="JLabelWithIconExample" width=200 height=200>
	</applet>
	*/
	 
	public class JLabelWithIconExample extends JApplet{
	        
	        public void init(){
	                
	                /*
	                 * Create an icon from an image using 
	                 * ImageIcon(String imagePath, String description)
	                 * constructor.
	                 */
	                
	                ImageIcon icon = new ImageIcon("E:\\Personal\\photos\\own_collection\\shunmugasundaram_senthivelu.jpg");
	                
	                /*
	                 * To create a JLabel with image icon use,
	                 * JLabel(Icon icon)
	                 * constructor of JLabel class. 
	                 */
	                
	                JLabel copyLabel = new JLabel(icon);
	                
	                /*
	                 * Add label to an applet
	                 */
	                
	                add(copyLabel);
	                
	        }
	}
