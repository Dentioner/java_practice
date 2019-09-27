package others;

/**
 * 实现爬山算法
 * @author Frank CHEN
 *
 */
public class HillClimbing {
    // 最大迭代次数
    public static final int ITERATIONS_BEFORE_MAXIMUM = 1500;

    /**
     * 寻找最短路径
     * @param currentRoute
     * @return
     */
    public Route findShortestRoute(Route currentRoute) {
        Route adjacentRoute;
        int iterToMaximumCounter = 0;
        String compareRoutes = null;
        while(iterToMaximumCounter < ITERATIONS_BEFORE_MAXIMUM) {
            adjacentRoute = obtainAdjacentRoute(new Route(currentRoute));
            if(adjacentRoute.getTotalDistance() <= currentRoute.getTotalDistance()) {
                compareRoutes = "<= (更新)";
                iterToMaximumCounter = 0;
                currentRoute = new Route(adjacentRoute);
            } else {
                compareRoutes = "> (保持) - 迭代次数 # " + iterToMaximumCounter;
                iterToMaximumCounter++;
            }
            System.out.println("       | " + compareRoutes);
            System.out.print(currentRoute + " |      " + currentRoute.getTotalStringDistance());
        }

        System.out.println("       | 可能的最优解");

        return currentRoute;
    }

    /**
     * 随机交换两个城市位置
     * @param route
     * @return
     */
    public Route obtainAdjacentRoute(Route route) {
        int x1 = 0, x2 = 0;
        while(x1 == x2) {
            x1 = (int) (route.getCities().size() * Math.random());
            x2 = (int) (route.getCities().size() * Math.random());
        }

        City city1 = route.getCities().get(x1);
        City city2 = route.getCities().get(x2);

        // swap two stochastic cities
        route.getCities().set(x2, city1);
        route.getCities().set(x1, city2);
        return route;
    }
}