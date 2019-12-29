package sqs_computerNetwork_protocolAnalyze;

import javax.swing.JFrame;
/**
 * 主函数
 * 负责人——@组长石其帅
 * */
public class MText {

	public static void main(String[] args) {
		JFrame jf = new JFrame("协议分析软件");
		jf.setSize(360, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false); //大小不可变

		Buttons starts = new Buttons(jf);
		
		jf.setVisible(true);
		
	}

}
