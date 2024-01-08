package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.pom.utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddToCartAPI {

    private Cookies cookies;

    public AddToCartAPI(){}

    public AddToCartAPI(Cookies cookies){
        this.cookies = cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }

    public Response addToCart(int productID, int quantity){
        Header header = new Header("Content-Type" , "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku:", "");
        formParams.put("product_id", productID);
        formParams.put("quantity", quantity);

        if(cookies == null){
            cookies = new Cookies();
        }

        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseURL()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
       when().
                post("/?wc-ajax=add_to_cart").
       then().
                log().all().
                extract().response();

        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to add Product" + productID  + ", HTTP Status Code " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
