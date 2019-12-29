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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import jpcap.JpcapCaptor;
import jpcap.packet.DatalinkPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;
/**
 * 完成功能——抓包分析MAC、IP、TCP（UDP）协议
 * 负责人——@组长石其帅41709050303
 * 类后期合并修改——@组长石其帅
 * */
public class AllAnalyzer extends WinForm{
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

	AllAnalyzer(){
		bind.printDevices();
	}
	
	//分析
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
			if(packet instanceof IPPacket && ((IPPacket)packet).version == 4) {	
				//包的数据
				byte[] data = packet.data;
				textArea.append("\n捕获数据包的数据(包括头)\n");
				for (int j = 0; j < data.length; j++) {
					textArea.append(Integer.toHexString(data[j] & 0xFF) + " ");
					if ((j+1)%16 == 0) {
						textArea.append("\n");
					}
				}
				textArea.append("\n描述数据包: " + packet.toString());
				textArea.append("\n数据包的长度： " + packet.len);
				textArea.append("\n时间戳(微妙)： " + packet.usec);
				
				
				//MAC分析
				textArea.append("\n\t---------MAC分析------------\n");
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
				
				
				
				//IP分析
				textArea.append("\n\t----------IP分析-------------\n");
				IPPacket ip = (IPPacket) packet;
				textArea.append("IP描述:\n"+ ip.toString());	
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
				textArea.append("IP首部信息");
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
				
				
				
				//TCP分析
				if (packet instanceof TCPPacket) {
					TCPPacket tcp = (TCPPacket) packet; //强转
					textArea.append("\n\t--------TCP分析----------\n");
					textArea.append("TCP描述:\n" + tcp.toString());			
					//打印TCP首部信息
					textArea.append("\n源端口:  " + tcp.src_port);
					textArea.append("\n目的端口: " + tcp.dst_port);
					textArea.append("\n序号: " + tcp.sequence);
					textArea.append("\n确认号: " + tcp.ack_num);
					textArea.append("\nURG: " + tcp.urg);
					textArea.append("\nACK: " + tcp.ack);
					textArea.append("\nPSH: " + tcp.psh);
					textArea.append("\nRST: " + tcp.rst);
					textArea.append("\nSYN: " + tcp.syn);
					textArea.append("\nFIN: " + tcp.fin);
					textArea.append("\n窗口: " + tcp.window);
					textArea.append("\n紧急指针: " + tcp.urgent_pointer);
					//TCP选项
					byte[] option = tcp.option;
					if (option != null) {
						for (int j = 0; j < option.length; j++) {
							textArea.append(Integer.toHexString(option[j] & 0xFF) + " ");
							if ((j+1)%16 == 0) {
								textArea.append("\n");
							}
						}
					}
				}else {
					//UDP分析
					UDPPacket udp = (UDPPacket) packet; //强转
					textArea.append("\n\t-------UDP分析----------\n");
					textArea.append("UDP描述:\n" + udp.toString());					
					//打印UDP首部信息
					textArea.append("\n源端口:  " + udp.src_port);
					textArea.append("\n目的端口: " + udp.dst_port);
					textArea.append("\n长度: " + udp.length);
					}			
			}else {
				textArea.append("\n很遗憾，没有抓到符合的包！\n");
			}
		}		
	}
	
	@Override
	//界面面板
	public void winForm(JFrame supJf) {
		jf = new JFrame("抓包与分析");
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
				new AllAnalyzer().analyze(supJf);
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
