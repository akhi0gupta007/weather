package org.api.weather.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.api.weather.model.WeatherData;
import org.api.weather.utils.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherApi implements WeatherService {

	private String dateRecorded;

	public String findCoolestDayByZip(String zip) {

		String urlText = String.format(
				"https://api.openweathermap.org/data/2.5/forecast?zip=%s&appid=8f1dc1ab16471bc8885d887a680412a5&units=metric", zip);
		String inline = "";
		List<WeatherData> list = new ArrayList<>();
		String cityName = null;
		try {
			URL url = new URL(urlText);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			// Scanner functionality will read the JSON data from the stream
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				inline += sc.nextLine();
			}
			// Close the stream when reading the data has been finished
			sc.close();

			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject) parse.parse(inline);

			JSONArray jsonArray = (JSONArray) jobj.get("list");
			JSONObject jcityobj = (JSONObject) jobj.get("city");
			cityName = (String) jcityobj.get("name");

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonList = (JSONObject) jsonArray.get(i);
				JSONObject jsonMain = (JSONObject) jsonList.get("main");
				dateRecorded = (String) jsonList.get("dt_txt");
				Date weatherTimeStamp = Utils.formatDate(dateRecorded);
				Date tommorow = Utils.getTomorrowDate(new Date());
				Date today = Utils.getTodayDate(new Date());

				if (weatherTimeStamp.before(today) || weatherTimeStamp.after(tommorow)) {
					continue;
				}

				Double minTemp = (Double) jsonMain.get("temp_min");
				Double maxTemp = (Double) jsonMain.get("temp_max");
				WeatherData data = new WeatherData(zip);
				data.setTemp_max(maxTemp);
				data.setTemp_min(minTemp);
				data.setTimestamp(weatherTimeStamp);
				list.add(data);

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!list.isEmpty()) {
			Optional<WeatherData> leastTemp = list.stream()
					.sorted((w1, w2) -> w1.getTemp_min().compareTo(w2.getTemp_min())).findFirst();

			if (leastTemp.isPresent()) {
				return String.format(
						"The coolest hour in %s wil be at %s and the minimum temparature would be about %4.3f degrees Celsius ",
						cityName, Utils.getHour(leastTemp.get().getTimestamp()), leastTemp.get().getTemp_min());
			} else {
				return "No data found";
			}

		} else {
			return "No data found";
		}
	}

}
