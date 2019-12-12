package intro.javase.tutorials;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Desc:
 * 
 * <pre>
 * 
 * The term network programming refers to writing programs that execute across
 * multiple devices (computers), in which the devices are all connected to each
 * other using a network.
 * 
 * The java.net package of the J2SE APIs contains a collection of classes and
 * interfaces that provide the low-level communication details, allowing you to
 * write programs that focus on solving the problem at hand.
 * 
 * The java.net package provides support for the two common network protocols −
 * 
 * TCP − TCP stands for Transmission Control Protocol, which allows for reliable
 * communication between two applications. TCP is typically used over the
 * Internet Protocol, which is referred to as TCP/IP.
 * 
 * 
 * UDP − UDP stands for User Datagram Protocol, a connection-less protocol that
 * allows for packets of data to be transmitted between applications.
 * 
 * 
 * This chapter gives a good understanding on the following two subjects −
 * 
 * Socket Programming − This is the most widely used concept in Networking and
 * it has been explained in very detail.
 * 
 * 
 * URL Processing − This would be covered separately. Click here to learn about
 * URL Processing in Java language.
 * 
 * 
 * Socket Programming
 * 
 * Sockets provide the communication mechanism between two computers using TCP.
 * A client program creates a socket on its end of the communication and
 * attempts to connect that socket to a server.
 * 
 * When the connection is made, the server creates a socket object on its end of
 * the communication. The client and the server can now communicate by writing
 * to and reading from the socket.
 * 
 * The java.net.Socket class represents a socket, and the java.net.ServerSocket
 * class provides a mechanism for the server program to listen for clients and
 * establish connections with them.
 * 
 * The following steps occur when establishing a TCP connection between two
 * computers using sockets −
 * 
 * The server instantiates a ServerSocket object, denoting which port number
 * communication is to occur on.
 * 
 * 
 * The server invokes the accept() method of the ServerSocket class. This method
 * waits until a client connects to the server on the given port.
 * 
 * 
 * After the server is waiting, a client instantiates a Socket object,
 * specifying the server name and the port number to connect to.
 * 
 * 
 * The constructor of the Socket class attempts to connect the client to the
 * specified server and the port number. If communication is established, the
 * client now has a Socket object capable of communicating with the server.
 * 
 * 
 * On the server side, the accept() method returns a reference to a new socket
 * on the server that is connected to the client's socket.
 * 
 * 
 * After the connections are established, communication can occur using I/O
 * streams. Each socket has both an OutputStream and an InputStream. The
 * client's OutputStream is connected to the server's InputStream, and the
 * client's InputStream is connected to the server's OutputStream.
 * 
 * TCP is a two-way communication protocol, hence data can be sent across both
 * streams at the same time. Following are the useful classes providing complete
 * set of methods to implement sockets.
 * 
 * ServerSocket Class Methods
 * 
 * The java.net.ServerSocket class is used by server applications to obtain a
 * port and listen for client requests.
 * 
 * The ServerSocket class has four constructors −
 * 
 * 
 * </pre>
 * 
 * *
 */

public class JavaNetworking {
    //GreetingClient and Server

}

