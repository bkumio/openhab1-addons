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
package org.openhab.binding.ihc.ws.datatypes;

/**
 * <p>
 * Java class for WSWeekdayValue complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="WSWeekdayValue">
 *   &lt;complexContent>
 *     &lt;extension base="{utcs.values}WSResourceValue">
 *       &lt;sequence>
 *         &lt;element name="weekdayNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */

public class WSWeekdayValue extends WSResourceValue {

    protected int weekdayNumber;

    /**
     * Gets the value of the weekdayNumber property.
     * 
     */
    public int getWeekdayNumber() {
        return weekdayNumber;
    }

    /**
     * Sets the value of the weekdayNumber property.
     * 
     */
    public void setWeekdayNumber(int value) {
        this.weekdayNumber = value;
    }

}
