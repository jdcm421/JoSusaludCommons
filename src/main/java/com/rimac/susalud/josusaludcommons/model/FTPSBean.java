package com.rimac.susalud.josusaludcommons.model;

import java.io.Serializable;

public class FTPSBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String server;
    private String port;
    private String username;
    private String password;
    private String local;
    private String remote;
    private String localPath;
    private String remotePath;
    private String workinMode;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getWorkinMode() {
        return workinMode;
    }

    public void setWorkinMode(String workinMode) {
        this.workinMode = workinMode;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
