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
package org.openhab.binding.weather.internal.provider;

import org.openhab.binding.weather.internal.model.ProviderName;
import org.openhab.binding.weather.internal.parser.JsonWeatherParser;

/**
 * Hamweather weather provider.
 *
 * @author Gerhard Riegler
 * @since 1.6.0
 */
public class HamweatherProvider extends AbstractWeatherProvider {
    private static final String URL = "http://api.aerisapi.com/batch?p=[LATITUDE],[LONGITUDE]&requests=/observations,/forecasts%3Ffilter=day%26to=+5days&client_id=[API_KEY]&client_secret=[API_KEY_2]";

    public HamweatherProvider() {
        super(new JsonWeatherParser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProviderName getProviderName() {
        return ProviderName.HAMWEATHER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getWeatherUrl() {
        return URL;
    }

}
