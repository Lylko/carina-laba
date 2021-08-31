package com.qaprosoft.carina.demo.api.local;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.demo.api.openweather.Credentials;

public class PatchCommentMethod extends AbstractApiMethodV2 {
    public PatchCommentMethod(){
        super("api/local/_patch/rq.json", "api/local/_patch/rs.json", "api/local/local.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
