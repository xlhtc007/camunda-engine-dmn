/*
 * Copyright © 2015-2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.dmn.engine.impl.hitpolicy;

import org.camunda.bpm.dmn.engine.DmnEngineException;

/**
 * Exception throw if a hit policy is not applicable for a
 * decision result.
 */
public class DmnHitPolicyException extends DmnEngineException {

  public DmnHitPolicyException(String message) {
    super(message);
  }

  public DmnHitPolicyException(String message, Throwable cause) {
    super(message, cause);
  }

}
