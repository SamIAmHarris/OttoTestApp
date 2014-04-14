package com.samiamharris.ottotestapp;

import com.squareup.otto.Bus;

/**
 * Created by samharris on 4/12/14.
 */
public class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances.
    }
}
