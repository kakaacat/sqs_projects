package sqs_computerNetwork_protocolAnalyze;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * 界面按钮设置 
 * 其应该响应的操作
 * */
public class Buttons {

		JLabel label2;
		JPanel jp1;
		//协议选择
		JLabel label;
		JPanel jp2;
		String[] list;
		JComboBox<String> jComboBox;
		//开始按钮
		JButton start;
		JPanel jp3;
		//网络设备选择
		JRadioButton wlanButton;
		JRadioButton internetButton;
		ButtonGroup btnGroup;
		JPanel jp4;		
			
		Buttons(JFrame jf){
			label2 = new JLabel(" 欢迎使用协议分析软件  ");
			label2.setFont(new Font("楷体", Font.BOLD, 20));
			jp1 = new JPanel();
			jp1.add(label2);
			
			label = new JLabel("协议选择：");
			list = new String[] {" IP "," TCP "," UDP ","ICMP","MAC","ALL"};
			jComboBox = new JComboBox<String>(list);
			jComboBox.setSelectedIndex(0);	//初始选项
			
			internetButton = new JRadioButton("以太网");
			wlanButton = new JRadioButton("WLAN");
			jp4 = new JPanel();
			btnGroup = new ButtonGroup();
			btnGroup.add(internetButton);
			btnGroup.add(wlanButton);
			wlanButton.setSelected(true);//初始选择wlan			
			jp4.add(internetButton);
			jp4.add(wlanButton);
			
			jp2 = new JPanel();
			jp2.add(label);
			jp2.add(jComboBox);
			
			start = new JButton(" 开始分析  ");
			jp3 = new JPanel();
			jp3.add(start);
			this.startAnalyze(jf);						
			
			Box box = Box.createVerticalBox();
			box.add(jp1);
			box.add(jp4);
			box.add(jp2);
			box.add(jp3);
			
			jf.add(box);
		}
		
		//开始分析
		public void startAnalyze(JFrame jf) {
			start.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					int protocolIndex = jComboBox.getSelectedIndex();
					if (wlanButton.isSelected()) {
						int sel = 2;
						if (protocolIndex == 0) { //分析IP
							WinForm ipAnalyzer = new IPAnalyzer();
							ipAnalyzer.bind.setSelDevice(sel);
							ipAnalyzer.analyze(jf);
						}else if (protocolIndex == 1) { //分析TCP
							WinForm tcpAnalyzer = new TCPAnalyzer();
							tcpAnalyzer.bind.setSelDevice(sel);
							tcpAnalyzer.analyze(jf);
						}else if (protocolIndex == 2) {	//分析UDP
							UDPAnalyzer udpAnalyzer = new UDPAnalyzer();
							udpAnalyzer.bind.setSelDevice(sel);
							udpAnalyzer.analyze(jf);
						}else if (protocolIndex == 3) { //分析ICMP
							ICMPAnalyzer icmpAnalyzer = new ICMPAnalyzer();
							icmpAnalyzer.bind.setSelDevice(sel);
							icmpAnalyzer.analyze(jf);
						}else if (protocolIndex == 4) { //分析MAC
							MACAnalyzer macAnalyzer = new MACAnalyzer();
							macAnalyzer.bind.setSelDevice(sel);
							macAnalyzer.analyze(jf);
						}else if (protocolIndex == 5) { //抓取一个包整体分析
							AllAnalyzer allAnalyzer = new AllAnalyzer();
							allAnalyzer.bind.setSelDevice(sel);
							allAnalyzer.analyze(jf);
						}
					}else if (internetButton.isSelected()) {
						int sel = 0;
						if (protocolIndex == 0) { //分析IP
							WinForm ipAnalyzer = new IPAnalyzer();
							ipAnalyzer.bind.setSelDevice(sel);
							ipAnalyzer.analyze(jf);
						}else if (protocolIndex == 1) { //分析TCP
							WinForm tcpAnalyzer = new TCPAnalyzer();
							tcpAnalyzer.bind.setSelDevice(sel);
							tcpAnalyzer.analyze(jf);
						}else if (protocolIndex == 2) {	//分析UDP
							UDPAnalyzer udpAnalyzer = new UDPAnalyzer();
							udpAnalyzer.bind.setSelDevice(sel);
							udpAnalyzer.analyze(jf);
						}else if (protocolIndex == 3) { //分析ICMP
							ICMPAnalyzer icmpAnalyzer = new ICMPAnalyzer();
							icmpAnalyzer.bind.setSelDevice(sel);
							icmpAnalyzer.analyze(jf);
						}else if (protocolIndex == 4) { //分析MAC
							MACAnalyzer macAnalyzer = new MACAnalyzer();
							macAnalyzer.bind.setSelDevice(sel);
							macAnalyzer.analyze(jf);
						}else if (protocolIndex == 5) { //抓取一个包整体分析
							AllAnalyzer allAnalyzer = new AllAnalyzer();
							allAnalyzer.bind.setSelDevice(sel);
							allAnalyzer.analyze(jf);
						}
					}
				}
			});
		}				
}
