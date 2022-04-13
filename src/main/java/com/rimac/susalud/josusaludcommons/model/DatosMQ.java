package com.rimac.susalud.josusaludcommons.model;

public class DatosMQ {

	private String queueManager;
	private String ipServerQueueManager;
	private String portServerQueueManager;
	private String channelMQ;
	private String queueRequest;
	private String queueResponse;
	private String passwordMQ;
	private String userMQ;
	private String tExperiry;
	private String nRetry;
	private String tWaitinterval;
	private String senderActive;
	private String receiverActive;
	
	public String getQueueManager() {
		return queueManager;
	}
	public void setQueueManager(String queueManager) {
		this.queueManager = queueManager;
	}
	public String getIpServerQueueManager() {
		return ipServerQueueManager;
	}
	public void setIpServerQueueManager(String ipServerQueueManager) {
		this.ipServerQueueManager = ipServerQueueManager;
	}
	public String getPortServerQueueManager() {
		return portServerQueueManager;
	}
	public void setPortServerQueueManager(String portServerQueueManager) {
		this.portServerQueueManager = portServerQueueManager;
	}
	public String getChannelMQ() {
		return channelMQ;
	}
	public void setChannelMQ(String channelMQ) {
		this.channelMQ = channelMQ;
	}
	public String getQueueRequest() {
		return queueRequest;
	}
	public void setQueueRequest(String queueRequest) {
		this.queueRequest = queueRequest;
	}
	public String getQueueResponse() {
		return queueResponse;
	}
	public void setQueueResponse(String queueResponse) {
		this.queueResponse = queueResponse;
	}
	public String getPasswordMQ() {
		return passwordMQ;
	}
	public void setPasswordMQ(String passwordMQ) {
		this.passwordMQ = passwordMQ;
	}
	public String getUserMQ() {
		return userMQ;
	}
	public void setUserMQ(String userMQ) {
		this.userMQ = userMQ;
	}
	public String gettExperiry() {
		return tExperiry;
	}
	public void settExperiry(String tExperiry) {
		this.tExperiry = tExperiry;
	}
	public String getnRetry() {
		return nRetry;
	}
	public void setnRetry(String nRetry) {
		this.nRetry = nRetry;
	}
	public String gettWaitinterval() {
		return tWaitinterval;
	}
	public void settWaitinterval(String tWaitinterval) {
		this.tWaitinterval = tWaitinterval;
	}
	public String getSenderActive() {
		return senderActive;
	}
	public void setSenderActive(String senderActive) {
		this.senderActive = senderActive;
	}
	public String getReceiverActive() {
		return receiverActive;
	}
	public void setReceiverActive(String receiverActive) {
		this.receiverActive = receiverActive;
	}
	
	
}
