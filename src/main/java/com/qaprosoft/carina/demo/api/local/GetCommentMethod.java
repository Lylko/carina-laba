package com.qaprosoft.carina.demo.api.local;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCommentMethod extends AbstractApiMethodV2 {

    public GetCommentMethod(){
        super(null,"api/local/_get/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
