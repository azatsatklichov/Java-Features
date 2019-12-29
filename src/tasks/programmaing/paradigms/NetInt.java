package tasks.programmaing.paradigms;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class NetInt {
	public static void main(String args[]) throws SocketException {
		Enumeration<NetworkInterface> netis = NetworkInterface.getNetworkInterfaces();
		while (netis.hasMoreElements()) {
			NetworkInterface nis = netis.nextElement();
			System.out.println("Network Interface name is :" + nis.getName());
			System.out.println("Display name of network interface is :" + nis.getDisplayName());
			System.out.println("Network Interface is up and running :" + nis.isUp());
			System.out.println("Network Interface is loopback :" + nis.isLoopback());
			System.out.println("Network Interface is point to point interface :" + nis.isPointToPoint());
			System.out.println("Network Interface support multicasting :" + nis.supportsMulticast());
			System.out.println("Network Interface MTU value is :" + nis.getMTU());
			System.out.println("Network Interface is virtual interface :" + nis.isVirtual());
			System.out.println("Network Interface has any Paren :" + nis.getParent());
			byte[] haddress = nis.getHardwareAddress();

			if (haddress != null) {
				System.out.print("  ============ Hardware address == ");
				for (int i = 0; i < haddress.length; i++)
					System.out.printf("%02X%c", haddress[i], (i != haddress.length - 1) ? '-' : '\0');
				System.out.println();
			}

			List<InterfaceAddress> iaddress = nis.getInterfaceAddresses();
			Iterator<InterfaceAddress> iiaddress = iaddress.iterator();
			while (iiaddress.hasNext()) {
				InterfaceAddress iadd = iiaddress.next();
				System.out.println("Interface Address   -");
				System.out.println("InetAddress of the Interface Address :" + iadd.getAddress());
				System.out.println("Broadcast Addres of the Interface Address :" + iadd.getBroadcast());
				System.out.println("Network Prefix Length of the Interface Address :" + iadd.getNetworkPrefixLength());
			}

			System.out.println("\n");
		}

	}

}
