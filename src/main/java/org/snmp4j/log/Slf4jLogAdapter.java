/*_############################################################################
  _## 
  _##  SNMP4J 2 - Slf4jLogAdapter.java  
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

import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Handler;

import org.snmp4j.util.EnumerationIterator;

/**
 * The <code>Slf4jLogAdapter</code> implements a logging adapter for SLF4J Loggers.
 *
 * @author Frank Fock
 * @version 1.10
 * @since 1.2.1
 */
public class Slf4jLogAdapter implements LogAdapter, Comparable {

  private final Logger logger;

  /**
   * Creates a Slf4J log adapter from a SLF4J Logger.
   * @param logger
   *    the SLF4J Logger to use with this adapter.
   * @since 1.2.1
   */
  public Slf4jLogAdapter(Logger logger) {
    this.logger = logger;
  }

  public Logger getLogger() {
    return logger;
  }

  // Implement LogAdapter

  public void debug(Serializable message) {
    logger.debug(toString(message));
  }

  public void error(Serializable message) {
    logger.error(toString(message));
  }

  public void error(CharSequence message, Throwable throwable) {
    logger.error(message.toString(), throwable);
  }

  public void info(CharSequence message) {
    logger.info(message.toString());
  }

  public boolean isDebugEnabled() {
    return logger.isDebugEnabled();
  }

  public boolean isInfoEnabled() {
    return logger.isInfoEnabled();
  }

  public boolean isWarnEnabled() {
    return logger.isWarnEnabled();
  }

  public void warn(Serializable message) {
    logger.warn(toString(message));
  }

  public void fatal(Object message) {
    logger.error(toString(message));
  }

  public void fatal(CharSequence message, Throwable throwable) {
    logger.error(message.toString(), throwable);
  }

  public String getName() {
    return logger.getName();
  }

  // Implement Comparable

  public int compareTo(Object o) {
    return getName().compareTo(((Slf4jLogAdapter)o).getName());
  }

  // Private

  private String toString(Object obj) {
    if (obj instanceof String) {
      return (String)obj;
    } else {
      return obj.toString();
    }
  }
}
