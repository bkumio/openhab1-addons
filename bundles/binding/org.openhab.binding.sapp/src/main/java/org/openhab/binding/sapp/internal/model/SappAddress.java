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
package org.openhab.binding.sapp.internal.model;

/**
 * Generic Address model
 *
 * @author Paolo Denti
 * @since 1.8.0
 *
 */
public abstract class SappAddress {

    private String pnmasId;
    private SappAddressType addressType;
    private int address;
    private String subAddress;

    /**
     * Constructor
     */
    public SappAddress(String pnmasId, SappAddressType addressType, int address, String subAddress) {
        super();
        this.pnmasId = pnmasId;
        this.addressType = addressType;
        this.address = address;
        this.subAddress = subAddress;
    }

    /**
     * pnmasId getter
     */
    public String getPnmasId() {
        return pnmasId;
    }

    /**
     * addressType getter
     */
    public SappAddressType getAddressType() {
        return addressType;
    }

    /**
     * address getter
     */
    public int getAddress() {
        return address;
    }

    /**
     * subAddress getter
     */
    public String getSubAddress() {
        return subAddress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("[ %s:%s:%d:%s ]", pnmasId, addressType, address, subAddress);
    }
}
