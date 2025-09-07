package swing;

	/*
	        Change Font of JTextField Example 
	        This java example shows how to change font of JTextField's text
	        using Java Swing JTextField class.
	*/
	 
	 
	import java.awt.FlowLayout;
	import java.awt.Font;
	import javax.swing.JApplet;
	import javax.swing.JTextField;
	 
	/*
	<applet code="JTextFieldFontExample" width=200 height=200>
	</applet>
	*/
	 
	public class JTextFieldFontExample extends JApplet{
	        
	        public void init(){
	                
	                //set flow layout for the applet
	                this.getContentPane().setLayout(new FlowLayout());
	                
	                //create new JTextField
	                JTextField field = new JTextField("JTextField Change Font Example",30);
	                JTextField field2 = new JTextField("JTextField Change Font Example",30);
	                
	                /*
	                 * To set custom font for JTextField use,
	                 * void setFont(Font font)
	                 * method.
	                 */
	                
	                //create new Font
	                Font font = new Font("Courier", Font.BOLD,12);
	                
	                //set font for JTextField
	                field.setFont(font);
	 
	                add(field);
	                add(field2);
	        }
	}
