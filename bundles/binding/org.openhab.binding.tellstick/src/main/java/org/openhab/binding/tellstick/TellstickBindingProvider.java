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
package org.openhab.binding.tellstick;

import java.util.EventListener;

import org.openhab.binding.tellstick.internal.device.SupportedMethodsException;
import org.openhab.binding.tellstick.internal.device.TellstickDevice;
import org.openhab.core.binding.BindingProvider;

/**
 * This interface provides the methods for getting the openhab configuration for
 * the tellstick binding.
 *
 * @author jarlebh
 * @since 1.5.0
 */
public interface TellstickBindingProvider extends BindingProvider {
    /**
     * Get the binding configuration for a given item.
     * 
     * @param itemName
     * @return the config
     */
    TellstickBindingConfig getTellstickBindingConfig(String itemName);

    /**
     * Get the binding configuration for a given deviceID (sensorId) and a given
     * type of value (Temp/Humid)
     * 
     * @param id
     * @param valueSel
     * @return The config.
     */
    TellstickBindingConfig getTellstickBindingConfig(int id, TellstickValueSelector valueSel, String protocol);

    /**
     * Get a device given its name.
     * 
     * @param itemName
     * @return The device.
     */
    TellstickDevice getDevice(String itemName);

    /**
     * Add a listener to Telldus Center for events.
     * 
     * @param changeListener
     */
    void addListener(EventListener changeListener);

    /**
     * Reset the tellstick as if openhab was restarted, need for linux hangups.
     * 
     * @throws SupportedMethodsException
     */
    void resetTellstickListener() throws SupportedMethodsException;

    /**
     * Remove the listeners to telldus center.
     */
    void removeTellstickListener();
}
