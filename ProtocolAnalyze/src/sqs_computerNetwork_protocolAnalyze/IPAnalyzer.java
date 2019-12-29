package sqs_computerNetwork_protocolAnalyze;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import jpcap.JpcapCaptor;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
/**
 * 完成功能——抓包分析IP协议
 * 负责人——@组长石其帅41709050303
 * 类后期合并修改——@组长石其帅
 * */
public class IPAnalyzer extends WinForm{
	private JpcapCaptor jpcap;

	
	private JFrame jf;
	private JTextArea textArea;
	JMenuBar jMenuBar = new JMenuBar();
	JMenu backToHome = new JMenu(" 返 回 主 菜 单 ");
	JMenu again = new JMenu(" 重 新 抓 取 分 析  ");
	JMenu save = new JMenu(" 保 存  ");
	JMenu openFile = new JMenu(" 打 开 文 件 ");
	int fFlag = 1;
	
	IPAnalyzer(){
		super.bind.printDevices();
	}
		
	//分析
	public void analyze(JFrame supJf) {
		this.winForm(supJf);
	
		textArea.append("设备列表：" + "\n");
		for (int i = 0; i < bind.deviceDescribe.length; i++) {
			textArea.append(bind.deviceDescribe[i] + "\n");;
		}
		textArea.append("当前选择的网络设备：\n" + bind.outpuDev());
		textArea.append("\n---------------------------------\n");
		textArea.append("\n正在10次尝试抓包......\n");
		jpcap = bind.selectDevice();
		for (int i = 0,k = 0; i < 10 && k < 100; i++,k++) {

			Packet packet = jpcap.getPacket(); //抓包
			textArea.append("\n第 " + (i+1) +" 次尝试抓包......\n" );
			if(packet instanceof IPPacket && ((IPPacket)packet).version == 4) {
				//k = 100;
				IPPacket ip = (IPPacket) packet;
				textArea.append("IP描述:\n"+ ip.toString());	
				textArea.append("\nIP数据报长度: " + Short.toString(ip.length));
				//打印IP首部
				textArea.append("\nIP首部：\n");
				byte[] ipHead = ip.header;
				for (int j = 0; j < ipHead.length; j++) {
					textArea.append(Integer.toHexString(ipHead[j] & 0xFF) + " ");
					if ((j+1)%16 == 0) {
						textArea.append("\n");
					}	
				}
				//打印IP数据部分
				textArea.append("\nIP数据部分：\n");
				byte[] ipData = ip.data;
				for (int j = 0; j < ipData.length; j++) {
					textArea.append(Integer.toHexString(ipData[j] & 0xFF) + " ");
					if ((j+1)%16 == 0) {
						textArea.append("\n");
					}
				}
				//打印IP首部信息
				textArea.append("\nIP首部信息");
				textArea.append("\n版本: IPv4 ");
				textArea.append("\n优先权: " + ip.priority);
				textArea.append("\n区分服务(最大的吞吐量): " + ip.t_flag );
				textArea.append("\n区分服务(最高的可靠性): " + ip.r_flag );
				textArea.append("\n总长度: " + ip.length );
				textArea.append("\n标识: " + ip.ident );
				textArea.append("\nMF(还有分片): " + ip.more_frag);
				textArea.append("\nDF(没有分片): " + ip.dont_frag);
				textArea.append("\n片偏移: " + ip.offset);
				textArea.append("\n生存时间: " + ip.hop_limit);
				
				String protocol = "";
				switch (new Integer(ip.protocol)) {
				case 1: protocol = "ICMP";break;
				case 2: protocol = "IGMP";break;
				case 6: protocol = "TCP";break;
				case 8: protocol = "EGP";break;
				case 9: protocol = "IGP";break;
				case 17:protocol = "UDP";break;
				case 41:protocol = "IPv6";break;
				case 89:protocol = "OSPF";break;
				default:break;
				}
				
				textArea.append("\n协议: " + protocol);
				textArea.append("\n源IP: " + ip.src_ip.getHostAddress());
				textArea.append("\n目的IP: " + ip.dst_ip.getHostAddress());
				textArea.append("\n-----------------------------------------------------------------\n");
			}else {
				textArea.append("\n很遗憾，第 " + (i+1) + " 次尝试，没有抓到符合的包！\n");
			}
				
//			}else if(k < 100){
//				--i;
//			}if (k == 99) {
//				textArea.append("\n抓包失败!\n请检查网络设备选择！\n");
//			}
			
		}
	}
	
	@Override
	//界面面板
	public void winForm(JFrame supJf) {
		jf = new JFrame("IP抓包与分析");
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
				IPAnalyzer ip = new IPAnalyzer();
				ip.analyze(supJf);
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
