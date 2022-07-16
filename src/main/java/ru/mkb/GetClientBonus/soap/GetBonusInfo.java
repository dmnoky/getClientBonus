package ru.mkb.GetClientBonus.soap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.mkb.bonusws.wsdl.ClientTypeRq;
import ru.mkb.bonusws.wsdl.GetClientMkbBonusInfo;
import ru.mkb.bonusws.wsdl.GetClientMkbBonusInfoResponse;
import ru.mkb.bonusws.wsdl.GetClientMkbBonusInfoRqTypeRq;

@Component
public class GetBonusInfo extends WebServiceGatewaySupport {
    @Autowired
    private SOAPConnector soapConnector;

    @Value("${soap.auth.URI}")
    private String URI;

    public GetClientMkbBonusInfoResponse getResponse(String clientCode) throws Exception {
        GetClientMkbBonusInfo request = new GetClientMkbBonusInfo();
        ClientTypeRq clientTypeRq = new ClientTypeRq();
        clientTypeRq.setClientCode(clientCode);
        GetClientMkbBonusInfoRqTypeRq getClientMkbBonusInfoRqTypeRq = new GetClientMkbBonusInfoRqTypeRq();
        getClientMkbBonusInfoRqTypeRq.getClients().add(clientTypeRq);
        request.setGetClientMkbBonusInfoRq(getClientMkbBonusInfoRqTypeRq);
        //System.out.println("clientCode = " + request.toString());
        //System.out.println("clientCode = " + clientCode);
        //String wsoUrl = "https://wso2-test.mcb.ru:8243/services/SIEBEL_GET_BONUS_INFO.SIEBEL_GET_BONUS_INFOHttpsSoap11Endpoint";
        GetClientMkbBonusInfoResponse response = null;
        //SOAPConnector soapConnector = new SOAPConnector();
        response = (GetClientMkbBonusInfoResponse) soapConnector.callWebService(URI, request);
        //ObjectMapper mapper = new ObjectMapper();
        //mapper.writeValue(System.out, response);
        return response;
    }
}
