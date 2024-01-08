package org.selenium.pom.dataproviders;

import org.selenium.pom.objects.Products;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {

    @DataProvider(name= "getFeaturedProducts" , parallel = true)
    public Object[] getFeaturedProducts() throws IOException {
        return JacksonUtils.deserializedJson("products.json", Products[].class);

    }
}
