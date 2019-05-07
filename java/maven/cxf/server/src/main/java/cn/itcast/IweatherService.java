package cn.itcast;

import javax.jws.WebService;

/**
 * 天气服务接口
 * @author baifeng
 *
 */
@WebService
public interface IweatherService {
	/**
	 * 查询天气
	 * @param city
	 * @return
	 */
	String info (String city);
}
