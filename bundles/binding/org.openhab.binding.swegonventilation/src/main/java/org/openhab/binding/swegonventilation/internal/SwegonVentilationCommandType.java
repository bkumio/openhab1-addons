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
package org.openhab.binding.swegonventilation.internal;

import java.io.InvalidClassException;

import org.openhab.core.items.Item;
import org.openhab.core.library.items.NumberItem;
import org.openhab.core.library.items.SwitchItem;

/**
 * Represents all valid command types which could be processed by this binding.
 *
 * @author Pauli Anttila
 * @since 1.4.0
 */
public enum SwegonVentilationCommandType {

    T1("T1", NumberItem.class), // Temperature sensor, outdoor air
    T2("T2", NumberItem.class), // Temperature sensor, supply air
    T3("T3", NumberItem.class), // Temperature sensor, extract air
    T4("T4", NumberItem.class), // Temperature sensor, supply air, re-heating
    T5("T5", NumberItem.class),
    T6("T6", NumberItem.class), // The freeze protection sensor of the water-heated air heater
    T7("T7", NumberItem.class), // Excess temperature sensor for the pre-heating air heater
    T8("T8", NumberItem.class), // Temperature sensor, exhaust air, freeze protection
    OUTDOOR_TEMP("OutdoorTemperature", NumberItem.class), // T1
    SUPPLY_TEMP("SupplyAirTemperature", NumberItem.class), // T2
    EXTRACT_TEMP("ExtractAirTemperature", NumberItem.class), // T3
    SUPPLY_TEMP_HEATED("SupplyAirTemperatureReheated", NumberItem.class), // T4
    EXHAUST_TEMP("ExhaustAirTemperature", NumberItem.class), // T8
    SUPPLY_AIR_FAN_SPEED("SupplyAirFanSpeed", NumberItem.class),
    EXTRACT_AIR_FAN_SPEED("ExtractAirFanSpeed", NumberItem.class),
    EFFICIENCY("Efficiency", NumberItem.class),
    EFFICIENCY_SUPPLY("EfficiencySupply", NumberItem.class),
    EFFICIENCY_EXTRACT("EfficiencyExtract", NumberItem.class),
    FAN_SPEED("FanSpeed", NumberItem.class),
    PREHEAT_STATE("PreheatState", SwitchItem.class),
    REHEAT_STATE("ReheatState", SwitchItem.class),
    CO2("CO2", NumberItem.class),
    HUMIDITY("Humidity", NumberItem.class),
    OPERATING_MODE("OperatingMode", NumberItem.class),
    UNIT_STATE("UnitState", NumberItem.class),
    HEATING_STATE("HeatingState", SwitchItem.class),
    COOLING_STATE("CoolingState", SwitchItem.class),
    BYBASS_STATE("BybassState", SwitchItem.class),
    FREEZE_PROTECTION_STATE("FreezeProtectionState", SwitchItem.class),
    PREHEATING_STATE("PreheatingState", SwitchItem.class),
    CHILLING_STATE("ChillingState", SwitchItem.class),
    PREHEATER_OVERHEAT_STATE("PreheaterOverheatState", SwitchItem.class),
    REHEATING_STATE("ReheatingState", SwitchItem.class),
    FIREPLACE_FUNCTION_STATE("FireplaceFunctionState", SwitchItem.class),
    UNDERPRESSURE_COMPENSATION_STATE("UnderpressureCompensationState", SwitchItem.class),
    EXTERNAL_BOOST_STATE("ExternalBoostState", SwitchItem.class),
    HUMIDITY_BOOST_STATE("HumidityBoostState", SwitchItem.class),
    CO2_BOOST_STATE("CO2State", SwitchItem.class),
    DEFROSTING_STATE("DefrostingState", SwitchItem.class),
    DEFROST_STARTER_MODE("DefrostingStarterMode", NumberItem.class),
    TF_STOP_STATE("TFStopState", SwitchItem.class),
    EXTERNAL_BOOST_FUNCTION_STATE("ExternalBoostFunctionState", SwitchItem.class),
    EXTERNAL_FIREPLACE_FUNCTION_STATE("ExternalFireplaceFunctionState", SwitchItem.class),
    FILTER_GUARD_STATUS("FilterGuardStatus", SwitchItem.class),
    IR_FREEZE_PROTECTION_STATUS("IRFreezeProctionStatus", SwitchItem.class),
    EMERGENCY_STOP_STATE("EmergencyStopState", SwitchItem.class),
    REHEATING_FREEZING_ALARM("ReheatingFreezingAlarm", SwitchItem.class),
    REHEATING_OVERHEAT_ALARM("ReheatingOverheatAlarm", SwitchItem.class),
    IR_SENSOR_FAILURE("IRSensorFailure", SwitchItem.class),
    SUPPLY_FAN_FAILURE("SupplyFanFailure", SwitchItem.class),
    EXTRACT_FAN_FAILURE("ExtractFanFailure", SwitchItem.class),
    TEMPERATURE_DEVIATION_FAILURE("TemperatureDeviationFailure", SwitchItem.class),
    EFFICINECY_ALARM("EfficiencyAlarm", SwitchItem.class),
    FILTER_GUARD_ALARM("FilterGuardAlarm", SwitchItem.class),
    SERVICE_REMINDER("ServiceReminder", SwitchItem.class),
    TEMPERATURE_FAILURE("TemperatureFailure", SwitchItem.class),
    AFTERHEATING_SETPOINT_SUPPLY_AIR_REGULATED("AfterheatingSetpointSupplyAirRegulated", NumberItem.class),
    AFTERHEATING_SETPOINT_ROOM_REGULATED("AfterheatingSetpointRoomRegulated", NumberItem.class),
    SUPPLY_FAN_VIRTUAL_SPEED("SupplyFanVirtualSpeed", NumberItem.class),
    EXTRACT_FAN_VIRTUAL_SPEED("ExtractFanVirtualSpeed", NumberItem.class),
    UNIT_STATUS("UnitStatus", NumberItem.class);

    private final String text;
    private Class<? extends Item> itemClass;

    private SwegonVentilationCommandType(final String text, Class<? extends Item> itemClass) {
        this.text = text;
        this.itemClass = itemClass;
    }

    @Override
    public String toString() {
        return text;
    }

    public Class<? extends Item> getItemClass() {
        return itemClass;
    }

    /**
     * Procedure to validate command type string.
     *
     * @param commandTypeText
     *            command string e.g. T1
     * @return true if item is valid.
     * @throws IllegalArgumentException
     *             Not valid command type.
     * @throws InvalidClassException
     *             Not valid class for command type.
     */
    public static boolean validateBinding(String commandTypeText, Class<? extends Item> itemClass)
            throws IllegalArgumentException, InvalidClassException {

        for (SwegonVentilationCommandType c : SwegonVentilationCommandType.values()) {
            if (c.text.equals(commandTypeText)) {

                if (c.getItemClass().equals(itemClass)) {
                    return true;
                } else {
                    throw new InvalidClassException("Not valid class for command type");
                }
            }
        }

        throw new IllegalArgumentException("Not valid command type");

    }

    /**
     * Procedure to convert command type string to command type class.
     *
     * @param commandTypeText
     *            command string e.g. T1
     * @return corresponding command type.
     * @throws InvalidClassException
     *             Not valid class for command type.
     */
    public static SwegonVentilationCommandType getCommandType(String commandTypeText) throws IllegalArgumentException {

        for (SwegonVentilationCommandType c : SwegonVentilationCommandType.values()) {
            if (c.text.equals(commandTypeText)) {
                return c;
            }
        }

        throw new IllegalArgumentException("Not valid command type");
    }

}