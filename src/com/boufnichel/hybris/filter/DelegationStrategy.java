package com.chanel.hybris.fnb.ecom.saml.filter;

import java.util.List;

/**
 * @author boufnichel
 */
public final class DelegationStrategy implements Delegable{

  private List<DelegationCondition> conditions;

  public boolean isDelegable() {
    return conditions.stream()
        .allMatch(condition -> Boolean.TRUE.equals(condition.verify()));
  };

  public void setConditions(
      List<DelegationCondition> conditions) {
    this.conditions = conditions;
  }
}
