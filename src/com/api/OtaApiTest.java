package com.api;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.APIHttpClient;
import test.test001;

@SuppressWarnings({ "unused" })
public class OtaApiTest {
    
    ApiPost api = new ApiPost();
    @Before
    public void setUp() throws Exception {
        System.out.println("********************************************准备调用接口********************************************");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("********************************************接口执行完毕********************************************");
    }

//    @Test
  //获取酒店详情
//    public void test001() {       
//        String url=  "http://app5.plateno.com:9950/hotel/detail";
//        String newjson = " [{ \"authority\": { \"token\": \"uu8rHdrAA0NjaalK4XuPzy7XDq/usE9g+a+ewrVry4Vr/FZNwut0y5GuyhcJ8Ji4\"},\"chainId\": 621}]";
//        int n = 1;
//        api.post(url,newjson,n);
//    }
//    @Test
  //新浪天气预报
//    public void test002() {
//        String url= "http://php.weather.sina.com.cn/xml.php?";
//        String parameters = "city=%B1%B1%BE%A9&password=DJOYnieT8234jlsK&day=0";
//        int n = 1;
//        api.get(url,parameters,n);
//    }
//    
//    @Test
//    //关键字搜索接口
//    public void test001keywordsearch(){
//    	String url = "http://10.100.112.39:9970/hotel/keyword/search";
//    	String newjson = "{\"cityCode\": \"AR00252\",\"cityName\": \"\",\"keyword\": \"官洲\"}";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
//    
//    @Test
//    //cms获取首页运营广告banner数据列表接口
//    public void test002cms(){
//    	String url = "http://10.100.112.39:9970/advertisement/homePage";
//    	String newjson = "";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
//    //增加酒店点评信息接口
//    public void test003writeComment(){
//    	String url = "http://10.100.112.39:9970/comment/writeComment";
//    	String newjson = "{\"innId\":\"128\","
//    			+ "\"memberId\":\"1\","
//    			+ "\"memberType\":\"1\","
//    			+ "\"orderCode\":\"100067263949\","
//    			+ "\"entireScore\":2,"
//    			+ "\"serviceScore\":1,"
//    			+ "\"facilityScore\":1,"
//    			+ "\"healthScore\":1,"
//    			+ "\"placeScore\":1,"
//    			+ "\"tripAim\":1,"
//    			+ "\"image\":[\"http://image/0\",\"http://image/1\"],"
//    			+ "\"content\":\"测试评价1030002\","
//    			+ "\"append\":0,"
//    			+ "\"authority\": {\"token\": \"nQOuOTdFK6PrhmCz6fivVb8l2xtegB9KGRqJGj5Nr4Qhm+cG6iV8mjJoYtJSV1xS\"}}";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
//    
//    @Test
//    //获取酒店点评信息接口
//    public void test004queryComment(){
//    	String url = "http://10.100.112.39:9970/comment/queryComment";
//    	String newjson = "{\"innId\":\"128\",\"memberId\":\"135945321\",\"orderCode\":\"100067263949\",\"entireScore\":2,\"start\":0,\"limit\":5000,\"authority\": {\"token\": \"nQOuOTdFK6PrhmCz6fivVb8l2xtegB9KGRqJGj5Nr4Qhm+cG6iV8mjJoYtJSV1xS\"}}";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
//    
//    @Test
//    //查询热门城市接口
//    public void test005hotCity(){
//    	String url = "http://10.100.112.39:9970/basic/ota/china/hotCity";
//    	String newjson = "";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
//    
//    @Test
//    //查询热门城市接口
//    public void test006mixturePay(){
//    	String url = "http://10.100.112.39:9970/pay/mixturePay";
//    	String newjson = "{\"orderId\": \"100067263949\","
//    			+ "\"memberId\": 0,"
//    			+ "\"chainId\": 128,"
//    			+ "\"totalAmount\": 106,"
//    			+ "\"cashDepositAmount\": 0,"
//    			+ "\"directPayAmount\": 0,"
//    			+ "\"weixinPay\": false,"
//    			+ "\"aliPayMobile\": true,"
//    			+ "\"isIos\": true,"
//    			+ "\"authority\": {\"token\": \"FmX32AZjhDotuceEDIoWfEdypTEw3nQy5Vth+1ZMwP9wMzvZZTjyjJfnKo+Vo2O6\"}}";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
//   
//    @Test
//    //OTA酒店常规列表查询接口
//    public void test007query(){
//    	String url = "http://10.100.112.39:9970/hotel/query/ota/basic";
//    	String newjson = "{\"cityCode\": \"AR03026\","
//    			+ "\"districtCode\": \"AR02145\","
//    			+ "\"brand\": \"1,2,3\","
//    			+ "\"keyword\": \"\","
//    			+ "\"lng\": 0,\"lat\": 0,"
//    			+ "\"isBiz\": false,"
//    			+ "\"bizlat\": 0,"
//    			+ "\"bizlng\": 0,"
//    			+ "\"maxPrice\": 0,"
//    			+ "\"minPrice\": 0,"
//    			+ "\"page\": 1,"
//    			+ "\"sort\": 1}";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
//    
//    //OTA酒店常规列表查询接口
//    @Test
//    public void test008etTotalPoint(){
//    	String url = "http://10.100.112.39:9970/assets/getTotalPoint";
//    	String newjson = "{\"authority\": { \"token\": \"FmX32AZjhDotuceEDIoWfEdypTEw3nQy5Vth+1ZMwP9wMzvZZTjyjJfnKo+Vo2O6\" }}";
//    	int n = 1;
//    	api.post(url, newjson, n);
//    	assertEquals("实际返回结果msgCode:"+api.getmsgCode(),100,api.getmsgCode());
//    }
  
    /**********************************************************************************************************************************************/
    //OTA取消订单接口
  @Test
    public void testapi(){
	  String url = "";
	  String newjson = "";
	  String methon = "getCurrentBalance";
	  Object expected;
	  String actaul;

	  int n = 1;
	  switch(methon){
	//OTA酒店常规列表查询接口
	  case "getCurrentBalance":
		   url = "http://10.100.112.139:9970/assets/getCurrentBalance";
	    	 newjson = "{\"authority\": { \"token\": \"FmX32AZjhDotuceEDIoWfEdypTEw3nQy5Vth+1ZMwP9wMzvZZTjyjJfnKo+Vo2O6\" }}";
	    	
	    	expected = 100;
	    	actaul = "msgCode";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
		  
		  //getOrderDetail 查询酒店订单详情
	  case "getOrderDetail":
		    url = "http://10.100.112.51:8080/booking/bookingService/getOrderDetail";
		    actaul = "resultMsg";
		    expected = "成功";
	    	newjson = "{\"orderCode\":\"100000000105\"}";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
		  
		  //queryOrderByPage 分页查询订单
	  case "queryOrderByPage":
		    url = "http://10.100.112.51:8080/booking/bookingService/queryOrderByPage";
		    actaul = "resultMsg";
		    expected = "成功";
	    	newjson = "{\"pageSize\":\"10\",\"pageIndex\":\"1\",\"orderCode\":\"100000000105\",\"crtBeginTime\":\"2015-11-17 00:00:00\","
	    			+ "\"crtEndTime\":\"2015-11-20 00:00:00\", \"arrBeginTime\":\"\",\"arrEndTime\":\"\",\"arrEndTime\":\"\","
	    			+ "\"depBeginTime\":\"\",\"depEndTime\":\"\",\"sourceType\":\"70\",\"orderState\":\"2\",\"roomTypeId\":\"220\","
	    			+ "\"bkMebId\":\"1485\"}";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
		  
		  //deleteBooking删除订单
	  case "deleteBooking":
		    url = "http://10.100.112.51:8080/booking/bookingService/deleteBooking";
		    actaul = "resultMsg";
		    expected = "成功";
	    	newjson = "{\"orderCode\": \"100000000105\", \"history\": false, \"remarks\": \"\"}";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
		//OTA酒店常规列表查询接口
	  case "query":
		   url = "http://10.100.112.139:9970/hotel/query/ota/basic";

		    actaul = "msgCode";
		    expected = 100;
	    	 newjson = "{\"cityCode\": \"AR03026\","
	    			+ "\"districtCode\": \"AR02145\","
	    			+ "\"brand\": \"1,2,3\","
	    			+ "\"keyword\": \"\","
	    			+ "\"lng\": 0,\"lat\": 0,"
	    			+ "\"isBiz\": false,"
	    			+ "\"bizlat\": 0,"
	    			+ "\"bizlng\": 0,"
	    			+ "\"maxPrice\": 0,"
	    			+ "\"minPrice\": 0,"
	    			+ "\"page\": 1,"
	    			+ "\"sort\": 1}";
	    	 
		    	api.post(url, newjson, n);
		    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
	    	//assertEquals("实际返回结果results:"+api.getresults(),"请求成功",api.getresults());
		  break;
	  default:

		  break;
	  }

	    	
	    	
		  
			  

    	
    }
}
