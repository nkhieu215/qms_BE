package com.fn.qms.service.api.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.constant.Constant;
import com.fn.qms.service.api.bean.AuthenToken;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class ApiRequest {
	 public String errCallMicroservice = "Error call microservice";
	    private static AuthenToken token;

	    public ApiRequest() {
	        if (token == null) {
	            token = this.getTokenRest();
	        }
	    }

	    private void reNewToken() {
	        if (retry == 0) {
	            token = this.getTokenRest();
	            retry++;
	        }
	    }

	    public String sendRequest(Map<String, String> input,ApiConstantUrl urlPath, String requestId) {
	        String response = "";      
	     
	        String jsonLog = "";
	        try {
	            Map<String, String> mapMessage = new HashMap<>();
	            mapMessage.putAll(input);
	            jsonLog = new ObjectMapper().writeValueAsString(mapMessage);
	        } catch (Exception e) {
	            AppLog.error(e);
	        }
	        if (urlPath.getMethod().equals(Constant.POST) || urlPath.getMethod().equals(Constant.PUT)) {
	            String datapost = input.get(Constant.DATA_JSON);
	            try {
	                response = this.postRequest(datapost, urlPath);
	            } catch (IOException e) {
	                AppLog.error(e);
	            }
	        } else if (urlPath.getMethod().equals(Constant.GET)) {
	            response = this.getRequest(input, urlPath);
	        } else if (urlPath.getMethod().equals(Constant.DELETE)) {
	            
	        }

	        return response;
	    }

	    private int retry = 0;

	    public String getRequest(Map<String, String> input, ApiConstantUrl urlPath) {
	        StringBuilder response = new StringBuilder();
	        String responseStr = "";
	        int responseCode = HttpURLConnection.HTTP_BAD_REQUEST;
	        try {
	            String host = Utils.isNull(urlPath.getHost()) ? RequestApiConstant.API_COMMON_URL : urlPath.getHost();
	            String url = host + urlPath.getUrl();
	            AppLog.info("uri::" + url);
	            String fullUrl = "";
	            if (urlPath.getIsparam()) {
	                fullUrl = url + "?" + input.get(Constant.DATA_JSON);
	            } else {
	                URIBuilder buildUrl = new URIBuilder(url);
	                if (input != null && input.size() > 0) {
	                    for (Map.Entry<String, String> entry : input.entrySet()) {
	                        String key = entry.getKey();
	                        String value = entry.getValue();
	                        if (value != null && !value.equals("")) {
	                            buildUrl.addParameter(key, value);
	                        }
	                    };
	                }
	                fullUrl = buildUrl.toString();
	            }
	            AppLog.info("URL ::" + fullUrl);
	            URL obj = new URL(fullUrl);
	            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	            // optional default is GET
	            con.setRequestMethod("GET");
	            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:27.0) Gecko/20100101 Firefox/27.0.2 Waterfox/27.0");
	            con.setRequestProperty("Content-Type", "application/json");
//	            con.setRequestProperty("access_token", token.getAccess_token());
	            con.setRequestProperty("Authorization", "Bearer " + getToken().getAccessToken());
	            responseCode = con.getResponseCode();

	            AppLog.info("\nSending 'GET' request to URL : " + url);
	            AppLog.info("Response Code : " + responseCode);

	            if (responseCode == 401) {
	                reNewToken();
	                return getRequest(input, urlPath);
	            } else {
	                retry = 0;
	            }

	            BufferedReader in;
	            String inputLine;
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                in = new BufferedReader(new InputStreamReader(con.getInputStream(), Constant.CHARSET_UTF8));
	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                in.close();

	                Gson gson = new Gson();
	                JsonObject inputObj = gson.fromJson(response.toString(), JsonObject.class);
	                responseStr = inputObj.toString();
	            } else {
	                if (con.getErrorStream() != null) {
	                    in = new BufferedReader(new InputStreamReader(con.getErrorStream(), Constant.CHARSET_UTF8));
	                } else {
	                    in = new BufferedReader(new InputStreamReader(con.getInputStream(), Constant.CHARSET_UTF8));
	                }
	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                in.close();
	                Gson gson = new Gson();
	                JsonObject inputObj = gson.fromJson(response.toString(), JsonObject.class);
	                inputObj.getAsJsonObject().addProperty("soaErrorCode", inputObj.get("soaErrorCode").getAsString());
	                responseStr = inputObj.toString();
	            }

	            if (responseCode == 401) {
	                token = this.getTokenRest();
	                if (retry == 0) {
	                    retry++;
	                    getRequest(input, urlPath);
	                }
	            } else {
	                retry = 0;
	            }

	        } catch (Exception e) {
	            AppLog.error(e);
	        }
	        return responseStr;
	    }

	    public String postRequest(String inputString, ApiConstantUrl urlPath) throws IOException {

	        HttpURLConnection conn = null;
	        OutputStream output = null;
	        InputStream input = null;

	        String host = Utils.isNull(urlPath.getHost()) ?  RequestApiConstant.API_COMMON_URL : urlPath.getHost();
	        String uri = host + urlPath.getUrl();
	        AppLog.info("uri::" + uri);
	        StringBuilder responseData = new StringBuilder("");
	        String responseStr = "";
	        // Get an HttpURLConnection subclass object instead of URLConnection
	        URL url = new URL(uri);
	        conn = (HttpURLConnection) url.openConnection();
	        // ensure you use the POST method
	        conn.setRequestMethod(urlPath.getMethod());
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type", "application/json");
//	        conn.setRequestProperty("access_token", token.getAccess_token());
	        conn.setRequestProperty("Authorization", "Bearer " + getToken().getAccessToken());
	        output = conn.getOutputStream();
	        // Output the JSON string to the REST service            
	        output.write(inputString.getBytes(Constant.CHARSET_UTF8));
	        output.flush();
	        output.close();

	        int responseCode = conn.getResponseCode();
	        AppLog.info("POST URL :: " + uri);
	        AppLog.info("POST Response Code :: " + responseCode);

	        if (responseCode == 401) {
	            reNewToken();
	            return postRequest(inputString, urlPath);
	        } else {
	            retry = 0;
	        }

	        try {
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), Constant.CHARSET_UTF8));
	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    responseData.append(inputLine);
	                }
	                in.close();

	                // add status succes	                
	                responseStr = in.toString();
	            } else {
	                BufferedReader in;
	                if (conn.getErrorStream() != null) {
	                    in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), Constant.CHARSET_UTF8));
	                } else {
	                    in = new BufferedReader(new InputStreamReader(conn.getInputStream(), Constant.CHARSET_UTF8));
	                }
	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    responseData.append(inputLine);
	                }
	                in.close();
	                Gson gson = new Gson();
	                JsonObject inputObj = gson.fromJson(responseData.toString(), JsonObject.class);	                
	                responseStr = inputObj.toString();
	            }
	        } catch (Exception e) {
	            AppLog.error(e);
	            BufferedReader ineror = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	            String inputLine;
	            while ((inputLine = ineror.readLine()) != null) {
	                responseData.append(inputLine);
	            }
	            ineror.close();
	            responseStr = responseData.toString();
	        } finally {
	            if (output != null) {
	                try {
	                    output.close();
	                } catch (IOException ex) {
	                }
	            }
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException ex) {
	                }
	            }
	            if (conn != null) {
	                conn.disconnect();
	                conn = null;
	            }
	        }
	        return responseStr;
	    }

	   

	    public AuthenToken getTokenRest() {

	        HttpURLConnection myHttpConnection = null;
	        OutputStream output = null;
	        InputStream input = null;
	        AuthenToken tokenObject = null;

	        String uri = RequestApiConstant.AUTHEN_TOKEN_URL;
	        StringBuilder responseData = new StringBuilder("");
	        AppLog.info("POST URL :: " + uri);
	        try {
	            // Get an HttpURLConnection subclass object instead of URLConnection
	            URL url = new URL(uri);
	            myHttpConnection = (HttpURLConnection) url.openConnection();
	            // ensure you use the POST method
	            myHttpConnection.setRequestMethod(Constant.POST);
	            myHttpConnection.setDoOutput(true);
	            myHttpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            
	            myHttpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
	            myHttpConnection.setRequestProperty("charset", "utf-8");
	           
	            
	            // set authenticate
	          
	            String urlParameters  = "username=admin&password=admin";
	            byte[] postData = urlParameters.getBytes( Constant.CHARSET_UTF8 );
	            int postDataLength = postData.length;
	            myHttpConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
	            myHttpConnection.setUseCaches(false);	         
	            output = myHttpConnection.getOutputStream();
	            output.flush();

	            BufferedReader br = new BufferedReader(new InputStreamReader((myHttpConnection.getInputStream())));
	            String outputJson;
	            while ((outputJson = br.readLine()) != null) {
	                responseData.append(outputJson);
	            }
	            br.close();
	            String json = responseData.toString();	            
	            ObjectMapper mapper = new ObjectMapper();
	            tokenObject = mapper.readValue(json, AuthenToken.class);
	            
	        } catch (Exception e) {
	            AppLog.error(e);
	        } finally {
	            if (output != null) {
	                try {
	                    output.close();
	                } catch (IOException ex) {
	                }
	            }
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException ex) {
	                }
	            }
	            if (myHttpConnection != null) {
	                myHttpConnection.disconnect();
	                myHttpConnection = null;
	            }
	        }
	        return tokenObject;
	    }

	    public AuthenToken getToken() {
	        return token;
	    }

	    public void setToken(AuthenToken token) {
	        this.token = token;
	    }
}
