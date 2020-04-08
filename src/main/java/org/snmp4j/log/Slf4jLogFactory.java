/*_############################################################################
  _## 
  _##  SNMP4J 2 - Slf4jLogFactory.java  
  _## 
  _##  Copyright (C) 2003-2016  Frank Fock and Jochen Katz (SNMP4J.org)
  _##  
  _##  Licensed under the Apache License, Version 2.0 (the "License");
  _##  you may not use this file except in compliance with the License.
  _##  You may obtain a copy of the License at
  _##  
  _##      http://www.apache.org/licenses/LICENSE-2.0
  _##  
  _##  Unless required by applicable law or agreed to in writing, software
  _##  distributed under the License is distributed on an "AS IS" BASIS,
  _##  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  _##  See the License for the specific language governing permissions and
  _##  limitations under the License.
  _##  
  _##########################################################################*/
package org.snmp4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.Collections;
import java.util.TreeMap;
import java.util.ArrayList;

/**
 * The <code>Slf4jLogFactory</code> implements a SNMP4J LogFactory for
 * SLF4J. In order to use SLF4J for logging SNMP4J log messages the
 * static {@link LogFactory#setLogFactory} method has to be used before
 * any (other) SNMP4J class is referenced or instantiated.
 *
 * @author Frank Fock
 * @version 1.6.1
 * @since 1.2.1
 */
public class Slf4jLogFactory extends LogFactory {
  private TreeMap<String, LogAdapter> loggers;

  public Slf4jLogFactory() {
    loggers = new TreeMap<String, LogAdapter>();
  }

  protected LogAdapter createLogger(Class c) {
    return createLogger(c.getName());
  }

  protected synchronized LogAdapter createLogger(String className) {
    if (loggers.containsKey(className)) {
      return loggers.get(className);
    } else {
      LogAdapter adapter = new Slf4jLogAdapter(LoggerFactory.getLogger(className));
      loggers.put(adapter.getName(), adapter);
      return adapter;
    }
  }

  @SuppressWarnings("unchecked")
  public Iterator loggers() {
    return loggers.values().iterator();
  }
}
