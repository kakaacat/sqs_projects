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
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
/**
 * 完成功能——抓包分析ICMP协议
 * 负责人——@组员魏源41709050306
 * 类后期合并修改——@组员魏源、@组长石其帅
 * */
public class ICMPAnalyzer extends WinForm{
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

	ICMPAnalyzer(){
		bind.printDevices();
		
	}
	//分析
	public void analyze(JFrame supJf) {
		this.winForm(supJf);	
		
		
		textArea.append("设备列表：" + "\n");
		for (int i = 0; i < bind.deviceDescribe.length; i++) {
			textArea.append(bind.deviceDescribe[i] + "\n");
		}
		textArea.append("\n正在尝试10次抓包......\n");
		jpcap = bind.selectDevice();
		for (int i = 0; i < 10; i++) {

			Packet packet = jpcap.getPacket(); //抓包
			textArea.append("\n第 " + (i+1) +" 次尝试抓包......\n" );
			if(packet instanceof IPPacket) {
				ICMPPacket icmp = (ICMPPacket) packet;
				textArea.append("ICMP描述:\n" + icmp.toString());	
				System.out.println("ICMP描述:\n"+ icmp.toString());
				//打印ICMP报文信息
				textArea.append("\n类型:  " + icmp.type);
				String type = "";
				switch (icmp.type) {
				case 3: type = "终点不可达";break;
				case 11: type = "时间超过";break;
				case 12: type = "参数问题";break;
				case 5: type = "改变路由(重定向)";break;
				case 8:
				case 0: type = "会送请求或回答";break;
				case 13:
				case 14: type = "时间戳请求或回答";break;
				default:break;
				}
				textArea.append(" " + type);		
				textArea.append("\n-----------------------------------------------------------------\n");
			}else {
				textArea.append("\n很遗憾，第 " + (i+1) + " 次尝试，没有抓到符合的包！\n");
			}
		}		

	}
	@Override
	//界面面板类
	public void winForm(JFrame supJf) {
		jf = new JFrame("ICMP抓包与分析");
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
				new ICMPAnalyzer().analyze(supJf);
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
