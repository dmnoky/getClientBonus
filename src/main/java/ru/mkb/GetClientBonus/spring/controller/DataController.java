package ru.mkb.GetClientBonus.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mkb.GetClientBonus.soap.GetBonusInfo;
import ru.mkb.bonusws.wsdl.GetClientMkbBonusInfoResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value = "/micro")
public class DataController {
    @Autowired
    private GetBonusInfo getBonusInfo;

    @GetMapping(value = "/getclientbonus")
    public ResponseEntity<String> baseUrlRedirectGet (@RequestParam(name = "client", required = true) String clientCode) throws Exception {
        DataResponse dataResponse = new DataResponse();
        //ENCODING
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json;charset=UTF-8");
        if (!clientCode.isEmpty()) {
            //Integration Request
            //GetBonusInfo getBonusInfo = new GetBonusInfo();
            GetClientMkbBonusInfoResponse getClientMkbBonusInfoResponse = getBonusInfo.getResponse(clientCode);

            //XML TO JSON
            String resultIntegration = "";
            ObjectMapper mapper = new ObjectMapper();
            resultIntegration = mapper.writeValueAsString(getClientMkbBonusInfoResponse);

            return ResponseEntity.ok().headers(responseHeaders).body(resultIntegration);
        }
        dataResponse.setEmptyError();
        return ResponseEntity.ok().headers(responseHeaders).body(dataResponse.toString());
    }

    @PostMapping(value = "/getclientbonus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=UTF-8")
    public  ResponseEntity<String> baseUrlRedirectPost(@RequestBody DataRequest dataRequest) throws Exception {
        DataResponse dataResponse = new DataResponse();
        if (!dataRequest.getClient().isEmpty()) {
            //Integration Request
            //GetBonusInfo getBonusInfo = new GetBonusInfo();
            GetClientMkbBonusInfoResponse getClientMkbBonusInfoResponse = getBonusInfo.getResponse(dataRequest.getClient());
            //XML TO JSON
            String resultIntegration = "";
            ObjectMapper mapper = new ObjectMapper();
            resultIntegration = mapper.writeValueAsString(getClientMkbBonusInfoResponse);

            return ResponseEntity.ok(resultIntegration);
        }
        dataResponse.setEmptyError();
        return ResponseEntity.ok(dataResponse.toString());
    }
}
