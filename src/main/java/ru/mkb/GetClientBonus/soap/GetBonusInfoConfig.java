package ru.mkb.GetClientBonus.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.PropertyException;

@Configuration
public class GetBonusInfoConfig {
    /*@Bean
    public Jaxb2Marshaller marshaller() throws PropertyException {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        //jaxb2Marshaller.setPackagesToScan("ru.mkb.bonusws.wsdl");
        jaxb2Marshaller.setContextPath("ru.mkb.bonusws.wsdl");
        //Marshaller marshaller = jaxb2Marshaller.createMarshaller();
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return jaxb2Marshaller;
    }

    @Bean
    public SOAPConnector getBonus(Jaxb2Marshaller marshaller) {
        SOAPConnector bonus = new SOAPConnector();
        final String wsoUrl = "https://wso2-test.mcb.ru:8243/services/SIEBEL_GET_BONUS_INFO.SIEBEL_GET_BONUS_INFOHttpsSoap11Endpoint";
        bonus.setDefaultUri(wsoUrl);
        bonus.setMarshaller(marshaller);
        bonus.setUnmarshaller(marshaller);
        return bonus;
    }*/
}
