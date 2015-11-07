package com.api;

import static org.junit.Assert.*;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.javaer.tools.formatter.*;

public class ApiPost {
  
    CloseableHttpClient httpClient=HttpClients.createDefault(); 
    private Log  logger = LogFactory.getLog(this.getClass()); 
    private long startTime  = 0L;
    private long endTime    = 0L;
//    private int msgCode ;
    String body;
    int status=0;

    
     public String post(String url,String parameters,int n) {
         HttpPost httppost=new HttpPost(url);
            
              try {                   
                  String json = parameters.toString();
                  logger.info("打印调用的api接口地址："+url);
                  logger.info("打印post的json字符串："+JsonFormatter.jsonFormatter(json));
                  
                    switch(n){
                    
                        case 1:
                            httppost.addHeader("Content-type", "application/json");
                        break;
                        
                        default :
                            httppost.addHeader("Content-type", "application/x-www-form-urlencoded");
                            break;
                    }   
                    
                    httppost.setEntity(new StringEntity(json, "UTF-8"));

//                    ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
//                    parameters = new String(parameters.getBytes("GBK"), "UTF-8");
//                    list.addAll((Collection<? extends NameValuePair>) new BasicNameValuePair("data", parameters));
//                    httppost.setEntity(new UrlEncodedFormEntity((List<? extends org.apache.http.NameValuePair>) list,  "UTF-8")); 
//                    StringEntity entity = new StringEntity(json);
//                    entity.setContentType("application/x-www-form-urlencodeds");
//                    httppost.setEntity(entity);                   
//                    logger.info("打印post的httppost字符串："+new StringEntity(json, "UTF-8").toString());
                    
                    startTime = System.currentTimeMillis();
                    HttpResponse response = httpClient.execute(httppost);
                    endTime = System.currentTimeMillis();
                    int statusCode = response.getStatusLine().getStatusCode();
                    logger.info("statusCode:" + statusCode);
                    logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
                    //assertEquals("很遗憾，返回值statusCode不等于200，请检查。。。",200,statusCode);


                    if (statusCode != HttpStatus.SC_OK) {
                    	
                        System.out.println("Method failed:" + response.getStatusLine());
                        status = 1;
                    }
                    // Read the response body
                    body = EntityUtils.toString(response.getEntity());

                } catch (IOException e) {
                    // 发生网络异常
                    System.out.println("exception occurred!\n" + ExceptionUtils.getStackTrace(e));
                    // 网络错误
                    status = 3;
                } finally {
                	switch(status){
                	
                	case 0:
                		logger.info("调用接口成功，status：" + status);
                		break;
                		
                	case 1:
                		logger.info("调用接口执行方法失败，status：" + status);
                		break;
                		
                	case 2:
                		logger.info("调用接口协议错误，status：" + status);
                		break;
                		
                	case 3:
                		logger.info("调用接口网络错误，status：" + status);
                		break;
                		
                	default:
                		logger.info("调用接口未知状态，status：" + status);
                		break;
                	}
//                    logger.info("调用接口状态：" + status);
                }

              String newbody = JsonFormatter.jsonFormatter(body);
              logger.info("post执行完毕，准备返回格式化前的jsonbody" + body);
              //格式化json
              logger.info("post执行完毕，准备返回格式化后的jsonbody" + newbody);

              
            	//  results = jsonObj.get(results).toString();
                 // logger.info("post执行完毕，准备返回getresults()的值:" + results);
                 // setresults(results.toString());            
                  //setbody(body);             
            return body;
        }
     
     //获取json中msgCode的值
     public Object check(Object result){
    	 JSONObject jsonObj = JSONObject.fromObject(body);
    	 
//    	 检查字符串结果 
		if(jsonObj.get(result) instanceof String){
    		String results = (String) jsonObj.get(result);
            logger.info("检查执行完毕，返回检查点是字符串"+result+":" + results);
            return results;
 		 }
		
//   	 检查整型类型结果 
    	 else{
    		int results= (int) jsonObj.get(result);
             logger.info("检查执行完毕，返回检查点是整型"+result+":" + results);
             return results;
         }   	 
     }

//     public String getbody() {
//         return body;
//     }
//
//     /**
//      * @param status
//      *            the status to set
//      */
//     public void setbody(String body) {
//         this.body = body;
//     }
        /**
         * 0.成功 1.执行方法失败 2.协议错误 3.网络错误
         * 
         * @return the status
         */
//        public int getStatus() {
//            return status;
//        }

        /**
         * @param status
         *            the status to set
         */
//        public void setStatus(int status) {
//            this.status = status;
//        }
        
//        public int getmsgCode() {
//            return msgCode;
//        }
//
//        /**
//         * @param msgCode
//         *            the msgCode to set
//         */
//        public void setmsgCode(int msgCode) {
//            this.msgCode = msgCode;
//        }
//        
//        public String getresults() {
//
//			return results;
//        }
//
//        /**
//         * @param results
//         *            the results to set
//         */
//        public void setresults(String results) {
//            this.results = results;
//        }

        /***********************************************************************************************************/
        public String get(String url,String parameters,int n ) {
            String body = null;
              try {
                  url=url+parameters;
                  logger.info("打印get请求url地址："+url);
                  HttpGet httpget=new HttpGet(url);
                  
                   switch(n){
                       case 1:
                           httpget.addHeader("Content-type", "application/x-www-form-urlencoded");
                       break;
                       default :
                           httpget.addHeader("Content-type", "application/x-www-form-urlencoded");
                           break;
                   }
                   startTime = System.currentTimeMillis();
                    HttpResponse response = httpClient.execute(httpget);
                    endTime = System.currentTimeMillis();
                    int statusCode = response.getStatusLine().getStatusCode();
                    System.out.println("statusCode:" + statusCode);
                    logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
                    assertEquals("很遗憾，返回值statusCode不等于200，请检查。。。",200,statusCode);

//                    ((AbstractHttpEntity) response).setContentType("text/xml;charset=UTF-8"); 
                    if (statusCode != HttpStatus.SC_OK) {
                        System.out.println("Method failed:" + response.getStatusLine());
                        status = 1;
                    }
                    // Read the response body
                    body = EntityUtils.toString(response.getEntity());
                   // body.getBytes(body).toString();


                } catch (IOException e) {
                    // 发生网络异常
                    System.out.println("exception occurred!\n" + ExceptionUtils.getStackTrace(e));
                    // 网络错误
                    status = 3;
                } finally {
                    System.out.println("调用接口状态：" + status);
                }

            
           System.out.println("get执行完毕，准备返回body" + body);
            return body;
        }  

      
    }
