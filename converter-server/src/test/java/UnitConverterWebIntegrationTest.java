import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {com.mehdi.main.UnitConverterApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitConverterWebIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @DisplayName("Check /converter/length/meterToFeet?meter=100")
    @Test
    void meterToFeet() throws JSONException {
        var entity = new HttpEntity<>(null, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort("/converter/length/meterToFeet"))
                .queryParam("meter", 100d);

        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET, entity, String.class);

        var expected = "{'value':328.08,'unit':'ft','message':'Success'}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @DisplayName("Check /converter/length/meterToFeet?meter=100&&fraction=3")
    @Test
    void meterToFeetWithFraction() throws JSONException {
        var entity = new HttpEntity<>(null, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(createURLWithPort("/converter/length/meterToFeet"))
                .queryParam("meter", 100d)
                .queryParam("fraction", 3);

        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET, entity, String.class);

        var expected = "{'value':328.084,'unit':'ft','message':'Success'}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

}