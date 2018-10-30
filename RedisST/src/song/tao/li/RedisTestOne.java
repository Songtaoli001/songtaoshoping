package song.tao.li;

import java.sql.Date;

import org.junit.Test;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import redis.clients.jedis.Jedis;

public class RedisTestOne {

	
	@Test
	public void  testOne()throws  Exception{
		Jedis jedis = new Jedis("192.168.232.128",6379);
		jedis.set("key2", "2");
		System.out.println(jedis.get("key2"));
//		jedis.select(arg0)
		jedis.close();
	}
	
	public void testTwo() {
		

String tabname;
  int id;//'商品id，同时也是商品编号',
 String title;// '商品标题',
 String sell_point;// '商品卖点',
  int price;//'商品价格，单位为：分',
  int num ; // '库存数量',
  String barcode;// '商品条形码',
  String image;// '商品图片',
  int cid; //'所属类目，叶子类目',
  int status;// '商品状态，1-正常，2-下架，3-删除',
  Date created; // '创建时间',
  Date updated; //'更新时间',
  
	
		
	}
}

