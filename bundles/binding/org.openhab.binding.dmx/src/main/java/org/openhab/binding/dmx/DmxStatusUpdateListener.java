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
package org.openhab.binding.dmx;

/**
 * DMX Status update listener. Objects which implement this interface can
 * register them for receiving updates when a DMX channel value changes.
 *
 * @author Davy Vanherbergen
 * @since 1.2.0
 */
public interface DmxStatusUpdateListener {

    /**
     * @return channel for which to receive updates
     */
    public int getChannel();

    /**
     * @return number of channels to receive updates for
     */
    public int getFootPrint();

    /**
     * @return minimum delay in ms between updates
     */
    public int getUpdateDelay();

    /**
     * Callback for processing status updates.
     * 
     * @param channelValues
     *            updated values.
     */
    public void processStatusUpdate(int[] channelValues);

    /**
     * @return time last status update was sent
     */
    public long getLastUpdateTime();
}
