/*_############################################################################
  _## 
  _##  SNMP4J 2 - LogLevel.java  
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

public enum LogLevel {
    NONE(0),
    OFF(1),
    ALL(2),
    TRACE(3),
    DEBUG(4),
    INFO(5),
    WARN(6),
    ERROR(7),
    FATAL(8);

    private int level;

    private LogLevel(int level) {
        if ((level < 0) || (level > 8)) {
            throw new IllegalArgumentException("Unknown log level "+level);
        }
        this.level = level;
    }

    /**
     * Convert a level string "OFF", "ALL", "DEBUG", etc. into a level number.
     * @param levelString
     *    one of the level strings "OFF", "ALL", "TRACE", "DEBUG", "INFO", "WARN",
     *    "INFO", "ERROR", and "FATAL".
     * @return
     *    a number greater than zero if the level string could be converted into a level,
     *    zero otherwise.
     */
    public static int levelFromString(String levelString) {
        for (LogLevel ll : values()) {
            if (levelString.equals(ll.toString())) {
                return ll.getLevel();
            }
	}
        throw new IllegalArgumentException(levelString);
    }

    /**
     * Returns a {@code LogLevel} object for the specified level string.
     * @param levelString
     *    one of the level strings "OFF", "ALL", "TRACE", "DEBUG", "INFO", "WARN",
     *    "ERROR", and "FATAL".
     * @return
     *    one of the {@code LogLevel} constants defined by this class.
     * @since 1.7.2
     */
    public static LogLevel toLevel(String levelString) {
        for (LogLevel ll : values()) {
            if (levelString.equals(ll.toString())) {
                return ll;
            }
	}
        throw new IllegalArgumentException(levelString);
    }

    public static LogLevel toLevel(int level) {
        for (LogLevel ll : values()) {
            if (ll.level == level) {
                return ll;
            }
	}
        throw new IllegalArgumentException(Integer.toString(level));
    }

    public int getLevel() {
        return level;
    }
}
