
import utils.Constants;
import utils.XMLHelper;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        XMLHelper xmlHelper;
        try {
            xmlHelper = new XMLHelper(Constants.CONFIG_FILE_PATH);
            System.out.println("XML file loaded successfully.");
            System.out.println(xmlHelper.getValueByXPath("//environment[@name='QA']/url"));
        } catch (Exception e) {
            System.err.println("Error loading XML file: " + e.getMessage());
        }
    }
}
