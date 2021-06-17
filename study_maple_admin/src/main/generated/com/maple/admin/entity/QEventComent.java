package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventComent is a Querydsl query type for EventComent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEventComent extends EntityPathBase<EventComent> {

    private static final long serialVersionUID = 1510803550L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventComent eventComent = new QEventComent("eventComent");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final StringPath even_coments = createString("even_coments");

    public final NumberPath<Integer> even_op = createNumber("even_op", Integer.class);

    public final QEventMaster eventMaster;

    public final StringPath mbr_email = createString("mbr_email");

    public final NumberPath<Integer> mbr_no = createNumber("mbr_no", Integer.class);

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QEventComent(String variable) {
        this(EventComent.class, forVariable(variable), INITS);
    }

    public QEventComent(Path<? extends EventComent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventComent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventComent(PathMetadata metadata, PathInits inits) {
        this(EventComent.class, metadata, inits);
    }

    public QEventComent(Class<? extends EventComent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.eventMaster = inits.isInitialized("eventMaster") ? new QEventMaster(forProperty("eventMaster")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

