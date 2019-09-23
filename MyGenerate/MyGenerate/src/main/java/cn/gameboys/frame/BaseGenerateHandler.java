package cn.gameboys.frame;

/**
 * 自定义handler初始化的抽象类
* @Description: 
* @author: sniper(1084038709@qq.com)
* @date:2019年9月18日 下午5:42:19
 */
public abstract class BaseGenerateHandler<T> implements IGenerateHandler<T> {

	protected T t;

	@Override
	public void init() {
		this.t = initCfg();
	}

	protected abstract T initCfg();

	@Override
	public String resolve() {
		return resolveTemple(t);
	}

	private StringBuilder sb = new StringBuilder();

	protected String resolveTemple(T t) {
		sb = new StringBuilder();
		this.resolveLogic();
		//System.out.println("resolveTemple");
		return sb.toString();
	}
	
	//这里面填充代码
	protected  void resolveLogic(){
		
	}

	protected void println(Object str) {
		sb.append(str).append("\n");
	}

	protected void print(Object str) {
		sb.append(str);
	}

}
