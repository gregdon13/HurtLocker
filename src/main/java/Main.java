import org.apache.commons.io.IOUtils;

import javax.swing.plaf.IconUIResource;
import java.io.IOException;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("justapples.txt"));
        return result;
    }



    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        ListCreator listCreator = new ListCreator(output);
        Counter counter = new Counter();
        listCreator.groceryMaker(output);
        counter.countInstances();
//        System.out.println(listCreator.groceryArraylist);
//        System.out.println(counter.mapMaker.listCreator.groceryMapList);
        System.out.println(counter.output);
    }
}
