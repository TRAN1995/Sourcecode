import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private static Properties configProperties;

	static {
		loadConfigurationData();
	}

	public static String getParam(String key) {
		if (configProperties != null) {
			return configProperties.getProperty(key);
		}
		return null;
	}

	private static void loadConfigurationData() {
		try {

			InputStream is = Configuration.class.getClassLoader()
					.getResourceAsStream(
							"config.properties");

			if (is != null) {
				configProperties = new Properties();
				configProperties.load(is);
			}
		} catch (IOException e) {
			System.err
					.println("ECMAPI > Configuration > getConfigurationData: "
							+ e.toString());
		}
	}

}