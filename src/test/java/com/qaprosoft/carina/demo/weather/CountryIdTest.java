package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetWeatherMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountryIdTest implements IAbstractTest {

    @Test
    public void testByIdLondon(){

        GetWeatherMethod getMethod = new GetWeatherMethod();
        getMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getMethod.addParameter("id", "2643743");
        String rs = getMethod.callAPI().asString();
        getMethod.validateResponseAgainstSchema("api/weather/_get/rs.schema");

        Assert.assertEquals(new JsonPath(rs).getInt("timezone"), 3600, "Time zone is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("name"), "London", "City name is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "GB", "Country code is incorrect!");
    }

    @Test
    public void testByIdRussia(){

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("id", "2017370");
        api.callAPI().asString();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("timeZone", "skip", 25200);
        api.getProperties().replace("cityName", "skip", "Russia");
        api.getProperties().replace("countryId", "skip", "RU");
        api.validateResponse();
    }

    @Test
    public void testByIdMinsk(){

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("id", "625144");
        String rs = api.callAPI().asString();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("timeZone", "skip", 10800);
        api.getProperties().replace("cityName", "skip", "Minsk");
        api.getProperties().replace("countryId", "skip", "BY");
        api.validateResponse();
    }

}
