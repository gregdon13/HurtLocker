import org.apache.commons.io.IOUtils;

import javax.swing.plaf.IconUIResource;
import java.io.IOException;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }



    public static void main(String[] args) throws Exception{
        Counters counters = new Counters();
        String output = (new Main()).readRawDataToString();
        counters.rackEmUp(output);
        System.out.println(counters.tablePrintOut());

    }
}
