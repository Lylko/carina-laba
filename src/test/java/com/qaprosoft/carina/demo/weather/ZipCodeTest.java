package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.openweather.GetWeatherMethod;
import org.testng.annotations.Test;

public class ZipCodeTest implements IAbstractTest {

    @Test
    public void testByZipMountain(){

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("zip", "94040,us");
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("cityName", "skip", "Mountain View");
        api.validateResponse();
    }

    @Test
    public void testByZipFrancisco(){

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("zip", "94134,us");
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("cityName", "skip", "San Francisco");
        api.validateResponse();
    }

    @Test
    public void testByIdRussia(){

        GetWeatherMethod api = new GetWeatherMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.addParameter("zip", "93030,us");
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/rs.schema");
        api.getProperties().replace("cityName", "skip", "Oxnard");
        api.validateResponse();
    }
}
