package song.tao.li;

import java.io.Serializable;
import java.sql.Date;

import org.omg.PortableServer.ServantActivator;

public class tb_item  implements Serializable {
private  static final long serialVersionUID=2724888087391664167L;
private String  id;//'商品id，同时也是商品编号',
private String title;// '商品标题',
private String sell_point;// '商品卖点',
//private  int price;//'商品价格，单位为：分',
//private  int num ; // '库存数量',
//private  String barcode;// '商品条形码',
//private  String image;// '商品图片',
//private  int cid; //'所属类目，叶子类目',
//private  int status;// '商品状态，1-正常，2-下架，3-删除',
//private  Date created; // '创建时间',
//private  Date updated; //'更新时间'

@Override
public String toString() {
	return "tb_item [id=" + id + ", title=" + title + ", sell_point=" + sell_point + "]";
}
public tb_item(String id, String title, String sell_point) {
	super();
	this.id = id;
	this.title = title;
	this.sell_point = sell_point;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSell_point() {
	return sell_point;
}
public void setSell_point(String sell_point) {
	this.sell_point = sell_point;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

		
}
