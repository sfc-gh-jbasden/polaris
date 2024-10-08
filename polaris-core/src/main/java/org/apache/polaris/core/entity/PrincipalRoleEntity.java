/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.polaris.core.entity;

import org.apache.polaris.core.admin.model.PrincipalRole;

/**
 * Wrapper for translating between the REST PrincipalRole object and the base PolarisEntity type.
 */
public class PrincipalRoleEntity extends PolarisEntity {
  public PrincipalRoleEntity(PolarisBaseEntity sourceEntity) {
    super(sourceEntity);
  }

  public static PrincipalRoleEntity of(PolarisBaseEntity sourceEntity) {
    if (sourceEntity != null) {
      return new PrincipalRoleEntity(sourceEntity);
    }
    return null;
  }

  public static PrincipalRoleEntity fromPrincipalRole(PrincipalRole principalRole) {
    return new Builder()
        .setName(principalRole.getName())
        .setProperties(principalRole.getProperties())
        .build();
  }

  public PrincipalRole asPrincipalRole() {
    PrincipalRole principalRole =
        new PrincipalRole(
            getName(),
            getPropertiesAsMap(),
            getCreateTimestamp(),
            getLastUpdateTimestamp(),
            getEntityVersion());
    return principalRole;
  }

  public static class Builder extends PolarisEntity.BaseBuilder<PrincipalRoleEntity, Builder> {
    public Builder() {
      super();
      setType(PolarisEntityType.PRINCIPAL_ROLE);
      setCatalogId(PolarisEntityConstants.getNullId());
      setParentId(PolarisEntityConstants.getRootEntityId());
    }

    public Builder(PrincipalRoleEntity original) {
      super(original);
    }

    @Override
    public PrincipalRoleEntity build() {
      return new PrincipalRoleEntity(buildBase());
    }
  }
}
