import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FxPractice{
	public static void main(String[] args) {
		 FxPractice  fx = new FxPractice();
		 fx.initUI();
	}
	public void initUI() {
		
		JFrame frame = new JFrame();
		
		frame.setTitle("µÇÂ½Æ÷");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,10,10);
		frame.setLayout(flowLayout);
		
		JLabel l_name = new JLabel("ÕËºÅ£º");
		frame.add(l_name);
		
		JTextField t_name = new JTextField();
		Dimension dimension = new Dimension(300,30);
		t_name.setPreferredSize(dimension);
		frame.add(t_name);
		
		JLabel l_password = new JLabel("ÃÜÂë£º");
		frame.add(l_password);
		
		JPasswordField t_password = new JPasswordField();
		t_password.setPreferredSize(dimension);
		frame.add(t_password);
		
		JButton button = new JButton();
		Dimension dimension2 = new Dimension(100,30);
		button.setPreferredSize(dimension2);
		button.setText("µÇÂ½");
		
		button.setSize(dimension2);
		frame.add(button);
		
		frame.setVisible(true);
	}
}
