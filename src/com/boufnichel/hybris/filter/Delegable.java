package com.chanel.hybris.fnb.ecom.saml.filter;

/**
 * @author boufnichel
 */
public interface Delegable {
  default boolean isDelegable() {return false;};
}
