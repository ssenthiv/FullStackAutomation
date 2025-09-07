package swing;

	/*
	        Get Horizontal Alignment of JLabel Example 
	        This java example shows how to get horizontal alignment of label's content using 
	        Java Swing JLabel class.
	*/
	 
	 
	import javax.swing.JApplet;
	import javax.swing.JLabel;
	 
	/*
	<applet code="GetHorizontalAlignmenntExample" width=200 height=200>
	</applet>
	*/
	 
	public class GetHorizontalAlignmentExample extends JApplet{
	        
	        public void init(){
                
	                /*
	                 * To create JLabel use 
	                 * JLabel(String caption) constructor
	                 * of JLabel class.
	                 */
	                
	                JLabel label1 = new JLabel("JLabel Get Horizontal Alignment Example.");
	                
	                //add label to applet
	                add(label1);
	                
	                
	                /*
	                 * To get horizontal alignment of label's content use,
	                 * int getHorizontalAlignment()
	                 * method of JLabel's class.
	                 * 
	                 *
	                 * Return value is one of the following constants,
	                 * LEFT, CENTER, RIGHT, LEADING or TRAILING.
	                 * 
	                 */
	                
	                int alignment = label1.getHorizontalAlignment();
	                System.out.println(alignment);
//	                alignment = label1.getVerticalAlignment();
//	                System.out.println(alignment);
	                 
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
	                
	        }
	}
