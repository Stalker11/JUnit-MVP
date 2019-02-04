package com.example.testtask;

import com.example.testtask.models.LogInRequestModel;
import com.example.testtask.models.LogInResponseModel;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.assertEquals;

public class TestLoginRequest {
    private final String mJsonFile = "loginUser.json";
    private MockWebServer mMockWebServer;
    private MockResponse mMockResponse;
    private final int mResponseCodeSet = 200;
    private final int mResponseCodeCheck = 200;
    private final String mUrl = "/users/login";
    private HttpUrl mHttpUrl;
    private int mUserId = 14523;
    private final String mFileDirectory = "src/test/resources/com.example.testtask";

    @Before
    public void createServer() throws IOException {
        mMockWebServer = new MockWebServer();
        mMockResponse = new MockResponse();

        mMockResponse.setBody(getStringFromJSON(mJsonFile));
        mMockResponse.setResponseCode(mResponseCodeSet);
        mMockWebServer.enqueue(mMockResponse);
    }

    @Test
    public void testRequest() throws IOException {
        mMockWebServer.start();
        mHttpUrl = mMockWebServer.url(mUrl);
        Response response = sendOkHttpTest(new OkHttpClient(), mHttpUrl);
        assertEquals(mResponseCodeCheck, response.code());
        Gson gson = new Gson();
        LogInRequestModel networkResponse = gson.fromJson(response.body().string(), LogInRequestModel.class);
        assertEquals(mUserId,networkResponse.getUserId());
            }

    private String getStringFromJSON(String file) throws IOException {
        File files = new File(mFileDirectory, file);
        //For this state does not work
        // InputStream mock = TestLoginRequest.class.getResourceAsStream(file);
        InputStream mock = new FileInputStream(files);
        BufferedReader buf = new BufferedReader(new InputStreamReader(mock));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        return sb.toString();
    }

    /**
     * Create mock http request
     * @param client OkHttpClient
     * @param url
     * @return
     * @throws IOException
     */
    private Response sendOkHttpTest(OkHttpClient client, HttpUrl url) throws IOException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                new Gson().toJson(new LogInResponseModel("trer@gff.cv","Gfgfgfc23")));
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Token")
                //.addHeader("")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }
}
