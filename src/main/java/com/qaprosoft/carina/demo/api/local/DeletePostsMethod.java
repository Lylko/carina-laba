package com.qaprosoft.carina.demo.api.local;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class DeletePostsMethod extends AbstractApiMethodV2 {
    public DeletePostsMethod(){
        super(null, "api/local/_delete/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
