package org.teacup.core;

import java.lang.reflect.Field;

enum Utils {
  ;

  static Object getField(Class<?> clazz, Object instance, String name)
      throws IllegalAccessException, NoSuchFieldException {
    return getAccessibleField(clazz, name).get(instance);
  }

  static void setField(Class<?> clazz, Object instance, String name, Object value)
      throws IllegalAccessException, NoSuchFieldException {
    getAccessibleField(clazz, name).set(instance, value);
  }

  private static Field getAccessibleField(Class<?> clazz, String name) throws NoSuchFieldException {
    var field = clazz.getDeclaredField(name);
    field.setAccessible(true);

    return field;
  }
}
