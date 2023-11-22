package in.ashokit.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
	@GetMapping("/greet")
	public String getMsg() {
		return "Good Morning";
	}

}
