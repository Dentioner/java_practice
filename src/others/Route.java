package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 路径实体类
 * @author Frank CHEN
 *
 */
public class Route {
    private ArrayList<City> cities = new ArrayList<>();

    /**
     * 构造方法
     * 随机打乱cities排序
     * @param cities
     */
    public Route(ArrayList<City> cities) {
        this.cities.addAll(cities);
        Collections.shuffle(this.cities);
    }

    public Route(Route route) {
        for(City city : route.getCities()) {
            this.cities.add(city);
        }
    }

    /**
     * 计算城市间总距离
     * @return
     */
    public double getTotalDistance() {
        int citiesSize = this.cities.size();
        double sum = 0D;
        int index = 0;
        while(index < citiesSize - 1) {
            sum += this.cities.get(index).measureDistance(this.cities.get(index + 1));
            index++;
        }
        sum += this.cities.get(citiesSize - 1).measureDistance(this.cities.get(0));
        return sum;
    }

    public String getTotalStringDistance() {
        String returnString = String.format("%.2f", this.getTotalDistance());
        return returnString;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return Arrays.toString(cities.toArray());
    }

}
