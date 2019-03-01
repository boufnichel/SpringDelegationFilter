package com.boufnichel.hybris.filter;

import de.hybris.platform.util.Config;

/**
 * @author boufnichel
 * Example of condition to check for delegation
 */
public final class SSOCondition implements DelegationCondition {

  @Override
  public boolean verify() {
    return isConditionTrue();
  }

  private Boolean isConditionTrue(){
    return Config.getBoolean("mycondition.key",true);
  }
}
