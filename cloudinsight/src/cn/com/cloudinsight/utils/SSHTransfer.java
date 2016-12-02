package cn.com.cloudinsight.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SSHTransfer {
	
	private String hostname ;
	private String username ;
	private String password ;
	private int port;
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public SSHTransfer(String hostname, String username, String password, int port) {
		super();
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	public boolean sshCon()
	{
		try
		{
			String[] fileList={"/root/.ssh/authorized_keys","/root/.ssh/id_rsa","/root/.ssh/id_rsa.pub","/root/.ssh/known_hosts"};
			Connection conn = new Connection(hostname,port);
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username, password);
			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");
			Session sess = conn.openSession();
			sess.execCommand("mkdir /root/.ssh;chmod 700 /root/.ssh;uname -a && date && uptime && who"); 
		//	System.out.println("Here is some information about the remote host:");
			InputStream stdout = new StreamGobbler(sess.getStdout());
			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
			while (true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
		//	System.out.println("ExitCode: " + sess.getExitStatus());
			sess.close();
			SCPClient scpClient = conn.createSCPClient();
			scpClient.put(fileList, "/root/.ssh");
			conn.close();
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			return false;
			//System.exit(2);
		}
	}
//	public static void main(String args[])
//	{
//		SSHTransfer ssh = new SSHTransfer("202.100.171.76","root","centos#0515;",10027);
//		ssh.sshCon();		
//	}

}
