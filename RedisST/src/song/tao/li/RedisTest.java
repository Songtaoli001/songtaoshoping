package song.tao.li;

import java.util.Date;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest{
private static Jedis jedis;
static{
//访问本地redis
jedis = new Jedis("192.168.232.128",6379);
}
@Test
public void serialize(){
	tb_item item =new tb_item("1", "2", "3");
//	jedis.set(item.getId().getBytes(),  SerializeUtils.serialize(item));
//	byte[] bytes=jedis.get(item.getId().getBytes());
	jedis.set(item.getId(), "123");
	System.out.println(jedis.get(item.getId()));
	jedis.set(item.getId().getBytes(), SerializeUtils.serialize(item));
	byte[] bytes=jedis.get(item.getId().getBytes());
//jedis.set(user.getId().getBytes(), SerializeUtils.serialize(user));
//byte[] bytes=jedis.get(user.getId().getBytes());
//System.out.println((tb_item)SerializeUtils.deSerialize(bytes));

System.out.println(jedis.get("1"));
}
}

