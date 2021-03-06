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
package org.camunda.bpm.dmn.feel.impl.juel.el;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.el.FunctionMapper;

import org.camunda.bpm.dmn.feel.impl.juel.FeelEngineLogger;
import org.camunda.bpm.dmn.feel.impl.juel.FeelLogger;

public class CompositeFunctionMapper extends FunctionMapper {

  public static final FeelEngineLogger LOG = FeelLogger.ENGINE_LOGGER;

  protected List<FunctionMapper> functionMappers = new ArrayList<FunctionMapper>();

  public Method resolveFunction(String prefix, String localName) {
    for (FunctionMapper functionMapper : functionMappers) {
      Method method = functionMapper.resolveFunction(prefix, localName);
      if (method != null) {
        return method;
      }
    }
    throw LOG.unknownFunction(prefix, localName);
  }

  public void setFunctionMappers(List<FunctionMapper> functionMappers) {
    this.functionMappers = functionMappers;
  }

  public void add(FunctionMapper functionMapper) {
    functionMappers.add(functionMapper);
  }

  public void remove(FunctionMapper functionMapper) {
    functionMappers.remove(functionMapper);
  }

}
