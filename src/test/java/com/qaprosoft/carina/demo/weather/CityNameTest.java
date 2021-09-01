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

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("q", "Minsk");
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("sysId", "skip", 8939);
        api.getProperties().replace("countryId", "skip", "BY");
        api.validateResponse();
    }

    @Test
    public void testByNameKiev(){

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("q", "Kiev");
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("sysId", "skip", 2003742);
        api.getProperties().replace("countryId", "skip", "UA");
        api.validateResponse();

    }

    @Test
    public void testByNameMoscow(){

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("q", "Moscow");
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("sysId", "skip", 2009195);
        api.getProperties().replace("countryId", "skip", "RU");
        api.validateResponse();
    }
}
