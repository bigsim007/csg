package za.co.bigsim;

import static org.hamcrest.CoreMatchers.is;

import  org.hamcrest.MatcherAssert;
import org.springframework.http.HttpStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

	 @When("^the client calls /baeldung$")
	    public void the_client_issues_POST_hello() throws Throwable {
	        executePost();
	    }

	    @Given("^the client calls /hello$")
	    public void the_client_issues_GET_hello() throws Throwable {
	        executeGet("http://localhost:8082/hello");
	    }

	    @When("^the client calls /version$")
	    public void the_client_issues_GET_version() throws Throwable {
	        executeGet("http://localhost:8082/version");
	    }

	    @Then("^the client receives status code of (\\d+)$")
	    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
	        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
	        MatcherAssert.assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
	    }

	    @And("^the client receives server version (.+)$")
	    public void the_client_receives_server_version_body(String version) throws Throwable {
	    	MatcherAssert.assertThat(latestResponse.getBody(), is(version));
	    }

	    @Given("^the client calls GET api/class$")
	    public void the_client_calls_GET_class() throws Throwable {
	        executeGet("http://localhost:8082/api/class");
	    }
}
