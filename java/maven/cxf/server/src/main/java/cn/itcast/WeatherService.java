package cn.itcast;

public class WeatherService implements IweatherService {
	/**
	 * 返回相应的天气
	 */
	@Override
	public String info(String city) {
		if("北京".equals(city))
			return "雾霾";
		return "晴天";
	}

}
