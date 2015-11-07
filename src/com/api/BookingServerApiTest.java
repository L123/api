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

import com.javaer.tools.formatter.JsonFormatter;

import test.APIHttpClient;
import test.test001;

@SuppressWarnings({ "unused" })
public class BookingServerApiTest {
    
    ApiPost api = new ApiPost();
    JsonFormatter j = new JsonFormatter();
    @Before
    public void setUp() throws Exception {
        System.out.println("********************************************准备调用接口********************************************");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("********************************************接口执行完毕********************************************");
    }

    /**********************************************************************************************************************************************/
    //OTA取消订单接口
  @Test
    public void testOtaBkingServer(){
	  String url;
	  String newjson;
	  String methon = "cancelBooking";
	  Object expected;
	  String actaul;

	  int n = 1;
	  switch(methon){
	  //addBooking新增订单
	  case "addBooking":
		  /****getSN 获取下单交易凭证****/
		    url = "http://10.100.112.51:8080/booking/bookingService/getSN";
	    	newjson = "{\"memberId\":\"1485\"}";
	    	expected = "成功";
	    	actaul = "resultMsg";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
	    	//String sn =(String) api.check("sn");
			  /****addBooking新增订单****/
	    	url = "http://10.100.112.51:8080/booking/bookingService/addBooking";
	    	newjson = "{\"innId\": \"451\",\"roomTypeId\": \"220\",\"roomCount\": \"1\",\"sourceTypeId\": \"70\","
	    			+ "\"dtArrorig\": \"2015-11-18 00:00:00\",\"dtDeporig\": \"2015-11-19 00:00:00\",\"bkGstName\": \"51测试服\","
	    			+ "\"mebId\": \"1485\",\"mebType\":\"5\",\"bkCardNo\": \"21007774\",\"bkMobile\": \"15252325222\","
	    			+ "\"bkEmail\": \"33232233@qq.com\",\"revPoint\": \"0\",\"assureType\": \"0\",\"activityCode\": \"ACT00120\","
	    			+ "\"remark\": \"联系人:51测试服 联系方式:15252325222\",\"bkPropertyId\": \"45324964\",\"bkProTypeId\": \"40\","
	    			+ "\"lstOrderGsts\": [{\"name\": \"51测试服\",\"doctType\": \"0\",\"mobile\": \"15252325222\","
	    			+ "\"tel\": \"02000100101\"}],\"isStopSendSMS\": \"true\",\"folioSellerId\": \"0\",\"treasureId\": \"0\","
	    			+ "\"lastArrTime\": null,\"payType\": \"0\",\"bkIp\": \"127.0.0.1\",\"dayLength\": \"1\","
	    			+ "\"contactPhone\": \"15252325222\",\"contactName\": \"51测试服\",\"roomRates\":[{\"roomRate\": \"165\","
	    			+ "\"endOfDay\": \"2015-11-18 00:00:00\",\"currencyCode\": \"CNY\"}], \"channelSourceType\":\"1\","
	    			+ "\"roomSourceType\":\"7days\","
	    			+ "\"sn\":\""+(String) api.check("sn")+ "\"}";
	    	//System.out.println(newjson);
	    	expected = "0";
	    	actaul = "resultCode";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
	  
	  //cancelBooking取消订单
	  case "cancelBooking":
		    url = "http://10.100.112.51:8080/booking/bookingService/cancelBooking";
	    	newjson = "{\"orderCode\":\"100000000107\",\"merchantNo\":\"00001\",\"remarks\":\"1车型\"}";
	    	expected = "取消成功";
	    	actaul = "resultMsg";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
		  
		  //getOrderDetail 查询酒店订单详情
	  case "getOrderDetail":
		    url = "http://10.100.112.51:8080/booking/bookingService/getOrderDetail";
	    	newjson = "{\"orderCode\":\"100000000105\"}";
	    	expected = "成功";
		    actaul = "resultMsg";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
		  
		  //queryOrderByPage 分页查询订单
	  case "queryOrderByPage":
		    url = "http://10.100.112.51:8080/booking/bookingService/queryOrderByPage";
	    	newjson = "{\"pageSize\":\"10\",\"pageIndex\":\"1\",\"orderCode\":\"100000000105\",\"crtBeginTime\":\"2015-11-17 00:00:00\","
	    			+ "\"crtEndTime\":\"2015-11-20 00:00:00\", \"arrBeginTime\":\"\",\"arrEndTime\":\"\",\"arrEndTime\":\"\","
	    			+ "\"depBeginTime\":\"\",\"depEndTime\":\"\",\"sourceType\":\"70\",\"orderState\":\"2\",\"roomTypeId\":\"220\","
	    			+ "\"bkMebId\":\"1485\"}";
	    	expected = "成功";
		    actaul = "resultMsg";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
	    	
		  break;
		  
		  //deleteBooking删除订单
	  case "deleteBooking":
		    url = "http://10.100.112.51:8080/booking/bookingService/deleteBooking";
	    	newjson = "{\"orderCode\": \"100000000107\", \"history\": false, \"remarks\": \"\"}";
	    	expected = "成功";
		    actaul = "resultMsg";
	    	api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
		  break;
		//OTA酒店常规列表查询接口
	  case "query":
		     url = "http://10.100.112.139:9970/hotel/query/ota/basic";
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
	    	 expected = 100;
			 actaul = "msgCode";
	    	 api.post(url, newjson, n);
	    	assertEquals("实际返回检查结果results:",expected,api.check(actaul));
	    	expected = "请求成功";
			 actaul = "message";
			 assertEquals("实际返回检查结果results:",expected,api.check(actaul));
	    	//assertEquals("实际返回结果results:"+api.getresults(),"请求成功",api.getresults());
		  break;
	  default:

		  break;
	  }
	    		    			  	    	
    }
}
