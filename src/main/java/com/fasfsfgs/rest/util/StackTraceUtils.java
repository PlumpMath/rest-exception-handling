package com.fasfsfgs.rest.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTraceUtils {

  public static String getStringFromStackTrace(Throwable exception) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    exception.printStackTrace(pw);
    return sw.toString();
  }

}
