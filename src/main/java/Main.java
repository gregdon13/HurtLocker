import org.apache.commons.io.IOUtils;

import javax.swing.plaf.IconUIResource;
import java.io.IOException;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        ListCreator listCreator = new ListCreator(output);
        Counter counter = new Counter();
        counter.countInstances();
        System.out.println(listCreator.groceryArraylist);
        System.out.println(counter.mapMaker.listCreator.groceryMapList);
        System.out.println(counter.output);
    }
}
