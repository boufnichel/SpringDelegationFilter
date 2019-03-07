package com.boufnichel.hybris.filter;

/**
 * @author boufnichel
 */
public interface Delegable {
  default boolean isDelegable() {return false;};
}
