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
/**
 */
package org.openhab.binding.tinkerforge.internal.model;

import com.tinkerforge.BrickletPiezoSpeaker;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MBricklet Piezo Speaker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.openhab.binding.tinkerforge.internal.model.MBrickletPiezoSpeaker#getDeviceType <em>Device Type</em>}
 * </li>
 * </ul>
 *
 * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getMBrickletPiezoSpeaker()
 * @model superTypes="org.openhab.binding.tinkerforge.internal.model.MDevice
 *        <org.openhab.binding.tinkerforge.internal.model.TinkerBrickletPiezoSpeaker>
 *        org.openhab.binding.tinkerforge.internal.model.ProgrammableSwitchActor"
 * @generated
 */
public interface MBrickletPiezoSpeaker extends MDevice<BrickletPiezoSpeaker>, ProgrammableSwitchActor {
    /**
     * Returns the value of the '<em><b>Device Type</b></em>' attribute.
     * The default value is <code>"bricklet_piezo_speaker"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Device Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Device Type</em>' attribute.
     * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getMBrickletPiezoSpeaker_DeviceType()
     * @model default="bricklet_piezo_speaker" unique="false" changeable="false"
     * @generated
     */
    String getDeviceType();

} // MBrickletPiezoSpeaker
