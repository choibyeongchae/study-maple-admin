package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemInven is a Querydsl query type for ItemInven
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemInven extends EntityPathBase<ItemInven> {

    private static final long serialVersionUID = 1527446753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemInven itemInven = new QItemInven("itemInven");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    public final StringPath caharacter_name = createString("caharacter_name");

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final NumberPath<Integer> item_seq = createNumber("item_seq", Integer.class);

    public final StringPath item_type = createString("item_type");

    public final QItemMaster itemMaster;

    public final NumberPath<Integer> iven_seq = createNumber("iven_seq", Integer.class);

    public final StringPath mbr_email = createString("mbr_email");

    public final NumberPath<Integer> mbr_no = createNumber("mbr_no", Integer.class);

    public final QMemberCharacter memberCharacter;

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QItemInven(String variable) {
        this(ItemInven.class, forVariable(variable), INITS);
    }

    public QItemInven(Path<? extends ItemInven> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemInven(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemInven(PathMetadata metadata, PathInits inits) {
        this(ItemInven.class, metadata, inits);
    }

    public QItemInven(Class<? extends ItemInven> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.itemMaster = inits.isInitialized("itemMaster") ? new QItemMaster(forProperty("itemMaster")) : null;
        this.memberCharacter = inits.isInitialized("memberCharacter") ? new QMemberCharacter(forProperty("memberCharacter"), inits.get("memberCharacter")) : null;
    }

}

