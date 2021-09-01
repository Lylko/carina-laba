package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.openweather.GetForecastMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.intValue;

public class ForecastTest implements IAbstractTest {

    @Test()
    public void testNumberOfDaysFromForecast(){

        GetForecastMethod api = new GetForecastMethod();
        api.addParameter("q", "London");
        String rs = api.callAPI().asString();
        List<Float> list = new JsonPath(rs).getList("list.dt");
        int number = (intValue(list.get(list.size()-1)) - intValue(list.get(0))) / 10800;
        Assert.assertEquals(number, 39, "Forecast is not on 5 days!");
    }


}
