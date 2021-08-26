package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

import java.util.Properties;

public class GetMethod extends AbstractApiMethodV2 {
    public GetMethod() {
        super(null, "api/users/_get/rs_copy.json", new Properties());
        replaceUrlPlaceholder("base_url", "https://api.openweathermap.org");
    }
}
