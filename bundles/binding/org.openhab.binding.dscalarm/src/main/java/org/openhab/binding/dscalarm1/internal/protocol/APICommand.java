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
package org.openhab.binding.dscalarm1.internal.protocol;

/**
 * Class to create a API Command string
 * 
 * @author Russell Stephens
 * @author Donn Renk
 * @since 1.6.0
 */
public class APICommand {

    private String apiCommand;
    private String apiData;
    private String apiChecksum;
    private String apiTerminator = "\r\n";

    /**
     * Basic constructor to create an API Command
     */
    APICommand() {
    }

    /**
     * Returns the API Command
     * 
     * @return
     */
    public String getAPICommand() {
        StringBuffer apiCommandSB = new StringBuffer();

        apiCommandSB.append(apiCommand);
        apiCommandSB.append(apiData);
        apiCommandSB.append(apiChecksum);
        apiCommandSB.append(apiTerminator);

        return apiCommandSB.toString();
    }

    /**
     * Sets a new API command
     * 
     * @param command
     * @param data
     */
    public void setAPICommand(String command, String data) {
        this.apiCommand = command;
        this.apiData = data;
        calculateChecksum();

    }

    /**
     * Calculates the API checksum
     */
    private void calculateChecksum() {
        int checkSum;
        int runningTotal = 0;
        apiChecksum = "ZZ";

        for (byte s : apiCommand.getBytes()) {
            runningTotal = s + runningTotal;
        }
        for (byte s : apiData.getBytes()) {
            runningTotal = s + runningTotal;
        }

        checkSum = runningTotal;
        String hexCheckSum = Integer.toHexString(checkSum);
        hexCheckSum = hexCheckSum.substring(hexCheckSum.length() - 2).toUpperCase();

        apiChecksum = hexCheckSum;
    }

    @Override
    public String toString() {
        return getAPICommand();
    }
}
