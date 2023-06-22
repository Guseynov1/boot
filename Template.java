package PP316;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Template {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://94.198.50.185:7081/api/users/";
        HttpHeaders headersGET = new HttpHeaders();
        headersGET.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headersGET);
        ResponseEntity<String> responseGET = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        headersGET = responseGET.getHeaders();
        String cookie = headersGET.getFirst(HttpHeaders.SET_COOKIE);
        System.out.println(responseGET.getBody());

        HttpHeaders headersPOST = new HttpHeaders();
        headersPOST.add("cookie", cookie);
        Map<String,String> json = new HashMap<>();
        json.put("id","3");
        json.put("name","James");
        json.put("lastName","Brown");
        json.put("age","24");
        HttpEntity<Map<String,String>> requestPOST = new HttpEntity<>(json, headersPOST);
        ResponseEntity<String> responsePOST = restTemplate.exchange(url, HttpMethod.POST, requestPOST, String.class);
        System.out.println(responsePOST.getBody());

        json.put("id","3");
        json.put("name","Thomas");
        json.put("lastName","Shelby");
        json.put("age","24");
        ResponseEntity<String> responsePUT = restTemplate.exchange(url, HttpMethod.PUT, requestPOST, String.class);
        System.out.println(responsePUT.getBody());

        HttpEntity<Map<String,String>> requestDELETE = new HttpEntity<>(headersPOST);
        ResponseEntity<String> responseDELETE = restTemplate.exchange(url + "3", HttpMethod.DELETE, requestDELETE,String.class);
        System.out.println(responseDELETE.getBody());
    }


}