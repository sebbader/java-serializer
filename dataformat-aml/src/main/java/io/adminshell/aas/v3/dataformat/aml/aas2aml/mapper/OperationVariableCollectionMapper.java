/*
 * Copyright (c) 2021 Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e. V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.adminshell.aas.v3.dataformat.aml.aas2aml.mapper;

import io.adminshell.aas.v3.dataformat.aml.AmlGenerator;
import io.adminshell.aas.v3.dataformat.aml.aas2aml.Aas2AmlMappingContext;
import io.adminshell.aas.v3.dataformat.aml.model.caex.InternalElementType;
import io.adminshell.aas.v3.dataformat.mapping.MappingException;
import io.adminshell.aas.v3.model.OperationVariable;
import java.util.Collection;

public class OperationVariableCollectionMapper extends DefaultCollectionMapper<OperationVariable> {

    @Override
    public void map(Collection<OperationVariable> value, AmlGenerator generator, Aas2AmlMappingContext context) throws MappingException {
        if (value == null || value.isEmpty()) {
            return;
        }
        String name = context.getAttributeNamingStrategy().getName(
                value.getClass(),
                value,
                context.getProperty().getName());
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        InternalElementType.Builder builder = InternalElementType.builder()
                .withName(name)
                .withID(getId(value, generator, context))
                .withRoleRequirements(generator.roleRequirement("Operation" + name));
        for (OperationVariable element : value) {
            context
                    .withoutProperty()
                    .withoutIdCache()
                    .map(element, generator.with(builder));
        }
        generator.addInternalElement(builder.build());
    }
}
