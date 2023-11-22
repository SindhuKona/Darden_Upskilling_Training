package in.ashokit.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.feign.GreetFeign;

@RestController
public class WelcomeRestController {
	@Autowired
	private GreetFeign greetFeign;
	@GetMapping("/welcome")
	public String getMsg() {
		
//		RestTemplate rt = new RestTemplate();
//		ResponseEntity<String> forEntity = rt.getForEntity("http://localhost:8081/greet",String.class);
//		String greet = forEntity.getBody();
		
		String greetResponse = greetFeign.invokeGreetApi();
		
		return greetResponse + "welcome to SBMS";
	}

}
