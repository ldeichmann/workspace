package com.cru.vsys_04;

public class Settings {
    private boolean listenMode = false;
    private boolean isTCP = true;
    private boolean error = false;
    private String remoteHost = "";
    private int remotePort = 0;
    private int localPort = 0;
    private String source = "";
    
	public String getRemoteHost() {
		return remoteHost;
	}
	
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	
	public int getRemotePort() {
		return remotePort;
	}
	
	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}
	
	public int getLocalPort() {
		return localPort;
	}
	
	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}
	
	public boolean isListenMode() {
		return listenMode;
	}
	
	public void setListenMode(boolean listenMode) {
		this.listenMode = listenMode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isTCP() {
		return isTCP;
	}

	public void setTCP(boolean isTCP) {
		this.isTCP = isTCP;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
