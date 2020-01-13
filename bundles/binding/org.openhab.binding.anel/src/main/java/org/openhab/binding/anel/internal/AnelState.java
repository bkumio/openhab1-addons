/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.anel.internal;

/**
 * This class is used to cache the device state in the binding to avoid spamming
 * the event bus on every refresh.
 *
 * @author paphko
 * @since 1.6.0
 */
public class AnelState {

    /** Device IP address / network name; fix value. */
    final String host;

    /** Device relay states; changeable. */
    final Boolean[] switchState = new Boolean[8];
    /** Device relay locked status; read-only. */
    final Boolean[] switchLocked = new Boolean[8];
    /** Device relay names; read-only. */
    final String[] switchName = new String[8];

    /** Device IO states; changeable if they are configures as input. */
    final Boolean[] ioState = new Boolean[8];
    /** Device IO input states; read-only. */
    final Boolean[] ioIsInput = new Boolean[8];
    /** Device IO names; read-only. */
    final String[] ioName = new String[8];

    /** Device name; read-only. */
    String name = null;
    /** Device temperature; read-only. */
    String temperature = null;

    /** Sensor temperature; read-only. */
    String sensorTemperature = null;
    /** Sensor Humidity; read-only. */
    String sensorHumidity = null;
    /** Sensor Brightness; read-only. */
    String sensorBrightness = null;

    /**
     * Create new internal state with default values <code>null</code> for the
     * specified IP address / network name.
     *
     * @param host
     *            The IP address / network name of an Anel device.
     */
    AnelState(String host) {
        if (host == null || host.trim().isEmpty()) {
            throw new IllegalArgumentException("argument must not be null or empty");
        }
        this.host = host;
    }

    /**
     * Clear all cached values.
     */
    void clear() {
        for (int i = 0; i < 8; i++) {
            switchState[i] = null;
            switchLocked[i] = null;
            switchName[i] = null;
            ioState[i] = null;
            ioIsInput[i] = null;
            ioName[i] = null;
        }
        name = null;
        temperature = null;
    }
}
