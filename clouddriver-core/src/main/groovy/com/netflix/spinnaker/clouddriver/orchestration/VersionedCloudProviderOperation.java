/*
 * Copyright 2020 Armory, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.spinnaker.clouddriver.orchestration;

import com.netflix.spinnaker.clouddriver.security.ProviderVersion;
import javax.annotation.Nullable;

public interface VersionedCloudProviderOperation {
  /**
   * Various operations can satisfy different provider's versions. This operation will only be
   * applicable to accounts at this version.
   *
   * @return true i.f.f. this operations works on accounts at this version
   */
  default boolean acceptsVersion(ProviderVersion version) {
    return ProviderVersion.v1.equals(version);
  }

  /**
   * Allows individual operations to be versioned.
   *
   * <p>A {@code version} may be null if no specific version is requested, which is the common case.
   *
   * @param version The operation version requested by the client
   * @return true if the operation works with the provided version
   */
  default boolean acceptsVersion(@Nullable String version) {
    return true;
  }
}
