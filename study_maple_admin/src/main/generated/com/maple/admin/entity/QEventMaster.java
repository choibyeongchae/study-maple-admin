package com.maple.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEventMaster is a Querydsl query type for EventMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEventMaster extends EntityPathBase<EventMaster> {

    private static final long serialVersionUID = 1784358646L;

    public static final QEventMaster eventMaster = new QEventMaster("eventMaster");

    public final com.maple.admin.util.QDateEntityUtil _super = new com.maple.admin.util.QDateEntityUtil(this);

    //inherited
    public final DateTimePath<java.time.Instant> createDate = _super.createDate;

    public final StringPath even_code = createString("even_code");

    public final StringPath even_coment = createString("even_coment");

    public final StringPath even_contents = createString("even_contents");

    public final DatePath<java.sql.Date> even_enddate = createDate("even_enddate", java.sql.Date.class);

    public final StringPath even_name = createString("even_name");

    public final NumberPath<Integer> even_op = createNumber("even_op", Integer.class);

    public final DatePath<java.sql.Date> even_stardate = createDate("even_stardate", java.sql.Date.class);

    public final StringPath even_title = createString("even_title");

    public final StringPath even_viewcnt = createString("even_viewcnt");

    //inherited
    public final DateTimePath<java.time.Instant> updateDate = _super.updateDate;

    public QEventMaster(String variable) {
        super(EventMaster.class, forVariable(variable));
    }

    public QEventMaster(Path<? extends EventMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEventMaster(PathMetadata metadata) {
        super(EventMaster.class, metadata);
    }

}

