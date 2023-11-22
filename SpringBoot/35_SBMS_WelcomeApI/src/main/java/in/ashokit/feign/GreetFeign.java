package in.ashokit.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface GreetFeign {
	@GetMapping("/greet")
	public String invokeGreetApi();

}
