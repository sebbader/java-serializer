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
package io.adminshell.aas.v3.dataformat.aml.fixtures;

import io.adminshell.aas.v3.dataformat.core.ReflectionHelper;
import io.adminshell.aas.v3.dataformat.core.deserialization.EnumDeserializer;
import io.adminshell.aas.v3.model.*;
import io.adminshell.aas.v3.model.impl.*;

import java.util.Arrays;

public class TestExample {

    public static final java.io.File FILE = new java.io.File("src/test/resources/amlfile/example_test.aml");

    private static KeyElements resolveKeyElement(Class<?> type) {
        String potentialEnumName = EnumDeserializer.translate(ReflectionHelper.getAasInterface(type).getSimpleName());
        return KeyElements.valueOf(potentialEnumName);
    }

    private static final Reference asReference(Identifiable identifiable) {
        return new DefaultReference.Builder()
                .key(new DefaultKey.Builder()
                        .idType(KeyType.IRI)
                        .type(resolveKeyElement(identifiable.getClass()))
                        .value(identifiable.getIdentification().getIdentifier())
                        .build())
                .build();
    }

    public static final Submodel SUBMODEL_1 = new DefaultSubmodel.Builder()
            .idShort("Identification")
            .description(new LangString("An example asset identification submodel for the test application", "en-us"))
            .description(new LangString("Ein Beispiel-Identifikations-Submodel für eine Test-Anwendung", "de"))
            .identification(new DefaultIdentifier.Builder()
                    .idType(IdentifierType.IRI)
                    .identifier("http://acplt.org/Submodels/Assets/TestAsset/Identification")
                    .build())
            .administration(new DefaultAdministrativeInformation.Builder()
                    .version("0.9")
                    .revision("0")
                    .build())
            .kind(ModelingKind.INSTANCE)
            .semanticId(new DefaultReference.Builder()
                    .key(new DefaultKey.Builder()
                            .type(KeyElements.SUBMODEL)
                            .idType(KeyType.IRI)
                            .value("http://acplt.org/SubmodelTemplates/AssetIdentification")
                            .build())
                    .build())
            .submodelElement(new DefaultReferenceElement.Builder()
                    .idShort("ExampleReferenceElement")
                    .category("Parameter")
                    .description(new LangString("Example Reference Element object", "en-us"))
                    .description(new LangString("Beispiel Reference Element Element", "de"))
                    .semanticId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.GLOBAL_REFERENCE).value(
                                    "http://acplt.org/ReferenceElements/ExampleReferenceElement")
                                    .idType(KeyType.IRI)
                                    .build())
                            .build())
                    .value(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .idType(KeyType.IRI)
                                    .type(KeyElements.SUBMODEL)
                                    .value("http://acplt.org/Submodels/Assets/TestAsset/Identification")
                                    .build())
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.SUBMODEL_ELEMENT)
                                    .idType(KeyType.ID_SHORT)
                                    .value("ExampleOperation")
                                    .build())
                            .build())
                    .build())
            //            .submodelElement(new DefaultRelationshipElement.Builder()
            //                    .idShort("ExampleRelationshipElement")
            //                    .first(new DefaultReference.Builder()
            //                            .key(new DefaultKey.Builder()
            //                                    .idType(KeyType.IRI)
            //                                    .type(KeyElements.SUBMODEL)
            //                                    .value("http://acplt.org/Submodels/Assets/TestAsset/Identification")
            //                                    .build())
            //                            .key(new DefaultKey.Builder()
            //                                    .type(KeyElements.SUBMODEL_ELEMENT)
            //                                    .idType(KeyType.ID_SHORT)
            //                                    .value("ExampleOperation")
            //                                    .build())
            //                            .build())
            //                    .second(new DefaultReference.Builder()
            //                            .key(new DefaultKey.Builder()
            //                                    .idType(KeyType.IRI)
            //                                    .type(KeyElements.SUBMODEL)
            //                                    .value("http://acplt.org/Submodels/Assets/TestAsset/BillOfMaterial")
            //                                    .build())                          
            //                            .build())
            //                    .build())
            //            .submodelElement(new DefaultFile.Builder()
            //                    .idShort("ExampleFile")
            //                    .category("Parameter")
            //                    .description(new LangString("Example File object", "en-us"))
            //                    .description(new LangString("Beispiel File Element", "de"))
            //                    .semanticId(new DefaultReference.Builder()
            //                            .key(new DefaultKey.Builder()
            //                                    .type(KeyElements.GLOBAL_REFERENCE)
            //                                    .value("http://acplt.org/Files/ExampleFile")
            //                                    .idType(KeyType.IRI)
            //                                    .build())
            //                            .build())
            //                    .value("/TestFile.pdf")
            //                    .mimeType("application/pdf")
            //                    .build())
            .submodelElement(new DefaultOperation.Builder()
                    .idShort("ExampleOperation")
                    .category("Parameter")
                    .description(new LangString("Example Operation object", "en-us"))
                    .description(new LangString("Beispiel Operation Element", "de"))
                    .semanticId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.GLOBAL_REFERENCE)
                                    .value("http://acplt.org/Operations/ExampleOperation")
                                    .idType(KeyType.IRI)
                                    .build())
                            .build())
                    .inputVariable(new DefaultOperationVariable.Builder()
                            .value(new DefaultProperty.Builder()
                                    .idShort("ExampleProperty")
                                    .category("Constant")
                                    .description(new LangString("Example Property object", "en-us"))
                                    .description(new LangString("Beispiel Property Element", "de"))
                                    .semanticId(new DefaultReference.Builder()
                                            .key(new DefaultKey.Builder()
                                                    .type(KeyElements.GLOBAL_REFERENCE)
                                                    .value("http://acplt.org/Properties/ExampleProperty")
                                                    .idType(KeyType.IRI)
                                                    .build())
                                            .build())
                                    .value("exampleValue")
                                    .valueId(new DefaultReference.Builder()
                                            .key(new DefaultKey.Builder()
                                                    .type(KeyElements.GLOBAL_REFERENCE)
                                                    .idType(KeyType.IRI)
                                                    .value("http://acplt.org/ValueId/ExampleValueId")
                                                    .build())
                                            .build())
                                    .valueType("string")
                                    .build())
                            .build())
                    .outputVariable(new DefaultOperationVariable.Builder()
                            .value(new DefaultProperty.Builder()
                                    .idShort("ExampleProperty")
                                    .category("Constant")
                                    .description(new LangString("Example Property object", "en-us"))
                                    .description(new LangString("Beispiel Property Element", "de"))
                                    .semanticId(new DefaultReference.Builder()
                                            .key(new DefaultKey.Builder()
                                                    .type(KeyElements.GLOBAL_REFERENCE)
                                                    .value("http://acplt.org/Properties/ExampleProperty")
                                                    .idType(KeyType.IRI)
                                                    .build())
                                            .build())
                                    .value("exampleValue")
                                    .valueId(new DefaultReference.Builder()
                                            .key(new DefaultKey.Builder()
                                                    .type(KeyElements.GLOBAL_REFERENCE)
                                                    .idType(KeyType.IRI)
                                                    .value("http://acplt.org/ValueId/ExampleValueId")
                                                    .build())
                                            .build())
                                    .valueType("string")
                                    .build())
                            .build())
                    .inoutputVariable(new DefaultOperationVariable.Builder()
                            .value(new DefaultProperty.Builder()
                                    .idShort("ExampleProperty")
                                    .category("Constant")
                                    .description(new LangString("Example Property object", "en-us"))
                                    .description(new LangString("Beispiel Property Element", "de"))
                                    .semanticId(new DefaultReference.Builder()
                                            .key(new DefaultKey.Builder()
                                                    .type(KeyElements.GLOBAL_REFERENCE)
                                                    .value("http://acplt.org/Properties/ExampleProperty")
                                                    .idType(KeyType.IRI)
                                                    .build())
                                            .build())
                                    .value("exampleValue")
                                    .valueId(new DefaultReference.Builder()
                                            .key(new DefaultKey.Builder()
                                                    .type(KeyElements.GLOBAL_REFERENCE)
                                                    .idType(KeyType.IRI)
                                                    .value("http://acplt.org/ValueId/ExampleValueId")
                                                    .build())
                                            .build())
                                    .valueType("string")
                                    .build())
                            .build())
                    .build())
            //            .submodelElement(
            //                    new DefaultProperty.Builder()
            //                            .idShort("ManufacturerName")
            //                            .description(new LangString("Legally valid designation of the natural or judicial person which is directly responsible for the design, production, packaging and labeling of a product in respect to its being brought into circulation.", "en-us"))
            //                            .description(new LangString("Bezeichnung für eine natürliche oder juristische Person, die für die Auslegung, Herstellung und Verpackung sowie die Etikettierung eines Produkts im Hinblick auf das 'Inverkehrbringen' im eigenen Namen verantwortlich ist", "de"))
            //                            .semanticId(new DefaultReference.Builder()
            //                                    .key(new DefaultKey.Builder()
            //                                            .type(KeyElements.GLOBAL_REFERENCE)
            //                                            .value("0173-1#02-AAO677#002")
            //                                            .idType(KeyType.IRI)
            //                                            .build())
            //                                    .build())
            //                            .qualifier(new DefaultQualifier.Builder()
            //                                    .value("100")
            //                                    .valueId(new DefaultReference.Builder()
            //                                            .key(new DefaultKey.Builder()
            //                                                    .type(KeyElements.GLOBAL_REFERENCE)
            //                                                    .idType(KeyType.IRI)
            //                                                    .value("http://acplt.org/ValueId/ExampleValueId")
            //                                                    .build())
            //                                            .build())
            //                                    .valueType("int")
            //                                    .type("http://acplt.org/Qualifier/ExampleQualifier")
            //                                    .build())
            //                            .qualifier(new DefaultQualifier.Builder()
            //                                    .value("50")
            //                                    .valueId(new DefaultReference.Builder()
            //                                            .key(new DefaultKey.Builder()
            //                                                    .type(KeyElements.GLOBAL_REFERENCE)
            //                                                    .idType(KeyType.IRI)
            //                                                    .value("http://acplt.org/ValueId/ExampleValueId")
            //                                                    .build())
            //                                            .build())
            //                                    .valueType("int")
            //                                    .type("http://acplt.org/Qualifier/ExampleQualifier2")
            //                                    .build())
            //                            .value("ACPLT")
            //                            .valueId(new DefaultReference.Builder()
            //                                    .key(new DefaultKey.Builder()
            //                                            .type(KeyElements.GLOBAL_REFERENCE)
            //                                            .idType(KeyType.IRI)
            //                                            .value("http://acplt.org/ValueId/ExampleValueId")
            //                                            .build())
            //                                    .build())
            //                            .valueType("string")
            //                            .build())

            //            .submodelElement(new DefaultProperty.Builder()
            //                    .idShort("InstanceId")
            //                    .description(new LangString("Legally valid designation of the natural or judicial person which is directly responsible for the design, production, packaging and labeling of a product in respect to its being brought into circulation.", "en-us"))
            //                    .description(new LangString("Bezeichnung für eine natürliche oder juristische Person, die für die Auslegung, Herstellung und Verpackung sowie die Etikettierung eines Produkts im Hinblick auf das 'Inverkehrbringen' im eigenen Namen verantwortlich ist", "de"))
            //                    .semanticId(new DefaultReference.Builder()
            //                            .key(new DefaultKey.Builder()
            //                                    .type(KeyElements.GLOBAL_REFERENCE)
            //                                    .value("http://opcfoundation.org/UA/DI/1.1/DeviceType/Serialnumber")
            //                                    .idType(KeyType.IRI)
            //                                    .build())
            //                            .build())
            //                    .value("978-8234-234-342")
            //                    .valueId(new DefaultReference.Builder()
            //                            .key(new DefaultKey.Builder()
            //                                    .type(KeyElements.GLOBAL_REFERENCE)
            //                                    .idType(KeyType.IRI)
            //                                    .value("http://acplt.org/ValueId/ExampleValueId")
            //                                    .build())
            //                            .build())
            //                    .valueType("string")
            //                    .build())
            .build();

    public static final Submodel SUBMODEL_2 = new DefaultSubmodel.Builder()
            .idShort("BillOfMaterial")
            .description(new LangString("An example bill of material submodel for the test application", "en-us"))
            .description(new LangString("Ein Beispiel-BillofMaterial-Submodel für eine Test-Anwendung", "de"))
            .identification(new DefaultIdentifier.Builder()
                    .idType(IdentifierType.IRI)
                    .identifier("http://acplt.org/Submodels/Assets/TestAsset/BillOfMaterial")
                    .build())
            .administration(new DefaultAdministrativeInformation.Builder()
                    .version("0.9")
                    .build())
            .kind(ModelingKind.TEMPLATE)
            .semanticId(new DefaultReference.Builder()
                    .key(new DefaultKey.Builder()
                            .type(KeyElements.SUBMODEL)
                            .idType(KeyType.IRI)
                            .value("http://acplt.org/SubmodelTemplates/BillOfMaterial")
                            .build())
                    .build())
            .submodelElement(new DefaultEntity.Builder()
                    .idShort("ExampleEntity")
                    .description(new LangString("Legally valid designation of the natural or judicial person which is directly responsible for the design, production, packaging and labeling of a product in respect to its being brought into circulation.", "en-us"))
                    .description(new LangString("Bezeichnung für eine natürliche oder juristische Person, die für die Auslegung, Herstellung und Verpackung sowie die Etikettierung eines Produkts im Hinblick auf das 'Inverkehrbringen' im eigenen Namen verantwortlich ist", "de"))
                    .semanticId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.GLOBAL_REFERENCE)
                                    .value("http://opcfoundation.org/UA/DI/1.1/DeviceType/Serialnumber")
                                    .idType(KeyType.IRI)
                                    .build())
                            .build())
                    .statement(new DefaultProperty.Builder()
                            .idShort("ExampleProperty2")
                            .category("Constant")
                            .description(new LangString("Example Property object", "en-us"))
                            .description(new LangString("Beispiel Property Element", "de"))
                            .semanticId(new DefaultReference.Builder()
                                    .key(new DefaultKey.Builder()
                                            .type(KeyElements.GLOBAL_REFERENCE)
                                            .value("http://acplt.org/Properties/ExampleProperty")
                                            .idType(KeyType.IRI)
                                            .build())
                                    .build())
                            .value("exampleValue2")
                            .valueId(new DefaultReference.Builder()
                                    .key(new DefaultKey.Builder()
                                            .type(KeyElements.GLOBAL_REFERENCE)
                                            .idType(KeyType.IRI)
                                            .value("http://acplt.org/ValueId/ExampleValueId")
                                            .build())
                                    .build())
                            .valueType("string")
                            .build())
                    .statement(new DefaultProperty.Builder()
                            .idShort("ExampleProperty")
                            .category("Constant")
                            .description(new LangString("Example Property object", "en-us"))
                            .description(new LangString("Beispiel Property Element", "de"))
                            .semanticId(new DefaultReference.Builder()
                                    .key(new DefaultKey.Builder()
                                            .type(KeyElements.GLOBAL_REFERENCE)
                                            .value("http://acplt.org/Properties/ExampleProperty")
                                            .idType(KeyType.IRI)
                                            .build())
                                    .build())
                            .value("exampleValue")
                            .valueId(new DefaultReference.Builder()
                                    .key(new DefaultKey.Builder()
                                            .type(KeyElements.GLOBAL_REFERENCE)
                                            .idType(KeyType.IRI)
                                            .value("http://acplt.org/ValueId/ExampleValueId")
                                            .build())
                                    .build())
                            .valueType("string")
                            .build())
                    .entityType(EntityType.CO_MANAGED_ENTITY)
                    .build())
            .submodelElement(new DefaultEntity.Builder()
                    .idShort("ExampleEntity2")
                    .description(new LangString("Legally valid designation of the natural or judicial person which is directly responsible for the design, production, packaging and labeling of a product in respect to its being brought into circulation.", "en-us"))
                    .description(new LangString("Bezeichnung für eine natürliche oder juristische Person, die für die Auslegung, Herstellung und Verpackung sowie die Etikettierung eines Produkts im Hinblick auf das 'Inverkehrbringen' im eigenen Namen verantwortlich ist", "de"))
                    .semanticId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.GLOBAL_REFERENCE)
                                    .value("http://opcfoundation.org/UA/DI/1.1/DeviceType/Serialnumber")
                                    .idType(KeyType.IRI)
                                    .build())
                            .build())
                    .entityType(EntityType.SELF_MANAGED_ENTITY)
                    .globalAssetId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.ASSET)
                                    .idType(KeyType.IRI)
                                    .value("https://acplt.org/Test_Asset2")
                                    .build())
                            .build())
                    .build())
            .qualifier(new DefaultQualifier.Builder()
                    .value("100")
                    .valueId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.GLOBAL_REFERENCE)
                                    .idType(KeyType.IRI)
                                    .value("http://acplt.org/ValueId/ExampleValueId")
                                    .build())
                            .build())
                    .valueType("int")
                    .type("http://acplt.org/Qualifier/ExampleQualifier")
                    .build())
            .qualifier(new DefaultQualifier.Builder()
                    .value("50")
                    .valueId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.GLOBAL_REFERENCE)
                                    .idType(KeyType.IRI)
                                    .value("http://acplt.org/ValueId/ExampleValueId")
                                    .build())
                            .build())
                    .valueType("int")
                    .type("http://acplt.org/Qualifier/ExampleQualifier2")
                    .build())
            .build();

    public final static ConceptDescription CONCEPT_DESCRIPTION_1 = new DefaultConceptDescription.Builder()
            .idShort("TestConceptDescription")
            .description(new LangString("An example concept description  for the test application", "en-us"))
            .description(new LangString("Ein Beispiel-ConceptDescription für eine Test-Anwendung", "de"))
            .identification(new DefaultIdentifier.Builder()
                    .idType(IdentifierType.IRI)
                    .identifier("https://acplt.org/Test_ConceptDescription")
                    .build())
            .administration(new DefaultAdministrativeInformation.Builder()
                    .version("0.9")
                    .revision("0")
                    .build())
            .isCaseOf(new DefaultReference.Builder()
                    .key(new DefaultKey.Builder()
                            .type(KeyElements.GLOBAL_REFERENCE)
                            .idType(KeyType.IRI)
                            .value("http://acplt.org/DataSpecifications/ConceptDescriptions/TestConceptDescription")
                            .build())
                    .build())
            .embeddedDataSpecification(new DefaultEmbeddedDataSpecification.Builder()
                    .dataSpecificationContent(new DefaultDataSpecificationIEC61360.Builder()
                            .preferredName(new LangString("Test Specification", "de"))
                            .preferredName(new LangString("TestSpecification", "en-us"))
                            .dataType(DataTypeIEC61360.REAL_MEASURE)
                            .definition(new LangString("Dies ist eine Data Specification für Testzwecke", "de"))
                            .definition(new LangString("This is a DataSpecification for testing purposes", "en-us"))
                            .shortName(new LangString("Test Spec", "de"))
                            .shortName(new LangString("TestSpec", "en-us"))
                            .unit("SpaceUnit")
                            .unitId(new DefaultReference.Builder()
                                    .key(new DefaultKey.Builder()
                                            .type(KeyElements.GLOBAL_REFERENCE)
                                            .idType(KeyType.IRI)
                                            .value("http://acplt.org/Units/SpaceUnit")
                                            .build())
                                    .build())
                            .sourceOfDefinition("http://acplt.org/DataSpec/ExampleDef")
                            .symbol("SU")
                            .valueFormat("string")
                            .value("TEST")
                            .levelType(LevelType.MIN)
                            .levelType(LevelType.MAX)
                            .valueList(new DefaultValueList.Builder()
                                    .valueReferencePairTypes(new DefaultValueReferencePair.Builder()
                                            .value("exampleValue")
                                            .valueId(new DefaultReference.Builder()
                                                    .key(new DefaultKey.Builder()
                                                            .type(KeyElements.GLOBAL_REFERENCE)
                                                            .idType(KeyType.IRI)
                                                            .value("http://acplt.org/ValueId/ExampleValueId")
                                                            .build())
                                                    .build())
                                            // TODO valueType
                                            .build())
                                    .valueReferencePairTypes(new DefaultValueReferencePair.Builder()
                                            .value("exampleValue2")
                                            .valueId(new DefaultReference.Builder()
                                                    .key(new DefaultKey.Builder()
                                                            .type(KeyElements.GLOBAL_REFERENCE)
                                                            .idType(KeyType.IRI)
                                                            .value("http://acplt.org/ValueId/ExampleValueId2")
                                                            .build())
                                                    .build())
                                            // TODO valueType
                                            .build())
                                    .build())
                            .build())
                    .build())
            .embeddedDataSpecification(new DefaultEmbeddedDataSpecification.Builder()
                    .dataSpecificationContent(new DefaultDataSpecificationIEC61360.Builder()
                            .preferredName(new LangString("Test Specification2", "de"))
                            .preferredName(new LangString("TestSpecification2", "en-us"))
                            .dataType(DataTypeIEC61360.REAL_MEASURE)
                            .definition(new LangString("Dies ist eine Data Specification für Testzwecke2", "de"))
                            .definition(new LangString("This is a DataSpecification for testing purposes2", "en-us"))
                            .shortName(new LangString("Test Spec2", "de"))
                            .shortName(new LangString("TestSpec2", "en-us"))
                            .unit("SpaceUnit")
                            .unitId(new DefaultReference.Builder()
                                    .key(new DefaultKey.Builder()
                                            .type(KeyElements.GLOBAL_REFERENCE)
                                            .idType(KeyType.IRI)
                                            .value("http://acplt.org/Units/SpaceUnit")
                                            .build())
                                    .build())
                            .sourceOfDefinition("http://acplt.org/DataSpec/ExampleDef")
                            .symbol("SU")
                            .valueFormat("string")
                            .value("TEST2")
                            .levelType(LevelType.MIN)
                            .levelType(LevelType.MAX)
                            .valueList(new DefaultValueList.Builder()
                                    .valueReferencePairTypes(new DefaultValueReferencePair.Builder()
                                            .value("exampleValue21")
                                            .valueId(new DefaultReference.Builder()
                                                    .key(new DefaultKey.Builder()
                                                            .type(KeyElements.GLOBAL_REFERENCE)
                                                            .idType(KeyType.IRI)
                                                            .value("http://acplt.org/ValueId/ExampleValueId")
                                                            .build())
                                                    .build())
                                            // TODO valueType
                                            .build())
                                    .valueReferencePairTypes(new DefaultValueReferencePair.Builder()
                                            .value("exampleValue22")
                                            .valueId(new DefaultReference.Builder()
                                                    .key(new DefaultKey.Builder()
                                                            .type(KeyElements.GLOBAL_REFERENCE)
                                                            .idType(KeyType.IRI)
                                                            .value("http://acplt.org/ValueId/ExampleValueId2")
                                                            .build())
                                                    .build())
                                            // TODO valueType
                                            .build())
                                    .build())
                            .build())
                    .build())
            .build();

    public static final AssetAdministrationShell AAS_1 = new DefaultAssetAdministrationShell.Builder()
            .idShort("TestAssetAdministrationShell")
            .description(new LangString("An Example Asset Administration Shell for the test application", "en-us"))
            .description(new LangString("Ein Beispiel-Verwaltungsschale für eine Test-Anwendung", "de"))
            .identification(new DefaultIdentifier.Builder()
                    .idType(IdentifierType.IRI)
                    .identifier("https://acplt.org/Test_AssetAdministrationShell")
                    .build())
            .administration(new DefaultAdministrativeInformation.Builder()
                    .version("0.9")
                    .revision("0")
                    .build())
            .derivedFrom(new DefaultReference.Builder()
                    .key(new DefaultKey.Builder()
                            .type(KeyElements.ASSET_ADMINISTRATION_SHELL)
                            .idType(KeyType.IRI)
                            .value("https://acplt.org/TestAssetAdministrationShell2")
                            .build())
                    .build())
            .assetInformation(new DefaultAssetInformation.Builder()
                    .assetKind(AssetKind.INSTANCE)
                    .globalAssetId(new DefaultReference.Builder()
                            .key(new DefaultKey.Builder()
                                    .type(KeyElements.ASSET)
                                    .idType(KeyType.IRI)
                                    .value("https://acplt.org/Test_Asset")
                                    .build())
                            .build())
                    //                    .billOfMaterial(asReference(SUBMODEL_2))
                    .build())
            .submodel(asReference(SUBMODEL_1))
            .submodel(asReference(SUBMODEL_2))
            .view(new DefaultView.Builder()
                    .idShort("ExampleView")
                    .containedElement(asReference(SUBMODEL_1))
                    .build())
            .build();

    public static final AssetAdministrationShellEnvironment ENVIRONMENT = new DefaultAssetAdministrationShellEnvironment.Builder()
            .assetAdministrationShells(Arrays.asList(
                    AAS_1))
            .submodels(Arrays.asList(
                    SUBMODEL_1,
                    SUBMODEL_2))
            .conceptDescriptions(Arrays.asList(
                    CONCEPT_DESCRIPTION_1))
            .build();
}
