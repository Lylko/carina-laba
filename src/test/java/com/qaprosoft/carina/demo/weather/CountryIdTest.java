package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetWeatherMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountryIdTest implements IAbstractTest {

    @Test
    public void testByIdRussia(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("id", "2017370");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getInt("timezone"), 25200, "Time zone is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("name"), "Russia", "Time zone is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "RU", "Time zone is incorrect!");
    }

    @Test
    public void testByIdMinsk(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("id", "625144");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getInt("timezone"), 10800, "Time zone is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("name"), "Minsk", "Time zone is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "BY", "Time zone is incorrect!");
    }

    @Test
    public void testByIdLondon(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("id", "2643743");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getInt("timezone"), 3600, "Time zone is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("name"), "London", "Time zone is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "GB", "Time zone is incorrect!");
    }


}
