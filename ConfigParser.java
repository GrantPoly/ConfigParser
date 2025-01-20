import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigParser {
    private String filePath;
    private HashMap<String, String> configMap  = new HashMap<>();

    public ConfigParser(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
	}
    
    public void setConfigMap() {
	//Read config file and separate key value pairs
		try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
				if(line.contains("=")) {
					String trimmed = line.replaceAll("\\s", "");
					String delimiter = "=";
					String[] split = trimmed.split(delimiter);
					
					this.configMap.put(split[0], split[1]);
				}
            }
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key) {
		return this.configMap.get(key);
	}
}

