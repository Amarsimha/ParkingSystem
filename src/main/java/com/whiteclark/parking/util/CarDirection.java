package com.whiteclark.parking.util;


import java.util.HashMap;
import java.util.Map;

public enum CarDirection {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private static Map<Integer, CarDirection> map = new HashMap<Integer, CarDirection>();

    static {
        for (CarDirection directionEnum : CarDirection.values()) {
            map.put(directionEnum.directionIndex, directionEnum);
        }
    }

    private int directionIndex;

    private CarDirection(int direction) {
        this.directionIndex = direction;
    }

    public static CarDirection valueOf(int directionNum) {
        return map.get(directionNum);
    }

    /**
     * Returns the direction on the left of the current one
     */
    public CarDirection leftDirection() {
        return rotate(-1);
    }

    /**
     * Returns the direction on the right of the current one
     */
    public CarDirection rightDirection() {
        return rotate(1);
    }

    private CarDirection rotate(int step) {

        int newIndex = (this.directionIndex + step) < 0 ?
                map.size() - 1 :
                (this.directionIndex + step) % map.size();

        return CarDirection.valueOf(newIndex);
    }

}
