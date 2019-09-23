package cn.gameboys;

import cn.gameboys.frame.TempleResolveManager;
import cn.gameboys.util.PropertiesUtil;

public class Main {
	public static void main(String[] args) {
		PropertiesUtil.readCfg("cfg.properties");
		TempleResolveManager manger = new TempleResolveManager();
		manger.resolve();
		System.out.println("run OK!!!");
	}
}
