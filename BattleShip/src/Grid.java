public class Grid {

    //attributes
    Location[][] grid;

    //constructor
    public Grid(boolean[][] shipGrid) {
        grid = new Location[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new Location(shipGrid[i][j]);
            }
        }
    }

    boolean guess(int x, int y) {
        return grid[x][y].guess();
    }

    int getStatus(int x, int y) {
        return grid[x][y].getStatus();
    }

    class Location {

        //attributes
        boolean hasShip;
        boolean hasBeenGuessed = false;

        //constructor
        Location(boolean hasShip) {
            this.hasShip = hasShip;
        }

        // -1 = miss ; 0 = notGuessed ; 1 = hit
        int getStatus() {
            if (!hasBeenGuessed) {
                return 0;
            } else {
                if (hasShip) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        //make guess
        boolean guess() {
            hasBeenGuessed = true;
            return hasShip;
        }
    }

}
