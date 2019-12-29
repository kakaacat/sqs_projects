package sqs_computerNetwork_protocolAnalyze;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import jpcap.JpcapCaptor;
import jpcap.packet.DatalinkPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
/**
 * 完成功能——抓包分析TCP协议
 * 负责人——@组员桑庆41709050305
 * 类后期合并修改——@组员桑庆、@组长石其帅
 * */
public class MACAnalyzer extends WinForm{
//	private BindNetDevice bind = new BindNetDevice();
	private JpcapCaptor jpcap;
	
	private JFrame jf;
	private JTextArea textArea;
	JMenuBar jMenuBar = new JMenuBar();
	JMenu backToHome = new JMenu(" 返 回 主 菜 单 ");
	JMenu again = new JMenu(" 重 新 抓 取 分 析  ");
	JMenu save = new JMenu(" 保 存  ");
	JMenu openFile = new JMenu(" 打 开 文 件 ");
	int fFlag = 1;
	
	MACAnalyzer(){
		bind.printDevices();

	}
	
	public void analyze(JFrame supJf) {
		this.winForm(supJf);
		
		textArea.append("设备列表：" + "\n");
		for (int i = 0; i < bind.deviceDescribe.length; i++) {
			textArea.append(bind.deviceDescribe[i] + "\n");
		}
		textArea.append("当前选择的网络设备：\n" + bind.outpuDev());
		textArea.append("\n---------------------------------\n");
		textArea.append("\n正在尝试10次抓包......\n");
		jpcap = bind.selectDevice();
		for (int i = 0; i < 10; i++) {
	
			Packet packet = jpcap.getPacket(); //抓包
			textArea.append("\n第 " + (i+1) +" 次尝试抓包......\n" );
			if(packet instanceof IPPacket) {
				DatalinkPacket datalinkPacket = packet.datalink; //获取数据链路层头部
				EthernetPacket mac = (EthernetPacket) datalinkPacket; //强转
				textArea.append("MAC描述:\n" + mac.toString());	
				//打印MAC目的地址
				byte[] dstMac = mac.dst_mac;
				textArea.append("\nMAC目的地址: \n");
				for (int j = 0; j < dstMac.length; j++) {
					textArea.append(Integer.toBinaryString(dstMac[j]));
				}
				//打印MAC源地址
				byte[] srcMac = mac.src_mac;
				textArea.append("\nMAC源地址: \n");
				for (int j = 0; j < srcMac.length; j++) {
					textArea.append(Integer.toBinaryString(srcMac[j]));
				}
				//打印MAC首部信息
				textArea.append("\n源地址:  " + mac.getSourceAddress());
				textArea.append("\n目的地址: " + mac.getDestinationAddress());
				textArea.append("\n帧类型: " + mac.frametype);				
				textArea.append("\n-----------------------------------------------------------------\n");
			}else {
				textArea.append("\n很遗憾，第 " + (i+1) + " 次尝试，没有抓到符合的包！\n");
			}
		}
	}
	
	@Override
	//界面面板
	public void winForm(JFrame supJf) {
		jf = new JFrame("MAC抓包与分析");
		jf.setSize(1000, 1000);
		jf.setLocationRelativeTo(null);
		textArea = new JTextArea(900,1000);
		textArea.setEditable(false);//不可编辑
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		//滚动面板
		JScrollPane scrollPane = new JScrollPane(
				textArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, //垂直滚动条一直显示
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED //水平滚动条
				);
		
		
		jMenuBar.add(again);
		again.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				new MACAnalyzer().analyze(supJf);
			}
		});
		
		jMenuBar.add(save);
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String finfo = textArea.getText(); //文本内容
				String fName = jf.getTitle();	//文本名
				

				File file = new File(fName + ".txt");
				if (file.exists()) {
					fName = fName + (fFlag++);
					file = new File(fName + ".txt");
				}
				PrintWriter output;//创建文件
				try {
					output = new PrintWriter(file);
					output.print(finfo);
					output.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(
						jf,
						"保存成功",
						"文件保存", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		jMenuBar.add(openFile);
		openFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().open(new File("D:\\Eclipse\\eclipse\\projects\\ProtocolAnalyze"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		jMenuBar.add(backToHome);
		backToHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				supJf.setVisible(true);
			}
		});
		jf.setJMenuBar(jMenuBar);
		jf.setContentPane(scrollPane);
		jf.setVisible(true);		
	}
}
