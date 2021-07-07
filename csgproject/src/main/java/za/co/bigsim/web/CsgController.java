package za.co.bigsim.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsgController {

	  @GetMapping("/hello")
	    public String sayHello() {
	        return "hello";
	    }

	    @PostMapping("/baeldung")
	    public String sayHelloPost() {
	        return "hello";
	    }
}
