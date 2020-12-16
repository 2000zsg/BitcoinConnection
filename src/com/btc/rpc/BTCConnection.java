package com.btc.rpc;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BTCConnection {
    private static final String RPCUSER = "user";//rpc服务的用户名
    private static final String RPCPASSWORD = "pwd";//rpc服务的服务密码
    private static final String RPCURL = "http://127.0.0.1:8332";//rpc的ip和端口

    public static void main(String[] args) {
        JSONObject rpcJson = new JSONObject();
        rpcJson.put("id", System.currentTimeMillis());
        rpcJson.put("jsonrpc", "2.0");//协议的版本号
        rpcJson.put("method", "getbestblockhash");//要调用的方法名：最后一块区块的hash

        String json = rpcJson.toJSONString();
        System.out.println("请求的数据：" + rpcJson.toJSONString());
        //2、发起网络请求
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(RPCURL);
        try {
            //将认证信息放在请求头中
            String authStr = Constants.RPCUSER + ":" + Constants.RPCPASSWORD;
            String authBase64 = RPCUtlis.Base64Str(authStr);
            //   rpcJson.put("Authorization", "Basic " + authBase64);//用户密码认证
            post.addHeader("Authorization", "Basic " + authBase64);
            //设置连接头信息
            post.addHeader("Encoding", "UTF-8");
            post.addHeader("Content-Type", "application/json");
            StringEntity entity = new StringEntity(json);//StringEntity传递参数
            post.setEntity(entity);//提交数据
            //    post.addHeader();
            HttpResponse response = client.execute(post);//发起post请求操作
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                System.out.println("rpc请求成功");
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            } else {
                System.out.println("抱歉，rpc请求失败" + code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
