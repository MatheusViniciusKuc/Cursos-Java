package br.com.bsoft.emailjava.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.stereotype.Service;

@Service
public class LeitorDeEmail {

    private final String host = "pop.bsoft.email";

    public List<DataHandler> leitorDeArquivos(String user, String password) throws MessagingException, IOException {
        List<DataHandler> anexos = new ArrayList<>();
        try (Store store = conexao(user, password)) {
            try (Folder folder = store.getFolder("inbox")) {
                folder.open(Folder.READ_WRITE);
                Message msg[] = folder.getMessages();
                for (int i = 0; i < msg.length; i++) {
                    Multipart multipart = (Multipart) msg[i].getContent();
                    for (int x = 0; x < multipart.getCount(); x++) {
                        BodyPart bodyPart = multipart.getBodyPart(x);
                        String disposition = bodyPart.getDisposition();
                        if (disposition != null && (disposition.equals(BodyPart.ATTACHMENT))) {
                            DataHandler handler = bodyPart.getDataHandler();
                            anexos.add(handler);
                        }

                    }
                }
                return anexos;
            }
        } catch (Exception e) {
            throw new RuntimeException("Zebra" + e);
        }
    }

    private Store conexao(String user, String password) throws MessagingException {
        Session session = Session.getInstance(propriedades(), autenticador(user, password));
        Store store = session.getStore("pop3");
        store.connect(host, user, password);
        return store;
    }

    private Properties propriedades() {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.bsoft.email");
        props.put("mail.smtp.auth", "true");
        return props;
    }

    private Authenticator autenticador(String user, String password) {
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
        return auth;
    }
}
