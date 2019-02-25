package io.renren.modules;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static io.renren.modules.RSATOOL.byteToStr;

public class Demo {
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    private static final String  appkey = "39dd949c-f748-4f9a-9620-2d7cb8f850a5";
    private static final String  appsecret = "fc27af70-8a02-4759-a72e-f51d9f0857b2";
    private static final String   priKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKEzn3y9STTpPQXMuK4D33AwAWuqCQerq/rZxy63l7pH8uFdxoLJlOADajben3reQcnr1FyypBMGMRuXOQaNqqekWYwsH/FHSAQAxA7D0jNKSY7s5TD64YVCGDBz6XETZ+31wUpCxczletUOIwYfo/YJZG5PKaczTh5VNME02O3TAgMBAAECgYAkmvZiexE+pKAoyv489cAtV5la+3eleERLaFykrSgVMvViW8sSM/hMjjn2T8NjQUkrMxQ8IIzFjShlnYdjh5PytUjkjRiYSuiXtI5laYRxaqHwOF+m+gSQrbH9oAKHwfenvNsDEdjBU+1i0Qn4x/53mGjyMXO/DCv/74IhlZsr0QJBAM2s/x3qMSv2B4taJu3NMcJaDKaGTzSY3XP/hLKgrl2yXJkLMD/Cg+bKj3XS2CNckL4Ex6Es0uX8dWW3qmGRjN8CQQDIpOG5UM1t+lB0Efg2u0vtpRQS1e5Now6iUrAONXbFi5DNiyHgIVWBlVrrCoyQBcKMbBhPIwsktEtUq2mbFYmNAkBg8H3Z8qy0ZKSPqLEaehFO4jR+NGWWi8osxy0bKCKm5M9CDwTxuFOE7soJJZRbrmBGP2h77e2FGqWWiKeUjw6PAkA1FLnKxv+yCrjiHCbog+BwfG21Ffe3fl3Ov8Vn3OkRFf03A4nwu6DdaV/mMqJBL+TqNWaw+PpnuXL8cWS87JO5AkBKDmfqNu8aiYZOtwr817bso4htR83ReyEYebxx0ejXGAVdzmLAo2UzwAq9IQfFbrCwSsajPfT0oJrTjh14cPSN";
    private static final String   pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChM598vUk06T0FzLiuA99wMAFrqgkHq6v62ccut5e6R/LhXcaCyZTgA2o23p963kHJ69RcsqQTBjEblzkGjaqnpFmMLB/xR0gEAMQOw9IzSkmO7OUw+uGFQhgwc+lxE2ft9cFKQsXM5XrVDiMGH6P2CWRuTymnM04eVTTBNNjt0wIDAQAB";

    private static  OkHttpClient instance = null;
    private final static String url = "http://saas.morningpay.io/api/";
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.transfer();
//        demo.accounts();
//        demo.balance();



    }

    public static OkHttpClient okHttps(){
        if(instance==null)
         instance = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        return instance;
//        MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
//        Request request = new Request.Builder()
//                .url(url)
//                .addHeader()
//                .get()
//                .build();
//        Response response = instance.newCall(request).execute();
//        String res = response.body().string();
//        response.close();
//        if (response.code() != 200) {
//
//        }
    }
    public void getAddresses(){
        try {
            String signStr = "GET|/wallet/address|BTC";
            String signValue = SHA256.getSha256(signStr, appsecret);
            Request request = new Request.Builder()
                    .url(url+"wallet/addresses?coin_type=BTC")
                    .addHeader("x-appkey", appkey)
                    .addHeader("x-sign", signValue)
                    .get()
                    .build();
            Response response = okHttps().newCall(request).execute();
            String res = response.body().string();
            System.out.print(res);
            response.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void balance(){
        try {
            String signStr = "GET|/wallet/balance|EOS|kpd1uhb1ulsj";
            String signValue = SHA256.getSha256(signStr, appsecret);
            Request request = new Request.Builder()
                    .url(url+"wallet/balance?coin_type=EOS&accounts=kpd1uhb1ulsj")
                    .addHeader("x-appkey", appkey)
                    .addHeader("x-sign", signValue)
                    .get()
                    .build();
            Response response = okHttps().newCall(request).execute();
            String res = response.body().string();
            System.out.print(res);
            response.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void accounts(){
        try {
            String signStr = "GET|/wallet/accounts|EOS|kpd1uhb1ulsj";
            String signValue = SHA256.getSha256(signStr, appsecret);
            Request request = new Request.Builder()
                    .url(url+"wallet/accounts?coin_type=EOS&accounts=kpd1uhb1ulsj")
                    .addHeader("x-appkey", appkey)
                    .addHeader("x-sign", signValue)
                    .get()
                    .build();
            Response response = okHttps().newCall(request).execute();
            String res = response.body().string();
            System.out.print(res);
            response.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void list(){
        try {
            String signStr = "GET|/wallet/list|EOS|kpd1uhb1ulsj";
            String signValue = SHA256.getSha256(signStr, appsecret);
            Request request = new Request.Builder()
                    .url(url+"wallet/list?coin_type=EOS&accounts=kpd1uhb1ulsj&page=1&limit=20")
                    .addHeader("x-appkey", appkey)
                    .addHeader("x-sign", signValue)
                    .get()
                    .build();
            Response response = okHttps().newCall(request).execute();
            String res = response.body().string();
            System.out.print(res);
            response.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deposits(){
        try {
            String signStr = "GET|/wallet/deposits|EOS|kpd1uhb1ulsj";
            String signValue = SHA256.getSha256(signStr, appsecret);
            Request request = new Request.Builder()
                    .url(url+"wallet/deposits?coin_type=EOS&accounts=kpd1uhb1ulsj&page=1&limit=20")
                    .addHeader("x-appkey", appkey)
                    .addHeader("x-sign", signValue)
                    .get()
                    .build();
            Response response = okHttps().newCall(request).execute();
            String res = response.body().string();
            System.out.print(res);
            response.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void withdraws(){
        try {
            String signStr = "GET|/wallet/withdraws|EOS|kpd1uhb1ulsj";
            String signValue = SHA256.getSha256(signStr, appsecret);
            Request request = new Request.Builder()
                    .url(url+"wallet/withdraws?coin_type=EOS&accounts=kpd1uhb1ulsj&page=1&limit=20")
                    .addHeader("x-appkey", appkey)
                    .addHeader("x-sign", signValue)
                    .get()
                    .build();
            Response response = okHttps().newCall(request).execute();
            String res = response.body().string();
            System.out.print(res);
            response.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transfer(){
        JSONObject json = new JSONObject();
        json.put("coin_type","EOS");
        json.put("to","kpd1uhb1ulsj");
        json.put("quantity",0.0001);
        json.put("memo","");
        try {
            String signStr = "POST|/wallet/transfer|"+"EOS|kpd1uhb1ulsj|0.0001|";
            byte[] sourcepri_pub = RSATOOL.messageToByte(signStr);
            byte[] signpri_pub =RSATOOL.encryptByRSA1(RSATOOL.strToByte(priKey) ,sourcepri_pub);
            String rsaValue = byteToStr(signpri_pub);
            System.out.print(rsaValue);
            rsaValue = rsaValue.replaceAll("\r\n","");
          //  rsaValue = "kKWx9qve3Yl4hQQPlQrgkUmpZ3NxdAECs41Kar6a5I8+DlzRKqTUrhTDkpkCu4ACV3ejb5YpQqvBd0uCzqautZ7j7eRBhJ/qkejLc7/qenROUb8t+Vu1RuAXkfFO3fhyYkPD1fjWbc/7ZE7+rrGBZXqiLeUaQsdMwl7pQiBeBh0=1d37374b351a0d608a79c1230eefc80cc1aa41a5429e5c5944bb14218a6c8c78";
            String signValue = SHA256.getSha256(signStr, appsecret);
            RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json.toJSONString());
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("x-appkey", appkey)
                    .addHeader("x-sign", signValue)
                    .addHeader("x-rsa-sign", rsaValue+"")
                    .post(body)
                    .build();
            Response response = okHttps().newCall(request).execute();
            String res = response.body().string();
            System.out.print(res);
            response.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }














//    tran(){
//        var signValue ="h8PSAREsVXknWox3lhEuejt9EhveK2LPbb5sNepi/01tBN1V1c6F+owqFHRCDQLwfpZ1Q38rINX4obYf3mONJ8E+VrI4XIOS3c45RoYmV9SNjOc7vBymW0IeESJRWSIAtPodUCMNQqOQVPEEc/dkK3ZQZzgORvc2VUTapk2uwkA="
//        this.$refs['dataForm'].validate((valid) => {
//        if (valid) {
//            this.$http({
//                    url: this.$http.adornUrl('/wallet/transfer'),
//                    method: 'post',
//                    data: this.$http.adornData({
//                    'coin_type': "EOS",
//                    'from':"vbuspyjtst3p",
//                    'to': "kpd1uhb1ulsj",
//                    'quantity': 0.0001,
//                    'memo':"",
//              }),
//            headers:{
//                'x-appkey':'39dd949c-f748-4f9a-9620-2d7cb8f850a5',
//                        'x-sign':"1d37374b351a0d608a79c1230eefc80cc1aa41a5429e5c5944bb14218a6c8c78",
//                        "x-rsa-sign":"kKWx9qve3Yl4hQQPlQrgkUmpZ3NxdAECs41Kar6a5I8+DlzRKqTUrhTDkpkCu4ACV3ejb5YpQqvBd0uCzqautZ7j7eRBhJ/qkejLc7/qenROUb8t+Vu1RuAXkfFO3fhyYkPD1fjWbc/7ZE7+rrGBZXqiLeUaQsdMwl7pQiBeBh0="
//            }
//            }).then(({data}) => {
//            // console.log("data"+JSON.stringify(data))
//            if (data && data.code === 0) {
//                this.$cookie.set('token', data.token)
//                this.$cookie.set('appkey', data.user.appkey)
//                this.$cookie.set('appsecret', data.user.appsecret)
//                this.$cookie.set('userId', data.user.userId)
//                this.$router.replace({ name: 'demo-echarts' })
//            } else {
//                this.getCaptcha()
//                this.$message.error(data.msg)
//            }
//            })
//        }
//        })
//    },









}
