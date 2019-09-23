package cn.gameboys.generate;

import cn.gameboys.frame.TempleResolveManager;
import cn.gameboys.util.PropertiesUtil;

public class MainTest {

	public static void main(String[] args) {
		//创建update insert  select语句
		PropertiesUtil.readCfg("cfg.properties");
		TempleResolveManager manger = new TempleResolveManager();
		manger.resolve();
		System.out.println("run OK!!!");
	}

}
