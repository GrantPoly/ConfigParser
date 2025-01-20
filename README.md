# ConfigParser
A Java configuration file parser

Example Code:

public class ConfigParserTest {

    public static void main(String[] args) {
        ConfigParser myParser = new ConfigParser("config.ini");
        System.out.println(myParser.getFilePath());
        myParser.setConfigMap();
        String sales = myParser.getValue("customers");
        System.out.println(sales);
    }
}
