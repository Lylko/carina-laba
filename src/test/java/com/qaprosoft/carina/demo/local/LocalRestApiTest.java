package com.qaprosoft.carina.demo.local;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.local.DeletePostsMethod;
import com.qaprosoft.carina.demo.api.local.GetCommentMethod;
import com.qaprosoft.carina.demo.api.local.PatchCommentMethod;
import com.qaprosoft.carina.demo.api.local.PostCommentMethod;
import org.testng.annotations.Test;

public class LocalRestApiTest implements IAbstractTest {

    @Test()
    public void testDeletePostMethod(){
        DeletePostsMethod api = new DeletePostsMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    public void testPatchCommentMethod(){
        PatchCommentMethod api = new PatchCommentMethod();
        api.getProperties().remove("id");
        api.getProperties().remove("postId");
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.getProperties().put("id", 5);
        api.getProperties().put("postId", 3);
        api.validateResponse();
    }

    @Test()
    public void testPostCommentMethod(){
        PostCommentMethod api = new PostCommentMethod();
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    public void testGetCommentMethod(){
        GetCommentMethod api = new GetCommentMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }

}
