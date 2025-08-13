#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass any JVM options to Gradle and Java processes.
# For more information, see https://docs.gradle.org/current/userguide/build_environment.html
DEFAULT_JVM_OPTS=""

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "ERROR: $*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
nonstop=false
case "`uname`" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
  NONSTOP* )
    nonstop=true
    ;;
esac

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`"/$link"
    fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/" >/dev/null
APP_HOME="`pwd -P`"
cd "$SAVED" >/dev/null

# Add a second backslash to variables coming from the OS
# just in case they have a single backslash in their definition
if $cygwin || $msys; then
    APP_HOME=`echo $APP_HOME | sed 's/\\/\\\\/g'`
    CLASSPATH=`echo $CLASSPATH | sed 's/\\/\\\\/g'`
    JAVA_HOME=`echo $JAVA_HOME | sed 's/\\/\\\\/g'`
fi

# For Cygwin, ensure paths are in UNIX format before anything is touched
if $cygwin ; then
    [ -n "$APP_HOME" ] &&
        APP_HOME=`cygpath --unix "$APP_HOME"`
    [ -n "$JAVA_HOME" ] &&
        JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
fi

# Locate the Wrapper Jar
WRAPPER_JAR="${APP_HOME}/gradle/wrapper/gradle-wrapper.jar"

# Locate the Wrapper Properties
WRAPPER_PROPERTIES="${APP_HOME}/gradle/wrapper/gradle-wrapper.properties"

# Read wrapper properties
if [ -f "$WRAPPER_PROPERTIES" ]; then
  while IFS= read -r line || [ -n "$line" ]
  do
    case $line in
      distributionUrl=*)
        distributionUrl=${line#*=}
        ;;
    esac
  done < "$WRAPPER_PROPERTIES"
fi

# The relative path to the distribution, if not specified in wrapper properties
if [ -z "$distributionUrl" ]; then
    distributionUrl="https://services.gradle.org/distributions/gradle-8.2.0-bin.zip"
fi

# For Cygwin, switch paths to Windows format before running java
if $cygwin ; then
    [ -n "$APP_HOME" ] &&
        APP_HOME=`cygpath --windows "$APP_HOME"`
    [ -n "$JAVA_HOME" ] &&
        JAVA_HOME=`cygpath --windows "$JAVA_HOME"`
    [ -n "$CLASSPATH" ] &&
        CLASSPATH=`cygpath --path --windows "$CLASSPATH"`
fi

if [ -z "$JAVA_HOME" ] ; then
    # Fallback to JAVA_HOME from java command
    JAVA_HOME=$(java -XshowSettings:properties -version 2>&1 | awk '/java.home/ {print $3}')
fi

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Set default CLASSPATH
if [ -z "$CLASSPATH" ] ; then
    CLASSPATH="$WRAPPER_JAR"
fi

# Set standard commands for invoking Java.
# -Djava.awt.headless=true prevents issues on systems without graphics
# -Dorg.gradle.appname=gradlew sets the process name in `ps`
# -DdistributionUrl is used by the wrapper
exec "$JAVACMD" \
    -Djava.awt.headless=true \
    -Dorg.gradle.appname="$APP_BASE_NAME" \
    -DdistributionUrl="$distributionUrl" \
    -classpath "$CLASSPATH" \
    org.gradle.wrapper.GradleWrapperMain "$@"
