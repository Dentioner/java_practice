package others;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 初始化城市数据
 * main方法
 * @author Frank CHEN
 *
 */
public class Driver {
    private ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
           new City(116.41667, 39.91667, "北京"),
            new City(121.43333, 34.50000, "上海"),
            new City(113.00000, 28.21667, "长沙"),
            new City(106.26667, 38.46667, "银川"),
            new City(109.50000, 18.20000, "三亚"),
            new City(112.53333, 37.86667, "太原"),
            new City(91.00000, 29.60000, "拉萨"),
            new City(102.73333,  25.05000, "昆明"),
            new City(126.63333, 45.75000, "哈尔滨"),
            new City(113.65000, 34.76667, "郑州"),
            new City(131.43233, 38.50000, "下海"),
            new City(119.00000, 58.21667, "短沙"),
            new City(146.26667, 88.46667, "金川"),
            new City(159.50000, 28.20000, "三冠"),
            new City(67.53333, 27.86667, "太本"),
            new City(101.00000, 89.60000, "拖萨"),
            new City(72.73333,  95.05000, "昆暗"),
            new City(176.63233, 75.75000, "呵尔滨"),
            new City(63.65000, 54.76667, "邓洲"),
            new City(113.50000, 22.20000, "澳门")));

/*            new City(116, 39, "北京"),
            new City(121, 34, "上海"),
            new City(113, 28, "长沙"),
            new City(106, 38, "银川"),
            new City(109, 18, "三亚"),
            new City(112, 37, "太原"),
            new City(91, 29, "拉萨"),
            new City(102,  25, "昆明"),
            new City(126, 45, "哈尔滨"),
            new City(113, 34, "郑州"),
            new City(113, 22, "澳门")));
*/

    public static void main(String[] args) {

        long startTime =  System.currentTimeMillis();
        Driver driver = new Driver();
        Route route = new Route(driver.initialCities);
        new HillClimbing().findShortestRoute(route);

        long endTime =  System.currentTimeMillis();
        long usedTime = (endTime-startTime);

        System.out.println(usedTime);
    }
}