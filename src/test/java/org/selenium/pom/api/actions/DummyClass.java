package org.selenium.pom.api.actions;

import com.github.javafaker.Faker;
import org.selenium.pom.objects.User;
import org.selenium.pom.utils.FakerUtils;

public class DummyClass {

    public static void main(String[] args) {
      String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUserName(username).
                setPassword("demopwd").
                setEmail(username + "@gmail.com");
        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(user);
      /*  System.out.println(signUpAPI.register(user));
        System.out.println(signUpAPI.getCookies());*/
        System.out.println("Register API Cookies" + signUpAPI.getCookies());
       AddToCartAPI addToCartAPI = new AddToCartAPI(signUpAPI.getCookies());
       addToCartAPI.addToCart(1215, 1);
        System.out.println("Cart API Cookies" + addToCartAPI.getCookies());
    }
}
