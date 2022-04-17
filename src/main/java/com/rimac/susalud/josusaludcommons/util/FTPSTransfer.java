package com.rimac.susalud.josusaludcommons.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rimac.susalud.josusaludcommons.model.FTPSBean;

public class FTPSTransfer {

    private String server;
    private String username;
    private String password;
    private String remote;
    private String local;
    private String port;

    static Logger logger = LoggerFactory.getLogger(FTPSTransfer.class);

    @SuppressWarnings("unused")
    public void transferirArchivo(FTPSBean ftpsbean) throws NoSuchAlgorithmException {

        String protocol = "TLS";    // TLS
        boolean storeFile = false, binaryTransfer = false, error = false;

        server = ftpsbean.getServer();
        username = ftpsbean.getUsername();
        password = ftpsbean.getPassword();
        remote = ftpsbean.getRemote();
        local = ftpsbean.getLocal();
        port = ftpsbean.getPort();

        FTPSClient ftpsClient;

        if (ftpsbean.getWorkinMode().equals("-s")) {
            storeFile = true;
        } else if (ftpsbean.getWorkinMode().equals("-b")) {
            binaryTransfer = true;
        }
        ftpsClient = new FTPSClient(protocol);
        ftpsClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

        try {
            int reply;

            ftpsClient.connect(server, Integer.parseInt(port));
            logger.info("Connected to " + server + ".");

            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftpsClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpsClient.disconnect();
                logger.error("FTP server refused connection.");
            }
        } catch (IOException e) {
            if (ftpsClient.isConnected()) {
                try {
                    ftpsClient.disconnect();
                } catch (IOException f) {
                    logger.error(f.getMessage());
                    f.printStackTrace();
                }
            }
            logger.error("Could not connect to server.");
            logger.error("Error", e);
            e.printStackTrace();
        }

        __main:
        try {
            ftpsClient.setBufferSize(1000);

            if (!ftpsClient.login(username, password)) {
                ftpsClient.logout();
                error = true;
                break __main;
            }

            ftpsClient.execPBSZ(0);
            ftpsClient.execPROT(Constan.DATA_CHANNEL_PROTECTION_PRIVATE);

            if (binaryTransfer) {
                ftpsClient.setFileType(FTP.BINARY_FILE_TYPE);
            }

            // Use passive mode as default because most of us are
            // behind firewalls these days.
            ftpsClient.enterLocalPassiveMode();
            ftpsClient.cwd(ftpsbean.getRemotePath());
            if (storeFile) {
                InputStream input;
                input = new FileInputStream(local);
                ftpsClient.storeFile(remote, input);
                input.close();
            } else {
                OutputStream output;
                output = new FileOutputStream(local);
                ftpsClient.retrieveFile(remote, output);
                output.close();
            }

            ftpsClient.logout();
        } catch (FTPConnectionClosedException e) {
            error = true;
            logger.error("Server closed connection.");
            logger.error("Error server closed ", e);
            e.printStackTrace();
        } catch (IOException e) {
            error = true;
            logger.error("Error ", e);
            e.printStackTrace();
        } finally {
            if (ftpsClient.isConnected()) {
                try {
                    ftpsClient.disconnect();
                } catch (IOException f) {
                    logger.error("Error ", f);
                    f.printStackTrace();
                }
            }
        }
    } // end main*/		
}
