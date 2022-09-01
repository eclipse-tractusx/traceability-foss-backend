/********************************************************************************
 * Copyright (c) 2021,2022 Contributors to the CatenaX (ng) GitHub Organisation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

package net.catenax.traceability.assets.infrastructure.adapters.cache.bpn;

import net.catenax.traceability.assets.infrastructure.config.cache.BpnCacheProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BpnCaffeineCache implements BpnCache {

	private final Cache cache;

	public BpnCaffeineCache(CacheManager cacheManager, BpnCacheProperties bpnCacheProperties) {
		this.cache = cacheManager.getCache(bpnCacheProperties.getName());
	}

	@Override
	public void put(BpnMapping bpnMapping) {
		cache.put(bpnMapping.bpn(), bpnMapping.companyName());
	}

	@Override
	public Optional<String> getCompanyName(String bpn) {
		return Optional.ofNullable(cache.get(bpn, String.class));
	}

	@Override
	public void clear() {
		cache.clear();
	}
}