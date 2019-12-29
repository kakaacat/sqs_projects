package sqs_computerNetwork_protocolAnalyze;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
/**
 * 绑定网络设备
 * */
public class BindNetDevice {
	
	private NetworkInterface[] devices = JpcapCaptor.getDeviceList();
	protected int selDevice = 2;
	private JpcapCaptor jpcap;
	String[] deviceDescribe = new String[devices.length+1];
	
	//描述网络设备列表
	protected void printDevices() {
		for (int i = 0; i < devices.length; i++) {
			deviceDescribe[i] = devices[i].name + "\t" +"|   " + devices[i].description;
		}
		deviceDescribe[devices.length] = "-------------------------------------------------------------";
	}
	//选择网络设备
	public void setSelDevice(int selDevice) {
		this.selDevice = selDevice;
	}
	public String outpuDev() {
		return devices[selDevice].name + "\t" +"|   " + devices[selDevice].description;
	}
	//设置网络设备
	public JpcapCaptor selectDevice() {
		try {
			jpcap = JpcapCaptor.openDevice(devices[selDevice],65535, false, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jpcap;
	}
	
}
