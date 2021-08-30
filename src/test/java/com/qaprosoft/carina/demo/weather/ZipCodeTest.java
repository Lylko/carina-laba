package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetWeatherMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest implements IAbstractTest {

    @Test
    public void testByZipMountain(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("zip", "94040,us");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getString("name"), "Mountain View", "City is incorrect!");
    }

    @Test
    public void testByZipFrancisco(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("zip", "94134,us");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getString("name"), "San Francisco", "City is incorrect!");
    }

    @Test
    public void testByIdRussia(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("zip", "93030,us");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getString("name"), "Oxnard", "City is incorrect!");
    }
}
