package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetWeatherMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CityNameTest implements IAbstractTest {

    @Test
    public void testByNameMinsk(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("q", "Minsk");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "BY", "Country name is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getInt("sys.id"), 8939, "Id value is incorrect!");
    }

    @Test
    public void testByNameKiev(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("q", "Kiev");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "UA", "Country name is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getInt("sys.id"), 2003742, "Id value is incorrect!");
    }

    @Test
    public void testByNameMoscow(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("q", "Moscow");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "RU", "Country name is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getInt("sys.id"), 2009195, "Id value is incorrect!");
    }
}
