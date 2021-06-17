package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemTake is a Querydsl query type for ItemTake
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemTake extends EntityPathBase<ItemTake> {

    private static final long serialVersionUID = 742324000L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemTake itemTake = new QItemTake("itemTake");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    public final StringPath caharacter_name = createString("caharacter_name");

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final StringPath mbr_email = createString("mbr_email");

    public final NumberPath<Integer> mbr_no = createNumber("mbr_no", Integer.class);

    public final QMemberCharacter memberCharacter;

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QItemTake(String variable) {
        this(ItemTake.class, forVariable(variable), INITS);
    }

    public QItemTake(Path<? extends ItemTake> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemTake(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemTake(PathMetadata metadata, PathInits inits) {
        this(ItemTake.class, metadata, inits);
    }

    public QItemTake(Class<? extends ItemTake> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberCharacter = inits.isInitialized("memberCharacter") ? new QMemberCharacter(forProperty("memberCharacter"), inits.get("memberCharacter")) : null;
    }

}

