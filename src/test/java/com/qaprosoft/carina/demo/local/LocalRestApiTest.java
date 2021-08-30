package com.qaprosoft.carina.demo.local;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.local.DeletePostsMethod;
import com.qaprosoft.carina.demo.api.local.PatchCommentMethod;
import com.qaprosoft.carina.demo.api.local.PostCommentMethod;
import org.testng.annotations.Test;

public class LocalRestApiTest implements IAbstractTest {

    @Test()
    public void testDeletePostMethod(){
        DeletePostsMethod deletePostsMethod = new DeletePostsMethod();
        deletePostsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePostsMethod.callAPI();
    }

    @Test()
    public void testPatchCommentMethod(){
        PatchCommentMethod patchCommentMethod = new PatchCommentMethod();
        patchCommentMethod.getProperties().remove("commentId");
        patchCommentMethod.getProperties().remove("postId");
        patchCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        patchCommentMethod.callAPI();
    }

    @Test()
    public void testPostCommentMethod(){
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        postCommentMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postCommentMethod.callAPI();
    }

}
