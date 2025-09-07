package swing;

	/*
	        Set Vertical Alignment of JLabel Example 
	        This java example shows how to set and get vertical alignment of label's content using 
	        Java Swing JLabel class.
	*/
	 
	 
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="JLabelVerticalAlignmentExample" width=200 height=200>
	</applet>
	*/
	 
	public class JLabelVerticalAlignmentExample extends JApplet{
	 
	        public void init(){
	                
	                /*
	                 * To create JLabel use 
	                 * JLabel (String caption) constructor
	                 * of JLabel class.
	                 */
	                
	                JLabel label1 = new JLabel("JLabel Get Horizontal Alignment Example.");
	                
	                //add label to applet
	                add(label1);
	                
	                
	                /*
	                 * To get vertical alignment of label's content use,
	                 * int getVerticalAlignment()
	                 * method of JLabel's class.
	                 * 
	                 *
	                 * Return value is one of the following constants,
	                 * LEFT, CENTER, RIGHT, LEADING or TRAILING.
	                 * 
	                 */
	                
	                int alignment = label1.getVerticalAlignment();
	                
	                switch(alignment){
	                
	                        case JLabel.LEFT:
	                                label1.setText("Left");
	                                break;
	                        case JLabel.CENTER:
	                                label1.setText("Center");
	                                break;
	                        case JLabel.RIGHT:
	                                label1.setText("Right");
	                                break;
	                        case JLabel.LEADING:
	                                label1.setText("Leading");
	                                break;
	                        case JLabel.TRAILING:
	                                label1.setText("Trailing");
	                                break;
	                        
	                }
	                
	                /*
	                 * To set vertical alignment of JLabel use,
	                 * void setVerticalAlignment(int alignment)
	                 * method
	                 */
	                
	                label1.setVerticalAlignment(JLabel.CENTER);
	        }
	}

