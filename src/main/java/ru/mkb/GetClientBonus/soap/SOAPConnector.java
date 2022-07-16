package ru.mkb.GetClientBonus.soap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.*;

@Component
public class SOAPConnector {
    @Value("${soap.auth.username}")
    private String userName;
    @Value("${soap.auth.password}")
    private String userPassword;

    public Object callWebService (String url, Object request) throws Exception {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(
                MessageFactory.newInstance());
        messageFactory.afterPropertiesSet();
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(
                messageFactory);
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("ru.mkb.bonusws.wsdl");
        marshaller.afterPropertiesSet();

        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.afterPropertiesSet();

        return webServiceTemplate.marshalSendAndReceive(url, request, new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                SaajSoapMessage saajsoapMessage = (SaajSoapMessage) webServiceMessage;
                MimeHeaders mimeHeader = saajsoapMessage.getSaajMessage().getMimeHeaders();

                String logo = userName + ":" + userPassword;
                mimeHeader.setHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString(logo.getBytes()));
            }
        });
    }
}
