package ru.mkb.GetClientBonus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.mkb.GetClientBonus.soap.GetBonusInfo;

@SpringBootApplication
public class GetClientBonusApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetClientBonusApplication.class, args);
	}
	/*wsimport.exe -d "C:\Users\bon\IDEAProject\demo2\src\main\java\com\example\demo2" -keep "C:\Users\bon\Downloads\SIEBEL_GET_BONUS_INFO_wsdl (1)\SIEBEL_GET_BONUS_INFO_wsdl.wsdl"
	*/
}
