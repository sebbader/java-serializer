package io.adminshell.aas.v3.dataformat.i4aas.mappers.sme;

import org.opcfoundation.ua._2011._03.uanodeset.UAObject;

import io.adminshell.aas.v3.dataformat.i4aas.mappers.ReferenceMapper;
import io.adminshell.aas.v3.dataformat.i4aas.mappers.utils.I4aasId;
import io.adminshell.aas.v3.dataformat.i4aas.mappers.utils.MappingContext;
import io.adminshell.aas.v3.model.Reference;
import io.adminshell.aas.v3.model.RelationshipElement;

public class RelationshipElementMapper extends SubmodelElementMapper<RelationshipElement> {

	public RelationshipElementMapper(RelationshipElement src, MappingContext ctx) {
		super(src, ctx);
	}

	@Override
	protected UAObject createTargetObject() {
		super.createTargetObject();
		addTypeReference(I4aasId.AASRelationshipElementType);
		return target;
	}
	
	@Override
	protected void mapAndAttachChildren() {
		super.mapAndAttachChildren();
		Reference first = source.getFirst();
		if (first != null) {
			UAObject uaFirst = new ReferenceMapper(first, ctx, "First").map();
			attachAsComponent(target, uaFirst);
		}
		Reference second = source.getSecond();
		if (second != null) {
			UAObject uaSecond = new ReferenceMapper(second, ctx, "Second").map();
			attachAsComponent(target, uaSecond);
		}
	}
}
