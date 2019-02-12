package org.teacup.core;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Useful utility methods.
 *
 * @since 1.0
 */
public enum Utils {
  ;

  private static final int FINAL = -17;
  private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

  /**
   * Sets the value of a field.
   *
   * @param clazz the class
   * @param instance the instance
   * @param name the name
   * @param value the value
   * @throws IllegalAccessException if illegal access
   * @throws NoSuchFieldException if no such field
   */
  public static void setField(Class<?> clazz, Object instance, String name, Object value)
      throws IllegalAccessException, NoSuchFieldException {
    LOGGER.log(Level.FINE, "Setting field " + name + " in " + clazz.getName());
    getAccessibleField(clazz, name).set(instance, value);
  }

  static Object getField(Class<?> clazz, Object instance, String name)
      throws IllegalAccessException, NoSuchFieldException {
    return getAccessibleField(clazz, name).get(instance);
  }

  private static Field getAccessibleField(Class<?> clazz, String name)
      throws IllegalAccessException, NoSuchFieldException {
    var field = clazz.getDeclaredField(name);
    field.setAccessible(true);

    var modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & FINAL);

    return field;
  }
}
